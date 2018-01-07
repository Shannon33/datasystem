package datasystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class depart_infor extends JFrame {

	private JPanel TV1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					depart_infor frame = new depart_infor();
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
	public depart_infor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		TV1 = new JPanel();
		TV1.setBorder(new EmptyBorder(5, 5, 5, 5));
		TV1.setLayout(null);
		setContentPane(TV1);
		
		//==================������Ϣ����==========================================
				
				department d=new department();
				List<Object> l1 = new ArrayList<Object>();
				ResultSet r1 = d.getAll("01");//��ϯ��
				l1 = d.excuteQuery(r1);
				Map m1 = (Map)l1.get(0);
				String t1=(String)m1.get("Dfunction");
				
				List<Object> l2 = new ArrayList<Object>();
				ResultSet r2 = d.getAll("02");//���鴦
				l2 = d.excuteQuery(r2);
				Map m2 = (Map)l2.get(0);
				String t2=(String)m2.get("Dfunction");
				
				List<Object> l3 = new ArrayList<Object>();
				ResultSet r3 = d.getAll("03");//��֯��
				l3 = d.excuteQuery(r3);
				Map m3 = (Map)l3.get(0);
				String t3=(String)m3.get("Dfunction");
				
				List<Object> l4 = new ArrayList<Object>();
				ResultSet r4 = d.getAll("04");//������
				l4 = d.excuteQuery(r4);
				Map m4 = (Map)l4.get(0);
				String t4=(String)m4.get("Dfunction");
				
				List<Object> l5 = new ArrayList<Object>();
				ResultSet r5 = d.getAll("05");//��Ϣ
				l5 = d.excuteQuery(r5);
				Map m5 = (Map)l5.get(0);
				String t5=(String)m5.get("Dfunction");
				
				List<Object> l6 = new ArrayList<Object>();
				ResultSet r6 = d.getAll("06");//������
				l6 = d.excuteQuery(r6);
				Map m6 = (Map)l6.get(0);
				String t6=(String)m6.get("Dfunction");
				
				List<Object> l7 = new ArrayList<Object>();
				ResultSet r7 = d.getAll("07");//ѧϰ��
				l7 = d.excuteQuery(r7);
				Map m7 = (Map)l7.get(0);
				String t7=(String)m7.get("Dfunction");
				
				List<Object> l8 = new ArrayList<Object>();
				ResultSet r8 = d.getAll("08");//���ղ�
				l8 = d.excuteQuery(r8);
				Map m8 = (Map)l8.get(0);
				String t8=(String)m8.get("Dfunction");
				
				List<Object> l9 = new ArrayList<Object>();
				ResultSet r9 = d.getAll("09");//ʵ����
				l9 = d.excuteQuery(r9);
				Map m9 = (Map)l9.get(0);
				String t9=(String)m9.get("Dfunction");
				
				List<Object> l10 = new ArrayList<Object>();
				ResultSet r10 = d.getAll("10");//���
				l10 = d.excuteQuery(r10);
				Map m10 = (Map)l10.get(0);
				String t10=(String)m10.get("Dfunction");
				

		//===============================================================
				
				
				
						

		//=================���Ž��ܲ���===============		

		//������ʾ�ı�		
				
				JTextArea content1 = new JTextArea();
				content1.setBounds(100, 327,503, 147);
				content1.setLineWrap(true);
				TV1.add(content1);
		//���ſؼ�		
				JRadioButton top = new JRadioButton();
				top.setText("\u4E3B\u5E2D\u56E201");
				top.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				top.setBounds(299, 57, 123, 29);
				top.setLayout(null);
				TV1.add(top);
//				
				JRadioButton d1 = new JRadioButton();
				d1.setText("��֯��03");
				d1.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				d1.setBounds(306, 120, 123, 30);
				TV1.add(d1);
				
				
//				
				JRadioButton d2 = new JRadioButton();
				d2.setText("��Ϣ��05");
				d2.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				d2.setBounds(100, 170, 123, 29);
				TV1.add(d2);
//				
				JRadioButton d3 = new JRadioButton();
				d3.setText("������06");
				d3.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				d3.setBounds(306, 170, 123, 29);
				TV1.add(d3);
				
				JRadioButton d4 = new JRadioButton();
				d4.setText("ѧϰ��07");
				d4.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				d4.setBounds(512, 170, 123, 29);
				TV1.add(d4);
				
				JRadioButton d5 = new JRadioButton();
				d5.setText("���ղ�08");
				d5.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				d5.setBounds(100, 230, 123, 29);
				TV1.add(d5);
				
				JRadioButton d6 = new JRadioButton();
				d6.setText("ʵ����09");
				d6.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				d6.setBounds(306, 230, 123, 29);
				TV1.add(d6);
				
				JRadioButton d7 = new JRadioButton();
				d7.setText("������04");
				d7.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				d7.setBounds(512, 121, 123, 29);
				TV1.add(d7);
				
				JRadioButton d8 = new JRadioButton();
				d8.setText("���鴦02");
				d8.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				d8.setBounds(100, 120, 123, 30);
				TV1.add(d8);
				
				JRadioButton d9 = new JRadioButton();
				d9.setText("\u751F\u6D3B\u90E810");
				d9.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				d9.setBounds(512, 230, 123, 29);
				TV1.add(d9);
				
				JLabel label_back1;
				
				JButton button = new JButton("\u4FDD\u5B58");
				button.setBounds(618, 398, 96, 37);
				TV1.add(button);
				label_back1 = new JLabel(" ");
				label_back1.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\10.jpg"));
				label_back1.setBounds(0, 0, 778, 544);
				TV1.add(label_back1);
				
	//���Ű�������
				//����¼�
				top.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String t1=(String)m1.get("Dfunction");
						
						content1.setText(t1);
						if(top.isSelected())
						{
							d1.setEnabled(false);
							d2.setEnabled(false);
							d3.setEnabled(false);
							d4.setEnabled(false);
							d5.setEnabled(false);
							d6.setEnabled(false);
							d7.setEnabled(false);
							d8.setEnabled(false);
							d9.setEnabled(false);
						}
						else if(!top.isSelected())
						{
							d1.setEnabled(true);
							d2.setEnabled(true);
							d3.setEnabled(true);
							d4.setEnabled(true);
							d5.setEnabled(true);
							d6.setEnabled(true);
							d7.setEnabled(true);
							d8.setEnabled(true);
							d9.setEnabled(true);
						}
					}
				});
				d1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String t3=(String)m3.get("Dfunction");
						content1.setText(t3);
						if(d1.isSelected())
						{
							top.setEnabled(false);
							d2.setEnabled(false);
							d3.setEnabled(false);
							d4.setEnabled(false);
							d5.setEnabled(false);
							d6.setEnabled(false);
							d7.setEnabled(false);
							d8.setEnabled(false);
							d9.setEnabled(false);
						}
						else if(!d1.isSelected())
						{
							top.setEnabled(true);
							d2.setEnabled(true);
							d3.setEnabled(true);
							d4.setEnabled(true);
							d5.setEnabled(true);
							d6.setEnabled(true);
							d7.setEnabled(true);
							d8.setEnabled(true);
							d9.setEnabled(true);
						}
					}
				});
				d2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String t5=(String)m5.get("Dfunction");
						content1.setText(t5);
						if(d2.isSelected())
						{
							top.setEnabled(false);
							d1.setEnabled(false);
							d3.setEnabled(false);
							d4.setEnabled(false);
							d5.setEnabled(false);
							d6.setEnabled(false);
							d7.setEnabled(false);
							d8.setEnabled(false);
							d9.setEnabled(false);
						}
						else if(!d2.isSelected())
						{
							top.setEnabled(true);
							d1.setEnabled(true);
							d3.setEnabled(true);
							d4.setEnabled(true);
							d5.setEnabled(true);
							d6.setEnabled(true);
							d7.setEnabled(true);
							d8.setEnabled(true);
							d9.setEnabled(true);
							
						}
					}
				});
				d3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String t6=(String)m6.get("Dfunction");
						content1.setText(t6);
						if(d3.isSelected())
						{
							top.setEnabled(false);
							d1.setEnabled(false);
							d2.setEnabled(false);
							d4.setEnabled(false);
							d5.setEnabled(false);
							d6.setEnabled(false);
							d7.setEnabled(false);
							d8.setEnabled(false);
							d9.setEnabled(false);
						}
						else if(!d3.isSelected())
						{
							top.setEnabled(true);
							d1.setEnabled(true);
							d2.setEnabled(true);
							d4.setEnabled(true);
							d5.setEnabled(true);
							d6.setEnabled(true);
							d7.setEnabled(true);
							d8.setEnabled(true);
							d9.setEnabled(true);
							
						}
					}
				});
				d4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String t7=(String)m7.get("Dfunction");
						content1.setText(t7);
						if(d4.isSelected())
						{
							top.setEnabled(false);
							d1.setEnabled(false);
							d2.setEnabled(false);
							d3.setEnabled(false);
							d5.setEnabled(false);
							d6.setEnabled(false);
							d7.setEnabled(false);
							d8.setEnabled(false);
							d9.setEnabled(false);
						}
						else if(!d4.isSelected())
						{
							top.setEnabled(true);
							d1.setEnabled(true);
							d3.setEnabled(true);
							d2.setEnabled(true);
							d5.setEnabled(true);
							d6.setEnabled(true);
							d7.setEnabled(true);
							d8.setEnabled(true);
							d9.setEnabled(true);
							
						}
					}
				});
				d5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String t8=(String)m8.get("Dfunction");
						content1.setText(t8);
						if(d5.isSelected())
						{
							top.setEnabled(false);
							d1.setEnabled(false);
							d2.setEnabled(false);
							d3.setEnabled(false);
							d4.setEnabled(false);
							d6.setEnabled(false);
							d7.setEnabled(false);
							d8.setEnabled(false);
							d9.setEnabled(false);
						}
						else if(!d5.isSelected())
						{
							top.setEnabled(true);
							d1.setEnabled(true);
							d3.setEnabled(true);
							d4.setEnabled(true);
							d2.setEnabled(true);
							d6.setEnabled(true);
							d7.setEnabled(true);
							d8.setEnabled(true);
							d9.setEnabled(true);
							
						}
					}
				});
				d6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String t9=(String)m9.get("Dfunction");
						content1.setText(t9);
						if(d6.isSelected())
						{
							top.setEnabled(false);
							d1.setEnabled(false);
							d2.setEnabled(false);
							d3.setEnabled(false);
							d4.setEnabled(false);
							d5.setEnabled(false);
							d7.setEnabled(false);
							d8.setEnabled(false);
							d9.setEnabled(false);
						}
						else if(!d6.isSelected())
						{
							top.setEnabled(true);
							d1.setEnabled(true);
							d3.setEnabled(true);
							d4.setEnabled(true);
							d5.setEnabled(true);
							d2.setEnabled(true);
							d7.setEnabled(true);
							d8.setEnabled(true);
							d9.setEnabled(true);
							
						}
					}
				});
				d7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String t4=(String)m4.get("Dfunction");
						content1.setText(t4);
						if(d7.isSelected())
						{
							top.setEnabled(false);
							d1.setEnabled(false);
							d2.setEnabled(false);
							d3.setEnabled(false);
							d4.setEnabled(false);
							d5.setEnabled(false);
							d6.setEnabled(false);
							d8.setEnabled(false);
							d9.setEnabled(false);
						}
						else if(!d7.isSelected())
						{
							top.setEnabled(true);
							d1.setEnabled(true);
							d3.setEnabled(true);
							d4.setEnabled(true);
							d5.setEnabled(true);
							d6.setEnabled(true);
							d2.setEnabled(true);
							d8.setEnabled(true);
							d9.setEnabled(true);
							
						}
					}
				});
				d8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String t2=(String)m2.get("Dfunction");
						content1.setText(t2);
						if(d8.isSelected())
						{
							top.setEnabled(false);
							d1.setEnabled(false);
							d2.setEnabled(false);
							d3.setEnabled(false);
							d4.setEnabled(false);
							d5.setEnabled(false);
							d6.setEnabled(false);
							d7.setEnabled(false);
							d9.setEnabled(false);
						}
						else if(!d8.isSelected())
						{
							top.setEnabled(true);
							d1.setEnabled(true);
							d3.setEnabled(true);
							d4.setEnabled(true);
							d5.setEnabled(true);
							d6.setEnabled(true);
							d7.setEnabled(true);
							d2.setEnabled(true);
							d9.setEnabled(true);
							
						}
					}
				});
				d9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String t10=(String)m10.get("Dfunction");
						content1.setText(t10);
						if(d9.isSelected())
						{
							top.setEnabled(false);
							d1.setEnabled(false);
							d2.setEnabled(false);
							d3.setEnabled(false);
							d4.setEnabled(false);
							d5.setEnabled(false);
							d6.setEnabled(false);
							d7.setEnabled(false);
							d8.setEnabled(false);
						}
						else if(!d2.isSelected())
						{
							top.setEnabled(true);
							d1.setEnabled(true);
							d3.setEnabled(true);
							d4.setEnabled(true);
							d5.setEnabled(true);
							d6.setEnabled(true);
							d7.setEnabled(true);
							d8.setEnabled(true);
							d2.setEnabled(true);
							
						}
					}
				});
				
