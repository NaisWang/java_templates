package com.whz.recursive;

/**
 * @author : whz
 */
public class DealInStack {

	private DealInStack() {
	}

	public static DealInStack dealInStack = new DealInStack();

	public DealInStack add(Object key, Object value) {
		RecursiveShowUtils.recursiveShowNodeStack.peek().inVariable.put(String.valueOf(key), String.valueOf(value));
		return dealInStack;
	}
}
