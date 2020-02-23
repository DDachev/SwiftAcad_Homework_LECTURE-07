package bg.swift.HW07_Ex03;

import java.time.LocalDateTime;

public class ContentFile extends File {
	private String content;
	private LocalDateTime lastModifiedDate;
	
	public ContentFile(String name, String location, String content) {
		super(name, location);
		this.content = content;
		this.lastModifiedDate = super.getCreationDate();
	}

	@Override
	protected void execute() {
		if(super.getDelete()) {
			System.out.println("Empty");
		}
	}

	@Override
	protected String getInfo() {
		String output = String.format(super.getInfo() + "%nLast modification date: " + this.lastModifiedDate);
		return output;
	}
	

	protected void modify(String data) {
		this.content = data;
		this.lastModifiedDate = LocalDateTime.now();
	}
	
	protected String getContent() {
		return this.content;
	}
	
}
