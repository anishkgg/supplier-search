package com.makersharks.supplier.search.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.makersharks.supplier.search.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	@Query("SELECT supplier FROM Supplier supplier JOIN supplier.manufacturingProcesses process"
	         + " WHERE supplier.location = ?1 AND supplier.businessNature = ?2 AND process.processName = ?3")
	Page<Supplier> findSuppliersBy(String location, String businessNature,
			String manufacturingProcess, Pageable pageable);

}
