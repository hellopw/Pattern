import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lenovo on 2018/8/15.
 */

interface Subject {
    void visit();
}
class RealSubject implements Subject{
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void visit() {
        System.out.print(name);
    }
}

public class DynamicProxy implements InvocationHandler {

    private Object object;
    public DynamicProxy(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling method");
        Object o = method.invoke(object,args);
        System.out.println("after calling method");
        return o;
    }
}
