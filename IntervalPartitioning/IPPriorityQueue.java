package intervalPartitioning;

import java.util.*;

public class IPPriorityQueue {

	static ArrayList<ArrayList<Intervals>> Schedule(ArrayList<Intervals> SortedIntervals) {
	final ArrayList<ArrayList<Intervals>> ClassRooms = new ArrayList<>();
		class PriorityComparator implements Comparator<Intervals> {
			public int compare(Intervals first, Intervals second) {
				return first.end - second.end;
			}
		}
		PriorityComparator comp = new PriorityComparator();
		PriorityQueue<Intervals> pq = new PriorityQueue<Intervals>(SortedIntervals.size() - 1, comp);

		int n = SortedIntervals.size();

		int ClassRoomNum = 0;
		for (int i = 0; i < n; i++) {
			if (ClassRooms.size() == 0) {
				ArrayList<Intervals> a = new ArrayList<>();
				a.add(SortedIntervals.get(i));
				ClassRooms.add(a);
				SortedIntervals.get(i).lable = ClassRoomNum;
				pq.offer(SortedIntervals.get(i));
				ClassRoomNum++;
			} else {
				if (SortedIntervals.get(i).start < pq.peek().end) {
					ArrayList<Intervals> a = new ArrayList<>();
					a.add(SortedIntervals.get(i));
					ClassRooms.add(a);
					SortedIntervals.get(i).lable = ClassRoomNum;
					pq.offer(SortedIntervals.get(i));
					ClassRoomNum++;
				} else {
					int temp = pq.poll().lable;
					ClassRooms.get(temp).add(SortedIntervals.get(i));
					SortedIntervals.get(i).lable = temp;
					pq.offer(SortedIntervals.get(i));
				}
			}
		}

		return ClassRooms;
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
	}

}
