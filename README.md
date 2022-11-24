# Bloțiu Mihnea-Andrei - 24.11.2022
# CSV-Parsing

The main ideea of this project is to parse a CSV file containing the following fields in this
order: first name, last name, street, zip, city, type, last check in date, job, phone and
company and return on the screen some required information extracted from the file such as:
* The customer with the earliest check in date.
* The customer with the latest check in date.
* The full list of customers sorted alphabetically by their full name.
* The full list of customer sorted alphabetically by their jobs name.

That being said, the project is divided into 7 files:
* Main class representing the logic of the project;
* Constants class representing a list of constants for recognizing the CSV fields much easily;
* InputFormat class representing one input from the CSV file (aka one row);
* Input class represented by a list of InputFormat elements (aka the whole file parsed);
* Makefile - the file used to compile and run the project
* input.csv - one input test file
* README.md - the documentation of the project

# Main:

* In the main method we firstly read the input file from the keyboard, and then we parse the input file;
* To parse the input file we read it line by line and for each line apart from the first line we construct
a list of tokens dividing the row at when meeting a comma and being careful with that comma not to be inside
quotes (moment when we don't take it into consideration);
* With the list of string tokens we try to construct the list of InputFormats. First of all we have to
check if the required tokens really exist (Street, Zip, City and Last Check-in Date). If they don't exist
we cannot add that row to our list. If they exist, we can add the row to our list. We construct a InputFormat
for each of the rows. If other information than the required ones are missing we just add "null" to that
field, and we move to the next line;
* With the final list being done, we can now filter it and retrieve the desired information. We firstly
put to stdOut the customer with the first check in date, then the customer with the latest check in date
then the full list sorted alphabetically by customer's full name and then the full list sorted by the
customer's job alphabetically;

# Input
# earliestCheckInDate
* In order to determine the earliest/latest check in date for a customer we just construct a new list with
all the dates that respect one of the formats (dd/MM/yyyy or d/MM/yyyy or dd/M/yyyy or d/M/yyyy) and we
sort the whole list in ascending order of the dates;
* We use a boolean that if it is true then we will return the first position from the sorted list (aka the
customer with the earliest check in date) and if it is false we will return the last position from the
sorted list (aka the customer with the latest check in date);

# getCustomersListSortedByFullName
* In order to get a full list of customers sorted alphabetically by their full name we firstly construct
a new list with all the InputFormats that have both the first name and the last name set correctly (because
if they don't have name, we cannot compare them);
* With the new list, we sort it using as a first criteria the first name and as a second criteria the second
name (if two entries are equally positioned after the first name sort);
* To be mentioned here is the fact that the first name and second name are normalized before sorted because
we can have name having accents, and we don't want to be influenced by that;

# getCustomersListSortedByJob
* In order to get a full list of customers sorted alphabetically by their job's name we firstly construct
a new list with all the InputFormats that have job name set correctly (because if they don't have a job,
we cannot compare them);
* With the new list, we sort it using as a unique criteria the job's name;
* To be mentioned here is the fact that job name is normalized before sorted because we can have job names
having accents, and we don't want to be influenced by that;

# Makefile
* The build rule compiles the project (make)
* The run rule runs the project and waits for the input file name (make run)
* The clean rule cleans the project


* In order to run the project we just have to run the following commands in a Linux terminal, WSL or any
other similar example:
  * make
  * make run
  * give the name of the input file