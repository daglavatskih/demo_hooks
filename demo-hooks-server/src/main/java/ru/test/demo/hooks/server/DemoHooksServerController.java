package ru.test.demo.hooks.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.test.demo.hooks.DemoHooksRequestDto;

/**
 * Класс контроллера сервера
 *
 * @author DGlavatskikh
 */
@RestController
public class DemoHooksServerController {

    @Autowired
    private DemoHooksServerTestService demoHooksServerTestService;

    /**
     * Обработка сообщения клиента
     *
     * @param requestDto сообщение
     * @return ответ сервера на получение сообщения
     */
    @PostMapping("/process")
    public String process(@RequestBody DemoHooksRequestDto requestDto) {
        demoHooksServerTestService.getRequests().add(requestDto);
        return "Hello, " + requestDto.getClientName() + ", msg - " + requestDto.getMessage();
    }

}
