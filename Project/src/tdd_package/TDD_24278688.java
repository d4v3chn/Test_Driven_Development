package tdd_package;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
