import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Input {
    private final ArrayList<InputFormat> inputList;

    public Input(ArrayList<InputFormat> inputList) {
        this.inputList = inputList;
    }

    public final InputFormat earliestCheckInDate(final boolean earliestCheckinDate) {
        ArrayList<InputFormat> newMatchedDates = new ArrayList<>();

        for (int i = 0; i < this.inputList.size(); i++) {
            if (this.inputList.get(i).getLastCheckInDate().matches("\\d\\d/\\d\\d/\\d\\d\\d\\d") || this.inputList.get(i).getLastCheckInDate().matches("\\d/\\d\\d/\\d\\d\\d\\d")
                    || this.inputList.get(i).getLastCheckInDate().matches("\\d\\d/\\d/\\d\\d\\d\\d") || this.inputList.get(i).getLastCheckInDate().matches("\\d/\\d/\\d\\d\\d\\d")) {
                newMatchedDates.add(this.inputList.get(i));
            } else {
                System.out.println("The row: " + i + " does not contain the date in the expected format so we cannot take it into consideration for the sort");
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

    public final ArrayList<InputFormat> getCustomersListSortedByFullName() {
        ArrayList<InputFormat> sortedList = new ArrayList<>();

        for (InputFormat currentInput : this.inputList) {
            if (!currentInput.getLastName().equals("null") && !currentInput.getFirstName().equals("null")) {
                sortedList.add(currentInput);
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

    public final ArrayList<InputFormat> getCustomersListSortedByJob() {
        ArrayList<InputFormat> sortedList = new ArrayList<>();

        for (InputFormat currentInput : this.inputList) {
            if (!currentInput.getJob().equals("null")) {
                sortedList.add(currentInput);
            }
        }

        sortedList.sort((o1, o2) -> Normalizer.normalize(o1.getJob(), Normalizer.Form.NFD)
                .compareToIgnoreCase(Normalizer.normalize(o2.getJob(), Normalizer.Form.NFD)));

        return sortedList;
    }

    public final void visualizeList() {
        for (InputFormat currentInput : this.inputList) {
            System.out.println(currentInput);
        }
    }
}
