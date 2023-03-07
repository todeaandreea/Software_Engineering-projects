package isp.lab5.exercise1;

import junit.framework.TestCase;

public class BankTest extends TestCase {
    public Account[] accounts;
    public Bank bank;
    public Card card;

    public void setUp() {
        card = new Card("123869U5", "4966");

        accounts = new Account[10];
        accounts[0] = new Account("Marian Lucian", 10000, card);


        bank = new Bank(accounts);
    }

    public void testGetAccountByCardId(){
        assertEquals(accounts[0],bank.getAccountByCardId("123869U5"));
    }
}
