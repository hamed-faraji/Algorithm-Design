package TopologicOrder;

import java.util.ArrayList;

public class topologic {

	static ArrayList<ArrayList<Node>> ordersList = new ArrayList<ArrayList<Node>>();

	public static void main(String[] args) {

		ArrayList<Node> nodes = new ArrayList<Node>();

		Node v1 = new Node();
		v1.name = "v1";
		Node v2 = new Node();
		v2.name = "v2";
		Node v3 = new Node();
		v3.name = "v3";
		Node v4 = new Node();
		v4.name = "v4";
		Node v5 = new Node();
		v5.name = "v5";
		Node v6 = new Node();
		v6.name = "v6";
		Node v7 = new Node();
		v7.name = "v7";

		v1.outputEdge.add(v4);
		v1.outputEdge.add(v5);
		v1.outputEdge.add(v7);

		v2.outputEdge.add(v3);
		v2.outputEdge.add(v5);
		v2.outputEdge.add(v6);

		v3.inputEdge.add(v2);

		v3.outputEdge.add(v4);
		v3.outputEdge.add(v5);

		v4.inputEdge.add(v1);
		v4.inputEdge.add(v3);

		v4.outputEdge.add(v5);

		v5.inputEdge.add(v1);
		v5.inputEdge.add(v2);
		v5.inputEdge.add(v3);
		v5.inputEdge.add(v4);

		v5.outputEdge.add(v6);
		v5.outputEdge.add(v7);

		v6.inputEdge.add(v2);
		v6.inputEdge.add(v5);

		v6.outputEdge.add(v7);

		v7.inputEdge.add(v1);
		v7.inputEdge.add(v5);
		v7.inputEdge.add(v6);

		nodes.add(v1);
		nodes.add(v2);
		nodes.add(v3);
		nodes.add(v4);
		nodes.add(v5);
		nodes.add(v6);
		nodes.add(v7);
		
		ArrayList<Node> orderList = new ArrayList<Node>();
		ArrayList<Node> test = copyArr(nodes);
		
		getTopologic(nodes, copyArr(nodes), null, orderList);

		System.out.println(ordersList.size());

		for(int i =0 ; i < ordersList.get(0).size(); i++)
			System.out.print(ordersList.get(0).get(i).name + " ");
		
	}
	
	public static void getTopologic(ArrayList<Node> nodes, ArrayList<Node> copy, Node temp, ArrayList<Node> orderList){//temp = node ke bayad hazf shavad

		if(nodes.isEmpty()){
			orderList.add(temp);

			ordersList.add(orderList);

			return;
		}else{

			if(temp != null){
				orderList.add(temp);

				for(int k = 0; k < temp.outputEdge.size(); k++){

					temp.outputEdge.get(k).inputEdge.remove(temp);

				}

			}

			for(int j = 0; j < nodes.size(); j++){
				if(nodes.get(j).inputEdge.isEmpty()){

					Node tempp = nodes.get(j);

					nodes.remove(tempp);

					getTopologic(nodes, copyArr(nodes), tempp, copyArr(orderList));

					nodes = new ArrayList<Node>(copyArr(copy));
					
					//	nodes = new ArrayList<Node>(copy);
					//nodes.add(tempp);

				}

			}//for j

		}//else

	}//method
	
	public static ArrayList<Node> copyArr(ArrayList<Node> orginal){

		ArrayList<Node> copy = new ArrayList<Node>();

		for(int i = 0; i < orginal.size(); i++){

			copy.add(node(orginal.get(i)));
			
		}

		return copy;

	}
}