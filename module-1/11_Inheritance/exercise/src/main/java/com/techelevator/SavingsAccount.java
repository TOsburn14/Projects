package com.techelevator;

public class SavingsAccount extends BankAccount{
    public SavingsAccount (String accountHolderName,String accountNumber, int balance ){
        super(accountHolderName,accountNumber,balance);
    }
    public SavingsAccount (String accountHolderName, String accountNumber){
        super(accountHolderName,accountNumber);
    }



    @Override
    public int withdraw (int amountToWithdraw){
        int afterWithdrawBalance = super.getBalance() - amountToWithdraw;
        if (afterWithdrawBalance >= 150){
            super.withdraw(amountToWithdraw);
            return afterWithdrawBalance;
        } else if (afterWithdrawBalance >= 2) {
            super.withdraw(amountToWithdraw + 2);

        }
        return getBalance();
    }


}
