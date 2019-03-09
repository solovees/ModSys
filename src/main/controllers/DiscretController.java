package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextField;
import main.services.DiscretService;

/**
 * Контроллер для дискретного распределния случайной велечины
 */
public class DiscretController {

    private DiscretService discretService = new DiscretService();

    @FXML
    private TextField minX1;
    @FXML
    private TextField maxX1;
    @FXML
    private TextField inputExperimentN;
    @FXML
    private LineChart graphicDiscret;

    /**
     * Проверка генерации случайных числе, дикретный случай
     *
     * @param event - событие нажатия кнопки
     */
    public void createGraphic(ActionEvent event) {
        Integer minX = Integer.parseInt(minX1.getText());
        Integer maxX = Integer.parseInt(maxX1.getText());
        Integer n = Integer.parseInt(inputExperimentN.getText());
        discretService.setBaseLine(graphicDiscret, minX, maxX);
        discretService.setSeriesForGraphic(graphicDiscret, n, minX, maxX);
    }
}
