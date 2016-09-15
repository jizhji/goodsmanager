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



//��¼����
public class LoginOnFrame extends JFrame{
	
	
	private JTextField username;//��Ϊ�����е�GoodsResetAction��GoodsLoginAction
	private JPasswordField password;//�ڲ����еķ���Ҫ���������������Բ��ܷ��ڹ�������
	private JButton login;//��Ϊ�����һ���������ڲ���KeyAdapter������������Է����ⲿ���У������ڲ������ڵķ���Ҳ����
	
	
	//������һ��������������
	private class GoodsResetAction implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			username.setText("");
			password.setText("");
			
		}
	}
	
	//�����ڶ�������������¼
	public class GoodsLoginAction implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			
			
		}
		
	}
	
	public LoginOnFrame(){
		super();
		final BorderLayout borderlayout= new BorderLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������������ע��WindowsListener��ʹ��System exit�˳�����
		borderlayout.setVgap(10);//��������䴹ֱ���
		setTitle("�̳���������ϵͳ��¼");//���ñ���
		setLayout(borderlayout);//����LoginOnFrameΪborderlayout����
		setBounds(100,100,285,194);
		
		//�½�һ��JPanel����м�����panel����һ��ͼ��һ��������������ť��
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());//BorderLayout�Ĳ���
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));//���������ı߿�
		add(panel);//LoginOnFrame�з���panel,Ĭ���в�����Ϊû�������ģ�����ռ��
		
		//������һ��ͼ
		final JLabel tupianLabel = new JLabel();
		ImageIcon loginIcon=CreateIcon.add("loginon.jpg");
		tupianLabel.setIcon(loginIcon);
		tupianLabel.setOpaque(true);
		tupianLabel.setBackground(Color.GREEN);
		tupianLabel.setPreferredSize(new Dimension(260, 60));
		panel.add(tupianLabel, BorderLayout.NORTH);
		
		//�ڶ�������panel2����������ǩ�������ı���
		final JPanel panel_2 = new JPanel();
		final GridLayout gridLayout = new GridLayout(0, 2);//GridLayout���֣�0�У���2�У�
		gridLayout.setHgap(5);
		gridLayout.setVgap(20);
		panel_2.setLayout(gridLayout);
		panel.add(panel_2);//pannel2����panel�е�CENTERλ��
		
		//�½�һ�����û���������ǩ
		final JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(0, 0));
		label.setMinimumSize(new Dimension(0, 0));
		panel_2.add(label);
		label.setText("��  ��  ����");

		username = new JTextField(20);
		username.setPreferredSize(new Dimension(0, 0));
		panel_2.add(username);

		final JLabel label_1 = new JLabel();
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_1);
		label_1.setText("��      �룺");

		password = new JPasswordField(20);
		
		//�����Ǵ�����һ���̳�PlainDocument������࣬����д��insertString()�������Ӷ��޶������ַ���
		//PlainDocument����һ�������ļ���password�ø����������ַ��������Ҹ������ʵ�ְ�ȫ���첽���£�
		password.setDocument(new MyDocument(6));//�����6�޶������ַ�����
		password.setEchoChar('*');//���������Ļ����ַ�
		
		//ʵ��������򼤻�״̬�°��س���������login��ťģ�ⱻ����Ĺ���
		password.addKeyListener(new KeyAdapter() {//KeyAdapter�࣬�����࣬���ฺ����������¼�
			public void keyPressed(final KeyEvent e) {//������Ǹ�password����һ��������
				if (e.getKeyCode() == 10)//����س������μ������ֶ�ֵ������getKeyCode���ؼ����ֵ�������ַ���ֵ
					login.doClick();//��½��ťģ�ⱻ�����
			}
		});
		panel_2.add(password);
		
		//��������һ����������������ť������panel�϶�
		final JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		login=new JButton();//��ʼ��login
		login.addActionListener(new GoodsLoginAction());//�������ť�����һ�����������Ĺ���
		
		login.setText("��¼");
		panel_1.add(login);
		JButton reset=new JButton();
		reset.addActionListener(new GoodsResetAction());
		
		reset.setText("����");
		panel_1.add(reset);
		
		
		setVisible(true);//��ʾ
		setResizable(false);//��ֹ���Ĵ��ڴ�С
	}
	
	//������
	public static void main(String[] args){
		LoginOnFrame lof = new LoginOnFrame();
		
	}

}
