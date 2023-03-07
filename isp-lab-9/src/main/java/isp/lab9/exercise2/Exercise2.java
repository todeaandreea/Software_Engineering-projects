/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp.lab9.exercise2;

import isp.lab9.exercise1.Observer;

/**
 *
 * @author Admin
 */
public class Exercise2 {
     public static void main(String[] args) {

         System.out.println("It works!");
         Sensor s1=new TemperatureSensor();
         Sensor s2=new PressureSensor();
         Sensor s3=new HumiditySensor();
        Controller controller=new Controller();

        s1.register(controller);
        s2.register(controller);
        s3.register(controller);

        s1.readSensor();
        s2.readSensor();
        s3.readSensor();
    }
}
