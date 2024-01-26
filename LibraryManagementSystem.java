import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}

class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                return;
            }
        }
        System.out.println("Book not found with title: " + title);
    }

    public void searchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                return;
            }
        }
        System.out.println("Book not found with author: " + author);
    }

    public void displayAllBooks() {
        System.out.println("List of all books in the library:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() +
                    " - Status: " + (book.isCheckedOut() ? "Checked Out" : "Available"));
        }
    }

    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isCheckedOut()) {
                    book.setCheckedOut(true);
                    System.out.println("Book checked out successfully: " + book.getTitle());
                } else {
                    System.out.println("Book is already checked out: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book not found with title: " + title);
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isCheckedOut()) {
                    book.setCheckedOut(false);
                    System.out.println("Book returned successfully: " + book.getTitle());
                } else {
                    System.out.println("Book is already available: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book not found with title: " + title);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();

        // Adding books to the library
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("1984", "George Orwell"));

        // Searching for books
        library.searchByTitle("To Kill a Mockingbird");
        library.searchByAuthor("George Orwell");

        // Displaying all books
        library.displayAllBooks();

        // Checking out and returning books
        library.checkOutBook("To Kill a Mockingbird");
        library.returnBook("To Kill a Mockingbird");
    }
}
