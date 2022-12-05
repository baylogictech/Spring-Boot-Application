package com.baylogic.service;

import com.baylogic.model.Doctors;
import com.baylogic.model.UserAccountDetail;

public interface ProfileService {
	public boolean saveDocProfile(Doctors docProfile);
	public boolean saveProfile(UserAccountDetail profile);
}
