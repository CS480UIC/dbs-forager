package interaction;

public class Interaction {

	
		
			
	private int interactionId;
	private int messageId;
	private int replyOf;
	private int toId;
	private int fromId;
	private String dateCreated;
	private String messageContent;
	


	public Interaction() {
	}


	
	public Interaction(int interactionId, String string, String string2, int toId, int fromId, String dateCreated, String messageContent) {
		super();
		this.interactionId = interactionId;
		this.messageId = Integer.parseInt(string);
		this.replyOf = Integer.parseInt(string2);
		this.toId =  toId;
		this.fromId =  fromId;
		this.dateCreated = dateCreated;
		this.messageContent =  messageContent;
		
	}
	
	
	public Interaction(int interactionId, String messageId, String replyOf, String toId, String fromId, String dateCreated, String messageContent) {
		super();
		this.interactionId = interactionId;
		this.messageId = Integer.parseInt(messageId);
		this.replyOf = Integer.parseInt(replyOf);
		this.toId =  Integer.parseInt(toId);
		this.fromId =  Integer.parseInt(fromId);
		this.dateCreated = dateCreated;
		this.messageContent =  messageContent;
		
	}
	
	
	public Interaction(String interactionId, String messageId, String replyOf, String toId, String fromId, String dateCreated, String messageContent) {
		super();
		this.interactionId = Integer.parseInt(interactionId);
		this.messageId = Integer.parseInt(messageId);
		this.replyOf = Integer.parseInt(replyOf);
		this.toId =  Integer.parseInt(toId);
		this.fromId =  Integer.parseInt(fromId);
		this.dateCreated = dateCreated;
		this.messageContent =  messageContent;
		
	}
	
	

	public Interaction(String interactionId, String messageId, String toId, String fromId, String dateCreated) {
		super();
		this.interactionId = Integer.parseInt(interactionId);
		this.messageId = Integer.parseInt(messageId);

		this.toId =  Integer.parseInt(toId);
		this.fromId =  Integer.parseInt(fromId);
		this.dateCreated = dateCreated;
		
	}
	
	public Interaction(String interactionId, String messageId, String replyOf, String toId, String fromId, String dateCreated) {
		super();
		this.interactionId = Integer.parseInt(interactionId);
		this.messageId = Integer.parseInt(messageId);
		this.replyOf = Integer.parseInt(replyOf);
		this.toId =  Integer.parseInt(toId);
		this.fromId =  Integer.parseInt(fromId);
		this.dateCreated = dateCreated;
		
	}



	public int getMessageId() {
		return messageId;
	}



	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}



	public int getReplyOf() {
		return replyOf;
	}



	public void setReplyOf(int replyOf) {
		this.replyOf = replyOf;
	}



	public int getToId() {
		return toId;
	}



	public void setToId(int toId) {
		this.toId = toId;
	}



	public int getFromId() {
		return fromId;
	}



	public void setFromId(int fromId) {
		this.fromId = fromId;
	}



	public String getDateCreated() {
		return dateCreated;
	}



	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}



	public String getMessageContent() {
		return messageContent;
	}



	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}



	public int getInteractionId() {
		return interactionId;
	}

	public void setInteractionId(int interactionId) {
		this.interactionId = interactionId;
	}



	@Override
	public String toString() {
		return "Interaction [interactionId=" + interactionId + ", messageId=" + messageId + ", replyOf=" + replyOf
				+ ", toId =" + toId  + ", fromId="  + fromId + ",  dateCreated=" + dateCreated + ", messageContent=" + messageContent +"]";
	}

}
