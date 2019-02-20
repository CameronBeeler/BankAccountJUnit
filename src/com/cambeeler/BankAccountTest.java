package com.cambeeler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest
{
    private BankAccount camAccount;
    private static int testMethodCounter=0;

    @BeforeAll
    public static void beforeClass()
    {
        System.out.println("This executes before any test classes");
        System.out.println(testMethodCounter++);
    }


    @BeforeEach
    public void setup()
    {
        camAccount = new BankAccount("Cameron", "Beeler", 1_000.0, BankAccount.CHECKING);
        System.out.println("Running a BankAccount test");
        System.out.println(testMethodCounter++);

    }

    @Test
    void deposit()
    {
        double balance = camAccount.deposit(200.00, true);
        double variance = 0;
        assertEquals(1_200, balance, variance);
        balance = camAccount.deposit(-200.0, false);
        assertEquals(1_200, balance, variance);
        System.out.println(testMethodCounter++);
    }

    @Test
    void withdrawal()
    {
        double balance = camAccount.withdrawal(750.0, true);
        double variance = 0;
        assertEquals(250, balance);
        balance = camAccount.withdrawal(500, false);
        assertEquals(250, balance);
        balance = camAccount.withdrawal(-200, false);
        assertEquals(250, balance);
        System.out.println(testMethodCounter++);

    }

    @Test
    void getBalance_deposit()
    {
        double variance = 0.03;
        double balance = 1250.37;
        balance = camAccount.deposit(175.98, false);
        assertEquals(balance, camAccount.getBalance(), variance);
        System.out.println(testMethodCounter++);
    }

    @Test
    void getBalance_withdrawal()
    {
        double variance = 0.03;
        double balance = camAccount.withdrawal(250.73, false);
        assertEquals(balance, camAccount.getBalance(), variance);
        System.out.println(testMethodCounter++);
    }

    @Test
    void isCheckingTest()
    {
        assertTrue(camAccount.isChecking());

        System.out.println(testMethodCounter++);
    }

    @AfterAll
    public static void afterClass()
    {
        System.out.println("This executes after all test classes");
        System.out.println(testMethodCounter++);

    }
}