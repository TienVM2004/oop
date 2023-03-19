// TabooTest.java
// Taboo class tests -- nothing provided.

import org.junit.Test;
import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class TabooTest {
    List<Character> list = new ArrayList<>(Arrays.asList('a', 'c', 'a', 'b'));
    Taboo<Character> reduced = new Taboo<>(list);
    List<Character> destroy = new ArrayList<>(Arrays.asList('a', 'c', 'b', 'x', 'c', 'a'));
    List<Character> afterReduce = new ArrayList<>(Arrays.asList('a', 'x', 'c'));

    @Test
    public void testReduce() {
        reduced.reduce(destroy);
        assertEquals(afterReduce, new ArrayList<>(destroy));
    }
}
