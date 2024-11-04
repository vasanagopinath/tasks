import java.util.Arrays;

class Student {
    String name;
    int score;

    
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public String toString() {
        return name + ": " + score;
    }
}

public class task2 {
    public static void main(String[] args) {
        
        Student[] students = {
            new Student("Alice", 90),
            new Student("Bob", 85),
            new Student("Charlie", 90),
            new Student("David", 85),
            new Student("Eve", 95)
        };
        
        
        Arrays.sort(students, (s1, s2) -> {
            
            if (s2.score != s1.score) {
                return Integer.compare(s2.score, s1.score);
            }
            
            return s1.name.compareTo(s2.name);
        });
        
        
        System.out.println("Sorted Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
