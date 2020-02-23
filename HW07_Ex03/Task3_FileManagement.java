package bg.swift.HW07_Ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3_FileManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File[] files = new File[500];
		String[] fileNames = new String[500];
		List<String[]> list = new ArrayList<>();
		int countOfFiles = 0;

		System.out.println("You have to insert command: ");
		String line = sc.nextLine();

		while (!"END".equals(line)) {
			String[] command = line.split(" ");

			if (command[0].equals("MAKE")) {
				String content = command[3].substring(0, 7);
				if (content.equals("CONTENT")) {
					String fileExtension = command[1].substring(command[1].length() - 4, command[1].length());
					if (fileExtension.equals(".mp3") || fileExtension.equals(".avi")) {
						files[countOfFiles] = new MediaContentFile(command[1], command[2], command[3]);
						fileNames[countOfFiles] = command[1];
						countOfFiles++;
					} else {
						files[countOfFiles] = new DocumentContentFile(command[1], command[2], command[3]);
						countOfFiles++;
					}
				} else {
					String[] resources = new String[command.length - 3];
					for (int i = 0; i < resources.length; i++) {
						resources[i] = command[3 + i];
					}
					list.add(resources);
					if (checkRequiredResources(fileNames, resources)) {
						files[countOfFiles] = new ExecutableFile(command[1], command[2], resources);
						fileNames[countOfFiles] = command[1];
						countOfFiles++;
					}
				}
			}

			if (command[0].equals("MOVE")) {
				if (getIndexOfFile(fileNames, command[1]) != -1) {
					files[getIndexOfFile(fileNames, command[1])].move(command[2]);
				}
			}

			if (command[0].equals("MOD")) {
				if (getIndexOfFile(fileNames, command[1]) != -1
						&& files[getIndexOfFile(fileNames, command[1])] instanceof ContentFile) {
					files[getIndexOfFile(fileNames, command[1])] = new ContentFile(command[1],
							files[getIndexOfFile(fileNames, command[1])].getLocation(), command[2]);
				}
			}

			if (command[0].equals("COPY")) {
				if (getIndexOfFile(fileNames, command[1]) != -1) {
					files[countOfFiles] = files[getIndexOfFile(fileNames, command[1])].copy(command[2]);
					countOfFiles++;
				}
			}

			if (command[0].equals("DEL")) {
				if (getIndexOfFile(fileNames, command[1]) != -1) {
					files[getIndexOfFile(fileNames, command[1])].delete();
				}
			}

			if (command[0].equals("EXEC")) {
				if (getIndexOfFile(fileNames, command[1]) != -1) {
					if (files[getIndexOfFile(fileNames, command[1])] instanceof ExecutableFile) {
						files[getIndexOfFile(fileNames, command[1])].execute();
						for (int i = 0; i < countOfFiles - 1; i++) {
							files[i].execute();
						}
					} else {
						files[getIndexOfFile(fileNames, command[1])].execute();
					}
				}
			}

			if (command[0].equals("INFO")) {
				if (getIndexOfFile(fileNames, command[1]) != -1) {
					if (files[getIndexOfFile(fileNames, command[1])] instanceof ExecutableFile) {
						System.out.println(files[getIndexOfFile(fileNames, command[1])].getInfo());
					} else {
						System.out.println(files[getIndexOfFile(fileNames, command[1])].getInfo());
					}
				}
			}
			line = sc.nextLine();
		}
		sc.close();
	}

	private static boolean checkRequiredResources(String[] names, String[] resources) {
		if (resources.length > names.length) {
			return false;
		}

		boolean isResources = false;

		for (int i = 0; i < resources.length; i++) {
			for (int j = 0; j < names.length; j++) {
				if (resources[i].equals(names[j])) {
					isResources = true;
					break;
				}
			}
			if (!isResources) {
				return false;
			}
		}
		return true;
	}

	private static int getIndexOfFile(String[] fileNames, String name) {
		for (int i = 0; i < fileNames.length; i++) {
			if (name.equals(fileNames[i])) {
				return i;
			}
		}
		return -1;
	}
}
