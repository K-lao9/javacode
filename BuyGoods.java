package Food;

import Dao2.DatabaseConnectionSql;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuyGoods extends JDialog implements ActionListener {
    JLabel JL = new JLabel("购买任意食品", JLabel.CENTER);
    JLabel number = new JLabel("食品编号");
    JTextField Number = new JTextField();
    JButton Buy = new JButton("购买");
    JButton Reset = new JButton("重置");
    JButton Exit = new JButton("退出");
    String sql = "";
    private DatabaseConnectionSql ConnectionFactory;
    public BuyGoods() {
        setTitle("购买任意食品");
        getContentPane().setLayout(null);

        JLabel number = new JLabel("食品编号");
        number.setBounds(57, 31, 71, 15);
        getContentPane().add(number);


        Number.setBounds(154, 28, 127, 21);
        getContentPane().add(Number);
        Number.setColumns(10);

        JButton Buy = new JButton("购买");
        Buy.setBounds(31, 115, 97, 23);
        getContentPane().add(Buy);

        JButton Reset = new JButton("重置");
        Reset.setBounds(184, 115, 97, 23);
        getContentPane().add(Reset);

        JButton Exit = new JButton("退出");
        Exit.setBounds(113, 183, 97, 23);
        getContentPane().add(Exit);
        this.setVisible(true);
        this.setBounds(10, 10, 390, 330);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        Buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    for(int i=1;i<=10000;i++){

                    }
                }catch(Exception ee){
                    JOptionPane.showMessageDialog( null, "该食品已卖完！" );
                    ee.printStackTrace();
                }
            }
        });
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Number.setText(null);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Buy){

            try {

                for(int i=1;i<=10000;i++){
                    
                }
            }catch(Exception ee){
                JOptionPane.showMessageDialog( null, "该食品已卖完！" );
                ee.printStackTrace();
            }
        }
        if(e.getSource()==Exit) {
            this.setVisible(false);
        }
    }
}
