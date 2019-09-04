//Alex Mcbride CIS340 3pm
public class Device {

	private String sku;
	private String name;
	private Boolean status;
	
	public void Device() {
		status = true;
	}
	
	public String getSku() {
		return sku;
	}
	
	public void setSku(String sku) {
		this.sku=sku;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setStatus(Boolean status) {
		this.status=status;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public String availability() {
	
		String availability = "";
		
		if (status == true) {
			 availability= "Available";
			 
		} else  {
			availability= "Unavailable";
				
		}
			
			return availability;
	
	}
}
