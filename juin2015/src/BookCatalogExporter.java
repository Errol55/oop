import java.io.IOException;

public interface BookCatalogExporter {
    void export(String filename, BookCatalogFormat format) throws IOException;
}
