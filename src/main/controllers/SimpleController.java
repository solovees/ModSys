package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextField;
import main.services.GraphicService;

/**
 * Контроллер построения графика параболлы
 */
public class SimpleController {

    private GraphicService graphicService = new GraphicService();

    @FXML
    private TextField inputA;
    @FXML
    private TextField inputB;
    @FXML
    private TextField inputC;
    @FXML
    private TextField minX;
    @FXML
    private TextField maxX;
    @FXML
    private LineChart graphic;

    /**
     * Создание графика параболлы по заданным пааметрам
     *
     * @param event - событие нажатия кнопки
     */
    public void createGraphic(ActionEvent event) {
        Double a = Double.parseDouble(inputA.getText());
        Double b = Double.parseDouble(inputB.getText());
        Double c = Double.parseDouble(inputC.getText());
        Double xMin = Double.parseDouble(minX.getText());
        Double xMax = Double.parseDouble(maxX.getText());
        graphicService.setSeriesForGraphic(graphic, a, b, c, xMin, xMax);
    }
}
