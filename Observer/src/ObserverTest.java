import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by lenovo on 2018/8/14.
 */
public class ObserverTest {

    /**
     * 测试master-servant类型
     * @param args
     */
    public static void main1(String[] args) {
        Master m = new Master();
        Servant s1 = new Servant(1);
        Servant s2 = new Servant(2);
        housekeeper h = new housekeeper(3);

        m.attach(s1);
        m.attach(s2);
        m.attach(h);

        h.attach(s1);
        h.attach(s2);

        //首先rest
        System.out.println("master say: 你们可以休息了");
        m.comAll("rest");
        //然后work
        System.out.println("master say: 现在S1去工作");
        m.comOne(s1,"work");
        //主人通知管家发工资
        System.out.println("master say: 管家把这个月工资发了吧");
        m.comOne(h,"salary");
    }

    /**
     * 测试module-view类型
     * @param args
     */
    public static void main(String[] args) {
        Module m = new Module();
        View v = new View();
        m.attach(v);

        JFrame f = new JFrame() ;
        f.setLocationRelativeTo(null);
        f.setSize(400,300);
        //f.setLayout(new BorderLayout());
        //f.add("Center", v);
        f.setLayout(null);
        f.add(v);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);    //大小不可变


        Scanner in = new Scanner(System.in);
        while(true){
            String s = in.next();
            m.setMess(s);
        }



    }
}
