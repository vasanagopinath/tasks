import java.util.*;
import java.util.stream.Collectors;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> strings = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            strings.add(scanner.nextLine());
        }
        
        Map<Integer, List<String>> groupedByLength = strings.stream()
                .collect(Collectors.groupingBy(String::length));

        
        groupedByLength.forEach((length, strList) -> 
                System.out.println(length + ": " + strList));
        
        scanner.close();
    }
}
