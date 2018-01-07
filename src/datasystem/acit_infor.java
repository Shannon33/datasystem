package datasystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class acit_infor extends JFrame {

	private JPanel TV2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						String sid="001";
						acit_infor frame = new acit_infor(sid);
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
	public acit_infor(String s1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 562);
		TV2 = new JPanel();
		TV2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(TV2);


		TV2.setLayout(null);
		
	
		
		JLabel aid = new JLabel("\u6D3B\u52A8ID");
		aid.setBounds(40, 100, 81, 21);
		aid.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(aid);
		
		
		JLabel label_back2;
		
		JLabel adate = new JLabel("\u6D3B\u52A8\u4E3B\u9898");
		adate.setBounds(40, 150, 81, 21);
		adate.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(adate);
		
		JLabel aname = new JLabel("\u6D3B\u52A8\u65E5\u671F");
		aname.setBounds(40, 200, 81, 21);
		aname.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(aname);
		
		JLabel label = new JLabel("\u6D3B\u52A8\u8D5E\u52A9");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label.setBounds(297, 150, 81, 21);
		TV2.add(label);
		
		JLabel acontent = new JLabel("\u6D3B\u52A8\u660E\u7EC6");
		acontent.setBounds(40, 250, 81, 21);
		acontent.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		TV2.add(acontent);
		
		JLabel label_1 = new JLabel("\u6D3B\u52A8\u627F\u529E");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_1.setBounds(297, 200, 81, 21);
		TV2.add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 286, 470, 194);
		TV2.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(152, 98, 96, 27);
		TV2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 148, 96, 27);
		TV2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(152, 198, 96, 27);
		TV2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(393, 148, 96, 27);
		TV2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(393, 198, 96, 27);
		TV2.add(textField_4);
		textField_4.setColumns(10);
		
		
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539/\u4FDD\u5B58");
		btnNewButton_3.setBounds(567, 117, 123, 29);
		TV2.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.setBounds(567, 199, 123, 29);
		TV2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.setBounds(567, 275, 123, 29);
		TV2.add(btnNewButton_2);
		
//===========²éÑ¯ÐÅÏ¢================
		activity s =new activity();
		List<Object> list1 = new ArrayList<Object>();
		ResultSet rs2 = s.getAll(s1);	
		list1 = s.excuteQuery(rs2);
		Map map1 = (Map)list1.get(0);
		String txt=(String)map1.get("Aid");
		
		textField.setText(txt);
		txt=(String)map1.get("Aname");
		textField_1.setText(txt);
		txt=(String)map1.get("Adate");
		textField_2.setText(txt);
		txt=(String)map1.get("Acontent");
		textArea.setText(txt);
		txt=(String)map1.get("Asponsor");
		textField_3.setText(txt);
		txt=(String)map1.get("Dno");
		textField_4.setText(txt);
		
		
//===================ÐÞ¸ÄÐÅÏ¢
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.setAid(s1);
				s.setAname(textField_1.getText());
				s.setAdata(textField_2.getText());
				s.setAcontent(textArea.getText());
				s.setAsponsor(textField_3.getText());
				s.setDno(textField_4.getText());
				s.update(s);
				JOptionPane.showMessageDialog(null, "ÐÞ¸Ä³É¹¦");
			}
		});
		
		
		
		
		

//É¾³ýÄ³»î¶¯ÐÅÏ¢		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				s.delete(s1);
				JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦£¡");
				dispose();
				
			}
		});
//ÍË³ö½çÃæ		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		label_back2 = new JLabel(" ");
		label_back2.setBounds(5, 5, 783, 496);
		label_back2.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\10.jpg"));
		TV2.add(label_back2);
	}
}
