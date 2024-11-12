package kr.kh.spring.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {

	@GetMapping("/data/sample")
	public String dataSample() {
		return "/data/sample";
	}
	
	public static final String serviceKey = "uuY9%2FYEYhEIZjIW9gGf%2Fu%2FtAjnVQ0uDC5tXa5Qww6OiqssHT0c7uqHovc4kx3Ah%2F3Y4Zs619OzZTfmjvcYSd5w%3D%3D";
	
	@ResponseBody
	@PostMapping(value="/data/sample", produces="application/text; charset=UTF-8;")
	public String dataSamplePost(String location) throws Exception {
        
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		
		if(location == null) {
			location = "서울";
		}
		
		url += "?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey;
		url += "&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8");
		url += "&" + URLEncoder.encode("sidoName","UTF-8") + "=" + URLEncoder.encode(location, "UTF-8");
		
		
        URL requestUrl = new URL(url);
        System.out.println(url);
        HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        String responseText = "";
        String line;
        while ((line = rd.readLine()) != null) {
        	responseText += line;
        }
        rd.close();
        conn.disconnect();
		return responseText;
	}
}
