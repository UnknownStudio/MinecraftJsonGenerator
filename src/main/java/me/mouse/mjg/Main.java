package me.mouse.mjg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(new MainUI());
		
		primaryStage.setScene(scene);
		primaryStage.setWidth(900);
		primaryStage.setHeight(600);
		primaryStage.setTitle("MinecraftJsonGenerator");
		primaryStage.show();
	}

}
