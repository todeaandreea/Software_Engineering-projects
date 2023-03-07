package isp.lab6.exercise4;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
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
     class Atm {
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
     class  Bank {

        private List<Account> accounts=new ArrayList<Account>(10);

        public Bank(List <Account> accounts){
            this.accounts=accounts;
        }

        public List <Account> getAccounts() {
            return accounts;
        }

        public String executeTransaction(Transaction t){

            return t.execute();
        }

        public Account getAccountByCardId(String CardId) {
            for(Account a:accounts){
                if (a.getCard().getCardId().equals(CardId)) return a;
            }
            return null;
        }


    }
   class Card {
        private String cardId;
        private String pin;



        public Card(String cardId, String pin){
            this.cardId=cardId;
            this.pin=pin;
        }
        public String getCardId() {
            return cardId;
        }

        public void setPin(String pin) {
            this.pin = pin;
        }

        public String getPin() {
            return pin;
        }
    }

     class ChangePin extends Transaction {
        private String cardId;
        private String pin;



        public String execute(){
            return "Change pin operation";
        }
    }


     class CheckMoney extends Transaction{
        public String execute(){
            return "Check Money operation";
        }

    }
    abstract class Transaction {
        private Account account;



        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        public abstract String execute();
    }
    class WithdrawMoney extends Transaction{
        private double amount;


        public String execute(){
            return "Withdraw Money operation";
        }

    }
public class Exercise4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Card card1=new Card("123869U5","4966");
        Card card2=new Card("425669U5","2398");
        Card card3=new Card("9287649U5","1159");

        List<Account> accounts=new ArrayList<Account>(10);

        accounts.add(new Account("Marian Lucian", 10000,card1));
        accounts.add(new Account("Lucia Mirel", 379,card2));
        accounts.add(new Account("Olimpiu Citu", 980,card3));

        Bank BCR=new Bank(accounts);



        System.out.println("Please introduce your card id: ");
        String cardId = s.nextLine();


        Atm atm = new Atm(BCR, BCR.getAccountByCardId(cardId).getCard());

        System.out.println("Please introduce your pin. You have only 3 attends! ");
        for(int i=0; i<3;i++) {
            if (i==1) System.out.println("Please reintroduce your pin: ");
            if (i==2) System.out.println("Please reintroduce your pin: ");
            String pin = s.nextLine();
            if (atm.insertCard(BCR.getAccountByCardId(cardId).getCard(), pin)) {

                while (true) {

                    System.out.println("1: Change Pin");
                    System.out.println("2: Withdraw money");
                    System.out.println("3: Check Money");
                    System.out.println("4: EXIT");
                    System.out.print("Choose the operation you want to perform:");
                    Scanner ss = new Scanner(System.in);
                    int n = ss.nextInt();
                    switch (n) {
                        case 1:
                            System.out.println(atm.createTransaction1().execute());
                            System.out.print("Please introduce your old pin: ");
                            Scanner s1 = new Scanner(System.in);
                            String oldPin = s1.nextLine();
                            System.out.print("Please introduce your new pin: ");
                            String newPin = s1.nextLine();
                            atm.changePin(oldPin, newPin);
                            System.out.println("Actual pin: " + BCR.getAccountByCardId(cardId).getCard().getPin());
                            break;

                        case 2:
                            System.out.println(atm.createTransaction2().execute());
                            Scanner s2 = new Scanner(System.in);
                            System.out.print("Please introduce the amount you want to withdraw: ");
                            double amount = s2.nextDouble();
                            atm.withdraw(amount);
                            System.out.println("Actual balance: " + BCR.getAccountByCardId(cardId).getBalance());
                            break;

                        case 3:
                            System.out.println(atm.createTransaction3().execute());
                            atm.checkMoney();
                            break;

                        case 4:
                            atm.removeCard();
                            System.exit(0);
                    }
                }

            } else

                System.out.println("The pin is incorrect :(");
        }
    }}
