package library.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import library.view.BookBorrow;
import library.view.BookInformation;
import library.view.ChangeUserInformation;
import library.view.Login;

/**
 * 菜单栏类，包含图书类别管理、图书信息管理、更改密码、退出系统菜单项以及进入各窗体触发事件
 */
public class MenuBar {
	
	JMenuBar menuBar;
	JMenuItem menuItemBookInformation;
	JMenuItem menuItemBorrowManage;
	JMenuItem menuItemChangUser;
	JMenuItem menuItemExit;
	
	
	public MenuBar(JFrame frame) {
		
		menuBar = new JMenuBar();
		
		// 图书信息管理菜单项
		menuItemBookInformation = new JMenuItem("图书馆管理");	 
		setMenuItemBookInformationn(frame);
	
		// 图书借阅管理菜单项
		menuItemBorrowManage = new JMenuItem("图书归还");
		setMenuItemBorrowManage(frame);
		
		// 用户信息更改菜单项
		menuItemChangUser = new JMenuItem("修改信息");
		setMenuItemChangeUser(frame);
		
		// 退出系统菜单项
		menuItemExit = new JMenuItem("退出登录");
		setMenuItemExit(frame);
			
		menuBar.add(menuItemBorrowManage);
		menuBar.add(menuItemBookInformation);
		menuBar.add(menuItemChangUser);
		menuBar.add(menuItemExit);
		
		frame.setJMenuBar(menuBar);
	}


	
	/**
	 * 设置退出系统菜单项
	 */
	private void setMenuItemExit(final JFrame frame) {
		menuItemExit.setIcon(new ImageIcon(""));
		menuItemExit.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new Login();
			}
		});
	}


	private void setMenuItemChangeUser(final JFrame frame) {
		menuItemChangUser.setIcon(new ImageIcon(""));
		menuItemChangUser.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new ChangeUserInformation();
			}
		});
	}


	private void setMenuItemBorrowManage(final JFrame frame) {
		menuItemBorrowManage.setIcon(new ImageIcon(""));
		menuItemBorrowManage.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new BookBorrow();
			}
		});
	}


	private void setMenuItemBookInformationn(final JFrame frame) {
		menuItemBookInformation.setIcon(new ImageIcon(""));
		menuItemBookInformation.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);	
				new BookInformation();
			}
		});
	}
	

}
