package java_generics.Generic_Interface;

public interface GenericDao<T> {

    void insert(T obj);

    void update(T obj);

}
