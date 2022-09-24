package library.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import library.controller.BookAction;
import library.util.BackgroundImage;
import library.util.FrameOption;
import library.util.LimitTextLength;
import library.util.MenuBar;
import library.util.SetTableColumnCenter;


/**
 * 图书信息管理界面类
 * 
 * @author 1651200111 陈彦志
 */
@SuppressWarnings("serial")
public class BookInformation extends JFrame {
	
	JFrame frame = new JFrame("图书馆书屋");
	Container container = frame.getContentPane();
	
	
	// 增加、删除、修改按钮
	JButton buttonAdd, buttonDel, buttonChange,buttonReset,buttonborrow; 
	
	JLabel labFieldID,labFieldISBN, labFieldBookName, labFieldPrice, labFieldAuthor;
	JLabel labFieldPublishedHouse, labFieldBookCategory;
	JLabel labFieldBorrowName, labFieldBorrowPhone;
	
	// ID、ISBN、图书名称、图书价格、图书作者文本框
	JTextField textFieldID,textFieldISBN, textFieldBookName, textFieldPrice, textFieldAuthor;
	// 出版社、图书分类号、借书人姓名文本框
	JTextField textFieldPublishedHouse, textFieldBookCategory;
	// 借书人姓名、借书人电话
	JTextField textFieldBorrowName, textFieldBorrowPhone;
	
	// 表格
	JTable table;
	// 显示表格的滚动面板
	JScrollPane scrollPane;
	
	BookAction bookAction;
	
	public BookInformation()  {

		frame.setLayout(null);
		
		// 设置背景图片
		new BackgroundImage(frame,container,"");
		// 添加工具栏以及各组件和监听事件
		new MenuBar(frame);
		
		bookAction = new BookAction();
		
		// ID文本框
		textFieldID = new JTextField();
		setTextFieldID();	
		// ISBN文本框
		textFieldISBN = new JTextField();
		setTextFieldISBN();		
		// 图书名称文本框
		textFieldBookName = new JTextField();
		setTextFieldBookName();
		// 图书价格文本框
		textFieldPrice = new JTextField();
		setTextFieldBookPrice();
		// 图书作者文本框
		textFieldAuthor = new JTextField();
		setTextFieldAuthor();
		// 出版社文本框
		textFieldPublishedHouse = new JTextField();
		setTextFieldPublishedHouse();	
		// 图书分类号文本框
		textFieldBookCategory = new JTextField();
		setTextFieldBookCategory();	
		// 借书人姓名文本框
		textFieldBorrowName = new JTextField();
		setTextFieldBorrowName();
		// 借书人电话文本框
		textFieldBorrowPhone = new JTextField();
		setTextFieldBorrowPhone();
		
		labFieldID=new JLabel("ID");
		labFieldID.setBounds(50,312,140,23);
		labFieldISBN=new JLabel("ISBN");
		labFieldISBN.setBounds(50,280,140,23);
		labFieldBookName = new JLabel("图书名称");
		labFieldBookName.setBounds(278,280,140,23);
		labFieldPrice=new JLabel("图书价格");
		labFieldPrice.setBounds(50,340,140,23);
		labFieldAuthor=new JLabel("图书作者");
		labFieldAuthor.setBounds(512,280,140,23);
		labFieldPublishedHouse=new JLabel("出版社");
		labFieldPublishedHouse.setBounds(278,340,140,23);
		labFieldBookCategory=new JLabel("图书分类号");
		labFieldBookCategory.setBounds(512,340,140,23);
		labFieldBorrowName=new JLabel("借书人姓名");
		labFieldBorrowName.setBounds(278,312,140,23);
		labFieldBorrowPhone=new JLabel("借书人电话");
		labFieldBorrowPhone.setBounds(512,312,140,23);
		
		// 设置窗体表格
		setTable();
		
		// 增加按钮
		buttonAdd = new JButton("增加");
		setButtonAdd();	
		// 删除按钮
		buttonDel = new JButton("删除");
		setButtonDel();		
		// 修改按钮
		buttonChange = new JButton("修改");
		setButtonChange();	
		// 重置按钮
		buttonReset = new JButton("重置");
		setButtonReset();
		// 借书按钮
		buttonborrow = new JButton("借书");
		setButtonborrow();	
	
		container.add(scrollPane);
		
		container.add(buttonAdd);
		container.add(buttonDel);
		container.add(buttonReset);
		container.add(buttonChange);
		container.add(buttonborrow);
		
		container.add(textFieldID);
		container.add(textFieldISBN);
		container.add(textFieldBookName);
		container.add(textFieldAuthor);
		container.add(textFieldPrice);
		container.add(textFieldBookCategory);
		container.add(textFieldPublishedHouse);
		container.add(textFieldBorrowName);
		container.add(textFieldBorrowPhone);
		
		container.add(labFieldID);
		container.add(labFieldISBN);
		container.add(labFieldBookName);
		container.add(labFieldAuthor);
		container.add(labFieldPrice);
		container.add(labFieldBookCategory);
		container.add(labFieldPublishedHouse);
		container.add(labFieldBorrowName);
		container.add(labFieldBorrowPhone);

		// 设置窗口大小、位置、可视、默认关闭方式等
		new FrameOption(frame);
	}


	
	
	
	/**
	 * 设置ISBN文本框
	 */
	private void setTextFieldISBN() {
		// 限制文本框长度为17
		textFieldISBN.setDocument(new LimitTextLength(17));
		textFieldISBN.setBounds(120,280,140,23);
	}
	
