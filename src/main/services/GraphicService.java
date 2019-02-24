package main.services;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import static java.lang.String.format;

/**
 * Построение графиков
 */
public class GraphicService extends BaseService {

    private static final String formula = "%sx²%s%sx+%s";

    public void setSeriesForGraphic(LineChart graphic, Integer a, Integer b, Integer c, Double... xValues) {
        XYChart.Series series = new XYChart.Series();
        double step = countStep(xValues[0], xValues[1]);
        for (double x = xValues[0]; x < xValues[1]; x += step) {
            double y = a * Math.pow(x, 2) + b * x + c;
            series.getData().add(new XYChart.Data(x, y));
        }
        series.setName(format(formula, a, getSign(b), b, c));
        series.setName(format(formula, a, getSign(b), b, c));
        graphic.getData().add(series);
    }
}
