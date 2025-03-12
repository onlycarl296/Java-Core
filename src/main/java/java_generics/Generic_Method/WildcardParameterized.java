package java_generics.Generic_Method;

import java.util.*;

public class WildcardParameterized {

    /*
    Ký tự đại diện <?>: chấp nhận tất cả các loại đối số (chứa mọi kiểu đối tượng).
    Ví dụ: Collection<?> mô tả một tập hợp chấp nhận tất cả các loại đối số kiểu String, Integer, Boolean, …
     */
    Collection<?> coll = new ArrayList<String>();

    // Một tập hợp chỉ chứa kiểu Number hoặc kiểu con của Number
    List<? extends Number> list = new ArrayList<Long>();

    // Một đối tượng có kiểu tham số đại diện.
    // (A wildcard parameterized type)
    Map<String,?> pair = new HashMap<>();
}
