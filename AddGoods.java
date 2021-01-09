package Food;

import Dao2.DatabaseConnectionSql;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class AddGoods extends JDialog implements ActionListener {
    private JLabel JL = new JLabel("添加食品基本信息：");
    private JLabel number = new JLabel("食品编号");
    private JTextField Number = new JTextField();
    private JLabel kind=new JLabel("类别");
    private JTextField Kind=new JTextField();
    private JLabel name = new JLabel("食品名称");
    private JTextField Name = new JTextField();
    private JLabel price=new JLabel("食品价格");
    private JTextField Price = new JTextField();
    private JLabel sinventory= new JLabel("库存量");
    private JTextField Sinventory = new JTextField();
    private JTextField jt=new JTextField(10);
    private JButton Add = new JButton("添加");
    private JButton Reset = new JButton("重置");
    private JButton Exit = new JButton("退出");
    String sql = "";
    private DatabaseConnectionSql ConnectionFactory;

    public AddGoods() {
        setTitle("添加食品基本信息");
        getContentPane().setLayout(null);

        ConnectionFactory=new DatabaseConnectionSql();
        JLabel number = new JLabel("食品编号");
        number.setBounds(21, 10, 58, 15);
        getContentPane().add(number);

        Number = new JTextField();
        Number.setBounds(108, 7, 107, 21);
        getContentPane().add(Number);
        Number.setColumns(10);

        JLabel kind = new JLabel("类别");
        kind.setBounds(21, 50, 58, 20);
        getContentPane().add(kind);

        Kind= new JTextField();
        Kind.setBounds(108, 46, 107, 20);
        getContentPane().add(Kind);
        Kind.setColumns(10);

        JLabel name = new JLabel("食品名称");
        name.setBounds(21, 94, 58, 15);
        getContentPane().add(name);

        Name = new JTextField();
        Name.setBounds(108, 91, 107, 21);
        getContentPane().add(Name);
        Name.setColumns(10);

        JLabel price = new JLabel("食品价格");
        price.setBounds(21, 137, 58, 15);
        getContentPane().add(price);

        Price = new JTextField();
        Price.setBounds(108, 134, 107, 21);
        getContentPane().add(Price);
        Price.setColumns(10);

        JLabel sinventory = new JLabel("库存量");
        sinventory.setBounds(21, 191, 58, 15);
        getContentPane().add(sinventory);

        Sinventory = new JTextField();
        Sinventory.setBounds(108, 188, 106, 21);
        getContentPane().add(Sinventory);
        Sinventory.setColumns(10);

        JButton Add = new JButton("添加");
        Add.setBounds(267, 48, 97, 23);
        getContentPane().add(Add);

        JButton Reset = new JButton("重置");
        Reset.setBounds(267, 112, 97, 23);
        getContentPane().add(Reset);

        JButton Exit = new JButton("退出");
        Exit.setBounds(267, 187, 97, 23);
        getContentPane().add(Exit);
        this.setVisible(true);
        this.setBounds(10, 10, 390, 330);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        /**增加食品信息
         */
        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String snumber=Number.getText();
                String kind=Kind.getText();
                String sname=Name.getText();
                String sprice=Price.getText();
                String sinventory=Sinventory.getText();

                try {
                    Connection cot=ConnectionFactory.getConnection();
                    Statement stm=cot.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE ,ResultSet.CONCUR_UPDATABLE );
                    //int s=jcb.getSelectedIndex();
                    //String kind=null;
                    //if(s==0)kind="蔬菜";
                    //else if(s==1)kind="水果";
                    //else if(s==2)kind="肉类";
                    //else if(s==3)kind="饮料";
                    sql="insert into goods values('"+snumber+"','"+kind+"','"+sname+"','"+sprice+"','"+sinventory+"')";
                    int n=stm.executeUpdate(sql);
                    if(n!=0)JOptionPane.showMessageDialog(null,"添加成功！");
                    else JOptionPane.showMessageDialog(null,"该食品已存在！");
                }catch(Exception ee) {
                    ee.printStackTrace();
                }
            }
        });/**清除Number,Name,Price,Sinventory
         */
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Number.setText(null);
                Name.setText(null);
                Kind.setText(null);
                Price.setText(null);
                Sinventory.setText(null);
            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==Exit) {
            this.setVisible(false);
        }
    }
}