public class GregorianDate extends Date{
    GregorianDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    GregorianDate() {
        super(1970, 1, 1);
        double timeSince1970 = System.currentTimeMillis();
        double offsetTimeZone = java.util.TimeZone.getDefault().getRawOffset();
        double timeInSeconds = timeSince1970 + offsetTimeZone;
        int timeInDays = (int)(timeInSeconds/(86400000));
        addDays(timeInDays);
    }

    @Override
    public boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 ==0) {
            return true;
        }
        return false;
    }
}

   