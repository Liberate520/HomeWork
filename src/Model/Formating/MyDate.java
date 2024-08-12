package Model.Formating;

import java.io.Serializable;
import java.util.Objects;
import java.util.TreeMap;

public class MyDate implements Serializable {
    private static final TreeMap<Integer, Integer> dayInMonth =  new TreeMap<>();

    static {
        dayInMonth.put(1, 31);
        dayInMonth.put(2, 28);
        dayInMonth.put(3, 31);
        dayInMonth.put(4, 30);
        dayInMonth.put(5, 31);
        dayInMonth.put(6, 30);
        dayInMonth.put(7, 31);
        dayInMonth.put(8, 31);
        dayInMonth.put(9, 30);
        dayInMonth.put(10, 31);
        dayInMonth.put(11, 30);
        dayInMonth.put(12, 31);
    }

    private Integer year;
    private Integer month;
    private Integer day;

    public MyDate(int year, int month, int day){
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public Integer getDay() {
        return day;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    private void setDay(int day){
        if (0 < day && day < dayInMonth.get(this.month)) this.day = day;
    }

    private void setMonth(int month){
        if (0 < month && month < 13) this.month = month;
    }

    private void setYear(int year){
        if (year > 0) this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d.%02d", this.year, this.month, this.day);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        MyDate date = (MyDate) obj;

        return Objects.equals(this.year, date.year) && Objects.equals(this.month, date.month) && Objects.equals(this.day, date.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.year, this.month, this.day);
    }
}
