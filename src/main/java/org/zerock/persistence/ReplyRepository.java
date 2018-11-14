package org.zerock.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.FreeReply;

public interface ReplyRepository extends CrudRepository<FreeReply, Long> {

}
