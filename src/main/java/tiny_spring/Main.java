package tiny_spring;

public class Main {
    public static void main(String[] args) {
        LiteSpringBoot app = new LiteSpringBoot(MyController.class, MyService.class);
        HttpRequest request = new HttpRequest("GET", "/hello");
        HttpResponse response = app.handleRequest(request);
        System.out.println("Response: " + response.getBody());
    }
}
