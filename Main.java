import java.util.*;

public class Main {
	public static void main(String[] args) throws InputMismatchException {
		ToDoList list = new ToDoList();
		int deleteItem = -1;
		boolean quit = false;
		
		//Menu
		System.out.println("\t\tTO-DO LIST\t\t");
		System.out.println("------------------------------------------");
		System.out.println("\t(1) ADD ITEM TO LIST");
		System.out.println("\t(2) REMOVE ITEM FROM LIST");
		System.out.println("\t(3) VIEW LIST");
		System.out.println("\t(4) CLEAR LIST");
		System.out.println();
		System.out.println("\t(0) EXIT");
		System.out.println("------------------------------------------");
		
		
		//UI Loop
		while(quit == false) {
			try {	
				System.out.print("PLEASE MAKE A SELECTION: ");
				Scanner scnr = new Scanner(System.in);
			
				//Determine user selection
				int selection = scnr.nextInt();
				scnr.nextLine();
	
				//Add Item
				if (selection == 1) {
					System.out.println("\n\n\tWHAT WOULD YOU LIKE TO ADD? ");
				
					String addItem = scnr.nextLine();
					list.addTODO(addItem);

					System.out.println("\n------------------------------------------");
					System.out.println("\tADDED \"" + addItem + "\" TO YOUR TO-DO LIST.");
					System.out.println("------------------------------------------\n\n");
				}
				//Delete Item
				else if (selection == 2) {
					list.viewTODO();
					System.out.print("\n\n\tWHICH ITEM WOULD YOU LIKE TO DELETE? ");
					deleteItem = scnr.nextInt();
					String deleted = list.deleteTODO(deleteItem);
				
					System.out.println("\n------------------------------------------");
					System.out.println("\tDELETED " + deleted + " FROM YOUR TO-DO LIST.");
					System.out.println("------------------------------------------\n\n");
				
				}
				//View List
				else if (selection == 3) {
					System.out.println("\n\n\t\tTO-DO LIST\t\t");
					System.out.println("------------------------------------------");
					list.viewTODO();			
					System.out.println("\n\n");
				}
				//Clear List of all Items
				else if (selection == 4) {
					list.clearTODO();
					System.out.println("\n------------------------------------------");
					System.out.println("\tLIST CLEARED.");
					System.out.println("------------------------------------------\n\n");
				
				}
				//Quit the program
				else if (selection == 0) {
					System.out.println("\n\n------------------------------------------");
					System.out.println("\t\tGOODBYE.");
					System.out.println("------------------------------------------\n\n");
					quit = true;
				}
			} catch (Exception e) {
				System.out.println("\n\n\tOOPS! LOOKS LIKE YOU'VE FORGOTTEN SOMETHING."
						+ "\n\tGOOD THING YOU'VE GOT A TO-DO LIST!\n");
			}
		}
	}
}

class ToDoList {
	public ArrayList<String> todoList = new ArrayList<String>();

	public void addTODO(String item) {
		todoList.add(item);
	}
	
	public String deleteTODO(int itemNumber) {
		int index = itemNumber - 1;
		String deletedItem = todoList.get(index);
		todoList.remove(index);
		return deletedItem;
	}
	
	public void viewTODO() {
		//list all items, numbered
		System.out.println();
		if (todoList.isEmpty() == true) {
			System.out.println("\n\n  --TO-DO LIST DOES NOT HAVE ANY ITEMS--");
		} else {
			for (int i = 0; i < todoList.size(); ++i) {
				System.out.print((i + 1) + ".   " );
				System.out.println(todoList.get(i));
			}
		}
	}
	
	public void clearTODO() {
		todoList.clear();
	}
}
