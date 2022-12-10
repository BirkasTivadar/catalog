package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    protected List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        CatalogItem deleteItem = catalogItems.stream()
                .filter(catalogItem -> catalogItem.getRegistrationNumber().equals(registrationNumber))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Catalog item not exists with this registration number: %s", registrationNumber)));
        catalogItems.remove(deleteItem);
    }

    public List<CatalogItem> getAudioLibraryItems() {
        return catalogItems.stream()
                .filter(CatalogItem::hasAudioFeature)
                .toList();
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        return catalogItems.stream()
                .filter(CatalogItem::hasPrintedFeature)
                .toList();
    }

    public int getAllPageNumber() {
        return getPrintedLibraryItems().stream()
                .mapToInt(CatalogItem::numberOfPagesAtOneItem)
                .sum();
    }

    public int getFullLength() {
        return getAudioLibraryItems().stream()
                .mapToInt(CatalogItem::fullLengthAtOneItem)
                .sum();
    }

    public double averagePageNumberOver(int aboveNumberPages) {
        if (aboveNumberPages <= 0) throw new IllegalArgumentException("Page number must be positive");

        return getPrintedLibraryItems().stream()
                .filter(printedLibraryItem -> printedLibraryItem.numberOfPagesAtOneItem() > aboveNumberPages)
                .mapToInt(CatalogItem::numberOfPagesAtOneItem)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("No page"));
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        return catalogItems.stream()
                .filter(catalogItem -> catalogItem.getTitles().contains(searchCriteria.getTitle()) || catalogItem.getContributors().contains(searchCriteria.getContributor()))
                .toList();
    }
}
