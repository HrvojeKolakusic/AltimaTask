package task;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MainTest {
	
	List<Node> roots;

	@Before
	public void setUp() throws Exception {
		
		
		roots = new ArrayList<Node>();
		Node markoNode = new Node("Marko");
		Node robertNode = new Node("Robert");
		Node stjepanNode = new Node("Stjepan");
		stjepanNode.children.add(markoNode);
		stjepanNode.children.add(robertNode);
		
		Node adamNode = new Node("Adam");
		adamNode.children.add(stjepanNode);
		
		Node ivanNode = new Node("Ivan");
		ivanNode.children.add(adamNode);
		
		Node franNode = new Node("Fran");
		ivanNode.children.add(franNode);
		
		Node lukaNode = new Node("Luka");
		Node leopoldNode = new Node("Leopold");
		
		lukaNode.children.add(leopoldNode);
		
		roots.add(adamNode);
		roots.add(lukaNode);
		
	}

	@Test
	public void testFindNode() {
		
		assertTrue(Main.findNode(roots.get(0), "Stjepan").name.equals("Stjepan"));
	}

	@Test
	public void testCycle() {
		assertTrue(Main.cycle(roots.get(0), "Stjepan"));
	}


}
