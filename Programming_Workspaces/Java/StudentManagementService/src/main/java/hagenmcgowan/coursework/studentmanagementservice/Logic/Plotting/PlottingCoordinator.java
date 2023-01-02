package hagenmcgowan.coursework.studentmanagementservice.Logic.Plotting;

public class PlottingCoordinator {
    //Fields
    GenderDataCollector genderDataCollector;
    DegreeDataCollector degreeDataCollector;

    //Constructor
    public PlottingCoordinator(String[] filenames) {
        this.genderDataCollector = new GenderDataCollector(filenames);
        this.degreeDataCollector = new DegreeDataCollector(filenames);
    }
    //Accessors and Mutators
    public GenderDataCollector getGenderDataCollector() {
        return genderDataCollector;
    }
    public DegreeDataCollector getDegreeDataCollector() {
        return degreeDataCollector;
    }
}
