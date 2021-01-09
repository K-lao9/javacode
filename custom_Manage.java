package Food;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class custom_Manage extends JDialog implements ActionListener {
    JMenu cm=new JMenu("请选择你需要的操作：");
    JButton cm1=new JButton("食品信息查询");
    JButton cm2=new JButton("退出登录");
    JButton cm3=new JButton("购买");
    public custom_Manage(){
        this.setTitle("请选择你需要的操作：");
        this.setLayout(null);
        cm1.setBounds(34, 33, 142, 23);
        this.add(cm1);
        cm2.setBounds(197, 33, 97, 23);
        this.add(cm2);
        cm3.setBounds(34, 99, 97, 23);
        this.add(cm3);
        this.setVisible(true);
        this.setBounds(10, 10, 390, 330);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        cm1.addActionListener(this);
        cm2.addActionListener(this);
        cm3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==cm1)new SetGoods().setVisible(true);
        else if(e.getSource()==cm2)	this.setVisible(false);
        else if(e.getSource()==cm3)new BuyGoods().setVisible(true);
    }
}