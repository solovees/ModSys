package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextField;
import main.services.GraphicService;

/**
 * Главный контроолер приложения
 */
public class Controller {

    /**
     * Сервисы
     */
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
        Integer a = Integer.parseInt(inputA.getText());
        Integer b = Integer.parseInt(inputB.getText());
        Integer c = Integer.parseInt(inputC.getText());
        Double xMin = Double.parseDouble(minX.getText());
        Double xMax = Double.parseDouble(maxX.getText());
        graphic.getData()
                .add(graphicService.setSeriesForGraphic(a, b, c, xMin, xMax));
    }
}
