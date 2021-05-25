package com.online.daoi;

import java.util.Vector;


import com.online.bean.SearchDTO;

public interface BookDaoI {
	Vector<SearchDTO> viewBooks();
	Vector<SearchDTO> viewBook(String path);
}
