package TopologicOrder;

import java.util.ArrayList;

public class Node {



	ArrayList<Node> inputEdge = new ArrayList<Node>();
	ArrayList<Node> outputEdge = new ArrayList<Node>();

	boolean chosen = false;
	String name = "";
}
