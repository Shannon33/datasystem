package datasystem;

import java.sql.*;
import java.util.*;

public class department {
    private Connection conn = null;    
    private PreparedStatement pstmt = null;         
    private ResultSet rs = null; 
	
    private String Dno;
    private String Dname;
    private String Dfunction;
    
	public department() {
		super();
	}
	
	public String getDno() {
		return Dno;
	}

	public void setDno(String dno) {
		Dno = dno;
	}

	public String getDname() {
		return Dname;
	}

	public void setDname(String dname) {
		Dname = dname;
	}

	public String getDfunction() {
		return Dfunction;
	}

	public void setDfunction(String dfunction) {
		Dfunction = dfunction;
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
//	查所有
	public ResultSet getAll() {
	    Connection conn = getConn();
	    ResultSet rs = null;
	    String sql = "select * from department";
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
//	    返回ResultSet集
	    return rs;
	}
//	查
	public ResultSet getAll(String dno) {
	    Connection conn = getConn();
	    ResultSet rs = null;
	    String sql = "select * from department where Dno='" + dno + "'";
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return rs;
	}
	
//	改
	public int update(department d) {
	    Connection conn = getConn();
	    int i = 0;
//	    拼接sql语句
	    String sql = "update department "
	    			+ "set Dname='" + d.getDname()+ "',"
	    				+"Dfunction='" + d.getDfunction() + "'"
	    		+ " where Dno='" + d.getDno() + "'";
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
                Map<String, Object> map = new HashMap<String, Object>();    
                for (int i = 1; i <= columnCount; i++) {    
                    map.put(rsmd.getColumnLabel(i), rs.getObject(i));    
                }    
                list.add(map);    
            }    
        } catch (SQLException e) {    
            System.out.println(e.getMessage());    
        }finally {
	    	closeAll();
		}
        return list;    
    } 
    public static void main(String[] args) {
    	
    	department d = new department();
    	List<Object> list = new ArrayList<Object>();
		ResultSet rs = d.getAll("02");
		
		list = d.excuteQuery(rs);
		Map map = (Map)list.get(0);
		System.out.println(map.get("Dfunction"));
		d.setDno("01");
		d.setDfunction("主席团拥有强大阵容");
		d.setDname("主席团");
		d.update(d);
		
    }
}
