package receiver;

public class Receiver {

	private int usersId;
	private String receiverType;
	private int avgRatingGiven;
	private int receiverId;

	public Receiver() {
	}

	public Receiver(int usersId, String receiverType, int avgRatingGiven, int receiverId) {
		super();
		this.usersId = usersId;
		this.receiverType = receiverType;
		this.avgRatingGiven = avgRatingGiven;
		this.receiverId = receiverId;
	}

	public Receiver(String receiverId, String receiverType, String usersId) {
		super();
		this.usersId = Integer.parseInt(usersId);
		this.receiverType = receiverType;
		this.receiverId = Integer.parseInt(receiverId);
	}

	public Receiver(String receiverId, String receiverType, String usersId, String avgRatingGiven) {
		super();
		this.usersId = Integer.parseInt(usersId);
		this.receiverType = receiverType;
		this.receiverId = Integer.parseInt(receiverId);
		this.avgRatingGiven = Integer.parseInt(avgRatingGiven);
	}

	@Override
	public String toString() {
		return "Receiver [usersId=" + usersId + ", receiverType=" + receiverType + ", avgRatingGiven=" + avgRatingGiven
				+ ", receiverId=" + receiverId + "]";
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getReceiverType() {
		return receiverType;
	}

	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType;
	}

	public int getAvgRatingGiven() {
		return avgRatingGiven;
	}

	public void setAvgRatingGiven(int avgRatingGiven) {
		this.avgRatingGiven = avgRatingGiven;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

}
