package org.zerock.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.FreeBoard;

public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long> {

	@Query("select b from FreeBoard b where b.bno > 0")
	public List<FreeBoard> list(Pageable pageable);
	
	@Query("select b, count(r) from FreeBoard b left outer join FreeReply r on b.bno = r.board group by b")
	public Page<Object[]> listPage(Pageable pageable);
	
	
	public Page<Object[]> listByTitlePage(String kryword, Pageable pageable);
}
