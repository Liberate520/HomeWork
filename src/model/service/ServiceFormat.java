package model.service;

import model.format.FormatUtils;

import java.io.Serializable;
import java.time.LocalDate;

public class ServiceFormat implements Serializable {
    private final FormatUtils formatUtils;

    public ServiceFormat() {
        this.formatUtils = new FormatUtils();
    }

    public String getDatePointFormat(LocalDate date){
        return formatUtils.getDatePointFormat(date);
    }

    public String getYearDeclension(int age){
        return formatUtils.getYearDeclension(age);
    }
}
