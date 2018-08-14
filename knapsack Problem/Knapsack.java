
import java.util.ArrayList;
import java.util.Scanner;

public class Knapsack {
	static ArrayList<Objects> Answer = new ArrayList<>();
	static int MaxValue = 0;
	static int MaxWeight = 0;
	static int[][] DyTable;
	private static Scanner scanner2;
	
	public static void BruteForce(Objects[] AllObjects, int W) {
		Objects[] subset;
		for (int i = 0; i < AllObjects.length; i++) {
			subset = new Objects[i + 1];
			FindAllSubSets(AllObjects, subset, 0, 0, 0, 0, W);
		}
	}
	
	public static void AddToTemp(Objects[] S, int value, int weight) {
		if (MaxValue < value) {
			MaxValue = value;
			MaxWeight = weight;
			if (Answer.size() > 0)
				Answer.clear();
			for (int i = 0; i < S.length; i++)
				Answer.add(S[i]);
		} else if (MaxValue == value) {
			if (MaxWeight < weight) {
				if (Answer.size() > 0)
					Answer.clear();
				for (int i = 0; i < S.length; i++)
					Answer.add(S[i]);
			}
		}
	}
	
	public static void FindAllSubSets(Objects[] finalSet, Objects[] subset, int subsetSize, int secondValue, int wei,
			int val, int W) {
		if (subsetSize == subset.length) {
			if (wei <= W)
				AddToTemp(subset, val, wei);
		} else
			for (int j = secondValue; j < finalSet.length; j++) {
				subset[subsetSize] = finalSet[j];
				wei += finalSet[j].Weight;
				val += finalSet[j].Value;
				FindAllSubSets(finalSet, subset, subsetSize + 1, j + 1, wei, val, W);
				wei -= finalSet[j].Weight;
				val -= finalSet[j].Value;
			}
	}
	
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
			for (int i = 0; i < Weights.length; i++) {
				int x = (int) (Float.parseFloat(ConvertedWeights[i]) * Math.pow(10, tempLength));
				Objects Temp = new Objects(x, Integer.parseInt(Values[i]), i);
				AllObjects[i] = Temp;
			}
			String finalW = W;
			if (W.contains("/"))
				finalW = W.split("/")[0] + "." + W.split("/")[1];
			int x = (int) (Float.parseFloat(finalW) * Math.pow(10, tempLength));
			
			BruteForce(AllObjects, x)
			//DynamicProgramming(AllObjects, x);
			
			System.out.print("Final objects are(Based on input sequence): ");
			for (int j = 0; j < Answer.size(); j++)
				System.out.print(Answer.get(j).ObjectNumber + 1 + " ");
	
	} else {
		for (int i = 0; i < Weights.length; i++) {
				Objects Temp = new Objects(Integer.parseInt(Weights[i]), Integer.parseInt(Values[i]), i);
				AllObjects[i] = Temp;
			}
			BruteForce(AllObjects, Integer.parseInt(W));
			// DynamicProgramming(AllObjects, Integer.parseInt(W));

			System.out.print("Final objects are(Based on input sequence): ");
			for (int j = 0; j < Answer.size(); j++)
				System.out.print(Answer.get(j).ObjectNumber + 1 + " and ");
	
	
	}
}
