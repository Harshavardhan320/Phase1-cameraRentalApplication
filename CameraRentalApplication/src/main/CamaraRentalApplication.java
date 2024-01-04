package main;

public class CamaraRentalApplication {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("|====================================================================|");
		System.out.println("|WELCOME          TO         CAMERA           RENTAL         APP     |");
		System.out.println("|====================================================================|");
		Methods camara = new Methods();
		if(camara.login()) {
			camara.DisplayMenu();
		}else {
			System.out.println("Enter Username and password");
		}
	}
}
