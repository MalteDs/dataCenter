package ui;
import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * The class Main allows the user select between show all available rooms, rent a room, simulate on and off room <br>
 * @author David Malte "RanitaUwU, RagnarArik"
*/
public class Main {
	public static DataCenter dataCenter = new DataCenter();
	public static Scanner sc=new Scanner(System.in);
	
	/**
	 * Method name: main <br>
	 * The method shows a menu <br> 
	 * @param args
	 */
	public static void main (String[]args){
		int rentalCont=0;
		for (boolean exit = false;exit==false;) {
			System.out.println("DATACENTER \n 1. Available mini-rooms \n 2. Rent mini_room \n 3. Cancel rent \n 4. DataCenter map \n 5. Simulate on \n 6. Simulate off \n 7. exit");
			int sel=sc.nextInt();
			sc.nextLine();
			switch (sel) {
				case 1: availableMiniRooms();
					
					break;
	
				case 2: rentMiniRoom(sc, rentalCont);
						rentalCont++;
					break;
				case 3: cancelRent(sc);
						rentalCont--;
					break;
				case 4: showMap();
		
					break;
				case 5: simulateOn();
		
					break;
				case 6: System.out.println(simulateOff(sc));
		
					break;
				case 7: exit=true;
		
					break;
			}
		}
	}
	
	
	/**
	 * Method name: availableMinirooms<br>
	 * The method shows the mini-rooms information
	 */
	public static void availableMiniRooms() {
		String message=dataCenter.avaliableRooms();
		System.out.println(message);
	}
	
	/**
	 * Method name: RentMiniRoom <br>
	 * The method allow register a rent of a mini-room
	 */
	public static void rentMiniRoom(Scanner sc, int cont) {
		System.out.println("DATACENTER \n Base price: $250  \n 1. Particular company \n 2. Investigation proyect");
		int sel=sc.nextInt();
		sc.nextLine();
		switch (sel) {
			case 1: rentCompany(sc, cont);
				break;
	
			case 2: rentProyect(sc, cont);
					
				break;
		}
	}
	
	/**
	 * Method name: rentCompany<br>
	 * The method read the information to rent a mini_room
	 * @param sc Scanner 
	 * @param cont integer the cantity of room alquilated
	 */
	public static void rentCompany(Scanner sc, int cont) {
		System.out.println("Enter the actual date (dd-mm-yyyy)");
		String date=sc.nextLine();
		System.out.println("Enter the name of the company");
		String nameCompany=sc.nextLine();
		System.out.println("Enter the nit of the company");
		String nitCompany=sc.nextLine();
		System.out.println("Enter the servers information: ");
		System.out.println("Cache (GB): ");
		int cache=sc.nextInt();
		sc.nextLine();
		System.out.println("Processors number");
		int processorsNumber=sc.nextInt();
		sc.nextLine();
		System.out.println("Processor brand");
		String processorBrand=sc.nextLine();
		System.out.println("Ram (GB): ");
		int ram=sc.nextInt();
		sc.nextLine();
		System.out.println("Number of discs: ");
		int discNumber=sc.nextInt();
		sc.nextLine();
		System.out.println("Discs capacity (Teras): ");
		int discCapacity=sc.nextInt();
		sc.nextLine();
		String message=dataCenter.rentMiniRoom(date, nameCompany, nitCompany, cache, processorsNumber, processorBrand, ram, discNumber, discCapacity, cont);
		System.out.println(message);
	}
	
	/**
	 * Method name: rentProyect <br>
	 * The method read the information for a proyect rent <br>
	 * @param sc
	 * @param cont
	 */
	public static void rentProyect(Scanner sc, int cont) {
		System.out.println("ICESI PROYECT");
		System.out.println("Company nit: 890.316.745-5");
		String nameCompany="ICESI University";
		String nitCompany="890.316.745-5";
		
		System.out.println("Enter the actual date (dd-mm-yyyy)");
		String date=sc.nextLine();
		System.out.println("Enter the proyect number");
		int proyectNumber=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the servers information: ");
		System.out.println("Cache: ");
		int cache=sc.nextInt();
		sc.nextLine();
		System.out.println("Processors number");
		int processorsNumber=sc.nextInt();
		sc.nextLine();
		System.out.println("Processor brand");
		String processorBrand=sc.nextLine();
		System.out.println("Ram: ");
		int ram=sc.nextInt();
		sc.nextLine();
		System.out.println("Number of discs: ");
		int discNumber=sc.nextInt();
		sc.nextLine();
		System.out.println("Discs capacity");
		int discCapacity=sc.nextInt();
		sc.nextLine();
		String message=dataCenter.rentProyect(date, nameCompany, nitCompany,proyectNumber, cache, processorsNumber, processorBrand, ram, discNumber, discCapacity, cont);
		System.out.println(message);
	}
	
