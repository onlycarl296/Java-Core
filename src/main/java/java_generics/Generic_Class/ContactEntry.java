package java_generics.Generic_Class;


//Một class mở rộng từ một class Generics, nó có thể chỉ định rõ kiểu cho tham số Generics,
// giữ nguyên các tham số Generics hoặc thêm các tham số Generics.

//public class ContactEntry extends KeyValuePair<String, Integer> {
//    public ContactEntry(String key, Integer value) {
//        super(key, value);
//    }
//}

//public class ContactEntry<V> extends KeyValuePair<String, V> {
//    public ContactEntry(String key, V value) {
//        super(key, value);
//    }
//}

//public class ContactEntry<K, V> extends KeyValuePair<K, V> {
//    public ContactEntry(K key, V value) {
//        super(key, value);
//    }
//}

public class ContactEntry<K, V, T> extends KeyValuePair<K, V> {

    private T obj;

    public ContactEntry(K key, V value, T obj) {
        super(key, value);
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

}
