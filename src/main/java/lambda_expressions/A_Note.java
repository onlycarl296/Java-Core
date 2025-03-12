package lambda_expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A_Note {
    public static void main(String[] args) {

        List<String> languages = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

        Collections.sort(languages, (String o1, String o2) -> {
            return o1.compareTo(o2);
        });

        for (String language : languages) {
            System.out.println(language);
        }
    }
}
/*
    Lambda Expression (biểu thức Lambda) có thể được định nghĩa là một hàm ẩn danh, cho phép người dùng chuyển các phương thức làm đối số.
    Điều này giúp loại bỏ rất nhiều mã soạn sẵn.


    - Tùy chọn khai báo kiểu dữ liệu: Bạn không cần phải khai báo kiểu dữ liệu cho các parameter truyền vào.
    Trình biên dịch sẽ tự suy luận ra kiểu dữ liệu từ giá trị của các parameter.

    - Tùy chọn sử dụng dấu ngoặc (): Trong trường hợp bạn chỉ truyền vào một parameter duy nhất thì chúng ta có thể bỏ qua cặp dấu ngoặc ().
    Nếu như có nhiều parameter thì phải sử dụng dấu ngoặc.
        (arg1, arg2, ...) -> {
            body-block
         }
        (parameters) -> expression

    - Tùy chọn sử dụng dấu ngoặc {}: Trong trường hợp phần body code của chúng ta chỉ thực hiện 1 statement duy nhất
    thì chúng ta cũng có thể loại bỏ luôn cặp dấu ngoặc {}.
        () -> expression

    -Tùy chọn sử dụng lệnh return: Trong biểu thức Lambda, nếu chỉ có một câu lệnh, bạn có thể sử dụng hoặc không sử dụng từ khoá return.
    Bạn phải sử dụng từ khóa return khi biểu thức lambda chứa nhiều câu lệnh.
        (arg1, arg2, ...) -> {
            body-block;
            return return-value;
        }
 */
