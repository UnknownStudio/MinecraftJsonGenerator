package me.mouse.mjg;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BlockStairsGenerator extends VBox implements IGenerator,IController{
	
	@FXML private TextField textureTF;
	@FXML private TextField outerNameTF;
	@FXML private TextField innerNameTF;
	
	public BlockStairsGenerator() {
		loadFXML("BlockStairs");
	}

	@Override
	public String getName() {
		return "Block Stairs";
	}

	@Override
	public void generate(File path, String modid, String name) {
		String texture = textureTF.getText();
		String outerName = outerNameTF.getText();
		String innerName = innerNameTF.getText();
		
		File blockstate = new File(path,"blockstates/"+name+".json");
		generateFile(blockstate, "blockstates/block_stairs.json", modid,name,outerName,innerName);
		File block = new File(path,"models/block/"+name+".json");
		generateFile(block, "block/block_stairs.json", modid,texture);
		File outer = new File(path,"models/block/"+outerName+".json");
		generateFile(outer, "block/block_outer_stairs.json", modid,texture);
		File inner = new File(path,"models/block/"+innerName+".json");
		generateFile(inner, "block/block_inner_stairs.json", modid,texture);
		File item = new File(path, "models/item/"+name+".json");
		generateFile(item, "item/item_block.json", modid,name);
	}
}
