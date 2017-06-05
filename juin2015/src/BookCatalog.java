import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class BookCatalog implements BookCatalogExporter, Cloneable {

    private Vector<Book> books = new Vector<>();

    public void add(Book book) {
        books.add(book);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        BookCatalog bookCatalog = (BookCatalog) super.clone();
        bookCatalog.books = new Vector<>();
        for (Book book : books)
            bookCatalog.books.add((Book) book.clone());
        return bookCatalog;
    }

    @Override
    public void export(String filename, BookCatalogFormat format) throws IOException {

        FileWriter fileWriter = new FileWriter(filename);
        try{
            fileWriter.write(format.beginDocument() + "\n");

            for (Book book : books)
                fileWriter.write(book.toString(format) + "\n");

            fileWriter.write(format.endDocument() + "\n");
        } finally {
            fileWriter.close();
        }
    }
}
