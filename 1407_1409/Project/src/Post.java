import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//package project1;

public class Post {
	public static void main(String[] args) throws IOException, SQLException{
		// TODO Auto-generated method stub
			
		home();
		
	}//end of main
	

	static Parcel p1= new Parcel(null, null, null, null);
	static Mail m1= new Mail(null, null, null, null);
	static Client c1= new Client();
	static Pay pa1= new Pay();

	public static void home() { //����
		Scanner scan= new Scanner(System.in);
		System.out.println("");
		System.out.println("********************************************************************");
		System.out.println("                    ��ü���� ���� �� ȯ���մϴ�~! ������ ���͵帱���?");
		System.out.println("");
		System.out.println("    <1> �ù� ����   <2> ���� ����   <3> ���� ��� ��ȸ   <4> ����� ��ȣ�� ���� ��ȸ"); 
		System.out.println("    <5> ���� ���   <6> ���� ����   <7> ������� ��� ���� ���� ");
		System.out.println("");
		System.out.println("********************************************************************");
		System.out.println("");
		System.out.println("��ȣ�� �Է����ּ��� ");
		System.out.print("-> ");
		int answer;
		answer=scan.nextInt();
		System.out.println("");
		
		
		switch(answer) {
		
		case 1: 
				parcelChoose(); //�ù� ����
				
				break;
		case 2: 
				mailChoose(); // ���� ����
				
		case 3: 
				searchMail(); // ���� ��� ��ȸ
				break;
				
		case 4:
				searchNumber(); //������ȣ�� ��� ��ȸ
				break;
		case 5: 
				cancel(); //���� ���
				break;
		
		case 6: modify();
				break;
				
		case 7:
				lookall(); //��� ���� ����  
				break;
		}
		
	}

	public static void parcelChoose() { //�ù�����
		Scanner scan=new Scanner(System.in);
			System.out.println("");
			System.out.println("�ù� ������ �Ͻðڽ��ϱ�?");
			System.out.println("1.��  / 2.�ƴϿ�");
			System.out.println("");
			System.out.println("��ȣ�� �Է����ּ��� ");
			System.out.print("-> ");
			int answer = scan.nextInt();
			if(answer==1) {
				p1.insertMember();
					System.out.println("");
					System.out.println("���� ��.. ���� â���� �Ѿ�ϴ�.");
					System.out.println("");
					pa1.p_calculation();
					System.out.println("");
					pa1.Payment();
					tohome();
			}else {
				tohome();
			}
		}

	public  static void mailChoose() { //���� ����
		Scanner scan= new Scanner(System.in);
			System.out.println("���� ������ �Ͻðڽ��ϱ�?");
			System.out.println("1.��  / 2.�ƴϿ�");
			System.out.println("");
			System.out.println("��ȣ�� �Է����ּ��� ");
			System.out.print("-> ");
			int answer = scan.nextInt();
				if(answer==1) {
					m1.insertMember();
						System.out.println("");
						System.out.println("���� ��.. ���� â���� �Ѿ�ϴ�.");
						System.out.println("");
						pa1.m_calculation();
						System.out.println("");
						pa1.Payment();
						
						tohome();
				}else {
						tohome();
				}
			}
	
	public static void  searchMail() { // ������ ��ȸ
		Scanner scan= new Scanner(System.in);
			System.out.println("���� ���� ����� ��ȸ�غ��ðڽ��ϱ�? ");
			System.out.println("1.�� / 2.�ƴϿ�");
			System.out.println("");
			System.out.println("��ȣ�� �Է����ּ��� ");
			System.out.print("-> ");
				int answer = scan.nextInt();
			if(answer==1) {
				m1.MailCheck();
				tohome();
			}else {
				tohome();
			}	
	}
	public static void searchNumber() { //������ȣ�� ���� ��ȸ
		Scanner scan= new Scanner(System.in);
				System.out.println("������ȣ�� ������ ��ȸ�غ��ðڽ��ϱ�? ");
				System.out.println("1.��  / 2.�ƴϿ�");
				System.out.println("");
				System.out.println("��ȣ�� �Է����ּ��� ");
				System.out.print("-> ");
				int answer = scan.nextInt();
				
				if(answer==1) {
						System.out.println("");
						System.out.println("����� ��ȣ�� �Է����ּ��� ");
						System.out.print("-> ");
						String Number=scan.next();
						
						c1.getMember(Number);
							tohome();
				}else {
						tohome();
				}
	}
	public static void cancel() { //���� ���
		Scanner scan= new Scanner(System.in);
			System.out.println("������ ����Ͻðڽ��ϱ�?"); 
			System.out.println("1.��  / 2.�ƴϿ�");
			System.out.println("");
			System.out.println("��ȣ�� �Է����ּ��� ");
			System.out.print("-> ");
			int answer=scan.nextInt();
			
			if(answer==1) {
				c1.deleteMember();
				tohome();
			}else {
				tohome();
			}
		
	}
	public static void modify() { //���� ����
		Scanner scan=new Scanner(System.in);
			System.out.println("����� ������ �����Ͻðڽ��ϱ�? ");
			System.out.println("1.��  / 2.�ƴϿ�");
			
			System.out.println("");
			System.out.println("��ȣ�� �Է����ּ��� ");
			System.out.print("-> ");
			int answer=scan.nextInt();
			
		if(answer==1) {
		System.out.println("������ �ּҸ� �Է��ϼ��� ");
		System.out.print("-> ");
			String address=scan.next();
		System.out.println("������ �������� �Է��ϼ��� ");
		System.out.print("-> ");
			String addressee=scan.next();
		System.out.println("������ �߽����� �Է��ϼ���  ");
		System.out.print("-> ");
			String addresser=scan.next();
		System.out.println("������ ��ȭ��ȣ�� �Է��ϼ��� ");
		System.out.print("-> ");
			String phonenumber=scan.next();
			c1.test(address, addressee, addresser, phonenumber);
			tohome();
		}else {
			tohome();
		}
	}//end of modify
	public static void lookall() { //��� ������� ���� ���� 
		Scanner scan= new Scanner(System.in);
			System.out.println("��� ������� ������ Ȯ���غ��ðڽ��ϱ�?"); 
			System.out.println("1.��  / 2.�ƴϿ�");
			System.out.println("");
			System.out.println("��ȣ�� �Է����ּ��� ");
			System.out.print("-> ");
			
			int answer=scan.nextInt();
			if(answer==1) {
				c1.getMemberList();
				tohome();
			}else {
				tohome();
			}
	}//end of lookall

	private static void tohome() {
		Scanner scan= new Scanner(System.in);
			System.out.println("");
			System.out.println("�������� �̵��Ͻðڽ��ϱ�?");
			System.out.println("1.��  / 2.�ƴϿ�");
			System.out.println("");
			System.out.println("��ȣ�� �Է����ּ��� ");
			System.out.print("-> ");
			
				int answer = scan.nextInt();
				if(answer==1) {
					home();
				}else {
					System.out.println("��ü���� �̿����ּż� �����մϴ�.");
				}		
	}//end of tohome
}//end of boxlookup

