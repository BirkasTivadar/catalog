package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

    private final String registrationNumber;
    private final int price;
    private final List<Feature> features = new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features.addAll(Arrays.asList(features));
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return new ArrayList<>(features);
    }

    public int numberOfPagesAtOneItem() {
        return features.stream()
                .filter(PrintedFeatures.class::isInstance)
                .mapToInt(feature -> ((PrintedFeatures) feature).getNumberOfPages())
                .sum();
    }

    public int fullLengthAtOneItem() {
        return features.stream()
                .filter(AudioFeatures.class::isInstance)
                .mapToInt(feature -> ((AudioFeatures) feature).getLength())
                .sum();
    }

    public List<String> getContributors() {
        List<String> result = new ArrayList<>();
        features.forEach(feature -> result.addAll(feature.getContributors()));
        return result;
    }

    public List<String> getTitles() {
        return features.stream()
                .map(Feature::getTitle)
                .toList();
    }

    public boolean hasAudioFeature() {
        return fullLengthAtOneItem() > 0;
    }

    public boolean hasPrintedFeature() {
        return numberOfPagesAtOneItem() > 0;
    }
}
