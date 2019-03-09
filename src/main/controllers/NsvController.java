package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextField;
import main.services.NsvService;

public class NsvController {

    private NsvService service = new NsvService();

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


    /**
     * @param event - событие нажатия кнопки
     */
    public void createGraphic(ActionEvent event) {
        Double a = Double.parseDouble(inputNsvA.getText());
        Double b = Double.parseDouble(inputNsvB.getText());
        Double al = Double.parseDouble(alpha.getText());
        Double bet = Double.parseDouble(betta.getText());
        service.setSeriesForGraphic(graphicNsv, a, b, al, bet);
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
