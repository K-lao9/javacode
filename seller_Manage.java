package Food;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class seller_Manage extends JDialog implements ActionListener {

    JButton cm1=new JButton("食品信息查询");
    JButton cm2=new JButton("增加食品");
    JButton cm3=new JButton("删除食品");
    JButton cm4=new JButton("修改食品");
    JButton cm5=new JButton("退出登录");
    public seller_Manage() {
        this.setTitle("请选择你需要的操作：");
        this.setLayout(null);
        cm1.setBounds(34, 33, 142, 23);
        this.add(cm1);
        cm2.setBounds(197, 33, 97, 23);
        this.add(cm2);
        cm3.setBounds(34, 99, 97, 23);
        this.add(cm3);
        cm4.setBounds(197, 99, 97, 23);
        this.add(cm4);
        cm5.setBounds(119, 181, 97, 23);
        this.add(cm5);
        this.setVisible(true);
        this.setBounds(10, 10, 390, 330);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        cm1.addActionListener(this);
        cm2.addActionListener(this);
        cm3.addActionListener(this);
        cm4.addActionListener(this);
        cm5.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==cm1)new SetGoods().setVisible(true);
        else if(e.getSource()==cm2)new AddGoods().setVisible(true);
        else if(e.getSource()==cm3)new DeleteGoods().setVisible(true);
        else if(e.getSource()==cm4)new GetGoods().setVisible(true);
        else if(e.getSource()==cm5)	this.setVisible(false);
    }
}