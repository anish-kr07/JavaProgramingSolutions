/*
Even Length Palindromic Number
You have to design a new model which maps an even length palindromic number to some digit between 0 to 9.
The number is mapped to a digit  on the basis of following criteria:
1.  should appear maximum number of times in the palindromic number, that is, among all digits in the number,  should appear maximum number of times.
2. If more than one digit appears maximum number of times,  should be the smallest digit among them.

Given an integer , you have to find the digit  for the  even length palindromic number.

Note- First 9 even length palindromic numbers are:

            11, 22, 33, 44, 55, 66, 77, 88, 99

Input :

    First line contains T, number of test cases.

    Each of the next T lines contains an integer N.

Output:

    For each test case, print the digit to which the  even length palindromic number is mapped.
    Answer for each test case should come in a new line.

Constraints:

1<=T<=10pow(5)
1<=N<=10pow(18)

Sample Input
3
1
2
10
Sample Output
1
2
0

Explanation
For case 1:

    1st even length palidromic number is 11 , so answer is 1 as 1 appears most number of times in the number.

For case 2:

    2nd even length palidromic number is 22 , so answer is 2 as 2 appears most number of times in the number.

For case 3:

    10th even length palindromic number is 1001, here both 0 and 1 appears same number of times but 0<1 so answer is 0.
*/

import java.util.Scanner;
import java.util.Arrays;
class NthEvenDigitPallindormeWithAscendingCount {
    public static void main(String args[] ) throws Exception {
  
        Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
        for(int i=1; i<= tests ; i++){
			int n = sc.nextInt();
		//	String pallindromeNumber = evenLengthPallindrome(n);
			char result= largestAscendingOrderDigit(n);
			/*Arrays.sort(result);
			for(int i1 =0;i1<result.length;i1++){
				System.out.println(result[i1]);    // Writing output to STDOUT
			}
			*/
			System.out.println(result-97);
			}
	}

	public static String evenLengthPallindrome(String n){
		String res = n;
        for (int j = n.length() - 1; j >= 0; --j){
            res += n.charAt(j);
		}
        return res;
	}
	public static char largestAscendingOrderDigit(int n){
		String str [] = {"0a","0b","0c","0d","0e","0f","0g","0h","0i","0j"}; 
		int max = 0;
		while(n>0){
			int line=n%10;
			String temp = str[line];
			char ch = (temp.charAt(0));
			char ch1 = temp.charAt(1);
			int count = (int)ch++;
			if(max<(count-47))
				max = count-47;
			str[line] = Integer.toString(count-47)+ch1;
			n=n/10;
		}
		Arrays.sort(str);
		for(int i1 =0;i1<str.length;i1++){
				System.out.println(str[i1]);    // Writing output to STDOUT
			}
		int index=0;
		for(int i =str.length-1;i>=0;i--){
			char ch = str[i].charAt(0);
			if(((int)ch)-48==max)
				continue;
			else
				{ 
					index = i+1;
				System.out.println("index " + index);
					break;
				}
		}
		return str[index].charAt(1);
	}
	
}