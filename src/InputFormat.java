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

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getType() {
        return type;
    }

    public String getJob() {
        return job;
    }

    public String getLastCheckInDate() {
        return lastCheckInDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getCompany() {
        return company;
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
