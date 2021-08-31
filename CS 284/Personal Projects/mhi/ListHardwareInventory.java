// Version 1.5.1, completed August 15, 2014
// Written by: Ben Rose

package mhi;

import java.util.Scanner;

public class ListHardwareInventory {

	public static void hardDrivesLaptop() {
		System.out.println("All 2.5\" SATA Hard Drives:");
		System.out.println("750GB Hard Drive: Occupied - Ben's Macbook Pro/Mac Laptop");
		System.out.println("320GB Hard Drive: Occupied - Ben's Main Server/Mac Desktop");
		System.out.println("160GB Hard Drive: Occupied - Ben's Compaq PC/PC Laptop");
		System.out.println("40GB Hard Drive: Occupied - Ben's Dell Laptop PC/PC Laptop");
		System.out.println("");
	}

	public static void solidStateDrives() {
		System.out.println("All 2.5\" SATA Solid State Drives:");
		System.out.println("None");
		System.out.println("");
	}

	public static void hardDrivesDesktop() {
		System.out.println("All 3.5\" SATA Hard Drives:");
		System.out.println("3TB Hard Drive: Occupied - Ben's Main Server/Mac Desktop");
		System.out.println("500GB Hard Drive: Unoccupied - Broken");
		System.out.println("250GB Hard Drive: Unoccupied - Broken");
		System.out.println("250GB Hard Drive: OccupiedEasyAccess - 3.5\" Hard Drive SATA to USB adapter/SATA to USB Adapters");
		System.out.println("");
	}

	public static void hardDrivesIDE() {
		System.out.println("All IDE Hard Drives:");
		System.out.println("320GB IDE Hard Drive: Occupied - Ben's Dell Tower PC/PC Desktop");
		System.out.println("40GB IDE Hard Drive: Occupied - Ben's Dell Tower PC/PC Desktop");
		System.out.println("40GB IDE Hard Drive: Occupied - Ben's Tower PC/Desktop");
		System.out.println("20GB IDE Hard Drive: Occupied - Ben's Tower PC/Desktop");
		System.out.println("1.25GB IDE Hard Drive: Occupied - Ben's '97 Toshiba Pro PC/PC Laptop");
		System.out.println("");
	}

	public static void laptopRAM() {
		System.out.println("All Laptop RAM:");
		System.out.println("4GB PC3-12800 1600MHz: Occupied - Ben's Macbook Pro/Mac Laptop");
		System.out.println("4GB PC3-12800 1600MHz: Occupied - Ben's Macbook Pro/Mac Laptop");
		System.out.println("2GB PC2-5300 667MHz: Occupied - Ben's Main Server/Mac Desktop");
		System.out.println("2GB PC2-5300 667MHz: Occupied - Ben's Main Server/Mac Desktop");
		System.out.println("1GB PC2-5300 667MHz: Occupied - Ben's Compaq PC/PC Laptop");
		System.out.println("1GB PC2-5300 667MHz: Occupied - Ben's Compaq PC/PC Laptop");
		System.out.println("1GB PC2-6800 667MHz: Occupied - Ben's Dell Laptop PC/PC Laptop");
		System.out.println("1GB PC2-6800 667MHz: Unoccupied");
		System.out.println("16MB: Occupied - Ben's '97 Toshiba Pro PC/PC Laptop");
		System.out.println("16MB: Occupied - Ben's '97 Toshiba Pro PC/PC Laptop");
		System.out.println("");
	}

	public static void desktopRAM() {
		System.out.println("All Desktop RAM:");
		System.out.println("256MB: Occupied - Ben's Dell Tower PC/PC Desktop");
		System.out.println("256MB: Occupied - Ben's Dell Tower PC/PC Desktop");
		System.out.println("256MB: Unoccupied");
		System.out.println("16MB: Occupied - Ben's Tower PC/Desktop");
		System.out.println("16MB: Occupied - Ben's Tower PC/Desktop");
		System.out.println("");
	}

