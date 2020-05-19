import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Pay {
	
   
	
	private int pay; // ���
	private int userpay; //������� �ݾ� 
	private double pweight; // �ù� ����
	private int pcount;//�ù� ���� 
	private double  mweight; //���� �߷�
	private double mcount; //���� ����
	private String number;//������ȣ
	private String answer=null; //�� �Է� �޴� ��
	private Statement st= null;
	
	
	
	void p_calculation(){ //�ù� ��� ���
		Scanner scan=new Scanner(System.in); 
		System.out.println("�ù� ������ �Է��ϼ���  "); 
		System.out.print("-> ");
		int pcount=scan.nextInt();
		
		System.out.println("�ù� �߷��� �Է��ϼ��� (����: 0.0)  ");
		System.out.print("-> ");
		double pweight=scan.nextDouble();
		
		//�ù� ���� ��� 

		this.pcount = pcount; // �Է¹��� ���� �Ѱ���
		this.pweight=pweight; // �Է¹��� ���� �Ѱ��� 

		if(this.pweight * this.pcount < 10.0 && this.pweight* this.pcount >= 0.0) { //�ù��� �߷��� 10kg�̸��̸� �⺻��� 5000��
			pay = 5000; //�⺻���
		}else if(this.pweight* this.pcount > 10.0){ //�ù��� �߷��� 10kg�ʰ��ϸ� �ù��߷� * 200�� *�ù����
			pay = (int) (this.pweight * 200 * this.pcount);
		}
		//�� �հ� ���
		System.out.println("");
		System.out.println("*************************************");
		System.out.println("�ù� ���� : " + this.pcount + "�� " + "\n" 
				+"�ù� ���� : " + this.pweight + "kg  " + "\n"
				+"�� �ݾ��� " + pay + "�� �Դϴ�.");
		System.out.println("*************************************");
		System.out.println("");
	}//end of payment
	
	
	void m_calculation() { //���� ��� ���
		Scanner scan= new Scanner(System.in);
		System.out.println("���� ������ �Է��ϼ���  "); 
		System.out.print("-> ");
		int mcount = scan.nextInt();
		
		System.out.println("���� �߷��� �Է��ϼ���(����: 0.0kg)");
		System.out.print("-> ");
		double mweight = scan.nextDouble();

		this.mcount = mcount; //�Է¹��� ���� �Ѱ���
		this.mweight = mweight; //�Է¹��� ���� �Ѱ���

		if(this.mweight * this.mcount <= 5.0 && this.mweight * this.mcount > 0.0) { //���� ���԰� 5g ���ϸ� �⺻��� 350��
			pay = 350;
		} else if(this.mweight * this.mcount > 5.0 && this.mweight * this.mcount <= 25.0) { //���� ���԰� 5g�ʰ� 25g�����̸� �⺻��� 380��
			pay = 380;
		} else if(this.mweight * this.mcount > 25.0 && this.mweight * this.mcount <= 50.0) { //���� ���԰� 25g�ʰ� 50g�����̸� �⺻��� 400��
			pay= 400;
		} else{ 
			pay= 500;
		}
		//�� �հ� ���
		System.out.println("");
		System.out.println("*************************************");
		System.out.println("���� ���� : " + this.mcount + "�� " + "\n" 
				+"���� �߷� : " + this.mweight + "g  " + "\n"
				+"�� �ݾ��� " + pay + "�� �Դϴ�.");
		System.out.println("*************************************");
		System.out.println("");
	}
	


		void Payment(){
				Scanner scan=new Scanner(System.in); 
				System.out.println("������ �������� �Ͻðڽ��ϱ�?");
				System.out.println("1.ī�� / 2.����");
				System.out.println("");
				System.out.println("��ȣ�� �Է����ּ��� ");
				System.out.print("-> ");
				System.out.println("");
				int answer=scan.nextInt();
				
				switch(answer) {
				case 1: //ī�����
						System.out.println("������ ... ��ø� ��ٷ��ֽʽÿ�.");

						break;

				case 2: //���ݰ���
						System.out.println("�ݾ��� �־��ֽʽÿ� (oooo��) ");
						System.out.print("->");
						userpay=scan.nextInt();
						System.out.println("");
						System.out.println("������... ��ø� ��ٷ��ֽʽÿ�.");
						System.out.println("");
						
						if(userpay>pay) {
							System.out.println("*************************************");
							System.out.println("�Ž��� ���� "+ (userpay-pay) +"�Դϴ�.");
						}else if (userpay==pay) {
							System.out.println("*************************************");
							System.out.println("�Ž��� ���� �����ϴ�. ");
						}else {
							System.out.println("*************************************");
							System.out.println((pay-userpay)+"��  �����մϴ�. ");
							System.out.println("");
							System.out.println("������ ��ҵǾ����ϴ�. ó������ �ٽ� �Է����ּ���.");
							System.out.println("*************************************");
							Payment();
						}
							break;
			
						}
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
							System.out.println("�̿����ּż� �����մϴ�.");
							System.out.println("*************************************");
						}
						} //end of pay