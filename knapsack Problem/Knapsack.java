
import java.util.ArrayList;
import java.util.Scanner;

public class Knapsack {
	
	public static void main(String[] args) {
		String n, k, W, Q;
		scanner2 = new Scanner(System.in);
		n = scanner2.nextLine();/// first line of input is the correct answer
		k = scanner2.nextLine();/// second line of input is data as described
		W = scanner2.nextLine();
		String[] Weights = n.split(" ");
		String[] Values = k.split(" ");
		Objects[] AllObjects = new Objects[Weights.length];
		System.out.println("Have your inputs any Float number?(yes/no)");
		Q = scanner2.nextLine();
		int tempLength = 0;
		if (Q.equals("yes")) {
			String[] ConvertedWeights = new String[Weights.length];
			for (int i = 0; i < AllObjects.length; i++) {
				if (Weights[i].contains("/")) {
					if (tempLength < Weights[i].split("/")[1].length()) {
						tempLength = Weights[i].split("/")[1].length();
						ConvertedWeights[i] = Weights[i].split("/")[0] + "." + Weights[i].split("/")[1];
					} else
						ConvertedWeights[i] = Weights[i].split("/")[0] + "." + Weights[i].split("/")[1];
				} else {
					ConvertedWeights[i] = Weights[i];
				}
			}
	
	} else {
	
	
	}
}
