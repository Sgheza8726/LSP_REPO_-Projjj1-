package org.howard.edu.lsp.assignment5; import java.util.ArrayList; import 
java.util.Collections; import java.util.List; /**
 * IntegerSet class that represents a set of integers with various set 
operations.
 */ public class IntegerSet {
	private List<Integer> set = new ArrayList<Integer>();
	public IntegerSet() {}
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}
	public void clear() {
		set.clear();
	}
	public int length() {
		return set.size();
	}
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
	public boolean contains(int value) {
		return set.contains(value);
	}
	public int largest() {
		if (set.isEmpty()) throw new RuntimeException("Set is empty");
		return Collections.max(set);
	}
	public int smallest() {
		if (set.isEmpty()) throw new RuntimeException("Set is empty");
		return Collections.min(set);
	}
	public void add(int item) {
		if (!set.contains(item)) {
			set.add(item);
		}
	}
	public void remove(int item) {
		set.remove(Integer.valueOf(item));
	}
	public void union(IntegerSet intSetb) {
		for (int item : intSetb.set) {
			if (!this.set.contains(item)) {
				this.set.add(item);
			}
		}
	}
	public void intersect(IntegerSet intSetb) {
		set.retainAll(intSetb.set);
	}
	public void diff(IntegerSet intSetb) {
		set.removeAll(intSetb.set);
	}
	public void complement(IntegerSet intSetb) {
		this.diff(intSetb);
	}
	public boolean isEmpty() {
		return set.isEmpty();
	}
	@Override
	public String toString() {
		return set.toString();
	} }
