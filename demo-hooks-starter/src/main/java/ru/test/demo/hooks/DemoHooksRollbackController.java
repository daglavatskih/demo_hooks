package ru.test.demo.hooks;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Интерфейс контроллера для ответа сервера
 *
 * @author DGlavatskikh
 */
@RestController
public interface DemoHooksRollbackController {

    /**
     * Получение ответа от сервера
     *
     * @param response сообщение
     */
    @PostMapping("/rollback")
    void rollbackStatus(@RequestBody DemoHooksResponseDto response);
}
