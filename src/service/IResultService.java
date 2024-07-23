package service;

import model.Result;
import model.User;
import model.WOD;

import java.util.List;

public interface IResultService {
    void addResult(Result result);

    List<Result> getResultsByWOD(WOD wod);

    List<Result> getResultsByAthlete(User athlete);

    int calculateTotalScore(User athlete); // Добавляем метод для вычисления общего балла
}
