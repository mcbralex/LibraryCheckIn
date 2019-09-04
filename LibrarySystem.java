//Alex Mcbride CIS340 3pm
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList <Device> deviceList = new ArrayList<Device>();
	public static void main(String[] args) {
			
		
		fillArray();
		
	    menu();
		
		
	}

	//menu method
	public static void menu() {
		try {
			
		
		do {
		System.out.println("\t\t\tLibrary Device Checkout System\n");
		int selection = 0;
		System.out.println("Please select an option 1-7\n\n1. List Devices by Title"
				+ "\n2. Add New Devices\n3. Edit a Device\n4. Search for a Device\n5. Checkout Device\n6. Check In Device\n7. Exit");
		selection = Integer.parseInt(scanner.nextLine());
		
		switch (selection){
			
		case 1: printDevices();
				break;
				
		case 2: addDevice();
				break;
		
		case 3: editDevice();
				break;
				
		case 4: search();
				break;
				
		case 5: checkout();
				break;
				
		case 6: checkin();
				break;
				
		case 7: System.out.println("GoodBye");
				System.exit(7);
		}
	
		System.out.println("\n\nPress Enter to Continue");
		
		}while ("x" != scanner.nextLine());
		}
		catch(NumberFormatException e) {
		
		}
		
	}
	
	// Print the Array list
	public static void printDevices() {
		System.out.println("Library Device List");
		System.out.println("# \t SKU \t\t Name \t\t Availability\n");
		
		for (int i = 0; i< deviceList.size(); i++) {
			Device tmpDevice = deviceList.get(i);
			
			
		System.out.printf("%-5d \t %-6s \t %-8s \t %-5s \n",i+1,tmpDevice.getSku(), tmpDevice.getName(),tmpDevice.availability());
		
		}
	}
	
	
	//adds a device to the arraylist
		public static Device addDevice() {
			
			Device tmpDevice = new Device();
			System.out.println("What is the SKU");
			
			tmpDevice.setSku(scanner.nextLine());
			System.out.println("What is the Device Name");
			
			tmpDevice.setStatus(true);
				
			tmpDevice.setName(scanner.nextLine());
			
			deviceList.add(tmpDevice);
			
			return tmpDevice;
		}
	
		
		//Edit Device Info
		public static void editDevice() {
			printDevices();
			Device tmpDevice = new Device();
			int deviceNumber = 0;
			System.out.println("Which device number would you like to edit?");
			deviceNumber = Integer.parseInt(scanner.nextLine());
		
				tmpDevice = deviceList.get(deviceNumber-1);
				
				if (deviceNumber-1 > deviceList.size()) {
					System.out.println("Invalid Number");
				}
				
				else {	System.out.println("SKU #: ");
				tmpDevice.setSku(scanner.nextLine());
				System.out.println("Name of the Device: ");
				tmpDevice.setName(scanner.nextLine());
				System.out.println("Your device has been updated");
				}
			}
		
		// search through devices 
		public static void search() {
			int counter= 0;
			System.out.print("Enter the Device You Are Searching For:");
			
			String keyword = scanner.nextLine().toLowerCase();
			String fullName = "";
			for (int i = 0 ; i< deviceList.size(); i++) {
				
				Device tmpDevice = deviceList.get(i);
				
				fullName = tmpDevice.getName().toLowerCase();
				
				if ( fullName.contains(keyword)){
				System.out.printf("\n%d \t %s \t %s \t %s",i+1,tmpDevice.getSku(), tmpDevice.getName(),tmpDevice.availability());
				counter =counter++;
				}
				
			}
			if (counter == 0)
				System.out.println("\nItem does not exist");
		}
			
	
		
	
			//checkout method
		public static void checkout() {
			int deviceNumber;
			Device tmpDevice = new Device();
			System.out.println("Devices Available for Checkout");
			System.out.println("# \t SKU \t\tName \t\t\n");
			
			for (int i = 0; i< deviceList.size(); i++) {
				 tmpDevice = deviceList.get(i);
				
				if (tmpDevice.getStatus()== true) {
			System.out.printf("%d \t %s \t %s\n",i+1,tmpDevice.getSku(), tmpDevice.getName());
				}
			}
			System.out.println("\nSelect the Device You Would Like to Checkout: ")	;
			
			deviceNumber = Integer.parseInt(scanner.nextLine());
		
			if (deviceNumber-1 > deviceList.size()) {
				System.out.println("Invalid Number");
			}
			
			else {	tmpDevice = deviceList.get(deviceNumber-1);
				
			  if (tmpDevice.getStatus() == false) {
				System.out.println("This device is already checked out");
				}
				  else {
				tmpDevice.setStatus(false);;
					System.out.println("Your Device is Checked Out");
				}
			}
			
		}
		
		//checkin method
	public static void checkin() {
		int deviceNumber;
		Device tmpDevice = new Device();
		System.out.println("Devices Currently Checked Out");
		System.out.println("# \t SKU \t\tName \t\t\n");
		
		for (int i = 0; i< deviceList.size(); i++) {
			 tmpDevice = deviceList.get(i);
			
			if (tmpDevice.getStatus()== false) {
		System.out.printf("%d \t %s \t %s\n",i+1,tmpDevice.getSku(), tmpDevice.getName());
			}
		}
		System.out.println("Select the Device You Would Like to Checkin")	;
		
		deviceNumber = Integer.parseInt(scanner.nextLine());
	
		if (deviceNumber-1 > deviceList.size()) {
			System.out.println("Invalid Number");
		}
		else { tmpDevice = deviceList.get(deviceNumber-1);
		
		if (tmpDevice.getStatus() == true) {
			System.out.println("This device is already checked in");
			}
			else {
			tmpDevice.setStatus(true);;
				System.out.println("Your Device is Checked in");
			}
		
		
		}
			
			
	}
	//fills array
		
		public static void fillArray() {
			Device device1 = new Device();
			Device device2 = new Device();
			Device device3 = new Device();
			Device device4 = new Device();
			Device device5 = new Device();
			
			device1.setName("Ipad");
			device2.setName("Google Home");
			device3.setName("Computer");
			device4.setName("Kindle");
			device5.setName("GameBoy");
			
			device1.setSku("I6454A");
			device2.setSku("87987");
			device3.setSku("654654");
			device4.setSku("19519");
			device5.setSku("357357");
			
			device1.setStatus(false);
			device2.setStatus(true);
			device3.setStatus(true);
			device4.setStatus(true);
			device5.setStatus(false);
			
			deviceList.add(device1);
			deviceList.add(device2);
			deviceList.add(device3);
			deviceList.add(device4);
			deviceList.add(device5);
			
		}
		
		
		
}
