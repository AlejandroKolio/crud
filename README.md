# CRUD sample
##Тестовое задание для [JavaRush](http://javarush.ru) </br>
Реализация простого [CRUD](https://ru.wikipedia.org/wiki/CRUD) Web приложения

Параметры БД задать в spring файле конфигураций [mvc-dispatcher-servlet.xml](https://github.com/AlejandroKolio/crud/blob/master/servlets/src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml):
```
    <!-- Database Information -->
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/test"/>
        <property name="username" value="root"/> - Логин к БД
        <property name="password" value="root"/> - Пароль к БД
    </bean>
```
