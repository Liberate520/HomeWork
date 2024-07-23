package service;

import model.WOD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WODService implements IWODService {
    private final Map<String, WOD> wods = new HashMap<>();

    @Override
    public void addWOD(WOD wod) {
        wods.put(wod.getId(), wod);
    }

    @Override
    public WOD getWODById(String id) {
        return wods.get(id);
    }

    @Override
    public List<WOD> getAllWODs() {
        return new ArrayList<>(wods.values());
    }
}
