package presenter;

import file.BackupAndRead;
import model.Calendar;
import model.CalendarEntry;
import ui.Console;
import java.time.LocalDate;

public class Presenter {

    private Calendar calendarList;
    private Console console;
    private BackupAndRead backupAndRead;
    private CalendarEntry calendarEntry;

    public Presenter(BackupAndRead backupAndRead,Calendar calendarList) {

        this.backupAndRead = backupAndRead;
        this.calendarList = calendarList;
    }

    
    public Calendar getCalendar() {
        return calendarList;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;

    }

    public void printCalendaryEntry(Calendar calendar) {
        console.printCalendarEntry(calendar);
    }

    public void getDayRecords() {
        LocalDate dataDay = console.getData();
        console.printDataDay(dataDay);
    }

    public void saveCalendar() {
        backupAndRead.saveCalendar(calendarList);
    }

    public Calendar readCalendar() {
        calendarList = backupAndRead.read();
        return calendarList;
    }

    public void addRecord() {

        calendarList.addRecord(new CalendarEntry(console.getData(), console.getRecord()));

    }

}
