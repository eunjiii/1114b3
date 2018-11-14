package org.zerock.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of="bno")
@ToString(exclude="replies")
public class FreeBoard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bno;
	
	private String title;
	private String content;
	private String writer;
	
	@CreationTimestamp
	private LocalDateTime regdate;
	
	@UpdateTimestamp
	private LocalDateTime updatedate;
	
	@OneToMany(mappedBy="board", cascade=CascadeType.ALL) //replies는 board에 매여잇다
	private List<FreeReply> replies;
	
	
	
	
}
