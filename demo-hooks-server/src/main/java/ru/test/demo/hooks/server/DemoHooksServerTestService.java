package ru.test.demo.hooks.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.reactive.function.client.WebClient;
import ru.test.demo.hooks.DemoHooksRequestDto;
import ru.test.demo.hooks.DemoHooksResponseDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс сервиса обработки сообщения
 *
 * @author DGlavatskikh
 */
@Slf4j
@Service
@EnableScheduling
public class DemoHooksServerTestService {

    private static final String ROLLBACK_CLIENT_PATH = "/rollback";

    // Для хранения запросов (имитация БД)
    private final List<DemoHooksRequestDto> requests = new ArrayList<>();

    public List<DemoHooksRequestDto> getRequests() {
        return requests;
    }

    /**
     * Обработчик сообщений по расписанию
     */
    @Scheduled(cron = "*/20 * * * * *")
    public void worker() {
        log.debug("Start scheduling");
        if (CollectionUtils.isEmpty(requests)) {
            return;
        }
        requests.forEach(request -> {
            log.info("Client - " + request.getClientName() + ", id - " + request.getMessageId());
            final DemoHooksResponseDto response = new DemoHooksResponseDto();
            response.setMessage(request.getMessage() + " changed");
            response.setMessageId(request.getMessageId());

            final WebClient webClient = WebClient.create(request.getClientUrl());

            webClient.post()
                .uri(ROLLBACK_CLIENT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(response)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        });
        requests.clear();
    }
}
