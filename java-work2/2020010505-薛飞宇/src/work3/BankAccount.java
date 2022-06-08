package work3;

public class BankAccount {
	int amount;
	BankAccount() {
		amount = 0;
	}
	BankAccount(int a) {
		amount = a;
	}
	void setAmount(int a) {
		amount = a;
	}
	void deposite(int dAmount) throws NegativeAmountException{
		if(dAmount<=0) {
			throw new NegativeAmountException(String.valueOf(dAmount), 0);
		}
		amount += dAmount;
		System.out.println("存入" + dAmount + "，当前余额：" + amount);
	}
	void withdraw(int dAmount) throws InsufficientFundsException,NegativeAmountException{
		if(dAmount<0) {
			throw new NegativeAmountException(String.valueOf(dAmount), 1);
		}
		if(amount-dAmount<0) {
			throw new InsufficientFundsException();
		}
		amount -= dAmount;
		System.out.println("取出" + dAmount + "，当前余额：" + amount);
	}
	void showBalance() {
		System.out.println("账户当前金额：" + amount);
	}
}
