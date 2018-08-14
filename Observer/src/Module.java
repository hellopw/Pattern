import javax.swing.*;
import java.awt.*;

/**
 * Created by lenovo on 2018/8/14.
 */
class Module extends Subject{
    public void setMess(String s){
        notifyall(s);
    }

}

class View extends JPanel implements Observer{

    JTextArea show = new JTextArea();

    public View(){
        init();
    }
    public void init(){
        this.setBounds(10,10,375,250);  //使用的前提是母容器的布局是null
        this.setBackground(Color.cyan);

        show.setBackground(Color.green);
        show.setEditable(false);

        this.setLayout(null);
        show.setBounds(30,30,320,200);     //50是相对的，相对于this也就是panel，并不是frame
        add(show);

    }

    @Override
    public void update(Object o) {
        show.append((String) o);
        show.append("\n");
    }
}
