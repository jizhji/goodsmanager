package com.uestc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.uestc.util.CreateIcon;
import com.uestc.util.MyDocument;



//登录界面
public class LoginOnFrame extends JFrame{
	
	
	private JTextField username;//因为该类中的GoodsResetAction和GoodsLoginAction
	private JPasswordField password;//内部类中的方法要调用这两个，所以不能放在构造器中
	private JButton login;//因为下面的一个方法的内部类KeyAdapter会调用它，所以放在外部类中，放在内部类所在的方法也不行
	
	
	//创建第一个动作——重置
	private class GoodsResetAction implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			username.setText("");
			password.setText("");
			
		}
	}
	
	//创建第二个动作——登录
	public class GoodsLoginAction implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			
			
		}
		
	}
	
	public LoginOnFrame(){
		super();
		final BorderLayout borderlayout= new BorderLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//当调用任意已注册WindowsListener后，使用System exit退出程序
		borderlayout.setVgap(10);//设置组件间垂直间距
		setTitle("商超物流管理系统登录");//设置标题
		setLayout(borderlayout);//设置LoginOnFrame为borderlayout布局
		setBounds(100,100,285,194);
		
		//新建一个JPanel类的中间容器panel（放一张图，一个容器，两个按钮）
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());//BorderLayout的布局
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));//设置容器的边框
		add(panel);//LoginOnFrame中放入panel,默认中部，因为没有其他的，所以占满
		
		//顶部放一张图
		final JLabel tupianLabel = new JLabel();
		ImageIcon loginIcon=CreateIcon.add("loginon.jpg");
		tupianLabel.setIcon(loginIcon);
		tupianLabel.setOpaque(true);
		tupianLabel.setBackground(Color.GREEN);
		tupianLabel.setPreferredSize(new Dimension(260, 60));
		panel.add(tupianLabel, BorderLayout.NORTH);
		
		//第二个容器panel2（放两个标签，两个文本框）
		final JPanel panel_2 = new JPanel();
		final GridLayout gridLayout = new GridLayout(0, 2);//GridLayout布局（0行？，2列）
		gridLayout.setHgap(5);
		gridLayout.setVgap(20);
		panel_2.setLayout(gridLayout);
		panel.add(panel_2);//pannel2放入panel中的CENTER位置
		
		//新建一个“用户名：”标签
		final JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(0, 0));
		label.setMinimumSize(new Dimension(0, 0));
		panel_2.add(label);
		label.setText("用  户  名：");

		username = new JTextField(20);
		username.setPreferredSize(new Dimension(0, 0));
		panel_2.add(username);

		final JLabel label_1 = new JLabel();
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_1);
		label_1.setText("密      码：");

		password = new JPasswordField(20);
		
		//这里是创建了一个继承PlainDocument类的子类，并重写了insertString()方法，从而限定输入字符数
		//PlainDocument类是一个虚拟文件，password用该类放输入的字符数，并且该类可以实现安全的异步更新；
		password.setDocument(new MyDocument(6));//这里的6限定输入字符个数
		password.setEchoChar('*');//设置密码框的回显字符
		
		//实现在密码框激活状态下按回车，就做出login按钮模拟被点击的功能
		password.addKeyListener(new KeyAdapter() {//KeyAdapter类，抽象类，该类负责监听键盘事件
			public void keyPressed(final KeyEvent e) {//这里就是给password按了一个监听器
				if (e.getKeyCode() == 10)//代表回车键（参见常量字段值表）这里getKeyCode返回键入键值，不是字符键值
					login.doClick();//登陆按钮模拟被鼠标点击
			}
		});
		panel_2.add(password);
		
		//这里用了一个容器，放两个按钮，放在panel南端
		final JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		login=new JButton();//初始化login
		login.addActionListener(new GoodsLoginAction());//这里给按钮添加了一个监听动作的功能
		
		login.setText("登录");
		panel_1.add(login);
		JButton reset=new JButton();
		reset.addActionListener(new GoodsResetAction());
		
		reset.setText("重置");
		panel_1.add(reset);
		
		
		setVisible(true);//显示
		setResizable(false);//禁止更改窗口大小
	}
	
	//测试用
	public static void main(String[] args){
		LoginOnFrame lof = new LoginOnFrame();
		
	}

}
