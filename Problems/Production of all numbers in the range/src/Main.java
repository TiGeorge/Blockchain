import java.util.function.LongBinaryOperator;

class Operator {

    public static LongBinaryOperator binaryOperator =
        (l1, l2) -> LongStream.rangeClosed(l1, l2).reduce(1, (a, b) -> a * b);
}
