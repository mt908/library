package library.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import library.controller.UserAction;
import library.util.BackgroundImage;
import library.util.FrameOption;
import library.util.KeyListener;
import library.util.MenuBar;

/**
 * 更改用户信息界面类
 */
@SuppressWarnings("serial")
public class ChangeUserInformation extends JFrame {
	
	JFrame frame = new JFrame("图书馆");
	Container container = frame.getContentPane();
	
	private JTextField textFieldUserName = new JTextField();
	private JTextField textFieldPasswd = new JTextField();
	private JButton buttonYes = new JButton("确认");
	private JButton buttonReset = new JButton("重置");
	JLabel labFieldUserName=new JLabel("新 用 户 名:");
	JLabel labFieldPasswd=new JLabel("新 密 码:");
	JLabel labchangeuser=new JLabel("修 改 信 息");
	Font font = new Font("宋体", Font.PLAIN, 35);
	
	public ChangeUserInformation() {

		frame.setLayout(null);
		
		
		labchangeuser.setFont(font);
		labchangeuser.setBounds(300,30,200,40);
		labFieldUserName.setBounds(280,145,200,30);
		labFieldPasswd.setBounds(280,235,200,30);
		// 设置背景图片
		new BackgroundImage(frame,container,"");
		// 添加工具栏以及各组件和监听事件
		new MenuBar(frame);
		
		// 用户名框
		setUserTextField();
		// 密码框
		 setPasswordField();
		// 确认按钮
		setButtonYes();
		// 重置按钮
		setButtonReset();
		
	
		container.add(textFieldPasswd);
		container.add(textFieldUserName);
		container.add(buttonReset);
		container.add(buttonYes);
		container.add(labchangeuser);
		container.add(labFieldUserName);
		container.add(labFieldPasswd);
		
		
		// 设置窗口大小、位置、可视、默认关闭方式等
		new FrameOption(frame);
	}

	
	
	/**
	 * 设置重置按钮
	 */
	private void setButtonReset() {
		buttonReset.setBounds(450,325,90,30);
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textFieldUserName.setText("");
				textFieldPasswd.setText("");
			}
		});
	}

	
	/**
	 * 设置确认按钮，添加操作数据库更改用户名密码事件
	 */
	public void setButtonYes(){
		buttonYes.setBounds(280,325,90,30);
		buttonYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				UserAction userAction = new UserAction();			
				try {
					userAction.edit(textFieldUserName,textFieldPasswd);
					JOptionPane.showMessageDialog(null,"用户名和密码修改成功","成功"
							,JOptionPane.PLAIN_MESSAGE);
					frame.setVisible(false);
					new Login();
				}catch(Exception e1) {
					e1.printStackTrace();
				}		
			}
		});
	}

	/**
	 * 设置密码框
	 */
	public void setPasswordField() {
		textFieldPasswd.setBounds(380,235,200,30);
		new KeyListener(textFieldPasswd,buttonYes);
	}

	/**
	 * 用户框
	 */
	public void setUserTextField() {
		textFieldUserName.setBounds(380,145,200,30);
		new KeyListener(textFieldUserName,buttonYes);
	}


}
