package com.online.serviceimpl;

import java.util.Vector;

import com.online.bean.SearchDTO;
import com.online.daoi.SearchDaoI;
import com.online.daoimpl.SearchDaoImpl;
import com.online.servicei.SearchServiceI;

public class SearchServiceImpl implements SearchServiceI {

	SearchDaoI daoI=new SearchDaoImpl();

	public Vector<SearchDTO> search(String query,String storepath) {
		// TODO Auto-generated method stub
		return daoI.search(query,storepath);
	}

	public Vector<SearchDTO> searchByAuthor(String query, String storepath) {
		// TODO Auto-generated method stub
		return daoI.searchByAuthor(query, storepath);
	}

	public Vector<SearchDTO> searchByCategory(String path) {
		// TODO Auto-generated method stub
		return daoI.searchByCategory(path);
	}

	public Vector<SearchDTO> searchByCategory(int query, String storepath) {
		// TODO Auto-generated method stub
		return daoI.searchByCategory(query, storepath);
	}

	public Vector<SearchDTO> searchByPrice(int query,int query1, String storepath) {
		// TODO Auto-generated method stub
		return daoI.searchByPrice(query,query1, storepath);
	}
}
