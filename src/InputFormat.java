public class InputFormat {
    private final String firstName;
    private final String lastName;
    private final String street;
    private final String zip;
    private final String city;
    private final String type;
    private final String job;
    private final String lastCheckInDate;
    private final String phone;
    private final String company;

    public InputFormat(final String firstName, final String lastName, final String street, final String zip, final String city,
                       final String type, final String job, final String lastCheckInDate, final String phone, final String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.type = type;
        this.job = job;
        this.lastCheckInDate = lastCheckInDate;
        this.phone = phone;
        this.company = company;
    }

    @Override
    public String toString() {
        return "InputFormat{" +
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
