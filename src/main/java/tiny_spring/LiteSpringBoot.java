package tiny_spring;

import java.lang.reflect.Method;

// Simple web framework
class LiteSpringBoot {
    private Container container = new Container();

    public LiteSpringBoot(Class<?>... classes) {
        // Register all components
        for (Class<?> clazz : classes) {
            if (clazz.isAnnotationPresent(Component.class)) {
                try {
                    Object instance = clazz.getDeclaredConstructor().newInstance();
                    //Tạo một instance mới của class được mô tả bởi clazz, bằng constructor không tham số, tại runtime.
                    container.register(clazz, instance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // Autowire dependencies after registering components
        for (Object instance : container.getInstances().values()) {
            container.autowire(instance);
        }
    }

    public HttpResponse handleRequest(HttpRequest request) {
        // Find the appropriate request handler and invoke it
        Object handler = container.getBean(requestHandlerFor(request));
        if (handler != null) {
            try {
                Method[] methods = handler.getClass().getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(RequestMapping.class)) {
                        RequestMapping mapping = method.getAnnotation(RequestMapping.class);
                        if (mapping.value().equals(request.path)) {
                            return (HttpResponse) method.invoke(handler, request);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private Class<?> requestHandlerFor(HttpRequest request) {
        // Simple logic to find the request handler based on the request path
        return MyController.class; // Replace with your own logic
    }
}