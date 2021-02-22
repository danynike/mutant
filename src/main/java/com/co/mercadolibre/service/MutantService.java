/**
 * 
 */
package com.co.mercadolibre.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.co.mercadolibre.persistence.model.DNAResult;
import com.co.mercadolibre.persistence.repo.DNAResultRepository;
import com.co.mercadolibre.request.MutantRequest;
import com.co.mercadolibre.service.validate.Detection;
import com.co.mercadolibre.web.exception.MutantMismatchException;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
@Service
public class MutantService {

	@Autowired
	private DNAResultRepository dnaResultRepository; 
	
	public boolean isMutantDNA(MutantRequest request) {
		if (request != null) {
			if (isValidDna(request.getDna())) {
				DNAResult dnaResult = new DNAResult();
				dnaResult.setDna(StringUtils.collectionToDelimitedString(Arrays.asList(request.getDna()), "\r\n"));
				Detection detection = new Detection(loadDNAStructure(request));
				dnaResult.setMutant(detection.isMutante());
				dnaResult = dnaResultRepository.save(dnaResult);
				
				return detection.isMutante();
			} else {
				throw new MutantMismatchException("ERROR leyendo el ADN ingresado");
			}
		}

		return false;
	}

	private boolean isValidDna(String[] dna) {
		for (int i = 0; i < dna.length; i++) {
			if ( dna[i].length() != dna.length ) 
				return false;
			
			if (dna[i].matches(".*[^ATCG].*")) 
				throw new MutantMismatchException("debe ingresar valores correcto de ADN");
		}

		return true;
	}
	
	private char[][] loadDNAStructure(MutantRequest dnaSequence) {
		int vectorLength = dnaSequence.getDna().length;
		char[][] dna = new char[vectorLength][vectorLength];

		for (int i = 0; i < vectorLength; i++) {
			String dnaRow = dnaSequence.getDna()[i];
			dna[i] = dnaRow.toUpperCase().toCharArray();
		}
		
		return dna;
	}
	
	/*public static void main(String[] args) {
		MutantRequest request = new MutantRequest();
		request.setDna(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
		MutantService s = new MutantService();
		s.isMutantDNA(request);
	}*/
}
