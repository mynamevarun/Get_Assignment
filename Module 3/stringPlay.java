package p3;
import java.util.*;


class strOperation{
	
	/**
	 * To check whether Strings are Equal or not.
	 * @param Two Strings values which are to be checked
	 * @return   return 1 if strings are equal and 0 if not equal.
	 */
	public int checkString(String str1, String str2) {
		int len = str1.length();
		int i=0;
		if(str1.length() == str2.length()) {
				while(i<len) {
					if(str1.charAt(i)!= str2.charAt(i)) {
						return 0;
					}
					i++;
				}
				return 1;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Reverse a String 
	 * @param String that to be reversed.
	
	 * @return the reversed String
	 */
	public String reverseStr(String st) {
		String revStr="";
		int start=0;
		int end = st.length()-1;
		char[] temparray = st.toCharArray();
		while(start<end) {
			// swapping the charcaters
			 char temp = temparray[start];
	            temparray[start] = temparray[end];
	            temparray[end] = temp;
	            start++;
	            end--;
		}
		 for (char c : temparray) {
			 revStr += c;
		 }
		 return revStr;
	}
	
	/**
	 * Convert LowerCase character to Uppercase and Uppercase Character to lowerCase in the String.
	 *@param String on which operation has to be done
	 
	 * @return the operated String 
	 */
	public String stringCaseConverter(String str) {
		String finalStr = "";
		char[] mixChar = str.toCharArray();
		for(int i=0;i<mixChar.length;i++) {
			if(mixChar[i] >='A' && mixChar[i]<='Z') {   //uppercase to lowercase
				mixChar[i] = (char)((int)mixChar[i]+32);
			}
			else {
				mixChar[i] = (char)((int)mixChar[i]-32);    //lowercase to uppercase
			}
		}
		for(int i=0;i<mixChar.length;i++){
			finalStr += mixChar[i];
		}
		return finalStr;
	}
	
	/**
	 * Find the longest word in the Given String.
	 * @param the string in which longest word has to find.
	 
	 * @return the longest word in the String.
	 */
	public String longestWord(String wordString) {
	    String longest = "";
	    for (String word: wordString.split(" "))
	      if (word.length()>=longest.length())
	        longest = word;
	    return longest;
	  }
}


public class stringPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		strOperation str = new strOperation();
		
		System.out.println("1. Check Equal or Not: ");
		System.out.println("2. Reverse the String: ");
		System.out.println("3. Lower to upper and Vice-versa ");
		System.out.println("4. Longest word: ");
		
		
		System.out.println("Enter your choice: ");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:
			System.out.println("Enter String 1: ");
			String str1 = sc.next();
			System.out.println("Enter String 2: ");
			String str2 = sc.next();
			System.out.println(str.checkString(str1,str2));
			break;
			
			
			
		case 2:
			System.out.println("Enter String : ");
			String st = sc.next();
			System.out.println(str.reverseStr(st));
			
		case 3:
			System.out.println("Enter String : ");
			String str3 = sc.next();
			System.out.println(str.stringCaseConverter(str3));
			break;
			
		case 4:
			System.out.println("Enter String : ");
			sc.nextLine();            
			String str4 = sc.nextLine();
			System.out.println(str.longestWord(str4));
			break;
		}
	}

	
		// TODO Auto-generated method stub
		

}
