package isp.lab5.exercise1;

public class Bank {

    private Account[] accounts=new Account[10];

    public Bank(Account[] accounts){
        for (int i=0; i< accounts.length; i++){
            this.accounts[i]=accounts[i];
        }
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public String executeTransaction(Transaction t){

        return t.execute();
    }

    public Account getAccountByCardId(String CardId) {
        for (int i=0; i<10;i++){
            if (accounts[i].getCard().getCardId().equals(CardId)) return accounts[i];
        }
        return null;
    }


}
