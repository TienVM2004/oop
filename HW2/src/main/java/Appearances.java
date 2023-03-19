import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		Map<T, Integer> mpA = new HashMap<>();
		Map<T, Integer> mpB = new HashMap<>();
		for (T s : a) {
			mpA.put(s, mpA.getOrDefault(s, 0) + 1);
		}
		for (T s : b) {
			mpB.put(s, mpB.getOrDefault(s, 0) + 1);
		}
		int count = 0;
		for(T key: mpA.keySet()){
			Integer num = mpA.get(key);
			if(mpB.get(key)==num) count++;
		}
		return count; // YOUR CODE HERE
	}
	
}
