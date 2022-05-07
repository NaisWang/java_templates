package com.whz.recursive;

import java.util.*;

/**
 * @author : whz
 */
public class RecursiveShowUtils {

	/**
	 * 最近一次出栈的节点
	 */
	static RecursiveShowNode lastPopNode = null;

	/**
	 * 以列表的形式展示
	 */
	public final static Integer SHOW_AS_LIST = 1;
	/**
	 * 以树的形式展示
	 */
	public final static Integer SHOW_AS_TREE = 2;

	public static RecursiveShowNode rootNode = null;

	static Stack<RecursiveShowNode> recursiveShowNodeStack = new Stack<>();

	private RecursiveShowUtils() {
	}

	private static void init() {
		rootNode = null;
		recursiveShowNodeStack.removeAllElements();
	}


	/**
	 * 入栈操作
	 */
	public static DealEnterStack enterStack() {
		RecursiveShowNode newNode = new RecursiveShowNode();
		if (recursiveShowNodeStack.size() != 0) {
			recursiveShowNodeStack.peek().children.add(newNode);
		} else {
			rootNode = newNode;
		}
		recursiveShowNodeStack.push(newNode);
		return DealEnterStack.dealEnterStack;
	}

	/**
	 * 栈中操作
	 */
	public static DealInStack inStack() {
		RecursiveShowNode inNode = recursiveShowNodeStack.peek();
		return DealInStack.dealInStack;
	}

	/**
	 * 出栈操作
	 *
	 * @param returnValue 出栈时的返回值
	 */
	public static DealOutStack outStack(Object returnValue) {
		lastPopNode = recursiveShowNodeStack.pop();

		if (returnValue != null) {
			lastPopNode.returnValue = String.valueOf(returnValue);
		}
		return DealOutStack.dealOutStack;
	}

	/**
	 * 处理dp剪枝情况
	 *
	 * @param index 表示dp状态的下标
	 * @param value dp状态值
	 */
	public static void dpOperate(Object value, Integer... index) {
		RecursiveShowNode newNode = new RecursiveShowNode();
		RecursiveShowNode peek = recursiveShowNodeStack.peek();
		String key = "dp" + Arrays.asList(index).toString().replace(", ", "][");
		newNode.dpInfo.put(key, String.valueOf(value));
		peek.children.add(newNode);
	}

	/**
	 * 展示
	 */
	public static void print(Integer method) {
		if (method.equals(SHOW_AS_TREE)) {
			RecursiveShowForTreeNode.print();
		} else if (method.equals(SHOW_AS_LIST)) {
			RecursiveShowForSwingTree.print();
		} else {
			RecursiveShowForTreeNode.print();
			RecursiveShowForSwingTree.print();
		}
		init();
	}

}
