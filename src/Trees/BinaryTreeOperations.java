package Trees;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeOperations {
	public static TreeNode buildTreeFromArray(int [] inp){
		TreeNode a= sortedArrayToBST(inp,0,inp.length-1);
		return a;
	}
	public static TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);
 
		return root;
	}
	public static void printInorderTree(TreeNode root){
		if(root==null){
			return;
		}
		printInorderTree(root.left);
		System.out.println(""+root.data);
		printInorderTree(root.right);
	}
	public static void printPreOrderTree(TreeNode root){
		if(root==null){
			return;
		}
		System.out.println(":"+root.data);
		printPreOrderTree(root.left);
		printPreOrderTree(root.right);
	}
	public static void printPostOrderTree(TreeNode root){
		if(root==null){
			return;
		}
		printPostOrderTree(root.left);
		printPostOrderTree(root.right);
		System.out.println(":"+root.data);
	}
	public static TreeNode insertNode(TreeNode root,int data){
		
		if(root==null){
			root = new TreeNode(data);
		}
		else {
			if(data > root.data){
				root.right = insertNode(root.right, data);
			}
			else{
				root.left = insertNode(root.left, data);
		    }
		}
		return root;
	}
	public static int height(TreeNode root){
		if(root==null){
			return -1;
		}else{
			
				return Math.max(height(root.left),height(root.right))+1;
		}
	}
	public static boolean searchTree(TreeNode root,int data){
		if(root == null){
			return false;
		}
		if(data<root.data){
			return searchTree(root.left, data);
		}else if(data>root.data){
			return searchTree(root.right, data);
		}else{
			return true;
		}
	}
	public static TreeNode minimum(TreeNode root){
		if(root==null || root.left==null){
			return root;
		}
		System.out.println("mm"+root.data);
		return minimum(root.left);
	}
	public static TreeNode maximum(TreeNode root){
		if(root==null || root.left==null){
			return root;
		}
		TreeNode  temp = root;
		while(temp.right!=null){
			temp = temp.right;
		}
		return temp;
	}
	public static void BFS(TreeNode root){
		Queue<TreeNode> sample=new LinkedList<TreeNode>();
		sample.add(root);
		System.out.print("BFS--");
		while(!sample.isEmpty()){
			TreeNode temp = sample.poll();
			System.out.print(temp.data+"  ");
			if(temp.left!=null)
				sample.add(temp.left);
			if(temp.right!=null)
				sample.add(temp.right);
		}
	}
	public static void DFS(TreeNode root){
		Stack<TreeNode> sample = new Stack<>();
//		sample.push(root);
		System.out.println("DFS--");
		while(!sample.empty() || root != null){
			 
            // if it is not null, push to stack
            //and go down the tree to left
            if(root != null){
                sample.push(root);
                root = root.left;
 
            // if no left child
            // pop stack, process the node
            // then let p point to the right
            }else{
                TreeNode t = sample.pop();
                System.out.print(t.data+" ");
                root = t.right;
            }
        }
 
	}
	public static void main(String[] args) {
		int[]input = {0,1,2,4,4,7,22,50,60};
		
		TreeNode t= buildTreeFromArray(input);
//		printInorderTree(t);
		t=insertNode(t,70);
		printInorderTree(t);
		System.out.println(searchTree(t,2)+" Minimum : "+minimum(t).data+":"+"Maximum:"+maximum(t).data);
		BFS(t);
		DFS(t);
		System.out.println("Height of tree--"+height(t));
		
	}
}
