public class InputFormat {
    private final String firstName;
    private final String lastName;
    private final String street;
    private final String zip;
    private final String city;
    private final String type;

    private final String lastCheckInDate;
    private final String job;
    private final String phone;
    private final String company;

    /**
     * The constructor for an InputFormat element
     * @param firstName the first name of the customer
     * @param lastName the second name of the customer
     * @param street the street of the customer
     * @param zip the zip code of the street
     * @param city the city of the customer
     * @param type the type of the customer
     * @param lastCheckInDate the check in date of the customer
     * @param job the job of the customer
     * @param phone the phone of the customer
     * @param company the company where the customer works
     */
    public InputFormat(final String firstName, final String lastName, final String street, final String zip, final String city,
                       final String type, final String lastCheckInDate, final String job, final String phone, final String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.type = type;
        this.lastCheckInDate = lastCheckInDate;
        this.job = job;
        this.phone = phone;
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJob() {
        return job;
    }

    public String getLastCheckInDate() {
        return lastCheckInDate;
    }

    /**
     * Overriding the toString() method in order to be able to present a
     * InputFormat element to stdOut
     * @return the formatted string ready to be presented to stdOut
     */
    @Override
    public String toString() {
        return "Customer {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", type='" + type + '\'' +
                ", job='" + job + '\'' +
                ", lastCheckInDate='" + lastCheckInDate + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
