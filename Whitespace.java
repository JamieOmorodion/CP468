package whitespace;

import java.util.Arrays;
import java.util.Scanner;

public class Whitespace {

	public static String[] whiteSplit(String userWord) {
		String[] userDictionary = {"hey","hi","hello","yo","sup"};
		for(int i = 0; i < userWord.length()-1; i++) {
			String tempFirstHalf = userWord.substring(0,i+1);
			String tempSecondHalf = userWord.substring(i+1,userWord.length());
			String temp = tempFirstHalf + " " + tempSecondHalf;
			String[] parts = temp.split(" ");
			boolean contains = Arrays.stream(userDictionary).anyMatch(parts[0]::equals);
			contains = Arrays.stream(userDictionary).anyMatch(parts[1]::equals);
			System.out.println(contains);
			System.out.println(temp);
			if(contains == true) {
				return new String[] {parts[0],parts[1]};
			}
		}
		return new String[] {"not in there chief"};
	}
	
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		String userWord = userInput.nextLine();
		String[] result = whiteSplit(userWord);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		userInput.close();
	}
}
