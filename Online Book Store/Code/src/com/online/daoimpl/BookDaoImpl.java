package com.online.daoimpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import com.online.bean.SearchDTO;
import com.online.daoi.BookDaoI;
import com.online.db.ConnectionFactory;
import com.online.db.SqlConstants;

public class BookDaoImpl implements BookDaoI {
	Connection connection = null;
	PreparedStatement preparedStatement,ps1,ps2,ps3 = null;
	ResultSet rs = null;
	String path = "";
	String isbn = null;

	
	public Vector<SearchDTO> viewBookInfo(String isbn) {
		SearchDTO book = null;
		Vector<SearchDTO> alist = new Vector<SearchDTO>();
		connection = ConnectionFactory.getConnection();
		System.out.println("" + connection);
		try {
			String sql = SqlConstants._DISPLAY_BOOKS;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, isbn);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				book = new SearchDTO();
				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setDescription(rs.getString(3));
				book.setPrice(rs.getFloat(4));
				book.setPublisher(rs.getString(5));
				alist.add(book);
				}
				
				
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		return alist;
}
	
	public Vector<SearchDTO> viewBooks(String path) {
		SearchDTO book = null;
		Vector<SearchDTO> alist = new Vector<SearchDTO>();
		connection = ConnectionFactory.getConnection();
		System.out.println("" + connection);
		try {
			String sql = SqlConstants._VIEW_BOOKS;
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				book = new SearchDTO();
				isbn = rs.getString(1);
				book.setIsbn(isbn);
				book.setTitle(rs.getString(2));
				book.setDescription(rs.getString(3));
				book.setPrice(rs.getFloat(4));
				book.setPublisher(rs.getString(5));
				book.setPublicationdate(rs.getString(6));
				book.setEdition(rs.getInt(7));
				book.setPages(rs.getInt(8));
				book.setLanguage(rs.getString(9));
				Blob b = rs.getBlob(10);
				if (b != null) {
					byte b1[] = b.getBytes(1, (int) b.length());// new
																// byte[(int)b.length()];
					// InputStream in=photo.getBinaryStream();
					FileOutputStream fout = new FileOutputStream(path + "/"
							+ isbn + ".jpg");
					fout.write(b1);

					book.setImage(isbn + ".jpg");
				}
				book.setQuantity(rs.getInt(11));
				alist.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alist;

	}

	public Vector<SearchDTO> viewBook(String path) {
		SearchDTO book = null;
		Vector<SearchDTO> alist = new Vector<SearchDTO>();
		connection = ConnectionFactory.getConnection();
		System.out.println("" + connection);
		try {
			String sql = SqlConstants._VIEW_BOOKS1;
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				book = new SearchDTO();
				isbn = rs.getString(1);
				book.setIsbn(isbn);
				book.setTitle(rs.getString(2));
				book.setDescription(rs.getString(3));
				book.setPrice(rs.getFloat(4));
				book.setPublisher(rs.getString(5));
				book.setPublicationdate(rs.getString(6));
				book.setEdition(rs.getInt(7));
				book.setPages(rs.getInt(8));
				book.setLanguage(rs.getString(9));
				Blob b = rs.getBlob(10);
				if (b != null) {
					byte b1[] = b.getBytes(1, (int) b.length());// new
																// byte[(int)b.length()];
					// InputStream in=photo.getBinaryStream();
					FileOutputStream fout = new FileOutputStream(path + "/"
							+ isbn + ".jpg");
					fout.write(b1);

					book.setImage(isbn + ".jpg");
				}
				book.setQuantity(rs.getInt(11));
				alist.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alist;

	}

	public Vector<SearchDTO> viewBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteBook(String isbn) {

		boolean flag = false;
		try {
			connection = ConnectionFactory.getConnection();
			
			ps1 = connection.prepareStatement(SqlConstants._DELETE_BOOK);
			ps1.setString(1, isbn);
			ps2 = connection.prepareStatement(SqlConstants._DELETE_BOOK1);
			ps2.setString(1, isbn);
			ps3 = connection.prepareStatement(SqlConstants._DELETE_BOOK2);
			ps3.setString(1, isbn);
			int d1 = ps1.executeUpdate();
			int d2 = ps2.executeUpdate();
			int d3 = ps3.executeUpdate();
			System.out.println("deleted==" + d1);
			System.out.println("deleted==" + d2);
			System.out.println("deleted==" + d3);
		} catch (SQLException e) {
			System.out.println("exception" + e);

		}
return flag;
	}


}
