package datasystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class infor extends JFrame {

	private JPanel TV2;
//	private JTextField department;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String test="20150011";
					infor frame = new infor(test);
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
	public infor(String s1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 562);
		TV2 = new JPanel();
		TV2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(TV2);

//²éÑ¯ÐÅÏ¢		
		member s=new member();
		List<Object> list2 = new ArrayList<Object>();
		ResultSet rs2 = s.getAll(s1);//Ö÷Ï¯ÍÅ		
		list2 = s.excuteQuery(rs2);
		Map map2 = (Map)list2.get(0);
		String txt1=(String)map2.get("Sname");
		
		JTextField Sno = new JTextField();
		txt1=(String)map2.get("Sno");
		TV2.setLayout(null);
		Sno.setText(txt1);
		Sno.setBounds(104, 100, 96, 27);
		TV2.add(Sno);
		Sno.setColumns(10);
		
		JTextField name = new JTextField();
		txt1=(String)map2.get("Sname");
		name.setText(txt1);
		name.setBounds(105,150, 96, 27);
		TV2.add(name);
		name.setColumns(10);
		
		JTextField sex = new JTextField();
		txt1=(String)map2.get("Ssex");
		sex.setText(txt1);
		sex.setBounds(104, 200, 96, 27);
		TV2.add(sex);
		sex.setColumns(10);
		
		JTextField birth = new JTextField();
		txt1=(String)map2.get("Sbirth");
		birth.setText(txt1);
		birth.setBounds(104, 250, 96, 27);
		TV2.add(birth);
		birth.setColumns(10);
		
		JTextField nation = new JTextField();
		txt1=(String)map2.get("Seth");
		nation.setText(txt1);
		nation.setBounds(104, 300, 96, 27);
		TV2.add(nation);
		nation.setColumns(10);
		
		JTextField zhengzhi = new JTextField();
		txt1=(String)map2.get("Spolitical_status");
		zhengzhi.setText(txt1);
		zhengzhi.setBounds(148, 350, 96, 27);
		TV2.add(zhengzhi);
		zhengzhi.setColumns(10);
		
		JTextField zy = new JTextField();
		txt1=(String)map2.get("profession");
		zy.setText(txt1);
		zy.setBounds(322, 200, 96, 27);
		TV2.add(zy);
		zy.setColumns(10);
		
		JTextField classnum = new JTextField();
		txt1=(String)map2.get("Sclass");
		classnum.setText(txt1);
		classnum.setBounds(322, 150, 96, 27);
		TV2.add(classnum);
		classnum.setColumns(10);
		
		JTextField tel = new JTextField();
		txt1=(String)map2.get("tel");
		tel.setText(txt1);
		tel.setBounds(365, 100, 96, 27);
		TV2.add(tel);
		tel.setColumns(10);
		
		JTextField position = new JTextField();
		txt1=(String)map2.get("position");
		position.setText(txt1);
		position.setBounds(332, 250, 96, 27);
		TV2.add(position);
		position.setColumns(10);
		
		JTextField department = new JTextField();
		txt1=(String)map2.get("Dno");
		department.setText(txt1);
		department.setBounds(322, 300, 96, 27);
		TV2.add(department);
		department.setColumns(10);
		
//		
//		
		
		JLabel IF_Sno = new JLabel("\u5B66\u53F7");
		IF_Sno.setBounds(40, 100, 81, 21);
		IF_Sno.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(IF_Sno);
		
		JLabel label_7 = new JLabel("\u59D3\u540D");
		label_7.setBounds(40, 150, 81, 21);
		label_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(label_7);
		
		JLabel lblName = new JLabel("\u6027\u522B");
		lblName.setBounds(40, 200, 81, 21);
		lblName.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(lblName);
		
		JLabel label_1 = new JLabel("\u751F\u65E5");
		label_1.setBounds(40, 250, 81, 21);
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(label_1);
		
		JLabel label_2 = new JLabel("\u6C11\u65CF");
		label_2.setBounds(40, 300, 81, 21);
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(label_2);
		
		JLabel label_3 = new JLabel("\u653F\u6CBB\u9762\u8C8C");
		label_3.setBounds(40, 350, 81, 21);
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(label_3);
		
		JLabel label_4 = new JLabel("\u4E13\u4E1A");
		label_4.setBounds(250, 200, 81, 21);
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(label_4);
		
		JLabel label_5 = new JLabel("\u73ED\u7EA7");
		label_5.setBounds(250, 150, 81, 21);
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(label_5);
		
		JLabel label_6 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		label_6.setBounds(250, 100, 81, 21);
		label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(label_6);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblPosition.setBounds(250, 250, 81, 21);
		TV2.add(lblPosition);
		
		
		JLabel label_back2;
		
		JLabel label = new JLabel("\u90E8\u95E8");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label.setBounds(264, 302, 81, 21);
		TV2.add(label);
		
		
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539/\u4FDD\u5B58");
		
		btnNewButton_3.setBounds(567, 147, 123, 29);
		TV2.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.setBounds(567, 199, 123, 29);
		TV2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.setBounds(567, 275, 123, 29);
		TV2.add(btnNewButton_2);
		
//ÐÞ¸ÄÄ³Ñ§ÉúÐÅÏ¢
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				s.setSno(Sno.getText());
				s.setSname(name.getText());
				s.setSsex(sex.getText());
				s.setSbirth(birth.getText());;
				s.setSeth(nation.getText());;
				s.setSpolitical_status(zhengzhi.getText());;
				s.setProfession(zy.getText());
				s.setSclass(classnum.getText());
				s.setTel(tel.getText());;
				s.setPosition(position.getText());;
				s.setDno(department.getText());
				s.update(s);
				JOptionPane.showMessageDialog(null, "ÐÞ¸Ä³É¹¦");
			}
		});
//É¾³ýÄ³Ñ§ÉúÐÅÏ¢		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//É¾³ýÕËºÅ
				testlogin t =new testlogin();
				if(t.getuser(s1))
				{
					t.delete(s1);
				}
				s.delete(s1);
				JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦£¡");
				dispose();
				
			}
		});
//ÍË³ö½çÃæ		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
				dispose();
			}
		});
		
		
		label_back2 = new JLabel(" ");
		label_back2.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\10.jpg"));
		label_back2.setBounds(5, 5, 783, 496);
		TV2.add(label_back2);
	}

}
