package org.zerock;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.PDS;
import org.zerock.domain.PDSFile;
import org.zerock.persistence.PDSrepository;

import lombok.Setter;
import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class Test2 {

	@Setter(onMethod_ = @Autowired)
	private PDSrepository pdsRepository;

	@Test
	public void testOldway() {

		PDS pds = pdsRepository.findById(2L).get();

		List<PDSFile> files = pds.getFiles();

		log.info("" + files);

		PDSFile newfile = new PDSFile();
		newfile.setFno(2L);
		newfile.setFname("갱신된 파일");

		int idx = files.indexOf(newfile);

		log.info("idx: " + idx);

		if (idx >= 0) {
			files.remove(idx);
			files.add(newfile);
		}
		pds.setFiles(files);
		pdsRepository.save(pds);
	}

	@Transactional
	@Test
	public void testDeleteFile() {

		pdsRepository.deletePDSFile(3L);

	}

	@Transactional
	@Test
	public void testUpdateFile() {

		pdsRepository.updatePDSFile(3L, "새로운 파일이름");

	}

	@Test
	public void testRead() {

		pdsRepository.findById(1L).ifPresent(vo -> log.info("" + vo));

	}

	@Test
	public void testInsert() {

		PDS vo = new PDS();
		vo.setTitle("sample PDS");
		vo.setWriter("user00");

		List<PDSFile> list = IntStream.range(0, 3).mapToObj(i -> {

			PDSFile fileObj = new PDSFile();
			fileObj.setFname("파일이름" + i);

			return fileObj;
		}).collect(Collectors.toList());

		vo.setFiles(list);

		log.info("" + vo);

		pdsRepository.save(vo);
	}

}
