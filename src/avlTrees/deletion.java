package avlTrees;

public class deletion {
	node root;
	rotations_height_print N2=new rotations_height_print();
	 
//Function Of Deletion..
	 node Deletion(node no,int elem) {
			if(no == null) {
				return no; //root= null(already empty tree)
			}
			
			if(elem < no.element) {
				no.left=Deletion(no.left,elem);
				if(no.left ==null) {
					return no.left;
				}
			}else if(elem > no.element) {
				no.right=Deletion(no.right,elem);
				if(no.right ==null) {
					return no.right;
				}
			}else {
				////if the deleted element is the root
				if(no.right==null || no.left==null) { //if the root lost one of its children or both
					node flag=null;
					if(no.right==flag) {
						flag=no.left;
					}else{
						flag=no.right;
					}
					if(flag==null) { //has no children
						flag=no;
						no=null;
					}else {
						no=flag;
					}
				}else { //if both children of root are here..
					//to get the minimum children of the root..
						node minimum=no.right; 
						node m=minimum;
						while(minimum!=null) { //case that the right child of the root has children.
							minimum=minimum.left;
							if(minimum!=null) {
								no.element=minimum.element;
								
							}else {
								no.element=m.element;
							}
							no.right=Deletion(no.right,no.element);
							
						}
				
				}
			}
			
			if(no==null) {
				return no;
			}
			
			no.height=N2.MaxHeight(N2.Height(no.left),N2.Height(no.right))+1;
			
			int BF=N2.BalanceFactor(no);
			if(BF > 1) {
				int BFleft=N2.BalanceFactor(no.left);
				if(BFleft >0 ) {
					return N2.RightRotation(no); //left-left case
				}else if(BFleft <0) { ///left-right case
					no.left=N2.LeftRotation(no.left);
					return N2.RightRotation(no);
				}else {
					return N2.RightRotation(no);  //consider it left-left case
				}
			}else if(BF <-1) {
				int BFright=N2.BalanceFactor(no.right);
				if(BFright > 0) {
					no.right=N2.RightRotation(no.right);
					return N2.LeftRotation(no);
				}else if(BFright <0) {
					return N2.LeftRotation(no);
				}else {
					return N2.LeftRotation(no);
				}
			}
			return no;
		}
	
  
}
