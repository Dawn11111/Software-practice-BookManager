package com.bookmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookmanager.model.User;

/**
 * �û�Dao�ࣨDao�����ݷ��ʶ��󣩣�data access object��
 * @author WenRan
 *
 */
public class UserDao {
	/**
	 * ��½��֤
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{//user�ǽ��洫�������û���Ϣ
		User resultUser=null;
		String sql="select * from t_user where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());//�������û���
		pstmt.setString(2,user.getPassword());//����������
		ResultSet rs=pstmt.executeQuery();//ִ��pstmt֮�󷵻صĽ����
		if(rs.next()) {//�жϽ�����Ƿ�����һ����¼
			resultUser=new User();//�м�¼�ͽ���ʵ��������������
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
				
		}
		
		return resultUser;
		
	}

}
