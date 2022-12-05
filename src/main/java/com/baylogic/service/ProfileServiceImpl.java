package com.baylogic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baylogic.model.Doctors;
import com.baylogic.model.UserAccountDetail;
import com.baylogic.repositories.DoctorsRepository;
import com.baylogic.repositories.UserAccountRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private DoctorsRepository docRepo;
	@Autowired
	private UserAccountRepository userAccRepo;

	@Override
	public boolean saveDocProfile(Doctors docProfile) {
		docRepo.save(docProfile);
		return true;
	}

	@Override
	public boolean saveProfile(UserAccountDetail profile) {
		userAccRepo.save(profile);
		return true;
	}

}
