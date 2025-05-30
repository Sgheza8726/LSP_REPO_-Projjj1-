package org.howard.edu.lsp.assignment5; 
public class Driver {
	public static void main(String[] args) {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		System.out.println("Set1: " + set1);
		System.out.println("Smallest in Set1: " + set1.smallest());
		System.out.println("Largest in Set1: " + set1.largest());
		
		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		System.out.println("Set2: " + set2);
		
		set1.union(set2);
		System.out.println("Union of Set1 and Set2: " + set1);
		
		set1.intersect(set2);
		System.out.println("Intersection of Set1 and Set2: " + set1);
		
		set1.diff(set2);
		System.out.println("Difference of Set1 and Set2: " + set1);
		
		System.out.println("Set1 equals Set2? " + set1.equals(set2));
		System.out.println("Set1 contains 3? " + set1.contains(3));
		
		set1.clear();
		System.out.println("Set1 after clear: " + set1);
		System.out.println("Set1 is empty? " + set1.isEmpty());
	} 
}
