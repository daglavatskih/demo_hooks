package ru.test.demo.hooks.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.test.demo.hooks.DemoHooksRequestDto;
import ru.test.demo.hooks.DemoHooksResponseDto;
import ru.test.demo.hooks.DemoHooksRollbackController;
import ru.test.demo.hooks.DemoHooksService;

/**
 * Класс контроллера клиента
 *
 * @author DGlavatskikh
 */
@RestController
@Slf4j
public class DemoHooksClientController implements DemoHooksRollbackController {

    private Long idMessage = 0L;

    @Autowired
    private DemoHooksService proxyService;

    /**
     * Отправить тестовое сообщение серверу
     *
     * @param message сообщение
     * @return ответ сервера
     */
    @GetMapping("/test")
    public String test(@RequestParam String message) {
        final DemoHooksRequestDto hookDto = new DemoHooksRequestDto();
        hookDto.setMessage(message);
        hookDto.setMessageId(idMessage++);
        return proxyService.sendMessages(hookDto);
    }

    /**
     * Обратный вызов сервера после завершения обработки сообщения
     *
     * @param response ответное сообщение
     */
    @Override
    public void rollbackStatus(DemoHooksResponseDto response) {
        log.info("Rollback message! id - " + response.getMessageId());
        log.info(response.getMessage());
    }
}