	public static void motherboards() {
		System.out.println("All Motherboards NOT in any Computers:");
		System.out.println("Motherboard - Type Unknown, Taken from Dad's old Dell Tower Computer");
		System.out.println("");
	}

	public static void keyboards() {
		System.out.println("All Keyboards:");
		System.out.println("PS/2 Keyboard: Unoccupied");
		System.out.println("PS/2 Keyboard: Occupied - Ben's Tower PC/Desktop");
		System.out.println("Dell USB Keyboard: Occupied - Ben's Dell Tower PC/PC Desktop");
		System.out.println("Apple USB Keyboard: Occupied - Ben's Main Server/Mac Desktop");
		System.out.println("Microsoft Wireless USB Keyboard: Occupied - Ben's Macbook Pro/Mac Laptop");
		System.out.println("");
	}

	public static void mice() {
		System.out.println("All Mice:");
		System.out.println("PS/2 Mouse: Occupied - Ben's Dell Tower PC/PC Desktop");
		System.out.println("Microsoft USB Mouse: Occupied - Ben's Tower PC/Desktop");
		System.out.println("Microsoft Mini USB Mouse: Occupied - Ben's Main Server/Mac Desktop");
		System.out.println("Dell USB Mouse: Unoccupied");
		System.out.println("Microsoft Wireless USB Mouse: Occupied - Ben's Macbook Pro/Mac Laptop");
		System.out.println("");
	}
	public static void usbWirelessAdapters() {
		System.out.println("All USB Wireless Adapters:");
		System.out.println("NETGEAR WN111 V2 Wireless Adapter: Occupied - Ben's Dell Tower PC/PC Desktop");
		System.out.println("");
	}

	public static void usbSticks() {
		System.out.println("All USB Sticks:");
		System.out.println("32GB Silver PNY Drive: Location - Laptop Computer Case");
		System.out.println("32GB Silver PNY Drive: Location - Laptop Computer Case");
		System.out.println("8GB Silver PNY Drive: Location - Laptop Computer Case");
		System.out.println("8GB Red PNY Drive: Location - Second Desk Drawer");
		System.out.println("8GB Blue PNY Drive: Location - Second Desk Drawer");
		System.out.println("4GB \"iD Tech\" USB Drive: Location - Undefined");
		System.out.println("4GB \"Pig\" USB Drive: Location - Second Desk Drawer");
		System.out.println("2GB USB Drive: Location - Second Desk Drawer");
		System.out.println("");
	}

	public static void externalHardDrives() {
		System.out.println("All External USB Hard Drives:");
		System.out.println("2TB USB Hard Drive: Used for - Backup");
		System.out.println("1TB USB Hard Drive: Used for - Backup of Macintosh HD 4-9-14");
		System.out.println("1TB USB Hard Drive: Used for - Backup");
		System.out.println("");
	}

	public static void satatoUSBadapters() {
		System.out.println("All SATA to USB Adapters:");
		System.out.println("3.5\" USB 2.0 Adapter: Occupied - 250GB Hard Drive");
		System.out.println("2.5\" USB 3.0 Adapter: Unoccupied");
		System.out.println("");
	}

	public static void externalDVDdrives() {
		System.out.println("All External DVD Drives:");
		System.out.println("Apple External SuperDrive: Unoccupied");
		System.out.println("Targus External DVD Drive: Quantity - 1: Occupied - Ben's Main Server");
		System.out.println("");
	}

	public static void internalDVDdrives() {
		System.out.println("All Internal DVD Drives NOT in any Computers:");
		System.out.println("Apple 12.7mm PATA 8x Pioneer SuperDrive");
		System.out.println("");
	}

