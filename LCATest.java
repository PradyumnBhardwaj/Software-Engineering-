import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LCATest {

	@Test
	public void testIsEmpty() 
 	{
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		boolean isEmpty = test.isEmpty();
		assertEquals(isEmpty, true);
		test.put(1, 2);
		test.put(2, 4);
		test.put(3, 6);
		test.put(4, 8);
		isEmpty = test.isEmpty();
		assertEquals(isEmpty, false);

 	}
	
	@Test
	public void testSize(){
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		assertEquals(test.size(), 0);
		test.put(4, 1);
		assertEquals(test.size(), 1);
		test.put(2, 4);
		test.put(3, 6);
		assertEquals(test.size(), 3);
		test.put(4, 8);
		assertEquals(test.size(), 3); //Size remains same as element already exists
	}
	
	@Test
	public void testOneNode()
	{
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		test.put(7, 1);
		assertNull(test.search(test.root, 7, 5)); //Test one node doesn't exist
		assertNull(test.search(test.root, 1, 5)); //Test both nodes don't exist
	}
	
	@Test
	public void testFullTree()
	{
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		test.put(8, 2);
		test.put(2, 1);
		test.put(5, 3);
		test.put(18, 4);
		test.put(7, 6);
		test.put(14, 5);
		test.put(3, 7);
		test.put(1, 8);
		test.put(15, 11);
		test.put(12, 10);
		test.put(16, 9);
		
		assertSame(test.search(test.root,18,1).key,8);
		assertSame(test.search(test.root,18,7).key,8);
		assertSame(test.search(test.root,12,16).key,14);
		
	}
	
	@Test 
	public void testNotInTree(){
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		test.put(8, 2);
		test.put(2, 1);
		test.put(5, 3);
		test.put(18, 4);
		test.put(7, 6);
		test.put(14, 5);
		
		assertNull(test.search(test.root, 18, 6));
		assertNull(test.search(test.root, 8, 3));
		assertNull(test.search(test.root, 4, 7));
		assertNull(test.search(test.root, 13, 9));
	}
	
	@Test
	public void testGet(){
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		assertNull(test.get(3));
		test.put(3, 1);
		assertSame(test.get(3), 1);
		test.put(4,2);
		test.put(5, 7);
		test.put(6, 3);
		assertSame(test.get(5), 7);
		assertNull(test.get(7));
	}
	
	@Test
	public void testSameValue()
	{
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		test.put(8, 2);
		test.put(2, 1);
		test.put(5, 3);
		test.put(18, 4);
		test.put(7, 6);
		test.put(14, 5);
		
		assertSame(test.search(test.root, 8,8).key, 8);
		assertSame(test.search(test.root, 7, 7).key, 7);
	}
	
	@Test
	public void testTwoNodes()
	{
		LCA<Integer, Integer> test = new LCA<Integer, Integer>();
		test.put(7, 1);
		test.put(8, 2);
		assertSame(test.search(test.root, 7, 8).key, 7);
		assertNull(test.search(test.root, 7, 1)); //Testing if one node doesn't exist
	}
}
