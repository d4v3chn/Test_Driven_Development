package tdd_package;

import java.util.HashMap;
import java.util.Map;

public class BankAccountManagementSystem_24278688 {

    private Map<Integer, Double> accounts;

    public BankAccountManagementSystem_24278688() {
        this.accounts = new HashMap<>();
    }

    public boolean createAccount(int accountNumber, double initialBalance) {
       

        if(accounts.containsKey(accountNumber) || initialBalance < 0 ) { 
            return false;
        }

        accounts.put(accountNumber, initialBalance);

        return true;
    }

    public double deposit(int accountNumber, double amount) {

        if (!accounts.containsKey(accountNumber) || amount < 0) { // p-use for accountNumber & amount
            return -1.0;
        }else if (amount == 0) { // p-use for amount
        	return -3.0; // Can't deposit 0;
        }

        double balance = accounts.get(accountNumber); // Definition of balance
        balance += amount; // c-use of amount, definition of balance
        accounts.put(accountNumber, balance); // Definitions of accounts
        return balance; // c-use of balance
    }

    public double withdraw(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            return 0.0;
        }

        double balance = accounts.get(accountNumber);

        if (amount == 0 || balance == 0){ 

            return -3.0; // Can't withdraw 0;

        }else if (amount < 0) { // Changed from <= to <
            
            return -1.0;
            
        } else  if (amount > balance) { // Changed from >= to >
               
            return -2.0;

        }

        balance -= amount;
        accounts.put(accountNumber, balance);
        return balance;
    }

    public double getAccountBalance(int accountNumber) {
    	if (!accounts.containsKey(accountNumber)) {
    		return 0.0;
    	}
    
        double balance = 0;

        balance = accounts.get(accountNumber);

        return balance;
    }

    
}