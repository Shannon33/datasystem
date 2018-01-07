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

public class add_activity extends JFrame {

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
					add_activity frame = new add_activity();
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
	public add_activity() {
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
		
		
		
		JButton btnNewButton_3 = new JButton("\u6DFB\u52A0/\u4FDD\u5B58");
		btnNewButton_3.setBounds(567, 117, 123, 29);
		TV2.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.setBounds(567, 185, 123, 29);
		TV2.add(btnNewButton_2);
		
//===========²éÑ¯ÐÅÏ¢================
		activity s =new activity();

		

		
		
//===================ÐÞ¸ÄÐÅÏ¢
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(null)||textField.getText().equals("") 
						||textField_1.getText().equals(null)||textField_1.getText().equals("")
						||textField_2.getText().equals(null)||textField_2.getText().equals("")
						||textArea.getText().equals(null)||textArea.getText().equals("")
						||textField_4.getText().equals(null)||textField_4.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "²¿·ÖÐÅÏ¢²»ÄÜÎª¿Õ£¡");
				}
				else {
						s.setAid(textField.getText());
						s.setAname(textField_1.getText());
						s.setAdata(textField_2.getText());
						s.setAcontent(textArea.getText());
						s.setAsponsor(textField_3.getText());
						s.setDno(textField_4.getText());
						int k = s.insert(s);
						if(k!=0)
							JOptionPane.showMessageDialog(null, "Ìí¼Ó³É¹¦");
				}
				
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
