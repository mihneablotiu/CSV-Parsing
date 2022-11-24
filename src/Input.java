import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Input {
    private final ArrayList<InputFormat> inputList;

    /**
     * The constructor of the array of inputs
     * @param inputList the array of InputFormat elements
     */
    public Input(ArrayList<InputFormat> inputList) {
        this.inputList = inputList;
    }

    /**
     * The function that checks that the format of the date is correct for each input is correct
     * and then creates a list with just the correct format dates, sorts the dates in ascending order
     * and returns the earliest check in date if the boolean parameter is true or the latest check in
     * date if the boolean parameter is false
     * @param earliestCheckinDate the boolean parameter depending on which we choose what to return
     * @return the customer with the earliest check in date or the latest check in date
     */
    public final InputFormat earliestCheckInDate(final boolean earliestCheckinDate) {
        ArrayList<InputFormat> newMatchedDates = new ArrayList<>();

        for (int i = 0; i < this.inputList.size(); i++) {
            if (this.inputList.get(i).getLastCheckInDate().matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")
                    || this.inputList.get(i).getLastCheckInDate().matches("\\d/\\d\\d/\\d\\d\\d\\d")
                    || this.inputList.get(i).getLastCheckInDate().matches("\\d\\d/\\d/\\d\\d\\d\\d")
                    || this.inputList.get(i).getLastCheckInDate().matches("\\d/\\d/\\d\\d\\d\\d")) {
                newMatchedDates.add(this.inputList.get(i));
            } else {
                System.out.println("The row: " + i + " does not contain the date in the expected format so we cannot" +
                        " take it into consideration for the sort");
            }
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        newMatchedDates.sort((o1, o2) -> {
            try {
                Date firstDate = formatter.parse(o1.getLastCheckInDate());
                Date secondDate = formatter.parse(o2.getLastCheckInDate());
                return firstDate.compareTo(secondDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        if (earliestCheckinDate) {
            return newMatchedDates.get(0);
        } else {
            return newMatchedDates.get(newMatchedDates.size() - 1);
        }
    }

    /**
     * The function that adds all the customers that have both first name and last name completed
     * in a new list and sorts the list alphabetically. It also takes care if the names contain
     * diacritics. If they do, they are normalized before sorted.
     * @return The list sorted by the customer's full name alphabetically
     */
    public final ArrayList<InputFormat> getCustomersListSortedByFullName() {
        ArrayList<InputFormat> sortedList = new ArrayList<>();

        for (int i = 0; i < this.inputList.size(); i++) {
            if (!this.inputList.get(i).getLastName().equals("null")
                    && !this.inputList.get(i).getFirstName().equals("null")) {
                sortedList.add(this.inputList.get(i));
            } else {
                System.out.println("The row: " + i + " does not contain the first name or the second name so we cannot take it into consideration for the sort");
            }
        }
        sortedList.sort((o1, o2) -> {
            if (Normalizer.normalize(o1.getFirstName(), Normalizer.Form.NFD)
                    .compareToIgnoreCase(Normalizer.normalize(o2.getFirstName(), Normalizer.Form.NFD)) < 0) {
                return -1;
            } else if (Normalizer.normalize(o1.getFirstName(), Normalizer.Form.NFD)
                    .compareToIgnoreCase(Normalizer.normalize(o2.getFirstName(), Normalizer.Form.NFD)) > 0) {
                return 1;
            } else {
                return Normalizer.normalize(o1.getLastName(), Normalizer.Form.NFD)
                        .compareToIgnoreCase(Normalizer.normalize(o2.getLastName(), Normalizer.Form.NFD));
            }
        });

        return sortedList;
    }

    /**
     * The function that adds all the customers that have their job completed in the file
     * in a new list and sorts the list alphabetically by their job's name. It also takes care
     * if the names of the jobs contain diacritics. If they do, they are normalized before sorted.
     * @return The list sorted by the customer's job name alphabetically
     */
    public final ArrayList<InputFormat> getCustomersListSortedByJob() {
        ArrayList<InputFormat> sortedList = new ArrayList<>();

        for (int i = 0; i < this.inputList.size(); i++) {
            if (!this.inputList.get(i).getJob().equals("null")) {
                sortedList.add(this.inputList.get(i));
            } else {
                System.out.println("The row: " + i + " does not contain the job name so we cannot take it into consideration for the sort");
            }
        }

        sortedList.sort((o1, o2) -> Normalizer.normalize(o1.getJob(), Normalizer.Form.NFD)
                .compareToIgnoreCase(Normalizer.normalize(o2.getJob(), Normalizer.Form.NFD)));

        return sortedList;
    }

    /**
     * The function for visualizing a list of InputFormats
     */
    public final void visualizeList() {
        for (InputFormat currentInput : this.inputList) {
            System.out.println(currentInput);
        }
    }
}
