import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.HashSet;


/**
 * Created by lenovo on 2018/8/14.
 */

/**
 * 观察者类   一个更新方法
 * param o  待更新值
 */
interface  Observer{
    public void update(Object o);
}

/**
 * 被观察者类  需要维护一个observe的链表
 *
 */
abstract class Subject{
    private HashSet<Observer> observers;


    /**
     * 添加一个观察者
     * @param o
     */
    public void attach(Observer o){
        if(observers == null){
            observers = new HashSet<>();
        }
        observers.add(o);
    }
    public void deattch(Observer o){
        observers.remove(o);
    }

    public void notifyall(String com){
        for(Observer k:observers)
            k.update(com);
    }
    public void notifyone(Observer o,String com){
        for(Observer k:observers){
            if(k.equals(o)){
                k.update(com);
            }
        }
        //o.update(com); //这样写是不对的，因为set中维护的才是真实存在仆人，传进来的是新建的，不是同一个对象
    }

}

/**
 *主人是被观察者
 */
class Master extends Subject{
    //命令所有人
    public void comAll(String com) {
        notifyall(com);
    }
    //命令某个人
    public void comOne(Observer o,String com) {
        notifyone(o,com);
    }
}

/**
 * 仆人是观察者
 */
class Servant implements Observer{

    //被观察者标识
    public int ID;
    public Servant(int a){
        this.ID = a;
    }
    //com 是命令
    //仆人接收的参数就是两个命令  rest和work
    //update 是执行命令的方法
    public void update(Object com) {
        if(com.equals("rest")){
            rest();
        }else if(com.equals("work")){
            work();
        }else if(com.equals("salary")){
            salary();
        }
    }
    /**
     * rest和work都是具体的观察者的执行方法
     * 这个根据模型不同，具体的执行方法也不同
     * 仆人一般有工作和休息两个方法
     */
    public void rest(){
        System.out.println("Servant say： ok,Servant "+ID+" will rest 30 minutes, thank you boss");
    }

    public void work(){
        System.out.println("Servant say： ooh,Servant "+ID+" have to work now");
    }

    public void salary(){
        System.out.println("Servant sa： thanks,Servant "+ID+" is coming to get my salary");
    }
}

/**
 * 管家既是一个观察者的角色，观察master
 * 又是一个被观察者的角色，被servant观察
 * 这个改一下就可以变为中介者模式    comone方法就是为中介者模式设计的
 * 中介者模式是一对一的抽象关系
 *
 */
class housekeeper extends Subject implements Observer{

    public int ID;
    public housekeeper(int s){
        this.ID = s;
    }

    //管家被观察的方法
    void comAll(String com){
        notifyall(com);
    }
    void comOne(Observer o,String s){
        notifyone(o,s);
    }

    //管家观察的方法
    public void update(Object o) {
        if(o.equals("salary")){
            System.out.println("housekeeper say: 管家要发工资了");
            comAll("salary");
        }
    }


}
