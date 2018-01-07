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

	//	�������ݿ�
	private Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/student_union";
	    String username = "root";
	    String password = "123456";
//	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,���ض�Ӧ����
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
//	�ͷ����ݿ�
	private void closeAll() {
		// �رս��������
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		// �ر�PreparedStatement����
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		// �ر�Connection ����
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
//	������
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
//	    ����ResultSet��
	    return rs;
	}
//	��
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
	
//	��
	public int update(department d) {
	    Connection conn = getConn();
	    int i = 0;
//	    ƴ��sql���
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
//	    ����ִ�����Ӱ�������
	    return i;
	}

	
    public List<Object> excuteQuery(ResultSet rs) {             
        // ����ResultSetMetaData����    
        ResultSetMetaData rsmd = null;    
            
        // ���������    
        int columnCount = 0;    
        try {    
            rsmd = rs.getMetaData();    
                
            // ��ý��������    
            columnCount = rsmd.getColumnCount();    
        } catch (SQLException e1) {    
            System.out.println(e1.getMessage());    
        }    
    
        // ����List    
        List<Object> list = new ArrayList<Object>();    
    
        try {    
            // ��ResultSet�Ľ�����浽List��    
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
		d.setDfunction("��ϯ��ӵ��ǿ������");
		d.setDname("��ϯ��");
		d.update(d);
		
    }
}
