package main.services;

import javafx.scene.chart.XYChart;

/**
 * Базовый сервис
 */
public abstract class BaseService {


    public void clear(XYChart graphic){
        graphic.getData().clear();
    }
}
