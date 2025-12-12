package tiny_spring;

// Fake HTTP request class
class HttpRequest {
    String method;
    String path;

    public HttpRequest(String method, String path) {
        this.method = method;
        this.path = path;
    }
}