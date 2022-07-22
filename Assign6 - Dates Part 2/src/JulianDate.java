public class JulianDate extends Date{
    JulianDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    JulianDate() {
        super(1, 1, 1);
        addDays(719164);
        double timeSince1970 = System.currentTimeMillis();
        double offsetTimeZone = java.util.TimeZone.getDefault().getRawOffset();
        double timeInSeconds = timeSince1970 + offsetTimeZone;
        int timeInDays = (int)(timeInSeconds/(3600 * 24 * 1000));
        addDays(timeInDays);
    }

    @Override
    public boolean isLeapYear(int year) {
        if ((year % 4 == 0)) {
            return true;
        }
        return false;
    }
}