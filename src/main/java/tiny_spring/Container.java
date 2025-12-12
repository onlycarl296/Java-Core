package tiny_spring;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Simple DI container
class Container {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz, Object instance) {
        instances.put(clazz, instance);
    }

    public Object getBean(Class<?> clazz) {
        return instances.get(clazz);
    }
    public Map<Class<?>, Object> getInstances() {
        return instances;
    }

    public void autowire(Object instance) {
        Field[] fields = instance.getClass().getDeclaredFields();
        //Lấy toàn bộ field của object
        for (Field field : fields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Object dependency = instances.get(field.getType());
                //field.getType() → Các class(bean) đã được register khi chạy ở LitSpringboot
                if (dependency != null) {
                    field.setAccessible(true);
                    //Cho phép set giá trị cho field private
                    //Nếu không có dòng này → IllegalAccessException
                    try {
                        field.set(instance, dependency);
                        //Gán dependency vào field  vd: instance.myService = dependency;
                        // Ở đây dependency đã được khia báo bằng 1 constructor ko tham số khi register class
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}