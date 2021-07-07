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

***

For **remote debug** use the following commands:

```shell
cf allow-space-ssh dev
``` 
where *dev* is a space name


```shell
cf enable-ssh my-pets-proxy
```
where *my-pets-proxy* is a app name


```shell
cf restage my-pets-proxy
```
where *my-pets-proxy* is a app name


```shell
cf ssh -N -T -L 5041:localhost:8000 my-pets-proxy
```
Then select **remote JDM Debug** from IDE the run configuration of IDE 
and set the following properties: <br>
**Host: localhost** <br>
**Port: 5041** <br>
