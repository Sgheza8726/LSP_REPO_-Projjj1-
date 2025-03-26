package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * IntegerSet class that represents a set of integers with various set operations.
 */
public class IntegerSet {
	private List<Integer> set = new ArrayList<Integer>();

	/**
	 * Default constructor
	 */
	public IntegerSet() {}

	/**
	 * Constructor that initializes the set with an existing list
	 * @param set ArrayList of integers
	 */
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}

	/**
	 * Clears the internal representation of the set
	 */
	public void clear() {
		set.clear();
	}

	/**
	 * Returns the length of the set
	 * @return int length
	 */
	public int length() {
		return set.size();
	}

	/**
	 * Returns true if 2 sets are equal, false otherwise
	 * @param o Object to compare
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof IntegerSet)) return false;
		IntegerSet other = (IntegerSet) o;
		List<Integer> copy1 = new ArrayList<>(set);
		List<Integer> copy2 = new ArrayList<>(other.set);
		Collections.sort(copy1);
		Collections.sort(copy2);
		return copy1.equals(copy2);
	}

	/**
	 * Checks if the set contains a specific value
	 * @param value integer to check
	 * @return boolean
	 */
	public boolean contains(int value) {
		return set.contains(value);
	}

	/**
	 * Returns the largest element in the set
	 * @return int
	 */
	public int largest() {
		if (set.isEmpty()) throw new RuntimeException("Set is empty");
		return Collections.max(set);
	}

	/**
	 * Returns the smallest element in the set
	 * @return int
	 */
	public int smallest() {
		if (set.isEmpty()) throw new RuntimeException("Set is empty");
		return Collections.min(set);
	}

	/**
	 * Adds an item to the set if not already present
	 * @param item int
	 */
	public void add(int item) {
		if (!set.contains(item)) {
			set.add(item);
		}
	}

	/**
	 * Removes an item from the set if present
	 * @param item int
	 */
	public void remove(int item) {
		set.remove(Integer.valueOf(item));
	}

	/**
	 * Performs union with another IntegerSet
	 * @param intSetb IntegerSet
	 */
	public void union(IntegerSet intSetb) {
		for (int item : intSetb.set) {
			if (!this.set.contains(item)) {
				this.set.add(item);
			}
		}
	}

	/**
	 * Performs intersection with another IntegerSet
	 * @param intSetb IntegerSet
	 */
	public void intersect(IntegerSet intSetb) {
		set.retainAll(intSetb.set);
	}

	/**
	 * Performs set difference
	 * @param intSetb IntegerSet
	 */
	public void diff(IntegerSet intSetb) {
		set.removeAll(intSetb.set);
	}

	/**
	 * Performs set complement (same as diff)
	 * @param intSetb IntegerSet
	 */
	public void complement(IntegerSet intSetb) {
		this.diff(intSetb);
	}

	/**
	 * Checks if the set is empty
	 * @return boolean
	 */
	public boolean isEmpty() {
		return set.isEmpty();
	}

	/**
	 * Returns string representation of the set
	 * @return String
	 */
	@Override
	public String toString() {
		return set.toString();
	}
} 
