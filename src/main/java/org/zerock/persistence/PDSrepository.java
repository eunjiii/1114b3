package org.zerock.persistence;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.PDS;

public interface PDSrepository extends CrudRepository<PDS, Long> {

	@Modifying
	@Query("update from PDSFile f set f.fname = ?2 where f.fno = ?1 ")
	public int updatePDSFile(Long fno, String newFileName);
	
	@Modifying
	@Query("delete from PDSFile f where f.fno = ?1")
	public int deletePDSFile(Long fno);
	
}
