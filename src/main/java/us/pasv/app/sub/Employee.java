package us.pasv.app.sub;
//нельзя наслеждоваться от 2х классов, -у каждого один родитель
//в Java отказались от этого иначе будет проблема ромбовидного наследования.
//Однако можно создавать дерево наследования (лучше не более 5)

public class Employee {
    //инициализцая свойств (чтобы потом можно их использовать в конструкторе)
    private String mFullName;
    private long mEmploymentDate;
    protected long mSalary;

    //constructor
    Employee (String fullName, long date, long salary){
        mFullName=fullName;
        mEmploymentDate=date;
        mSalary=salary;
    }

    //Getter

    public double getSalary(){
        return mSalary;
    }


}
