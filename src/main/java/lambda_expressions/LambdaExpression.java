package lambda_expressions;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Addable {
    int add(int a, int b);
}

public class LambdaExpression {

    public static void main(String[] args) {

        // Multiple parameters with data type in lambda expression
        Addable ad1 = (int a, int b) -> (a + b);
        System.out.println(ad1.add(10, 20));

        // Multiple parameters in lambda expression
        Addable ad2 = (a, b) -> (a + b);
        System.out.println(ad2.add(10, 20));

        // Lambda expression without return keyword.
        Addable ad3 = (a, b) -> (a + b);
        System.out.println(ad3.add(10, 20));

        // Lambda expression with return keyword.
        Addable ad4 = (a, b) -> {
            return (a + b);
        };
        System.out.println(ad4.add(10, 20));

        // Lambda expression without return keyword.
        Addable ad5 = (a, b) -> (a + b);
        System.out.println(ad5.add(10, 20));

        // Lambda expression with multi-statement
        Addable ad6 = (a, b) -> {
            int sum = (a + b);
            return sum;
        };
        System.out.println(ad6.add(10, 20));

        //-------------------------------------------------------------------------------------------------------------------

        List<String> languages = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

        // Using Lambda expression
        languages.forEach(n -> System.out.println(n));

        //--------------------------------------------------------------------------------------------------------------
        //Ví dụ biểu thức Lambda tạo Thread
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("Runnable 1");
            }
        };

        // Using Lambda Expression for Funcational Interface
        Runnable r2 = () -> System.out.println("Runnable 2");
        //Chỉ có thể sử dụng biểu thức lamda kiểu này nếu đó là 1 function interface
        //Ở đấy thì Runnable chính là 1 functional interface (1 interface chỉ có 1 phương thức trừu tượng duy nhất

        r1.run();
        r2.run();

    }

}
