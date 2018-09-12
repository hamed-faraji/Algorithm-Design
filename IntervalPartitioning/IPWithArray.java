package intervalPartitioning;

import java.util.ArrayList;

public class IPWithArray {
	
	static ArrayList<ArrayList<Intervals>> Schedule(ArrayList<Intervals> SortedIntervals) {
		ArrayList<ArrayList<Intervals>> ClassRooms = new ArrayList<>();

		int n = SortedIntervals.size();
		int eachOverlab = 0;
		int finish = SortedIntervals.get(0).end;
		for (int i = 0; i < n; i++) {
			if (ClassRooms.size() == 0) {
				ArrayList<Intervals> a = new ArrayList<>();
				a.add(SortedIntervals.get(i));
				ClassRooms.add(a);
				SortedIntervals.get(i).lable = eachOverlab;
			} else {

				for (int j = 0; j < ClassRooms.size(); j++) {
					if (finish > ClassRooms.get(j).get((ClassRooms.get(j).size()) - 1).end) {
						finish = ClassRooms.get(j).get((ClassRooms.get(j).size()) - 1).end;
						eachOverlab = j;
					}
				}
				if (SortedIntervals.get(i).start < finish) {
					ArrayList<Intervals> a = new ArrayList<>();
					a.add(SortedIntervals.get(i));
					ClassRooms.add(a);
					SortedIntervals.get(i).lable = ClassRooms.size() - 1;
				} else {
					ClassRooms.get(eachOverlab).add(SortedIntervals.get(i));
				}
				finish = SortedIntervals.get(i).end;
				SortedIntervals.get(i).lable = eachOverlab;
			}
		}

		return ClassRooms;
	}

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
