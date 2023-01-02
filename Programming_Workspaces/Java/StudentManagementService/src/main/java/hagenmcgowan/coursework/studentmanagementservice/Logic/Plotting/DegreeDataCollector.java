package hagenmcgowan.coursework.studentmanagementservice.Logic.Plotting;

import hagenmcgowan.coursework.studentmanagementservice.Logic.Data.DataStudent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DegreeDataCollector extends PlottingCore implements PlottingInterface<String, Integer> {

    public DegreeDataCollector(String[] fileNames) {
        super(fileNames);
        //TODO Auto-generated constructor stub
    }

    private List<String> degreeFileReader() {
        List<String> fileOutput = new ArrayList<>();

        try {
            File fileName = new File("C:\\Users\\Hagen Mcgowan\\Documents\\Programming_Workspaces\\Java\\StudentManagementService\\student_data\\Degrees.txt");
            FileInputStream inputFile = new FileInputStream(fileName);
            int i = 0;
            String textOutput = "";
            while((i = inputFile.read()) != -1) {
                textOutput += (char)i;
            }
            inputFile.close();

            String[] strings = textOutput.split("\n");
            for (String string : strings) {
                fileOutput.add(string);
            }
            return fileOutput;

        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public LinkedHashMap<String, Integer> collector() {
        // TODO Auto-generated method stub
        LinkedHashMap<String, Integer> degreeValues = new LinkedHashMap<>();

        //Gather all the possible degrees
        List<String> possibleDegrees = degreeFileReader();

        //Build the dictionary
        for (String degree : possibleDegrees) {
            degreeValues.put(degree, 0);
        }

        LinkedHashMap<String, DataStudent> dataframe = getDataCoordinator().miningGateway().trialRun();
        for (Map.Entry<String, DataStudent> entry : dataframe.entrySet()) {
            String studentDegree = entry.getValue().getDegree();
            if (degreeValues.containsKey(studentDegree)) {
                int value = degreeValues.get(studentDegree);
                degreeValues.put(studentDegree, value+1);
            }
        }

        return degreeValues;
    }

}
