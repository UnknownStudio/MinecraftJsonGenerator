package me.mouse.mjg;

import java.io.File;

import me.mouse.mjg.util.IOUtils;

public interface IGenerator {

	public String getName();
	public void generate(File path,String modid,String name);
	
	default public void generateFile(File target,String source,Object ...args){
		IOUtils.writeFile(target, String.format(IOUtils.readFile(BlockSlabGenerator.class.getResourceAsStream("/json/"+source)), args));
	}
}
