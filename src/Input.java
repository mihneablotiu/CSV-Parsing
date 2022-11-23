import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class Input {
    private final ArrayList<InputFormat> inputList;

    public Input(ArrayList<InputFormat> inputList) {
        this.inputList = inputList;
    }

    public InputFormat earliestCheckInDate(final boolean earliestCheckinDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        this.inputList.sort((o1, o2) -> {
            try {
                Date firstDate = formatter.parse(o1.getLastCheckInDate());
                Date secondDate = formatter.parse(o2.getLastCheckInDate());
                return firstDate.compareTo(secondDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        if (earliestCheckinDate) {
            return this.inputList.get(0);
        } else {
            return this.inputList.get(this.inputList.size() - 1);
        }
    }
}
