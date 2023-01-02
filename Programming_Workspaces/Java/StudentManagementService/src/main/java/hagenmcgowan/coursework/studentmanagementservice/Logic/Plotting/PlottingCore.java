package hagenmcgowan.coursework.studentmanagementservice.Logic.Plotting;

import hagenmcgowan.coursework.studentmanagementservice.Logic.Data.DataCoordinator;


public class PlottingCore {
    private DataCoordinator dataCoordinator;

    public PlottingCore(String[] fileNames) {
        this.dataCoordinator = new DataCoordinator(fileNames);
    }

    public DataCoordinator getDataCoordinator() {
        return dataCoordinator;
    }
}
