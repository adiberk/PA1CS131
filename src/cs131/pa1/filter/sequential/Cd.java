package cs131.pa1.filter.sequential;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Cd extends SequentialFilter{
	
	public Cd(String directoryName) {
		input = new LinkedList<>();
		output = new LinkedList<>();
		input.add(directoryName);
	}
	
	public String processLine(String line) {
		line = setDirectory(line);
		
		return line;
		
	}
	public static String setDirectory(String directoryName) {
		
		String currentDir =  System.getProperty("user.dir");
		if(directoryName.equals("..")) {
			String[] directNames = currentDir.split("\\\\");
			int lastSlashIndex = currentDir.lastIndexOf("/");
			int prevDirectory = directNames.length-1;
			String directory = "";
			int i = 0;
			while(i < prevDirectory) {
				directory+= directNames[i] + "\\";
				i++;
			}
			System.setProperty("user.dir", directory);
			
		}else{
			
			currentDir+= "\\" + directoryName;
			System.setProperty("user.dir", currentDir);
			
			
		}
		return currentDir;
		
		
	}
	

}
