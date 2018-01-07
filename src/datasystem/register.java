package datasystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
//ÏûÏ¢¿ò
import javax.swing.JOptionPane;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField depart;
	private JPasswordField pwdDfd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pwdDfd = new JPasswordField();
		pwdDfd.setBounds(559, 217, 127, 27);
		contentPane.add(pwdDfd);
		
		JTextField Sno = new JTextField();
		Sno.setBounds(559, 175, 127, 27);
		contentPane.add(Sno);
		Sno.setColumns(10);
		
		JTextField name = new JTextField();
		name.setBounds(105,100, 96, 27);
		contentPane.add(name);
		name.setColumns(10);
		
		JTextField sex = new JTextField();
		sex.setBounds(104, 150, 96, 27);
		contentPane.add(sex);
		sex.setColumns(10);
		
		JTextField birth = new JTextField();		
		birth.setBounds(104, 200, 96, 27);
		contentPane.add(birth);
		birth.setColumns(10);
		
		JTextField nation = new JTextField();
		nation.setBounds(104, 250, 96, 27);
		contentPane.add(nation);
		nation.setColumns(10);
		
		JTextField zhengzhi = new JTextField();
		zhengzhi.setBounds(128, 300, 96, 27);
		contentPane.add(zhengzhi);
		zhengzhi.setColumns(10);
		
		JTextField zy = new JTextField();
		zy.setBounds(345, 200, 96, 27);
		contentPane.add(zy);
		zy.setColumns(10);
		
		JTextField classnum = new JTextField();
		classnum.setBounds(322, 150, 96, 27);
		contentPane.add(classnum);
		classnum.setColumns(10);
		
		JTextField tel = new JTextField();
		tel.setBounds(322, 100, 96, 27);
		contentPane.add(tel);
		tel.setColumns(10);
		
		JTextField position = new JTextField();
		position.setBounds(345, 250, 96, 27);
		contentPane.add(position);
		position.setColumns(10);
		
		JTextField depart = new JTextField();
		depart.setColumns(10);
		depart.setBounds(322, 300, 96, 27);
		contentPane.add(depart);
		
//×¢²á
		
		
//
		
		JButton button = new JButton("\u786E\u5B9A\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//²éÑ¯ÓÃ»§ÊÇ·ñ´æÔÚ
				testlogin t1 =new testlogin();
				String s1=Sno.getText();
				String s2=pwdDfd.getText();
				if(t1.getuser(Sno.getText()))
				{
					JOptionPane.showMessageDialog(null, "ÓÃ»§ÒÑ´æÔÚ£¡");
				}
				else if(s1==null||s1.equals("")||s2.equals("")||s2==null)
				{
					JOptionPane.showMessageDialog(null, "ÓÃ»§ÕËºÅ¼°ÃÜÂë²»ÄÜÎª¿Õ£¡");
				}
				else if((Sno.getText().equals(""))||(name.getText().equals(""))||(tel.getText().equals(""))||(depart.getText().equals(""))||(position.getText().equals("")))
				{
					JOptionPane.showMessageDialog(null, "ÓÃ»§²¿·ÖÐÅÏ¢²»ÄÜÎª¿Õ£¡");
				}
				else
				{
					member a=new member();
					a.setSno(Sno.getText());;
					a.setSname(name.getText());
					a.setSsex(sex.getText());
					a.setSeth(birth.getText());
					a.setSbirth(nation.getText());
					a.setSpolitical_status(zhengzhi.getText());
					a.setSclass(classnum.getText());
					a.setProfession(zy.getText());
					a.setPosition(position.getText());
					a.setTel(tel.getText());
					a.setDno(depart.getText());
					a.insert(a);
					testlogin t2 = new testlogin(Sno.getText(),pwdDfd.getText(),"0");
					t2.insert(t2);
				}
				
				
				
			}
		});
		
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		button.setBounds(651, 370, 89, 28);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		button_1.setBounds(651, 413, 89, 28);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("\u4E2A\u4EBA\u4FE1\u606F\u6CE8\u518C");
		lblNewLabel.setBounds(5, 5, 758, 21);
		contentPane.add(lblNewLabel);
		
//		
//		
//		
//		
//		
//		
		
		JLabel IF_Sno = new JLabel("\u5B66\u53F7");
		IF_Sno.setBounds(500, 177, 81, 21);
		IF_Sno.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		contentPane.add(IF_Sno);
		
		JLabel pw = new JLabel("\u5BC6\u7801");
		pw.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		pw.setBounds(500, 217, 81, 21);
		contentPane.add(pw);
		
		JLabel label_7 = new JLabel("\u59D3\u540D");
		label_7.setBounds(40, 100, 81, 21);
		label_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		contentPane.add(label_7);
		
		JLabel lblName = new JLabel("\u6027\u522B");
		lblName.setBounds(40, 150, 81, 21);
		lblName.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		contentPane.add(lblName);
		
		JLabel label_1 = new JLabel("\u751F\u65E5");
		label_1.setBounds(40, 200, 81, 21);
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6C11\u65CF");
		label_2.setBounds(40, 250, 81, 21);
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u653F\u6CBB\u9762\u8C8C");
		label_3.setBounds(40, 300, 81, 21);
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u4E13\u4E1A");
		label_4.setBounds(250, 200, 81, 21);
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u73ED\u7EA7");
		label_5.setBounds(250, 150, 81, 21);
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		label_6.setBounds(234, 100, 81, 21);
		label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		contentPane.add(label_6);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblPosition.setBounds(250, 250, 81, 21);
		contentPane.add(lblPosition);
		
		JLabel label_back2;
		
		JLabel label_8 = new JLabel("\u90E8\u95E8");
		label_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_8.setBounds(250, 300, 81, 21);
		contentPane.add(label_8);
		label_back2 = new JLabel(" ");
		label_back2.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\10.jpg"));
		label_back2.setBounds(15, 31, 758, 439);
		contentPane.add(label_back2);
		
//ÍË³ö¼àÌý		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				log_in log = new log_in();
				dispose();

			}
		});

	}

}
