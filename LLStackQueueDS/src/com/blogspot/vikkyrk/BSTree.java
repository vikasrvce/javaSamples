package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BSTree<T extends Comparable<T>> {
	
	BSTNode root = null;
	private class BSTNode {
		T value;
		BSTNode left, right, parent;
		
		private BSTNode(T t, BSTNode parent) {
			this(t,null,null,parent);
		}
		
		private BSTNode(T t, BSTNode l, BSTNode r, BSTNode parent) {
			value = t;
			left = l;
			right = r;
			this.parent = parent;
		}
	}
	
	/*
	 * ***************************** Size/maxHeight ************************************
	 */
	
	public int size() {
		return computeSize(root);
	}
	
	private int computeSize(BSTNode node) {
		if(node == null) 
			return 0;
		return (1 + computeSize(node.right) + computeSize(node.left));
	}
	
	public int maxHeight() {
		return maxHeight(root);
	}
	
	private int maxHeight(BSTNode node) {
		if(node == null)
			return 0;
		int r = maxHeight(node.right);
		int l = maxHeight(node.left);
		return r>l?r+1:l+1;
	}

	/*
	 * Counting the number of unique Binary Search Trees
	 * that can be formed, for a given N
	 */
	public int countN(int num) {
		if(num <= 1) 
			return 1;
		int left,right;
		int sum = 0;
		for(int i=1;i<=num;i++) {
			left = countN(i-1);
			right = countN(num-i);
			sum+=left*right;
		}
		return sum;
	}
	
	/*
	 * ****************************** Insertion/Deletion ***************************
	 */
	
	public void clear() {
		root = null;
	}
	
	public void insert(T t) {
		if(root == null) {
			root = new BSTNode(t,null);
			return;
		}
		
		BSTNode temp = root, parent = null;
		int compare = 0;
		
		while(temp!=null) {
			compare = temp.value.compareTo(t);
			parent = temp;
			if(compare < 0) {
				temp = temp.right;
			} else if(compare > 0) {
				temp = temp.left;
			} else {
				throw new IllegalArgumentException("This element already exists");
			}
		}
		
		if(compare < 0) {
			parent.right = new BSTNode(t,parent);
		} else {
			parent.left = new BSTNode(t,parent);
		}
	}
	
	public void recursiveInsert(T t) {
		root = recursiveInsert(root, t);
	}
	
	private BSTNode recursiveInsert(BSTNode node, T t) {
		if(node == null) {
			node = new BSTNode(t,null);
			return node;
		}
		
		if(node.value.compareTo(t) < 0) {
			node.right = recursiveInsert(node.right,t);
			node.right.parent = node;
		} else {
		    node.left = recursiveInsert(node.left,t);
		    node.left.parent = node;
		}
		return node;
	}
	
	public void delete(T t) {
		BSTNode current = root;
		BSTNode parent = null, tempNode = null;

		while(current!=null && !current.value.equals(t)) {
			parent = current;
			if(current.value.compareTo(t) < 0) 
				current = current.right;
			else
				current = current.left;
		}
		
		if(current != null) {
			if(current.left == null) {
				tempNode = current.right;
			} else if(current.right == null) {
				tempNode = current.left;
			} else {
				BSTNode node = findMax(current.left);
				delete(node.value);
				node.left = current.left;
				node.right = current.right;
				if(node.left != null)
					node.left.parent = node;
				if(node.right != null)
					node.right.parent = node;
				tempNode = node;
			}
			
			if(current == root) {
				root = tempNode;
			} else if(current == parent.right) {
				parent.right = tempNode;
			} else {
				parent.left = tempNode;
			}
			
			if(tempNode != null)
				tempNode.parent = parent;
			current = null;
		}
	}
	

	/*
	 * ******************************** Validate ************************************
	 */
	public boolean isBST() {
		T max = findMax();
		T min = findMin();
		return isBST(root,max,min);
	}
	
	/*
	 * The other algorithm is to do inOrder Traversal
	 * and check if it is sorted or not
	 */
	private boolean isBST(BSTNode node, T max, T min) {
		if(node == null)
			return true;
		if((node.value.compareTo(min) < 0) || (node.value.compareTo(max) > 0))
			return false;
		return (isBST(node.left,node.value,min) && 
				isBST(node.right,max,node.value));
	}
	
	/*
	 * A redundant method just to test tamper the tree
	 * to verify isBST method.
	 */
	public void destroyBSProperty(T t1, T t2) {
		root.left.left.value = t1;
		root.right.left.value = t2;
	}
	
	
	/*
	 * *************** Search *************************************
	 */

	public T findMax() {
		BSTNode max = findMax(root);
		if(max != null)
			return max.value;
		else
			return null;
	}
	
	private BSTNode findMax(BSTNode node) {
		if(node == null) 
			return null;
		if(node.right == null)
			return node;
		return(findMax(node.right));
	}
	
	public T findMin() {
		BSTNode min = findMin(root);
		if(min != null)
			return min.value;
		else
			return null;
	}
	
	private BSTNode findMin(BSTNode node) {
		if(node == null) 
			return null;
		if(node.left == null)
			return node;
		return(findMin(node.left));
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
	
	/*
	 * *******************************Traversals ************************************
	 */
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
		if(node.parent != null)
			System.out.print("(" + node.value + "," + node.parent.value + "), ");
		else
			System.out.print("(" + node.value + "," + "null" + "), ");

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
	
	/*
	 * 	********************* Balancing Trees ************************
	 */

	public void balanceWithExtraMemory() {
		ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
		inorderTreeToArray(root,arr);
		root = constructBinaryTreefromArray(arr,0,arr.size()-1);
		if(root != null)
			root.parent = null;
	}
	 
	private void inorderTreeToArray(BSTNode node, ArrayList<BSTNode> arr) {
		if(node == null) 
			return;
		 
		inorderTreeToArray(node.left,arr);
		arr.add(node);
		inorderTreeToArray(node.right,arr);
	}
	 
	private BSTNode constructBinaryTreefromArray(ArrayList<BSTNode> arr, int lIndex, int rIndex) {
		if((arr == null) || (lIndex > rIndex))
			return null;
		
		int mid = lIndex + (rIndex-lIndex)/2;
		BSTNode node = arr.get(mid);
		node.left = constructBinaryTreefromArray(arr,lIndex,mid-1);
		node.right = constructBinaryTreefromArray(arr,mid+1,rIndex);
		 
		if(node.left != null)
			node.left.parent = node;
		if(node.right != null)
			node.right.parent = node;
		return node;
	}
	 
	 
	public void balanceUsingRotation() {
		rotateRightAll();
		BSTNode temp = null;
		
		for(int i=size()/2;i>0;i=i/2) {
			temp = root.right;
			for(int k=0;k<i;k++) {
				rotateLeftOnce(temp);
				if(temp.right == null)
					break;
				if(temp.right.right == null)
					break;
				temp = temp.right.right;
			}
		}
	}
	 
	/* 
	 * Tree Rotation. Adding a new parameter called 'parent' since
	 * tree rotation need information about the parent. 
	 */
	public void rotateRightAll() {
		BSTNode temp = root;
		while(temp != null) {
			if(temp.left == null)
				temp = temp.right;
			else {
				temp = temp.left;
				rotateRightOnce(temp);
			}
		}
	}
	 
	private void rotateRightOnce(BSTNode node) {
		if((node == null) || (node.parent == null))
			return;
		if(node != node.parent.left)
			return;
		 
		node.parent.left = node.right;
		
		if(node.right != null)
			node.right.parent = node.parent;
		node.right = node.parent;
		node.parent = node.parent.parent;
		node.right.parent = node;
		 
		if(node.parent == null)
			root = node;
		else if(node.parent.right == node.right)
			node.parent.right = node;
		else
			node.parent.left = node;
	}
	 
	public void rotateLeftAll() {
		BSTNode temp = root;
		while(temp != null) {
			if(temp.right == null)
				temp = temp.left;
			else {
				temp = temp.right;
				rotateLeftOnce(temp);
			}
		}
	}
	 
	private void rotateLeftOnce(BSTNode node) {
		if((node == null) || (node.parent == null))
			return;
		if(node != node.parent.right)
			return;
		 
		node.parent.right = node.left;
		
		if(node.left != null)
			node.left.parent = node.parent;
		node.left = node.parent;
		node.parent = node.parent.parent;
		node.left.parent = node;
		 
		if(node.parent == null)
			root = node;
		else if(node.parent.left == node.left)
			node.parent.left = node;
		else
			node.parent.right = node;
	}
	
	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	private boolean isBalanced(BSTNode node) {
		if(size() == 0)
			return true;
		if(maxHeight() > (int)(Math.log(size())/Math.log(2)) + 1) 
			return false;
		else
			return true;
	}
}	

