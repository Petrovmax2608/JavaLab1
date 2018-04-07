import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertFalse;

public class test {
    @Test
    public void plus() {
        assertEquals(new Num("100км"), new Num("40км").plus(new Num("60км")));
        assertEquals(new Num("120км"),
                new Num("40км")
                        .plus(new Num("60км"))
                        .plus(new Num("20км")));
        assertThrows(IllegalArgumentException.class, () -> {
            new Num("12км").plus(new Num("1гр"));
        });
    }

    @Test
    public void minus() {
        assertEquals(new Num("-20р"), new Num("40р").minus(new Num("60р")));
        assertEquals(new Num("-40р"), new Num("40р").minus(new Num("60р"))
                .minus(new Num("20р")));
    }

    @Test
    public void times() {
        assertEquals(new Num("2400р"), new Num("40р").times(new Num("60р")));
        assertEquals(new Num("48000р"),
                new Num("40р")
                        .times(new Num("60р"))
                        .times(new Num("20р")));
    }

    @Test
    public void times1() {
        assertEquals(new Num("48р"), new Num("40р").times(1.2));
        assertEquals(new Num("956.8р"),
                new Num("40р")
                        .times(2.6)
                        .times(9.2));
    }

    @Test
    public void division() {
        assertEquals(new Num("2р"), new Num("40р").division(new Num("20р")));
        assertEquals(new Num("16р"), new Num("40р").division(new Num("2.5р")));

    }

    @Test
    public void division1() {
        assertEquals(new Num("18р"), new Num("27р").division(1.5));
        assertEquals(new Num("16р"), new Num("40р").division(2.5));
    }

    @Test
    public void equals() {
        assertFalse(new Num("20h").equals(new Num("20k")));
        assertTrue(new Num("20h").equals(new Num("20h")));
    }

    @Test
    public void toStringTest() {
        assertEquals("1000.0кг", (new Num("1000кг").toString()));
    }
}