package StableMaching;

import java.util.ArrayList;

public class AllStableMatchingAnswers {

	public static <T> void main(String[] args) {

		int x = 10; // number of men or women

		MenAndWomen[] men = new MenAndWomen[x];
		MenAndWomen[] women = new MenAndWomen[x];
		int[] matching = new int[] {3,4,0,1,5,9,8,2,6,7};
		boolean stable = true;
		int f = 0;
		ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();

		for(int i = 0; i < x; i++){
			men[i] = new MenAndWomen();
			women[i] = new MenAndWomen();
		}

		men[0].list = new int[]  {0 ,3, 8, 7, 6, 4, 5, 1, 9, 2 };
	    men[1].list = new int[]  {6 ,1, 3, 5, 9, 4, 7, 0, 8, 2 };
	    men[2].list = new int[]  {8 ,0, 7, 4, 1, 3, 2, 9, 5, 6 };
	    men[3].list = new int[]  {7 ,9 ,0, 5, 2, 1, 4, 3, 6, 8 };
	    men[4].list = new int[]  {4 ,5, 1, 0, 6, 3, 2, 7, 9, 8 };
	    men[5].list = new int[]  {6 ,5, 9 ,0, 3, 8, 2, 7, 1, 4 };
	    men[6].list = new int[]  {6 ,3, 0, 4, 8, 9, 5, 2, 7, 1 };
	    men[7].list = new int[]  {9 ,5, 2, 3 ,6, 0, 7, 8, 4, 1 };
	    men[8].list = new int[]  {4 ,0, 2, 9, 1, 7, 5, 3, 8, 6 };
	    men[9].list = new int[]  {6 ,0, 5, 2, 4, 7, 9, 3, 1, 8 };

	    women[0].list = new int[]  {2 ,3 ,5, 8, 4, 1, 0, 7, 6, 9 };
	    women[1].list = new int[]  {3 ,5 ,0, 8, 9, 1 ,7, 2, 6, 4 };
	    women[2].list = new int[]  {7 ,2 ,5, 9, 1, 4, 0, 6, 8, 3 };
	    women[3].list = new int[]  {0 ,8, 3, 5, 7, 6, 9, 1, 4, 2 };
	    women[4].list = new int[]  {2 ,1, 7, 4, 6, 5, 9 ,3, 8, 0 };
	    women[5].list = new int[]  {4 ,8, 2, 3, 7, 6, 1, 9 ,5, 0 };
	    women[6].list = new int[]  {4 ,1 ,6 ,2, 5, 7, 8, 0, 9, 3 };
	    women[7].list = new int[]  {7 ,4, 1, 6, 9, 2, 0, 8, 3, 5 };
	    women[8].list = new int[]  {1 ,7, 5, 4, 9, 2, 3, 0, 6, 8 };
	    women[9].list = new int[]  {5 ,4, 8, 3, 9, 7, 1, 0, 6, 2 };

		while(f < 20){

			for(int i = 0; i < x; i++){ // loop roye arayeye matching

				int[] womanList = women[matching[i]].list;
				int womanPartner = i;
				int womanPartnerIndex = search(womanPartner, womanList);

				for(int j = 0; j < womanPartnerIndex; j++){ // loop roye list olaviate zan

					int man = womanList[j];

					if(search(matching[i], men[man].list) < search(matching[man], men[man].list)){
						stable = false;
						break;}

				}//end for j

				if(!stable)
					break;

			}if(stable){
				f++;
				ArrayList<Integer> temp = new ArrayList<>();
				for(int k=0 ; k < matching.length ;k++)
					temp.add(matching[k]);
				if(!set.contains(temp))
				set.add(temp);
			}
			
			matching = swap(matching);
			stable = true;
		}
		
		for(int j =0 ; j < set.size();j++)
		for(int i= 0; i < x; i++)
			if(i == x-1)
				System.out.println("Man"+ i + " is matched with woman" + set.get(j).get(i) +"\n");
			else
			System.out.println("Man"+i + " is matched with woman" + set.get(j).get(i));
		
	}
			public static int[] swap(int[] matching){

		int x = (int )(Math.random() * matching.length);
		int temp;

		if(x == matching.length - 1){

			temp = matching[x];
			matching[x] = matching[0];
			matching[0] = temp;

		} else {

			temp = matching[x];
			matching[x] = matching[x + 1];
			matching[x + 1] = temp;

		}

		return matching;

	}//end swap

	public static int search(int find, int[] list){

		for(int i = 0; i < list.length; i++){

			if(list[i] == find)
				return i;
		}
		return -1;

	}//end search

}