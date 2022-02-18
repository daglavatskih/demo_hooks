package ru.test.demo.hooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Objects;

/**
 * Интерфейс сервиса
 *
 * @author DGlavatskikh
 */
class DemoHooksServiceImpl implements DemoHooksService {

    @Autowired
    private DemoHooksConnection hooksConnection;

    @Value("${spring.application.name:}")
    private String clientName;

    @Value("${hooks.client_url:}")
    private String clientUrl;

    @Override
    public String sendMessages(DemoHooksRequestDto requestDto) {
        if (Objects.isNull(requestDto)) {
            return "null";
        }
        requestDto.setClientName(clientName);
        requestDto.setClientUrl(clientUrl);
        return hooksConnection.sendMessages(requestDto);
    }
}
