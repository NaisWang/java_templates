package com.whz.recursive;

/**
 * 带有备忘录的dfs
 */
public class SolutionForTreeTest {

	private Integer n = null;
	private int[][] g = null;
	private Integer visited = 1 << 20;
	private Integer[][] dp = new Integer[visited << 1][20];

	public SolutionForTreeTest(Integer n, int[][] g) {
		this.n = n;
		this.g = g;
	}

	private boolean isVisited(int i) {
		return (visited & (1 << i)) != 0;
	}

	public int dfs(int now) {
		RecursiveShowUtils.enterStack().addEnterVariable("now", now);

		int temp = Integer.MAX_VALUE;
		for (int i = 1; i < n - 1; i++) {
			if (!isVisited(i)) {
				visited |= (1 << i);
				if (dp[visited][i] == null) {
					dp[visited][i] = dfs(i);
				} else {
					RecursiveShowUtils.dpOperate(dp[visited][i], visited, i);
				}
				RecursiveShowUtils.inStack().addInVariable(String.format("g[%s][%s]", now, i), g[now][i]);
				temp = Math.min(temp, dp[visited][i] + g[now][i]);
				visited ^= (1 << i);
			}
		}
		if (temp == Integer.MAX_VALUE) {
			temp = g[now][n - 1];
		}

		RecursiveShowUtils.outStack(temp).addOutVariable("dp[" + visited + "]" + "[" + now + "]", temp + "");
		return temp;
	}
}
