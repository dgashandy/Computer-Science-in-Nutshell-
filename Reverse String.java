package prakjava4;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
	public static String reverse(String str){
			char[] charArr = str.toCharArray();
			int size = charArr.length;
			Stack<Character> stack = new Stack<Character>();
				for(int i=0; i<size; i++){
					stack.push(charArr[i]);
				}
				for(int i=0 ; i<size ;i++){
					charArr[i] = stack.pop();
				}
				return new String (charArr);
		}

	public static void main(String[] args) {
		String name;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter name :");
		name = in.nextLine();
		System.out.println("Reverse of the name :" + reverse(name));

	}

}