	/**
	 * 设置图书名称文本框
	 */
	private void setTextFieldBookName() {
		textFieldBookName.setBounds(348,280,140,23);
	}
	
	/**
	 * 设置图书作者文本框
	 */
	private void setTextFieldAuthor() {
		textFieldAuthor.setBounds(582,280,140,23);
	}
	
	/**
	 * 设置图书ID
	 */
	private void setTextFieldID() {
		textFieldID.setBounds(120,312,140,23);
	}
	
	/**
	 * 设置借书人姓名文本框
	 */
	private void setTextFieldBorrowName() {
		textFieldBorrowName.setBounds(348,312,140,23);
	}

	/**
	 * 设置借书人电话文本框
	 */
	private void setTextFieldBorrowPhone() {
		textFieldBorrowPhone.setBounds(582,312,140,23);
	}
	
	/**
	 * 设置图书分类号文本框
	 */
	private void setTextFieldBookCategory() {
		textFieldBookCategory.setBounds(582,340,140,23);
	}


	/**
	 * 设置出版社文本框
	 */
	private void setTextFieldPublishedHouse() {
		textFieldPublishedHouse.setBounds(348,340,140,23);
	}


	/**
	 * 设置图书价格文本框
	 */
	private void setTextFieldBookPrice() {
		textFieldPrice.setBounds(120,340,140,23);
	}

