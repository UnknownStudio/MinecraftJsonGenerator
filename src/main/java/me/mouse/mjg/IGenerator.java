package me.mouse.mjg;

import java.io.File;

public interface IGenerator {

	public String getName();
	public void generate(File path,String modid,String name,String texture);
}
