package com.online.daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.online.bean.SearchDTO;
import com.online.daoi.OrderDaoI;
import com.online.db.ConnectionFactory;
import com.online.db.SqlConstants;
import com.online.delegate.BookServiceMgrDelegate;

public class OrderDaoImpl implements OrderDaoI {

	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement, pstmt = null;

	public boolean addCategoty(String category) {
		boolean flag = false;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._ADD_CATEGORY);
			preparedStatement.setString(1, category);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				flag = true;
				connection.commit();
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean addBookInfo(SearchDTO dto, String isbn) {
		boolean flag = false;
		try {

			connection = ConnectionFactory.getConnection();

			preparedStatement = connection
					.prepareStatement(SqlConstants._ADD_BOOK_INFO);
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, dto.getTitle());
			preparedStatement.setString(3, dto.getDescription());
			preparedStatement.setFloat(4, dto.getPrice());
			preparedStatement.setString(5, dto.getPublisher());
			preparedStatement.setInt(6, dto.getEdition());
			preparedStatement.setInt(7, dto.getPages());
			preparedStatement.setString(8, dto.getLanguage());
			File file = new File(dto.getImage());
			FileInputStream fileInputStream = new FileInputStream(file);
			preparedStatement.setBinaryStream(9, fileInputStream, (int) file
					.length());
			preparedStatement.setInt(10, dto.getQuantity());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {

				preparedStatement = connection
						.prepareStatement(SqlConstants._ADD_AUTHOR);
				preparedStatement.setString(1, dto.getFname());
				int j = preparedStatement.executeUpdate();
				if (j > 0) {
					preparedStatement = connection
							.prepareStatement(SqlConstants._ADD_BOOK_AUTHORS);
					preparedStatement.setString(1, isbn);
					int k = preparedStatement.executeUpdate();
					if (k > 0) {
						preparedStatement = connection
								.prepareStatement(SqlConstants._ADD_BOOK_CATEGORIES);
						preparedStatement.setInt(1, dto.getCategoryid());
						preparedStatement.setString(2, isbn);
						int l = preparedStatement.executeUpdate();
						if (l > 0) {
							flag = true;

						} else {
							flag = false;
							connection.rollback();
						}
					} else {
						flag = false;
					}

				} else {
					flag = false;
				}
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return flag;
	}

	public boolean updateBranch(SearchDTO cb) {

		boolean flag = true;
		try {
			connection = ConnectionFactory.getConnection();
			pstmt = connection
					.prepareStatement("update bookdescriptions set title=?,DESCRIPTION=?,price=?,publisher=? where isbn=?");
			pstmt.setString(1, cb.getTitle());

			System.out.println(cb.getTitle());
			System.out.println("title" + cb);
			pstmt.setString(2, cb.getDescription());
			System.out.println(cb.getDescription());
			pstmt.setFloat(3, cb.getPrice());
            System.out.println(cb.getPrice());
			pstmt.setString(4, cb.getPublisher());
			System.out.println(cb.getPublisher());
			pstmt.setString(5, cb.getIsbn());
           	System.out.println(cb.getIsbn());
			int update = pstmt.executeUpdate();
			System.out.println("updated" + update);
			if (update > 0) {

				connection.commit();
			} else {
				flag = false;
				connection.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				connection.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	public boolean placeOrder(String userid, float total) {

		boolean flag = false;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._PLACE_ORDER);
			preparedStatement.setString(1, userid);
			preparedStatement.setFloat(2, total);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				preparedStatement = connection
						.prepareStatement(SqlConstants._UPDATE_STATUS);
				preparedStatement.setString(1, userid);
				int j = preparedStatement.executeUpdate();
				if (j > 0) {
					flag = true;
					connection.commit();
				} else {
					flag = false;
					connection.rollback();
				}
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean deleteCartItem(int cartid) {
		boolean flag = false;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._DELETE_CART_ITEM);
			preparedStatement.setInt(1, cartid);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				flag = true;
				connection.commit();
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean acceptOrder(int orderid) {
		boolean flag = false;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._ACCEPT_ORDER);
			preparedStatement.setInt(1, orderid);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				flag = true;
				connection.commit();
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean rejectOrder(int orderid) {
		boolean flag = false;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._REJECT_ORDER);
			preparedStatement.setInt(1, orderid);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				flag = true;
				connection.commit();
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

}
