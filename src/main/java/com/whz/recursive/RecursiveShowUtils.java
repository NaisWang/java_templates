package com.whz.recursive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author : whz
 */
public class RecursiveShowUtils {

	public static RecursiveShowNode rootNode = null;

	private static Stack<RecursiveShowNode> recursiveShowNodeStack = new Stack<>();

	private static void init() {
		rootNode = null;
		recursiveShowNodeStack.removeAllElements();
	}

	/**
	 * 入栈操作
	 */
	public static Map<String, String> enterStack() {
		RecursiveShowNode newNode = new RecursiveShowNode();
		if (recursiveShowNodeStack.size() != 0) {
			recursiveShowNodeStack.peek().children.add(newNode);
		} else {
			rootNode = newNode;
		}
		recursiveShowNodeStack.push(newNode);
		return newNode.enterVariable;
	}

	/**
	 * 栈中操作
	 */
	public static Map<String, String> inStack() {
		RecursiveShowNode inNode = recursiveShowNodeStack.peek();
		return inNode.inVariable;
	}

	/**
	 * 出栈操作
	 *
	 * @param returnValue 出栈时的返回值
	 */
	public static Map<String, String> outStack(String returnValue) {
		RecursiveShowNode popNode = recursiveShowNodeStack.pop();
		if (returnValue != null) {
			popNode.returnValue = returnValue;
		}
		return popNode.outVariable;
	}

	/**
	 * 处理dp剪枝情况
	 */
	public static void dpOperate(String key, String value) {
		RecursiveShowNode newNode = new RecursiveShowNode();
		RecursiveShowNode peek = recursiveShowNodeStack.peek();
		newNode.dpInfo.put(key, value);
		peek.children.add(newNode);
	}

	/**
	 * 展示
	 */
	public static void print(Integer method) {
		if (method == 0) {
			RecursiveShowForTreeNode.print();
		} else if (method == 1) {
			RecursiveShowForSwingTree.print();
		} else {
			RecursiveShowForTreeNode.print();
			RecursiveShowForSwingTree.print();
		}
		init();
	}

}
