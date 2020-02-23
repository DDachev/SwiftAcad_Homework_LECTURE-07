package bg.swift.HW07_Ex03;

import java.time.LocalDateTime;

public class ExecutableFile extends File {
	private LocalDateTime lastExecutionDate;
	private String[] requiredResources;

	protected ExecutableFile(String name, String location, String...args) {
		super(name, location);
		this.requiredResources = args;
	}

	@Override
	protected void execute() {
		this.lastExecutionDate = LocalDateTime.now();
		System.out.println("Executing " + getLocation() + "/" + getName());
	}

	@Override
	protected String getInfo() {
		String output = String.format(super.getInfo() + "%nLast execution date: " + this.lastExecutionDate + "%nRequired resources:");
		for(int i = 0; i < this.requiredResources.length; i++) {
			output += String.format("%n%s", this.requiredResources[i]);
		}
		return output;
	}
	
	protected String[] getRequiredResources() {
		return this.requiredResources;
	}

}
