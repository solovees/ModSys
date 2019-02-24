package main.services;

/**
 * Базовый сервис
 */
public abstract class BaseService {

    protected double countStep(double xMin, double xMax) {
        return (xMax - xMin) / 100;
    }

    protected String getSign(Integer b) {
        return b > 0 ? "+" : "";
    }
}
