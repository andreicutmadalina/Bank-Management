package validator;

import exceptions.InsufficientMoneyException;
import entity.BankAccount;

public class WithdrawValidator {

    public static void validateWithdraw(BankAccount account, double amount) throws InsufficientMoneyException{

       if(account.getBalance() < amount)
           throw  new InsufficientMoneyException("Insufficient money.");

    }
}