//=================�޸ı���==========
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String content=content1.getText();
						department d = new department();
						if(top.isSelected())
						{
							d.setDno("01");
							d.setDfunction(content);
							d.setDname("��ϯ��");
							d.update(d);
							
						}
						else if(d1.isSelected())
						{
							d.setDno("03");
							d.setDfunction(content);
							d.setDname("��֯��");
							d.update(d);
							
						}else if(d2.isSelected())
						{
							d.setDno("05");
							d.setDfunction(content);
							d.setDname("��Ϣ��");
							d.update(d);
						}else if(d3.isSelected())
						{
							d.setDno("06");
							d.setDfunction(content);
							d.setDname("������");
							d.update(d);
						}else if(d4.isSelected())
						{
							d.setDno("07");
							d.setDfunction(content);
							d.setDname("ѧϰ��");
							d.update(d);
						}else if(d5.isSelected())
						{
							d.setDno("08");
							d.setDfunction(content);
							d.setDname("���ղ�");
							d.update(d);
						}else if(d6.isSelected())
						{
							d.setDno("09");
							d.setDfunction(content);
							d.setDname("ʵ����");
							d.update(d);
						}else if(d7.isSelected())
						{
							d.setDno("04");
							d.setDfunction(content);
							d.setDname("������");
							d.update(d);
						}else if(d8.isSelected())
						{
							d.setDno("02");
							d.setDfunction(content);
							d.setDname("���鴦");
							d.update(d);
						}else if(d9.isSelected())
						{
							d.setDno("10");
							d.setDfunction(content);
							d.setDname("���");
							d.update(d);
						}
						
						JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
						dispose();
						
					}
				});
		//================���Ž��ܲ��ֽ���=================		
	}
}
