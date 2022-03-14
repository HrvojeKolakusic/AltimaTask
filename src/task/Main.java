package task;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {

		Path put = Paths.get(args[0]);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new BufferedInputStream(new FileInputStream(put.toString()))));

		String line;
		List<Node> roots = new ArrayList<Node>();

		while ((line = br.readLine()) != null) {

			String[] split = line.split(" ");
			Node parent = null;
			Node child = null;

			for (Node root : roots) {
				child = findNode(root, split[0]);
				if (child != null) break;
				
			}

			if (child == null) child = new Node(split[0]);
			
			for (Node root : roots) {
				parent = findNode(root, split[1]);
				if (parent != null) break;
			}
			
			if (parent == null) {
				parent = new Node(split[1]);
				roots.add(parent);
			}
			else if (cycle(child, split[1])) throw new CycleInTreeException("Can't add " + line + ", cycle found");
			
			parent.children.add(child);
			
			
			roots.remove(child);
		}
		
		for (Node root : roots) {
			print_tree(root, 0);
		}	

	}

	public static Node findNode(Node node, String name) {

		Node retNode = null;

		if (node.name.equals(name))
			return node;
		for (Node child : node.children) {
			retNode = findNode(child, name);
			if (retNode != null)
				break;
		}

		return retNode;
	}

	public static boolean cycle(Node node, String parent) {

		if (node.name.equals(parent)) return true;
		for (Node child : node.children) {
			boolean ret = cycle(child, parent);
			if (ret) return true;
		}

		return false;
	}
	
	public static void print_tree(Node root, int lvl) {
		
		for (int i = 0; i < lvl; ++i) System.out.print("    ");
		System.out.println(root.name);
		for (Node child : root.children) {
			print_tree(child, lvl+1);
		}
	}

}
