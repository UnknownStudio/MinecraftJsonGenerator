package me.mouse.mjg;

import java.io.File;

import me.mouse.mjg.util.IOUtils;

public class NormalItemGenerator implements IGenerator{

	@Override
	public String getName() {
		return "Normal Item";
	}

	@Override
	public void generate(File path, String modid, String name, String texture) {
		File item = new File(path, "models/item/"+name+".json");
		IOUtils.writeFile(item, String.format("{\n"
				+"  \"parent\": \"item/generated\",\n"
				+"  \"textures\": {\n"
				+"    \"layer0\": \"%1$s:items/%2$s\"\n"
				+"  }\n"
				+"}", modid, name));
	}

}
