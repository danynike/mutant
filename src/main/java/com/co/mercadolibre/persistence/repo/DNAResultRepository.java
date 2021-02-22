/**
 * 
 */
package com.co.mercadolibre.persistence.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.mercadolibre.persistence.model.DNAResult;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
@Repository
public interface DNAResultRepository extends CrudRepository<DNAResult, Long> {

}