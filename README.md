# Todo Application Clone Code ð¤

âï¸ Spring boot
+ Java 11
+ Springframework version 2.4.2

âï¸ todobackend Test Success
+ Link â [todobackend](http://todobackend.com "todobackend.com")
+ Funtional Statement

|  No  |    Method    | Comment                         |
|:----:|:------------|:--------------------------------|
|  1.  |     Add      | Listã«ã¢ã¤ãã ãè¿½å                     |
|  2.  |  searchById  | Listã®ä¸­ã§ç¹å®ã®ã¢ã¤ãã ãæ¢ã               |
|  3.  |  searchAll   | Listãå¨é¨æ¤ç´¢ãã                     |
|  4.  |  updateById  | Listã®ä¸­ã§ç¹å®ã®ã¢ã¤ãã ãç´ã               |
|  5.  |  deleteById  | Listã®ä¸­ã§ç¹å®ã®ã¢ã¤ãã ãæ¶ã               |
|  6.  |  deleteAll   | Listã®ã¢ã¤ãã ãå¨é¨æ¶ã                  |

<img width="500" alt="ì¤í¬ë¦°ì· 2022-10-06 ì¤í 9 20 41" src="https://user-images.githubusercontent.com/61968619/194315162-3a8361ab-17c0-467c-aaa3-0ea79aaa7fc9.png">
<img width="500" alt="ì¤í¬ë¦°ì· 2022-10-06 ì¤í 9 20 19" src="https://user-images.githubusercontent.com/61968619/194317293-bb253f29-f7bd-4e0a-840b-11fb249a5d19.png">

âï¸ postman Test Success
+ Link â [postman](https://www.postman.com/ "postman.com")
+ API Spec

| Method | EndPoint |       Functions      |         Request        |                                                                                  Response                                                                                  |
|:------:|:--------:|:--------------------:|:----------------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|  POST  |     /    |    ã¢ã¤ãã ãè¿½å     | {"title":"ããããã"} |                                             {"id":1,"title":"blah1","order:0,"completed":false,"url":"http://localhost:8080/1"}                                            |
|   GET  |     /    |  ãªã¹ããå¨é¨è¦ãã  |            -           | {"id":1,"title":"blah1","order:0,"completed":false,"url":" http://localhost:8080/1"}  {"id":2,"title":"blah2","order:0,"completed":false,"url":" http://localhost:8080/2"} |
|   GET  |  /{:id}  | ç¹å®ã®ã¢ã¤ãã ãæ¢ã |            -           |                                           {"id":10,"title":"blah10","order:0,"completed":false,"url":" http://localhost:8080/10"}                                          |
|  PATCH |  /{:id}  | ç¹å®ã®ã¢ã¤ãã ãç´ã | {"title":"ããããã"} |                                            {"id":1,"title":"blah1","order:0,"completed":false,"url":" http://localhost:8080/1"}                                            |
| DELETE |     /    |   ãªã¹ããå¨é¨æ¶ã   |            -           |                                                                                     200                                                                                    |
| DELETE |  /{:id}  | ç¹å®ã®ã¢ã¤ãã ãæ¶ã |            -           |                                                                                     200                                                                                    |    







âï¸ Chrome, Brave browser CORS ISSUE Solution 
+ I Used the Firefox browser
+ Add CorsFilter Class
```java
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods","*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers","*");

        if("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
```
âï¸ Check the dependencies
```javascript
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-rest'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

    runtimeOnly 'com.h2database:h2'

    annotationProcessor("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok")

    testImplementation('org.springframework.boot:spring-boot-starter-test') {
        exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
    }
}
```