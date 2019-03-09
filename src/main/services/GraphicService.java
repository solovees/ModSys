package main.services;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.Arrays;

import static java.lang.String.format;

/**
 * Построение графиков
 */
public class GraphicService extends BaseService {

    private static final String formula = "%sx²%s%sx+%s";

    public void setSeriesForGraphic(XYChart graphic, Double a, Double b, Double c, Double... xValues) {
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

    protected double countStep(double xMin, double xMax) {
        return (xMax - xMin) / 100;
    }

    protected String getSign(Double b) {
        return b > 0 ? "+" : "";
    }

    @Override
    public void setSeriesForGraphic(XYChart graphic, Integer n, Integer minX, Integer maxX) {
        setSeriesForGraphic(graphic, new Double(n), new Double(minX), new Double(maxX), -10.0, 10.0);
    }
}
