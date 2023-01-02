package hagenmcgowan.coursework.studentmanagementservice;

import hagenmcgowan.coursework.studentmanagementservice.Logic.Data.DataStudent;
import hagenmcgowan.coursework.studentmanagementservice.Logic.GUI.Algorithm;
import hagenmcgowan.coursework.studentmanagementservice.Logic.GUI.GUICoordinator;
import hagenmcgowan.coursework.studentmanagementservice.Logic.LogicCoordinator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import java.io.*;
import java.util.*;

public class HelloApplication extends Application {
    //Fields
    private LogicCoordinator logicCoordinator;
    private String choiceOfChart;
    //Constructor
    public HelloApplication() {
        //All the filenames absolute paths need to be changed when you run this on your computer Rob.
        String[] fileNames = {"C:\\Users\\Hagen Mcgowan\\Documents\\Programming_Workspaces\\Java\\StudentManagementService\\student_data\\Student_Data_Raw.csv",
                              "C:\\Users\\Hagen Mcgowan\\Documents\\Programming_Workspaces\\Java\\StudentManagementService\\student_data\\Student_Data_Improved.csv",
                              "C:\\Users\\Hagen Mcgowan\\Documents\\Programming_Workspaces\\Java\\StudentManagementService\\student_data\\Degrees.txt"};
        this.logicCoordinator = new LogicCoordinator(fileNames);
        this.choiceOfChart = "";
    }

    //Accessors and Mutators
    private LogicCoordinator getLogicCoordinator() {
        return logicCoordinator;
    }
    private String getChoiceOfChart() {return this.choiceOfChart;}
    private void setChoiceOfChart(String sChoiceOfChart) {this.choiceOfChart = sChoiceOfChart;}
    private LogicCoordinator logicGateway(){
        return getLogicCoordinator();
    }
    @Override
    public void start(Stage stage) throws IOException {
        LinkedHashMap<String, DataStudent> studentDataframe = logicGateway().dataGateway().miningGateway().trialRun();
        LinkedHashMap<String,Integer> genderDataResultsMap = logicGateway().plottingGateway().getGenderDataCollector().collector();
        LinkedHashMap<String, Integer> degreeDataResultsMap = logicGateway().plottingGateway().getDegreeDataCollector().collector();
        try {
            GUICoordinator guiCoordinator = new GUICoordinator();
            guiCoordinator.guiGateway().myGUI();

            Thread.sleep(60000);

            //Same Here
            Algorithm dataPersistAlgorithm = new Algorithm("C:\\Users\\Hagen Mcgowan\\Documents\\Programming_Workspaces\\Java\\StudentManagementService\\DataHolder.txt");
            String testDataPersistAlgorithm = dataPersistAlgorithm.deserialise();
            System.out.println(testDataPersistAlgorithm);
            setChoiceOfChart(testDataPersistAlgorithm);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        System.out.println("Your choice of chart: "+ getChoiceOfChart());
        if (Objects.equals(getChoiceOfChart(), "Gender")){
            List<String> genders = new ArrayList<>();
            List<Integer> frequency = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : genderDataResultsMap.entrySet()) {
                genders.add(entry.getKey());
                frequency.add(entry.getValue());
            }

            Scene scene = new Scene(new Group());
            stage.setTitle("Gender v Frequency");
            stage.setWidth(515);
            stage.setHeight(500);

            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new PieChart.Data(genders.get(0), frequency.get(0)),
                            new PieChart.Data(genders.get(1), frequency.get(1)),
                            new PieChart.Data(genders.get(2), frequency.get(2)),
                            new PieChart.Data(genders.get(3), frequency.get(3)),
                            new PieChart.Data(genders.get(4), frequency.get(4)),
                            new PieChart.Data(genders.get(5), frequency.get(5)),
                            new PieChart.Data(genders.get(6), frequency.get(6)),
                            new PieChart.Data(genders.get(7), frequency.get(7)));

            final PieChart chart = new PieChart(pieChartData);
            chart.setTitle("Gender v Frequency");

            ((Group) scene.getRoot()).getChildren().add(chart);
            stage.setScene(scene);
            stage.show();
        } else if (Objects.equals(getChoiceOfChart(), "Degree")) {
            List<String> degrees = new ArrayList<>();
            List<Integer> frequency = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : degreeDataResultsMap.entrySet()) {
                degrees.add(entry.getKey());
                frequency.add(entry.getValue());
            }

            stage.setTitle("Degree v Frequency");
            final NumberAxis xAxis = new NumberAxis();
            final CategoryAxis yAxis = new CategoryAxis();
            final BarChart<Number,String> bc = new BarChart<>(xAxis, yAxis);
            bc.setTitle("Degree v Frequency");
            xAxis.setLabel("Frequency");
            xAxis.setTickLabelRotation(90);

            yAxis.setLabel("Degree");

            XYChart.Series series = new XYChart.Series<>();
            series.getData().add(new XYChart.Data<>(frequency.get(0), degrees.get(0)));
            series.getData().add(new XYChart.Data<>(frequency.get(1), degrees.get(1)));
            series.getData().add(new XYChart.Data<>(frequency.get(2), degrees.get(2)));
            series.getData().add(new XYChart.Data<>(frequency.get(3), degrees.get(3)));
            series.getData().add(new XYChart.Data<>(frequency.get(4), degrees.get(4)));
            series.getData().add(new XYChart.Data<>(frequency.get(5), degrees.get(5)));
            series.getData().add(new XYChart.Data<>(frequency.get(6), degrees.get(6)));
            series.getData().add(new XYChart.Data<>(frequency.get(7), degrees.get(7)));
            series.getData().add(new XYChart.Data<>(frequency.get(8), degrees.get(8)));
            series.getData().add(new XYChart.Data<>(frequency.get(9), degrees.get(9)));
            series.getData().add(new XYChart.Data<>(frequency.get(10), degrees.get(10)));
            series.getData().add(new XYChart.Data<>(frequency.get(11), degrees.get(11)));
            series.getData().add(new XYChart.Data<>(frequency.get(12), degrees.get(12)));
            series.getData().add(new XYChart.Data<>(frequency.get(13), degrees.get(13)));
            series.getData().add(new XYChart.Data<>(frequency.get(14), degrees.get(14)));


            Scene scene  = new Scene(bc,800,600);
            bc.getData().addAll(series);
            stage.setScene(scene);
            stage.show();
        }
    }

    public static void main(String[] args){
        launch();
    }
}