import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaOne {

    public List<String> filteredNAMES(String names) {
        return Arrays.stream(names.split(", "))
                .filter(s -> Integer.parseInt(s.split("\\.")[0]) % 2 != 0)
                .collect(Collectors.toList());
    }
}

class LambdaOneSandBox {
    public static final String NAMES = "1. Alice, 2. Bob, 3. Charlie, 4. David, 5. Eve, 6. Fiona, 7. George, 8. Hannah, 9. Ian, 10. Jack, 11. Karen, 12. Liam, 13. Mia, 14. Noah, 15. Olivia, 16. Paul, 17. Quinn, 18. Rachel, 19. Sam, 20. Tina, 21. Uma, 22. Victor, 23. Wendy, 24. Xander, 25. Yara, 26. Zoe, 27. Amber, 28. Brian, 29. Clara, 30. Dylan, 31. Ethan, 32. Grace, 33. Harper";

    public static void main(String[] args) {
        System.out.println("\n"+"--===||    Unfiltered names are    ||===--");
        System.out.println(NAMES);
        System.out.println("\n"+"--===||     Filtered names are     ||===--");
        System.out.println(new LambdaOne().filteredNAMES(NAMES));
    }
}