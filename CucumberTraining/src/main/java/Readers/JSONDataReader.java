package Readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import JsonDataClass.batter;
import JsonDataClass.topping;

public class JSONDataReader {
	
	
	public static JSONDataReader dataReader ;
	private final String LoginDataJsonPath = GlobalPropertyReader.getInstanceOf().getProperty("JSONDatPath")+"LoginData.json";
	List<JsonDataClass.batters> batters ;
	
	
	protected JSONDataReader()
	{
		batters=getLoginDatalist(LoginDataJsonPath);
		for(JsonDataClass.batters pizza :batters )
		{
			if(pizza.getId().equals("0002"))
			{
				topping[] batter =pizza.gettopping();
				for(int i=0;i<=batter.length;i++)
				{
					System.out.println(batter[i].getId());
					System.out.println(batter[i].getType());
				}
				
				topping[] topping=pizza.gettopping();
				for(int i=0;i<=topping.length;i++)
				{
					System.out.println(topping[i].getId());
					System.out.println(topping[i].getType());
				}
			}
		}
		
		
		
		
	}
	
	public static JSONDataReader getInstanceOf()
	{
		return (dataReader==null) ? new JSONDataReader() : dataReader;
		
	}
	
	
	public List<JsonDataClass.batters> getLoginDatalist(String FilePath)
	{
		
		Gson gson = new Gson();
		BufferedReader BufferedReader;
		JsonDataClass.batters[]  batters=null;
		try {
			BufferedReader = new BufferedReader(new FileReader(FilePath));
			System.out.println(FilePath);
			batters =  gson.fromJson(BufferedReader, JsonDataClass.batters[].class);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Arrays.asList(batters);
	}
	

}
