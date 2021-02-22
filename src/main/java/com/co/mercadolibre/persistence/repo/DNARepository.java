/**
 * 
 */
package com.co.mercadolibre.persistence.repo;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.mercadolibre.persistence.model.DNA;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
@Repository
public interface DNARepository extends CrudRepository<DNA, Long> {

	@Query(value = "SELECT COUNT(*) FROM dnaresult AS dna where dna.is_mutant is true",nativeQuery = true)
	Long countTotalMutant();
	
	@Query(value = "SELECT COUNT(*) FROM dnaresult AS dna where dna.is_mutant is false",nativeQuery = true)
	Long countTotalHuman();
	
	public default DNA getStats() {
		DNA dna = new DNA();
		dna.setHumanCount(countTotalHuman());
		dna.setMutantCount(countTotalMutant());
		dna.setTotal((dna.getHumanCount() != null ? dna.getHumanCount() : 0L) + (dna.getMutantCount() != null ? dna.getMutantCount() : 0L));

		Double ratio = Double.MIN_VALUE;

		if (dna.getMutantCount() != 0) {
			if (dna.getHumanCount() == 0) {
				ratio = 1.0d;
			} else {
				BigDecimal mutant = BigDecimal.valueOf(dna.getMutantCount());
				BigDecimal human = BigDecimal.valueOf(dna.getHumanCount());
				ratio = mutant.divide(human, 2, RoundingMode.HALF_UP).doubleValue();
			}
		}
		
		dna.setRatio(ratio);
		dna = save(dna);
		
		return dna;
	}

}
