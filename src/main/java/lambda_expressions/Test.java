package lambda_expressions;

public class Test {
    int b=1;
    int c= 2;
    Addable a= (b,c)-> {
        return b;
    };
}
