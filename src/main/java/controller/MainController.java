package controller;

import model.CalculationRecord;
import util.CalculationService;
import util.LocalizationService;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    @FXML private TextField distanceField;
    @FXML private TextField consumptionField;
    @FXML private TextField priceField;
    @FXML private Label resultLabel;
    @FXML private Button calculateButton;
    @FXML private Label titleLabel;

    private LocalizationService localizationService = new LocalizationService();
    private CalculationService calculationService = new CalculationService();

    private String currentLanguage = "en";

    @FXML
    public void initialize() {
        setLanguage("en");
    }

    public void setLanguage(String lang) {
        currentLanguage = lang;
        localizationService.loadStrings(lang);

        titleLabel.setText(localizationService.getString("title"));
        calculateButton.setText(localizationService.getString("calculate"));

        distanceField.setPromptText(localizationService.getString("distance"));
        consumptionField.setPromptText(localizationService.getString("consumption"));
        priceField.setPromptText(localizationService.getString("price"));
    }

    @FXML
    public void handleCalculate() {
        try {
            double distance = Double.parseDouble(distanceField.getText());
            double consumption = Double.parseDouble(consumptionField.getText());
            double price = Double.parseDouble(priceField.getText());

            if (distance <= 0 || consumption <= 0 || price <= 0) {
                throw new Exception();
            }

            double totalFuel = (distance / 100) * consumption;
            double totalCost = totalFuel * price;

            resultLabel.setText(
                    localizationService.getString("result") + " " + totalCost
            );

            CalculationRecord record = new CalculationRecord(
                    distance, consumption, price,
                    totalFuel, totalCost, currentLanguage
            );

            calculationService.saveCalculation(record);

        } catch (Exception e) {
            resultLabel.setText(localizationService.getString("error"));
        }
    }

    public void setEnglish() { setLanguage("en"); }
    public void setFrench() { setLanguage("fr"); }
    public void setJapanese() { setLanguage("jp"); }
    public void setPersian() { setLanguage("ir"); }
}
