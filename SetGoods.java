package Food;

import Dao2.DatabaseConnectionSql;

import javax.swing.*;
import javax.tools.Diagnostic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class SetGoods extends JDialog implements ActionListener {
    JLabel JL = new JLabel("请用任意一种方式查询食品", JLabel.CENTER);
    JLabel number = new JLabel("食品编号");
    JTextField Number = new JTextField();
    JLabel JClass=new JLabel("类别");
    String str[]={"蔬菜","水果","肉类","饮料"};
    JComboBox jcb=new JComboBox(str);
    JLabel name = new JLabel("食品名称");
    JTextField Name = new JTextField();
    JLabel price=new JLabel("食品价格");
    JTextField Price = new JTextField();
    JTextField jt=new JTextField(10);
    JButton Set = new JButton("查询");
    //JButton purchase = new JButton("购买");
    JButton Reset = new JButton("重置");
    JButton Exit = new JButton("退出");
    String sql = "";
    private DatabaseConnectionSql ConnectionFactory;
    public SetGoods() {
        this.setTitle("请用任意一种方式查询食品");
        this.setLayout(null);
        ConnectionFactory=new DatabaseConnectionSql();
        number.setBounds(10, 10, 58, 15);
        this.add(number);
        Number.setBounds(85, 10, 114, 21);
        this.add(Number);
        Number.setColumns(10);
        JClass.setBounds(10, 47, 58, 45);
        getContentPane().add(JClass);
        jcb.setBounds(85, 43, 34, 23);
        getContentPane().add(jcb);
        name.setBounds(10, 85, 58, 15);
        getContentPane().add(name);
        Name.setBounds(85, 82, 114, 21);
        getContentPane().add(Name);
        Name.setColumns(10);
        price.setBounds(10, 127, 58, 15);
        getContentPane().add(price);
        Price = new JTextField();
        Price.setBounds(85, 124, 114, 21);
        getContentPane().add(Price);
        Price.setColumns(10);
        Set.setBounds(25, 197, 97, 23);
        getContentPane().add(Set);
        Reset.setBounds(149, 197, 97, 23);
        getContentPane().add(Reset);
        Exit.setBounds(278, 197, 97, 23);
        getContentPane().add(Exit);
        this.setVisible(true);
        this.setBounds(10, 10, 450, 330);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        /**查询食品信息
         */
        Set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Statement stm=null;
                Connection cot;
                try{
                    cot=ConnectionFactory.getConnection();
                    stm=cot.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE ,ResultSet.CONCUR_UPDATABLE );
                    if(Number.getText()!=null)
                        sql="select * from goods where snumber='"+Number.getText()+"'";
                    else if(Name.getText()!=null)
                        sql="select * from goods where sname='"+Name.getText()+"'";
                    else if(Price.getText()!=null)
                        sql="select * from goods where sprice='"+Price.getText()+"'";

                    ResultSet rs=stm.executeQuery(sql);
                    while(rs.next()) {
                        System.out.println("食品编号: "+Number.getText());
                        int s=jcb.getSelectedIndex();
                        if(s==-1)
                            JOptionPane.showMessageDialog( null, "请选择商品类别！" );
                        else if(s==1)System.out.println("食品类别: 蔬菜");
                        else if(s==2)System.out.println("食品类别: 水果");
                        else if(s==3)System.out.println("食品类别: 肉类");
                        else if(s==4)System.out.println("食品类别: 饮料");
                        System.out.println("类别："+rs.getString("kind"));
                        System.out.println("食品名称: "+rs.getString("sname"));
                        System.out.println("价格: "+rs.getInt("sprice"));
                        System.out.println("库存量: "+rs.getInt("inventory"));
                    }
                }catch(Exception ee){
                    JOptionPane.showMessageDialog( null, "该食品不存在！" );
                    ee.printStackTrace();
                }
            }
        });
        /**清空Number，Name，Price
         */
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Number.setText(null);
                Name.setText(null);
                Price.setText(null);
            }
        });
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Set) {
            Statement stm=null;
            Connection cot;
            try{
                cot=ConnectionFactory.getConnection();
                stm=cot.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE ,ResultSet.CONCUR_UPDATABLE );
                if(Number.getText()!=null)
                    sql="select * from goods where snumber='"+Number.getText()+"'";
                else if(Name.getText()!=null)
                    sql="select * from goods where sname='"+Name.getText()+"'";
                else if(Price.getText()!=null)
                    sql="select * from goods where sprice='"+Price.getText()+"'";

                ResultSet rs=stm.executeQuery(sql);
                while(rs.next()) {
                    System.out.println("食品编号: "+Number.getText());
                    int s=jcb.getSelectedIndex();
                    if(s==0)
                        JOptionPane.showMessageDialog( null, "请选择商品类别！" );
                    else if(s==1)System.out.println("食品类别: 蔬菜");
                    else if(s==2)System.out.println("食品类别: 水果");
                    else if(s==3)System.out.println("食品类别: 肉类");
                    else if(s==4)System.out.println("食品类别: 饮料");
                    System.out.println("食品名称: "+rs.getString("name"));
                    System.out.println("价格: "+rs.getString("price"));
                    System.out.println("库存量: "+rs.getString("storage"));
                }
            }catch(Exception ee){
                JOptionPane.showMessageDialog( null, "该食品不存在！" );
                ee.printStackTrace();
            }
        }
        //else if(e.getSource()==purchase){new Purchase();}
        else if(e.getSource()==Reset){
            Number.setText(null);
            Name.setText(null);
            Price.setText(null);
        }
        else if(e.getSource()==Exit) {
            this.setVisible(false);
        }
    }

}