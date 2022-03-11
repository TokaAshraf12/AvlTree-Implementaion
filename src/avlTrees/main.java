package avlTrees;
import java.util.*;

public class main {
	public static void main(String[] args) {
		String operation;
		rotations_height_print N=new rotations_height_print();
		insertion nodeinsert=new insertion();
		deletion  nodedelete=new deletion();
		
		Scanner input=new Scanner(System.in);
		boolean temp=false;
		while(!temp) {
			System.out.println("Enter your desired operation: (insert - delete - height - print) or (exit) to end the program: ");
			 operation=input.next(); 
				switch(operation) {
				case "insert":
					System.out.println("Enter the element: ");
					int item=input.nextInt();
					nodeinsert.root=nodeinsert.Insertion(nodeinsert.root,item);
					
					break;
				case "height":
					System.out.println(N.Height(nodeinsert.root));
					break; 
				case "print":
				  N.printAvlTree( nodeinsert.root,  N.Height(nodeinsert.root));
				  break;
				case "delete":
					if(nodeinsert.root != null) {
						System.out.println("Enter the element that you want to delete : ");
						int itemdeleted=input.nextInt();

						N.root=N.search(nodeinsert.root,itemdeleted);
						if(N.root!=null) {
							nodeinsert.root=nodedelete.Deletion( nodeinsert.root, itemdeleted);
							System.out.println("done");
						}else {
							System.out.println("not found");
						}
						
					}else {
						System.out.println("Empty Tree");
					}

					break;
				case"search":
					System.out.println("Enter the element that you want to search for : ");
					int itemsearch=input.nextInt();
					N.root=N.search(nodeinsert.root,itemsearch);
					if(N.root!=null) {
						System.out.println(""+N.root.element);
					}
					break;
				case"exit":
					System.exit(0);
//					temp=true;
//					break;
					
			    default:
			    	System.out.println("It IS Not Available. Please Enter The Right Operation: ");
			    	break;
					
				}
		
			
		}
		
			
		
	}

}
