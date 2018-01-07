package datasystem;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
//table
import javax.swing.table.DefaultTableModel;



import java.awt.Insets;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;  


public class user extends JFrame {

	private JPanel contentPane;
	private JLabel label_back;
	private JLabel label_back1;
	private JLabel label_back4;
	private JTable table;
	private JTable table2;
	private JTextField getsno;
	private JTextField getAid;
	private JTextField departid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String s1 = "20150001";
					user frame = new user(s1);
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
//进入管理员界面，s1为用户ID
	public user(String s1) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//		TV3.setLayout(null);

		
//s1登陆=================================
		member s=new member();
		List<Object> list2 = new ArrayList<Object>();
		ResultSet rs2 = s.getAll(s1);//主席团		
		list2 = s.excuteQuery(rs2);
		Map map2 = (Map)list2.get(0);
		String txt1=(String)map2.get("Sname");

//=========================================		
		
//两个txt名字换了	
//获得该学号的信息
		
		
//==================部门信息部分==========================================
		
		department d=new department();
		List<Object> l1 = new ArrayList<Object>();
		ResultSet r1 = d.getAll("01");//主席团
		l1 = d.excuteQuery(r1);
		Map m1 = (Map)l1.get(0);
		String t1=(String)m1.get("Dfunction");
		
		List<Object> l2 = new ArrayList<Object>();
		ResultSet r2 = d.getAll("02");//秘书处
		l2 = d.excuteQuery(r2);
		Map m2 = (Map)l2.get(0);
		String t2=(String)m2.get("Dfunction");
		
		List<Object> l3 = new ArrayList<Object>();
		ResultSet r3 = d.getAll("03");//组织部
		l3 = d.excuteQuery(r3);
		Map m3 = (Map)l3.get(0);
		String t3=(String)m3.get("Dfunction");
		
		List<Object> l4 = new ArrayList<Object>();
		ResultSet r4 = d.getAll("04");//外联部
		l4 = d.excuteQuery(r4);
		Map m4 = (Map)l4.get(0);
		String t4=(String)m4.get("Dfunction");
		
		List<Object> l5 = new ArrayList<Object>();
		ResultSet r5 = d.getAll("05");//信息
		l5 = d.excuteQuery(r5);
		Map m5 = (Map)l5.get(0);
		String t5=(String)m5.get("Dfunction");
		
		List<Object> l6 = new ArrayList<Object>();
		ResultSet r6 = d.getAll("06");//宣传部
		l6 = d.excuteQuery(r6);
		Map m6 = (Map)l6.get(0);
		String t6=(String)m6.get("Dfunction");
		
		List<Object> l7 = new ArrayList<Object>();
		ResultSet r7 = d.getAll("07");//学习部
		l7 = d.excuteQuery(r7);
		Map m7 = (Map)l7.get(0);
		String t7=(String)m7.get("Dfunction");
		
		List<Object> l8 = new ArrayList<Object>();
		ResultSet r8 = d.getAll("08");//文艺部
		l8 = d.excuteQuery(r8);
		Map m8 = (Map)l8.get(0);
		String t8=(String)m8.get("Dfunction");
		
		List<Object> l9 = new ArrayList<Object>();
		ResultSet r9 = d.getAll("09");//实践部
		l9 = d.excuteQuery(r9);
		Map m9 = (Map)l9.get(0);
		String t9=(String)m9.get("Dfunction");
		
		List<Object> l10 = new ArrayList<Object>();
		ResultSet r10 = d.getAll("10");//生活部
		l10 = d.excuteQuery(r10);
		Map m10 = (Map)l10.get(0);
		String t10=(String)m10.get("Dfunction");
		contentPane.setLayout(null);
		

//===============================================================
		
		
		
		
		
//
								
//==============================大框架==============
								
		JPanel panel = new JPanel();
		panel.setBounds(37, 48, 909, 565);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton button_1 = new JButton("\u90E8\u95E8\u4ECB\u7ECD");
		
