package com.blogspot.vikkyrk;

import java.util.Random;

public class mainTest {
	public static void main(String[] args) {
	    //myRun mRun = new ReverseLL();
	    //myRun mRun = new LLPalindrome();
		//myRun mRun = new LLSort();
		//mRun.run();
		//LLRun();
		//stackRun();
		BSTRun();
		
		//StackAlgorithms.StockSpan();
		//StackAlgorithms.LRAHistogram();
	}		

	public static void stackRun() {
		myStack<Integer> mStack = new myArrayStack<Integer>(10);
		mStack.push(1);
		mStack.push(2);
		mStack.push(3);
		System.out.println(mStack.toString());
		mStack.pop();
		mStack.pop();
		System.out.println(mStack.toString());
		System.out.println(mStack.pop());
		System.out.println(mStack);
		
		myListImpl<Integer> ll = new myListImpl<Integer>();
		ll.add(1);ll.add(2);ll.add(3);ll.add(4);
		ll.printList();
		while(ll.size() != 0) {
			mStack.push(ll.remove(ll.size()-1));
		}
		System.out.println(mStack.toString());
		while(!mStack.isEmpty()) {
			ll.add(mStack.pop());
		}
		ll.printList();
		
	}
	public static void LLRun() {
		myListImpl<Integer> ml = new myListImpl<Integer>();
		/*ml.printList();
		ml.add(2);
		ml.printList();
		ml.add(4);
		ml.printList();
		ml.add(1,ml.size());
		ml.printList();
		ml.add(4,0);
		ml.printList();
		ml.set(5,0);
		ml.printList();
		ml.set(3, 0);
		ml.printList();
		ml.set(6,3);
		ml.printList();
		System.out.println(ml.get(0));
		System.out.println(ml.get(ml.size()-1));
		
		Iterator<Integer> iter = ml.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		ml.remove(0);
		ml.remove(0);
		ml.remove(0);
		ml.remove(0);
		ml.printList();*/
		
		
		generateRandomInput(ml);
	/*	ml.clear();
		ml.add(1);
		ml.add(2);
		ml.add(3);
		ml.add(3);
		ml.add(2);
		ml.add(1);*/
		//ml.generateRandomLoop();
		//System.out.println("HasLoop = " + ml.hasLoop());
		//System.out.println("LoopStartIndex = " + ml.getLoopStartIndex());
		//System.out.println("Nth element From last =  " + ml.getNthElementFromLast(5));
		ml.printList();
		System.out.println("IsPalindrome = " + ml.isPalindrome());
		ml.reversePairwise();
		//ml.reverseList(4);
		
		ml.printList();
	}
	
	public static void generateRandomInput(myListImpl<Integer> ml) {
		Random randomGen = new Random();
		int sz = randomGen.nextInt(12);
		for(int i=0; i<sz; i++) {
			ml.add(randomGen.nextInt(100));
		}
		
	}
	public static void BSTRun() {
		BSTree<Integer> mTree = new BSTree<Integer>();
	
		generateRandomTree(mTree, 10);
		mTree.preOrderTraversal();
		mTree.inOrderTraversal();
		mTree.postOrderTraversal();
		/*mTree.recursiveInsert(1);
		mTree.recursiveInsert(2);
		mTree.recursiveInsert(3);
		mTree.recursiveInsert(4);
		//mTree.recursiveInsert(5);
		//mTree.recursiveInsert(6);
		//mTree.recursiveInsert(7);
		mTree.balanceUsingRotation();
		System.out.println(mTree.isBalanced());*/
		
		/*Random randomGen = new Random();
		
		for(int i=1;i<10;i++) {
			
			generateRandomTree(mTree,i);
			System.out.println("\n\nTree Construction");
			if(!mTree.isBST())
				throw new RuntimeException("Failed for input Size" + i);
			else
				System.out.println("Success for Size = " + mTree.size());
	
			mTree.delete(randomGen.nextInt(i));
			mTree.delete(randomGen.nextInt(i));
			mTree.delete(randomGen.nextInt(i));
			mTree.delete(randomGen.nextInt(i));
			
			System.out.println("Deletion Test");
			if(!mTree.isBST())
				throw new RuntimeException("Failed for input Size" + i);
			else
				System.out.println("Success for Size = " + mTree.size());
			
			mTree.rotateRightAll();
			System.out.println("Right Rotation Test");
			if(!mTree.isBST()) {
				mTree.inOrderTraversal();
				mTree.breadthFirstTraversal();
				throw new RuntimeException("Failed for input Size" + i);
			}
			else
				System.out.println("Success for Size = " + mTree.size());
			
			mTree.rotateLeftAll();
			System.out.println("Left Rotation Test");
			if(!mTree.isBST()) {
				mTree.inOrderTraversal();
				mTree.breadthFirstTraversal();
				throw new RuntimeException("Failed for input Size" + i);
			}	
			else
				System.out.println("Success for Size = " + mTree.size());
			
			
			mTree.balanceWithExtraMemory();
			System.out.println("Balance using Memory Test: Height = " + mTree.maxHeight());
			if(!mTree.isBST() || !mTree.isBalanced())
			{
				mTree.inOrderTraversal();
				mTree.breadthFirstTraversal();
				throw new RuntimeException("Failed for input Size" + i);
			} else
				System.out.println("Success for Size = " + mTree.size());
			
			mTree.balanceUsingRotation();
			System.out.println("Balance using Rotation Test: Height = " + mTree.maxHeight());
			if(!mTree.isBST() || !mTree.isBalanced()) {
				mTree.inOrderTraversal();
				mTree.breadthFirstTraversal();
				throw new RuntimeException("Failed for input Size" + i);
			} else
				System.out.println("Success for Size = " + mTree.size());
			
			mTree.breadthFirstTraversal();
			mTree.clear(); 
		} */
	}
	
	/***************** Random Tree Input Generation and Testing ***************************/
	
	public static void generateRandomTree(BSTree<Integer> mTree, int size) {
		mTree.clear();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(size);
		while(mTree.size() != randomInt) {
			int randomInt1 = randomGenerator.nextInt(size);
			if(!mTree.search(randomInt1))
				mTree.recursiveInsert(randomInt1);
		}
	}
	
	
}
