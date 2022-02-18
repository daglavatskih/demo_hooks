# Библиотека-стартер для демонстрации Webhook
Демонстрация работы обратного вызова клиента сервером как вариант реализации Webhook.

### Сборка проекта
```
% gradle clean build
```
### Публикация библиотеки в локальный репозиторий
```
% gradle publishMavenJavaPublicationToMavenLocalRepository
```
### Подключение библиотеки
```
implementation 'ru.test.demo.hooks:demo-hooks-spring-boot-starter:1.0.0'
```
Библиотеку необходимо подключить как для клиентов так и для сервера.
На сервере необходимо отключить автоконфигурацию, чтобы не создавались не
нужные на сервере бины. Для этого в конфиге нужно добавить:
```
spring:
  autoconfigure:
    exclude: ru.test.demo.hooks.ConfigurationReference
```
