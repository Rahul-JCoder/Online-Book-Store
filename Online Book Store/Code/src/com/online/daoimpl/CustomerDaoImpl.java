package com.online.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.online.bean.BookOrderDTO;
import com.online.daoi.CustomerDaoI;
import com.online.db.ConnectionFactory;
import com.online.db.SqlConstants;

public class CustomerDaoImpl implements CustomerDaoI {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet, resultSet2 = null;

	public boolean addToCart(String isbn, float price, int id, BookOrderDTO dto) {

		int count = 0;
		boolean flag = false;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._ADD_TO_CART);
			preparedStatement.setString(1, isbn);
			preparedStatement.setFloat(2, price);
			preparedStatement.setInt(3, id);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				flag = true;

				preparedStatement = connection
						.prepareStatement(SqlConstants._COUNT);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					count = resultSet.getInt(1);
					dto.setCount(count);
					System.out.println("count value is" + count);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	public Vector<BookOrderDTO> viewCart(int id) {
		BookOrderDTO bookOrderDTO = null;
		Vector<BookOrderDTO> bookOrderDTOs = new Vector<BookOrderDTO>();
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_CART);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bookOrderDTO = new BookOrderDTO();
				bookOrderDTO.setOrderid(resultSet.getInt(1));
				bookOrderDTO.setIsbn(resultSet.getString(2));
				bookOrderDTO.setQuantity(resultSet.getInt(3));
				bookOrderDTO.setPrice(resultSet.getFloat(4));
				preparedStatement = connection
						.prepareStatement(SqlConstants._VIEW_QUANTITY);
				preparedStatement.setString(1, bookOrderDTO.getIsbn());
				resultSet2 = preparedStatement.executeQuery();
				while (resultSet2.next()) {
					int inventory = resultSet2.getInt(1);
					bookOrderDTO.setInventory(inventory);

				}
				bookOrderDTOs.add(bookOrderDTO);
				System.out.println("size is" + bookOrderDTOs.size());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return bookOrderDTOs;

	}

	public Vector<BookOrderDTO> viewCustomerOrders(String s) {
		BookOrderDTO bookOrderDTO = null;
		Vector<BookOrderDTO> bookOrderDTOs = new Vector<BookOrderDTO>();
		try {
			connection = ConnectionFactory.getConnection();
			if(s.equals("r"))
				preparedStatement = connection
				.prepareStatement("select * from totalorders where status!='pending'");
			else
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_CUSTOMER_ORDERS);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bookOrderDTO = new BookOrderDTO();
				bookOrderDTO.setOrderid(resultSet.getInt(1));
				bookOrderDTO.setUserid(resultSet.getInt(2));
				bookOrderDTO.setOrderdate(resultSet.getString(3));
				bookOrderDTO.setPrice(resultSet.getFloat(4));
				bookOrderDTO.setOrderstatus(resultSet.getString(5));
				bookOrderDTOs.add(bookOrderDTO);
				System.out.println("size is" + bookOrderDTOs.size());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return bookOrderDTOs;

	}

	public Vector<BookOrderDTO> viewOrderStatus(int id) {
		BookOrderDTO bookOrderDTO = null;
		Vector<BookOrderDTO> bookOrderDTOs = new Vector<BookOrderDTO>();
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_ORDER_STATUS);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bookOrderDTO = new BookOrderDTO();
				bookOrderDTO.setOrderid(resultSet.getInt(1));
				bookOrderDTO.setUserid(resultSet.getInt(2));
				bookOrderDTO.setOrderdate(resultSet.getString(3));
				bookOrderDTO.setPrice(resultSet.getFloat(4));
				bookOrderDTO.setOrderstatus(resultSet.getString(5));
				bookOrderDTOs.add(bookOrderDTO);
				System.out.println("size is" + bookOrderDTOs.size());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return bookOrderDTOs;

	}

	public boolean post(String isbn, String opnion) {

		boolean flag = false;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants._POST);
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, opnion);

			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				connection.rollback();
			}
		} catch (SQLException e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		}
		return flag;
	}

	public Vector<BookOrderDTO> viewEditorials(String isbn) {
		BookOrderDTO bookOrderDTO = null;
		Vector<BookOrderDTO> bookOrderDTOs = new Vector<BookOrderDTO>();
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_EDITORIALS);
			preparedStatement.setString(1, isbn);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				bookOrderDTO = new BookOrderDTO();
				bookOrderDTO.setIsbn(resultSet.getString(1));
				bookOrderDTO.setEditorial(resultSet.getString(2));
				bookOrderDTOs.add(bookOrderDTO);
				System.out.println("size is" + bookOrderDTOs.size());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return bookOrderDTOs;

	}

}
