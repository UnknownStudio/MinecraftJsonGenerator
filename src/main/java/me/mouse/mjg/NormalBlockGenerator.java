package me.mouse.mjg;

import java.io.File;

public class NormalBlockGenerator implements IGenerator{

	@Override
	public String getName() {
		return "Normal Block";
	}

	@Override
	public void generate(File path,String modid,String name) {
		File blockstate = new File(path,"blockstates/"+name+".json");
		generateFile(blockstate, "blockstates/block.json", modid,name);
		File block = new File(path,"models/block/"+name+".json");
		generateFile(block, "block/block.json", modid,name);
		File item = new File(path, "models/item/"+name+".json");
		generateFile(item, "item/item_block.json", modid,name);
	}
}
