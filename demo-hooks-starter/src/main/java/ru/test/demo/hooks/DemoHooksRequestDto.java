package ru.test.demo.hooks;

/**
 * Класс сообщения запроса
 *
 * @author DGlavatskikh
 */
public class DemoHooksRequestDto extends DemoHooksDto {

    private String clientUrl;

    public String getClientUrl() {
        return clientUrl;
    }

    void setClientUrl(String clientUrl) {
        this.clientUrl = clientUrl;
    }
}