		button_1.setFont(new Font("黑体", Font.PLAIN, 22));
		button_1.setBounds(36, 115, 136, 48);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		button_2.setFont(new Font("黑体", Font.PLAIN, 22));
		button_2.setBounds(36, 274, 136, 48);
		panel.add(button_2);
		

		
		JButton button_3 = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		
		button_3.setFont(new Font("黑体", Font.PLAIN, 22));
		button_3.setBounds(36, 354, 136, 48);
		panel.add(button_3);

				
		


		
		JButton button4 = new JButton("\u6D3B\u52A8\u4ECB\u7ECD");
		button4.setFont(new Font("黑体", Font.PLAIN, 22));
		button4.setBounds(36, 196, 136, 48);
		panel.add(button4);
		
		
		
		
		JButton button_5 = new JButton("\u9000\u51FA");
		


		button_5.setFont(new Font("黑体", Font.PLAIN, 22));
		button_5.setBounds(36, 428, 136, 48);
		panel.add(button_5);
		
		
//布局		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(192, 44, 701, 506);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel layoutback = new JPanel();
		layoutback.setLayout(null);
		panel_1.add(layoutback, "name_22026413028650");
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel.setBounds(295, 116, 181, 135);
		layoutback.add(lblNewLabel);
		
		JLabel ground = new JLabel(" ");
		ground.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\10.jpg"));
		ground.setBounds(0, 0, 701, 506);
		layoutback.add(ground);
		
		

//==========member信息表格==================
		//创建表格模型
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"学号","姓名","电话","班级"});
		member b=new member();
		ResultSet rr = b.All();
		List<Object> listpeople = new ArrayList<Object>();
		listpeople = b.excuteQuery(rr);
		//打印内容
//		for(int i=0;i<listpeople.size();i++)
//		{
//			System.out.println(listpeople.get(i));
//		}
		int count = listpeople.size();
		int j=0;
		while(j<count)
		{
			Map map = (Map)listpeople.get(j);
		String xuehao=(String)map.get("Sno");
				String name=(String)map.get("Sname");
				String telephone=(String)map.get("Sno");
				String banji = (String)map.get("Sclass");
					
		//把以上数据添加到表格模型的一行中
	
						
			model.addRow(new Object[]{xuehao,name,telephone,banji,j+1});
			j++;
		}
//=========================表格结束
//将以上表格部分添加到下面信息查询部分
		
		
//==================信息查询部分============
		
		JPanel TV4_information = new JPanel();
		panel_1.add(TV4_information, "name_22526188651983");		
		JLabel label_back4;					//		背景		
		TV4_information.setLayout(null);
		table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(106, 77, 499, 236);
		TV4_information.add(scrollPane);
		
		getsno = new JTextField();
		getsno.setBounds(112, 388, 382, 35);
		TV4_information.add(getsno);
		getsno.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
//查询单个成员信息
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "对不起，您的权限不足！");
			}
		});
		btnNewButton.setBounds(531, 390, 123, 29);
		TV4_information.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u5B66\u53F7\u8FDB\u884C\u67E5\u8BE2\u6216\u7BA1\u7406");
		lblNewLabel_1.setBounds(135, 352, 285, 21);
		TV4_information.add(lblNewLabel_1);
	
		
		
		label_back4 = new JLabel(" ");
		label_back4.setBounds(0, 0, 701, 506);
		label_back4.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\10.jpg"));
		TV4_information.add(label_back4);
