package com.whz.recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author : whz
 */
class RecursiveShowNode {

	/**
	 * 孩子节点
	 */
	public ArrayList<RecursiveShowNode> children = new ArrayList<>();
	/**
	 * 入栈时变量值
	 */
	public Map<String, String> enterVariable = new HashMap<>();
	/**
	 * 出栈时变量值
	 */
	public Map<String, String> outVariable = new HashMap<>();
	/**
	 * 栈中时变量值
	 */
	public Map<String, String> inVariable = new HashMap<>();
	/**
	 * 使用到备忘录从而剪掉到枝
	 */
	public Map<String, String> dpInfo = new HashMap<>();
	/**
	 * 返回值
	 */
	public String returnValue = "";

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (!enterVariable.isEmpty()) {
			sb.append("入=" + enterVariable + "；\n");
		}
		if (!inVariable.isEmpty()) {
			sb.append("中=" + inVariable + "；\n");
		}
		if (!outVariable.isEmpty()) {
			sb.append("出=" + outVariable + "；\n");
		}
		if (!returnValue.isBlank()) {
			sb.append("返=" + returnValue + "；\n");
		}
		if (dpInfo.size() != 0) {
			sb.append("DP=" + dpInfo + "；\n");
			sb.append("-isDp");
		}
		return sb.toString();
	}

	public String toTreeString() {
		return toString().replace(",", ",\n");
	}

	public int getOutputLineNumber() {
		int res = 0;
		res += enterVariable.size();
		res += outVariable.size();
		res += inVariable.size();
		if (!returnValue.isBlank()) {
			res += 1;
		}
		return res;
	}
}
