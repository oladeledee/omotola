/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MidtermV2_Last_First;
/**
 *
 * @author Omotola
 */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Mortage_calculator extends Application {
  private TextField AnnualInterestRate = new TextField();
  private TextField NumberOfYears = new TextField();
  private TextField LoanAmount = new TextField();
  private TextField MonthlyPayment = new TextField();
  private TextField TotalPayment = new TextField();
  private Button btn= new Button("Calculate");
  
  @Override 
  public void start(Stage primaryStage) {
    // Create UI
    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    
    
    gridPane.add(new Label("Annual Interest Rate:"), 0, 0);
    gridPane.add(AnnualInterestRate, 1, 0);
    gridPane.add(new Label("Number of Years:"), 0, 1);
    gridPane.add(NumberOfYears, 1, 1);
    gridPane.add(new Label("Loan Amount:"), 0, 2);
    gridPane.add(LoanAmount, 1, 2);
    gridPane.add(new Label("Monthly Payment:"), 0, 3);
    gridPane.add(MonthlyPayment, 1, 3);
    gridPane.add(new Label("Total Payment:"), 0, 4);
    gridPane.add(TotalPayment, 1, 4);
    gridPane.add(btn, 1, 5);

    // Set properties for UI
    gridPane.setAlignment(Pos.CENTER);
    AnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
    NumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
    LoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
    MonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
    TotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
    MonthlyPayment.setEditable(false);
    TotalPayment.setEditable(false);
    GridPane.setHalignment(btn, HPos.RIGHT);

    // Process events
    btn.setOnAction(e -> calculateLoanPayment());

    // Create a scene and place it in the stage
    Scene scene = new Scene(gridPane, 400, 250);
    // Set title
    primaryStage.setTitle("Mortgage Calculator"); 
    // Place the scene in the stage
    primaryStage.setScene(scene);
    
    // Display the stage
    primaryStage.show(); 
  }
  
  private void calculateLoanPayment() {
    // Get values from text fields
    double interest =
      Double.parseDouble(AnnualInterestRate.getText());
    int year = Integer.parseInt(NumberOfYears.getText());
    double loanAmount =
      Double.parseDouble(LoanAmount.getText());

    // instantiate a Mortgage object
    Mortgage mortgage = new Mortgage(interest, year, loanAmount);

    
   
		
        
    // Display monthly payment and total payment
    MonthlyPayment.setText(String.format("$%.2f",
      mortgage.getMonthlyPayment()));
    MonthlyPayment.setStyle("-fx-text-fill:green;-fx-font-weight: bold;");
    
    
    TotalPayment.setText(String.format("$%.2f",
      mortgage.getTotalPayment()));
    TotalPayment.setStyle("-fx-text-fill:green;-fx-font-weight: bold;");
    
  }
      public static void main(String[] args) {
        launch(args);
    }
  
  
  

}