//=======================信息查询部分结束==============
	
		
//=================活动查询部分===============
		
		
		JPanel TV3 = new JPanel();
		TV3.setLayout(null);
		panel_1.add(TV3, "name_21126316569907");
		
		//活动内容
		activity a = new activity();
		List<Object> list = new ArrayList<Object>();
		ResultSet r = a.All();
		list = a.excuteQuery(r);
		for(int i=0;i<list.size();i++)
		{
			Map map = (Map)list.get(i);
			String txt =(String)map.get("Acontent");
		}
		
		DefaultTableModel model2=new DefaultTableModel();
		model2.setColumnIdentifiers(new Object[]{"活动编号","活动主题","内容"});

		int count2 = list.size();
		int k=0;
		while(k<count2)
		{
			Map map = (Map)list.get(k);
			String activity_id=(String)map.get("Aid");
			String activity_name=(String)map.get("Aname");
			String activity_content=(String)map.get("Acontent");
					
		//把以上数据添加到表格模型的一行中		
			model2.addRow(new Object[]{activity_id,activity_name,activity_content,k+1});
			k++;
		}

		getAid = new JTextField();
		getAid.setBounds(231, 363, 157, 33);
		TV3.add(getAid);
		getAid.setColumns(10);
		//查询单个活动信息
		JButton activity_search = new JButton("\u67E5\u8BE2");
		activity_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getAid.getText().equals("")||getAid.getText().equals(null))
				{
					JOptionPane.showMessageDialog(null, "查询活动ID不能为空");
				}
				else 
				{
					activity_content search=new activity_content(getAid.getText());
					search.setVisible(true);
				}
			}
		});
		activity_search.setBounds(434, 365, 90, 31);
		TV3.add(activity_search);
		
		table2 = new JTable(model2);
		JScrollPane acitivityshow = new JScrollPane(table2);
		acitivityshow.setBounds(76, 43, 537, 233);
		TV3.add(acitivityshow);
		
		JLabel label_back3 = new JLabel(" ");
		label_back3.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\10.jpg"));
		label_back3.setBounds(0, 0, 701, 506);
		TV3.add(label_back3);
		
//=================活动查询部分结束==============
		
		
//===============个人信息部分==================
		
		
		JPanel TV2 = new JPanel();
		panel_1.add(TV2, "name_21080958776771");
		TV2.setLayout(null);
		
		JTextField Sno = new JTextField();
		txt1=(String)map2.get("Sno");
		Sno.setText(txt1);
		Sno.setBounds(104, 150, 96, 27);
		TV2.add(Sno);
		Sno.setColumns(10);
		
		JTextField name = new JTextField();
		txt1=(String)map2.get("Sname");
		name.setText(txt1);
		name.setBounds(105,200, 96, 27);
		TV2.add(name);
		name.setColumns(10);
		
		JTextField sex = new JTextField();
		txt1=(String)map2.get("Ssex");
		sex.setText(txt1);
		sex.setBounds(104, 250, 96, 27);
		TV2.add(sex);
		sex.setColumns(10);
		
		JTextField birth = new JTextField();
		txt1=(String)map2.get("Sbirth");
		birth.setText(txt1);
		birth.setBounds(104, 300, 96, 27);
		TV2.add(birth);
		birth.setColumns(10);
		
		JTextField nation = new JTextField();
		txt1=(String)map2.get("Seth");
		nation.setText(txt1);
		nation.setBounds(104, 350, 96, 27);
		TV2.add(nation);
		nation.setColumns(10);
		
		JTextField zhengzhi = new JTextField();
		txt1=(String)map2.get("Spolitical_status");
		zhengzhi.setText(txt1);
		zhengzhi.setBounds(148, 400, 96, 27);
		TV2.add(zhengzhi);
		zhengzhi.setColumns(10);
		
		JTextField zy = new JTextField();
		txt1=(String)map2.get("profession");
		zy.setText(txt1);
		zy.setBounds(322, 250, 96, 27);
		TV2.add(zy);
		zy.setColumns(10);
		
		JTextField classnum = new JTextField();
		txt1=(String)map2.get("Sclass");
		classnum.setText(txt1);
		classnum.setBounds(322, 200, 96, 27);
		TV2.add(classnum);
		classnum.setColumns(10);
		
		JTextField tel = new JTextField();
		txt1=(String)map2.get("tel");
		tel.setText(txt1);
		tel.setBounds(365, 150, 96, 27);
		TV2.add(tel);
		tel.setColumns(10);
		
		JTextField position = new JTextField();
		txt1=(String)map2.get("position");
		position.setText(txt1);
		position.setBounds(332, 300, 96, 27);
		TV2.add(position);
		position.setColumns(10);
		
		departid = new JTextField();
		txt1=(String)map2.get("Dno");
		departid.setText(txt1);
		departid.setBounds(322, 350, 96, 27);
		TV2.add(departid);
		departid.setColumns(10);
		
