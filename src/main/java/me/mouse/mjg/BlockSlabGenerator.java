package me.mouse.mjg;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BlockSlabGenerator extends VBox implements IGenerator,IController{
	
	@FXML private TextField textureTF;
	@FXML private TextField doubleNameTF;
	@FXML private TextField doubleModelTF;
	
	public BlockSlabGenerator() {
		loadFXML("BlockSlab");
	}

	@Override
	public String getName() {
		return "Block Slab";
	}

	@Override
	public void generate(File path, String modid, String name) {
		String texture = textureTF.getText();
		String doubleName = doubleNameTF.getText();
		String doubleModel = doubleModelTF.getText();
		
		File blockstate = new File(path,"blockstates/"+name+".json");
		generateFile(blockstate, "blockstates/block_slab.json", modid,name);
		File doubleblockstate = new File(path,"blockstates/"+doubleName+".json");
		generateFile(doubleblockstate, "blockstates/block_double_slab.json", modid,doubleModel);
		File slab_half = new File(path,"models/block/"+name+"_half.json");
		generateFile(slab_half, "block/block_slab_half.json", modid,texture);
		File slab_top = new File(path,"models/block/"+name+"_top.json");
		generateFile(slab_top, "block/block_slab_top.json", modid,texture);
		File item = new File(path, "models/item/"+name+".json");
		generateFile(item, "item/item_block.json", modid,name+"_half");
	}
}
