Postman REST API: https://www.getpostman.com/collections/bdf6ed833295b0a90809

Maven compile & run commands: <br>
```shell
mvn clean package -P <profile-id> 
```

```shell
mvn spring-boot:run -P <profile-id> 
```
where `<profile-id>` is id of the profile for a build. (<b>dev</b> and <b>cloud</b> in our app).
To see all available profiles, check `<profiles>` section in <i>pom.xml</i>

