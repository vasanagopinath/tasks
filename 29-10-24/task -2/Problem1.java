import java.util.*;
import java.util.stream.Collectors;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }
        List<Integer> sortedEvens = numbers.stream()
                .filter(num -> num % 2 == 0) // filtering and sorting and storing 
                .sorted()                    
                .collect(Collectors.toList());

        sortedEvens.forEach(num -> System.out.print(num + " "));
        
        scanner.close();
    }
}
