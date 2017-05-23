public interface BookCatalogFormat {
    String beginDocument();

    String beginBook();

    String outputTitle(String title);

    String outputAuthor(String firstname, String lastname);

    String outputComment(String comment);

    String endBook();

    String endDocument();
}