	/**
	 * 设置修改按钮
	 */
	private void setButtonChange() {
		buttonChange.setBounds(180,390,60,25);
		//buttonChange.setIcon(new ImageIcon("res/button_change.jpg"));
		buttonChange.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {	
				try {
					bookAction.changeBookInformation(textFieldID,textFieldISBN, textFieldBookName
							,textFieldPrice, textFieldAuthor, textFieldPublishedHouse
							, textFieldBookCategory, textFieldBorrowName, textFieldBorrowPhone);		
					frame.setVisible(false);
					new BookInformation();				
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"表中没有该数据","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
	}




	/**
	 * 设置删除按钮
	 */
	private void setButtonDel() {
		buttonDel.setBounds(300,390,60,25);
		//buttonDel.setIcon(new ImageIcon("res/button_del.jpg"));
		buttonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					bookAction.delBookInformation(table);
					frame.setVisible(false);	
					new BookInformation();
				} catch(Exception e1) {
					e1.printStackTrace();
				}			
			}
		});
	}

	/**
	 * 设置文本框重置按钮
	 */
	private void setButtonReset() {
		buttonReset.setBounds(60,390,60,25);
		//buttonReset.setIcon(new ImageIcon("res/button_textReset.jpg"));
		buttonReset.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textFieldID.setText("");
				textFieldBookName.setText("");
				textFieldAuthor.setText("");
				textFieldISBN.setText("");
				textFieldPrice.setText("");
				textFieldBookCategory.setText("");
				textFieldPublishedHouse.setText("");
				
			}
		});
	}

	/**
	 * 设置文本框借书按钮
	 */
	private void setButtonborrow() {
		buttonborrow.setBounds(540,390,60,25);
		//buttonborrow.setIcon(new ImageIcon("res/button_change.jpg"));
		buttonborrow.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				if(textFieldBorrowName.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"借书人姓名不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				
				else if(textFieldBorrowPhone.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"借书人电话不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else {
					try {
						bookAction.changeBookInformation(textFieldID,textFieldISBN, textFieldBookName
								,textFieldPrice, textFieldAuthor, textFieldPublishedHouse
								, textFieldBookCategory, textFieldBorrowName, textFieldBorrowPhone);		
						frame.setVisible(false);
						new BookInformation();				
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"表中没有该数据","错误"
								, JOptionPane.PLAIN_MESSAGE);
					}
				}

			}
		});
	}

	/**
	 * 设置添加按钮
	 */
	private void setButtonAdd() {
		buttonAdd.setBounds(420,390,60,25);
		//buttonAdd.setIcon(new ImageIcon("res/button_add.jpg"));
		buttonAdd.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(textFieldID.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"ID不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				
				else if(textFieldISBN.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"ISBN号不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
					
				else if(textFieldISBN.getText().length() != 17) {	
					JOptionPane.showMessageDialog(null,"ISBN号位数必须是13位","错误"
							, JOptionPane.PLAIN_MESSAGE);	
				}
				else if(textFieldBookName.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "图书名称不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
					
				else if(textFieldAuthor.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "图书作者不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textFieldPrice.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "图书价格不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textFieldPublishedHouse.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "出版社不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textFieldBookCategory.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "图书分类号不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textFieldPrice.getText().length() > 4) {
					JOptionPane.showMessageDialog(null, "图书价格不能超过4位数", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else {
					try {
						bookAction.addBookInformation(textFieldID,textFieldISBN, textFieldBookName, textFieldPrice,textFieldAuthor
								,textFieldPublishedHouse,textFieldBookCategory,textFieldBorrowName,textFieldBorrowPhone, table);		
						frame.setVisible(false);	
						new BookInformation();
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			
			}
		});
	}


	/**
	 * 设置窗体表格
	 */
	private void setTable() {
		String[] columnNames = {"ID", "图书名称","图书作者","图书价格(元)","ISBN"
				,"出版社","分类号", "借书人姓名", "借书人电话"
				};	
		try {
			BookAction bookAction = new BookAction();
			Object[][] results = bookAction.initializTable(columnNames);
		
			table = new JTable(results,columnNames);
			// 设置表格字段居中
			new SetTableColumnCenter(table);
			scrollPane = new JScrollPane(table);
			scrollPane.setViewportView(table);
			scrollPane.setBounds(20,80,760,190);			
			table.addMouseListener(new MouseListener() {			
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub			
				}			
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub	
				}				
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub					
				}				
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub					
				}			
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					String ID,ISBN,  bookName, price, author;
					String publishedHouse, category, borrowName, borrowPhone;
					
					int selRow = table.getSelectedRow();
			
					bookName = table.getValueAt(selRow, 1).toString();
					author = table.getValueAt(selRow, 2).toString();
					price = table.getValueAt(selRow, 3).toString();
					ISBN = table.getValueAt(selRow, 4).toString();
					publishedHouse = table.getValueAt(selRow, 5).toString();
					category = table.getValueAt(selRow, 6).toString();
					
					if (table.getValueAt(selRow, 7).toString() == null) {
						borrowName = "";
					}
					else {
						borrowName = table.getValueAt(selRow, 7).toString();
					}
					
					if (table.getValueAt(selRow, 8).toString() == null) {
						borrowPhone = "";
					}
					else {
						borrowPhone = table.getValueAt(selRow, 8).toString();
					}
					ID = table.getValueAt(selRow, 0).toString();
					
					
					textFieldBookName.setText(bookName);
					textFieldAuthor.setText(author);
					textFieldPrice.setText(price);
					textFieldISBN.setText(ISBN);
					textFieldPublishedHouse.setText(publishedHouse);
					textFieldBookCategory.setText(category);
					textFieldBorrowName.setText(borrowName);
					textFieldBorrowPhone.setText(borrowPhone);
					textFieldID.setText(ID);
					
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
