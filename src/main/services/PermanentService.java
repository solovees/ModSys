package main.services;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Непрерывный случай
 */
public class PermanentService extends BaseService {

    private Random random;

    public void setSeriesForGraphic(XYChart graphic, Integer n, Integer minX, Integer maxX) {
        Double step = 1.00 / new Double(n);
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < maxX - minX; i++) {
            map.put(i, 0.0);
        }
        random = new Random();
        for (int j = 0; j < n; j++) {
            Integer experement = random.nextInt(maxX - minX);
            for (int h = 0; h < maxX - minX + 1; h++) {
                if (experement >= h && experement < h + 1) {
                    Double value = map.get(h);
                    map.put(h, value + step);
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            XYChart.Series series = new XYChart.Series();
            Double key = new Double(entry.getKey().toString());
            series.getData().add(new XYChart.Data(key + 0.1 + minX, 0));
            series.getData().add(new XYChart.Data(key + 0.1 + minX, (Double) entry.getValue()));
            series.getData().add(new XYChart.Data(key + 1 + minX, (Double) entry.getValue()));
            series.getData().add(new XYChart.Data(key + 1 + minX, 0));
            graphic.getData().add(series);
        }

    }

    public void setBaseLine(LineChart graphic, Integer minX, Integer maxX) {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data(0, 1.00 / (maxX - minX)));
        series.getData().add(new XYChart.Data(maxX, 1.00 / (maxX - minX)));
        series.setName("Теоретическое");
        graphic.getData().add(series);
    }
}
