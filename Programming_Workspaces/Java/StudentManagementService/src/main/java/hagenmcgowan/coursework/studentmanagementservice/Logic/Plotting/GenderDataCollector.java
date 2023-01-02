package hagenmcgowan.coursework.studentmanagementservice.Logic.Plotting;

import hagenmcgowan.coursework.studentmanagementservice.Logic.Data.DataStudent;

import java.util.LinkedHashMap;
import java.util.Map;


public class GenderDataCollector extends PlottingCore implements PlottingInterface<String, Integer>{

    public GenderDataCollector(String[] fileNames) {
        super(fileNames);
        //TODO Auto-generated constructor stub
    }



    @Override
    public LinkedHashMap<String, Integer> collector() {
        // TODO Auto-generated method stub
        LinkedHashMap<String, Integer> genderValues = new LinkedHashMap<>();
        String[] genders = {"Male", "Female", "Agender", "Bigender",
                "Genderfluid", "Genderqueer", "Non-binary", "Polygender"};
        for (String gender : genders) {
            genderValues.put(gender, 0);
        }

        LinkedHashMap<String, DataStudent> dataframe = getDataCoordinator().miningGateway().trialRun();
        for (Map.Entry<String, DataStudent> entry : dataframe.entrySet()) {
            String studentGender = entry.getValue().getGender();
            if (genderValues.containsKey(studentGender)) {
                int value = genderValues.get(studentGender);
                genderValues.put(studentGender, value+1);
            }
        }

        return genderValues;
    }

}