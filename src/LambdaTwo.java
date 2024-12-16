import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface extractatable {
    String extract(String whole);
}


public class LambdaTwo {

    private String extractP2(String whole) {
        // Extract the name part after "number. " ("John" from "1. John")
        return whole.substring(whole.indexOf('.') + 2).trim();
    }
    public String[] namesSortCAPS(String[] names) {
        return Arrays.stream(names)
                .sorted((a, b) -> extractP2(a).compareToIgnoreCase(extractP2(b)))
                .toArray(String[]::new);
    }
}

class LambdaTwoSandbox {


    public static void main(String[] args) {

        System.out.println(LambdaOneSandBox.NAMES);
        LambdaTwo l2 = new LambdaTwo();
        System.out.println(Arrays.toString(l2.namesSortCAPS(LambdaOneSandBox.NAMES.split(","))));
    }
}