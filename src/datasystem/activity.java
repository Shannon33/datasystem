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
	        System.out.println("���ݿ����ӳɹ���");
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
//	��
	public int insert(activity A) {
//		��������
	    Connection conn = getConn();
	    int i = 0;
//	    ʹ��ռλ������SQL��䡣
	    String sql = "insert into activity (Aid,Aname,Adate,Acontent,Asponsor,Dno) values(?,?,?,?,?,?)";
	    try {
//	    	sqlԤ����
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
//	        ���ݲ���
	        pstmt.setString(1, A.getAid());
	        pstmt.setString(2, A.getAname());
	        pstmt.setString(3, A.getAdata());
	        pstmt.setString(4, A.getAcontent());
	        pstmt.setString(5, A.getAsponsor());
	        pstmt.setString(6, A.getDno());

//	        ������SQL���ִ��Ӱ���������
	        i = pstmt.executeUpdate();
	        System.out.println("���ݲ���ɹ���");
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
	    }finally {
//	    	�ͷ�������Դ
	    	closeAll();
		}
	    return i;
	}
//	ɾ����ѧ��ɾ����
	public int delete(String aid) {
	    Connection conn = getConn();
	    int i = 0;
//	    ʹ��ռλ������SQL��䡣
	    String sql = "delete from activity where Aid='" + aid + "'";
	    try {
//	    	sqlԤ����
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("����ɾ���ɹ���");
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

//	��
	public int update(activity A) {
	    Connection conn = getConn();
	    int i = 0;
//	    ƴ��sql���
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
	        System.out.println("���ݸ��³ɹ���");
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
	
//	��
	public ResultSet getAll(String aid) {
	    Connection conn = getConn();
	    ResultSet rs = null;
	    String sql = "select * from activity where Aid='" + aid + "'";
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        System.out.println("���ݲ�ѯ�ɹ���");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
//	    ����ResultSet��
	    return rs;
	}
	
	public ResultSet All() {
	    Connection conn = getConn();
	    ResultSet rs = null;
	    String sql = "select * from activity ";
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        System.out.println("���ݲ�ѯ�ɹ���");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
//	    ����ResultSet��
	    return rs;
	}
//	��ResultSet��������List<map>��
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
//            	����map
                Map<String, Object> map = new HashMap<String, Object>();    
                for (int i = 1; i <= columnCount; i++) {  
//                	getColumnLabel������ȡ�����������Ŀ������
                    map.put(rsmd.getColumnLabel(i), rs.getObject(i));    
                }    
                list.add(map);    
            }    
        } catch (SQLException e) {    
            System.out.println(e.getMessage());    
        }finally {
	    	closeAll();
		}
//        ����һ��list<Map>
        return list;    
    } 

    public static void main(String[] args) {
    	
    	activity a = new activity();
//    	a.setAid("002");
//    	a.setAname("����");
//    	a.setAcontent("09��00 -- ���Ӷӳ��������(������������) ����\n"
//    			+ "09��05 -- �ӹ�˾���� ����\n"
//    			+ "10��00 -- ����Ŀ�ĵ� ����\n"
//    			+ "10��05 -- ��ʼ����Ȥζ��Ϸ�(�����������һ) ����\n"
//    			+ "a�������� ����b������������ ����c�������� ����\n"
//    			+ "12��00 -- �� �� �����ۺ�����(�䷢2003���ȫ�ڽ�) ����\n"
//    			+ "3��30 -- ����� ����������1���� (2Сʱ13��30) ������ë��2������(��1Сʱ13��30) ����ƹ����2����(��1Сʱ13��30) ������ ��1������(2Сʱ13��30) ������ ��1������(1Сʱ13��30) ����\n"
//    			+ "18��00 -- ��� ����18��30 -- ���سɶ� \n");
//    	a.setAsponsor("ĳ����");
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
