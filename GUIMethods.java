import javax.swing.*;
import java.awt.*;

public class GUIMethods {
    public void about (JFrame aboutFrame){
        aboutFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        aboutFrame.setBounds(550,50, 400, 550);

        Container aboutContainer = aboutFrame.getContentPane();
        aboutContainer.setLayout(null);

        Font titleFont = new Font("Arial",Font.PLAIN, 30);

        JLabel aboutTitle = new JLabel("About");
        aboutTitle.setOpaque(true);
        aboutTitle.setBounds(150, 40, 500, 30);
        aboutTitle.setFont(titleFont);

        //buttons in the about page
        JButton whySRASButton = new JButton("Why SRAS?");
        whySRASButton.setBounds(100, 100, 200, 70);

        JButton ourGoalsButton = new JButton("Our Goals");
        ourGoalsButton.setBounds(100, 200, 200, 70);

        JButton dataUsageButton = new JButton("Data Usage");
        dataUsageButton.setBounds(100, 300, 200, 70);

        JButton foundersAndCurrentTeamButton = new JButton("Founders and Current Team");
        foundersAndCurrentTeamButton.setBounds(100, 400, 200, 70);

        //adding everything to the container
        aboutContainer.add(aboutTitle);
        aboutContainer.add(whySRASButton);
        aboutContainer.add(ourGoalsButton);
        aboutContainer.add(dataUsageButton);
        aboutContainer.add(foundersAndCurrentTeamButton);

        aboutFrame.setVisible(true);
    }

    public void additionalResources(JFrame addResourcesFrame){
        addResourcesFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addResourcesFrame.setBounds(550,50, 400, 500);

        Container addResourcesContainer = addResourcesFrame.getContentPane();
        addResourcesContainer.setLayout(null);

        Font titleFont = new Font("Arial",Font.PLAIN, 30);

        JLabel ARTitle = new JLabel("Additional Resources");
        ARTitle.setOpaque(true);
        ARTitle.setBounds(60, 40, 500, 30);
        ARTitle.setFont(titleFont);

        //buttons in the additional resources page
        JButton onCampusResourcesButton = new JButton("On Campus Resources");
        onCampusResourcesButton.setBounds(100, 150, 200, 70);

        JButton offCampusResourcesButton = new JButton("Off Campus Resources");
        offCampusResourcesButton.setBounds(100, 250, 200, 70);

        //adding everything to the container
        addResourcesContainer.add(ARTitle);
        addResourcesContainer.add(onCampusResourcesButton);
        addResourcesContainer.add(offCampusResourcesButton);

        addResourcesFrame.setVisible(true);
    }

    public void campusStats(JFrame campusStatsFrame){
        campusStatsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        campusStatsFrame.setBounds(400,50, 700, 725);

        Container campusStatsContainer = campusStatsFrame.getContentPane();
        campusStatsContainer.setLayout(null);

        campusStatsFrame.setVisible(true);
    }

    public void fileReport(JFrame fileReportFrame){
        fileReportFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fileReportFrame.setBounds(400,50, 700, 725);

        Container fileRepContainer = fileReportFrame.getContentPane();
        fileRepContainer.setLayout(null);

        fileReportFrame.setVisible(true);
    }

    public void accessReport(JFrame accessReportFrame){
        accessReportFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        accessReportFrame.setBounds(400, 50, 700, 725);

        Container accessRepContainer = accessReportFrame.getContentPane();
        accessRepContainer.setLayout(null);

        accessReportFrame.setVisible(true);
    }
}
