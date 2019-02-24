package main.services;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Дискретный случай
 */
public class DiscretService extends BaseService {

    private Random random;
    private Integer counter = 1;

    public void setSeriesForGraphic(LineChart graphic, Integer n, Integer minX, Integer maxX) {
        Double step = 1.00 / new Double(n);
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < maxX - minX + 1; i++) {
            map.put(i, 0.0);
        }
        random = new Random();
        XYChart.Series series = new XYChart.Series();
        for (int j = 0; j < n; j++) {
            Integer experement = random.nextInt(maxX - minX + 1);
            for (int h = 0; h <= maxX - minX + 1; h++) {
                if (experement >= h && experement < h + 1) {
                    Double value = map.get(h);
                    map.put(h, value + step);
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            series.getData().add(new XYChart.Data((Integer) entry.getKey(),(Double) entry.getValue()));
        }
        series.setName("Эксперемент №" + counter.toString());
        counter++;
        graphic.getData().add(series);
    }

    public void setBaseLine(LineChart graphic, Integer minX, Integer maxX) {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data(0, 1.00 / (maxX - minX)));
        series.getData().add(new XYChart.Data(maxX, 1.00 / (maxX - minX)));
        series.setName("Теоретическое");
        graphic.getData().add(series);
    }
}
