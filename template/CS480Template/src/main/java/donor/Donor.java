package donor;

public class Donor {

	private int usersId;
	private String donorType;
	private int noOfTimesDonated;
	private int avgRatingReceived;
	private int donorId;

	public Donor() {
	}

	public Donor(String donorId, String donorType, String usersId) {
		super();
		this.usersId = Integer.parseInt(usersId);
		this.donorType = donorType;
		this.donorId = Integer.parseInt(donorId);
	}

	public Donor(int usersId, String donorType, int noOfTimesDonated, int avgRatingRecieved, int donorId) {
		super();
		this.usersId = usersId;
		this.donorType = donorType;
		this.noOfTimesDonated = noOfTimesDonated;
		this.avgRatingReceived = avgRatingRecieved;
		this.donorId = donorId;
	}

	public Donor(String donorId, String donorType, String usersId, String noOfTimesDonated, String avgRatingRecieved) {
		super();
		this.usersId = Integer.parseInt(usersId);
		this.donorType = donorType;
		this.noOfTimesDonated = Integer.parseInt(noOfTimesDonated);
		this.avgRatingReceived = Integer.parseInt(avgRatingRecieved);
		this.donorId = Integer.parseInt(donorId);
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getDonorType() {
		return donorType;
	}

	public void setDonorType(String donorType) {
		this.donorType = donorType;
	}

	public int getNoOfTimesDonated() {
		return noOfTimesDonated;
	}

	public void setNoOfTimesDonated(int noOfTimesDonated) {
		this.noOfTimesDonated = noOfTimesDonated;
	}

	public int getAvgRatingReceived() {
		return avgRatingReceived;
	}

	public void setAvgRatingRecieved(int avgRatingRecieved) {
		this.avgRatingReceived = avgRatingRecieved;
	}

	@Override
	public String toString() {
		return "Donor [usersId=" + usersId + ", donorType=" + donorType + ", noOfTimesDonated=" + noOfTimesDonated
				+ ", avgRatingReceived=" + avgRatingReceived + "]";
	}

}
