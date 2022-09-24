package library.util;

import javax.swing.ImageIcon;

/**
 * 指定路径加载图片
 */
public class CreateImage {
	
	public static ImageIcon add(String ImageName) {	
		// 加载图片
		ImageIcon icon= new ImageIcon("res/" + ImageName);	
		return icon;
	}
	

}
