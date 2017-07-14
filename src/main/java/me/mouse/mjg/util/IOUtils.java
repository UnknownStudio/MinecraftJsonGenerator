package me.mouse.mjg.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;

public enum IOUtils {
	;
	
	public static String readFile(File file){
		if(!file.exists())
			return "";
		
		StringBuilder builder = new StringBuilder("");
		try{
			FileReader reader = new FileReader(file);
			for(String line:org.apache.commons.io.IOUtils.readLines(reader))
				builder.append(line).append("\n");
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	public static String readFile(InputStream input){
		
		StringBuilder builder = new StringBuilder("");
		try{
			for(String line:org.apache.commons.io.IOUtils.readLines(input))
				builder.append(line).append("\n");
			input.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	public static void writeFile(File file,String value){
		try{
			if(!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			
			if(!file.exists())
				file.createNewFile();
			
			FileWriter writer = new FileWriter(file);
			writer.write(value);
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}