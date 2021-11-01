### SpringBoot集成Redis

####导入依赖:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
    <version>1.4.1.RELEASE</version>
</dependency>
```

####配置application.properties

```properties
server.port=7000


spring.redis.host=127.0.0.1
#Redis服务器连接端口
spring.redis.port=6379
#Redis服务器连接密码（默认为空）
spring.redis.password=
```

####启动Redis服务器

```cmd
redis-server.exe redis.windows.conf
```

####使用RedisTemplate

```java
@Autowired
private RedisTemplate redisTemplate;
```

