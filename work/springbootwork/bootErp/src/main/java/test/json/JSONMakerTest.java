package test.json;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// json 형식의 데이터를 만들어보기
/*
	
	{} -> JSON오브젝트 => JSONObject(맵구조)
	[] -> JSON Array => JSONArray(리스트 구조)
*/
public class JSONMakerTest {
	public static void main(String[] args) throws IOException {
		JSONObject myjson = new JSONObject();
		myjson.put("name", "전병준");
		myjson.put("age", "26");
		
		JSONArray subjectlist = new JSONArray();

		subjectlist.add("자바");
		subjectlist.add("스프링");
		subjectlist.add("하둡");
		
		// 위에서 작성한 JSONArray를 JSONObject에 추가하기
		myjson.put("subject", subjectlist);
		
		JSONArray commentlist = new JSONArray();
		
		JSONObject comment1 = new JSONObject();
		comment1.put("no", "1");
		comment1.put("content", "json만들기");
		comment1.put("id", "전병준");
		
		JSONObject comment2 = new JSONObject();
		comment2.put("no", "2");
		comment2.put("content", "json 파일도 만들기");
		comment2.put("id", "전병준2");
		
		commentlist.add(comment1);
		commentlist.add(comment2);
		
		myjson.put("comment", commentlist);
		System.out.println(myjson.toJSONString());
		
		//json파일을 생성
		FileWriter fw = new FileWriter("src/main/java/test/json/myjson.json");
		fw.write(myjson.toJSONString());
		fw.flush();
		fw.close();
		
		
		
		
	}

}
