package com.online.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.online.bean.ProfileDTO;
import com.online.daoi.SecurityDaoI;
import com.online.db.ConnectionFactory;
import com.online.db.SqlConstants;

public class SecurityDaoImpl implements SecurityDaoI{

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
		public String checkUser(ProfileDTO p) 
		{
			con = ConnectionFactory.getConnection();
			String loginid = p.getUsername();
			System.out.println("in DAO Login user is............." + loginid);
			String password = p.getPassword();
			System.out.println("in DAO Login pass is............." + password);
			String role = "";
			int userid = 0;

			try {
				System.out.println("con" + con);
				pstmt = con.prepareStatement(SqlConstants._GET_LOGINTYPE);
				pstmt.setString(1, loginid);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					userid = rs.getInt(1);
					System.out.println("userid is" + userid);
					role = rs.getString(2);

				}
				p.setUserid(userid);
				System.out.println("userid is" + userid);

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			System.out.println("roleis...." + role);
			return role;

		}
		public boolean changePassword(ProfileDTO rb) {
			boolean flag = true;
			String loginid = rb.getUsername();
			String oldpassword = rb.getPassword();
			String newpassword = rb.getNewpassword();
			try {
				con = ConnectionFactory.getConnection();
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(SqlConstants._CHANGE_PASSWORD);
				pstmt.setString(1, newpassword);
				pstmt.setString(2, loginid);
				pstmt.setString(3, oldpassword);
				
				int i = pstmt.executeUpdate();
				if (i == 1) {
					flag = true;
					con.commit();
				} 
						else
						{
							flag=false;
							con.rollback();
						}
					
			} catch (SQLException ex) {
				ex.printStackTrace();

				flag = false;
				try {
					con.rollback();
				} catch (SQLException se) {

				}

			}

			return flag;
		}
}


