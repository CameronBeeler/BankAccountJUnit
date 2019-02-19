package com.cambeeler;

public
class BankAccount
{
    private String firstName;
    private String lastName;
    private double balance;

    public static final int CHECKING =1;
    public static final int SAVINGS = 2;
    private int AccountType;

    public
    BankAccount(String firstName, String lastName, double balance, int AccountType)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        if(AccountType<1 || AccountType>2)
        {
            AccountType = 1; //default
        }
        this.AccountType = AccountType;
    }

    public double deposit(double amount, boolean branch)
    {
        if(amount < 0) return balance;
        balance += amount;
        return balance;
        // Branch argument is true if the customer is performing the transaction at a branch
        // false if a customer is performing transaction at an ATM
    }

    public double withdrawal(double amount, boolean branch)
    {
        if((amount<0) || (amount > balance))
        {
            System.out.println("requested withdrawal amount of $ "+ amount + " is outside of withdrawal boundaries");
            return balance;
        }

        balance -= amount;
        return balance;
        // Branch argument is true if the customer is performing the transaction at a branch
        // false if a customer is performing transaction at an ATM
    }

    public
    double getBalance()
    {
        return balance;
    }


    public boolean isChecking()
    {
        return (this.AccountType == CHECKING);
    }
}
