package hagenmcgowan.coursework.studentmanagementservice.Logic.Data;

import java.util.LinkedHashMap;

public class DataCore<T> {
    /*
     * This is the base class that holds the fields, accessors, mutators and methods
     * that will be available to any subclass that inherits from this class.
     * */

    /*
     * All fields that are displayed below are marked private to prevent other classes
     * from having direct access to them.
     * */
    //Fields
    private String inputFileName = "";
    private String outputFileName = "";
    private String degreeFileName = "";
    private LinkedHashMap<String, T> studentDataframe;

    /*
     * @param: filenames
     * this is done in this way to both make the code more readable and to utilise the
     * concept of args.
     * */
    //Constructor
    public DataCore(String[] filenames){
        this.inputFileName = filenames[0];
        this.outputFileName = filenames[1];
        this.degreeFileName = filenames[2];
        this.studentDataframe = new LinkedHashMap<>();
    }

    /*
     * These are designed because they allow the programmer to utilise the fields,
     * either to access the value held inside or to change them when necessary,
     * safely, without going to them directly.
     * */
    //Accessors and Mutators

    public String getInputFileName() {
        return inputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public String getDegreeFileName() {
        return degreeFileName;
    }

    public LinkedHashMap<String, T> getStudentDataframe() {
        return studentDataframe;
    }

    /*
     *This section deals with the behaviour of the class, in other words, what the
     * class can do. Since this is the base class, these methods can be restricted
     * somewhat to protected access by the use of an access modifier, protected
     * */
}
