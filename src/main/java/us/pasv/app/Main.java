package us.pasv.app;

import us.pasv.app.sub.*;

public class Main {

    public static void main(String[] args) {
        Car porshe = new Car("Cayenne","clean","dealership");
        System.out.println(porshe.getCarMake()+ " is the car make");

        //-------------------------------------
//создаем объект типа массив emps
        Employee[] emps=new Employee[3];
        emps[0]=new Doctor("Suleman", 12/02/2006, 10000,1);
       emps[1]=new Lawer( "Safiya", 22/12/2009, 123333,"fin");
       emps[2]=new Doctor("test",12/12, 32323,2);

       double totalSalary=0;
       for (int i=0; i<emps.length; i++){
           totalSalary+=emps[i].getSalary();
       }

    }
}
