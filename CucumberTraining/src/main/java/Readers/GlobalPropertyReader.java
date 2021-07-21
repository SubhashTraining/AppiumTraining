package Readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GlobalPropertyReader {
	
	
	private static GlobalPropertyReader Reader;
	private Properties property ;
	
	protected GlobalPropertyReader()
	{
	loadProperty();	
	}
	
	
	public static GlobalPropertyReader getInstanceOf()
	{
		return (Reader==null) ? new GlobalPropertyReader() : Reader;
	}
	
	
	public void loadProperty()
	{
		
		try {
			//String Path = 
			FileReader filreader= new FileReader("C:\\Users\\Sanjay\\Appium\\eclipse-workspace\\CucumberTraining\\Configs\\GlobalProperties.properties");
			BufferedReader  bufferedReader = new BufferedReader(filreader);
			property=new Properties();
			//System.out.println();
			try {
			property.load(bufferedReader);
			}catch(Exception e) {System.out.println(e.toString());}
			bufferedReader.close();
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {e.printStackTrace();}
		
	}
	
	
	public String getProperty(String PropertyName)
	{
		  return property.getProperty(PropertyName);
		 
	}
	
}
