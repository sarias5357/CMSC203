

import javafx.geometry.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button hello, howdy, chinese, russian, clear, exit;
	Label feedback;
	TextField textField;
	//  declare two HBoxes
	HBox hbox1;
	HBox hbox2;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		hello = new Button("Hello");
		howdy = new Button("Howdy");
		chinese = new Button("Chinese");
		russian = new Button("Russian");
		clear = new Button("Clear");
		exit = new Button("Exit");
		feedback = new Label("Feedback:");
		textField = new TextField();
	
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(hello, new Insets(10));
		HBox.setMargin(howdy, new Insets(10));
		HBox.setMargin(chinese, new Insets(10));
		HBox.setMargin(russian, new Insets(10));
		HBox.setMargin(clear, new Insets(10));
		HBox.setMargin(exit, new Insets(10));
		HBox.setMargin(textField, new Insets(10));
		HBox.setMargin(feedback, new Insets(10));
		
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().addAll(feedback, textField);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(hello, howdy, chinese, russian, clear, exit);
		//  add the HBoxes to this FXMainPanel (a VBox)
		this.getChildren().addAll(hbox1, hbox2);
		
		hello.setOnAction(new ButtonHandler());
		howdy.setOnAction(new ButtonHandler());
		chinese.setOnAction(new ButtonHandler());
		russian.setOnAction(new ButtonHandler());
		clear.setOnAction(new ButtonHandler());
		exit.setOnAction(new ButtonHandler());
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent event) {
			
			Button clicked = (Button) event.getTarget();
	
			if (clicked == hello || clicked == howdy || 
					clicked == chinese || clicked == russian) {
				if (clicked == (hello)) {
					textField.setText(dataManager.getHello());
				}
				else if (clicked == howdy) {
					textField.setText(dataManager.getHowdy());
				}
				else if (clicked == chinese){
					textField.setText(dataManager.getChinese());
				}
				else {
					textField.setText(dataManager.getRussian());
				}
			}
			else if (clicked == clear) {
				textField.setText("");
			}
			else if (clicked == exit) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
