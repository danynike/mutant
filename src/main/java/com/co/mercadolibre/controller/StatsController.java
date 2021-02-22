/**
 * 
 */
package com.co.mercadolibre.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.mercadolibre.persistence.model.DNA;
import com.co.mercadolibre.service.DNAService;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
@RestController
@RequestMapping(value = "/stats", produces = {
		MediaType.APPLICATION_JSON_VALUE })
public class StatsController {

	@Autowired
	private DNAService dnaService;

	@GetMapping("/")
	@SuppressWarnings("unchecked")
	public ResponseEntity<String> statisticsDNAMutant() {
		DNA stats = dnaService.getStatistics();
		if(stats != null) {
			JSONObject json = new JSONObject();//{“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}
			json.put("count_mutant_dna", stats.getMutantCount());
			json.put("count_human_dna", stats.getHumanCount());
			json.put("ratio", stats.getRatio());
			
			return ResponseEntity.ok(json.toString());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
