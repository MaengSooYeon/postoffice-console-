
	import java.sql.CallableStatement;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
import java.util.Scanner;
	
public class Client {
	
	private static Connection conn;
    private PreparedStatement pstmt;
    private CallableStatement cstmt;
    private ResultSet rs;
	private String sql;
	private final String URL= "jdbc:mysql://localhost/testdb?characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false\\r\\n&serverTimezone=UTC&useSSL=false";
    private Statement st= null;
    

		     private void getConnection() throws SQLException, ClassNotFoundException{ //db �� ����
		    	 Connection conn = null;
		            //��������
		            String url = "jdbc:mysql://localhost/testdb?characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false\\r\\n&serverTimezone=UTC&useSSL=false";
		            System.out.println("���� ����");
		            
		            java.util.Scanner in = new java.util.Scanner(System.in);
					java.sql.Statement stmt = conn.createStatement();
		            java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);

		            //JDBC����̹� �ε�
		            Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection(url, "root", "se9703709");
	        
		     }//end of getConnection

	    /**
	    * ȸ����ȣ�� �ش��ϴ� ȸ������ ����
	    */
	    public Parcel getMember(String Number){ //������ȣ�� �´� ȸ������ ����
	    	 Connection conn = null;
	 		
	 		try {
	 			Class.forName("com.mysql.jdbc.Driver");
	 			conn = DriverManager.getConnection(URL, "root", "Weak");
	 			System.out.println("������ �ҷ����� �� �Դϴ�.");
				System.out.println("...");
				System.out.println("");
	 			
	 			java.util.Scanner in = new java.util.Scanner(System.in);
	 			java.sql.Statement stmt = conn.createStatement();
	            java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);
	 			
	 			
	 			java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE Number='"+Number+"'");
	 			rs.beforeFirst();
	 			System.out.println("====================================================================================");
	 			System.out.println("     �ּ�                     ������           �߽���                     ��ȭ��ȣ                   ����� ��ȣ          	        Ÿ��  		");
	 			System.out.println("====================================================================================");
	 			while(rs.next()) {
	 			
	 				System.out.println(rs.getString("address")+"           "+
				 			rs.getString("addressee")+"           "+
				 			rs.getString("addresser")+"               "+
				 			rs.getString("phoneNumber")+"        "+
				 			rs.getString("number")+"       "+
				 			rs.getString("Type"));
	 			}//while
	 			System.out.println("====================================================================================");
	 			conn.close();
	 		}
	 		catch(ClassNotFoundException e) {
	 			System.out.println("����̹� �ε� ����");
	 		}
	 		catch(SQLException e) {
	 			System.out.println("����:" +e);
	 		}
	 		finally {
	 			try {
	 				if(conn != null && !conn.isClosed()) {
	 					conn.close();
	 				}
	 			}
	 			catch(SQLException e) {
	 				e.printStackTrace();
	 			}
	 		}
	 		//return false;
			return null;
	     
	     }
	    /**
	    * ����� ȸ�� ��� ����
	    */
	    public boolean getMemberList(){
	    	Connection conn = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(URL, "root", "se9703709");
				System.out.println("");
				System.out.println("������ �ҷ����� �� �Դϴ�.");
				System.out.println("...");
				System.out.println("");
				
				java.util.Scanner in = new java.util.Scanner(System.in);
				java.sql.Statement stmt = conn.createStatement();
	            java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);
	          
				
				java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM user");
				rs.beforeFirst();
	 			System.out.println("====================================================================================");
	 			System.out.println("     �ּ�                     ������           �߽���                     ��ȭ��ȣ                   ����� ��ȣ          	        Ÿ��  		");
	 			System.out.println("====================================================================================");
				while(rs.next()) {
				
					System.out.println(rs.getString("address")+"           "+
				 			rs.getString("addressee")+"           "+
				 			rs.getString("addresser")+"               "+
				 			rs.getString("phoneNumber")+"        "+
				 			rs.getString("number")+"       "+
				 			rs.getString("Type"));
				}//while
				System.out.println("====================================================================================");
				conn.close();
			}
			catch(ClassNotFoundException e) {
				System.out.println("����̹� �ε� ����");
			}
			catch(SQLException e) {
				System.out.println("����:" +e);
			}
			finally {
				try {
					if(conn != null && !conn.isClosed()) {
						conn.close();
					}
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
	    }//end of getmemberlist
	   //ȸ�� ���� 
	    
	    public void test(String address, String addressee,String addresser,String phonenumber) {

	    	  try {
	    		  Scanner scan=new Scanner(System.in);
	    		  Class.forName("com.mysql.jdbc.Driver");
		 			Connection conn = DriverManager.getConnection(URL, "root", "se9703709");
		 			st = conn.createStatement();
		 			System.out.println("������ ������ȣ�� �Է��ϼ���:");
					System.out.print("-> ");
					System.out.println("");
		 			String number=scan.next();
		 			String update = ("UPDATE user SET address ='"+address+"',addressee='"+addressee+"',addresser='"+addresser+"',phonenumber='"+phonenumber+"'WHERE number="+number+";");
		 			System.out.println("");
		 			st.executeUpdate(update);
	    	  
		 			String insert="SELECT*FROM user WHERE number='"+number+"';";
		 			System.out.println("");
		 			rs= st.executeQuery(insert);
	    	  
	    	   while(rs.next()) {
		 				String Address = rs.getString("address");
		 				String Addressee = rs.getString("addressee");
		 				String Addresser = rs.getString("addresser");
		 				String Phonenumber = rs.getString("phonenumber");
		 				System.out.println(" | "+Address+" | "+Addressee+" | "+Addresser+" | "+Phonenumber+" | ");
		 			}
	    }
	    	  catch(ClassNotFoundException ex) {
	    		  System.out.println("�ε� ����");
	    	  }catch(SQLException ex) {
	    		  System.out.println("���� :"+ex);
	    	  }
	    	  finally {
	    		  if(rs!=null) {
	    			  try {
						st.close();
	    			  }catch(SQLException ex) {
	    				  ex.printStackTrace();
	    			  }
	    		  }
	    		  if(st != null) {
	    			  try {
	    				  st.close();
	    			  }catch (SQLException ex) {
	    				  ex.printStackTrace();
	    			  }
	    		  }
	    	  }
	    }

	    /**
	    * ȸ�� ����
	    */
	    public boolean deleteM(String number){        
	     
	    	boolean result = false;            
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(URL, "root", "se9703709");
				java.sql.Statement stmt = conn.createStatement();
				String delete=("DELETE FROM user WHERE number ="+number+";");
				stmt.executeUpdate(delete);
	            
	        } catch (Exception e) {
	            System.out.println("���ܹ߻�:deleteMember()=> "+e.getMessage());
	        }finally{          
	            //dbClose();
	        }      
	        return result;
	    }//deleteMember()--------------
	    
	public void deleteMember(){
	
	Client cl = new Client();
    Scanner scan = new Scanner(System.in);
    System.out.println("������ ������ȣ�� �Է����ּ���");
	System.out.print("-> ");
    String Number = scan.nextLine();
    cl.deleteM(Number);
    System.out.println("");
    System.out.println("ȸ�������� �����Ǿ����ϴ�.");
	}  
}//end of client 