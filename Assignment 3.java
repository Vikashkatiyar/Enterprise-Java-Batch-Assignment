import java.util.*;
//Vikash Katiyar
public class StringOperationsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nInput for question 1 :: ");
		String s = sc.nextLine();
		System.out.println("\nQuestion 1 answer :: " + reverseString(s));
		
		System.out.print("\nInput for question 2 :: ");
		s = sc.nextLine();
		System.out.println("\nQuestion 2 answer :: " + reverseStringWordWise(s));
		
		System.out.print("\nInput for question 3 :: ");
		s = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println("\nQuestion 3 Anagram answer :: " + anagram(s,s2));
		
		System.out.print("\nInput for question 4 :: ");
		s = sc.nextLine();
		
		System.out.println("\nQuestion 4 Panagram answer :: " + panagram(s));
		
		System.out.print("\nInput for question 5 :: ");
		s = sc.nextLine();		
		System.out.println("\nQuestion 5 repeteting chareacter answer :: " + repetingChar(s));
		
		System.out.print("\nInput for question 6 :: ");
		s = sc.nextLine();		
		System.out.println("\nQuestion 6 Sorted String answer :: " + sortingString(s));
		
		System.out.print("\nInput for question 7 :: ");
		s = sc.nextLine();		
		System.out.println("\nQuestion 7 answer number of :: " + vowelsAndConsonants(s));
		
		System.out.print("\nInput for question 8 :: ");
		s = sc.nextLine();		
		System.out.println("\nQuestion 8 answer number of Special Charecter :: " + numOfSpecialCharecter(s));

	}

	public static String numOfSpecialCharecter(String s) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i=0;i<s.length();i++) {
			if(!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i)) && !Character.isWhitespace(s.charAt(i))) {
				count++;
			}
		}
		return Integer.toString(count);
	}

	public static String vowelsAndConsonants(String s) {
		// TODO Auto-generated method stub
		char[] val = s.toCharArray();
		int v = 0;
		int c = 0;
		for(char i:val) {
			if(i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u' ) {
				v++;
			}
			else {
				c++;
			}
		}
		
		String ans = "Vowels count : " + Integer.toString(v) + " and Consonants: " + Integer.toString(c); 
		
		return ans;
	}

	public static String sortingString(String s) {
		// TODO Auto-generated method stub
		
		char[] val = s.toCharArray();
		
		Arrays.sort(val);
		
		String ans = "";
		
		for(char i : val) {
			ans += i;
		}
		
		return ans;
	}

	public static String repetingChar(String s) {
		// TODO Auto-generated method stub
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		 
		 s = s.toLowerCase();
		 s = s.replaceAll("\\s", "");
		 		 
		 char [] val = s.toCharArray();
		 		 
		 for(int i=0;i<val.length;i++) {
			  if(map.containsKey(val[i])) {
				  map.put(val[i],map.get(val[i])+1);
			  }
			  else {
				  map.put(val[i], 1);
			  }
		 }
		 
		 int maxVal = 0;
		 for(int i:map.values()) {
			 if(i>maxVal) {
				 maxVal = i;
			 }
		 }
		 
		 String ans = "";
		 
		 for(char i:map.keySet()) {
			 if(map.get(i) == maxVal) {
				 ans += i;
			 }
		 }
		 
		 return ans;
	}

	public static String panagram(String s) {
		// TODO Auto-generated method stub

		if(s.length() <26)
			return "False";
		
		 
		 int[] check = new int[26];
		 
		 s = s.toLowerCase();
		 s = s.replaceAll("\\s", "");
		 		 
		 char [] val = s.toCharArray();
		 		 
		 for(int i=0;i<val.length;i++) {			 
			 check[(val[i] - 'a')] = 1;
		 }
		 
		 for(int i=0;i<check.length;i++) {
			 if(check[i] != 1) {
				 return "False";
			 }
		 }
		 
		
		return "True";
	}

	public static String anagram(String s, String s1) {
		// TODO Auto-generated method stub
		
		if(s.length() != s1.length()) {
			return "False";
		}
		
		char [] temp1 = s.toCharArray();
		char [] temp2 = s.toCharArray();
		
		Arrays.sort(temp1);
		Arrays.sort(temp2);
		
		for(int i=0;i<temp1.length;i++) {
			if(temp1[i] != temp2[i]) {
				return "False";
			}
		}
		
		return "True";
	}

	public static String reverseStringWordWise(String s) {
		// TODO Auto-generated method stub
		String[] temp = s.split(" ");
		String ans = "";
		for(int i=0;i<temp.length;i++) {
			ans = ans + reverseString(temp[i]) + " ";
		}
		
		return ans;
	}

	public static String reverseString(String s) {
		// TODO Auto-generated method stub
		String temp = "";
		for(int i=s.length()-1;i>=0;i--) {
			temp += s.charAt(i); 
		}
		return temp;
	}

}
