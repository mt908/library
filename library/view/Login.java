package library.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import library.dao.UserDao;
import library.model.User;
import library.util.KeyListener;
import library.util.LimitTextLength;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	private final JFrame frame = new JFrame("图书馆");
	private final Container container = frame.getContentPane();
	
	// 用户名框
	private JTextField texFieldtUserName  = new JTextField();
	// 密码框
	private JPasswordField textFieldPasswd = new JPasswordField();
	// 重置按钮
	private JButton buttonReset = new JButton("重置");
	// 登录按钮
	private JButton buttonLogin = new JButton("登录");
	//注册按钮
	private JButton buttonRegister = new JButton("注册");
	
	private JLabel labFieldtUserName=new JLabel("用户名");
	private JLabel labFieldtpaawd=new JLabel("密  码");
	JLabel lablogin = new JLabel("图书馆登录");
	
	public Login() {
		
		container.setLayout(null);
	
		
		// 设置用户名框以及监听事件
		setTextFieldUserName();
		
		// 设置密码框以及监听事件
		setPasswdField();
		
		// 设置用户名框以及监听事件
		setlabFieldUserName();
				
		// 设置密码框以及监听事件
		setlabPasswdField();
		
		// 设置登录按钮以及添加监听事件
		setButtonLogin();
		
		// 设置重置按钮以及添加监听事件
		setButtonReset();
		
		//设置注册按钮以及添加监听事件
		setButtonRegister();

		container.add(lablogin);
		container.add(texFieldtUserName);
		container.add(textFieldPasswd);
		container.add(buttonLogin);
		container.add(buttonReset);
		container.add(buttonRegister);
		container.add(labFieldtUserName);
		container.add(labFieldtpaawd);
		
		
		Font font = new Font("宋体", Font.PLAIN, 35);
		lablogin.setFont(font);
		lablogin.setBounds(220,50,200,40);
		// 设置窗口大小、位置、可视、默认关闭方式等
		frame.setVisible(true);
		// 窗口不可调整大小
		frame.setResizable(false);
		frame.setSize(550, 388);
		frame.setLocation(300,150);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
	}


	/**
	 * 设置重置按钮以及监听事件
	 */
	private void setButtonReset() {
		buttonReset.setBounds(120,280,90,30);
		buttonReset.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				texFieldtUserName.setText("");
				textFieldPasswd.setText("");
			}
		});
	}


	
	/**
	 * 设置登录按钮以及监听事件
	 */
	private void setButtonLogin() {
	
		buttonLogin.setBounds(240,280,90,30);
		buttonLogin.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent paramActionEvent) {
				// TODO Auto-generated method stub
				String username = texFieldtUserName.getText();
				String passwd = new String(textFieldPasswd.getPassword());
				UserDao userDao = new UserDao();						
				try {		   
					    List<User> userList = userDao.query();
				        for (User user : userList) {	
				        	if (user.getUser().equals(username) && user.getPasswd().equals(passwd)) {
				        		frame.setVisible(false);
				        		new MainFrame();
				        	} else if(username.equals("") || passwd.equals("")) {
				        		JOptionPane.showMessageDialog(null,"用户名或密码不能为空","错误"
										,JOptionPane.PLAIN_MESSAGE);
				        	} else {
				        		JOptionPane.showMessageDialog(null,"用户名或密码错误","错误"
										,JOptionPane.PLAIN_MESSAGE);		
				        	}
				        }			        
				}catch(Exception ex) {
					ex.printStackTrace();
				}  
			}
		});
	}

	/**
	 * 设置密码框以及添加监听事件
	 */
	private void setPasswdField() {
		// 限制用户输入长度
		textFieldPasswd.setDocument(new LimitTextLength(8));
		textFieldPasswd.setBounds(235,210,180,30);
		// 键盘事件，如果按下回车则模拟鼠标点击登录按钮
		new KeyListener(textFieldPasswd,buttonLogin);
	}
	
	private void setlabFieldUserName() {
		labFieldtUserName.setBounds(175,145,180,30);
	}
	
	private void setlabPasswdField() {
		labFieldtpaawd.setBounds(175,210,180,30);
	}


	
	/**
	 * 设置用户名框以及添加监听事件
	 */
	private void setTextFieldUserName() {
		// 限制用户输入长度
		texFieldtUserName.setDocument(new LimitTextLength(8));
		texFieldtUserName.setBounds(235,145,180,30);
		// 键盘事件，如果按下回车则模拟鼠标点击登录按钮
		new KeyListener(texFieldtUserName,buttonLogin);
	}

	//、改
	/**
	 * 设置注册按钮以及监听事件
	 */
	
	private void setButtonRegister() {
		
		buttonRegister.setBounds(360,280,90,30);
		buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent e) {
            	frame.setVisible(false);
                new Register();
            }
        });
	}
	//改


	
}
