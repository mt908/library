package library.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import library.controller.BorrowAction;
import library.util.FrameOption;
import library.util.MenuBar;
import library.util.SetTableColumnCenter;

/**
 * 图书借阅窗体类
 */
public class BookBorrow {

	JFrame frame = new JFrame("图书馆");
	Container container = frame.getContentPane();
	
	
	// 表格
	JTable table;
	// 显示表格的滚动面板
	JScrollPane scrollPane;
	// 归还图书按钮
	JButton buttonReturn;
	JLabel labbookborrow=new JLabel("图 书 归 还");
	Font font = new Font("宋体", Font.PLAIN, 35);
	
	
	BorrowAction borrowAction;

	public BookBorrow() {

		frame.setLayout(null);
		
		labbookborrow.setFont(font);
		labbookborrow.setBounds(300,30,200,40);
		// 添加工具栏以及各组件和监听事件
		new MenuBar(frame);
	
		// 设置表格
		setTable();
	
		// 归还图书按钮
		buttonReturn = new JButton("归还图书");
		setButtonReturn();
		
		container.add(buttonReturn);
		container.add(scrollPane);
		container.add(labbookborrow);
		// 设置窗口大小、位置、可视、默认关闭方式等			
		new FrameOption(frame);
	}


	
	
	/**
	 * 设置归还图书按钮
	 */
	private void setButtonReturn() {
		buttonReturn.setBounds(580,390,100,25);
		buttonReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					borrowAction = new BorrowAction();
					borrowAction.BorrowBook(table);
					frame.setVisible(false);	
					new BookBorrow();
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"请先选中要归还的表格项","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}			
			}
		});
	}

	
	/**
	 * 设置表格
	 */
	private void setTable() {
		String[] columnNames = {"ID", "图书名称", "借书人姓名", "借书人电话"};	
		try {
			BorrowAction borrowAction = new BorrowAction();
			Object[][] results = borrowAction.initializTable(columnNames);
					
			table = new JTable(results,columnNames);
			new SetTableColumnCenter(table);
			scrollPane = new JScrollPane(table);
			scrollPane.setViewportView(table);
			scrollPane.setBounds(20,80,760,250);			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
