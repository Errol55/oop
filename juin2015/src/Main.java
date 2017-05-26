import java.io.IOException;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        BookCatalog books = new BookCatalog();
        populate(books);

        try {
            BookCatalog copy = (BookCatalog) books.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        try {
            books.export("catalog.xml", new XMLBookCatalogFormat());
        } catch (IOException e) {
            System.err.println("An error occurred.");
        }
    }

    private static void populate(BookCatalog books) {
        Vector<Author> authors = new Vector<>(5);
        for (int i = 0; i < authors.capacity(); i++)
            authors.add(new Author("firstname" + i, "lastname" + i));

        Vector<Author> v1 = new Vector<>();
        v1.add(authors.get(0));
        Vector<Author> v2 = new Vector<>();
        v2.add(authors.get(1));

        books.add(new Book("title1", v1, "comment1"));
        books.add(new Book("title2", v2, "comment2"));
        books.add(new Book("title3", authors, "comment3"));

    }
}
