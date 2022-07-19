public class JulianDate {

    private int month;
    private int year;
    private int dayOfMonth;

    JulianDate(int year, int month, int dayOfMonth) {
        this.month = month;
        this.year = year;
        this.dayOfMonth = dayOfMonth;
    }

    JulianDate() {
        this(1, 1, 1);
        addDays(719164);
        double timeSince1970 = System.currentTimeMillis();
        double offsetTimeZone = java.util.TimeZone.getDefault().getRawOffset();
        double timeInSeconds = timeSince1970 + offsetTimeZone;
        int timeInDays = (int)(timeInSeconds/(3600 * 24 * 1000));
        addDays(timeInDays);
    }

    private boolean isLeapYear(int year) {
        if ((year % 4 == 0)) {
            return true;
        }
        return false;
    }

    public boolean isLeapYear() {
        boolean yearIdentity = isLeapYear(year);
        return yearIdentity;
    }

    public void printShortDate() {
        System.out.printf("%d/%d/%d", month, dayOfMonth, year);
    }

    public String getMonthName() {
        switch (month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
        }
        return "Not in the list of months";
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    private int getNumberOfDaysInMonth (int year, int month) {
        switch(month) {
            case 1, 3, 5, 7, 8, 10, 12: return 31;
            case 2: if (isLeapYear(year)) {
                return 29;
            } return 28;
            default: return 30;
        }
    }

    private int getNumberOfDaysInYear (int year) {
        if (isLeapYear(year)) {
            return 366;
        }
        return 365;
    }

    public void printLongDate() {
        System.out.printf("%s %d, %d", getMonthName(), dayOfMonth, year);
    }

    public void addDays(int days) {
        for (int day = 0; day < days; day ++) {
            dayOfMonth++;
            if (dayOfMonth > getNumberOfDaysInMonth(year, month)) {
                month ++;
                if (month > 12) {
                    year ++;
                    month = 1;
                }
                dayOfMonth = 1;
            }
        }
    }

    public void subtractDays(int days) {
        for (int day = 0; day < days; day ++) {
            dayOfMonth--;
            if (dayOfMonth < 1) {
                month --;
                if (month < 1) {
                    year--;
                    month = 12;
                }
                dayOfMonth = getNumberOfDaysInMonth(year, month);
            }
        }
    }
    
}