//	填写/展示信息	
	
		
		JLabel IF_Sno = new JLabel("\u5B66\u53F7");
		IF_Sno.setBounds(40, 150, 81, 21);
		IF_Sno.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		TV2.add(IF_Sno);
		
		JLabel label_7 = new JLabel("\u59D3\u540D");
		label_7.setBounds(40, 200, 81, 21);
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		TV2.add(label_7);
		
		JLabel lblName = new JLabel("\u6027\u522B");
		lblName.setBounds(40, 250, 81, 21);
		lblName.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		TV2.add(lblName);
		
		JLabel label_1 = new JLabel("\u751F\u65E5");
		label_1.setBounds(40, 300, 81, 21);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		TV2.add(label_1);
		
		JLabel label_2 = new JLabel("\u6C11\u65CF");
		label_2.setBounds(40, 350, 81, 21);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		TV2.add(label_2);
		
		JLabel label_3 = new JLabel("\u653F\u6CBB\u9762\u8C8C");
		label_3.setBounds(40, 400, 81, 21);
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		TV2.add(label_3);
		
		JLabel label_4 = new JLabel("\u4E13\u4E1A");
		label_4.setBounds(250, 250, 81, 21);
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		TV2.add(label_4);
		
		JLabel label_5 = new JLabel("\u73ED\u7EA7");
		label_5.setBounds(250, 200, 81, 21);
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		TV2.add(label_5);
		
		JLabel label_6 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		label_6.setBounds(250, 150, 81, 21);
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		TV2.add(label_6);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblPosition.setBounds(250, 300, 81, 21);
		TV2.add(lblPosition);
		
		JLabel Dpart = new JLabel("\u90E8\u95E8");
		Dpart.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		Dpart.setBounds(250, 353, 81, 21);
		TV2.add(Dpart);
		
		JButton checkedit = new JButton("\u4FEE\u6539");
		
		checkedit.setBounds(530, 371, 123, 29);
		TV2.add(checkedit);
		
		JLabel label_back2;
		label_back2 = new JLabel(" ");
		label_back2.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\10.jpg"));
		label_back2.setBounds(0, 0, 701, 506);
		TV2.add(label_back2);
		
//修改个人信息		
		checkedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				s.setDno(departid.getText());
				s.update(s);
				JOptionPane.showMessageDialog(null, "修改成功");
			}
		});
//=================个人信息部分结束=========	
//
//=================部门介绍部分===============		
		JPanel TV1 = new JPanel();
		panel_1.add(TV1, "name_21018174572050");
		TV1.setLayout(null);
//多行显示文本		
		
		JTextArea content1 = new JTextArea();
		content1.setBounds(100, 327,503, 147);
		content1.setLineWrap(true);
		TV1.add(content1);
//部门控件		
		JButton top = new JButton();
		top.setForeground(Color.BLACK);
		top.setText("\u4E3B\u5E2D\u56E2");
		top.setBackground(UIManager.getColor("TextArea.caretForeground"));
		top.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		top.setBounds(299, 57, 123, 29);
		top.setLayout(null);
		TV1.add(top);
//		
		JButton d1 = new JButton();
		d1.setText("组织部");
		d1.setForeground(Color.BLACK);
		d1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		d1.setBackground(UIManager.getColor("TextArea.inactiveForeground"));
		d1.setBounds(306, 120, 106, 30);
		TV1.add(d1);
//		
		JButton d2 = new JButton();
		d2.setText("信息部");
		d2.setForeground(Color.BLACK);
		d2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		d2.setBackground(UIManager.getColor("TextArea.inactiveForeground"));
		d2.setBounds(512, 120, 106, 29);
		TV1.add(d2);
