//package catalog;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static catalog.SearchCriteria.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//class CatalogTest {
//    public CatalogItem catalogItem1 = new CatalogItem("R-1", 300,
//            new AudioFeatures("Night Visions", 185, List.of("Dan Raynolds"), List.of("Imagine Dragons")),
//            new PrintedFeatures("Harry Potter", 600, List.of("J.K. Rowling")),
//            new AudioFeatures("Piece of Mind", 200, List.of("Steve Harris"), List.of("Iron Maiden"))
//
//    );
//
//    public CatalogItem catalogItem2 = new CatalogItem("R- 2", 300,
//            new PrintedFeatures("Harry Potter", 500, List.of("J.K. Rowling"))
//    );
//
//
//    public CatalogItem catalogItem3 = new CatalogItem("R-3", 300,
//            new AudioFeatures("Californication", 100, List.of("Flea"), List.of("RHCP"))
//    );
//
//    public Catalog catalog = new Catalog();
//
//
//    @Test
//    void testAddAndDeleteItem() {
//        assertEquals(0, catalog.catalogItems.size());
//        catalog.addItem(catalogItem1);
//        assertEquals(1, catalog.catalogItems.size());
//        catalog.deleteItemByRegistrationNumber("R-1");
//        assertEquals(0, catalog.catalogItems.size());
//
//    }
//
//    @Test
//    void testGetAudioLibraryItems() {
//
//        catalog.addItem(catalogItem1);
//        catalog.addItem(catalogItem2);
//
//        assertEquals(1, catalog.getAudioLibraryItems().size());
//
//    }
//
//    @Test
//    void testGetPrintedLibraryItems() {
//
//        catalog.addItem(catalogItem1);
//        catalog.addItem(catalogItem2);
//
//        assertEquals(2, catalog.getPrintedLibraryItems().size());
//    }
//
//    @Test
//    void testGetAllPageNumber() {
//
//        catalog.addItem(catalogItem1);
//        catalog.addItem(catalogItem2);
//
//        assertEquals(1100, catalog.getAllPageNumber());
//
//    }
//
//    @Test
//    void testGetFullLength() {
//
//        catalog.addItem(catalogItem1);
//        catalog.addItem(catalogItem2);
//        catalog.addItem(catalogItem3);
//
//        assertEquals(485, catalog.getFullLength());
//    }
//
//    @Test
//    void testAveragePageWithIllegalArgument() {
//        catalog.addItem(catalogItem1);
//        catalog.addItem(catalogItem2);
//        catalog.addItem(catalogItem3);
//
//        Exception actualException = assertThrows(IllegalArgumentException.class, () -> {
//            catalog.averagePageNumberOver(0);
//        });
//        assertEquals("Page number must be positive", actualException.getMessage());
//    }
//
//    @Test
//    void testAveragePageWithZero() {
//        catalog.addItem(catalogItem1);
//        catalog.addItem(catalogItem2);
//        catalog.addItem(catalogItem3);
//
//        Exception actualException = assertThrows(IllegalArgumentException.class, () -> {
//            catalog.averagePageNumberOver(10000);
//        });
//        assertEquals("No page", actualException.getMessage());
//    }
//
//    @Test
//    void testAveragePageNumberOverVariable() {
//        catalog.addItem(catalogItem1);
//        catalog.addItem(catalogItem2);
//        catalog.addItem(catalogItem3);
//
//        assertEquals(550.0, catalog.averagePageNumberOver(100));
//        assertEquals(600.0, catalog.averagePageNumberOver(501));
//
//    }
//
//    @Test
//    void testFindByCriteriaBoth() {
//
//        SearchCriteria searchCriteria = createByBoth("Night Visions", "Dan Raynolds");
//
//
//        catalog.addItem(catalogItem1);
//        catalog.addItem(catalogItem2);
//
//        assertEquals(1, catalog.findByCriteria(searchCriteria).size());
//        assertEquals("Night Visions", catalog.findByCriteria(searchCriteria).get(0).getFeatures().get(0).getTitle());
//
//    }
//
//    @Test
//    void testFindByCriteriaContributor() {
//
//
//        SearchCriteria searchCriteria = createByContributor("Imagine Dragons");
//
//
//        catalog.addItem(catalogItem1);
//
//        assertEquals(1, catalog.findByCriteria(searchCriteria).size());
//
//    }
//
//    @Test
//    void testFindByCriteriaTitle() {
//
//        SearchCriteria searchCriteria = createByTitle("Harry Potter");
//
//
//        catalog.addItem(catalogItem1);
//
//        assertEquals(1, catalog.findByCriteria(searchCriteria).size());
//
//    }
//
//}