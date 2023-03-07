package isp.lab4.exercise6;

public class Exercise6 {
    public static void main(String[] args) {
        double s=0;

        ComissionEmployee ce=new ComissionEmployee("Andreea","Todea",4.6,2.5);
        System.out.println(ce.getPaymentAmount());

        HourlyEmployee he=new HourlyEmployee("Ion","Popescu",30.000,8.0);
        System.out.println(he.getPaymentAmount());

        SalariedEmployee se=new SalariedEmployee("Ionescu","Pop",1721);
        System.out.println(se.getPaymentAmount());

        Employee[] employees=new Employee[6];
        employees[0]=new ComissionEmployee("Andreea","Todea",4.6,2.5);
        employees[1]=new ComissionEmployee("Ioana","Marian",5.7,9.78);

        employees[2]=new HourlyEmployee("Ion","Popescu",30.000,8.0);
        employees[3]=new HourlyEmployee("Larisa","Marela",90.000,14.0);

        employees[4]=new SalariedEmployee("Ionescu","Pop",1721);
        employees[5]=new SalariedEmployee("Marisa","Pop",2895);


        for (int i=0; i<6; i++){
            s+=employees[i].getPaymentAmount();
        }
        System.out.println("Total payment: "+s);

    }
}
