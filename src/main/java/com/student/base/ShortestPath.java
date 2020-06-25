package com.student.base;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class ShortestPath {
	static class Node
	{
	public ArrayList<Node> neighborNodes;
	public int value;

	public Node(int v)
	{
	neighborNodes = new ArrayList<Node>();
	value = v;
	}
	}

	static int traverse(Node node1, Node node2, LinkedHashSet<Node> traversedNodes, int knownLength, LinkedHashSet<Node> out)
	{
	int minLen = Integer.MAX_VALUE;
	LinkedHashSet<Node> minPath = new LinkedHashSet<Node>();

	if (!traversedNodes.contains(node1))
	{
	traversedNodes.add(node1);

	if (!node1.equals(node2))
	{
	for (int i =0; i < node1.neighborNodes.size(); i++)
	{
	int len = traverse(node1.neighborNodes.get(i), node2, traversedNodes, knownLength + 1, out);
	if (len < minLen)
	{
	minLen = len;
	minPath.clear();
	minPath.addAll(out);
	}
	}
	}
	else
	{
	minLen = knownLength + 1;
	minPath.addAll(traversedNodes);
	}

	if (minPath.size() > 0)
	{
	out.clear();
	out.addAll(minPath);
	}

	traversedNodes.remove(node1);
	}

	return minLen;
	}

	static void printResult(LinkedHashSet<Node> path) {
	int i = path.size();
	for (Node n : path)
	{
	System.out.print(n.value + ",");
	}
	}

	/**
	* @param args
	*/
	public static void main(String[] args) {
	Node node1 = new Node(1),
	node2 = new Node(2),
	node3 = new Node(3),
	node4 = new Node(4),
	node5 = new Node(5),
	node6 = new Node(6),
	node7 = new Node(7),
	node8 = new Node(8),
	node9 = new Node(9);

	node1.neighborNodes.add(node2);
	node2.neighborNodes.add(node5);
	node5.neighborNodes.add(node6);
	node6.neighborNodes.add(node8);

	node2.neighborNodes.add(node6);

	node1.neighborNodes.add(node3);
	node3.neighborNodes.add(node4);
	node4.neighborNodes.add(node8);

	node1.neighborNodes.add(node5);
	node5.neighborNodes.add(node6);
	node6.neighborNodes.add(node8);


	LinkedHashSet<Node> traversedNodes = new LinkedHashSet<Node>();
	LinkedHashSet<Node> out = new LinkedHashSet<Node>();
	int i = traverse(node1, node8, traversedNodes, 0, out);
	if (i != Integer.MAX_VALUE)
	{
	printResult(out);
	}
	}
}
