package intervalPartitioning;

import java.util.*;

public class IPPriorityQueue {

	static ArrayList<ArrayList<Intervals>> Schedule(ArrayList<Intervals> SortedIntervals) {
	
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		ArrayList<Intervals> SortedIntervals = new ArrayList<>();
		int starts[] = { 1,2,5,4 };
		int finishes[] = {2,6,6,10};

		for (int i = 0; i < starts.length; i++) {
			Intervals a = new Intervals(starts[i], finishes[i], 0);
			SortedIntervals.add(a);
		}
		Sort.Sort(SortedIntervals);
		System.out.println(Schedule(SortedIntervals));
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
//		System.out.println(ClassRo);
		// System.out.println();
	}

}
