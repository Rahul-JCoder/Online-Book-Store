package com.online.serviceimpl;

import com.online.bean.ProfileDTO;
import com.online.daoi.SecurityDaoI;
import com.online.daoimpl.SecurityDaoImpl;
import com.online.servicei.SecurityServiceI;

public class SecurityServiceImpl implements SecurityServiceI {
	
	SecurityDaoI daoI=new SecurityDaoImpl();

	public String checkUser(ProfileDTO p) {
		// TODO Auto-generated method stub
		return daoI.checkUser(p);
	}

}
