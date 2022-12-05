package com.baylogic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.baylogic.model.Diagnosis;
import com.baylogic.model.Specialization;
import com.baylogic.model.Symptoms;
import com.baylogic.service.ProvidersService;

@RestController
public class ProvidersController {
	@Autowired
	private ProvidersService providersService;

	@GetMapping("/prov/symptoms")
	public View getSymptoms(Model model) {
		List<Symptoms> symptoms = providersService.getSymptoms();
		model.addAttribute("symptoms", symptoms);
        return new MappingJackson2JsonView();
	}
	
	@GetMapping("/prov/specializations")
	public View getSpecializations(Model model) {
		List<Specialization> specializations = providersService.getSpecializations();
		model.addAttribute("specializations", specializations);
        return new MappingJackson2JsonView();
	}
	
	@GetMapping("/prov/diagnosis")
	public View getDiagnosis(Model model) {
		List<Diagnosis> diagnosis = providersService.getDiagnosis();
		model.addAttribute("diagnosis", diagnosis);
        return new MappingJackson2JsonView();
	}
}