	/**
	 * Method name <br>
	 * The method shows a menu to cancel a rent <br>
	 * @param sc
	 */
	
	public static void cancelRent(Scanner sc) {
		System.out.println("CANCEL RENT \n 1. Cancel single room rent \n 2. Cancel rent of all rooms rented by a company");
		int sel=sc.nextInt();
		sc.nextLine();
		switch (sel) {
			case 1: cancelByRoom(sc);
				
				break;

			case 2: deleteByCompany(sc);
				break;
		}
	}
	
	/**
	 * Method name: cancelByRoom <br>
	 * The method allows cancel a rent by a unique room number entered <br>
	 * @param sc
	 */
	public static void cancelByRoom(Scanner sc) {
		System.out.println("CANCEL SINGLE ROOM RENT \n Enter the unique number room");
		int search=sc.nextInt();
		sc.nextLine();
		if (dataCenter.showRent(search)!="The rent does not exist") {
			System.out.println(dataCenter.showRent(search)+"\n Are you sure to eliminate the rent from this room? \n 1. Yes \n 2. No");
			int sel=sc.nextInt();
			sc.nextLine(); 
			switch (sel) {
				case 1: System.out.println(dataCenter.deleteByRoom(search));
					
					break;
		
				case 2: System.out.println("Ok. Comming back");
					break;
			}
		}
		else System.out.println(dataCenter.showRent(search));
	}
	
	/**
	 * Method name deleteByCompany <br>
	 * The method allows cancel a rent by a company namme entered <br> 
	 * @param sc
	 */
	public static void deleteByCompany(Scanner sc) {
		System.out.println("CANCEL ALL COMPANY ROOMS RENT \n Enter the name of the company");
		String search=sc.nextLine();
		String message="";
		boolean exist=dataCenter.messageDeleteByCompany(search);
		if (exist==true) {
			System.out.println("Are you sure to delete all rents of: "+search+" \n 1. Yes \n 2. No");
			int sel=sc.nextInt();
			sc.nextLine();
			if (sel==1) {
				message=dataCenter.deleteByCompany(search);
			}
			else message="Ok. Comming back";	
		}
		System.out.println(message);
	}
	/**
	 * Method name: showMap <br>
	 * The method shows a map of the mini-rooms on or off <br>
	 */
	public static void showMap() {
		String message=dataCenter.showMap();
		System.out.println("DATACENTER MAP \n x: off \n o: on");
		System.out.println(message);
	}
	
	
	/**
	 * Method name: showMap <br>
	 * The method shows a map of the all mini-rooms on <br>
	 */
	public static void simulateOn() {
		String message=dataCenter.simulateOnMap();
		System.out.println("SIMULATE ON \n x: off \n o: on");
		System.out.println(message);
	}
	
	/**
	 * Method name: showMap <br>
	 * The method shows a map of some mini-rooms off <br>
	 */
	public static String simulateOff(Scanner sc) {
		String message;
		 System.out.println("SIMULATE OFF \n x: off \n o: on \n Letter L: turn off the first mini-quarters of all runners, along with the mini-quarters of the first runner.\n" + 
		 		"Letter Z: turn off the mini-quarters of the first and last runner, along with the mini-quarters of the reverse diagonal.\n" + 
		 		"Letter H: turn off the mini-rooms located in the odd-numbered corridors\n" + 
		 		"Letter O: turn off the mini-rooms located in the windows\n" + 
		 		"Letter M: Select a Column to turn off \n" + 
		 		"Letter P: turn off the mini-rooms of a corridor");
		 String sel=sc.nextLine();
		 if (sel.equalsIgnoreCase("m")) {
			System.out.println("Enter a column to turn off (1-50)");
			int column=sc.nextInt();
			sc.nextLine();
			return message=dataCenter.simulateOff(sel,column);
		 } 
		 
		 if (sel.equalsIgnoreCase("p")) {
			 System.out.println("Enter a corrier to turn off (1-8)");
			 int corrier=sc.nextInt();
			 sc.nextLine();
			 return message=dataCenter.simulateOff(sel, corrier);
		}
		 else return message=dataCenter.simulateOff(sel,0);
	}
}