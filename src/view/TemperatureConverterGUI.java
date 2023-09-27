package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.TemperatureConverter;

/*
 * A program that allows the user to enter a Celsius temperature
 * and show the Fahrenheit difference (and visa versa)
 */
public class TemperatureConverterGUI extends Application {

  public static void main(String[] args) {
    launch(args);
  }
  
  private Label celsius = new Label("    Celsius");
  private TextField textCelcius = new TextField("");
  private Label fahrenheit = new Label("Fahrenheit");
  private TextField textFahrenheit = new TextField("");

  @Override
  public void start(Stage stage) {
    // The main entry point into this program
    stage.setTitle("CtoF FtoC");
    GridPane pane = new GridPane();
    pane.setHgap(10);
    pane.setVgap(10);
    // Added three UI controls
    pane.add(celsius, 1, 0);
    pane.add(textCelcius, 2, 0);
    pane.add(fahrenheit, 1, 2);
    pane.add(textFahrenheit, 2, 2);

    BorderPane holder = new BorderPane();
    holder.setCenter(pane);
    holder.setTop(new Label(" "));
    holder.setLeft(new Label("   "));

    Scene scene = new Scene(holder, 280, 110); 
    stage.setScene(scene);

    textCelcius.setOnAction(new isCelcius());
    textFahrenheit.setOnAction(new isFahrenheit());

    // Don't forget to show the running app:
    stage.show();
  }

  private class isFahrenheit implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      String str = textFahrenheit.getText().trim();
      if (str.length() > 0) {
        double input = Double.parseDouble(str);
        double output = TemperatureConverter.FtoC(input);
        textCelcius.setText("" + output);
      }
    }
  }

  private class isCelcius implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      double input = Double.parseDouble(textCelcius.getText());
      Double output = TemperatureConverter.CtoF(input);
      textFahrenheit.setText("" + output);
    }
  }
}
