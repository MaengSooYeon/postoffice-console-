import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

	public class Mail{//���� ����
		
	private double MailWeight;  //���� �߷�
	private int MailCount;  //���� ����
	private String answer; // �Է¹޴� ��
	private int pay; //�ݾ�
	private String m_phoneNumber; //���� ��ȭ��ȣ
	private String m_address; //�ּ�
	private String m_addresser; //������
	private String m_addressee; //�߽���
	private final String URL= "jdbc:mysql://localhost/testdb?characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false\\r\\n&serverTimezone=UTC&useSSL=false";

	Mail(String address, String addressee, String addresser, String phoneNumber) { //���� ������
			this.m_address=address; 
			this.m_addressee=addressee;
			this.m_addresser=addresser;
			this.m_phoneNumber=phoneNumber;
			
		}//end of ������

		public double getMailWeight() {
		return MailWeight;
	}

	public void setMailWeight(double mailWeight) {
		MailWeight = mailWeight;
	}

	public int getMailCount() {
		return MailCount;
	}

	public void setMailCount(int mailCount) {
		MailCount = mailCount;
	}

	public String getM_phoneNumber() {
		return m_phoneNumber;
	}

	public void setM_phoneNumber(String m_phoneNumber) {
		this.m_phoneNumber = m_phoneNumber;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public String getM_addresser() {
		return m_addresser;
	}

	public void setM_addresser(String m_addresser) {
		this.m_addresser = m_addresser;
	}

	public String getM_addressee() {
		return m_addressee;
	}

	public void setM_addressee(String m_addressee) {
		this.m_addressee = m_addressee;
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
			String Type = "����";
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

	public void MailCheck() { //���� ��� ��ȸ
		Scanner scan= new Scanner(System.in);
		System.out.println("���� ������ �Է��ϼ���"); //��������Է�
		System.out.print("-> ");
		int ncount = scan.nextInt();
		System.out.println("���� ���Ը� �Է��ϼ���(����: 0.0g)"); //�������Է�
		System.out.print("-> ");
		double nweight = scan.nextDouble();

		this.MailCount = ncount; //����
		this.MailWeight = nweight; //�߷�

		if(this.MailWeight <= 5.0 && this.MailWeight > 0.0) { //0�ʰ� 5����
			pay = 350;
		} else if(this.MailWeight *this.MailCount > 5.0 && this.MailWeight *this.MailCount <= 25.0 ) { //5�ʰ� 25����
			pay = 380;
		} else if(this.MailWeight *this.MailCount > 25.0  && this.MailWeight *this.MailCount<= 50.0 ) { //25�ʰ� 50����
			pay= 400;
		} else{ //50 �ʰ�
			System.out.println("������ �ִ� �߷��� 50���� �Դϴ�. �ٽ� �Է����ּ���.");
		}
		//��¹�
		System.out.println("");
		System.out.println("���� ����: " + this.MailCount + "�� " + "\n" 
				+"�߷�: " + this.MailWeight + "g  " + "\n"
				+"�� �ݾ���: " + pay + "�Դϴ�.");
		System.out.println("");
	} //end of MailCheck
	
	}//end of mail