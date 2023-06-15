import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);

        if (b == 0) {
            System.out.println("b равен " + b + " на ноль делить нельзя");
        }else {
            int c = calc.devide.apply(a, b); // код не работает из-за деления на ноль. Можно решить как тут, или через перехват ошибок
            calc.println.accept(c);
        }
    }

    public static class Calculator {
        static Supplier<Calculator> instance = Calculator::new;

        BinaryOperator<Integer> plus = (x, y) -> x + y;
        BinaryOperator<Integer> minus = (x, y) -> x - y;
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        BinaryOperator<Integer> devide = (x, y) -> x / y;
        UnaryOperator<Integer> pow = x -> x * x;
        UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
        Predicate<Integer> isPositive = x -> x > 0;
        Consumer<Integer> println = System.out::println;
    }
}