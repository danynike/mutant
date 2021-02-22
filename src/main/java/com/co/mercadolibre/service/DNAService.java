/**
 * 
 */
package com.co.mercadolibre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.mercadolibre.persistence.model.DNA;
import com.co.mercadolibre.persistence.repo.DNARepository;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
@Service
public class DNAService {

	@Autowired
	private DNARepository dnaStatusRepository;

	/**
	 * return the statistics of verifications the exposed method (humans, mutants
	 * and ratio).
	 * 
	 * @return statistics and ratio
	 */
	public DNA getStatistics() {
		return dnaStatusRepository.getStats();
	}

	
}
