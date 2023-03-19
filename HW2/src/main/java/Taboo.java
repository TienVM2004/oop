
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
	List<T> lis;
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		lis = rules;
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		 Set<T> set = new HashSet<>();
		 for(int i=0;i<lis.size()-1;i++){
			 if(lis.get(i).equals(elem)){
				 set.add(lis.get(i+1));
			 }
		 }
		return set; // YOUR CODE HERE
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		int len = list.size();
		for(int i = 0; i < len-1; i++){
			for(int j = 0; j < lis.size()-1; j++){
				if(list.get(i).equals(lis.get(j)) && list.get(i+1).equals(lis.get(j+1))){
					list.remove(i+1);
					i=0;j=0;
					len = list.size();
				}
			}
		}

	}
}