	public static void speakers() {
		System.out.println("All Speakers:");
		System.out.println("Logitech USB Speakers: Occupied - Ben's Macbook Pro");
		System.out.println("Dell USB and 3.5mm Headphone Jack Speakers: Unoccupied");
		System.out.println("Dell Outlet and 3.5mm Headphone Jack Speakers: Occupied - Ben's Dell Tower PC/PC Desktop");
		System.out.println("");
	}

	public static void monitors() {
		System.out.println("All Monitors:");
		System.out.println("Apple MiniDVI Monitor: Occupied - Ben's Main Server/Mac Desktop");
		System.out.println("IBM ThinkVision Monitor: Occupied - Ben's Macbook Pro/Mac Laptop");
		System.out.println("Dell Monitor: Occupied - Ben's Dell Tower PC/PC Desktop");
		System.out.println("Asus Monitor: Occupied - Ben's Tower PC/Desktop");
		System.out.println("");
	}

	public static void allPrinters() {
		System.out.println("All Printers:");
		System.out.println("Ben's Epson RX680 Printer");
		System.out.println("Mom's Epson XP-600 Printer");
		System.out.println("Rose Family's HP Laserjet Printer");
		System.out.println("");
	}

	public static void allCables() {
		System.out.println("All Cables:");
		System.out.println("FireWire 800 - 800 cable: quantity - 1: 0 occupied");
		System.out.println("FireWire 400 - 400 cable: quantity - 1: 0 occupied");
		System.out.println("Ethernet cable: quantity - 5: 1 occupied - Ben's Main Server/Mac Desktop");
		System.out.println("USB extention cable: quantity - 2: 1 occupied - Logitech USB Speakers/Speakers");
		System.out.println("USB printer cable: quantity - 3: 2 occupied - Targus DVD Drive/DVD Drives, Ben's Epson RX680 Printer/Printers");
		System.out.println("PS/2 to USB adapter: quantity - 1: 0 occupied");
		System.out.println("Thunderbolt cable: Length - 2 yards: quantity - 1: 0 occupied");
		System.out.println("VGA to VGA cable: quantity - 4: 3 occupied - Ben's Dell Tower PC/PC Desktop, Ben's Tower PC/PC Desktop, Ben's Macbook Pro/Mac Laptop");
		System.out.println("");
	}

	public static void macDesktops() {
		System.out.println("All Mac Desktops:");
		System.out.println("Ben's Main Server: iMac 2007, 20\"");
		System.out.println("");
	}

	public static void macLaptops() {
		System.out.println("All Mac Laptops:");
		System.out.println("Ben's Macbook Pro: MacBook Pro 2012, NOT Retina Display, 13.3\"");
		System.out.println("");
	}

	public static void pcDesktops() {
		System.out.println("All PC Desktops:");
		System.out.println("Ben's Dell Tower PC: Dell Tower Computer, Year Unspecified, No Internal Screen");
		System.out.println("Ben's Tower PC: Tower Computer, Year Unspecified, No Internal Screen");
		System.out.println("");
	}

	public static void pcLaptops() {
		System.out.println("All PC Laptops:");
		System.out.println("Ben's Compaq PC: Compaq Laptop Computer, Year Unspecified, Internal Screen Size Unknown");
		System.out.println("Ben's Dell Laptop PC: Dell Laptop Computer, Year Unspecified, Internal Screen Size Unknown");
		System.out.println("Ben's '97 Toshiba Pro PC: Toshiba Laptop Computer, 1997, Internal Screen Size Unknown");
		System.out.println("");
	}

