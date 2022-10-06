# Todo Application Clone Code 🤖

☑️ Spring boot
+ Java 11
+ Springframework version 2.4.2

☑️ todobackend Test Success
+ Link ➜ [todobackend](http://todobackend.com "todobackend.com")
+ Funtional Statement

|  No  |    Method    | Comment                         |
|:----:|:------------|:--------------------------------|
|  1.  |     Add      | Listにアイテムを追加                    |
|  2.  |  searchById  | Listの中で特定のアイテムを探す               |
|  3.  |  searchAll   | Listを全部検索する                     |
|  4.  |  updateById  | Listの中で特定のアイテムを直す               |
|  5.  |  deleteById  | Listの中で特定のアイテムを消す               |
|  6.  |  deleteAll   | Listのアイテムを全部消す                  |

<img width="500" alt="스크린샷 2022-10-06 오후 9 20 41" src="https://user-images.githubusercontent.com/61968619/194315162-3a8361ab-17c0-467c-aaa3-0ea79aaa7fc9.png">
<img width="500" alt="스크린샷 2022-10-06 오후 9 20 19" src="https://user-images.githubusercontent.com/61968619/194317293-bb253f29-f7bd-4e0a-840b-11fb249a5d19.png">

☑️ postman Test Success
+ Link ➜ [postman](https://www.postman.com/ "postman.com")
+ API Spec

| Method | EndPoint |       Functions      |         Request        |                                                                                  Response                                                                                  |
|:------:|:--------:|:--------------------:|:----------------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|  POST  |     /    |    アイテムを追加    | {"title":"あいうえお"} |                                             {"id":1,"title":"blah1","order:0,"completed":false,"url":"http://localhost:8080/1"}                                            |
|   GET  |     /    |  リストを全部見せる  |            -           | {"id":1,"title":"blah1","order:0,"completed":false,"url":" http://localhost:8080/1"}  {"id":2,"title":"blah2","order:0,"completed":false,"url":" http://localhost:8080/2"} |
|   GET  |  /{:id}  | 特定のアイテムを探す |            -           |                                           {"id":10,"title":"blah10","order:0,"completed":false,"url":" http://localhost:8080/10"}                                          |
|  PATCH |  /{:id}  | 特定のアイテムを直す | {"title":"かきくけこ"} |                                            {"id":1,"title":"blah1","order:0,"completed":false,"url":" http://localhost:8080/1"}                                            |
| DELETE |     /    |   リストを全部消す   |            -           |                                                                                     200                                                                                    |
| DELETE |  /{:id}  | 特定のアイテムを消す |            -           |                                                                                     200                                                                                    |    







☑️ Chrome, Brave browser CORS ISSUE Solution 
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
☑️ Check the dependencies
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