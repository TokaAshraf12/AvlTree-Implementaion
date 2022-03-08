package avlTrees;

public class rotations_height_print {
	node root;
	int MaxHeight(int n1,int n2) {
		int max=n1;
		if(n2>n1) {
			max=n2;
		}
		return max;
	}
	///Search
	node search(node node,int element1) {
		node now=node;
		while(now!=null) {
			if(now.element==element1) {
				System.out.println("Found..");
				break;
			}else if(element1 < now.element) {
				now=now.left;
				
				return search(now,element1);
			}else {
				now=now.right;
				
				return search(now,element1);
			}
			
		}
		if(now==null) {
			System.out.println("Not Found..");
		}
		
		return now;
	}
	int BalanceFactor(node no) {
		if(no ==null) {
			return -1;
		}else {
			return Height(no.left)-Height(no.right);
		}
	}
	node RightRotation(node n0){
		node n1=n0.left;
		node n2=n1.right;
		n1.right=n0;
		n0.left=n2;
		n0.height=MaxHeight(Height(n0.left),Height(n0.right))+1;
		n1.height=MaxHeight(Height(n1.left),Height(n1.right))+1;
		
		return n1;
	}
	
	node LeftRotation(node n0){
		node n1=n0.right;
		node n2=n1.left;
		n1.left=n0;
		n0.right=n2;
		n0.height=MaxHeight(Height(n0.left),Height(n0.right))+1;
		n1.height=MaxHeight(Height(n1.left),Height(n1.right))+1;
		
		return n1;
	}
	int Height(node elem) {
		if(elem != null) {
			return elem.height;
		}
		return -1;
	}
	 void printAvlTree(node n, int height){
	    if(n==null) {
	    	 
	         return;
	    }
	    	
	    printAvlTree(n.right, height+1);
	    if(height!=0){
	        for(int i=0;i<height-1;i++)
	            System.out.print("|\t");
	        System.out.println("|-----"+n.element);
	    }
	    else {
	        System.out.println(n.element);
	    }
	    printAvlTree(n.left, height+1);
	}   

}
