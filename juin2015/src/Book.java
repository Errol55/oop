import java.util.Vector;

public class Book implements Cloneable {

    private final String title;
    private Vector<Author> authors;
    private final String comment;

    public Book(String title, Vector<Author> authors, String comment) {
        this.title = title;
        this.authors = authors;
        this.comment = comment;
    }

    public String toString(BookCatalogFormat format) {
        return format.beginBook() + "\n" +
                format.outputTitle(title) +
                Author.toString(authors, format) +
                format.outputComment(comment) +
                format.endBook();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Book book = (Book) super.clone();
        book.authors = new Vector<>();
        for(Author author: authors)
            book.authors.add((Author) author.clone());
        return book;
    }
}
