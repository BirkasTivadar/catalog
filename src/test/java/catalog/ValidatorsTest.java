//package catalog;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import static catalog.Validators.isBlank;
//import static catalog.Validators.isEmpty;
//
//class ValidatorsTest {
//    @Test
//     void testIsBlank() {
//        assertTrue(isBlank(null));
//        assertTrue(isBlank(""));
//        assertTrue(isBlank("    "));
//        assertFalse(isBlank("a"));
//        assertFalse(isBlank("     a       "));
//    }
//
//    @Test
//    void testIsEmpty() {
//        assertTrue(isEmpty(null));
//        assertTrue(isEmpty(Arrays.asList()));
//        assertFalse(isEmpty(Arrays.asList("aaa")));
//        assertFalse(isEmpty(Arrays.asList("aaa", "bbb")));
//    }
//
//}