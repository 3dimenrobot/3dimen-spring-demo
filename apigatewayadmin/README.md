本代码是服务端。

如何配置客户端：
application.properties 增加
spring.boot.admin.client.url=http://localhost:10001
management.endpoints.web.exposure.include=*

pom.xml 增加

<dependency>
	<groupId>de.codecentric</groupId>
	<artifactId>spring-boot-admin-starter-client</artifactId>
	<version>2.1.5</version>
</dependency>