import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int n = scanner.nextInt();
        scanner.nextLine(); 
        List<Optional<String>> optionals = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if ("empty".equals(input)) {
                optionals.add(Optional.empty());
            } else {
                optionals.add(Optional.of(input));
            }
        }
        
        Optional<String> firstNonEmpty = optionals.stream()
                                                  .filter(Optional::isPresent)
                                                  .findFirst()
                                                  .orElse(Optional.empty());

        System.out.println(firstNonEmpty.orElse("No value found"));
        
        scanner.close();
    }
}
