package isp.lab5.exercise1;

public class ChangePin extends Transaction {
    private String cardId;
    private String pin;



    public String execute(){
        return "Change pin operation";
    }
}
