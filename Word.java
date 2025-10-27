import java.util.List;
import java.util.ArrayList;

public class Word2{


	/**
	* @param solution current word
	* @param remaining remaining letters
	*/

	public static void combination(String solution, int k, String remaining){
		if(solution.length() == k){
			System.out.println(solution);
		}

		else if (remaining.length() == 0) {
			return;
		}

		else{
			char ch = remaining.charAt(0);
	
			remaining = remaining.substring(1);

			solution = solution + ch;

			permutation(solution, remaining, k);

			solution = solution.substring(0, solution.length() - 1);

			combination(solution, remaining, k);

		}
	}

	public static void main(String [] args){

		int k = 2;

		if(args.length != 1){
			System.out.println("Usage: java Word yourword");
			return;
		}
		
		String word = args[0];

		String word = new String(args[0]);

		String empty = new String("");

		combination(empty, word, k);

	

	}

}
