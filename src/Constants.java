/**
 * The constants class used for each field in the CSV file
 */
public class Constants {
    public static final Integer FIRST_NAME = 0;
    public static final Integer LAST_NAME = 1;
    public static final Integer STREET = 2;
    public static final Integer ZIP = 3;
    public static final Integer CITY = 4;
    public static final Integer TYPE = 5;
    public static final Integer LAST_CHECK_IN_DATE = 6;
    public static final Integer JOB = 7;
    public static final Integer PHONE = 8;
    public static final Integer COMPANY = 9;
}

/**
 * The string constants equivalent to the constants above
 */
enum StringConstants {
    FIRST_NAME, LAST_NAME, STREET, ZIP, CITY, TYPE,
    LAST_CHECK_IN_DATE, JOB, PHONE, COMPANY
}
