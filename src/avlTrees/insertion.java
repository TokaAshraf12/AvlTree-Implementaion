package avlTrees;

public class insertion {
	rotations_height_print N1=new rotations_height_print();
	node root;
	
	
	node Insertion(node n,int elem) {
		
		//empty place
		if(n==null) {
			return new node(elem);
		}
		//check if the inserted element less or greater than root
		if(elem <n.element) {
			n.left=Insertion(n.left,elem);
		}else if(elem>n.element) {
			n.right=Insertion(n.right,elem);
		}else {
			return n; //the inserted element is already here
		}
		n.height=1+N1.MaxHeight(N1.Height(n.left),N1.Height(n.right));
		
		int BF=N1.BalanceFactor(n);
		if(BF >1) {
			if(elem< n.left.element) {
				return N1.RightRotation(n);
			}
			//left-right rotation
           if(elem >n.left.element){ 
				n.left=N1.LeftRotation(n.left);
				node f=N1.RightRotation(n);
				return f;
			}
           
		}else if(BF<-1) {
			if(elem > n.right.element) {
				return N1.LeftRotation(n);
			}
			//right-left rotation
			if(elem <n.right.element) {
				n.right=N1.RightRotation(n.right);
				node f=N1.LeftRotation(n);
				return f;
			}
		}
		return n;
	}

}
