package ru.test.demo.hooks;

/**
 * Класс сообщения
 *
 * @author DGlavatskikh
 */
public class DemoHooksDto {

    private Long messageId;

    private String message;

    private String clientName;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getClientName() {
        return clientName;
    }

    void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
