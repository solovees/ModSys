package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextField;
import main.services.PermanentService;

/**
 *  Контроллер непрерывного распределения слуяайной величины
 */
public class PermamentController {

    private PermanentService permanentService = new PermanentService();

    @FXML
    private TextField minX2;
    @FXML
    private TextField maxX2;
    @FXML
    private TextField inputExperimentPermament;

    @FXML
    private LineChart graphicPermament;


    /**
     * Проверка генерации случайных числе, непрерывный случай
     *
     * @param event - событие нажатия кнопки
     */
    public void createGraphic(ActionEvent event) {
        Integer minX = Integer.parseInt(minX2.getText());
        Integer maxX = Integer.parseInt(maxX2.getText());
        Integer n = Integer.parseInt(inputExperimentPermament.getText());
        permanentService.setBaseLine(graphicPermament, minX, maxX);
        permanentService.setSeriesForGraphic(graphicPermament, n, minX, maxX);
    }
}
