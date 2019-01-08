package cn.entity;

public class subject {
	private String subject;

	public subject() {
		
	}

	public subject(String subject) {
		super();
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "subject [subject=" + subject + "]";
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
