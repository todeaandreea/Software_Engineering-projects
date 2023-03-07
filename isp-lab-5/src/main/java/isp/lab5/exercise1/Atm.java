package isp.lab5.exercise1;

public class Atm {
    private Bank bank;
    private Card card;

    public Atm(Bank bank, Card card){
        this.bank=bank;
        this.card=card;
    }

    public void changePin(String oldPin, String newPin){
        String p=this.bank.getAccountByCardId(this.card.getCardId()).getCard().getPin();

        if(oldPin.equals(p)) this.bank.getAccountByCardId(this.card.getCardId()).getCard().setPin(newPin);
        else System.out.println("Your old pin is incorrect. You can't change it until you introduce your old pin correct");

    }

    public void withdraw(double amount){
        this.bank.getAccountByCardId(this.card.getCardId()).setBalance(this.bank.getAccountByCardId(this.card.getCardId()).getBalance()-amount);

    }

    public void checkMoney(){
        double b=this.bank.getAccountByCardId(this.card.getCardId()).getBalance();
        System.out.println("Money: "+b);
    }

    public boolean insertCard(Card card, String pin){
        if (pin.equals(card.getPin())) {
            this.card=card;
            return true;
        }
        return false;
    }

    public void removeCard(){
        this.card=null;
    }


    public Transaction createTransaction1(){return new ChangePin();
    }
    public Transaction createTransaction2(){
        return new WithdrawMoney();
    }
    public Transaction createTransaction3(){
      return new CheckMoney();
    }

}