	public static void hardwareList() {
		System.out.println("My Hardware:");
		System.out.println("<1> Hard Drives (SATA 2.5\")");
		System.out.println("<2> Solid State Drives (SATA 2.5\")");
		System.out.println("<3> Hard Drives (SATA 3.5\")");
		System.out.println("<4> Hard Drives (IDE)");
		System.out.println("<5> RAM (Laptop)");
		System.out.println("<6> RAM (Desktop)");
		System.out.println("<7> Motherboards");
		System.out.println("<8> Keyboards");
		System.out.println("<9> Mice");
		System.out.println("<10> USB Wireless Adapters");
		System.out.println("<11> USB Sticks");
		System.out.println("<12> External USB Hard Drives");
		System.out.println("<13> SATA to USB Adapters");
		System.out.println("<14> External DVD Drives");
		System.out.println("<15> Internal DVD Drives");
		System.out.println("<16> Speakers");
		System.out.println("<17> Monitors");
		System.out.println("<18> Printers");
		System.out.println("<19> Cables");
		System.out.println("<20> Computers (Mac Desktops)");
		System.out.println("<21> Computers (Mac Laptops)");
		System.out.println("<22> Computers (PC Desktops)");
		System.out.println("<23> Computers (PC Laptops)");
		System.out.println("<24> All Hard Drives and SSDs");
		System.out.println("<25> All RAM");
		System.out.println("<26> All Hard Drives, SSDs, and RAM");
		System.out.println("<27> All Hard Drives, SSDs, RAM and Computers");
		System.out.println("<28> All Keyboards and Mice");
		System.out.println("<29> All USB Storage-Related Devices");
		System.out.println("<30> All Hardware");
		System.out.println("<31> List All Options");
		System.out.println("<32> List Version History");
	}

	public static void currentVersion() {
		System.out.println("Version 1.5.1");
	}

