import java.util.ArrayList;
import java.util.List;

abstract class MagicalBook {
    private String title;
    private String author;
    private String subject;
    private boolean isRestricted;

    public MagicalBook(String title, String author, String subject, boolean isRestricted) {
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.isRestricted = isRestricted;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getSubject() { return subject; }

    // Encapsulate  isRestricted
    public boolean isRestricted() { return isRestricted; }
    protected void setRestricted(boolean restricted) { this.isRestricted = restricted; }

    public void openBook() { System.out.println(title + " is now open."); }
    public void closeBook() { System.out.println(title + " is now closed."); }

    // Abstract method 
    public abstract void useBook();
}

// Interface
interface Readable {
    String summarizeContent();
    void bookmarkPage(int pageNumber);
}

// Subclass
class SpellBook extends MagicalBook implements Readable {
    public SpellBook(String title, String author) {
        super(title, author, "Spells", false);
    }

    @Override
    public void useBook() {
        System.out.println("Casting spells from " + getTitle());
    }

    @Override
    public String summarizeContent() {
        return "A collection of powerful spells.";
    }

    @Override
    public void bookmarkPage(int pageNumber) {
        System.out.println("Bookmarking page " + pageNumber + " in " + getTitle());
    }
}

// Subclass
class PotionBook extends MagicalBook implements Readable {
    public PotionBook(String title, String author) {
        super(title, author, "Potions", false);
    }

    @Override
    public void useBook() {
        System.out.println("Brewing potions from " + getTitle());
    }

    @Override
    public String summarizeContent() {
        return "A guide to brewing various magical potions.";
    }

    @Override
    public void bookmarkPage(int pageNumber) {
        System.out.println("Bookmarking page " + pageNumber + " in " + getTitle());
    }
}

// Subclass
class DarkArtsBook extends MagicalBook implements Readable {
    public DarkArtsBook(String title, String author) {
        super(title, author, "Dark Arts", true);
    }

    @Override
    public void useBook() {
        System.out.println("Exploring the Dark Arts in " + getTitle());
    }

    @Override
    public String summarizeContent() {
        return "Contains advanced dark magic spells. Restricted content.";
    }

    @Override
    public void bookmarkPage(int pageNumber) {
        System.out.println("Bookmarking page " + pageNumber + " in " + getTitle());
    }
}

//  Library 
class Library {
    private List<MagicalBook> books = new ArrayList<>();

    public void addBook(MagicalBook book) {
        books.add(book);
        System.out.println(book.getTitle() + " has been added to the library.");
    }

    public void removeBook(MagicalBook book) {
        books.remove(book);
        System.out.println(book.getTitle() + " has been removed from the library.");
    }

    public void listBooks() {
        System.out.println("Listing all books in the library:");
        for (MagicalBook book : books) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
        }
    }

    public MagicalBook searchBookByTitle(String title) {
        for (MagicalBook book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found book: " + book.getTitle());
                return book;
            }
        }
        System.out.println("Book not found.");
        return null;
    }
}

// LibraryUser 
class LibraryUser {
    private String name;
    private boolean isProfessor;

    public LibraryUser(String name, boolean isProfessor) {
        this.name = name;
        this.isProfessor = isProfessor;
    }

    public void borrowBook(MagicalBook book) {
        if (book.isRestricted() && !isProfessor) {
            System.out.println(name + " cannot borrow restricted book: " + book.getTitle());
        } else {
            System.out.println(name + " has borrowed " + book.getTitle());
            book.openBook();
        }
    }
}

public class HogwartsLibrarySystem {
    public static void main(String[] args) {
        Library hogwartsLibrary = new Library();

        // Creating
        SpellBook spellBook = new SpellBook("The Standard Book of Spells", "Miranda Goshawk");
        PotionBook potionBook = new PotionBook("Advanced Potion-Making", "Libatius Borage");
        DarkArtsBook darkArtsBook = new DarkArtsBook("Secrets of the Darkest Art", "Unknown");

        // Adding books 
        hogwartsLibrary.addBook(spellBook);
        hogwartsLibrary.addBook(potionBook);
        hogwartsLibrary.addBook(darkArtsBook);

        // Listing 
        hogwartsLibrary.listBooks();

        // Creating users
        LibraryUser student = new LibraryUser("gopi nath", false);
        LibraryUser professor = new LibraryUser("dinesh", true);

        // Borrowing books
        student.borrowBook(spellBook);
        student.borrowBook(darkArtsBook); // Restricted  for students

        professor.borrowBook(darkArtsBook); // access for professors

        // Searching 
        hogwartsLibrary.searchBookByTitle("Advanced Potion-Making");
    }
}
