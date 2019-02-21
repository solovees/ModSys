package main.services;

import javafx.scene.chart.XYChart;

import static java.lang.String.format;

/**
 * Построение графиков
 */
public class GraphicService {

    private static final String formula = "%sx²%s%sx+%s";

    public XYChart.Series setSeriesForGraphic(Integer a, Integer b, Integer c, Double... xValues) {
        XYChart.Series series = new XYChart.Series();
        double step = countStep(xValues[0], xValues[1]);
        for (double x = xValues[0]; x < xValues[1]; x += step) {
            double y = a * Math.pow(x, 2) + b * x + c;
            series.getData().add(new XYChart.Data(x, y));
        }
        series.setName(format(formula, a, getSign(b), b, c));
        series.setName(format(formula, a, getSign(b), b, c));
        return series;
    }

    private double countStep(double xMin, double xMax) {
        return (xMax - xMin) / 100;
    }

    private String getSign(Integer b) {
        return b > 0 ? "+" : "";
    }
}
