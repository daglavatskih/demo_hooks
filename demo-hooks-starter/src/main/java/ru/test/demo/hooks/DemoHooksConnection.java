package ru.test.demo.hooks;

/**
 * Интерфейс подключения к серверу
 *
 * @author DGlavatskikh
 */
public interface DemoHooksConnection {

    /**
     * Отправка сообщения на сервер
     *
     * @param hookDto сообщение
     * @return ответ сервера
     */
    String sendMessages(DemoHooksRequestDto hookDto);
}
