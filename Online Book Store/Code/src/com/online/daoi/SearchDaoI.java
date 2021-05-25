package com.online.daoi;

import java.util.Vector;

import com.online.bean.SearchDTO;

public interface SearchDaoI {

	Vector<SearchDTO> search(String query, String storepath);

	Vector<SearchDTO> searchByAuthor(String query, String storepath);

	Vector<SearchDTO> searchByCategory(String path);

	Vector<SearchDTO> searchByCategory(int query, String storepath);

	Vector<SearchDTO> searchByPrice(int query, int query1, String storepath);

}
