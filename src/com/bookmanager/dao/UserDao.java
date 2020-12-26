package com.bookmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookmanager.model.User;

/**
 * 用户Dao类（Dao（数据访问对象）：data access object）
 * @author WenRan
 *
 */
public class UserDao {
	/**
	 * 登陆验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{//user是界面传过来的用户信息
		User resultUser=null;
		String sql="select * from t_user where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());//传过来用户名
		pstmt.setString(2,user.getPassword());//传过来密码
		ResultSet rs=pstmt.executeQuery();//执行pstmt之后返回的结果集
		if(rs.next()) {//判断结果集是否有下一条记录
			resultUser=new User();//有记录就进行实例化并进行设置
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
				
		}
		
		return resultUser;
		
	}

}
