package cap.gemini;

public class Account {

	private int accountNo;
	private String name;
	private float balance;

	public static String bankName = "ICICI Bank";

	public static String getBankName() {
		return bankName;
	}

	public Account(int accountNo, String name, float balance) {

		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}

	public void deposit(float amt) {
		if (amt >= 100)
			balance = balance + amt;
		else
			System.out.println("Deposit less than 100 not accepted");
	}

	public void withdraw(float amt) {
		if (balance - amt > 1000)
			balance = balance - amt;
		else
			System.out.println("Balance not available");
	}

	public void showDetails() {
		System.out.println("Account Number: " + this.accountNo);
		System.out.println("Name: " + name);
		System.out.println("Balance: " + balance);
	}

}
