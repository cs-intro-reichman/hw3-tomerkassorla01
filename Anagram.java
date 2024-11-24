/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String preProcessStr1 = preProcess(str1);
		String preProcessStr2 = preProcess(str2);
		char c;
		for (int i = 0; i < preProcessStr1.length(); i++) {
			String cuttedStr2 = "";
			int indexOfCharInStr2;
			c = preProcessStr1.charAt(i);
			indexOfCharInStr2 = preProcessStr2.indexOf(c);
			if(indexOfCharInStr2 == -1) {
				return false;
			}
			for (int j = 0; j < preProcessStr2.length(); j++) {
				if (j != indexOfCharInStr2)
				{
					cuttedStr2 += preProcessStr2.charAt(j);
				}
			}
			preProcessStr2 = cuttedStr2;
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String preProcessString = "";
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if ((c < 97) || (c > 122)) {
				if((c >= 65) && (c <= 90)) {
					preProcessString += (char)(c + 32);
				}
			}
			else {
				preProcessString += c;
			}
		}
		return preProcessString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String randomString = "";
		String s1 = str;
		for (int i = 0; i < str.length(); i++) {
			int randomNumber = (int)((Math.random()) * s1.length());
			randomString += s1.charAt(randomNumber);
			s1 = s1.substring(0,randomNumber) + s1.substring(randomNumber + 1);

		}
		return randomString;
	}
}
