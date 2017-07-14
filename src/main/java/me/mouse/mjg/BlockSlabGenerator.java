package me.mouse.mjg;

import java.io.File;

import me.mouse.mjg.util.IOUtils;

public class BlockSlabGenerator implements IGenerator{

	@Override
	public String getName() {
		return "Block Slab";
	}

	@Override
	public void generate(File path, String modid, String name, String texture) {
		File blockstate = new File(path,"blockstates/"+name+".json");
		IOUtils.writeFile(blockstate, String.format(IOUtils.readFile(BlockSlabGenerator.class.getResourceAsStream("/json/blockstates/block_slab.json")), modid,name));
		File slab_half = new File(path,"models/block/"+name+"_half.json");
		IOUtils.writeFile(slab_half, String.format(IOUtils.readFile(BlockSlabGenerator.class.getResourceAsStream("/json/block/block_slab_half.json")), modid,texture));
		File slab_top = new File(path,"models/block/"+name+"_top.json");
		IOUtils.writeFile(slab_top, String.format(IOUtils.readFile(BlockSlabGenerator.class.getResourceAsStream("/json/block/block_slab_top.json")), modid,texture));
		File item = new File(path, "models/item/"+name+".json");
		IOUtils.writeFile(item, String.format(IOUtils.readFile(BlockSlabGenerator.class.getResourceAsStream("/json/item/item_block.json")), modid,name+"_half"));
	}

}
