package us.pasv.app.sub;

//наследование - расширение функционала дописанием к родительскому
public class Doctor extends Employee {
    private int mCategory;

    public Doctor (String fullName, long date, long salary, int category){
        super(fullName, date, salary);
        mCategory=category;
    }

    @Override
    /*тут и происходит полиморфизм
    то есть наследуя от другого класса методы и свойства,
    бывает есть нужда чуть подправить изменить метод под наследующий метод.
    Тогда, берем метод, переписываем со 100% точностб и просто в теле операции,
    дорабатываем так, как нам надо, не меняя названия самого геттера.
     */
    public double getSalary(){
        return mSalary*1.2;
    }
}




