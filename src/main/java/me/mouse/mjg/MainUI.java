package me.mouse.mjg;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.google.common.collect.Maps;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

public class MainUI extends VBox{
	
	public static final Map<String, IGenerator> GENERATORS = Maps.newHashMap();
	public static void addGenerator(IGenerator generator){
		GENERATORS.put(generator.getName(), generator);
	}
	
	static{
		addGenerator(new NormalBlockGenerator());
		addGenerator(new NormalItemGenerator());
		addGenerator(new BlockSlabGenerator());
	}
	
	@FXML private ComboBox<String> jsonTypeComboBox;
	@FXML private TextField modidTextField;
	@FXML private TextField nameTextField;
	@FXML private TextField textureTextField;
	
	public MainUI() throws IOException {
		FXMLLoader loader = new FXMLLoader(MainUI.class.getResource("/fxml/MainUI.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		loader.setCharset(StandardCharsets.UTF_8);
		loader.load();
		
		nameTextField.textProperty().addListener(event->textureTextField.setText(nameTextField.getText()));
		jsonTypeComboBox.getItems().addAll(GENERATORS.keySet());
	}
	
	@FXML
	private void generate(){
		File path = openDirectoryChooser();
		if(path==null)
			return;
		
		String modid = modidTextField.getText();
		String name = nameTextField.getText();
		String texture = textureTextField.getText();
		IGenerator generator = GENERATORS.get(jsonTypeComboBox.getValue());
		if(generator!=null)
			generator.generate(path,modid,name,texture);
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
