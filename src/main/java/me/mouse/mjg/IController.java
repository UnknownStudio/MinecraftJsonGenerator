package me.mouse.mjg;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public interface IController {
	
	default public Parent loadFXML(String fxml){
		try {
			FXMLLoader loader = new FXMLLoader(IController.class.getResource("/fxml/"+fxml+".fxml"));
			loader.setRoot(this);
			loader.setController(this);
			loader.setCharset(StandardCharsets.UTF_8);
			return loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
