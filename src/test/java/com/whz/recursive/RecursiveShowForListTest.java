package com.whz.recursive;

/**
 * 对应的题目为[最短Hamilton路径](https://www.acwing.com/problem/content/93/)
 */
public class RecursiveShowForListTest {


	public static void main(String[] args) {

		int[][] g = new int[][]{
				{0, 2, 4, 5, 1, 1, 1},
				{2, 0, 6, 5, 3, 2, 2},
				{4, 6, 0, 8, 3, 3, 3},
				{5, 5, 8, 0, 5, 4, 4},
				{1, 3, 3, 5, 0, 5, 5},
				{1, 2, 3, 4, 5, 0, 5},
				{1, 2, 3, 4, 5, 5, 0}
		};

		SolutionForListTest solution = new SolutionForListTest(7, g);
		solution.dfs(0);

		RecursiveShowUtils.print(1);
	}
}

