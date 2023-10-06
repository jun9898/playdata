package test.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// .json 파일을 JSONArray나 JSONObject로 변환

public class JSONParserExam {
	public static void main(String[] args) 
			throws FileNotFoundException, IOException, ParseException {
		//1. JSON parser생성
		// ==> json 문자열을 분석해서 문자열로 변환할 수 있는 객체
		JSONParser parser = new JSONParser();
		
		//2. json파일의 파싱
		JSONObject root = (JSONObject)parser.parse(new FileReader("src/main/java/test/json/myjson_exam.json"));
		
		//3. json object에서 데이터 읽기
		String name = (String)root.get("name");
		String age = (String)root.get("age");
		System.out.println("name = " + name);
		System.out.println("age = " + age);

		//4. JSONArray에서 데이터 읽기
		System.out.println("=====================");
		JSONArray subjectlist = (JSONArray) root.get("subject");
		
		for (int i = 0; i < subjectlist.size(); i++) {
			String subject = (String)subjectlist.get(i);
			System.out.println("subject = " + subject);
		}
		System.out.println("=====================");
		
		JSONObject addr = (JSONObject) root.get("addr");
		System.out.println("addr[1] = " + addr.get("zip"));
		System.out.println("addr[1] = " + addr.get("addr1"));
		
		System.out.println("=====================");
		JSONArray historylist = (JSONArray)root.get("history");
		for (int i = 0; i < historylist.size(); i++) {
			JSONObject history = (JSONObject)historylist.get(i);
			System.out.println("month = " + history.get("month"));
			System.out.println("subject = " + history.get("subject"));
		}
		
		
	}

}
