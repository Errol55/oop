
public class XMLBookCatalogFormat implements BookCatalogFormat {

    @Override
    public String beginDocument() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<library>";
    }

    @Override
    public String beginBook() {
        return "<book>";
    }

    @Override
    public String outputTitle(String title) {
        return "<title>" + title + "</title>";
    }

    @Override
    public String outputAuthor(String firstname, String lastname) {
        return "<author><first>" + firstname + "</first><last>" + lastname + "</last></author>";
    }

    @Override
    public String outputComment(String comment) {
        return "<comment>" + comment + "</comment>";
    }

    @Override
    public String endBook() {
        return "</book>";
    }

    @Override
    public String endDocument() {
        return "</library>";
    }
}
