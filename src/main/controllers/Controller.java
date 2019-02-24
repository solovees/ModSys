package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextField;
import main.services.DiscretService;
import main.services.GraphicService;

/**
 * Главный контроолер приложения
 */
public class Controller {

    /**
     * Сервисы
     */
    private GraphicService graphicService = new GraphicService();
    private DiscretService discretService = new DiscretService();

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
    private TextField minX1;
    @FXML
    private TextField maxX1;
    @FXML
    private LineChart graphic;
    @FXML
    private LineChart graphicDiscret;
    @FXML
    private TextField inputExperimentN;

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
        graphicService.setSeriesForGraphic(graphic, a, b, c, xMin, xMax);
    }

    /**
     * Проверка генерации случайных числе, дикретный случай
     *
     * @param event - событие нажатия кнопки
     */
    public void createDiscretGraphic(ActionEvent event) {
        Integer minX = Integer.parseInt(minX1.getText());
        Integer maxX = Integer.parseInt(maxX1.getText());
        Integer n = Integer.parseInt(inputExperimentN.getText());
        if (graphicDiscret.getData().isEmpty()) {
            discretService.setBaseLine(graphicDiscret, minX, maxX);
        }
        discretService.setSeriesForGraphic(graphicDiscret, n, minX, maxX);
    }
}
