package us.pasv.app;

public class Car {

    //инкапсулияца - сокрытие свойст и методом класса и регулирование доступами
    //посредством access уровней как public private protected default
    private String make;
    private String body;
    private int year;
    private String color;
    private String status;
    private String ownership;

    public Car (String make, String status, String ownership){
        this.make=make;
        this.status=status;
        this.ownership=ownership;
    }

    //methods

    public void age(){
        year=year+1;
    }

    //чтобы вытащить private свойства класса, нужны getter, чтобы можно было использовать
    //в других классах
    //Getters - функции, которые вызывают значения, они ничего не высчитываеют
    public String getCarMake(){
        return make;
    }

    //Setters - Для задачи значений, уже с добавлением void
    public void setColor (String value){
        //через if мы задаем условие, при котором инифиировать setter
        if (value.compareTo("red")!=0)
        color=value;
    }

    /*Отсюда вопрос, зачем специальныо создавать getter & setters, - не проще ли
    сделать уровни asscess public у свойств?
    */

    /*наследование - главный принцип программирования
    чтобы не повторять код, тчобы не писать много раз одно и тоже
    ТО етсь создаем родительский класс, общий класс, где
    эти методы и свойства будут общими для проекта или подпроекта.
    То есть делаем extends (наследуем) методы и свойства родительского (с общими свойствами)
    а уже в каждом отдельном классе добавляются индивидуальные свойства и методы,
    характерные только для этого класса.
    */

}
