package main.services;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import static java.lang.Math.abs;
import static java.lang.String.format;

public class ExpectedCriterionService extends BaseService {

    private static final String formula = "Теоретическое %sx²%s%sx+%s";
    private static final DecimalFormat df = new DecimalFormat("#.###");
    private Random random = new Random();

    public void setSeriesForGraphic(LineChart graphic, Double A, Double B, Double alpha, Double betta, Label xLabel,
                                    Label qLabel, Integer n) {
        XYChart.Series series = new XYChart.Series();
        Double a = (alpha + betta) / (2 * (B - A));
        Double b = -(betta * A + alpha * B) / (B - A);
        Double c = (betta * Math.pow(A, 2) + alpha * Math.pow(B, 2)) / (2 * (B - A));
        UnaryOperator<Double> function = x -> a * Math.pow(x, 2) + b * x + c;
        BinaryOperator<Double> qXandYFunction = (x, y) -> (x < y ? alpha * (y - x) : betta * (x - y));
        Map<Integer, Double> mapTheory = new HashMap<>();
        for (int x = A.intValue(); x <= B; x++) {
            Double yRes = 0.0;
            for (int y = A.intValue(); y <= B; y++) {
                yRes += qXandYFunction.apply(new Double(x), new Double(y));
            }
            mapTheory.put(x, yRes / (B.intValue() - A.intValue() + 1));
            series.getData().add(new XYChart.Data(x, yRes / (B.intValue() - A.intValue() + 1)));
        }
        Double xMin = mapTheory.values().stream().sorted().findFirst().get();
        series.setName(format(formula, a, getSign(b), abs(b), c));
        graphic.getData().add(series);
        xLabel.setText("Теор.: x* = " + df.format(xMin) + " Q(x*) = " + df.format(function.apply(xMin)));

        Map<Integer, Double> map = new HashMap<>();
        Map<Integer, Double> dispersia = new HashMap<>();

        for (int i = A.intValue(); i <= B; i++) {
            Double summ = 0.0;
            Double res = 0.0;
            for (int j = 1; j < n; j++) {
                Integer experimentY = random.nextInt(B.intValue() - A.intValue() + 1) + A.intValue();
                summ += qXandYFunction.apply(new Double(i), experimentY.doubleValue());
                res += abs(Math.pow(qXandYFunction.apply(new Double(i), experimentY.doubleValue())
                        - function.apply(new Double(i)), 2));
            }
            map.put(i, summ / n);
            dispersia.put(i, Math.sqrt(res / (n - 1)));
        }

        LineChart.Series series2 = new LineChart.Series();
        for (Map.Entry entry : map.entrySet()) {
            series2.getData().add(new LineChart.Data(entry.getKey(), entry.getValue()));
        }
        graphic.getData().add(series2);
        series2.setName("Экспериментальные значения");
        series2.getNode().setStyle("-fx-stroke: transparent;");
        graphic.setCreateSymbols(true);

        Double ExYMin = map.values().stream().sorted().findFirst().get();
        qLabel.setText("Экс-нт.: x* = " + df.format(xMin) + " Q(x*) = " + df.format(ExYMin));

        LineChart.Series series3 = new LineChart.Series();
        for (Map.Entry entry : dispersia.entrySet()) {
            series3.getData().add(new LineChart.Data(entry.getKey(), entry.getValue()));
        }
        graphic.getData().add(series3);
        series3.setName("Отклонение");
        series3.getNode().setStyle("-fx-stroke: transparent;");
        graphic.setCreateSymbols(true);
    }

    protected String getSign(Double b) {
        return b > 0 ? "+" : "-";
    }
}
