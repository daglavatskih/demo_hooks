package ru.test.demo.hooks;

import org.springframework.stereotype.Service;

/**
 * Интерфейс сервиса
 *
 * @author DGlavatskikh
 */
public interface DemoHooksService {

    /**
     * Отправка сообщения на сервер
     *
     * @param requestDto сообщение
     * @return ответ сервера
     */
    String sendMessages(DemoHooksRequestDto requestDto);
}
