package me.mouse.mjg;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BlockFenceGateGenerator extends VBox implements IGenerator,IController{
	
	@FXML private TextField textureTF;
	@FXML private TextField wallNameTF;
	
	public BlockFenceGateGenerator() {
		loadFXML("BlockFenceGate");
	}

	@Override
	public String getName() {
		return "Block Fence Gate";
	}

	@Override
	public void generate(File path, String modid, String name) {
		String texture = textureTF.getText();
		String wallName = wallNameTF.getText();

		File blockstate = new File(path, "blockstates/" + name + ".json");
		generateFile(blockstate, "blockstates/block_fence_gate.json", modid, name, wallName);
		File open = new File(path, "models/block/" + name + "_open.json");
		generateFile(open, "block/block_fence_gate_open.json", modid, texture);
		File closed = new File(path, "models/block/" + name + "_closed.json");
		generateFile(closed, "block/block_fence_gate_closed.json", modid, texture);
		File wallopen = new File(path, "models/block/" + wallName + "_open.json");
		generateFile(wallopen, "block/block_wall_gate_open.json", modid, texture);
		File wallclosed = new File(path, "models/block/" + wallName + "_closed.json");
		generateFile(wallclosed, "block/block_wall_gate_closed.json", modid, texture);
		File item = new File(path, "models/item/" + name + ".json");
		generateFile(item, "item/item_block.json", modid, name + "_closed");
	}
}
