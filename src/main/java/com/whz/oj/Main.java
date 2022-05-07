package com.whz.oj;

import java.util.Arrays;
import java.util.Scanner;

class BaseUtil {

	final Scanner scan = new Scanner(System.in);

	private Object getDataByScanner(Class a) {
		if (a.equals(Integer.class)) {
			return scan.nextInt();
		} else if (a.equals(Double.class)) {
			return scan.nextDouble();
		} else if (a.equals(Float.class)) {
			return scan.nextFloat();
		} else if (a.equals(Long.class)) {
			return scan.nextLong();
		} else if (a.equals(Short.class)) {
			return scan.nextShort();
		} else if (a.equals(Byte.class)) {
			return scan.nextByte();
		} else if (a.equals(String.class)) {
			return scan.nextLine();
		}
		return null;
	}

	<T> void read(T[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = (T) getDataByScanner(a.getClass().getComponentType());
		}
	}

	<T> void read(T[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (T) getDataByScanner(a[i].getClass().getComponentType());
			}
		}
	}

	<T> void read(T[][][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				for (int k = 0; k < a[i][j].length; k++) {
					a[i][j][k] = (T) getDataByScanner(a[i][j].getClass().getComponentType());
				}
			}
		}
	}

	<T> void println(T[] a) {
		System.out.println(Arrays.toString(a));
	}

	<T> void println(T[][] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}

	<T> void println(T[][][] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println("#" + i + ":");
			for (int j = 0; j < a[i].length; j++) {
				System.out.println(Arrays.toString(a[i][j]));
			}
		}
	}
}

class Solution extends BaseUtil {
	public void solve() {

	}
}

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}
}
