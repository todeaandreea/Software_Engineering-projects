package isp.lab6.exercise1;



public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("Test implementation here.");
        SensorReadingList srl=new SensorReadingList();


        SensorReading sr1=new SensorReading(5,"La mare",Type.HUMIDITY);
        SensorReading sr2=new SensorReading(15,"Alba Iulia",Type.HUMIDITY);
        SensorReading sr3=new SensorReading(10,"Paris",Type.PRESSURE);
        SensorReading sr4=new SensorReading(28,"Paris",Type.PRESSURE);
        srl.addReading(sr1);
        srl.addReading(sr2);
        srl.addReading(sr3);
        srl.addReading(sr4);

        System.out.println("Average value by type is: "+srl.getAvarageValueByType(Type.HUMIDITY,"La mare"));


        System.out.println("Sensor readings by type are: "+srl.getReadingsByType(Type.HUMIDITY).toString());

        srl.listSortedByLocation();
        srl.listSortedByValue();

        System.out.println("Sensor readings by type and location are: "+srl.findAllByLocationAndType("Paris",Type.PRESSURE).toString());
    }
}
