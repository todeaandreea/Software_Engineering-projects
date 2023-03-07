package isp.lab5.exercise1;

public class Account {
    private String owner;
    private double balance;
    private Card card;

    public Account(String owner,double balance, Card card){
        this.owner=owner;
        this.balance=balance;
        this.card=card;
    }



    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }



}
