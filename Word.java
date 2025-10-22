public class Word{


	/**
	* @param solution current word
	* @param remaining remaining letters
	*/

	public static void permutation(String solution, String remaining){
		if(remaining.length() == 0){
			System.out.println(solution);
		}

		else{
			for(int i =0 ;i < remaining.length(); i++){

				char ch = remaining.charAt(i);
	
				//create new strings to pass to the recursive method			
				String  nextRemaining = remaining.substring(0, i) + remaining.substring(i+1);
				String nextSolution = solution + ch;
				
				permutation(nextSolution, nextRemaining);

			}
		}
	}

	public static void main(String [] args){

		if(args.length != 1){
			System.out.println("Usage: java Word yourword");
			return;
		}
		
		String word = new String(args[0]);

		String empty = new String("");

		permutation(empty, word);

	}

}
