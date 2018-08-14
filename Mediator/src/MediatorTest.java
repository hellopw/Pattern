/**
 * Created by lenovo on 2018/8/14.
 */
public class MediatorTest {

    public static void main(String[] args){
        Person male1 = new Male("h","dfg",24); male1.setState("单身");
        Person male2 = new Male("y","dfg",23);male2.setState("单身");
        Person female2 = new Female("l","dfg",22);female2.setState("单身");
        Person female1 = new Female("o","dfg",21);female1.setState("单身");


        AbstractMediator am = new Mediator();
        am.addAbstractColleague(male1);
        am.addAbstractColleague(male2);
        am.addAbstractColleague(female2);
        am.addAbstractColleague(female1);

        System.out.println(male1.getState()+"  "+male2.getState()+"  "+female1.getState()+"  "+female2.getState());
//      male1.SetMeeting(female1,am);
        male1.SetClaim("female",20,25,am);
        System.out.println(male1.getState()+"  "+male2.getState()+"  "+female1.getState()+"  "+female2.getState());

    }
}