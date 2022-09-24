package library.view;

import javax.swing.*;

import library.controller.UserAction;
import library.dao.UserDao;
import library.model.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt. event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;



@SuppressWarnings("serial")
public class Register extends JFrame implements ActionListener,Runnable {
	
	UserAction useraction=new UserAction();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JTextField jtUser = new JTextField();
    JPasswordField jpUsePwd1 = new JPasswordField();
    JPasswordField jpUsePwd2 = new JPasswordField();
    JButton jbEnter = new JButton();
    JButton jbExit = new JButton();

    //设置登陆的用户名和密码

    String userID;
    String userPwd;
    public Register() {
        super("用户注册界面");
        try {
            // 设置窗体的大小、位置、可见性
            jbInit();
            this.setVisible(true);
            this.setSize(500, 400);
            this.setLocation(300,150);
            this.addWindowListener(new WindowAdapter() { // 清空内存
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    

    private void jbInit() throws Exception {
        // 初始化各控件，设置控件位置，将控件添加到面板上
        getContentPane().setLayout(null);
        jLabel1.setText("用 户 名：");
        jLabel1.setBounds(new Rectangle(100, 50, 80, 30));
        jLabel2.setText("密      码：");
        jLabel2.setBounds(new Rectangle(100, 90, 80, 30));
        jLabel3.setText("确认密码：");
        jLabel3.setBounds(new Rectangle(100, 130, 78, 30));
        jtUser.setBounds(new Rectangle(200,50,140,30));
        jpUsePwd1.setBounds(new Rectangle(200,90,140,30));
        jpUsePwd2.setBounds(new Rectangle(200,130,140,30));
        jbEnter.setBounds(new Rectangle(130,200,90,30));
        jbEnter.setText("注册");
        jbExit.setBounds(new Rectangle(240, 200, 90, 30));
        jbExit.setText("退出");
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jtUser);
        this.getContentPane().add(jpUsePwd1);
        this.getContentPane().add(jpUsePwd2);
        this.getContentPane().add(jbEnter);
        this.getContentPane().add(jbExit);

        jbEnter.addActionListener(this);
        jbExit.addActionListener(this);

    }

    //当点击按钮的时候触发下面的方法
    public void actionPerformed(ActionEvent e) {
        try{
            String command=e.getActionCommand();
            if (command.equals("退出")) {
            	this.setVisible(false);
            	new Login();
            } else {
                // 管理员登陆功能实现
                if (jtUser.getText().equals("")
                        ||new String(jpUsePwd1.getPassword()).equals("")
                        ||new String(jpUsePwd2.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(null, "请输入完整数据");
                } else {
                    if (new String(jtUser.getText())!= null
                    		&&new String(jpUsePwd1.getPassword())
                            .equals(new String(jpUsePwd2.getPassword()))
                            ) {
                    	try {
                    		useraction.addUserInformation(jtUser,jpUsePwd2);	
        					this.setVisible(false);
        					UserDao userDao=new UserDao();
							List<User> userList = userDao.query();
        					new Login();				
        				}catch(Exception e1) {
        					JOptionPane.showMessageDialog(null,"注册不成功","错误"
        							, JOptionPane.PLAIN_MESSAGE);
        				}
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "密码不一致");
                        jpUsePwd1.setText("");
                        jpUsePwd2.setText("");
                    }
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public static void main(String[] args) {
        new Register();
    }



	public void run() {
		// TODO 自动生成的方法存根
		
	}
    
}
