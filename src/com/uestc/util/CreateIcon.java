package com.uestc.util;

import java.net.URL;

import javax.swing.ImageIcon;

import com.uestc.view.LoginOnFrame;

//���ã���ȡͼƬ
public class CreateIcon {
	
	public static ImageIcon add(String ImageName){
		URL IconUrl = LoginOnFrame.class.getResource("/"+ImageName);//�����/��ָbuildpath�����趨�ı����.class�ļ���Ŀ¼
		ImageIcon icon=new ImageIcon(IconUrl);
		return icon;
	}
	
}
