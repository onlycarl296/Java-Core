package tiny_spring;

import java.util.Map;

// Example controller
@Component
class MyController {
    @Autowired
    private MyService myService;

    @RequestMapping("/hello")
    public HttpResponse handleRequest(HttpRequest request) {
        System.out.println("Handling request for path: " + request.path);
        myService.doSomething();

        Map<String, Object> responseBody = Map.of("message", "Hello, World!");
        return new HttpResponse(200, responseBody);
    }
}
