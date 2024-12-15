import java.util.stream.Stream;
    public static void main(String[] args) {
        double a = 25214903917d;
        double c = 11d;
        double m = Math.pow(2, 48);
        Stream.iterate(0d, d ->  ((a * d + c) % m))//Get infinity stream of pseudorandom numbers
                .forEach(System.out::println);//Just printing it to console
    }