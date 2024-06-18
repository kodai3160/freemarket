package bean;

public class MailInfo {

	private int mail_id;
	
	private int sender_id;
	
	private int receiver_id;
	
	private String message;
	
	private String sent_date;
	
	public MailInfo() {
		this.mail_id = 0;
		this.sender_id = 0;
		this.receiver_id = 0;
		this.message = null;
		this.sent_date = null;
	}

	public int getMail_id() {
		return mail_id;
	}

	public void setMail_id(int mail_id) {
		this.mail_id = mail_id;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public int getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSent_date() {
		return sent_date;
	}

	public void setSent_date(String sent_date) {
		this.sent_date = sent_date;
	}
}
