package com.backjoon.fibonacci;

import java.io.*;
import java.util.*;

public class Main {

	static int answer[] = new int[2];
	static int call = 0;

	public static void main(String[] args) {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int cnt = Integer.parseInt(bf.readLine());

			int[][] arr = new int[cnt][2];
			for (int i = 0; i < cnt; i++) {
				String[] read = bf.readLine().split(" ");
				arr[i][0] = Integer.parseInt(read[0]);
				arr[i][1] = Integer.parseInt(read[1]);
			}



			bw.write(answer[0] + "\n");
			bw.write(answer[1] + "");

			bw.flush();
			bw.close();
			bf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class BinTree<K, V> {

	private Node root;
	private Comparator<? super Integer> comparator = null;

	private int comp(Integer a, Integer b) {
		return (comparator == null) ? ((Comparable<Integer>) a).compareTo(b) : comparator.compare(a, b);
	}

	BinTree() {
		root = null;
	}

	class Node<K, V> {
		private K key;
		private V data;
		private List<Node<K, V>> childs;

		Node(K key, V data, List<Node<K, V>> childs) {
			this.key = key;
			this.data = data;
			this.childs = childs;
		}

		K getKey() {
			return key;
		}

		V getValue() {
			return data;
		}

		void print() {
			System.out.print(data);
		}

	}
	
	private void add(Node<K, V> node, K key, V data) {
		if(root == null) {
			root = new Node<K, V>(key, data, null);
		}else {
			addNode(root, key, data);
		}
	}
	
	private void addNode(Node<K, V> node, K key, V data) {
		if(node.childs == null) {
			node.childs = new ArrayList<>();
			node.childs.add(new Node<K, V>(key, data, null));
		}else {
			for(int i = 0 ; i < node.childs.size(); i++) {
				addNode(node.childs.get(i), key, data);
			}
		}
	}
}