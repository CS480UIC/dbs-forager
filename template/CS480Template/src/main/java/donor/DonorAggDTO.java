package donor;

public class DonorAggDTO {

	private String donorType;
	private int count;
	
	
	public DonorAggDTO(String donorType, int count) {
		super();
		this.donorType = donorType;
		this.count = count;
	}
	public String getDonorType() {
		return donorType;
	}
	public void setDonorType(String donorType) {
		this.donorType = donorType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
