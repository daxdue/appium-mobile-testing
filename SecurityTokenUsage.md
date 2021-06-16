##Solution to avoid storing security token in git repository
To avoid storing tokens in repository we can use maven command line options to provide secure token as property.
For example, in pom.xml we declare:
```
<properties>
......
<token></token>
.......
</properties>
```
When we need to provide secret key or token to application, we run app with command:
```
mvn clean test -Dtoken=$yourToken
```