package datasystem;

import java.awt.EventQueue;
//消息框
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JEditorPane;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class log_in {
	
 //定义组件
	public JFrame frame;
	private JTextField label_1;
	private JTextField label_2;
	private JTextField ID;
	private JRadioButton student;
	private JRadioButton manage;
	private JButton exit;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log_in window = new log_in();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public log_in() {
		initialize();

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.getContentPane().setFont(new Font("幼圆", Font.BOLD, 18));
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.getContentPane().setLayout(null);
		
		JPanel back_1 = new JPanel();
		back_1.setBounds(0, 0, 864, 492);
		frame.getContentPane().add(back_1);
		back_1.setLayout(null);
		
		student = new JRadioButton("\u666E\u901A\u7528\u6237");

		student.setBounds(272, 125, 88, 28);
		back_1.add(student);
		student.setOpaque(false);
		student.setForeground(UIManager.getColor("Button.foreground"));
		student.setFont(new Font("宋体", Font.PLAIN, 12));
		student.setBackground(SystemColor.scrollbar);
		
		manage = new JRadioButton("\u7BA1\u7406\u7528\u6237");
		manage.setBounds(382, 126, 93, 29);
		back_1.add(manage);
		manage.setOpaque(false);
		manage.setForeground(UIManager.getColor("Button.foreground"));
		manage.setFont(new Font("宋体", Font.PLAIN, 12));
		manage.setBackground(SystemColor.scrollbar);
		
		
		
		
		
		label_1 = new JTextField();
		label_1.setBounds(276, 192, 65, 30);
		back_1.add(label_1);
		label_1.setOpaque(false);
		label_1.setBackground(new Color(240, 240, 240));
		label_1.setText("\u8D26\u53F7\uFF1A");
		label_1.setColumns(10);
		
		label_2 = new JTextField();
		label_2.setBounds(277, 233, 65, 30);
		back_1.add(label_2);
		label_2.setOpaque(false);
		label_2.setBackground(SystemColor.menu);
		label_2.setText("\u5BC6\u7801:");
		label_2.setColumns(10);
		
		ID = new JTextField();
		ID.setBounds(364, 192, 113, 27);
		back_1.add(ID);
		ID.setFont(new Font("SimSun", Font.PLAIN, 18));
		ID.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(364, 233, 113, 27);
		back_1.add(passwordField);
		passwordField.setColumns(10);
		
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(325, 293, 93, 28);
		back_1.add(btnLogIn);
		btnLogIn.setFont(new Font("幼圆", Font.BOLD, 15));
		
		JButton register = new JButton("\u6CE8\u518C");
		register.setBounds(537, 195, 70, 22);
		back_1.add(register);
		
		exit = new JButton("\u9000\u51FA");
		exit.setBounds(537, 236, 70, 22);
		back_1.add(exit);
		
		
		
		
		JLabel label = new JLabel("\u5B66\u751F\u4F1A\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("华文行楷", Font.PLAIN, 40));
		label.setBounds(219, 15, 426, 100);
		back_1.add(label);
		JLabel background = new JLabel(" ");
		background.setForeground(SystemColor.desktop);
		background.setBounds(0, 0, 864, 492);
		background.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\10.jpg"));
		back_1.add(background);
		frame.setBounds(100, 100, 886, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
//用户切换只允许选择一个模式
		student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(student.isSelected())
				{
					manage.setEnabled(false);
				}
				else if(!student.isSelected())
				{
					manage.setEnabled(true);
				}
			}
		});
		manage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manage.isSelected())
				{
					student.setEnabled(false);
				}
				else if(!manage.isSelected())
				{
					student.setEnabled(true);
				}
			}
		});

				
//登陆部分
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//判断模式
				String str=ID.getText();
				String str2 = passwordField.getText();
				if(str==null||str.equals(""))
				{
					JOptionPane.showMessageDialog(null, "账号不能为空！");
				}
				else if(str2==null||str2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "密码不能为空！");
				}
				else if(student.isSelected()&&(ID.getText()!=null)&&(passwordField.getText()!=null))
				{
					testlogin t1 =new testlogin();
					if(!t1.getuser(ID.getText()))
					{
						JOptionPane.showMessageDialog(null, "用户不存在！");
					}
					else if(!t1.getauth(ID.getText()).equals("0"))
					{
						
						JOptionPane.showMessageDialog(null, "您的权限选择错误！");
					}
					else
					{
						login1();
					}
				}
				else if(manage.isSelected()&&(ID.getText()!=null)&&(passwordField.getText()!=null))
				{
					testlogin t1 =new testlogin();
					if(!t1.getuser(ID.getText()))
					{
						JOptionPane.showMessageDialog(null, "用户不存在！");
					}
					else if(!t1.getauth(ID.getText()).equals("1"))
					{
						JOptionPane.showMessageDialog(null, "您的权限选择错误！");
					}
					else
					{
						login2();
					}
					
				}
				
				
			}
		});
		
//注册
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register r = new register();
				r.setVisible(true);
				frame.dispose();
			}
		});
		
//退出
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		
		
		
	}
	
	public void login1()
	{
		String s1 = ID.getText(),s2 = passwordField.getText();
		testlogin a = new testlogin();
//		System.out.println(s1 + a.getps(s1) + s2);
		if(s2.equals(a.getps(s1)))
		{
//			System.out.println("登陆成功！");
			frame.setVisible(false);//隐藏原来窗口
			user win1=new user(s1);
			win1.setVisible(true);
			JOptionPane.showMessageDialog(null, "登陆成功！");
			frame.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "登陆失败！");
		}
	}
	
	public void login2()
	{
		String s1 = ID.getText(),s2 = passwordField.getText();
		testlogin a = new testlogin();
//		System.out.println(s1 + a.getps(s1) + s2);
		if(s2.equals(a.getps(s1)))
		{
//			System.out.println("登陆成功！");
			frame.setVisible(false);
			manacard win1=new manacard(s1);
			win1.setVisible(true);
			JOptionPane.showMessageDialog(null, "登陆成功！");
			frame.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "登陆失败！");
		}
	}
}
