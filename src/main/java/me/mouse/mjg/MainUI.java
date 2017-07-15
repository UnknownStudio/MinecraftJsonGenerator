package me.mouse.mjg;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.google.common.collect.Maps;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

public class MainUI extends VBox implements IController{
	
	public static final Map<String, IGenerator> GENERATORS = Maps.newHashMap();
	public static void addGenerator(IGenerator generator){
		GENERATORS.put(generator.getName(), generator);
	}
	
	static{
		addGenerator(new NormalBlockGenerator());
		addGenerator(new NormalItemGenerator());
		addGenerator(new BlockSlabGenerator());
		addGenerator(new CustomSlabGenerator());
	}
	
	@FXML private ComboBox<String> jsonTypeComboBox;
	@FXML private TextField modidTextField;
	@FXML private TextField nameTextField;
	@FXML private AnchorPane customPane;
	
	public MainUI() throws IOException {
		loadFXML("MainUI");
		
		jsonTypeComboBox.getItems().addAll(GENERATORS.keySet());
		jsonTypeComboBox.valueProperty().addListener(event->{
			IGenerator generator = GENERATORS.get(jsonTypeComboBox.getValue());
			if(generator instanceof Node){
				Node node = (Node) generator;
				customPane.getChildren().add(node);
				AnchorPane.setBottomAnchor(node, 0D);
				AnchorPane.setLeftAnchor(node, 0D);
				AnchorPane.setRightAnchor(node, 0D);
				AnchorPane.setTopAnchor(node, 0D);
			}else{
				customPane.getChildren().clear();
			}
		});
	}
	
	@FXML
	private void generate(){
		File path = openDirectoryChooser();
		if(path==null)
			return;
		
		String modid = modidTextField.getText();
		String name = nameTextField.getText();
		IGenerator generator = GENERATORS.get(jsonTypeComboBox.getValue());
		if(generator!=null)
			generator.generate(path,modid,name);
	}
	
	private File lastPath;
	private File openDirectoryChooser(){
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("选择生成路径");
		directoryChooser.setInitialDirectory(lastPath);
		
		File result = directoryChooser.showDialog(getScene().getWindow());
		
		if(result!=null)
			lastPath = result;
		
		return result;
	}
}
