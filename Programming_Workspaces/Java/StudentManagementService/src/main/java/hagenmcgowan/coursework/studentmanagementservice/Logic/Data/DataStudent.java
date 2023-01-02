package hagenmcgowan.coursework.studentmanagementservice.Logic.Data;

import java.util.Arrays;

public class DataStudent {
    private int studentID;
    private String fullName;
    private String gender;
    private double[] testResults;
    private int attendance;
    private String degree;
    private String[] examDates;

    public DataStudent(int pStudentID, String pFullName, String pGender,
                       double[] pTestResults, int pAttendance, String pDegree,
                       String[] pExamDates){
        this.studentID = pStudentID;
        this.fullName = pFullName;
        this.gender = pGender;
        this.testResults = pTestResults;
        this.attendance = pAttendance;
        this.degree = pDegree;
        this.examDates  = pExamDates;
    }

    public DataStudent(String pFullName, String pGender, double[] pTestResults,
                       int pAttendance, String pDegree, String[] pExamDates){
        this.fullName = pFullName;
        this.gender = pGender;
        this.testResults = pTestResults;
        this.attendance = pAttendance;
        this.degree = pDegree;
        this.examDates  = pExamDates;
    }

    //Accessors and Mutators
    public int getStudentID() {
        return studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public double[] getTestResults() {
        return testResults;
    }

    public int getAttendance() { return attendance; }

    public String getDegree() {
        return degree;
    }

    public String[] getExamDates() {
        return examDates;
    };

    //Methods

    public String[] toStringArrayForCSV()
    {
        //int neededLength = testResults.length + 7;
        String[] representation = new String[7];
        representation[0] = Integer.toString(this.studentID);
        representation[1] = this.getFullName();
        representation[2] = this.getGender();
        representation[3] = Arrays.toString(this.getTestResults());
        representation[4] = Integer.toString(this.getAttendance());
        representation[5] = this.getDegree();
        representation[6] = Arrays.toString(this.getExamDates());

        return representation;
    }

    public String[] toStringArrayForDataframe()
    {
        //int neededLength = testResults.length + 7;
        String[] representation = new String[6];
        representation[0] = Integer.toString(this.studentID);
        representation[1] = this.getGender();
        representation[2] = Arrays.toString(this.getTestResults());
        representation[3] = Integer.toString(this.getAttendance());
        representation[4] = this.getDegree();
        representation[5] = Arrays.toString(this.getExamDates());

        return representation;
    }
}
