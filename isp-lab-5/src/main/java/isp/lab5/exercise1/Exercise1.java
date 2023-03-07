package isp.lab5.exercise1;


import java.util.ArrayList;
import java.util.Scanner;


public class Exercise1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Card card1=new Card("123869U5","4966");
        Card card2=new Card("425669U5","2398");
        Card card3=new Card("9287649U5","1159");

        Account[] accounts=new Account[10];
        accounts[0]=new Account("Marian Lucian", 10000,card1);
        accounts[1]=new Account("Lucia Mirel", 379,card2);
        accounts[2]=new Account("Olimpiu Citu", 980,card3);

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
        }
    }





