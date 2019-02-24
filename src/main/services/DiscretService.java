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

    @Override
    public void setSeriesForGraphic(XYChart graphic, Integer n, Integer minX, Integer maxX) {
        Double step = 1.00 / new Double(n);
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < maxX - minX; i++) {
            map.put(i, 0.0);
        }
        random = new Random();
        XYChart.Series series = new XYChart.Series();
        for (int j = 0; j < n; j++) {
            Integer experement = random.nextInt(maxX - minX + 1);
            for (int h = 1; h <= maxX - minX; h++) {
                if (experement >= h-1 && experement < h) {
                    Double value = map.get(h-1);
                    map.put(h-1, value + step);
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            series.getData().add(new XYChart.Data((Integer) entry.getKey() + minX, (Double) entry.getValue()));
        }
        series.setName("Эксперимент №" + counter.toString());
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
