package ru.test.demo.hooks;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Класс конфигурации стартера
 *
 * @author DGlavatskikh
 */
@Configuration
@Import({ DemoHooksConnectionImpl.class, DemoHooksServiceImpl.class})
public class ConfigurationReference {

    /**
     * Высвечивать ошибку при отсутствии бина
     */
    @Bean
    @ConditionalOnMissingBean(DemoHooksRollbackController.class)
    public DemoHooksRollbackController demoHooksRollbackController() {
        throw new BeanCreationException("DemoHooksRollbackController");
    }
}
