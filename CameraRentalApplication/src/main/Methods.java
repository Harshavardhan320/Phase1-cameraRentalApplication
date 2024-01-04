package main;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import camara.Camera;
import exception.InSufficientAmount;
import wallet.Wallet;

public class Methods {
	
	private Camera cam = new Camera();
	private Wallet wall = new Wallet();
	
	/*Login Method*/
	public Boolean login() {
		
		
		Scanner Input = new Scanner(System.in);
		System.out.println("Enter The Username ");
		String username = Input.next();
		System.out.println("Enter The Password");
		String password =Input.next();
		
		
		if(username !=null && password != null) {
			return true;
		}else {
			System.out.println("Fail To Login");
			return false;
		}
	}
	
	
	/* Display the methods */
	
	
	
	public void DisplayMenu() {
		String[] optionlist = {"1. My Camera",
							"2. Rent A Camera",
							"3. View All Camera",
							"4. My Wallet",
							"5. Exit"
						};
		for(int i=0; i<optionlist.length; i++) {
			System.out.println(optionlist[i]);
			//display the list of options
		}
		
		
		int[] arr = {1,2,3,4,5};
		Scanner Input = new Scanner(System.in);
		System.out.println("Select The Option");
		int option = 0;
		try {
			option= Input.nextInt();
		}catch(InputMismatchException e) {
			System.err.println("Error Invalid Input.");
		}catch(NoSuchElementException e) {
			System.err.println("Error Invalid Input.");
		}
		//Taking input for user options
		
		
		for(int j=1; j<arr.length; j++) {
			if(j==option) {
				switch(option) {
				case 1:
					String suboption[] = {"1. Add", "2. Remove", "3. View My Camera", "4. Go To Previous Menu"};
					for(int i=0; i< suboption.length; i++) {
						System.out.println(suboption[i]);
					}
					System.out.println("Enter The option");
					int Secoundoption = 0;
					try {
						Secoundoption= Input.nextInt();
					}catch(InputMismatchException e) {
						System.err.println("Error Invalid Input");
					}
					//taking value from the user
					
					int[] aOption = {1,2,3,4};
					for(int a =1; a< aOption.length; a++) {
						if(a == Secoundoption) {
							switch(Secoundoption) {
							case 1:
								System.out.println("Enter The Id");
								int id = Input.nextInt();
								System.out.println("Enter The Brand");
								String brand =Input.next();
								System.out.println("Enter The Model");
								String Model = Input.next();
								System.out.println("Enter The Prise");
								int prise = Input.nextInt();
								String status = "Avaliable";
								cam.addCamera(id, brand, Model, prise, status);
								DisplayMenu();
								break;
							case 2:
								
								cam.ViewCameraList();
								System.out.println("Enter The Camera Id To Remove");
								int Id = Input.nextInt();
								cam.RemoveCamara(Id);
								cam.ViewCameraList();
								DisplayMenu();
								break;
							case 3:
								cam.ViewCameraList();
								DisplayMenu();
								break;
							case 4:
								DisplayMenu();
								break;
							}
						}
					}	
					DisplayMenu();
					break;
				case 2:
					cam.ViewCameraList();
					System.out.print("Enter The Camera Id ");
					int id = Input.nextInt();
					int amount =cam.rentcamera(id);
					try {
						if(amount != -1) {
							if(wall.reduceamount(amount)) {
								cam.setStatus(id);;
							}
						}else {
							System.out.println("The Camera already in rent");
						}
					} catch (InSufficientAmount e) {
						System.out.println(e.getMessage());
					}
					DisplayMenu();
					break;
				case 3:
					cam.ViewCameraList();
					DisplayMenu();
					break;
				case 4:
					String[] wallet = {"1. View Balance", "2. Add Balance", "3. Main Menu"};
					for(int a=0; a<wallet.length; a++) {
						System.out.println(wallet[a]);
					}
					int n[] = {1,2,3};
					System.out.println("Enter The Option");
					int walletoption = 0;
					try {
						walletoption = Input.nextInt();
					}catch(InputMismatchException e) {
						System.err.println("Error Input");
					}
					for(int a=1; a< n.length; a++) {
						if(walletoption == a) {
							switch(walletoption) {
							case 1:
								System.out.println("Balance amount"+ wall.DisplayAmount());
								break;
							case 2:
								System.out.println("Enter The Balence amout ");
								try {
									int addamount = Input.nextInt();
									wall.addamount(addamount);
								}catch(InputMismatchException e) {
									System.err.println("Error Input");
								}
								break;
							case 3:
								DisplayMenu();
								break;
							}
						}
					}
					DisplayMenu();
					break;
				case 5:
					System.out.println("Exit");
					return;
				}
			}
		}
		Input.close();
	}
}





