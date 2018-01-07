package datasystem;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;


public class member {
	private String Sno;
	private String Sname;
	private String Ssex;
	private String Seth;
	private String Sbirth;
	private String Spolitical_status;
	private String Sclass;
	private String profession;
	private String position;
	private String tel;
	private String Dno;
//	创建用到的对象
    private Connection conn = null;    
    private PreparedStatement pstmt = null;         
    private ResultSet rs = null; 
//	构造函数
	public member(String sno, String sname, String ssex, String seth, String sbirth, String spolitical_status,
			String sclass, String profession, String position, String tel, String dno) {
		super();
		this.Sno = sno;
		this.Sname = sname;
		this.Ssex = ssex;
		this.Seth = seth;
		this.Sbirth = sbirth;
		this.Spolitical_status = spolitical_status;
		this.Sclass = sclass;
		this.profession = profession;
		this.position = position;
		this.tel = tel;
		this.Dno = dno;
	}
	public member(){
		
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		this.Sno = sno;
	}
	public String getSname() {
		return this.Sname;
	}
	public void setSname(String sname) {
		this.Sname = sname;
	}
	public String getSsex() {
		return this.Ssex;
	}
	public void setSsex(String ssex) {
		this.Ssex = ssex;
	}
	public String getSeth() {
		return this.Seth;
	}
	public void setSeth(String seth) {
		this.Seth = seth;
	}
	public String getSbirth() {
		return this.Sbirth;
	}
	public void setSbirth(String sbirth) {
		this.Sbirth = sbirth;
	}
	public String getSpolitical_status() {
		return this.Spolitical_status;
	}
	public void setSpolitical_status(String spolitical_status) {
		this.Spolitical_status = spolitical_status;
	}
	public String getSclass() {
		return this.Sclass;
	}
	public void setSclass(String sclass) {
		this.Sclass = sclass;
	}
	public String getProfession() {
		return this.profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getPosition() {
		return this.position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTel() {
		return this.tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDno() {
		return this.Dno;
	}
	public void setDno(String dno) {
		this.Dno = dno;
	}
	//	连接数据库
	private Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/student_union";
	    String username = "root";
	    String password = "123456";
//	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
//	释放数据库
	private void closeAll() {
		// 关闭结果集对象
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		// 关闭PreparedStatement对象
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		// 关闭Connection 对象
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

//	增
	public int insert(member m) {
//		创建连接
	    Connection conn = getConn();
	    int i = 0;
//	    使用占位符创建SQL语句。
	    String sql = "insert into member (Sno,Sname,Ssex,Seth,Sbirth,Spolitical_status,Sclass,profession,position,tel,Dno) values(?,?,?,?,?,?,?,?,?,?,?)";
	    try {
//	    	sql预编译
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
//	        传递参数
	        pstmt.setString(1, m.getSno());
	        pstmt.setString(2, m.getSname());
	        pstmt.setString(3, m.getSsex());
	        pstmt.setString(4, m.getSeth());
	        pstmt.setString(5, m.getSbirth());
	        pstmt.setString(6, m.getSpolitical_status());
	        pstmt.setString(7, m.getSclass());
	        pstmt.setString(8, m.getProfession());
	        pstmt.setString(9, m.getPosition());
	        pstmt.setString(10, m.getTel());
	        pstmt.setString(11, m.getDno());
//	        返回受SQL语句执行影响的行数。
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally {
//	    	释放所有资源
	    	closeAll();
		}
	    return i;
	}
//	删（按学号删除）
	public int delete(String sno) {
	    Connection conn = getConn();
	    int i = 0;
//	    使用占位符创建SQL语句。
	    String sql = "delete from member where Sno='" + sno + "'";
	    try {
//	    	sql预编译
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
//	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	    	JOptionPane.showMessageDialog(null, "删除失败！");
	        e.printStackTrace();
	    }finally {
	    	closeAll();
		}
//	    返回执行语句影响的行数
	    return i;
	}

//	改
	public int update(member m) {
	    Connection conn = getConn();
	    int i = 0;
//	    拼接sql语句
	    String sql = "update member "
	    			+ "set Sname='" + m.getSname()+ "',"
	    				+"Ssex='" + m.getSsex() + "',"
	    				+"Seth='" + m.getSeth() + "',"
	    				+"Sbirth='" + m.getSbirth() + "',"
	    				+"Spolitical_status='" + m.getSpolitical_status() + "',"
	    				+"Sclass='" + m.getSclass() + "',"
	    				+"profession='" + m.getProfession() + "',"
	    				+"position='" + m.getPosition() + "',"
	    				+"tel='" + m.getTel() + "',"
	    				+"Dno='" + m.getDno() + "'"
	    		+ " where Sno='" + m.getSno() + "'";
//	    String sql = "update member set position='" + m.getPosition() + "' where Sno='" + m.getSno() + "'";
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
//	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally {
	    	closeAll();
		}
//	    返回执行语句影响的行数
	    return i;
	}
	
//	查
	public ResultSet getAll(String sno) {
	    Connection conn = getConn();
	    ResultSet rs = null;
	    String sql = "select * from member where Sno='" + sno + "'";
	    PreparedStatement pstmt = null;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	    } catch (SQLException e) {
	    	JOptionPane.showMessageDialog(null, "查询失败！");
	        e.printStackTrace();
	    }
//	    返回ResultSet集
	    return rs;
	}
	
//查所有
	public ResultSet All() {
	    Connection conn = getConn();
	    ResultSet rs = null;
	    String sql = "select * from member ";
	    PreparedStatement pstmt = null;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
//	    返回ResultSet集
	    return rs;
	}
//	将ResultSet集保存在List<map>中
    public List<Object> excuteQuery(ResultSet rs) {             
        // 创建ResultSetMetaData对象    
        ResultSetMetaData rsmd = null;      
        // 结果集列数    
        int columnCount = 0;    
        try {    
            rsmd = rs.getMetaData();    
            // 获得结果集列数    
            columnCount = rsmd.getColumnCount();    
        } catch (SQLException e1) {    
            System.out.println(e1.getMessage());    
        }    
    
        // 创建List    
        List<Object> list = new ArrayList<Object>();    
    
        try {    
            // 将ResultSet的结果保存到List中    
            while (rs.next()) {
//            	创建map
                Map<String, Object> map = new HashMap<String, Object>();    
                for (int i = 1; i <= columnCount; i++) {  
//                	getColumnLabel（）获取结果集中列项目的属性
                    map.put(rsmd.getColumnLabel(i), rs.getObject(i));    
                }    
                list.add(map);    
            }    
        } catch (SQLException e) {    
            System.out.println(e.getMessage());    
        }finally {
	    	closeAll();
		}
//        返回一个list<Map>
        return list;    
    } 
	
//	public static void main(String[] args) {
		
//		member m = new member("20150017","Tom","男","汉族","20151021","团员","三班","计科","无","123456789","01");
//		m.insert(m);
//		m.delete("001");
//		m.setPosition("主席");
//		System.out.println(m.getPosition());
//		m.update(m);
//		List<Object> list = new ArrayList<Object>();
//		ResultSet rs = m.getAll("20150001");
//		
//		list = m.excuteQuery(rs);
//		System.out.println(list.get(0));
//		list.get(i)方法可以获取第i个的内容为一个map
//		
//		将list转为map获取具体map中的数据
//		System.out.println(map.get("Ssex"));
//		System.out.println(m.getAll("20150001"));
		
		
//		member a=new member();
//		ResultSet r = a.All();
//		list = a.excuteQuery(r);
//		for(int i=0;i<list.size();i++)
//		{
//			System.out.println(list.get(i));
//		}


//	}
}
