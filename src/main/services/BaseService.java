package main.services;

import javafx.scene.chart.XYChart;

/**
 * Базовый сервис
 */
public abstract class BaseService {

    public abstract void setSeriesForGraphic(XYChart graphic, Integer n, Integer minX, Integer maxX);
}
