package work3;
import java.util.Scanner;
public class ExceptionTest {

	public static void main(String[] args) {
		BankAccount myAccount = new BankAccount(2000);
		myAccount.showBalance();
		System.out.print("输入操作及金额：");
		Scanner scanner = new Scanner(System.in);
		String operation;
		int temp;
		while(scanner.hasNext()) {
			operation = scanner.next();
			temp = scanner.nextInt();
			try {
				if(operation.equals("draw")) {
					myAccount.withdraw(temp);
				}else if(operation.equals("save")) {
					myAccount.deposite(temp);
				}else {
					break;
				}
			} catch (NegativeAmountException e) {
				System.out.println(e.getMessage());
			} catch (InsufficientFundsException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.print("输入操作及金额：");
			}
		}
		scanner.close();
	}

}
