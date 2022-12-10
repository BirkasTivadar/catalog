package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {
    private final String title;
    private final int length;
    private final List<String> performers;
    private List<String> composer;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (Validators.isBlank(title)) throw new IllegalArgumentException("Title can not be null or empty");
        if (length <= 0) throw new IllegalArgumentException("Length must be larger than zero");
        if (Validators.isEmpty(performers)) throw new IllegalArgumentException("There must be perfpmers(s)");

        this.title = title;
        this.length = length;
        this.performers = new ArrayList<>(performers);
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        this(title, length, performers);
        this.composer = new ArrayList<>(composer);
    }

    public int getLength() {
        return length;
    }

    @Override
    public List<String> getContributors() {
        List<String> result = new ArrayList<>();
        if (!Validators.isEmpty(composer)) result.addAll(composer);
        if (!Validators.isEmpty(performers)) result.addAll(performers);
        return result;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
