package com.cambeeler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest
{

    @Test
    void deposit()
    {
        BankAccount camAccount = new BankAccount("Cameron", "Beeler", 1_000.0, 2);
        double balance = camAccount.deposit(200.00, true);
        double variance = 0;
        assertEquals(1_200, balance, variance);
        balance = camAccount.deposit(-200.0, false);
        assertEquals(1_200, balance, variance);
    }

    @Test
    void withdrawal()
    {
        BankAccount camAccount = new BankAccount("Cameron", "Beeler", 950.0, 1);
        double balance = camAccount.withdrawal(750.0, true);
        double variance = 0;
        assertEquals(200, balance);
        balance = camAccount.withdrawal(500, false);

    }

    @Test
    void getBalance_deposit()
    {
        double variance = 0.03;
        double balance = 1250.37;
        BankAccount camsAccount = new BankAccount("Cameron", "Beeler", balance, 1);
        balance = camsAccount.deposit(175.98, false);
        assertEquals(balance, camsAccount.getBalance(), variance);
    }

    @Test
    void getBalance_withdrawal()
    {
        double variance = 0.03;
        double balance = 1250.37;
        BankAccount camsAccount = new BankAccount("Cameron", "Beeler", balance, 1);
        balance = camsAccount.withdrawal(250.73, false);
        assertEquals(balance, camsAccount.getBalance(), variance);
    }

    @Test
    void imaFailedTest()
    {
        fail("because that is in my nature");
    }

    @Test
    void isCheckingTest()
    {
        double balance = 2237.85;
        BankAccount ba = new BankAccount("Cam", "Beeler", balance, 0);
        BankAccount ba2 = new BankAccount("Cam", "Beeler", balance, 3);
        BankAccount ba3 = new BankAccount("Cam", "Beeler", balance, 1);
        BankAccount ba4 = new BankAccount("Cam", "Beeler", balance, 2);

        assertEquals(true, (ba.isChecking()));
        assertEquals(true, (ba2.isChecking()));
        assertEquals(true, (ba3.isChecking()));
        assertEquals(false, (ba4.isChecking()));
    }

}