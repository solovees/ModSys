package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextField;
import main.services.DiscretService;
import main.services.GraphicService;
import main.services.PermanentService;

/**
 * Главный контроолер приложения
 */
public class Controller {

    /**
     * Сервисы
     */
    private GraphicService graphicService = new GraphicService();
    private DiscretService discretService = new DiscretService();
    private PermanentService permanentService = new PermanentService();

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
    private TextField minX2;
    @FXML
    private TextField maxX2;
    @FXML
    private TextField inputExperimentN;
    @FXML
    private TextField inputExperimentPermament;

    @FXML
    private LineChart graphic;
    @FXML
    private LineChart graphicDiscret;
    @FXML
    private LineChart graphicPermament;

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
        discretService.setBaseLine(graphicDiscret, minX, maxX);
        discretService.setSeriesForGraphic(graphicDiscret, n, minX, maxX);
    }

    /**
     * Проверка генерации случайных числе, непрерывный случай
     *
     * @param event - событие нажатия кнопки
     */
    public void createPermanentGraphic(ActionEvent event) {
        Integer minX = Integer.parseInt(minX2.getText());
        Integer maxX = Integer.parseInt(maxX2.getText());
        Integer n = Integer.parseInt(inputExperimentPermament.getText());
        permanentService.setBaseLine(graphicPermament, minX, maxX);
        permanentService.setSeriesForGraphic(graphicPermament, n, minX, maxX);
    }


}
