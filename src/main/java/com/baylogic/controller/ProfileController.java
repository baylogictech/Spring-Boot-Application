package com.baylogic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.baylogic.model.Doctors;
import com.baylogic.model.UserAccountDetail;
import com.baylogic.service.ProfileService;

@RestController
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	@PostMapping("/saveDocProfile")
	public View saveDocProfile(@RequestBody Doctors profile, Model model) {
		try {
		profileService.saveDocProfile(profile);
		} catch(Exception e) {
			model.addAttribute("status", "Unable to update Profile.");
			e.printStackTrace();
		}
		model.addAttribute("status", "Profile updated successfully.");
		return new MappingJackson2JsonView();
	}
	
	@PostMapping("/saveProfile")
	public View saveProfile(@RequestBody UserAccountDetail profile, Model model) {
		try {
			profileService.saveProfile(profile);
		} catch(Exception e) {
			model.addAttribute("status", "Unable to update Profile.");
			e.printStackTrace();
		}
		model.addAttribute("status", "Profile updated successfully.");
		return new MappingJackson2JsonView();
	}
}
