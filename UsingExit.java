package Food;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UsingExit extends JFrame implements ActionListener {
    JLabel Info=new JLabel("确认退出？");
    JButton JExit=new JButton("确认");
    JButton Cancel=new JButton("取消");
    public UsingExit(){

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==JExit)
            System.exit(0);
        else if(e.getSource()==Cancel)
            setVisible(false);
    }
}
