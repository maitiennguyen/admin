import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMethods {
    public void about (JFrame aboutFrame){
        aboutFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        aboutFrame.setBounds(500,50, 500, 650);

        Container aboutContainer = aboutFrame.getContentPane();
        aboutContainer.setLayout(null);

        Font titleFont = new Font("Arial",Font.PLAIN, 30);

        JLabel aboutTitle = new JLabel("About");
        aboutTitle.setOpaque(true);
        aboutTitle.setBounds(210, 30, 500, 30);
        aboutTitle.setFont(titleFont);

        //buttons in the about page
        JButton whySRASButton = new JButton("Why SRAS?");
        whySRASButton.setBounds(150, 90, 200, 70);

        JButton ourGoalsButton = new JButton("Our Goals");
        ourGoalsButton.setBounds(150, 190, 200, 70);

        JButton dataUsageButton = new JButton("Data Usage");
        dataUsageButton.setBounds(150, 290, 200, 70);

        JButton FAQButton = new JButton("FAQ");
        FAQButton.setBounds(150, 390,200, 70);

        JButton foundersAndCurrentTeamButton = new JButton("Founders and Current Team");
        foundersAndCurrentTeamButton.setBounds(150, 490, 200, 70);

        // Add button to return home
        JButton returnHomeButton = new JButton("Back");
        returnHomeButton.setBounds(1, 1, 75, 25);

        //adding everything to the container
        aboutContainer.add(aboutTitle);
        aboutContainer.add(whySRASButton);
        aboutContainer.add(ourGoalsButton);
        aboutContainer.add(dataUsageButton);
        aboutContainer.add(FAQButton);
        aboutContainer.add(foundersAndCurrentTeamButton);
        aboutContainer.add(returnHomeButton);

        returnHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new homeGUI();
                aboutFrame.dispose();
            }
        });

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

        // Add button to return home
        JButton returnHomeButton = new JButton("Back");
        returnHomeButton.setBounds(1, 1, 75, 25);

        //adding everything to the container
        addResourcesContainer.add(ARTitle);
        addResourcesContainer.add(onCampusResourcesButton);
        addResourcesContainer.add(offCampusResourcesButton);
        addResourcesContainer.add(returnHomeButton);

        returnHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new homeGUI();
                addResourcesFrame.dispose();
            }
        });

        onCampusResourcesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ARTitle.setText("On Campus Resources");
                ARTitle.setBounds(50, 40, 500, 30);
                addResourcesContainer.remove(onCampusResourcesButton);
                addResourcesContainer.remove(offCampusResourcesButton);
                addResourcesContainer.remove(returnHomeButton);
                addResourcesFrame.repaint();

                //buttons in the additional resources page
                JButton campusSafety = new JButton("Campus Safety");
                campusSafety.setBounds(100, 150, 200, 70);

                JButton titleIVOffice = new JButton("Title IV Office");
                titleIVOffice.setBounds(100, 250, 200, 70);

                JButton counselingCenter = new JButton("Counseling Center");
                counselingCenter.setBounds(100, 350, 200, 70);

                // Add button to return home
                JButton returnAddRe = new JButton("Back");
                returnAddRe.setBounds(1, 1, 75, 25);


                addResourcesContainer.add(campusSafety);
                addResourcesContainer.add(titleIVOffice);
                addResourcesContainer.add(counselingCenter);
                addResourcesFrame.add(returnAddRe);

                returnAddRe.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame returnAD = new JFrame("Additional Resources");
                        additionalResources(returnAD);
                        addResourcesFrame.dispose();
                    }
                });

                campusSafety.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ARTitle.setText("Campus Safety");
                        ARTitle.setBounds(250, 40, 500, 30);
                        addResourcesContainer.remove(campusSafety);
                        addResourcesContainer.remove(titleIVOffice);
                        addResourcesContainer.remove(counselingCenter);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(400,50, 700, 725);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().campusSafetyDescription);
                        campusSafetyTextArea.setBounds(5,100,690, 300);
                        campusSafetyTextArea.setLineWrap(true);
                        campusSafetyTextArea.setWrapStyleWord(true);
                        campusSafetyTextArea.setEditable(false);
                        addResourcesContainer.add(campusSafetyTextArea);
                    }
                });

                titleIVOffice.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ARTitle.setText("Title IV Office");
                        ARTitle.setBounds(250, 40, 500, 30);
                        addResourcesContainer.remove(campusSafety);
                        addResourcesContainer.remove(titleIVOffice);
                        addResourcesContainer.remove(counselingCenter);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(400,50, 700, 725);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().titleIVOfficeDescription);
                        campusSafetyTextArea.setBounds(5,100,690, 400);
                        campusSafetyTextArea.setLineWrap(true);
                        campusSafetyTextArea.setWrapStyleWord(true);
                        campusSafetyTextArea.setEditable(false);
                        addResourcesContainer.add(campusSafetyTextArea);
                    }
                });

                counselingCenter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ARTitle.setText("Counseling Center");
                        ARTitle.setBounds(250, 40, 500, 30);
                        addResourcesContainer.remove(campusSafety);
                        addResourcesContainer.remove(titleIVOffice);
                        addResourcesContainer.remove(counselingCenter);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(400,50, 700, 725);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().counselingCenterDescription);
                        campusSafetyTextArea.setBounds(5,100,690, 600);
                        campusSafetyTextArea.setLineWrap(true);
                        campusSafetyTextArea.setWrapStyleWord(true);
                        campusSafetyTextArea.setEditable(false);
                        addResourcesContainer.add(campusSafetyTextArea);
                    }
                });

            }
        });

        offCampusResourcesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ARTitle.setText("Off Campus Resources");
                ARTitle.setBounds(200, 40, 500, 30);
                addResourcesContainer.remove(onCampusResourcesButton);
                addResourcesContainer.remove(offCampusResourcesButton);
                addResourcesContainer.remove(returnHomeButton);
                addResourcesFrame.repaint();

                addResourcesFrame.setBounds(400,50, 700, 725);
                JTextArea offCampusTextArea = new JTextArea("Colorado Springs Police Department\nhttps://coloradosprings.gov/gocos\n(719) 444-7000");
                offCampusTextArea.setBounds(5,100,690, 600);
                offCampusTextArea.setLineWrap(true);
                offCampusTextArea.setWrapStyleWord(true);
                offCampusTextArea.setEditable(false);
                addResourcesContainer.add(offCampusTextArea);

                // Add button to return home
                JButton returnAddRe = new JButton("Back");
                returnAddRe.setBounds(1, 1, 75, 25);
                addResourcesFrame.add(returnAddRe);

                returnAddRe.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame returnAD = new JFrame("Additional Resources");
                        additionalResources(returnAD);
                        addResourcesFrame.dispose();
                    }
                });


            }
        });

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
