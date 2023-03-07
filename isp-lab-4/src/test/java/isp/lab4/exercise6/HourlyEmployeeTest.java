package isp.lab4.exercise6;

import junit.framework.TestCase;

public class HourlyEmployeeTest extends TestCase {
    public HourlyEmployee he;

    public void setUp(){

        he=new HourlyEmployee("Ion","Popescu",30.000,8.0);
    }

    public void testPayment(){

       assertEquals(400.0,he.getPaymentAmount());
    }
}
