package hagenmcgowan.coursework.studentmanagementservice.Logic.Data;

/**
 * DataCoordinator
 *
 * Backus Naur Form
 */
public class DataCoordinator {
    //Fields
    private DataMining dataMining;

    //Constructor
    public DataCoordinator(String[] filenames) {

        this.dataMining = new DataMining(filenames);
    }

    //Accessors and Mutators
    private DataMining getDataMining() {
        return dataMining;
    }

    public DataMining miningGateway() {
        return getDataMining();
    }
}