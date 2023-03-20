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
        aboutTitle.setBounds(210, 30, 500, 40)
        ;
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

        whySRASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutTitle.setText("Why SRAS?");
                aboutTitle.setBounds(160, 30, 500, 50);
                aboutContainer.remove(whySRASButton);
                aboutContainer.remove(ourGoalsButton);
                aboutContainer.remove(dataUsageButton);
                aboutContainer.remove(FAQButton);
                aboutContainer.remove(foundersAndCurrentTeamButton);
                aboutContainer.remove(returnHomeButton);
                aboutFrame.repaint();

                aboutFrame.setBounds(500,50, 500, 500);

                // Add button to return to About
                JButton returnAbout = new JButton("Back");
                returnAbout.setBounds(1, 1, 75, 25);
                aboutFrame.add(returnAbout);
                returnAbout.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame returnA = new JFrame("About");
                        about(returnA);
                        aboutFrame.dispose();
                    }
                });

                //first text field
                JTextArea whySRASTextField1 = new JTextArea(new About().whySRASDescription);
                whySRASTextField1.setBounds(0,80,500, 150);
                whySRASTextField1.setLineWrap(true);
                whySRASTextField1.setWrapStyleWord(true);
                whySRASTextField1.setEditable(false);

                aboutContainer.add(whySRASTextField1);
            }
        });

        ourGoalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutTitle.setText("Our Goals");
                aboutTitle.setBounds(190, 40, 500, 50);
                aboutContainer.remove(whySRASButton);
                aboutContainer.remove(ourGoalsButton);
                aboutContainer.remove(dataUsageButton);
                aboutContainer.remove(FAQButton);
                aboutContainer.remove(foundersAndCurrentTeamButton);
                aboutContainer.remove(returnHomeButton);
                aboutFrame.repaint();

                aboutFrame.setBounds(500,50, 500, 500);

                // Add button to return to About
                JButton returnAbout = new JButton("Back");
                returnAbout.setBounds(1, 1, 75, 25);
                aboutFrame.add(returnAbout);
                returnAbout.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame returnA = new JFrame("About");
                        about(returnA);
                        aboutFrame.dispose();
                    }
                });

                //first text field
                JTextArea ourGoalsTextField1 = new JTextArea(new About().ourGoalsDescription);
                ourGoalsTextField1.setBounds(0,90,500, 300);
                ourGoalsTextField1.setLineWrap(true);
                ourGoalsTextField1.setWrapStyleWord(true);
                ourGoalsTextField1.setEditable(false);

                aboutContainer.add(ourGoalsTextField1);
            }
        });

        dataUsageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutTitle.setText("Data Usage");
                aboutTitle.setBounds(170, 30, 500, 50);
                aboutContainer.remove(whySRASButton);
                aboutContainer.remove(ourGoalsButton);
                aboutContainer.remove(dataUsageButton);
                aboutContainer.remove(FAQButton);
                aboutContainer.remove(foundersAndCurrentTeamButton);
                aboutContainer.remove(returnHomeButton);
                aboutFrame.repaint();

                aboutFrame.setBounds(500,50, 500, 500);

                // Add button to return to About
                JButton returnAbout = new JButton("Back");
                returnAbout.setBounds(1, 1, 75, 25);
                aboutFrame.add(returnAbout);
                returnAbout.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame returnA = new JFrame("About");
                        about(returnA);
                        aboutFrame.dispose();
                    }
                });

                //first text field
                JTextArea dataUsageTextField1 = new JTextArea(new About().dataUsageDescription);
                dataUsageTextField1.setBounds(0,90,500, 150);
                dataUsageTextField1.setLineWrap(true);
                dataUsageTextField1.setWrapStyleWord(true);
                dataUsageTextField1.setEditable(false);

                aboutContainer.add(dataUsageTextField1);
            }
        });

        FAQButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutTitle.setText("FAQ");
                aboutTitle.setBounds(220, 40, 500, 30);
                aboutContainer.remove(whySRASButton);
                aboutContainer.remove(ourGoalsButton);
                aboutContainer.remove(dataUsageButton);
                aboutContainer.remove(FAQButton);
                aboutContainer.remove(foundersAndCurrentTeamButton);
                aboutContainer.remove(returnHomeButton);
                aboutFrame.repaint();

                aboutFrame.setBounds(500,50, 500, 720);

                // Add button to return to About
                JButton returnAbout = new JButton("Back");
                returnAbout.setBounds(1, 1, 75, 25);
                aboutFrame.add(returnAbout);
                returnAbout.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame returnA = new JFrame("About");
                        about(returnA);
                        aboutFrame.dispose();
                    }
                });

                //first text field
                JTextArea FAQTextField1 = new JTextArea(new About().howToNavigateHeading + new About().howToNavigateDescription);
                FAQTextField1.setBounds(0,80,500, 135);
                FAQTextField1.setLineWrap(true);
                FAQTextField1.setWrapStyleWord(true);
                FAQTextField1.setEditable(false);

                //second text field
                JTextArea FAQTextField2 = new JTextArea(new About().howDoIFileAReportHeading + new About().howDoIFileAReportDescription);
                FAQTextField2.setBounds(0,225,500, 153);
                FAQTextField2.setLineWrap(true);
                FAQTextField2.setWrapStyleWord(true);
                FAQTextField2.setEditable(false);

                //third text field
                JTextArea FAQTextField3 = new JTextArea(new About().howDoIReAccessAReportHeading+ new About().howDoIReAccessAReportDescription);
                FAQTextField3.setBounds(0,388,500, 135);
                FAQTextField3.setLineWrap(true);
                FAQTextField3.setWrapStyleWord(true);
                FAQTextField3.setEditable(false);

                //fourth text field
                JTextArea FAQTextField4 = new JTextArea(new About().howCurrentAreTheStatisticsHeading + new About().howCurrentAreTheStatisticsDescription);
                FAQTextField4.setBounds(0,533,500, 73);
                FAQTextField4.setLineWrap(true);
                FAQTextField4.setWrapStyleWord(true);
                FAQTextField4.setEditable(false);

                aboutContainer.add(FAQTextField1);
                aboutContainer.add(FAQTextField2);
                aboutContainer.add(FAQTextField3);
                aboutContainer.add(FAQTextField4);
            }
        });

        foundersAndCurrentTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutTitle.setText("Founders and Current Team");
                aboutTitle.setBounds(70, 40, 500, 30);
                aboutContainer.remove(whySRASButton);
                aboutContainer.remove(ourGoalsButton);
                aboutContainer.remove(dataUsageButton);
                aboutContainer.remove(FAQButton);
                aboutContainer.remove(foundersAndCurrentTeamButton);
                aboutContainer.remove(returnHomeButton);
                aboutFrame.repaint();

                aboutFrame.setBounds(500,50, 500, 400);

                // Add button to return to About
                JButton returnAbout = new JButton("Back");
                returnAbout.setBounds(1, 1, 75, 25);
                aboutFrame.add(returnAbout);
                returnAbout.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame returnA = new JFrame("About");
                        about(returnA);
                        aboutFrame.dispose();
                    }
                });

                //first text field
                JTextArea foundersAndCurrTeamDescription = new JTextArea(new About().foundersAndCurrentTeamDescription);
                foundersAndCurrTeamDescription.setBounds(0,80,500, 150);
                foundersAndCurrTeamDescription.setLineWrap(true);
                foundersAndCurrTeamDescription.setWrapStyleWord(true);
                foundersAndCurrTeamDescription.setEditable(false);

                aboutContainer.add(foundersAndCurrTeamDescription);
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
                addResourcesFrame.setBounds(550,50, 400, 650);

                //buttons in the additional resources page
                JButton campusSafety = new JButton("Campus Safety");
                campusSafety.setBounds(100, 150, 200, 70);

                JButton titleIVOffice = new JButton("Title IV Office");
                titleIVOffice.setBounds(100, 250, 200, 70);

                JButton counselingCenter = new JButton("Counseling Center");
                counselingCenter.setBounds(100, 350, 200, 70);

                JButton otherOnCampusResources = new JButton("Other On Campus Resources");
                otherOnCampusResources.setBounds(100, 450, 200, 70);

                // Add button to return home
                JButton returnAddRe = new JButton("Back");
                returnAddRe.setBounds(1, 1, 75, 25);

                addResourcesContainer.add(campusSafety);
                addResourcesContainer.add(titleIVOffice);
                addResourcesContainer.add(counselingCenter);
                addResourcesContainer.add(otherOnCampusResources);
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
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(400,50, 700, 725);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().campusSafetyDescription);
                        campusSafetyTextArea.setBounds(0,100,700, 300);
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
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(400,50, 700, 725);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().titleIVOfficeDescription);
                        campusSafetyTextArea.setBounds(0,100,700, 400);
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
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(400,50, 700, 725);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().counselingCenterDescription);
                        campusSafetyTextArea.setBounds(0,100,700, 600);
                        campusSafetyTextArea.setLineWrap(true);
                        campusSafetyTextArea.setWrapStyleWord(true);
                        campusSafetyTextArea.setEditable(false);
                        addResourcesContainer.add(campusSafetyTextArea);
                    }
                });

                otherOnCampusResources.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ARTitle.setText("Other On Campus Resources");
                        ARTitle.setBounds(25, 40, 450, 30);
                        addResourcesContainer.remove(campusSafety);
                        addResourcesContainer.remove(titleIVOffice);
                        addResourcesContainer.remove(counselingCenter);
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(525,50, 450, 600);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().otherOnCampusResourcesDescription);
                        campusSafetyTextArea.setBounds(0,100,450, 300);
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
                JTextArea offCampusTextArea = new JTextArea(new AdditionalResources().offCampusDescription);
                offCampusTextArea.setBounds(0,100,700, 600);
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
