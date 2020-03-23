package us.pasv.app.sub;

public class Lawer extends Employee {

        private String mDepartment;

        public Lawer (String fullName, long date, long salary, String department){
            super(fullName, date, salary);
            mDepartment=department;
        }
    }

