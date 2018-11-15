import java.util.ArrayList;
import java.util.Scanner;

public class kSubsets {
	
	private static Scanner scanner2;
	static  int TempValue = 0;
	final ArrayList<Integer> n = new ArrayList<>();
	
	public static void AddToTemp(int[] S){
		TempValue=0;
		for(int i = 0; i< S.length ; i++)
			TempValue += S[i];
	}

	public static void processKsubsets(int[] finalSet, int[] subset, int subsetSize, int secondValue, int tem ) {
		if (subsetSize == subset.length)
			System.out.println(tem);
		else
			for (int j = secondValue; j < finalSet.length; j++) {
				subset[subsetSize] = finalSet[j];
				tem += finalSet[j];
				processKsubsets(finalSet, subset, subsetSize + 1, j + 1,tem);
				tem -= finalSet[j];
			}
	}

	public static void main(String[] args) throws Exception {
		scanner2 = new Scanner(System.in);
		String n = scanner2.nextLine();/// first line of input is the correct answer
		int[] finalSet = new int[Integer.parseInt(n) + 1];
		for (int i = 0; i <= Integer.parseInt(n); i++)/// make set in format:{1 ,2 ,...,n}
			finalSet[i] = i;
		int[] subset;
		for(int i=0 ; i< finalSet.length ; i++){
			subset = new int[i+1];
			processKsubsets(finalSet, subset, 0, 0, 0);
		}
	}
}