import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int max=0;
		int len = str.length();
		for(int i=0;i<len;i++){
			for(int j = i;j<len;j++){

				if(str.charAt(j) != str.charAt(i)){
					if(j-i>max) max = j-i;
					i = j-1;
					break;
				} else if (str.charAt(j) == str.charAt(i) && j == len - 1) {
					if(j-i+1>max) max = j - i + 1;
					i = j;
					break;
				}

			}
		}
		return max; // YOUR CODE HERE
	}


	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		StringBuilder res= new StringBuilder();
		int len = str.length();
		for(int i=0;i<len;i++){
			char c = str.charAt(i);
			//if c isnt 0 to 9
			if(c<48 || c>57) res.append(c);
			else { //if it is
				if(i+1<len){ //check if it is the last char
					char d = str.charAt(i+1);
					//print out if d isn't 0 to 9
					//if(d<'0' || d>'9'){
						int count = Character.getNumericValue(c);
						for(int j=0;j<count;j++){
							res.append(d);
						}
					//}//if d is still 0 to 9 just print c out
					//else res.append(c);
				}
			}
		}
		return res.toString(); // YOUR CODE HERE

	}

	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> lmao= new HashSet<String>();
		String sub= "";
		int lena = a.length();
		int lenb = b.length();
		for(int i=0;i<=lena-len;i++){
			for(int j=i;j<i+len;j++){
				sub+=a.charAt(j);
			}
			lmao.add(sub);
			sub="";
		}

		for(int i=0;i<=lenb-len;i++){
			for(int j=i;j<i+len;j++){
				sub+=b.charAt(j);
			}
			if(lmao.contains(sub)){
				return true;
			}
			sub="";
		}
		return false; // YOUR CODE HERE
	}
}
