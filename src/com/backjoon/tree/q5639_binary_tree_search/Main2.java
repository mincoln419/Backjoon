package com.backjoon.tree.q5639_binary_tree_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
	static class Node {
		int num;
		Node left, right;

		public Node(int num) {
			this.num = num;
		}

		public void insert(int child) {
			if (child < this.num) {
				if (this.left == null)
					this.left = new Node(child);
				else
					this.left.insert(child);
			} else {
				if (this.right == null)
					this.right = new Node(child);
				else
					this.right.insert(child);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node root = new Node(Integer.parseInt(br.readLine()));
		String input;
		while (true) {
			input = br.readLine();
			if (input == null || input.equals(""))
				break;
			root.insert(Integer.parseInt(input));
		}

		postOrder(root);
	}

	static void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);
	}
}
