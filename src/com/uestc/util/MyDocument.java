package com.uestc.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * 功能：创建该类，继承了PlainDocument类，作为一个虚拟文件存放文本框里的字符串，
 * 重写了insertString（）方法，从而添加了限定输入字符数的功能
 * @author jizhji
 * @date： 日期：2016年9月13日 时间：上午12:53:29
 * @version 1.0
 */
public class MyDocument extends PlainDocument{
	int maxLength = 10;//设定默认字符数上限
	
	public MyDocument(int newMaxLength){//这里构造器中的参数为设定的字符数上限
		super();
		maxLength = newMaxLength;
		
	}
	
	public MyDocument(){
		this(10);
	}
	
	public void insertString(int offset,String str,AttributeSet a) throws BadLocationException{
		//如果文档中现存的字符数与待输入的字符数之和大于最大值，则返回
		if(getLength()+str.length()>maxLength)
			return;
		else {
			//否则，调用父类的insertString方法插入字符串str
			super.insertString(offset, str, a);
		}
		
	}
}
