import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination{

	/**
	* copy an ArrayList
	* @param source source list
	* @return destination list
	*/

	public static ArrayList<String> copy(ArrayList<String> source){
		ArrayList<String> destination = new ArrayList<>();
		
		for(int i = 0; i < source.size(); i ++){
			destination.add(source.get(i));
		}
		return destination;
	}



	/**
	* method to print out k combination of a list
	* @param solution current solution
	* @param remaining remaining options
	* @param k choose k of
	*/
 
	public static void combination(ArrayList<String> solution, ArrayList<String> remaining, int k){
		if(solution.size() == k){
			for(int i = 0; i < k;i++){
				System.out.print(solution.get(i)+ " ");
			}	
			System.out.println();
		}

		else if (remaining.size()==0){
				return;
		}
		else{

			String name = remaining.remove(0);
		
			//setup new lists to pass to the rerucisve method
			ArrayList<String> newRemaining = copy(remaining);
			ArrayList<String> newSolution = copy(solution);

	
			combination(newSolution, newRemaining, k);	

			//setup new lists to pass to the recursive method
			newRemaining = copy(remaining);
			newSolution = copy(solution);
			//add name to solution
			newSolution.add(name);

			combination(newSolution, newRemaining, k);

		}
	}

	public static void main(String [] args){

		String[] names =  {"Roberts", "Thomas", "Alito", "Sotomayor", "Kagan", "Gorsuch", "Kavanaugh", "Barrett", "Jackson"};

		ArrayList<String> justices = new ArrayList<> (Arrays.asList(names));

		ArrayList<String> majority = new ArrayList<>();

		combination(majority, justices, 5); 

	}

}