//		
		JButton d3 = new JButton();
		d3.setText("宣传部");
		d3.setForeground(Color.BLACK);
		d3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		d3.setBackground(UIManager.getColor("TextArea.inactiveForeground"));
		d3.setBounds(100, 170, 106, 29);
		TV1.add(d3);
		
		JButton d4 = new JButton();
		d4.setText("学习部");
		d4.setForeground(Color.BLACK);
		d4.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		d4.setBackground(UIManager.getColor("TextArea.inactiveForeground"));
		d4.setBounds(306, 170, 106, 29);
		TV1.add(d4);
		
		JButton d5 = new JButton();
		d5.setText("文艺部");
		d5.setForeground(Color.BLACK);
		d5.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		d5.setBackground(UIManager.getColor("TextArea.inactiveForeground"));
		d5.setBounds(512, 170, 106, 29);
		TV1.add(d5);
		
		JButton d6 = new JButton();
		d6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		d6.setText("实践部");
		d6.setForeground(Color.BLACK);
		d6.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		d6.setBackground(UIManager.getColor("TextArea.inactiveForeground"));
		d6.setBounds(100, 230, 106, 29);
		TV1.add(d6);
		
		JButton d7 = new JButton();
		d7.setText("\u5916\u8054\u90E8");
		d7.setForeground(Color.BLACK);
		d7.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		d7.setBackground(UIManager.getColor("TextArea.inactiveForeground"));
		d7.setBounds(306, 230, 106, 29);
		TV1.add(d7);
		
		JButton d8 = new JButton();
		d8.setText("秘书处");
		d8.setForeground(Color.BLACK);
		d8.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		d8.setBackground(UIManager.getColor("TextArea.inactiveForeground"));
		d8.setBounds(100, 120, 106, 30);
		TV1.add(d8);
		
		JButton d9 = new JButton();
		d9.setText("\u751F\u6D3B\u90E8");
		d9.setForeground(Color.BLACK);
		d9.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		d9.setBackground(UIManager.getColor("TextArea.inactiveForeground"));
		d9.setBounds(512, 230, 106, 29);
		TV1.add(d9);
		
		JLabel label_back1;
//修改部门按键		
		JButton edit = new JButton("\u7F16\u8F91");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "对不起，您的权限不足，无法使用该功能！");
			}
		});
		edit.setBounds(618, 437, 69, 29);
		TV1.add(edit);
		label_back1 = new JLabel(" ");
		label_back1.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\10.jpg"));
		label_back1.setBounds(0, 0, 701, 506);
		TV1.add(label_back1);
		
		//部门按键监听
				top.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						content1.setText((String)m1.get("Dfunction"));
					}
				});		
				d1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						content1.setText((String)m3.get("Dfunction"));
					}
				});
				d2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						content1.setText((String)m5.get("Dfunction"));
					}
				});
				d3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						content1.setText((String)m6.get("Dfunction"));
					}
				});
				d4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						content1.setText((String)m7.get("Dfunction"));
					}
				});
				d5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						content1.setText((String)m8.get("Dfunction"));
					}
				});
				d6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						content1.setText((String)m9.get("Dfunction"));
					}
				});
				d7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						content1.setText((String)m4.get("Dfunction"));
					}
				});
				d8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						content1.setText((String)m2.get("Dfunction"));
					}
				});
				d9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						content1.setText((String)m10.get("Dfunction"));
					}
				});
//================部门介绍部分结束=================						
		
//==============卡片布局监听=====模块切换==============
				
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				layoutback.setVisible(false);
				TV2.setVisible(false);
				TV3.setVisible(false);
				TV4_information.setVisible(false);
				TV1.setVisible(true);
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layoutback.setVisible(false);
				TV1.setVisible(false);
				TV3.setVisible(false);
				TV4_information.setVisible(false);
				TV2.setVisible(true);
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layoutback.setVisible(false);
				TV1.setVisible(false);
				TV2.setVisible(false);				
				TV3.setVisible(false);
				TV4_information.setVisible(true);
				
			}
		});
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layoutback.setVisible(false);
				TV1.setVisible(false);
				TV2.setVisible(false);
				TV4_information.setVisible(false);
				TV3.setVisible(true);				
				
				
			}
		});
//退出
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
//=================模块切换结束==============
		
		
//背景		
		JLabel back2 = new JLabel(" ");
		back2.setBounds(0, 0, 909, 565);
		panel.add(back2);
		back2.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\1.jpg"));
		back2.setVisible(true);
		
		
//大背景		
		JLabel back1 = new JLabel(" ");
		back1.setBounds(0, 0, 1168, 733);
		contentPane.add(back1);
		back1.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\10.jpg"));
		

		

	}
}
