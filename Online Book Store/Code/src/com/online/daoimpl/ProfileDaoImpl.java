package com.online.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.online.bean.ProfileDTO;
import com.online.daoi.ProfileDaoI;
import com.online.db.ConnectionFactory;
import com.online.db.SqlConstants;

public class ProfileDaoImpl implements ProfileDaoI {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public boolean addCustomer(ProfileDTO profileDTO) {
		boolean falg = false;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._REGISTER);
			preparedStatement.setString(1, profileDTO.getUsername());
			preparedStatement.setString(2, profileDTO.getConformpassword());
			preparedStatement.setString(3, profileDTO.getEmail());
			preparedStatement.setString(4, profileDTO.getDob());
			preparedStatement.setLong(5, profileDTO.getPhone());
			preparedStatement.setString(6, profileDTO.getSquest());
			preparedStatement.setString(7, profileDTO.getSecrete());
			preparedStatement.setString(8, profileDTO.getFullname());
			preparedStatement.setString(9, profileDTO.getRole());
			preparedStatement.setString(10, profileDTO.getGender());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				preparedStatement = connection
						.prepareStatement(SqlConstants._ADDRESS);
				preparedStatement.setString(1, profileDTO.getHouseno());
				preparedStatement.setString(2, profileDTO.getStreet());
				preparedStatement.setString(3, profileDTO.getCity());
				preparedStatement.setString(4, profileDTO.getState());
				preparedStatement.setString(5, profileDTO.getCountry());
				preparedStatement.setInt(6, profileDTO.getPin());
				int j = preparedStatement.executeUpdate();
				if (j > 0) {
					falg = true;
				} else {
					falg = false;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return falg;
	}

	public String recoverPassword(ProfileDTO pf) {

		connection = ConnectionFactory.getConnection();
		String password1 = null;
		String username = pf.getUsername();
		String squest = pf.getSquest();
		String sanswer = pf.getSecrete();
		System.out.println("sanswer" + sanswer);
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._RECOVER_PASSWORD);
			preparedStatement.setString(1, squest);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, sanswer);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				password1 = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password1;
	}

	public Vector<ProfileDTO> viewProfile(int id) {
		Vector<ProfileDTO> alist = new Vector<ProfileDTO>();
		connection = ConnectionFactory.getConnection();
		try {
			String sql = SqlConstants._VIEW_PROFILE;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProfileDTO profile = new ProfileDTO();
				profile.setUsername(resultSet.getString(1));
				profile.setPassword(resultSet.getString(2));
				profile.setEmail(resultSet.getString(3));
				profile.setDob(resultSet.getString(4));
				profile.setPhone(resultSet.getLong(5));
				profile.setSquest(resultSet.getString(6));
				profile.setSecrete(resultSet.getString(7));
				profile.setFullname(resultSet.getString(8));
				profile.setGender(resultSet.getString(9));
				profile.setHouseno(resultSet.getString(10));
				profile.setStreet(resultSet.getString(11));
				profile.setCity(resultSet.getString(12));
				profile.setState(resultSet.getString(13));
				profile.setCountry(resultSet.getString(14));
				profile.setPin(resultSet.getInt(15));
				alist.add(profile);
				System.out.println(alist.size());
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return alist;
	}

	

	public Vector<ProfileDTO> viewUsers() {
		Vector<ProfileDTO> alist = new Vector<ProfileDTO>();
		connection = ConnectionFactory.getConnection();
		try {
			String sql = SqlConstants._VIEW_USERS;
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProfileDTO profile = new ProfileDTO();
				profile.setUsername(resultSet.getString(1));
				profile.setPassword(resultSet.getString(2));
				profile.setEmail(resultSet.getString(3));
				profile.setDob(resultSet.getString(4));
				profile.setPhone(resultSet.getLong(5));
				profile.setSquest(resultSet.getString(6));
				profile.setSecrete(resultSet.getString(7));
				profile.setFullname(resultSet.getString(8));
				profile.setGender(resultSet.getString(9));
				profile.setHouseno(resultSet.getString(10));
				profile.setStreet(resultSet.getString(11));
				profile.setCity(resultSet.getString(12));
				profile.setState(resultSet.getString(13));
				profile.setCountry(resultSet.getString(14));
				profile.setPin(resultSet.getInt(15));
			
				alist.add(profile);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return alist;
	}

}