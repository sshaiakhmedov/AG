package us.pasv.app;

public class Employee {
    private String mFullName;
    private long mEmploymentDate;
    private long mSalary;

    //constructor
    Employee (String fullName, long date, long salary){
        mFullName=fullName;
        mEmploymentDate=date;
        mSalary=salary;
    }

    //Getter

    public double getSalary (){
        return mSalary;
    }
}
