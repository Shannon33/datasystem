package datasystem;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class activity {
    private Connection conn = null;    
    private PreparedStatement pstmt = null;         
    private ResultSet rs = null; 
	
    private String Aid;
    private String Aname;
    private String Adata;
    private String Acontent;
    private String Asponsor;
    private String Dno;
    
	
	public String getAid() {
		return Aid;
	}

	public void setAid(String aid) {
		Aid = aid;
	}

	public String getAname() {
		return Aname;
	}

	public void setAname(String aname) {
		Aname = aname;
	}

	public String getAdata() {
		return Adata;
	}

	public void setAdata(String adata) {
		Adata = adata;
	}

	public String getAcontent() {
		return Acontent;
	}

	public void setAcontent(String acontent) {
		Acontent = acontent;
	}

	public String getAsponsor() {
		return Asponsor;
	}

	public void setAsponsor(String asponsor) {
		Asponsor = asponsor;
	}

	public String getDno() {
		return Dno;
	}

	public void setDno(String dno) {
		Dno = dno;
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
	        System.out.println("数据库连接成功。");
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
	public int insert(activity A) {
//		创建连接
	    Connection conn = getConn();
	    int i = 0;
//	    使用占位符创建SQL语句。
	    String sql = "insert into activity (Aid,Aname,Adate,Acontent,Asponsor,Dno) values(?,?,?,?,?,?)";
	    try {
//	    	sql预编译
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
//	        传递参数
	        pstmt.setString(1, A.getAid());
	        pstmt.setString(2, A.getAname());
	        pstmt.setString(3, A.getAdata());
	        pstmt.setString(4, A.getAcontent());
	        pstmt.setString(5, A.getAsponsor());
	        pstmt.setString(6, A.getDno());

//	        返回受SQL语句执行影响的行数。
	        i = pstmt.executeUpdate();
	        System.out.println("数据插入成功。");
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "添加失败！");
	    }finally {
//	    	释放所有资源
	    	closeAll();
		}
	    return i;
	}
//	删（按学号删除）
	public int delete(String aid) {
	    Connection conn = getConn();
	    int i = 0;
//	    使用占位符创建SQL语句。
	    String sql = "delete from activity where Aid='" + aid + "'";
	    try {
//	    	sql预编译
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("数据删除成功。");
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

//	改
	public int update(activity A) {
	    Connection conn = getConn();
	    int i = 0;
//	    拼接sql语句
	    String sql = "update activity "
	    			+ "set Aid='" + A.getAid()+ "',"
	    				+"Aname='" + A.getAname() + "',"
	    				+"Adate='" + A.getAdata() + "',"
	    				+"Acontent='" + A.getAcontent() + "',"
	    				+"Asponsor='" + A.getAsponsor() + "',"
	    				+"Dno='" + A.getDno() + "'"	
	    		+ " where Aid='" + A.getAid() + "'";
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("数据更新成功。");
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
	public ResultSet getAll(String aid) {
	    Connection conn = getConn();
	    ResultSet rs = null;
	    String sql = "select * from activity where Aid='" + aid + "'";
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        System.out.println("数据查询成功。");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
//	    返回ResultSet集
	    return rs;
	}
	
	public ResultSet All() {
	    Connection conn = getConn();
	    ResultSet rs = null;
	    String sql = "select * from activity ";
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        System.out.println("数据查询成功。");
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

    public static void main(String[] args) {
    	
    	activity a = new activity();
//    	a.setAid("002");
//    	a.setAname("春游");
//    	a.setAcontent("09：00 -- 各队队长清点人数(名单见附件二) 　　\n"
//    			+ "09：05 -- 从公司出发 　　\n"
//    			+ "10：00 -- 到达目的地 　　\n"
//    			+ "10：05 -- 开始集体趣味游戏活动(规则详见附件一) 　　\n"
//    			+ "a、火车赛跑 　　b、跳长绳比赛 　　c、过龙门 　　\n"
//    			+ "12：00 -- 午 餐 　　观湖餐厅(颁发2003年度全勤奖) 　　\n"
//    			+ "3：30 -- 体育活动 　　保龄球1个道 (2小时13：30) 　　羽毛球2个场地(各1小时13：30) 　　乒乓球2个桌(各1小时13：30) 　　网 球1个场地(2小时13：30) 　　壁 球1个场地(1小时13：30) 　　\n"
//    			+ "18：00 -- 晚餐 　　18：30 -- 返回成都 \n");
//    	a.setAsponsor("某集团");
//    	a.setAdata("2013-10-23");
//    	a.setDno("02");
//    	a.insert(a);
    	
    	
    	
    	
//    	a.insert(a);
//    	a.update(a);
//    	a.delete("002");
    	List<Object> list1 = new ArrayList<Object>();
    	List<Object> list2 = new ArrayList<Object>();
//		ResultSet rs = a.getAll("002");
//
//	
//		list = a.excuteQuery(a.getAll("002"));
//		System.out.println(list);
//		Map map = (Map)list.get(0);
//		System.out.println(map.get("Acontent"));
		
		ResultSet r = a.All();
		ResultSet single = a.getAll("001");
		list1 = a.excuteQuery(r);
		list2 = a.excuteQuery(single);
		Map map2 = (Map)list2.get(0);
//		for(int i=0;i<list.size();i++)
//		{
//			System.out.println(list.get(i));
////			System.out.println(list.get(i));
//		}
		System.out.println(map2.get("Acontent"));
    }
}
