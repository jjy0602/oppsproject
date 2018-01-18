package opens;
 
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class Naver {
        
    	Naver() throws IOException{
    	
    	FileWriter fo = new FileWriter("C:\\JHS\\naver.txt");
        //InputStreamReader reader = new InputStreamReader(System.in);
        
        //BufferedReader buff = new BufferedReader(reader);
        
        //System.out.print("input url: ");
       // String url = buff.readLine();
        String url = "http://www.naver.com/";
        
       // System.out.print("input selector: ");
        //String selector = buff.readLine();
        String selector = "li.ah_item";
        
        Document doc = Jsoup.connect(url).get();
        
        Elements titles = doc.select(selector);
        StringBuffer sb=new StringBuffer();
        //180116 문자열 픽스
        String output = "";
        //카운트 생성
        int cnt=0;
        for(Element e: titles) {
        	cnt++;
        	//11카운트가 되면 break
        	if(cnt==11) break;
        	sb.append(e.text());
        	//1~9위까지는 숫자 다음에 '위' 삽입
        	if(cnt<10)
        		sb.insert(1, '위');
        	else
        		//10위의 경우 두번째 글자다음에 '위' 삽입
        		sb.insert(2, '위');
        	
        	output+=sb.toString();
        	sb.delete(0, sb.length());
            output += "\r\n";

        }
        

        System.out.println("Naver 실시간 검색어" );
        System.out.println(output);
       
       fo.write(output);
     
       fo.close();
        
    }
}
