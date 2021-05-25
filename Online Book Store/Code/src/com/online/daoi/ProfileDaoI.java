package com.online.daoi;

import java.util.Vector;

import com.online.bean.ProfileDTO;

public interface ProfileDaoI {

	boolean addCustomer(ProfileDTO profileDTO);

	String recoverPassword(ProfileDTO pf);

	Vector<ProfileDTO> viewProfile(int id);

	Vector<ProfileDTO> viewUsers();

}
