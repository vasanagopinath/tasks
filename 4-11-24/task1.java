import java.util.Arrays;

public class task1 {
    public static void main(String[] args) {
        String[] words = {"apple", "pie", "banana", "kiwi", "pear"};
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("Sorted array by length:");
        System.out.println(Arrays.toString(words));
    }
}
