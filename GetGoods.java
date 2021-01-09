package Food;

import Dao2.DatabaseConnectionSql;
import TestSP.DatabaseConnectionMysql;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class GetGoods extends JDialog implements ActionListener {
    JLabel JL = new JLabel("修改食品信息", JLabel.CENTER);
    JLabel number = new JLabel("请输入你要修改的食品编号");
    JTextField Number = new JTextField();
    JLabel massage = new JLabel("请输入你要修改的食品信息");
    JTextField Massage = new JTextField();
    JLabel afterget=new JLabel("你想要将该列信息修改为：");
    JTextField Afterget = new JTextField();
    //JTextField jt=new JTextField(10);
    JButton Get = new JButton("修改");
    JButton Reset = new JButton("重置");
    JButton Exit = new JButton("退出");
    String sql = "";
    private DatabaseConnectionSql ConnectionFactory;
    public GetGoods() {
        setTitle("修改食品信息");
        getContentPane().setLayout(null);

        ConnectionFactory=new DatabaseConnectionSql();
        JLabel number = new JLabel("请输入你要修改的食品编号");
        number.setBounds(10, 10, 250, 15);
        getContentPane().add(number);

        Number = new JTextField();
        Number.setBounds(170, 7, 103, 21);
        getContentPane().add(Number);
        Number.setColumns(10);

        JLabel massage = new JLabel("请输入修改的食品的列名");
        massage.setBounds(10, 57, 250, 15);
        getContentPane().add(massage);

        Massage = new JTextField();
        Massage.setBounds(170, 54, 103, 21);
        getContentPane().add(Massage);
        Massage.setColumns(10);

        JLabel list = new JLabel("snumber,sname,kind,sprice,inventory");
        list.setBounds(10, 78, 263, 21);
        getContentPane().add(list);

        JLabel afterget = new JLabel("你想要将该列信息修改为");
        afterget.setBounds(10, 113, 250, 15);
        getContentPane().add(afterget);

        Afterget = new JTextField();
        Afterget.setBounds(170, 110, 103, 21);
        getContentPane().add(Afterget);
        Afterget.setColumns(10);

        //jt = new JTextField();
        //jt.setText("");
        //jt.setBounds(283, 100, 66, 21);
        //getContentPane().add(jt);
        //jt.setColumns(10);

        JButton Get = new JButton("修改");
        Get.setBounds(10, 168, 97, 23);
        getContentPane().add(Get);

        JButton Reset = new JButton("重置");
        Reset.setBounds(126, 168, 97, 23);
        getContentPane().add(Reset);

        JButton Exit = new JButton("退出");
        Exit.setBounds(262, 168, 97, 23);
        getContentPane().add(Exit);
        this.setVisible(true);
        this.setBounds(10, 10, 390, 330);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        /**修改食品信息
         */
        Get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Statement stm=null;
                Connection cot=null;
                try{
                    cot=ConnectionFactory.getConnection();
                    stm=cot.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE ,ResultSet.CONCUR_UPDATABLE );
                    sql="update goods set "+Massage.getText()+"='"+Afterget.getText()+"' where snumber='"+Number.getText()+"'";
                    int n=stm.executeUpdate(sql);
                    if(n!=0)JOptionPane.showMessageDialog(null,"修改成功！");
                    else JOptionPane.showMessageDialog(null,"修改失败！");
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        });
        /**清空Number，Massage，Afterget
         */
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Number.setText(null);
                Massage.setText(null);
                Afterget.setText(null);
            }
        });
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==Get){
            Statement stm=null;
            Connection cot=null;
            try{
                cot=ConnectionFactory.getConnection();
                stm=cot.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE ,ResultSet.CONCUR_UPDATABLE );
                sql="update goods set "+Massage.getText()+"='"+Afterget.getText()+"' where number='"+Number.getText()+"'";
                int n=stm.executeUpdate(sql);
                if(n!=0)JOptionPane.showMessageDialog(null,"修改成功！");
                else JOptionPane.showMessageDialog(null,"修改失败！");
            }catch(Exception er){
                er.printStackTrace();
            }
        }
        if(e.getSource()==Reset){
            Number.setText(null);
            Massage.setText(null);
            Afterget.setText(null);
        }
        if(e.getSource()==Exit) {
            this.setVisible(false);
        }
    }
}
