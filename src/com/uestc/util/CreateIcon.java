package com.uestc.util;

import java.net.URL;

import javax.swing.ImageIcon;

import com.uestc.view.LoginOnFrame;

//作用：读取图片
public class CreateIcon {
	
	public static ImageIcon add(String ImageName){
		URL IconUrl = LoginOnFrame.class.getResource("/"+ImageName);//这里的/是指buildpath，即设定的编译的.class文件根目录
		ImageIcon icon=new ImageIcon(IconUrl);
		return icon;
	}
	
}
