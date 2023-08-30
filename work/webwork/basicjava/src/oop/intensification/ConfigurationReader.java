package oop.intensification;

import java.awt.Container;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ConfigurationReader {
	
    String file;
    char comment;
    String  delm;
    Hashtable ht;    

    public ConfigurationReader(String file) {
    	
    	this.file = file;
        this.comment  = '#';   // 주석 구분자 # 기호.
        this.delm = "=>";      // 서버 정보 구분자 = 기호.
        ht = new Hashtable();  // 정보를 파싱하여 key, value 쌍으로 저장하기 위한 공간
        
    }
    
    public String getValue(String name) {
    	// 프로그램 구현 부분 --------------------------- (5점)
        // 해쉬테이블의 키에 해당하는 값을 리턴시키도록 구현.

    	return (String) ht.get(name);

        
        // ---------------------------------------------------------
    }    

    public void parse() throws IOException {
    	
    	// 프로그램 구현 부분 --------------------------------------(20점)
     	
		// 1. 파일로부터 내용을 읽어내어  파싱 하는 부분이다.
		// 2. 읽은 첫 글자가 ‘#’ 인 경우는 주석이므로 다음라인을 읽고,
		// 3. 주석이 아닌 경우는 서버 정보이므로.. 서버정보 구분자인 delm (“=>”)을
		//    이용하여 key, value 를 추출하여 해쉬 테이블에 저장하는 기능을 완성하라.
    	
    	String str;
    	try {
    		String path = ConfigurationReader.class.getResource("").getPath();
    		BufferedReader reader = new BufferedReader(new FileReader(path +"\\"+ file));
    		while((str = reader.readLine()) != null) {
    			if (str.contains(delm)) {
    				String[] strTest = str.split(delm);
    				ht.put(strTest[0], strTest[1]);
    			}
    		}
		} catch (Exception e) {
		}
        //---------------------------------------------------------
    }



    public static void main(String args[]) { // 변경 하지 마세요.
    	
        ConfigurationReader cr =
        	new ConfigurationReader("myserver.ini");
        
        try {
            cr.parse();
            System.out.println(cr.getValue("port"));
            System.out.println(cr.getValue("server"));
            System.out.println(cr.getValue("admin"));
        } catch (Exception e) { }
        
    }
}
