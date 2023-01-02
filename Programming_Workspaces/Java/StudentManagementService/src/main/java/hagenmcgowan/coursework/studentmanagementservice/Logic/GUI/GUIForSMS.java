package hagenmcgowan.coursework.studentmanagementservice.Logic.GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIForSMS extends GUICore implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JTextArea jTextArea;
    private String choiceOfChart;
    public GUIForSMS() {
        super();
        this.frame =  new JFrame();
        this.panel = new JPanel();
        this.button = new JButton("Calculate");
        this.label3 = new JLabel("Output: ");
        this.label4 = new JLabel("Gender or Degree: ");
        this.textField1 = new JTextField();
        this.jTextArea = new JTextArea();
        this.choiceOfChart = "";
    }

    public String getChoiceOfChart() {
        return choiceOfChart;
    }

    public void setChoiceOfChart(String choiceOfChart) {
        this.choiceOfChart = choiceOfChart;
    }
    public void myGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.setSize(350,250);

        button.addActionListener(this);

        frame.add(panel);

        panelComponents(panel);

        frame.setVisible(true);

    }

    private void panelComponents(JPanel jPanel) {
        jPanel.setLayout(null);

        // Amount
        this.label4.setBounds(10, 20, 120, 25);
        jPanel.add(this.label4);


        this.textField1.setBounds(120,20,165,25);
        jPanel.add(this.textField1);

        //Output Section
        this.label3.setBounds(10, 130, 120, 25);
        jPanel.add(this.label3);

        this.jTextArea.setBounds(120, 130, 180, 50);
        this.jTextArea.setLineWrap(true);
        jPanel.add(this.jTextArea);

        this.button.setBounds(10, 180, 100, 25);
        jPanel.add(this.button);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String inputTextField = this.textField1.getText();

        Algorithm dataPersistAlgorithm  = new Algorithm("DataHolder.txt");
        dataPersistAlgorithm.serialise(inputTextField);
        jTextArea.setText(inputTextField);
    }
}