package tdd_package;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class TDD_24278688 {
	
	// Testing createAccount method
	@Test
	void testCreateSuccess() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		boolean result = account.createAccount(1001, 200.0);
		assertEquals(true, result);
	}
	@Test
	void testCreateAccountDuplicated() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		account.createAccount(1001, 200.0);
		boolean result = account.createAccount(1001, 400.0);
		assertEquals(false, result);
	}
	@Test
	void testCreateAccountNegativeBalance() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		boolean result = account.createAccount(1001, -100.0);
		assertEquals(false, result);
	}
	@Test
	void testCreateAccountDuplicatedAndNegativeBalance() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		account.createAccount(1001, -100.0);
		boolean result = account.createAccount(1001, -200.0);
		assertEquals(false, result);
	}
	
	// Testing deposit method
	@Test
	void testDepositSuccess() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		account.createAccount(1001, 200);
		double result = account.deposit(1001, 400);
		assertEquals(600, result);
	}
	@Test
	void testDepositNoAccount() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		double result = account.deposit(1001, 400);
		assertEquals(-1.0, result);
	}
	@Test
	void testDepositNegativeDeposit() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		account.createAccount(1001, 200);
		double result = account.deposit(1001, -400);
		assertEquals(-1.0, result); // no implementation to handle negative deposit
	}
	@Test
	void testDepositNegativeDepositWithNoAccount() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		double result = account.deposit(1001, -400);
		assertEquals(-1.0, result);
	}
	@Test
	void testDepositZero() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		account.createAccount(1001, 200);
		double result = account.deposit(1001, 0);
		assertEquals(-3.0, result);
	}
	
	// Testing withdraw method
	@Test
	void testWithdrawSuccess() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		account.createAccount(1001, 200);
		double result = account.withdraw(1001, 50);
		assertEquals(150, result);
	}
	@Test
	void testWithdrawMoreThanBalance() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		account.createAccount(1001, 200);
		double result = account.withdraw(1001, 300);
		assertEquals(-2.0, result);
	}
	@Test
	void testWithdrawNegative() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		account.createAccount(1001, 200);
		double result = account.withdraw(1001, -50);
		assertEquals(-1.0, result);
	}
	@Test
	void testWithdrawNoAccount() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		double result = account.withdraw(1001, 50);
		assertEquals(0.0, result);
	}
	@Test 
	void testWithdrawNoMoneyNoBalance(){
		BankAccountManagementSystem_24278688 account1 = new BankAccountManagementSystem_24278688();
		BankAccountManagementSystem_24278688 account2 = new BankAccountManagementSystem_24278688();
		BankAccountManagementSystem_24278688 account3 = new BankAccountManagementSystem_24278688();
		account1.createAccount(1001, 0);
		account2.createAccount(1001, 10);
		account3.createAccount(1001, 0);
		double result1 = account1.withdraw(1001, 10);
		double result2 = account2.withdraw(1001, 0);
		double result3 = account3.withdraw(1001, 0);
		assertEquals(-3.0, result1); // returns -2.0; update: returns -3.0
		assertEquals(-3.0, result2); // returns -2.0; update: returns -3.0
		assertEquals(-3.0, result3); // returns -2.0; update: returns -3.0
	}
	
	// Testing getAccountBalance
	@Test
	void getAccountBalanceSuccess() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		account.createAccount(1001, 200);
		double result = account.getAccountBalance(1001);
		assertEquals(200, result);
	}
	@Test
	void getAccountBalanceNoAccount() {
		BankAccountManagementSystem_24278688 account = new BankAccountManagementSystem_24278688();
		double result = account.getAccountBalance(1001);
		assertEquals(0.0, result);
	}
}
