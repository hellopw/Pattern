/**
 * Created by lenovo on 2018/8/14.
 */
abstract class Car{
    public String shape;
    public String color;

}
class QQcar extends Car{
    public QQcar(String color){
        this.shape = "QQ";
        this.color = color;
    }
}
class XLcar extends Car{
    public XLcar(String color){
        this.shape = "XL";
        this.color = color;
    }
}
class staticFactory{
    public static Car makeCar(String shape,String color){
        switch (shape){
            case "QQ":
                return new QQcar(color);
            case "XL":
                return new XLcar(color);
            default:
                return new QQcar("blue");     //默认的是蓝色的qq
        }
    }

}