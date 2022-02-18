package ru.test.demo.hooks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Класс подключения к серверу
 *
 * @author DGlavatskikh
 */
class DemoHooksConnectionImpl implements DemoHooksConnection {

    private static final String SEND_MESSAGE_PATH = "process";

    @Value("${hooks.server_url:}")
    private String serverUrl;

    @Override
    public String sendMessages(DemoHooksRequestDto hookDto) {
        WebClient webClient = WebClient.create(serverUrl);

        return webClient.post()
            .uri(SEND_MESSAGE_PATH)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(hookDto)
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }
}
