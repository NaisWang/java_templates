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
		} else {
			throw new RuntimeException("输入的数据类型不支持!!!");
		}
	}

	void read(Object o) {
		Class eClass = o.getClass();
		if (eClass == byte[].class) {
			byte[] b = (byte[]) o;
			for (int i1 = 0; i1 < b.length; i1++) {
				b[i1] = (Byte) getDataByScanner(Byte.class);
			}
		} else if (eClass == short[].class) {
			short[] b = (short[]) o;
			for (int i1 = 0; i1 < b.length; i1++) {
				b[i1] = (Short) getDataByScanner(Short.class);
			}
		} else if (eClass == int[].class) {
			int[] b = (int[]) o;
			for (int i1 = 0; i1 < b.length; i1++) {
				b[i1] = (Integer) getDataByScanner(Integer.class);
			}
		} else if (eClass == long[].class) {
			long[] b = (long[]) o;
			for (int i1 = 0; i1 < b.length; i1++) {
				b[i1] = (Long) getDataByScanner(Long.class);
			}
		} else if (eClass == char[].class) {
			long[] b = (long[]) o;
			for (int i1 = 0; i1 < b.length; i1++) {
				b[i1] = (Long) getDataByScanner(Long.class);
			}
		} else if (eClass == float[].class) {
			float[] b = (float[]) o;
			for (int i1 = 0; i1 < b.length; i1++) {
				b[i1] = (Float) getDataByScanner(Float.class);
			}
		} else if (eClass == double[].class) {
			double[] b = (double[]) o;
			for (int i1 = 0; i1 < b.length; i1++) {
				b[i1] = (Double) getDataByScanner(Double.class);
			}
		} else if (eClass == boolean[].class) {
			boolean[] b = (boolean[]) o;
			for (int i1 = 0; i1 < b.length; i1++) {
				b[i1] = (Boolean) getDataByScanner(Boolean.class);
			}
		}
	}

	void read(Object[] a) {
		for (int i = 0; i < a.length; i++) {
			Object o = a[i];
			if (o == null || !o.getClass().isArray()) {
				a[i] = getDataByScanner(a.getClass().getComponentType());
				continue;
			}
			Class eClass = o.getClass();
			if (Arrays.asList(byte[].class, short[].class, int[].class, long[].class, char[].class, float[].class, double.class, double.class).contains(eClass)) {
				read(o);
			} else {
				read((Object[]) o);
			}
		}
	}

	void println(Object[] a) {
		System.out.println(Arrays.deepToString(a));
	}

	void println(Object a) {
		Class eClass = a.getClass();
		if (eClass == byte[].class) {
			System.out.println(Arrays.toString((byte[]) a));
		} else if (eClass == short[].class) {
			System.out.println(Arrays.toString((short[]) a));
		} else if (eClass == int[].class) {
			System.out.println(Arrays.toString((int[]) a));
		} else if (eClass == long[].class) {
			System.out.println(Arrays.toString((long[]) a));
		} else if (eClass == char[].class) {
			System.out.println(Arrays.toString((char[]) a));
		} else if (eClass == float[].class) {
			System.out.println(Arrays.toString((float[]) a));
		} else if (eClass == double[].class) {
			System.out.println(Arrays.toString((double[]) a));
		} else if (eClass == boolean[].class) {
			System.out.println(Arrays.toString((boolean[]) a));
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
