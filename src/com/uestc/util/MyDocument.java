package com.uestc.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * ���ܣ��������࣬�̳���PlainDocument�࣬��Ϊһ�������ļ�����ı�������ַ�����
 * ��д��insertString�����������Ӷ�������޶������ַ����Ĺ���
 * @author jizhji
 * @date�� ���ڣ�2016��9��13�� ʱ�䣺����12:53:29
 * @version 1.0
 */
public class MyDocument extends PlainDocument{
	int maxLength = 10;//�趨Ĭ���ַ�������
	
	public MyDocument(int newMaxLength){//���ﹹ�����еĲ���Ϊ�趨���ַ�������
		super();
		maxLength = newMaxLength;
		
	}
	
	public MyDocument(){
		this(10);
	}
	
	public void insertString(int offset,String str,AttributeSet a) throws BadLocationException{
		//����ĵ����ִ���ַ������������ַ���֮�ʹ������ֵ���򷵻�
		if(getLength()+str.length()>maxLength)
			return;
		else {
			//���򣬵��ø����insertString���������ַ���str
			super.insertString(offset, str, a);
		}
		
	}
}
