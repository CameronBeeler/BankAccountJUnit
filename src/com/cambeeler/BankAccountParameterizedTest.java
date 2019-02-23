package com.cambeeler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public
class BankAccountParameterizedTest
{
    private BankAccount bankAccount;
    private double amount;
    private boolean branch;
    private double expected;

    @BeforeEach
    public void setup()
    {
        bankAccount = new BankAccount("Cam", "Beeler", 1_000, BankAccount.CHECKING);
        System.out.println("Running a Parameterized Test");
    }

    private static
    Stream<Arguments> test()
    {
        return Stream.of(
                Arguments.of(100.00,    true, 1100.00),
                Arguments.of(200.00,    true, 1200.00),
                Arguments.of(325.14,    true, 1325.14),
                Arguments.of(489.33,    true, 1489.33),
                Arguments.of(1000.00,   true, 2000.00)
        );
    }

    @ParameterizedTest
    @MethodSource("test")
    void deposit(double amount, boolean branch, double expected)
    {
        bankAccount.deposit(amount, branch);
        assertEquals(expected, bankAccount.getBalance(), 0.1);
    }
}
