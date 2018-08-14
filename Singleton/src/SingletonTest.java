/**
 * Created by lenovo on 2018/8/14.
 */
public class SingletonTest {
    public static void main(String args[]){
        Singleton t = Singleton.getInstance();
        t.b = "lo";
        System.out.println(t.b);
        Singleton t2 = Singleton.getInstance();
        System.out.println(t2.b);
        System.out.println(Singleton.getInstance());
        System.out.println(t);
        System.out.println(t2);
    }
}