	public static void listVersionHistory() {
		System.out.print("Current Version of MHI: ");currentVersion();
		System.out.println("Version 0.1: Program Started, Unfinished, in development");
		System.out.println("Version 0.2: Program Hardware Category List Complete, Program in Development");
		System.out.println("Version 0.3: Program Switch installed, Program In Development");
		System.out.println("Version 0.7: Program Switch Tested, 1/2 of program completed and tested");
		System.out.println("Version 1.0: Program Completed");
		System.out.println("Version 1.0.1: A Bit of Information added to the program, corrections made");
		System.out.println("Version 1.0.2: Separated PC Desktops, Mac Desktops, PC Laptops, and Mac Laptops");
		System.out.println("Version 1.1: Username and Password Fields added");
		System.out.println("Version 1.2: Created \"All Hardware\" Option Created Different Methods for Every Category");
		System.out.println("Version 1.2.1: Created \"All Hard Drives\" Option");
		System.out.println("Version 1.2.2: Created \"All RAM\" Option");
		System.out.println("Version 1.2.3: Created \"All Hard Drives, SSDs, and RAM\" Option");
		System.out.println("Version 1.2.4: Created \"Keyboards and Mice\" Option");
		System.out.println("Version 1.2.5: Created \"All USB Storage-Related Devices\" Option");
		System.out.println("Version 1.2.6: Created \"List All Options\" Option");
		System.out.println("Version 1.2.7: Improved \"List All Options\" Option and Hardware List");
		System.out.println("Version 1.2.8: Added \"List Version History\" Option");
		System.out.println("Verison 1.2.9: Improved \"List Version History\" Option");
		System.out.println("Version 1.3: Fixed bug where if a non-integer was typed in, the program would crash");
		System.out.println("Version 1.4: All error handling has been simplified, default case removed");
		System.out.println("Version 1.4.1: Created \"All USB Wireless Adapters\" Option");
		System.out.println("Version 1.4.2: Created \"All External DVD Drives\" Option");
		System.out.println("Version 1.4.3: Created \"All Internal DVD Drives\" Option");
		System.out.println("Version 1.4.4: Created \"All Printers\" Option");
		System.out.println("Version 1.4.5: Created \"All Cables\" Option");
		System.out.println("Version 1.5: Program Completed, Checked, and Debugged");
		System.out.println("Version 1.5.1: Added new item to program");
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String username;

		String password = "";

		System.out.println("Username: ");
		username = input.nextLine();

		if (username.equals("admin")) {
			System.out.println("Password: ");
			password = input.nextLine();

		}

		if (password.equals("rosebud")) {
			System.out.println("Continue into MHI.");
			System.out.println("");
		}

		else {
			System.out.println("Username and/or password incorrect! Please exit now.");
			// Exits program functionality if username and/or password is wrong
			System.exit(0);
		}
		int option = -1;
		currentVersion();
		System.out.println("");
		hardwareList();
		boolean wrongInput = true;

		while (option != 0) {
			System.out.println("Choose hardware item or 0 to exit and logout: ");
			//Next 14 lines perform all error handling
			do {
				try {
					option = input.nextInt();
					wrongInput = false;
					if(option < 0 || option > 32){
						System.out.println("The option you selected is not listed. Please select again.");
						System.out.println("Choose hardware item or 0 to exit and logout: ");
					}
				} catch (Exception e) {
					wrongInput = true;
					System.out.println("The option you selected is not listed. Please select again.");
					System.out.println("Choose hardware item or 0 to exit and logout: ");
					input.nextLine();
				}
			} while (wrongInput || option < 0 || option > 32);

			switch (option) {

			case 0:
				System.out.println("You have been successfully logged out. Please close program.");
				System.exit(0);
				break;
			case 1:
				hardDrivesLaptop();
				break;
			case 2:
				solidStateDrives();
				break;
			case 3:
				hardDrivesDesktop();
				break;
			case 4:
				hardDrivesIDE();
				break;
			case 5:
				laptopRAM();
				break;
			case 6:
				desktopRAM();
				break;
			case 7:
				motherboards();
				break;
			case 8:
				keyboards();
				break;
			case 9:
				mice();
				break;
			case 10:
				usbWirelessAdapters();
				break;
			case 11:
				usbSticks();
				break;
			case 12:
				externalHardDrives();
				break;
			case 13:
				satatoUSBadapters();
				break;
			case 14:
				externalDVDdrives();
				break;
			case 15:
				internalDVDdrives();
				break;
			case 16:
				speakers();
				break;
			case 17:
				monitors();
				break;
			case 18:
				allPrinters();
				break;
			case 19:
				allCables();
				break;
			case 20:
				macDesktops();
				break;
			case 21:
				macLaptops();
				break;
			case 22:
				pcDesktops();
				break;
			case 23:
				pcLaptops();
				break;
			case 24:
				hardDrivesLaptop();
				solidStateDrives();
				hardDrivesDesktop();
				hardDrivesIDE();
				break;
			case 25:
				laptopRAM();
				desktopRAM();
				break;
			case 26:
				hardDrivesLaptop();
				solidStateDrives();
				hardDrivesDesktop();
				hardDrivesIDE();
				laptopRAM();
				desktopRAM();
				break;
			case 27:
				hardDrivesLaptop();
				solidStateDrives();
				hardDrivesDesktop();
				hardDrivesIDE();
				laptopRAM();
				desktopRAM();
				macDesktops();
				macLaptops();
				pcDesktops();
				pcLaptops();
				break;
			case 28:
				keyboards();
				mice();
				break;
			case 29:
				usbSticks();
				externalHardDrives();
				satatoUSBadapters();
				break;
			case 30:
				hardDrivesLaptop();
				solidStateDrives();
				hardDrivesDesktop();
				hardDrivesIDE();
				laptopRAM();
				desktopRAM();
				motherboards();
				keyboards();
				mice();
				usbWirelessAdapters();
				usbSticks();
				externalHardDrives();
				satatoUSBadapters();
				externalDVDdrives();
				internalDVDdrives();
				speakers();
				monitors();
				allPrinters();
				allCables();
				macDesktops();
				macLaptops();
				pcDesktops();
				pcLaptops();
				break;
			case 31:
				hardwareList();
				break;
			case 32:
				listVersionHistory();
				break;

			}

		}

		input.close();

	}

}
