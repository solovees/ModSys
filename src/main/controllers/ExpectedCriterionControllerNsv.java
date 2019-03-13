package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;
import main.services.ExpectedCriterionServiceNsv;

public class ExpectedCriterionControllerNsv {
    private ExpectedCriterionServiceNsv service = new ExpectedCriterionServiceNsv();

    @FXML
    private TextField inputNsvA;
    @FXML
    private TextField inputNsvB;
    @FXML
    private TextField alpha;
    @FXML
    private TextField betta;
    @FXML
    private LineChart graphicNsv;
    @FXML
    private TextField inputN;
    @FXML
    private Label x;
    @FXML
    private Label qX;


    /**
     * @param event - событие нажатия кнопки
     */
    public void createGraphic(ActionEvent event) {
        graphicNsv.getStylesheets().add(Main.class.getResource("views/root.css").toExternalForm());
        graphicNsv.setCreateSymbols(true);
        service.clear(graphicNsv);
        Double a = Double.parseDouble(inputNsvA.getText());
        Double b = Double.parseDouble(inputNsvB.getText());
        Double al = Double.parseDouble(alpha.getText());
        Double bet = Double.parseDouble(betta.getText());
        Integer n = Integer.parseInt(inputN.getText());
        service.setSeriesForGraphic(graphicNsv, a, b, al, bet, x, qX, n);
    }

    /**
     * Отчистить график
     *
     * @param event - событие нажатия кнопки
     */
    public void clear(ActionEvent event) {
        service.clear(graphicNsv);
    }


}
