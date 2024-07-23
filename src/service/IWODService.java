package service;

import model.WOD;

import java.util.List;

public interface IWODService {
    void addWOD(WOD wod);
    WOD getWODById(String id);
    List<WOD> getAllWODs();
}
