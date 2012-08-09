package com.blogspot.vikkyrk;

import java.util.LinkedList;
import java.util.Queue;

public class BSTree<T extends Comparable<T>> {
	
	BSTNode root = null;
	private class BSTNode {
		T value;
		BSTNode left, right;
		
		private BSTNode(T t) {
			this(t,null,null);
		}
		
		private BSTNode(T t, BSTNode l, BSTNode r) {
			value = t;
			left = l;
			right = r;
		}
	}
	
	public void insert(T t) {
		if(root == null) {
			root = new BSTNode(t);
			return;
		}
		
		BSTNode temp = root, prevNode = null;
		int compare;
		
		while(temp!=null) {
			compare = temp.value.compareTo(t);
			if(compare < 0) {
				prevNode = temp;
				temp = temp.right;
			} else if(compare > 0) {
				prevNode = temp;
				temp = temp.left;
			} else {
				throw new IllegalArgumentException("This element already exists");
			}
		}
		
		if(prevNode.value.compareTo(t) < 0) {
			prevNode.right = new BSTNode(t);
		} else {
			prevNode.left = new BSTNode(t);
		}
	}
	
	public void recursiveInsert(T t) {
		root = recursiveInsert(root, t);
	}
	
	private BSTNode recursiveInsert(BSTNode node, T t) {
		if(node == null) {
			node = new BSTNode(t);
			return node;
		}
		
		if(node.value.compareTo(t) < 0) {
			node.right = recursiveInsert(node.right,t);
		} else {
		    node.left = recursiveInsert(node.left,t);
		}
		return node;
	}
	
	public void delete(T t) {
		if(root == null)
			return;
		
		BSTNode current = root;
		BSTNode parent = null;
		int compare, branch=0;
		do {
			compare = current.value.compareTo(t);
			if(compare < 0) {
				parent = current;
				branch = compare;
				current = current.right;
			}	
			else if(compare > 0) {
				parent = current;
				branch = compare;
				current = current.left;
			}
			else
				break;
		} while(current!=null);

		if(current != null) {
			if(current.left == null && current.right == null) {
				if(current == root) {
					root = null;
					return;
				}
				
				if(branch < 0)
					parent.right = null;
				else if(branch > 0)
					parent.left = null;
				
			} else if(current.left == null) {
				if(current == root) {
					root = current.right;
					return;
				}
				
				if(branch < 0)
					parent.right = current.right;
				else if(branch > 0)
					parent.left = current.right;
				
			} else if(current.right == null) {
				if(current == root) {
					root = current.left;
					return;
				}
				
				if(branch < 0)
					parent.right = current.left;
				else if(branch > 0)
					parent.left = current.left;
			} else {
				
			}
					
		}
		
	}
	
	public boolean search(T t) {
		if(search(root,t) == null)
			return false;
		else
			return true;
	}
	
	private BSTNode search(BSTNode node, T t) {
		if(node == null) 
			return null;
		if(t.compareTo(node.value) > 0)
			return search(node.right,t);
		else if(t.compareTo(node.value) < 0)
			return search(node.left,t);
		else
			return node;
	}
	
	public void breadthFirstTraversal() {
		System.out.println("\nBreadthFirstTraversal");
		Queue<BSTNode> mQueue = new LinkedList<BSTNode>();
		mQueue.offer(root);
		breadthFirstTraversal(mQueue);
	}
	
	private void breadthFirstTraversal(Queue<BSTNode> mQueue) {
		BSTNode node = mQueue.poll();
		if(node == null) 
			return;
		
		System.out.print(node.value + ",");
		if(node.left != null)
			mQueue.offer(node.left);
		
		if(node.right != null)
			mQueue.offer(node.right);
		
		breadthFirstTraversal(mQueue);
	}
	
	public void preOrderTraversal() {
		System.out.println("\nPreOrderTraversal");
		preOrderTraversal(root);
	}
	
	private void preOrderTraversal(BSTNode node) {
		if(node == null) 
			return;
		System.out.print(node.value + ",");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
		
	}
	
	public void inOrderTraversal() {
		System.out.println("\nInOrderTraversal");
		inOrderTraversal(root);
	}
	
	/*
	 * Inorder traversal on a BSTree prints out the list
	 * in a sorted order. This is the principle of TreeSort.
	 * But if the tree is unbalanced, the worst case is
	 * O(n^2). Explore self balancing trees for that.
	 */
	private void inOrderTraversal(BSTNode node) {
		if(node == null) 
			return;
		inOrderTraversal(node.left);
		System.out.print(node.value + ",");
		inOrderTraversal(node.right);
	}
	
	public void postOrderTraversal() {
		System.out.println("\nPostOrderTraversal");
		postOrderTraversal(root);
	}
	
	private void postOrderTraversal(BSTNode node) {
		if(node == null) 
			return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.value + ",");		
	}
}
