import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


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
                whySRASTextField1.setBounds(0,80,500, 280);
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
                ourGoalsTextField1.setBounds(0,90,500, 250);
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
                dataUsageTextField1.setBounds(0,90,500, 140);
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
                foundersAndCurrTeamDescription.setBounds(0,80,500, 250);
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
        addResourcesFrame.setBounds(500,50, 500, 500);

        Container addResourcesContainer = addResourcesFrame.getContentPane();
        addResourcesContainer.setLayout(null);

        Font titleFont = new Font("Arial",Font.PLAIN, 30);

        JLabel ARTitle = new JLabel("Additional Resources");
        ARTitle.setOpaque(true);
        ARTitle.setBounds(115, 50, 500, 30);
        ARTitle.setFont(titleFont);

        //buttons in the additional resources page
        JButton onCampusResourcesButton = new JButton("On Campus Resources");
        onCampusResourcesButton.setBounds(150, 150, 200, 70);

        JButton offCampusResourcesButton = new JButton("Off Campus Resources");
        offCampusResourcesButton.setBounds(150, 250, 200, 70);

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
                ARTitle.setBounds(110, 40, 500, 30);
                addResourcesContainer.remove(onCampusResourcesButton);
                addResourcesContainer.remove(offCampusResourcesButton);
                addResourcesContainer.remove(returnHomeButton);
                addResourcesFrame.repaint();
                addResourcesFrame.setBounds(500,50, 500, 650);

                //buttons in the additional resources page
                JButton campusSafety = new JButton("Campus Safety");
                campusSafety.setBounds(150, 150, 200, 70);

                JButton titleIVOffice = new JButton("Title IV Office");
                titleIVOffice.setBounds(150, 250, 200, 70);

                JButton counselingCenter = new JButton("Counseling Center");
                counselingCenter.setBounds(150, 350, 200, 70);

                JButton otherOnCampusResources = new JButton("Other On Campus Resources");
                otherOnCampusResources.setBounds(150, 450, 200, 70);

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
                        ARTitle.setBounds(150, 40, 500, 50);
                        addResourcesContainer.remove(campusSafety);
                        addResourcesContainer.remove(titleIVOffice);
                        addResourcesContainer.remove(counselingCenter);
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(500,50, 500, 600);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().campusSafetyDescription);
                        campusSafetyTextArea.setBounds(0,100,500, 400);
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
                        ARTitle.setBounds(160, 40, 500, 30);
                        addResourcesContainer.remove(campusSafety);
                        addResourcesContainer.remove(titleIVOffice);
                        addResourcesContainer.remove(counselingCenter);
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(500,50, 500, 600);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().titleIVOfficeDescription);
                        campusSafetyTextArea.setBounds(0,100,500, 450);
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
                        ARTitle.setBounds(230, 30, 500, 50);
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
                        ARTitle.setBounds(50, 40, 450, 30);
                        addResourcesContainer.remove(campusSafety);
                        addResourcesContainer.remove(titleIVOffice);
                        addResourcesContainer.remove(counselingCenter);
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(500,50, 500, 600);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().otherOnCampusResourcesDescription);
                        campusSafetyTextArea.setBounds(0,100,500, 300);
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
                ARTitle.setBounds(100, 40, 500, 30);
                addResourcesContainer.remove(onCampusResourcesButton);
                addResourcesContainer.remove(offCampusResourcesButton);
                addResourcesContainer.remove(returnHomeButton);
                addResourcesFrame.repaint();

                addResourcesFrame.setBounds(500,50, 500, 500);
                JTextArea offCampusTextArea = new JTextArea(new AdditionalResources().offCampusDescription);
                offCampusTextArea.setBounds(0,100,500, 300);
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

    public void campusStats(JFrame campusStatsFrame) {
        // set up frame
        campusStatsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        campusStatsFrame.setBounds(400, 50, 700, 725);

        // create container with null layout
        Container campusStatsContainer = campusStatsFrame.getContentPane();
        campusStatsContainer.setLayout(null);

        // create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBounds(0, 0, 100, campusStatsFrame.getHeight() - 100); // set bounds to left-hand side of container
        campusStatsContainer.add(buttonPanel); // add panel to container

        // create panel for text fields and combo box
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.setBounds(campusStatsFrame.getWidth() / 4, campusStatsFrame.getHeight() - 100, campusStatsFrame.getWidth() / 2, 100);
        campusStatsContainer.add(inputPanel);
        generateStatsText();

        // create input fields
        JTextField startDateField = new JTextField("Start Date");
        JTextField endDateField = new JTextField("End Date");

        // create combo box for class selection
        JComboBox<String> classComboBox = new JComboBox<>(new String[] {"First Year", "Second Year", "Third Year", "Fourth Year"});

        // add input fields and combo box to panel
        inputPanel.add(new JLabel("Start Date"));
        inputPanel.add(startDateField);
        inputPanel.add(new JLabel("End Date"));
        inputPanel.add(endDateField);
        inputPanel.add(new JLabel("Class"));
        inputPanel.add(classComboBox);

        try (ReportDAO reportDao = new ReportDAO(); Connection conn = reportDao.getConnection()) {
            // get columns from table2
            String query = "SELECT * FROM table2";
            ResultSet result = ReportDAO.executeQuery(conn, "table2");

            // add buttons to panel based on columns in table2
            try {
                ResultSetMetaData meta = result.getMetaData();
                int numCols = meta.getColumnCount();
                for (int i = 1; i <= numCols; i++) {
                    String colName = meta.getColumnName(i);
                    buttonPanel.add(new JButton(colName));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // make frame visible
        campusStatsFrame.setVisible(true);
    }

    public String generateStatsText() {
        StringBuilder sb = new StringBuilder();
        try (ReportDAO reportDao = new ReportDAO(); Connection conn = reportDao.getConnection()) {
            // calculate average MHI number
            String avgMhiQuery = "SELECT AVG(mhi) FROM table2";
            ResultSet avgMhiResult = ReportDAO.executeQuery(conn, avgMhiQuery);
            if (avgMhiResult.next()) {
                double avgMhi = avgMhiResult.getDouble(1);
                sb.append(String.format("Average MHI number: %.2f\n", avgMhi));
            }

            // calculate total number of rows
            String numRowsQuery = "SELECT COUNT(*) FROM table2";
            ResultSet numRowsResult = ReportDAO.executeQuery(conn, numRowsQuery);
            if (numRowsResult.next()) {
                int numRows = numRowsResult.getInt(1);
                sb.append(String.format("Total number of rows: %d\n", numRows));
            }

            // calculate three most frequent location names
            String freqLocsQuery = "SELECT location, COUNT(*) as count FROM table2 GROUP BY location ORDER BY count DESC LIMIT 3";
            ResultSet freqLocsResult = ReportDAO.executeQuery(conn, freqLocsQuery);
            sb.append("Most frequent location names: ");
            while (freqLocsResult.next()) {
                String location = freqLocsResult.getString("location");
                sb.append(location);
                if (!freqLocsResult.isLast()) {
                    sb.append(", ");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sb.toString();
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
