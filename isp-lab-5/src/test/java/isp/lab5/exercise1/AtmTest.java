package isp.lab5.exercise1;

import junit.framework.TestCase;

public class AtmTest extends TestCase {
    public Account[] accounts;
    public Bank bank;
    public Card card;
    public Atm atm;

    public void setUp(){

        card=new Card("9287649U5","1159");

        accounts=new Account[10];

        accounts[0]=new Account("Olimpiu Citu", 980,card);

        bank=new Bank(accounts);
        atm = new Atm(bank,card);

    }

    public void testChangePin(){
        atm.changePin("1159","1111");
        assertEquals("1111",bank.getAccountByCardId(card.getCardId()).getCard().getPin());
    }

    public void testWithdraw(){
        atm.withdraw(380.5);
        assertEquals(599.5,bank.getAccountByCardId(card.getCardId()).getBalance());
    }

    public void testInsertCard(){
        assertTrue(atm.insertCard(card,"1159"));
    }


}
