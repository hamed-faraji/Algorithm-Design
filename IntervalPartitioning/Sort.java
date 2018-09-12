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
	

	
}
