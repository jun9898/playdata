package com.playdata.erp.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadLogicService {
//	파일 업로드를 수행하는 메소드
//	업로드한 파일이 곧 디비에 저장할 정보
//	업로드한 파일의 정보를 이용해서 dto를 만들고 ArrayList에 담아서 리턴
	public List<BoardFileDTO> uploadFiles(List<MultipartFile> multipartFile, String path) throws IllegalStateException, IOException {
		List<BoardFileDTO> filedtolist = new ArrayList<BoardFileDTO>();
		int count =1;
		for (MultipartFile file : multipartFile) {
			if (!file.isEmpty()) {
//				업로드 하는 경우 원본파일명과 서버에서 실벽할 수 있는 실제 서버에 저장되는 파일명 두 개를 관리
				String originalFilename = file.getOriginalFilename();
				String storeFilename = createStoreFilename(originalFilename);
				System.out.println("file name = " + originalFilename + " + UUID + " + storeFilename);
				// 파일명과 path를 이용해서 실제 File객체를 만들고 업로드하기
				file.transferTo(new File(path+File.separator+storeFilename));
				filedtolist.add(new BoardFileDTO(null,originalFilename,storeFilename,count+""));
				count++;
			}
		}
		return filedtolist;
	}
	
//	식별할 파일명을 만들어서 리턴하는 메소드
//	
	private String createStoreFilename(String originalFilename) {
		int postition = originalFilename.lastIndexOf(".");
		String ext = originalFilename.substring(postition+1);
		String uuid = UUID.randomUUID().toString();
		return uuid + "." + ext;
	}

}