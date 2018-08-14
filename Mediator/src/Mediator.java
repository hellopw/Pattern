import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by lenovo on 2018/8/14.
 */
abstract class Person{

    int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    String name;
    String sex;
    int age;
    public Person(String name,String sex,int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String state;

    /**
     *
     * @param p    约会对象
     * @param m    中介所
     */
    public abstract void SetMeeting(Person p,AbstractMediator m);
    public abstract void SetClaim(String sex,int x,int y,AbstractMediator m);

}

class Male extends Person{

    public Male(String name, String sex, int age) {
        super(name, "male", age);
    }

    @Override
    public void SetMeeting(Person p,AbstractMediator m) {
        System.out.println("i want to meet "+p.getID());
        this.setState("约会中");
        m.arrangeMeet(p);
    }

    @Override
    public void SetClaim(String sex,int x,int y,AbstractMediator m) {
        System.out.println("i want to meet the person which age is between "+x+" , "+y);
        this.setState("约会中");
        m.search_arrangeMeet(sex,x,y);
    }

}
class Female extends Person{

    public Female(String name, String sex, int age) {
        super(name, "female", age);
    }

    @Override
    public void SetMeeting(Person p,AbstractMediator m) {
        System.out.println("i want to meet "+p.getID());
        this.setState("约会中");
        m.arrangeMeet(p);
    }

    @Override
    public void SetClaim(String sex,int x,int y,AbstractMediator m) {
        System.out.println("i want to meet the person which age is between "+x+" , "+y);
        this.setState("约会中");
        m.search_arrangeMeet(sex,x,y);
    }

}

abstract class AbstractMediator {

    protected HashSet<Person> lac;

    public void addAbstractColleague(Person a){
        if(lac == null){
            lac = new HashSet();
        }
        lac.add(a);
    }

    /**
     * 中介行为   安排约会
     * @param a  引起变化的对象，触发改变
     */
    public abstract void arrangeMeet(Person a);
    public abstract void search_arrangeMeet(String sex,int x,int y);

}

class Mediator extends AbstractMediator {

    @Override
    /**
     * 定义*10操作
     */
    public void arrangeMeet(Person a) {
        Iterator<Person> c = lac.iterator();
        while(c.hasNext()){
            Person b = c.next();
            if(b == a){
                b.setState("约会中");
                break;
            }
        }
    }

    @Override
    public void search_arrangeMeet(String sex,int x,int y) {
        Iterator<Person> c = lac.iterator();
        while(c.hasNext()){
            Person b = c.next();
            if(b.sex.equals(sex) && b.getAge()>x && b.getAge()<y ){
                b.setState("约会中");
            }
        }
    }

}