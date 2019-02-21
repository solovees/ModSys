package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

import static java.lang.String.format;

public class Controller {

    private static final String formula = "%sx²+%sx+%s";
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

    public void createGraphic(ActionEvent event) {
        graphic.setCreateSymbols(false);
        Integer a = Integer.parseInt(inputA.getText());
        Integer b = Integer.parseInt(inputB.getText());
        Integer c = Integer.parseInt(inputC.getText());
        Double xMin = Double.parseDouble(minX.getText());
        Double xMax = Double.parseDouble(maxX.getText());
        XYChart.Series series = new XYChart.Series();
        double step = (xMax - xMin) / 100;
        for (double x = xMin; x < xMax; x += step) {
            double y = a * Math.pow(x, 2) + b * x + c;
            series.getData().add(new XYChart.Data(x, y));
        }
        series.setName(format(formula, a, b, c));
        graphic.getData().add(series);

    }
}
