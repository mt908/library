package library.controller;

import javax.swing.JTextField;

import library.dao.UserDao;
import library.model.User;

/**
 * 用户行为控制类，包含用户名和密码的修改
 */
public class UserAction {
    

	   /**
	    * 修改用户名密码
	    */
	    public void edit(JTextField username,JTextField passwd) throws Exception{
	    	User user = new User();
	        UserDao userdao=new UserDao();
	        userdao.updateUser(user,username.getText(),passwd.getText());
	    }
	       
	    /**
		    * 注册用户名密码
		    */
	    public void addUserInformation (JTextField jtUser,JTextField jpUsepwd) throws Exception {
		
	        UserDao userDao=new UserDao();
	        User user=new User();
	        
	        int ID = 10;	
	        user.setID(ID);
	        user.setUser(jtUser.getText());      
	        user.setUser(jpUsepwd.getText());
	        
	        //添加用户
	        userDao.addUser(user);
	    }

}
