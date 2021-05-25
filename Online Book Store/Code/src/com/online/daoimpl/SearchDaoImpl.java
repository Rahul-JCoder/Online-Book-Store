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
import com.online.daoi.SearchDaoI;
import com.online.db.ConnectionFactory;
import com.online.db.SqlConstants;

public class SearchDaoImpl implements SearchDaoI {

	Connection connection = null;
	ResultSet resultSet, resultSet2 = null;
	PreparedStatement preparedStatement, preparedStatement2 = null;

	public SearchDaoImpl() {
		super();
		connection = ConnectionFactory.getConnection();
	}

	public Vector<SearchDTO> search(String query, String path) {

		String fname = null;

		Vector<SearchDTO> dtos = new Vector<SearchDTO>();
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._SEARCH_BY_TITLE);
			System.out.println("connection is" + connection);
			preparedStatement.setString(1, query);
			resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet.getFetchSize());
			while (resultSet.next()) {
				SearchDTO searchDTO = new SearchDTO();
				String isbn = resultSet.getString(1);
				searchDTO.setIsbn(isbn);
				searchDTO.setTitle(resultSet.getString(2));
				searchDTO.setDescription(resultSet.getString(3));
				searchDTO.setPrice(resultSet.getFloat(4));
				searchDTO.setPublisher(resultSet.getString(5));
				searchDTO.setPublicationdate(resultSet.getString(6));
				searchDTO.setEdition(resultSet.getInt(7));
				searchDTO.setPages(resultSet.getInt(8));
				searchDTO.setLanguage(resultSet.getString(9));
				Blob b = resultSet.getBlob(10);
				byte b1[] = b.getBytes(1, (int) b.length());
				String storepath = path + "/" + isbn + ".jpg";
				System.out.println("path is" + storepath);
				FileOutputStream stream = new FileOutputStream(storepath);
				stream.write(b1);
				searchDTO.setImage(storepath);
				searchDTO.setQuantity(resultSet.getInt(11));
				preparedStatement = connection
						.prepareStatement(SqlConstants._GET_AUTHOR);
				preparedStatement.setString(1, isbn);
				resultSet2 = preparedStatement.executeQuery();
				if (resultSet2.next()) {
					fname = resultSet2.getString(1);

				}
				searchDTO.setFname(fname);

				dtos.add(searchDTO);
				System.out.println("results size is" + dtos.size());
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public Vector<SearchDTO> searchByAuthor(String query, String path) {

		String isbn = null;
		String fname = null;
		SearchDTO searchDTO = null;
		Vector<SearchDTO> dtos = new Vector<SearchDTO>();
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._GET_ISBN);
			System.out.println("connection is" + connection);
			preparedStatement.setString(1, query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				isbn = resultSet.getString(1);
				fname = resultSet.getString(2);
				System.out.println(".........." + isbn + "......" + fname);
				preparedStatement2 = connection
						.prepareStatement(SqlConstants._SEARCH_BY_AUTHOR);
				preparedStatement2.setString(1, isbn);
				resultSet2 = preparedStatement2.executeQuery();
				while (resultSet2.next()) {
					searchDTO = new SearchDTO();
					searchDTO.setFname(fname);
					searchDTO.setIsbn(resultSet2.getString(1));
					searchDTO.setTitle(resultSet2.getString(2));
					searchDTO.setDescription(resultSet2.getString(3));
					searchDTO.setPrice(resultSet2.getFloat(4));
					searchDTO.setPublisher(resultSet2.getString(5));
					searchDTO.setPublicationdate(resultSet2.getString(6));
					searchDTO.setEdition(resultSet2.getInt(7));
					searchDTO.setPages(resultSet2.getInt(8));
					searchDTO.setLanguage(resultSet2.getString(9));
					Blob b = resultSet2.getBlob(10);
					searchDTO.setQuantity(resultSet2.getInt(11));
					byte b1[] = b.getBytes(1, (int) b.length());
					String storepath = path + "/" + isbn + ".jpg";
					System.out.println("path is" + storepath);
					FileOutputStream stream = new FileOutputStream(storepath);
					stream.write(b1);
					searchDTO.setImage(storepath);
					
					dtos.add(searchDTO);
					System.out.println("results size is" + dtos.size());
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public Vector<SearchDTO> searchByCategory(String path) {
		
		SearchDTO searchDTO = null;
		Vector<SearchDTO> dtos = new Vector<SearchDTO>();
		try{
			preparedStatement= connection.prepareStatement(SqlConstants._GET_CATEGORIES);
			System.out.println("connection is" + connection);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				searchDTO=new SearchDTO();
				searchDTO.setCategoryid(resultSet.getInt(1));
				searchDTO.setCategoryname(resultSet.getString(2));
				dtos.add(searchDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		return dtos;
	}

	public Vector<SearchDTO> searchByCategory(int query, String path) {
		String isbn = null;
		String fname = null;
		SearchDTO searchDTO = null;
		Vector<SearchDTO> dtos = new Vector<SearchDTO>();
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._GET_ISBN1);
			System.out.println("connection is" + connection);
			preparedStatement.setInt(1, query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				isbn = resultSet.getString(1);
				System.out.println(".........." + isbn );
				preparedStatement2 = connection
						.prepareStatement(SqlConstants._SEARCH_BY_CATEGORY);
				preparedStatement2.setString(1, isbn);
				resultSet2 = preparedStatement2.executeQuery();
				while (resultSet2.next()) {
					searchDTO = new SearchDTO();
					searchDTO.setIsbn(resultSet2.getString(1));
					searchDTO.setTitle(resultSet2.getString(2));
					searchDTO.setDescription(resultSet2.getString(3));
					searchDTO.setPrice(resultSet2.getFloat(4));
					searchDTO.setPublisher(resultSet2.getString(5));
					searchDTO.setPublicationdate(resultSet2.getString(6));
					searchDTO.setEdition(resultSet2.getInt(7));
					searchDTO.setPages(resultSet2.getInt(8));
					searchDTO.setLanguage(resultSet2.getString(9));
					Blob b = resultSet2.getBlob(10);
					byte b1[] = b.getBytes(1, (int) b.length());
					String storepath = path + "/" + isbn + ".jpg";
					System.out.println("path is" + storepath);
					FileOutputStream stream = new FileOutputStream(storepath);
					stream.write(b1);
					searchDTO.setImage(storepath);
					searchDTO.setQuantity(resultSet2.getInt(11));
					fname=resultSet2.getString(12);
					searchDTO.setFname(fname);
					dtos.add(searchDTO);
					System.out.println("results size is" + dtos.size());
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public Vector<SearchDTO> searchByPrice(int query,int query1, String path) {
		SearchDTO searchDTO = null;
		String isbn=null;
		String fname=null;
		Vector<SearchDTO> dtos = new Vector<SearchDTO>();
		try{
			preparedStatement= connection.prepareStatement(SqlConstants._SEARCH_BY_PRICE);
			preparedStatement.setInt(1, query);
			preparedStatement.setInt(2, query1);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				searchDTO=new SearchDTO();
				isbn=resultSet.getString(1);
				searchDTO.setIsbn(isbn);
				searchDTO.setTitle(resultSet.getString(2));
				searchDTO.setDescription(resultSet.getString(3));
				searchDTO.setPrice(resultSet.getFloat(4));
				searchDTO.setPublisher(resultSet.getString(5));
				searchDTO.setPublicationdate(resultSet.getString(6));
				searchDTO.setEdition(resultSet.getInt(7));
				searchDTO.setPages(resultSet.getInt(8));
				searchDTO.setLanguage(resultSet.getString(9));
				Blob b = resultSet.getBlob(10);
				byte b1[] = b.getBytes(1, (int) b.length());
				String storepath = path + "/" + isbn + ".jpg";
				System.out.println("path is" + storepath);
				FileOutputStream stream = new FileOutputStream(storepath);
				stream.write(b1);
				searchDTO.setImage(storepath);
				searchDTO.setQuantity(resultSet.getInt(11));
				fname=resultSet.getString(12);
				searchDTO.setFname(fname);
				dtos.add(searchDTO);
				System.out.println("results size is" + dtos.size());
				dtos.add(searchDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dtos;
	}
}
