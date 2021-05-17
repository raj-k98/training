import com.trg.bank.Account;
import com.trg.bank.SavingsAccount;
import com.trg.bank.exceptions.AccountCreateException;
import com.trg.bank.exceptions.InsufficientBalnceException;
import com.trg.bank.exceptions.InvalidDepositException;

public class AccountMain {

	public static void main(String[] args) {

		try {
			Account act = new SavingsAccount(100, "Ramana", 2500);
			System.out.println(act);
			act.withdraw(1000);

			System.out.println(act);

			act.deposit(10);
			


		} catch (AccountCreateException e) {
			System.out.println(e.getMessage());
		} catch (InsufficientBalnceException e) {
			System.out.println(e.getMessage());
		}

		catch (InvalidDepositException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Program complete");

	}

}
