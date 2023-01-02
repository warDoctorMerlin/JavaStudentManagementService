package hagenmcgowan.coursework.studentmanagementservice.Logic.Data;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataMining extends DataCore<DataStudent> {

    public DataMining(String[] filenames){
        super(filenames);

    }

    public LinkedHashMap<String, DataStudent> trialRun(){
        List<DataStudent> dataStudents = dataExtractor();
        writeCSV(dataStudents);
        return getStudentDataframe();
    }
    /*
     * This method deals with the extraction of the data from the csv file to an
     * appropriate storage collection which will be a LinkedHashMap of types String
     * and an array of type T. T is a generic which will be linked to the class
     * DataStudent.
     * */
    private List<DataStudent> dataExtractor(){
        /*
         * This section reads in the Mock_Data csv file and converts it into a DataFrame
         * for the purpose of shaping the data to what I want it to be. Then it creates a
         * for loop and sets it to the length of the dataframe so that the method will
         * change every row in the dataframe.
         * */
        List<DataStudent> studentDataframe = new ArrayList<>();
        List<String[]> students = readCSV();
        String[] headers = students.get(0);
        students.remove(0);
        System.out.println(Arrays.toString(headers));
        for (String[] line : students) {
            //We are not going to use the id category. This column is made redundant by the index positions of the
            //ArrayList that will hold this data

            //Student number
            int studentNumber = Integer.parseInt(line[1]);

            //Full name
            String fullName = line[2];

            //Gender
            String gender = line[3];

            //Test Results
            /*
             * This section deals with the test_result column, converting a string of values
             * into a list of floats, each one a result from six modules taken over four
             * years.
             * */
            String testScores = line[4];
            testScores = testScores.substring(0, testScores.length() - 1);
            String[] testStrings = testScores.split(",");
            double[] testResults = new double[testStrings.length];
            for (int i = 0; i < testStrings.length; i++) {
                double number = Double.parseDouble(testStrings[i]);
                testResults[i] = number;
            }

            //Attendance
            /*
             * This section is designed to deal with the attendence by creating a number
             * between 1 and 99 so that there are no zeroes in the data as it is unlikely
             * for a student to get this.
             * */
            int attendance = createRandomIntBetween(1, 99);

            //Degrees
            /*
             * This section deals with the degree the student is currently taking. Right now,
             * the values in this section are blank however, with the use of files and random
             * numbers, this will soon be populated.
             * */
            String[] degrees = textReader().split("\n");
            int randomNumber = (int) Math.round(Math.random() * (degrees.length - 1 - 0));
            String degree = degrees[randomNumber];

            //Exam Dates
            /*
             * This section deals with filling it with a list of exam dates
             * generated from the static method exam_dates_generator(). I made this method static
             * because it does not use any of the fields within the class. The None keyword acts
             * as a temporary placeholder for the future exam_dates list
             * */
            String[] exam_dates = new String[24];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
            for (int i = 0; i < 24; i++) {
                LocalDate randomDate = createRandomDate(2091, 9013);
                String dateString = formatter.format(randomDate);
                exam_dates[i] = dateString;
            }

            /*
             * This final section deals with sending the dataframe back into a csv file ready
             * for the subclasses to utilise whether to add a student, change the value or
             * delete a student from the records.
             * */
            studentDataframe.add(new DataStudent(studentNumber, fullName, gender, testResults, attendance, degree, exam_dates));
            getStudentDataframe().put(String.valueOf(studentNumber), new DataStudent(fullName, gender, testResults, attendance, degree, exam_dates));

        }
        return studentDataframe;
    }

    /*
     * This section of the core allows for the user of the system to add, update or delete a
     * student to the dataframe using the details of said student in a dictionary passed to
     * the protected method along with a choice of which option the user would like to do
     * */

    /*
     * This section of the code deals with the reading and writing of the csv file. Since no
     * later classes will require these methods, I can make them private so to make them into
     * helper methods, designed to support the data extractor method.
     * */

    private List<String[]> readCSV(){
        List<String[]> csvOutput;
        try {
            FileReader fileReader = new FileReader(getInputFileName());
            CSVReader csvReader = new CSVReader(fileReader);
            csvOutput = csvReader.readAll();
            csvReader.close();
        } catch (CsvException | IOException e) {
            throw new RuntimeException(e);
        }
        return csvOutput;
    }
    private void writeCSV(List<DataStudent> dataframe){
        File file = new File(getOutputFileName());

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // create a List which contains String

            List<String[]> data = new ArrayList<String[]>();

            //Ask Rob about how to convert between a custom datatype and an
            //in-built one. Maybe he can help.

            for (DataStudent studentDetails:dataframe) {
                data.add(studentDetails.toStringArrayForCSV());
            }

            writer.writeAll(data);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String textReader() {
        try {

            FileInputStream inputFile = new FileInputStream(getDegreeFileName());
            int i = 0;
            String textOutput = "";
            while((i = inputFile.read()) != -1) {
                textOutput += (char)i;
            }
            inputFile.close();
            return textOutput;
        } catch (IOException e) {
            return "There has been an IO exception!";
        }
    }
    private static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
}