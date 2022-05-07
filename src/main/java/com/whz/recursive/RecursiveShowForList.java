package com.whz.recursive;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * @author : whz
 */
class RecursiveShowForList extends JPanel {

	public RecursiveShowForList(RecursiveShowNode root) {
		super(new BorderLayout());

		JTree jt = new JTree(translate2SwingTree(root));

		jt.setCellRenderer(new DefaultTreeCellRenderer() {
			@Override
			public Component getTreeCellRendererComponent(JTree tree,
																										Object value, boolean sel, boolean expanded, boolean leaf,
																										int row, boolean hasFocus) {
				StringBuffer text = new StringBuffer(value.toString());
				text = new StringBuffer(toMark(text.toString(), new String[]{"出", "入", "返", "额", "全"}));
				if (text.toString().endsWith("-isDp")) {
					text = new StringBuffer("<b color='green'>" + text.toString().replace("-isDp", "") + "</b>");
				}
				text = new StringBuffer("<html>").append(text);
				text.append("</html>");
				return super.getTreeCellRendererComponent(
						tree, text.toString(), sel, expanded, leaf, row, hasFocus);
			}
		});
		add(jt);
	}

	private String toMark(String target, String[] text) {
		for (String s : text) {
			target = target.replace(s, "<b color='blue'>" + s + "</b>");
		}
		return target;
	}

	DefaultMutableTreeNode translate2SwingTree(RecursiveShowNode ast) {
		DefaultMutableTreeNode dmtn = new DefaultMutableTreeNode("" + ast.toString());
		for (RecursiveShowNode child : ast.children) {
			dmtn.add(translate2SwingTree(child));
		}
		return dmtn;
	}


	public static void print() {
		JFrame frame = new JFrame("递归可视化-列表");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent newContentPane = new RecursiveShowForList(RecursiveShowUtils.rootNode);
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		frame.setSize(1000, 1000);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
