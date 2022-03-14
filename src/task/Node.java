package task;

import java.util.ArrayList;
import java.util.List;

public class Node {

	String name;
	List<Node> children;
	
	public Node(String name) {
		this.name = name;
		children = new ArrayList<Node>();
	}
}
