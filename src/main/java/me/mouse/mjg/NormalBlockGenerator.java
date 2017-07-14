package me.mouse.mjg;

import java.io.File;

import me.mouse.mjg.util.IOUtils;

public class NormalBlockGenerator implements IGenerator{

	@Override
	public String getName() {
		return "Normal Block";
	}

	@Override
	public void generate(File path,String modid,String name, String texture) {
		File blockstate = new File(path,"blockstates/"+name+".json");
		IOUtils.writeFile(blockstate, String.format("{\n"
				+ "  \"variants\": {\n"
				+ "    \"normal\": {\"model\": \"%1$s:%2$s\"}\n"
				+ "  }\n"
				+ "}", modid,name));
		File block = new File(path,"models/block/"+name+".json");
		IOUtils.writeFile(block, String.format("{\n" 
				+ "  \"parent\": \"block/cube_all\",\n" 
				+ "  \"textures\": {\n"
				+ "    \"all\": \"%1$s:blocks/%2$s\"\n" 
				+ "  }\n" 
				+ "}", modid, name));
		File item = new File(path, "models/item/"+name+".json");
		IOUtils.writeFile(item, String.format("{\n"
				+"  \"parent\": \"%1$s:block/%2$s\"\n"
				+"}", modid, name));
	}
}
