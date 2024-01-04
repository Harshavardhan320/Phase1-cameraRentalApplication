package wallet;

import exception.InSufficientAmount;

public class Wallet {
	//amount
	private int amount = 500;
	
	//adding amount to wallet
	public void addamount(int a) {
		amount +=a;
		System.out.println("Amount Added To Your Wallet "+amount);
	}
	
	//reduce amount from the Wallet
	public boolean reduceamount(int a) throws InSufficientAmount {
		if(a>amount) {
			throw new InSufficientAmount("In sufficient Amount In Your Wallet "+amount);
		}else {
			amount -=a;
			System.out.println("Total Amount "+amount);	
			return true;
			
		}
	}
	
	public int DisplayAmount() {
		return amount;
	}
}
