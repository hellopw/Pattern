/**
 * Created by lenovo on 2018/8/14.
 */
public class FactoryTest {
    //简单工厂模式测试  也叫静态工厂模式
    public static void main1(String[] args) {
        Car c1 = staticFactory.makeCar("QQ","red");
        Car c2 = staticFactory.makeCar("XL","Yellow");
        System.out.println(c1.shape+" "+c1.color);
        System.out.println(c2.shape+" "+c2.color);
    }
    //测试普通工厂模式
    public static void main(String[] args) {
        Factory f = new TVfactory();
        TV tv = (TV) f.produce();
        Factory f2 = new Watchfactory();
        Watch watch = (Watch) f2.produce();

        System.out.println(tv.name);
        System.out.println(watch.name);

    }

}
