package com.online.serviceimpl;

import java.util.Vector;

import com.online.bean.ProfileDTO;
import com.online.daoi.ProfileDaoI;
import com.online.daoimpl.ProfileDaoImpl;
import com.online.servicei.ProfileServiceI;

public class ProfileServiceImpl implements ProfileServiceI{

	ProfileDaoI daoI=new ProfileDaoImpl();

	public boolean addCustomer(ProfileDTO profileDTO) {
		// TODO Auto-generated method stub
		return daoI.addCustomer(profileDTO);
	}

	public String recoverPassword(ProfileDTO pf) {
		// TODO Auto-generated method stub
		return daoI.recoverPassword(pf);
	}

	public Vector<ProfileDTO> viewProfile(int id) {
		// TODO Auto-generated method stub
		return daoI.viewProfile(id);
	}

	public Vector<ProfileDTO> viewUsers() {
		// TODO Auto-generated method stub
		return daoI.viewUsers();
	}
}
