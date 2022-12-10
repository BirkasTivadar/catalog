package catalog;

import java.util.ArrayList;
import java.util.List;

public class PrintedFeatures implements Feature {

    private final String title;

    private final int numberOfPages;

    private final List<String> authors;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (Validators.isBlank(title)) throw new IllegalArgumentException("Empty title");
        if (numberOfPages <= 0) throw new IllegalArgumentException("Number of pages must be larger than zero");
        if (Validators.isEmpty(authors)) throw new IllegalArgumentException("There must be author(s)");
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = new ArrayList<>(authors);
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public List<String> getContributors() {
        return new ArrayList<>(authors);
    }

    @Override
    public String getTitle() {
        return title;
    }
}
