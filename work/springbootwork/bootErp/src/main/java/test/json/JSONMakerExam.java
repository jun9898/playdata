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
public class JSONMakerExam {
	public static void main(String[] args) throws IOException {
		JSONObject myjson = new JSONObject();
		myjson.put("name", "김서연");
		myjson.put("age", "25");
		
		JSONArray subjectlist = new JSONArray();

		subjectlist.add("자바");
		subjectlist.add("하둡");
		subjectlist.add("시큐어코딩");
		
		// 위에서 작성한 JSONArray를 JSONObject에 추가하기
		myjson.put("subject", subjectlist);
		
		JSONObject addr = new JSONObject();
		addr.put("zip", "111-222");
		addr.put("addr1", "인천시");

		myjson.put("addr", addr);
		
		JSONArray historylist = new JSONArray();
		
		JSONObject comment1 = new JSONObject();
		comment1.put("subject", "java");
		comment1.put("month", "11");
		
		JSONObject comment2 = new JSONObject();
		comment2.put("subject", "servlet");
		comment2.put("month", "12");
		
		historylist.add(comment1);
		historylist.add(comment2);
		
		myjson.put("history", historylist);
		System.out.println(myjson.toJSONString());
		
		//json파일을 생성
		FileWriter fw = new FileWriter("src/main/java/test/json/myjson_exam.json");
		fw.write(myjson.toJSONString());
		fw.flush();
		fw.close();
		
		
		
		
	}

}
