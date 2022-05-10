package com.whz.recursive;

/**
 * @author : whz
 */
public class DealEnterStack {

	private DealEnterStack() {
	}

	public static DealEnterStack dealEnterStack = new DealEnterStack();

	public DealEnterStack add(Object key, Object value) {
		RecursiveShowUtils.recursiveShowNodeStack.peek().enterVariable.put(String.valueOf(key), String.valueOf(value));
		return dealEnterStack;
	}
}
