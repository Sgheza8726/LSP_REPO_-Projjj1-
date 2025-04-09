package org.howard.edu.assignment6; import static 
org.junit.jupiter.api.Assertions.*; import org.junit.jupiter.api.DisplayName; 
import org.junit.jupiter.api.Test; public class IntegerSetTest {
	@Test
	@DisplayName("Test add and toString")
	public void testAddToString() {
		IntegerSet set = new IntegerSet();
		set.add(10);
		set.add(20);
		set.add(10); // should not duplicate
		assertEquals("[10, 20]", set.toString());
	}
	@Test
	@DisplayName("Test clear and isEmpty")
	public void testClearIsEmpty() {
		IntegerSet set = new IntegerSet();
		set.add(1);
		set.clear();
		assertTrue(set.isEmpty());
	}
	@Test
	@DisplayName("Test length")
	public void testLength() {
		IntegerSet set = new IntegerSet();
		set.add(3);
		set.add(5);
		assertEquals(2, set.length());
	}
	@Test
	@DisplayName("Test equals")
	public void testEquals() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(5);
		set1.add(10);
		set2.add(10);
		set2.add(5);
		assertTrue(set1.equals(set2));
	}
	@Test
	@DisplayName("Test contains")
	public void testContains() {
		IntegerSet set = new IntegerSet();
		set.add(99);
		assertTrue(set.contains(99));
		assertFalse(set.contains(100));
	}
	@Test
	@DisplayName("Test largest and exception")
	public void testLargest() throws IntegerSetException {
		IntegerSet set = new IntegerSet();
		set.add(3);
		set.add(10);
		set.add(7);
		assertEquals(10, set.largest());
		IntegerSet empty = new IntegerSet();
		assertThrows(IntegerSetException.class, () -> 
empty.largest());
	}
	@Test
	@DisplayName("Test smallest and exception")
	public void testSmallest() throws IntegerSetException {
		IntegerSet set = new IntegerSet();
		set.add(3);
		set.add(10);
		set.add(1);
		assertEquals(1, set.smallest());
		IntegerSet empty = new IntegerSet();
		assertThrows(IntegerSetException.class, () -> 
empty.smallest());
	}
	@Test
	@DisplayName("Test remove")
	public void testRemove() {
		IntegerSet set = new IntegerSet();
		set.add(4);
		set.remove(4);
		assertFalse(set.contains(4));
	}
	@Test
	@DisplayName("Test union")
	public void testUnion() {
		IntegerSet s1 = new IntegerSet();
		IntegerSet s2 = new IntegerSet();
		s1.add(1);
		s1.add(2);
		s2.add(2);
		s2.add(3);
		s1.union(s2);
		assertTrue(s1.contains(1) && s1.contains(2) && 
s1.contains(3));
	}
	@Test
	@DisplayName("Test intersect")
	public void testIntersect() {
		IntegerSet s1 = new IntegerSet();
		IntegerSet s2 = new IntegerSet();
		s1.add(1);
		s1.add(2);
		s2.add(2);
		s2.add(3);
		s1.intersect(s2);
		assertEquals("[2]", s1.toString());
	}
	@Test
	@DisplayName("Test diff")
	public void testDiff() {
		IntegerSet s1 = new IntegerSet();
		IntegerSet s2 = new IntegerSet();
		s1.add(1);
		s1.add(2);
		s2.add(2);
		s1.diff(s2);
		assertEquals("[1]", s1.toString());
	}
	@Test
	@DisplayName("Test complement")
	public void testComplement() {
		IntegerSet s1 = new IntegerSet();
		IntegerSet s2 = new IntegerSet();
		s1.add(4);
		s1.add(5);
		s2.add(5);
		s2.add(6);
		s1.complement(s2);
		assertEquals("[4]", s1.toString());
	} }
