import java.util.Collection;

public class Author implements Cloneable {
    private final String firstname;
    private final String lastname;

    public Author(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static String toString(Collection<Author> collection, BookCatalogFormat format) {
        StringBuilder str = new StringBuilder();
        for (Author author : collection)
            str.append(author.toString(format)).append("\n");
        return str.toString();
    }

    public String toString(BookCatalogFormat format) {
        return format.outputAuthor(firstname, lastname);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
