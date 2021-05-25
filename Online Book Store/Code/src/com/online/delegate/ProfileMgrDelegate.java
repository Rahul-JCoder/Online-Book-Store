package com.online.delegate;

import java.util.Vector;

import com.online.bean.ProfileDTO;
import com.online.servicei.ProfileServiceI;
import com.online.servicei.SecurityServiceI;
import com.online.serviceimpl.ProfileServiceImpl;
import com.online.serviceimpl.SecurityServiceImpl;

public class ProfileMgrDelegate {

	ProfileServiceI serviceI =new  ProfileServiceImpl();
	SecurityServiceI serviceI2=new SecurityServiceImpl();
	public String checkUser(ProfileDTO p) {
		// TODO Auto-generated method stub
		return serviceI2.checkUser(p);
	}
	public boolean addCustomer(ProfileDTO profileDTO) {
		// TODO Auto-generated method stub
		return serviceI.addCustomer(profileDTO);
	}
	public String recoverPassword(ProfileDTO pf) {
		// TODO Auto-generated method stub
		return serviceI.recoverPassword(pf);
	}
	public Vector<ProfileDTO> viewUsers() {
		// TODO Auto-generated method stub
		return serviceI.viewUsers();
	}
	public Vector<ProfileDTO> viewProfile(int id1) {
		// TODO Auto-generated method stub
		return serviceI.viewProfile(id1);
	}
	
}
