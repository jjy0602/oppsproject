package opens;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class Daum {
        
    	Daum() throws IOException
    	{
	    	FileWriter fo = new FileWriter("C:\\JHS\\daum.txt"); //출력내용저장
	       // InputStreamReader reader = new InputStreamReader(System.in);
	        
	        //BufferedReader buff = new BufferedReader(reader);
	        
	        //System.out.print("input url: ");
	       // String url = buff.readLine();
	        String url = "https://www.daum.net"; //url 고정
	        
	       
	       // String selector = buff.readLine();
	        String selector = "ol.list_hotissue.issue_row.list_mini";
	        
	     
	         
	        
	        Document doc = Jsoup.connect(url).get();
	        
	        Elements titles = doc.select(selector);
	        
	        String output = "";
	        
	        for(Element e: titles) {
	            output += e.text();
	            output += "\r\n";
	
	        }
	        
	        //180116 문자열 픽스
	        StringBuffer sb = new StringBuffer(output);
	        for(int i = 2 ; i <sb.length();i++)
	        {
	        	//i-1이 숫자이며 i가 '위'인 글자 탐색
	           if(sb.charAt(i)=='위' &&(sb.charAt(i-1)>='0' && sb.charAt(i-1)<='9'))
	           {
	        	   //10위 처리
	        	  if(sb.charAt(i-1)=='0' &&sb.charAt(i-2)>='1')
	        	  {
	        		  sb.insert(i-3, "\r\n");
	        		  i=i+2;
		              sb.deleteCharAt(i-3);
		             
		              continue;
	        	  }
	              sb.insert(i-2, "\r\n");
	              i=i+2;
	              sb.deleteCharAt(i-2);
	           }
	        }

	        
	        //System.out.println( output.replace("\n\n", "\b") );
	        System.out.println("Daum 실시간 검색어" );
	        output=sb.toString();
	        System.out.println( output ); //결과물 출력
	    
	        fo.write(output);
	       
	        fo.close();
	        //selector 해당 클래스로 고정
	        //input selector : ol.list_hotissue.issue_row.list_mini
    	}
}
