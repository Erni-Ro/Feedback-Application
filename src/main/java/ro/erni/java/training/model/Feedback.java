package ro.erni.java.training.model;

public class Feedback {

	private int senderId;
	private String senderName;
	private int receiverId;
	private String receiverName;
	private boolean isAnonymous;
	private String rocks;
	private String good;
	private String improve;

	public Feedback(){

	}
	
	public Feedback(int senderId, int receiverId, boolean isAnonymous, String rocks, String good, String improve) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.isAnonymous = isAnonymous;
		this.rocks = rocks;
		this.good = good;
		this.improve = improve;
	}
	

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public boolean isAnonymous() {
		return isAnonymous;
	}

	public void setAnonymous(boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public String getRocks() {
		return rocks;
	}

	public void setRocks(String rocks) {
		this.rocks = rocks;
	}

	public String getGood() {
		return good;
	}

	public void setGood(String good) {
		this.good = good;
	}

	public String getImprove() {
		return improve;
	}

	public void setImprove(String improve) {
		this.improve = improve;
	}

	@Override
	public String toString() {
		return senderId + " " + senderName + " " +receiverId + " " + receiverName +" " + rocks + " " +good+ " " +improve;
	}

	public int getFirstName() {
		// TODO Auto-generated method stub
		return 0;
	}
}
