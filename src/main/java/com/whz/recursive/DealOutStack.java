package com.whz.recursive;

/**
 * @author : whz
 */
public class DealOutStack {

	private DealOutStack() {
	}

	public static DealOutStack dealOutStack = new DealOutStack();

	public DealOutStack add(Object key, Object value) {
		RecursiveShowUtils.lastPopNode.outVariable.put(String.valueOf(key), String.valueOf(value));
		return dealOutStack;
	}
}
