package JsonDataClass;

import java.util.ArrayList;

public class batters {

	private String id;
	 private String type;
	 private String name;
	 private float ppu;
	batter[] batter;
	topping[] topping;
	
	public batter[] getBatter()
	{
		return batter; 
	}
	
	public void setBatter(batter[] batter)
	{
		this.batter=batter;
	}
	
	public  topping[] gettopping()
	{
		return topping;
	}
	
	public void settopping(topping[] topping)
	{
		this.topping= topping;
	}
	
	public String getId() {
		  return id;
		 }

		 public String getType() {
		  return type;
		 }

		 public String getName() {
		  return name;
		 }

		 public float getPpu() {
		  return ppu;
		 }	
	
		 public void setId(String id) {
			  this.id = id;
			 }

			 public void setType(String type) {
			  this.type = type;
			 }

			 public void setName(String name) {
			  this.name = name;
			 }

			 public void setPpu(float ppu) {
			  this.ppu = ppu;
			 }
	
		 
		 
		 
}


