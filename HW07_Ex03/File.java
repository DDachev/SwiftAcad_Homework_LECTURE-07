package bg.swift.HW07_Ex03;

import java.time.LocalDateTime;

public class File {
	private String name;
	private String location;
	private LocalDateTime creationDate;
	private boolean isDeleted;

	public File(String name, String location) {
		this.name = name;
		this.location = location;
		this.creationDate = LocalDateTime.now();
	}

	protected void move(String newLocation) {
		this.location = newLocation;
	}

	protected File copy(String newLocation) {
		File newFile = new File(this.name, newLocation);
		return newFile;
	}

	protected void delete() {
		this.isDeleted = true;
	}

	protected void execute() {
		if (!this.isDeleted) {
			System.out.println(getInfo());
		}
	}

	protected String getInfo() {
		if (isDeleted) {
			String output = String.format("Name: %s/%s [DELETED]%nCreation date: " + this.creationDate, this.location,
					this.name);
			return output;
		}
		String output = String.format("Name: %s/%s%nCreation date: " + this.creationDate, this.location, this.name);
		return output;
	}

	protected boolean getDelete() {
		return isDeleted;
	}

	protected String getName() {
		return this.name;
	}

	protected String getLocation() {
		return this.location;
	}

	protected LocalDateTime getCreationDate() {
		return this.creationDate;
	}
}
