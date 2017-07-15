package me.mouse.mjg;

import java.io.File;

public class NormalItemGenerator implements IGenerator{

	@Override
	public String getName() {
		return "Normal Item";
	}

	@Override
	public void generate(File path, String modid, String name) {
		File item = new File(path, "models/item/"+name+".json");
		generateFile(item, "item/item.json", modid,name);
	}

}
