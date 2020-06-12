import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        // type your java code here
        if (n == 0) {
            return BigInteger.ONE;
        }
        BigInteger result = new BigInteger(String.valueOf(n));
        for (int i = n - 2; i > 1; i--, i--) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }
}