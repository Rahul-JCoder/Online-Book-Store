package com.online.servicei;

import java.util.Vector;

import com.online.bean.ProfileDTO;

public interface ProfileServiceI {

	boolean addCustomer(ProfileDTO profileDTO);

	String recoverPassword(ProfileDTO pf);

	Vector<ProfileDTO> viewUsers();

	Vector<ProfileDTO> viewProfile(int id1);

}
