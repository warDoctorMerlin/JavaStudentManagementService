package hagenmcgowan.coursework.studentmanagementservice.Logic;

import hagenmcgowan.coursework.studentmanagementservice.Logic.Data.DataCoordinator;
import hagenmcgowan.coursework.studentmanagementservice.Logic.Plotting.PlottingCoordinator;

public final class LogicCoordinator {
    //Fields
    private final DataCoordinator dataCoordinator;
    private final PlottingCoordinator plottingCoordinator;

    //Constructor
    public LogicCoordinator(String[] filenames) {
        this.dataCoordinator = new DataCoordinator(filenames);
        this.plottingCoordinator = new PlottingCoordinator(filenames);
    }

    private DataCoordinator getDataCoordinator() {
        return dataCoordinator;
    }

    private PlottingCoordinator getPlottingCoordinator() {
        return plottingCoordinator;
    }

    public DataCoordinator dataGateway() {
        return getDataCoordinator();
    }

    public PlottingCoordinator plottingGateway() {
        return getPlottingCoordinator();
    }
}

