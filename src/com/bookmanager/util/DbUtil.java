package com.bookmanager.util;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ⹤����
 * @author WenRan
 *
 */
public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/db_book?serverTimezone=UTC";//���ݿ����ӵ�ַ
	private String dbUserName="root";//�û���
	private String dbPassword="1234";//����
	private String jdbcName="com.mysql.cj.jdbc.Driver";//��������
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;		
	}
	
	/**
	 * �ر����ݿ�����
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	
	/**
	 * ����������
	 * @param args
	 */
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();	
			System.out.println("���ݿ����ӳɹ���");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
		
	}
	
}
