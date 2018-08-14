import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by lenovo on 2018/8/15.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        Subject subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), new  Class[]{Subject.class},  new DynamicProxy(realSubject));

        subject.visit();
    }
}
