# Jasypt-spring-boot-example
Encrypting Spring Boot Application using Jasypt Spring Boot . Example with Jasypt and Spring boot .
### How To Encrypt Passwords In Spring Boot Configuration
#### More often we come approach this kind of scenarios where we need to store sensitive passwords or keys in our application.properties file , there are ways you can encrypt those passwords and sensitive credentials using [jasypt-spring-boot example](https://frugalisminds.com/how-to-encrypt-passwords-in-spring-boot-configuration) . 



```
	<dependency>
    <groupId>com.github.ulisesbocchio</groupId>
    <artifactId>jasypt-spring-boot-starter</artifactId>
    <version>3.0.4</version>
	</dependency>
```
```
			<plugin>
    <groupId>com.github.ulisesbocchio</groupId>
    <artifactId>jasypt-maven-plugin</artifactId>
    <version>3.0.4</version>
</plugin>
```

spring.datasource.url=jdbc:mysql://localhost:3306/broadleaf
spring.datasource.username= root
spring.datasource.password= DEC(root)
jasypt.encryptor.algorithm= PBEWithMD5AndDES
jasypt.encryptor.iv-generator-classname: org.jasypt.iv.NoIvGenerator

mvn jasypt:encrypt -Djasypt.encryptor.password=frugalisminds

mvn jasypt:encrypt -Djasypt.encryptor.password=frugalisminds -Djasypt.plugin.path="file:src/main/resources/application-test.properties"

mvn jasypt:encrypt -Dspring.profiles.active=test -Djasypt.encryptor.password="frugalisminds "

mvn jasypt:encrypt-value -Djasypt.encryptor.password=frugalisminds -Djasypt.plugin.value=root