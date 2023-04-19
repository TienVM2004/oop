// TabooTest.java
// Taboo class tests -- nothing provided.

import org.junit.Test;
import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class TabooTest {
    Taboo taboo;
    List<Character> list = new ArrayList<>(Arrays.asList('a', 'c', 'a', 'b'));
    Taboo<Character> reduced = new Taboo<>(list);
    List<Character> destroy = new ArrayList<>(Arrays.asList('a', 'c', 'b', 'x', 'c', 'a'));
    List<Character> afterReduce = new ArrayList<>(Arrays.asList('a', 'x', 'c'));

    @Test
    public void testReduce() {
        reduced.reduce(destroy);
        assertEquals(afterReduce, new ArrayList<>(destroy));
    }
    @Test
    public void testReduce1() {
        List<String> a1 = new ArrayList<String>(Arrays.asList("a", "c", "b", "x","c","a"));
        List<String> rl =new ArrayList<String>( Arrays.asList("a","c","a","b"));
        taboo = new Taboo<>(rl);
        List<String> expected_a1 = Arrays.asList("a", "x", "c");
        taboo.reduce(a1);
        assertEquals(expected_a1, a1);
    }
    @Test
    public void testReduce2() {
        List<String> rl2 = new ArrayList<String>(Arrays.asList("a", "b", null, "c", "d"));
        taboo = new Taboo<>(rl2);
        List<String> a2 = new ArrayList<String>(Arrays.asList("a","b","c","h","b","a"));
        List<String> expected_a2 = Arrays.asList("a","c","h","b","a");
        taboo.reduce(a2);
        assertEquals(expected_a2, a2);
    }
    @Test
    public void testNoFollow1() {
        List<Character> rules2 = Arrays.asList('k','a',null,null,'d','a','b',null,'h');
        taboo = new Taboo<>(rules2);
        Set<Character> expected2 = new HashSet<>(Arrays.asList('b'));
        Set<Character> actual2 = taboo.noFollow('a');
        assertEquals(expected2,actual2);
    }
}
