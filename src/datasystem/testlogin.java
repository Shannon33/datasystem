package datasystem;

import java.sql.*;

public class testlogin {
	private String Sno;
	private String passwd;
	private String auth;
    
    public testlogin(String sno, String passwd, String auth) {
		super();
		Sno = sno;
		this.passwd = passwd;
		this.auth = auth;
	}
    public testlogin()
    {
    	
    }

	public String getSno() {
		return Sno;
	}

	public void setSno(String sno) {
		Sno = sno;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}
//	连接数据库
	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/student_union";
	    String username = "root";
	    String password = "123456";
	    Connection conn = null;
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
//	插入
	public  int insert(testlogin L) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into login (Sno,password,authority) values(?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, L.getSno());
	        pstmt.setString(2, L.getPasswd());
	        pstmt.setString(3, L.getAuth());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
//	删除
	public  int  delete(String sno) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "delete from login where Sno='" + sno + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
//	更新
	public int update(testlogin L) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update login set password='" + L.getPasswd() + "' where Sno='" + L.getSno() + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
//	查询
	public Integer getAll() {
	    Connection conn = getConn();
	    String sql = "select * from login";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
//	        System.out.println("============================");
	        while(rs.next()){
	    
	            String sno = rs.getString(1);
	            String ps = rs.getString(2);
	            String auth = rs.getString(3);

//	            System.out.print("Sno: " + sno);
//	            System.out.print(", password: " + ps);
//	            System.out.print(", Auth: " + auth);
	         }
//	        	System.out.println();
//	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
//	查询用户是否存在	
	public static boolean getuser(String sno) {
		if(getps(sno) == null) {
//			System.out.println("用户名不存在!");
			return false;
		}else {
			return true;
		}
	}

//根据用户账号匹配密码	
	public static String getps(String sno) {
		String ps = null;
	    Connection conn = getConn();
	    String sql = "select password from login where Sno='" + sno + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        
	        ResultSet rs = pstmt.executeQuery();
	        
//	        System.out.println("============================");
	        while(rs.next()){
	    
	            ps = rs.getString(1);
	            
//	            System.out.print("password: " + ps);
	         }
//	        	System.out.println();
//	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ps;
	}
	//根据用户账号匹配权限
		public static String getauth(String sno) {
			String ath = null;
		    Connection conn = getConn();
		    String sql = "select authority from login where Sno='" + sno + "'";
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        
		        ResultSet rs = pstmt.executeQuery();
		        
//		        System.out.println("============================");
		        while(rs.next()){
		    
		            ath = rs.getString(1);
		            
//		            System.out.print("password: " + ps);
		         }
//		        	System.out.println();
//		            System.out.println("============================");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ath;
		}


	public static void main(String[] args) {
//		testlogin.getAll();
//   	testlogin.insert(new testlogin("02","123","1"));
//		testlogin.getAll();
//		testlogin.delete("02");
//		testlogin.getAll();
//		testlogin.getps("1");
//		testlogin.getauth("20150001");
//		System.out.println(testlogin.getauth("20150001").equals("0"));
		
   }
}
