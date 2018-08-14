/**
 * Created by lenovo on 2018/8/15.
 */

public class StaticProxy implements Subject{
    private Subject subject;

    public StaticProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void visit() {
        subject.visit();
    }
}
