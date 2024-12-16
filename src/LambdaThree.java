import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.Integer.parseInt;


public class LambdaThree {


    public void joinAndSort(String[] data) {


        //My firs independent design that actually works
        List<Integer> sortedIntegers = new ArrayList<>();

        Arrays.stream(data)
                .forEach(d -> Arrays.stream(d.replaceAll(" ", "").split(","))
                        .forEach(n -> sortedIntegers
                                .add(parseInt(n))));

        sortedIntegers.stream()
                .sorted()
                .forEach(i -> System.out.print(i + ", "));

        //Improved second version when I asked chat GPT for advice and learned more about Collectors
//        String sortedNumbers = Arrays.stream(data)
//                .flatMap(d -> Arrays.stream(d.replaceAll(" ", "").split(","))) // Flatten all strings into a single stream
//                .map(Integer::parseInt) // Convert each string to an integer
//                .sorted() // Sort the integers
//                .map(String::valueOf) // Convert back to strings for joining
//                .collect(Collectors.joining(", ")); // Join with commas
//
//        System.out.println(sortedNumbers);

    }
}

class LambdaThreeSandBox {

    public static final String[] DATA;

    static {
        DATA = new String[]{
                "3, 21, 67, 45, 98",
                "10, 56, 4, 79",
                "1, 50, 34",
                "23, 17, 88, 41, 73",
                "95, 12, 61, 6",
                "33, 85, 53, 77, 11",
                "31, 48, 100",
                "25, 64, 8, 92",
                "5, 26, 72, 84",
                "38, 71, 13, 60, 90",
                "2, 27, 44",
                "9, 51, 28, 74",
                "20, 18, 35, 57, 87",
                "7, 30, 96, 16",
                "43, 70, 62, 24",
                "14, 36, 47, 89, 19",
                "49, 29, 82",
                "32, 59, 78, 63",
                "54, 40, 99",
                "22, 66, 55, 39",
                "68, 46, 76, 80, 15",
                "37, 52, 97, 75",
                "42, 58, 94, 93, 69",
                "65, 81, 83, 86, 91"
        };
    }

    public static void main(String[] args) {

        new LambdaThree().joinAndSort(DATA);


    }
}
