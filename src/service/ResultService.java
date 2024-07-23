package service;

import model.Result;
import model.User;
import model.WOD;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultService implements IResultService {
    private List<Result> results;

    public ResultService() {
        this.results = new ArrayList<>();
    }

    @Override
    public void addResult(Result result) {
        results.add(result);
    }

    @Override
    public List<Result> getResultsByWOD(WOD wod) {
        // Реализация получения результатов по WOD
        return results.stream()
                .filter(result -> result.getWod().equals(wod))
                .collect(Collectors.toList());
    }

    @Override
    public List<Result> getResultsByAthlete(User athlete) {
        // Реализация получения результатов по атлету
        return results.stream()
                .filter(result -> result.getAthlete().equals(athlete))
                .collect(Collectors.toList());
    }

    @Override
    public int calculateTotalScore(User athlete) {
        List<Result> athleteResults = getResultsByAthlete(athlete);
        return athleteResults.stream().mapToInt(result -> {
            if ("Minimal Time".equals(result.getScoringMethod())) {
                return calculateScoreForTime(result.getTime());
            } else if ("Max Reps".equals(result.getScoringMethod())) {
                return result.getRepetitions();
            } else {
                return 0;
            }
        }).sum();
    }

    private int calculateScoreForTime(String time) {
        // Преобразование времени в баллы (например, минуты и секунды в секунды)
        String[] timeParts = time.split(":");
        int minutes = Integer.parseInt(timeParts[0]);
        int seconds = Integer.parseInt(timeParts[1]);
        return minutes * 60 + seconds;
    }
}
