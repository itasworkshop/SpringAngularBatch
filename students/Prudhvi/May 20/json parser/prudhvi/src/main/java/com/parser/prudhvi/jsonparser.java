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

public class jsonparser {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Object obj = new JSONParser().parse(new FileReader("C:\\Users\\prudh\\eclipse-workspace\\assignments\\resources\\clicks.json"));
		Object obj2 = new JSONParser().parse(new FileReader("C:\\Users\\prudh\\eclipse-workspace\\assignments\\resources\\impressions.json"));
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

			
		}

		
		
		HashMap<dimensionstruct,metricstruct> metricmap = new HashMap<dimensionstruct,metricstruct>();
		for(int i=0;i<impressions.size();i++)
		{
			JSONObject block = (JSONObject) impressions.get(i);
			String impression_id = (String) block.get("id");
			//System.out.println(block.get("id"));
			long app_id = (long) block.get("app_id");
			//System.out.println( block.get("advertiser_id"));
			long ad_id = block.get("advertiser_id")==null?-1: (long) block.get("advertiser_id");
			
			String country = (String) block.get("country_code");
			dimensionstruct key = new dimensionstruct(app_id, country);
			metricstruct value = metricmap.containsKey(key)? metricmap.get(key): new metricstruct();
			
			if(clickmap.containsKey(impression_id))
			{
			value.updatemetric(clickmap.get(impression_id),ad_id);
			}
			else
			{
				value.updatemetric(ad_id);
			}
			metricmap.put(key, value);
		}
		
		JSONArray output1 = new JSONArray();
		JSONArray output2 = new JSONArray();
		
		for(Map.Entry<dimensionstruct,metricstruct> entry: metricmap.entrySet())
		{
		JSONObject block = new JSONObject();
		block.put("app_id", entry.getKey().appid);
		block.put("country_code", entry.getKey().country);
		block.put("impressions", entry.getValue().impressions);
		block.put("clicks", entry.getValue().clicks);
		block.put("revenue", entry.getValue().revenue);
		output1.add(block);
		}
		
		for(Map.Entry<dimensionstruct,metricstruct> entry: metricmap.entrySet())
		{
			JSONObject block = new JSONObject();
			block.put("app_id", entry.getKey().appid);
			block.put("country_code", entry.getKey().country);
			
			long[] top5 = entry.getValue().gettop5();
			String str = "["+top5[0]+","+top5[1]+","+top5[2]+","+top5[3]+","+top5[4]+"]";
			
			block.put("recommended_advertiser_ids", str);

			output2.add(block);
		}
		
        try (FileWriter file = new FileWriter("C:\\Users\\prudh\\eclipse-workspace\\assignments\\resources\\metric.json")) {
  
            file.write(output1.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
        try (FileWriter file = new FileWriter("C:\\Users\\prudh\\eclipse-workspace\\assignments\\resources\\recommendation.json")) {

            file.write(output2.toJSONString()); 
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
		return this.frequency;
	}
	public double getrevenue() {
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
	HashMap<Long,revenueperimp> app_idmap = new HashMap<Long,revenueperimp>();
	
	public metricstruct()
	{
		this.impressions=0;
		this.clicks=0;
		this.revenue=0;
	}
	
	public void updatemetric(clickstruct object, long ad_id)
	{
		this.impressions++;
		this.clicks = this.clicks+ object.getfrequency();
		this.revenue = this.revenue + object.getrevenue(); 
		
		revenueperimp temp = this.app_idmap.containsKey(ad_id)? this.app_idmap.get(ad_id) : new revenueperimp();
		
		temp.increment(object.getrevenue());
		this.app_idmap.put(ad_id, temp);
	}
	
	public void updatemetric(long ad_id)
	{
		this.impressions++;
		
		revenueperimp temp = this.app_idmap.containsKey(ad_id)? this.app_idmap.get(ad_id) : new revenueperimp();
		
		temp.increment();
		this.app_idmap.put(ad_id, temp);
	}
	
	public long[] gettop5()
	{
		long[] app_id = {-1,-1,-1,-1,-1,};
		double[] ratio = {0,0,0,0,0};
		int current_index;
		for(Map.Entry<Long,revenueperimp> entry: app_idmap.entrySet())
		{
			long key = entry.getKey();
			revenueperimp value = entry.getValue();
			
			double current_ratio = value.getratio();
			if(ratio[4]<current_ratio)
			{
				current_index = 4;
				ratio[4] = current_ratio;
				
				for(int i=4;i>0;i--)
				{
					if(ratio[current_index-1]<current_ratio)
					{
						 ratio[current_index] = ratio[current_index-1];
						 ratio[current_index-1] = current_ratio;
						 current_index--;
						
					}
					else
					{
						break;
					}
				}
				
				app_id[current_index] = key;
			}
			
		}
		System.out.println(app_idmap.size());
		return app_id;
		
	}
}
class revenueperimp implements Comparable{
	double revenue;
	int impressions;
	public revenueperimp()
	{
		this.revenue=0;
		this.impressions=0;
	}
	
	public void increment(double revenue)
	{
		this.revenue = this.revenue+revenue;
		this.impressions++;
	}
	
	public void increment()
	{
		this.revenue = this.revenue+revenue;
		this.impressions++;
	}
	
	public double getratio()
	{
		return this.revenue/this.impressions;
	}

	@Override
	public int compareTo(Object o) {
		double p = this.getratio() - ((revenueperimp) o).getratio();
		if(p==0)
			return 0;
		else if (p>0)
			return 1;
		else 
			return -1;
	}
}
