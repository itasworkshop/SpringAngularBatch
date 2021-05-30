package com.example.demo;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
@RestController
public class RestService {

	private final RestTemplate restTemplate;

	public RestService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	@GetMapping(path="/all")
	public @ResponseBody String getPostsPlainJSON() throws java.text.ParseException {
		String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=RELIANCE.BSE&outputsize=full&apikey=demo";
		String jsonString = this.restTemplate.getForObject(url, String.class);
		
		JSONParser parser = new  JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(jsonString);
			JSONObject time = (JSONObject) json.get("Time Series (Daily)");
			long sum =0, i=0;
			String output="";
			SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd"); 
			String currentMonth = "2020-08-01";
			Date dateCompare = formatter2.parse(currentMonth);
			for(Iterator iterator = time.keySet().iterator(); iterator.hasNext();) {
			    String key = (String) iterator.next();
			    //System.out.println(key);
			    
			    Date date2=formatter2.parse(key);
			    

			    JSONObject temp = (JSONObject) time.get(key);
			    
			    //return temp.toJSONString();
			    	if(date2.before(dateCompare)) {
			    	output = output + dateCompare.toString()+ Long.toString(sum);
			    	output = output+"\n";
			    	sum=Long.parseLong((String)temp.get("6. volume"));
			    	
				    Calendar cal = Calendar.getInstance();
				    cal.setTime(dateCompare);
				    cal.add(Calendar.MONTH, -1);
				    dateCompare = cal.getTime();
				    //System.out.println("1");
			    	}
			    	else {
			    		sum = sum+ Long.parseLong((String)temp.get("6. volume"));
			    		//System.out.println("2");
			    	}
			    	
			    	if(i>100)
			    		break;
			    	i++;
			}
			
			return output;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hello";

	}
}