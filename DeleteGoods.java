package Food;



import Dao2.DatabaseConnectionSql;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class DeleteGoods extends JDialog implements ActionListener {

    JTextField Number = new JTextField();
    JButton Del = new JButton("删除");
    JButton Reset = new JButton("重置");
    JButton Exit = new JButton("退出");
    String sql = "";
    private DatabaseConnectionSql ConnectionFactory;
    public DeleteGoods() {
        setTitle("删除食品信息");
        getContentPane().setLayout(null);
        ConnectionFactory=new DatabaseConnectionSql();
        JLabel number = new JLabel("食品编号");
        number.setBounds(29, 32, 58, 15);
        getContentPane().add(number);

        Number = new JTextField();
        Number.setBounds(111, 29, 100, 21);
        getContentPane().add(Number);
        Number.setColumns(10);

        JButton Del = new JButton("删除");
        Del.setBounds(24, 125, 97, 23);
        getContentPane().add(Del);

        JButton Reset = new JButton("重置");
        Reset.setBounds(161, 125, 97, 23);
        getContentPane().add(Reset);

        JButton Exit = new JButton("退出");
        Exit.setBounds(287, 125, 97, 23);
        getContentPane().add(Exit);
        this.setVisible(true);
        this.setBounds(10, 10, 490, 330);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        /**删除食品信息
         */
        Del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement stm;
                Connection cot=null;
                try {
                    cot=ConnectionFactory.getConnection();

                    sql ="delete from goods where snumber='"+Number.getText()+"'";
                    stm= cot.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE ,ResultSet.CONCUR_UPDATABLE );
                    int n = stm.executeUpdate();
                    if (n!=0)
                        JOptionPane.showMessageDialog(null, "删除成功！");
                    else
                        JOptionPane.showMessageDialog(null, "删除失败！");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "该食品不存在！");
                    e1.printStackTrace();
                }
            }
        }); /**清空Number
         */
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Number.setText(null);
            }
        });
    }
    public void actionPerformed(ActionEvent e) {
        //if (e.getSource() == Del) {
        //   Statement stm=null;
        //    Connection cot=null;
        //    try {
        //        cot=ConnectionFactory.getConnection();
        //        stm= cot.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE ,ResultSet.CONCUR_UPDATABLE );
        //        sql ="delete from goods where number='"+Number.getText()+"'";
        //        int n = stm.executeUpdate(sql);
        //        if (n!=0)
        //            JOptionPane.showMessageDialog(null, "删除成功！");
        //        else
        //            JOptionPane.showMessageDialog(null, "删除失败！");
        //    } catch (SQLException e1) {
        //        JOptionPane.showMessageDialog(null, "该食品不存在！");
        //        e1.printStackTrace();
        //    }
        //}
        //if (e.getSource() == Reset) {
        //    Number.setText(null);
        //}
        if (e.getSource() == Exit)
            this.setVisible(false);
    }
}
