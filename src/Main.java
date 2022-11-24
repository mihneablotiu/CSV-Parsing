import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            String file = "C:\\Users\\mblot\\Desktop\\CSV-Parsing\\src\\input.csv";
            ArrayList<InputFormat> parsedList = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(file));
            readAndSplitInput(reader, parsedList);
            reader.close();

            Input inputToBeInterpreted = new Input(parsedList);
            System.out.println("\nThe customer with the earliest check in date is: " + inputToBeInterpreted.earliestCheckInDate(true));
            System.out.println("\nThe customer with the latest check in date is: " + inputToBeInterpreted.earliestCheckInDate(false));

            System.out.println("\nThis is the list with the users full name ordered alphabetically");
            Input alphabeticalSortedList = new Input(inputToBeInterpreted.getCustomersListSortedByFullName());
            alphabeticalSortedList.visualizeList();

            System.out.println("\nThis is the list with the jobs of the users ordered alphabetically");
            Input jobsSortedList = new Input(inputToBeInterpreted.getCustomersListSortedByJob());
            jobsSortedList.visualizeList();
        } catch (IOException e) {
            System.out.println("Error at opening the input file");
            e.printStackTrace();
        }
    }

    private static void readAndSplitInput(BufferedReader reader, ArrayList<InputFormat> parsedList) throws IOException {
        String currentLine;
        int currentRow = 0;

        while ((currentLine = reader.readLine()) != null) {
            if (currentRow != 0) {
                boolean isInQuotes = false;
                int startPosition = 0;
                ArrayList<String> splitList = new ArrayList<>();

                for (int currentPosition = 0; currentPosition < currentLine.length(); currentPosition++) {
                    if (currentLine.charAt(currentPosition) == '\"') {
                        isInQuotes = !isInQuotes;
                    } else if (currentLine.charAt(currentPosition) == ',' && !isInQuotes) {
                        splitList.add(currentLine.substring(startPosition, currentPosition));
                        startPosition = currentPosition + 1;
                    }
                }

                String lastToken = currentLine.substring(startPosition);
                if (lastToken.equals(",")) {
                    splitList.add("");
                } else {
                    splitList.add(lastToken);
                }

                constructParsedList(splitList, parsedList, currentRow);
            }

            currentRow++;
        }
    }

    private static void constructParsedList(ArrayList<String> splitList, ArrayList<InputFormat> parsedList, Integer currentRow) {
        if (splitList.get(Constants.STREET).equals("") || splitList.get(Constants.ZIP).equals("") || splitList.get(Constants.LAST_CHECK_IN_DATE).equals("")
                || splitList.get(Constants.COMPANY).equals("")) {
            System.out.println("The row: " + currentRow + " does not contain the necessary information so we cannot take it into consideration but we go forward with the file");
            return;
        }

        ArrayList<String> currentInput = new ArrayList<>();

        for (int currentField = 0; currentField < splitList.size(); currentField++) {
            if (!splitList.get(currentField).equals("")) {
                currentInput.add(splitList.get(currentField));
            } else {
                System.out.println("The following part: " +  StringConstants.values()[currentField] + " is missing from current row: "
                                   + currentRow + " but it is not a critical information so we can go forward ");
                currentInput.add("null");
            }
        }

        InputFormat newInput = new InputFormat(currentInput.get(Constants.FIRST_NAME), currentInput.get(Constants.LAST_NAME), currentInput.get(Constants.STREET),
                                               currentInput.get(Constants.ZIP), currentInput.get(Constants.CITY), currentInput.get(Constants.TYPE),
                                               currentInput.get(Constants.LAST_CHECK_IN_DATE), currentInput.get(Constants.JOB), currentInput.get(Constants.PHONE),
                                               currentInput.get(Constants.COMPANY));

        parsedList.add(newInput);
    }
}