
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Parcel {

	private String p_address; //�ּ�
	private String p_addressee; //������
	private String p_addresser;// �߽��� 
	private String p_phoneNumber;//��ȭ��ȣ
	private String p_number; //���� ������ȣ
	private final String URL= "jdbc:mysql://localhost/testdb?characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false\\r\\n&serverTimezone=UTC&useSSL=false";



	Parcel(String address,  String addressee, String addresser, String phoneNumber){
		this.p_address= address;
		this.p_addressee=addressee;
		this.p_addresser=addresser;
		this.p_phoneNumber=phoneNumber;
	} //������
	
	public String getAddress() {
		return p_address;
	}
	public void setAddress(String address) {
		this.p_address = address;
	}
	public String getAddressee() {
		return p_addressee;
	}
	public void setAddressee(String addressee) {
		this.p_addressee = addressee;
	}
	public String getAddresser() {
		return p_addresser;
	}
	public void setAddresser(String addresser) {
		this.p_addresser = addresser;
	}
	public String getPhoneNumber() {
		return p_phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.p_phoneNumber = phoneNumber;
	}
	public String getNumber() {
		return p_number;
	}
	public void setNumber(String number) {
		this.p_number = number;
	}
	
	
	public static String numberGen(int len, int dupCd ) {
        
        Random rand = new Random();
        String numStr = ""; //������ ����� ����
        
        for(int i=0;i<len;i++) {

            String ran = Integer.toString(rand.nextInt(10));
            if(dupCd==1) {
                //�ߺ� ���� numStr�� append
                numStr += ran;
            }else if(dupCd==2) {
                //�ߺ��� ������� ������ �ߺ��� ���� �ִ��� �˻��Ѵ�
                if(!numStr.contains(ran)) {
                    //�ߺ��� ���� ������ numStr�� append
                    numStr += ran;
                }else {
                    //������ ������ �ߺ��Ǹ� ��ƾ�� �ٽ� �����Ѵ�
                    i-=1;
                }
            }
        }
        return numStr;
    }//end of numberGen
	
	public boolean insertMember(){   
		Connection conn = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(URL, "root", "Weak");
		System.out.println("");
		
		java.util.Scanner in = new java.util.Scanner(System.in);
		java.sql.Statement stmt = conn.createStatement();
        java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);
		
		System.out.println("======�����Է�=======");
		System.out.println("");
		System.out.println("�ּҸ� �Է��ϼ���(���� X) "); 
		System.out.print("-> ");
		String address = in.next();
		
		System.out.println("�������� �Է��ϼ���  ");
		System.out.print("-> ");
		String addressee = in.next();
		
		System.out.println("�߽����� �Է��ϼ���  ");
		System.out.print("-> ");
		String addresser = in.next();
		
		System.out.println("��ȭ��ȣ�� �Է��ϼ��� "); 
		System.out.print("-> ");
		String phoneNumber = in.next();
		
		System.out.println("���� �Է��� �������ϴ�."); 
		String number = numberGen(10,2);
		String Type = "�ù�";
		System.out.println("");
		System.out.println("������ȣ�� "+number+"�Դϴ�.");
		String dbCommand = "INSERT testdb.user VALUES('"+address+"','"+addressee+"','"+addresser +"','"+phoneNumber+"','"+number+"','"+Type+"')";
		System.out.println("**"+dbCommand);
		stmt.executeUpdate(dbCommand);

		conn.close();
	}
	catch(ClassNotFoundException e) {
		System.out.println("�����߻�");
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
	}
	}
 
