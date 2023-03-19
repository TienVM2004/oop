import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class AppearancesTest {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}

	@Test
	public void testSameCount_Basic_Character() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, b));
	}

	@Test
	public void testSameCount_Basic_Integer() {
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}

	@Test
	public void meh() {
		List<Integer> a = Arrays.asList(6,6,6,6,6,6,6,6,6,6,6);
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(6,7,5,4,6,6)));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(9,9,9,9,9,9,9,9,9,9,9,9,9,9)));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(8,8,8,8,8,8,8,8,8,8,8)));
	}

	@Test
	public void mehh() {
		List<Integer> a = Arrays.asList(6,6,6,6,7,7,7,7,8);
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(6,7,1,4,6,6)));
		assertEquals(3, Appearances.sameCount(a, Arrays.asList(7,6,7,6,7,6,7,8,6)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(6,6,6,6,8,8,8,5,8,8,8)));
	}
	
	// Add more tests
}
