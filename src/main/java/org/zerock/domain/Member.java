package org.zerock.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Member {
	
	@Id
	private String uid;
	
	private String upw;
	
	private String uname;

}
