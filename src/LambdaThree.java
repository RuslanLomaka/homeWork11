import java.util.stream.Stream;
public class LambdaThree {
    public Stream<Double> generateLCG(double a, double c, double m) {
        return Stream.iterate(0d, d ->  ((a * d + c) % m));
    }
}
class LambdaThreeSandBox {
    public static void main(String[] args) {
        double a = 25214903917d;
        double c = 11d;
        double m = Math.pow(2, 48);
        new LambdaThree().generateLCG(a, c, m).forEach(System.out::println);
    }
}