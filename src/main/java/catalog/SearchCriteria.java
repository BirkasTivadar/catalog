package catalog;

public class SearchCriteria {

    public static String contributor;

    public static String title;

    private SearchCriteria(String contributor, String title) {
        SearchCriteria.contributor = contributor;
        SearchCriteria.title = title;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (Validators.isBlank(title) || Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Contributor and title must not be empty");
        }

        return new SearchCriteria(contributor, title);
    }

    public static SearchCriteria createByTitle(String title) {
        if (Validators.isBlank(title)) throw new IllegalArgumentException("Title must not be empty");

        return new SearchCriteria(null, title);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)) throw new IllegalArgumentException("Contributor must be not empty");

        return new SearchCriteria(contributor, null);
    }

    public boolean hasContributor() {
        return !Validators.isBlank(contributor);
    }

    public boolean hasTitle() {
        return !Validators.isBlank(title);
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }
}
