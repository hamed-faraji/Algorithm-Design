package intervalPartitioning;

import java.util.ArrayList;

public class Sort {

	static void Sort(final ArrayList<Intervals> SortedIntervals) {
		int n = SortedIntervals.size();
		if (n < 2)
			return;
		int mid = n / 2;
		ArrayList<Intervals> left = new ArrayList<>();
		ArrayList<Intervals> right = new ArrayList<>();
		for (int i = 0; i < mid; i++)
			left.add(SortedIntervals.get(i));
		for (int i = mid; i < n; i++)
			right.add(SortedIntervals.get(i));
		Sort(left);
		Sort(right);
		merge(SortedIntervals, left, right);
	}
	
	public static void merge(ArrayList<Intervals> SortedIntervals, ArrayList<Intervals> left,
			ArrayList<Intervals> right) {
		int nL = left.size();
		int nR = right.size();
		int i = 0, j = 0, k = 0;
		while (i < nL && j < nR) {
			if (left.get(i).start <= right.get(j).start) {
				SortedIntervals.remove(k);
				SortedIntervals.add(k, left.get(i));
				i++;
			} else {
				SortedIntervals.remove(k);
				SortedIntervals.add(k, right.get(j));
				j++;
			}
			k++;
		}
		while (i < nL) {
			SortedIntervals.remove(k);
			SortedIntervals.add(k, left.get(i));
			i++;
			k++;
		}
		while (j < nR) {
			SortedIntervals.remove(k);
			SortedIntervals.add(k, right.get(j));
			j++;
			k++;
		}
	}
	

	
}
