package org.vivek.algos;

public class Range {
	
	public long upper, value;

	@Override
	public String toString() {
		return "Range [upper=" + upper + ", value=" + value + "]";
	}

	public long getUpper() {
		return upper;
	}

	public void setUpper(long upper) {
		this.upper = upper;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public Range() {
		// TODO Auto-generated constructor stub
	}

	public Range(long upper,long value) {
		this.upper = upper;
		this.value =value;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
