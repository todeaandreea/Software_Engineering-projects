package isp.lab4.exercise6;

public class ComissionEmployee extends Employee{
    private double grossSales;
    private double comissonSales;

    public ComissionEmployee(String firstName,String lastName, double grossSales, double comissonSales){
        super(firstName,lastName);
        this.comissonSales=comissonSales;
        this.grossSales=grossSales;
    }


    @Override
    public double getPaymentAmount() {
        return 5.0;
    }
}
