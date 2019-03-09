package main.services;

import javafx.scene.chart.XYChart;

import static java.lang.Math.abs;
import static java.lang.String.format;

public class NsvService extends BaseService {

    private static final String formula = "%sx²%s%sx+%s";

    public void setSeriesForGraphic(XYChart graphic, Double A, Double B, Double alpha, Double betta) {
        XYChart.Series series = new XYChart.Series();
        Double a = (alpha + betta) / (2 * (B - A));
        Double b = -(betta * A + alpha * B) / (B - A);
        Double c = (betta * Math.pow(A, 2) + alpha * Math.pow(B, 2)) / (B - A);
        double step = countStep(A, B);
        for (double x = A; x <= B; x += step) {
            double y = a * Math.pow(x, 2) + b * x + c;
            series.getData().add(new XYChart.Data(x, y));
        }
        series.setName(format(formula, a, getSign(b), abs(b), c));
        series.setName(format(formula, a, getSign(b), abs(b), c));
        graphic.getData().add(series);
    }

    protected double countStep(double xMin, double xMax) {
        return (xMax - xMin) / 100;
    }

    protected String getSign(Double b) {
        return b > 0 ? "+" : "-";
    }
}
