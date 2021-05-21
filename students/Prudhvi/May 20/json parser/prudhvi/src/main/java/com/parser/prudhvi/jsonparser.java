package com.parser.prudhvi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import may18.students;

public class jsonparser {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Object obj = new JSONParser().parse(new FileReader("C:\\Users\\prudh\\eclipse-workspace\\assignments\\clicks.json"));
		Object obj2 = new JSONParser().parse(new FileReader("C:\\Users\\prudh\\eclipse-workspace\\assignments\\impressions.json"));
		JSONArray clicks = (JSONArray) obj;
		JSONArray impressions = (JSONArray) obj2;
		
		HashMap<String,clickstruct> clickmap = new HashMap<String,clickstruct>();
		for(int i=0;i<clicks.size();i++)
		{
			JSONObject block = (JSONObject) clicks.get(i);
			String impression_id = (String) block.get("impression_id");
			clickstruct temp = clickmap.containsKey(impression_id)? clickmap.get(impression_id)  : new clickstruct();
			temp.increaserevenue((double)block.get("revenue"));
			clickmap.put(impression_id, temp);
			System.out.println(clickmap.size());
			
		}

		
		/*
		 * for(Map.Entry m : map.entrySet()){
		 * System.out.println(m.getKey()+" "+m.getValue()); }
		 */
		
		HashMap<dimensionstruct,metricstruct> metricmap = new HashMap<dimensionstruct,metricstruct>();
		for(int i=0;i<impressions.size();i++)
		{
			JSONObject block = (JSONObject) impressions.get(i);
			String impression_id = (String) block.get("id");
			System.out.println(block.get("id"));
			long app_id = (long) block.get("app_id");
			String country = (String) block.get("country_code");
			dimensionstruct key = new dimensionstruct(app_id, country);
			metricstruct value = metricmap.containsKey(key)? metricmap.get(key): new metricstruct();
			
			if(clickmap.containsKey(impression_id))
			{
			value.updatemetric(clickmap.get(impression_id));
			}
			else
			{
				value.updatemetric();
			}
			metricmap.put(key, value);
		}
		
		JSONArray output = new JSONArray();
		for(Map.Entry<dimensionstruct,metricstruct> entry: metricmap.entrySet())
		{
		JSONObject block = new JSONObject();
		block.put("app_id", entry.getKey().appid);
		block.put("country_code", entry.getKey().country);
		block.put("impressions", entry.getValue().impressions);
		block.put("clicks", entry.getValue().clicks);
		block.put("revenue", entry.getValue().revenue);
		output.add(block);
		}
		
        try (FileWriter file = new FileWriter("D:/employees.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(output.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}

class clickstruct {
	int frequency ;
	double revenue;
	
	public clickstruct()
	{
		this.revenue = 0;
		this.frequency = 0;
	}
	public void increaserevenue(double revenue)
	{
		this.revenue = this.revenue + revenue;
		frequency++;
	}
	
	public String toString() {
		return String.valueOf(revenue);
	}
	public int getfrequency() {
		// TODO Auto-generated method stub
		return this.frequency;
	}
	public double getrevenue() {
		// TODO Auto-generated method stub
		return this.revenue;
	}
}
class dimensionstruct implements Comparable<dimensionstruct>{
	String country;
	long appid;

	public  dimensionstruct(long app_id, String country)
	{
		this.country = country;
		this.appid = app_id;
	}

	@Override
	public int compareTo(dimensionstruct o) {
		String a = "" + this.appid;
		a= a+ this.country;
		String b = "" + o.appid;
		b = b+o.country;
		return a.compareTo(b);
	}
	
	
	
}

class metricstruct{
	int impressions;
	int clicks;
	double revenue;
	public metricstruct()
	{
		this.impressions=0;
		this.clicks=0;
		this.revenue=0;
	}
	
	public void updatemetric(clickstruct object)
	{
		this.impressions++;
		this.clicks = this.clicks+ object.getfrequency();
		this.revenue = this.revenue + object.getrevenue(); 
	}
	
	public void updatemetric()
	{
		this.impressions++;
	}
}

