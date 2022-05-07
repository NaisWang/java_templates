package com.whz.recursive;

import javax.swing.*;
import java.awt.*;

/**
 * @author : whz
 */
class RecursiveShowForTreeNode extends JPanel {
	public TreeCanvas drawingPanel;

	public RecursiveShowForTreeNode(RecursiveShowNode root) {
		super(new BorderLayout());

		drawingPanel = new TreeCanvas(root);
		drawingPanel.setBackground(Color.white);

		JScrollPane scroller = new JScrollPane(drawingPanel);
		scroller.setPreferredSize(new Dimension(200, 200));

		add(scroller, BorderLayout.CENTER);
	}

	class TreeCanvas extends JPanel {

		private RecursiveShowNode root;
		public int y0ff;
		public int x0ff;
		public int rows;
		public int cols;
		private int maxHeight;
		private int maxWeight;
		private int outputMaxLineNumber;

		public TreeCanvas(RecursiveShowNode root) {
			this.root = root;
			init();
		}

		public void init() {
			outputMaxLineNumber = root.getOutputLineNumber();
			rows = depthChild(root);
			cols = leafNumber(root) + 3;
			maxWeight = cols * 200;
			maxHeight = rows * (100 + outputMaxLineNumber * 20);
		}

		/**
		 * 计算深度
		 */
		int depthChild(RecursiveShowNode node) {
			if (node.children.size() == 0) {
				return 1;
			}
			Integer temp = Integer.MIN_VALUE;
			for (RecursiveShowNode child : node.children) {
				temp = Math.max(depthChild(child), temp);
			}
			return 1 + temp;
		}

		/**
		 * 计算叶子节点的个数
		 */
		int leafNumber(RecursiveShowNode node) {
			if (node.children.size() == 0) {
				return 1;
			}
			int temp = 0;
			for (RecursiveShowNode child : node.children) {
				temp += leafNumber(child);
			}
			return temp;
		}

		@Override
		protected void paintComponent(Graphics g) {
			//super.paintComponent(g);
			Dimension dim = getSize();
			x0ff = dim.width / cols;
			y0ff = 10;
			printTree(root, new int[]{x0ff, y0ff}, g);
			drawingPanel.setPreferredSize(new Dimension(maxWeight, maxHeight));
			drawingPanel.revalidate();
		}

		/**
		 * 绘制节点
		 */
		public void printNode(String nodeText, int[] parentPt, Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(3.0f));
			if (nodeText.endsWith("-isDp")) {
				nodeText = nodeText.replace("-isDp", "");
				g2d.setColor(Color.green);
			}
			drawString(g, nodeText, parentPt[0] - 25, parentPt[1]);
			g.setColor(Color.BLACK);
		}

		void drawString(Graphics g, String text, int x, int y) {
			for (String line : text.split("\n")) {
				g.drawString(line, x, y += g.getFontMetrics().getHeight());
			}
		}

		/**
		 * 绘制树
		 */
		void printTree(RecursiveShowNode tree, int[] parentPt, Graphics g) {
			Integer numLeaf = leafNumber(tree);

			int[] centerPt = new int[]{(int) (x0ff + (numLeaf + 1) / 2.0 * 200), y0ff};

			g.drawLine(centerPt[0], centerPt[1], parentPt[0], parentPt[1] + (20 * outputMaxLineNumber));

			printNode(tree.toTreeString(), centerPt, g);
			y0ff = (int) (y0ff + 1.0 * 100 + (20 * outputMaxLineNumber));
			for (RecursiveShowNode child : tree.children) {
				if (child.children.size() != 0) {
					printTree(child, centerPt, g);
				} else {
					x0ff = (int) (x0ff + 1.0 * 200);

					g.drawLine(x0ff, y0ff, centerPt[0], centerPt[1] + (20 * outputMaxLineNumber));

					printNode(child.toTreeString(), new int[]{x0ff, y0ff}, g);
				}
			}
			y0ff = (int) (y0ff - 1.0 * 100 - (20 * outputMaxLineNumber));
		}
	}

	public static void print() {
		JFrame frame = new JFrame("递归可视化--树");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent newContentPane = new RecursiveShowForTreeNode(RecursiveShowUtils.rootNode);
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		frame.setSize(1000, 1000);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}