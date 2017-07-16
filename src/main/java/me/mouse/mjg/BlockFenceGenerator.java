package me.mouse.mjg;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BlockFenceGenerator extends VBox implements IGenerator,IController{
	
	@FXML private TextField textureTF;
	
	public BlockFenceGenerator() {
		loadFXML("BlockFence");
	}

	@Override
	public String getName() {
		return "Block Fence";
	}

	@Override
	public void generate(File path, String modid, String name) {
		String texture = textureTF.getText();
		
		File blockstate = new File(path,"blockstates/"+name+".json");
		generateFile(blockstate, "blockstates/block_fence.json", modid,name);
		File side = new File(path,"models/block/"+name+"_side.json");
		generateFile(side, "block/block_fence_side.json", modid,texture);
		File post = new File(path,"models/block/"+name+"_post.json");
		generateFile(post, "block/block_fence_post.json", modid,texture);
		File inv = new File(path,"models/block/"+name+"_inventory.json");
		generateFile(inv, "block/block_fence_inventory.json", modid,texture);
		File item = new File(path, "models/item/"+name+".json");
		generateFile(item, "item/item_block.json", modid,name+"_inventory");
	}
}
