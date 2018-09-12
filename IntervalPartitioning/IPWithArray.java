package intervalPartitioning;

import java.util.ArrayList;

public class IPWithArray {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		ArrayList<Intervals> SortedIntervals = new ArrayList<>();
		int starts[] = { 830,500,320,450,216,1430,520, 320 , 1120 ,900, 940, 950 };
		int finishes[] = { 900,600,350,535,530,1600,525 , 1200, 1500 ,1200, 1200, 1220 };

		for (int i = 0; i < starts.length; i++) {
			Intervals a = new Intervals(starts[i], finishes[i], 0);
			SortedIntervals.add(a);
		}
		Sort.Sort(SortedIntervals);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}

}
