/**
 * 
 */
package com.co.mercadolibre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.mercadolibre.request.MutantRequest;
import com.co.mercadolibre.service.MutantService;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
@RestController
@RequestMapping(value = "/mutant", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public class MutantController {
	
	@Autowired
	private MutantService mutantService;

	@PostMapping("/")
	public @ResponseBody ResponseEntity<String> isMutant(@RequestBody MutantRequest dnaSequence) {
		try {
			boolean isMutant = mutantService.isMutantDNA(dnaSequence);
			if (isMutant) {
				return ResponseEntity.ok("MUTANT");
			} else {
				return new ResponseEntity<>( "ADN HUMAN!", HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			return new ResponseEntity<>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
