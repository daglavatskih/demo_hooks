package ru.test.demo.hooks;

/**
 * Класс сообщения ответа
 *
 * @author DGlavatskikh
 */
public class DemoHooksResponseDto extends DemoHooksDto {

    private int status;

    private String error;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
