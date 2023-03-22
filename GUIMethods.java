import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.sql.*;

public class GUIMethods {
    private String classValue;
    public void about (JFrame aboutFrame) {
        aboutFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        aboutFrame.setBounds(500, 50, 500, 650);

        Container aboutContainer = aboutFrame.getContentPane();
        aboutContainer.setLayout(null);

        Font titleFont = new Font("Arial", Font.PLAIN, 30);

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
        FAQButton.setBounds(150, 390, 200, 70);

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

                aboutFrame.setBounds(500, 50, 500, 500);

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
                whySRASTextField1.setBounds(0, 80, 500, 280);
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

                aboutFrame.setBounds(500, 50, 500, 500);

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
                ourGoalsTextField1.setBounds(0, 90, 500, 250);
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

                aboutFrame.setBounds(500, 50, 500, 500);

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
                dataUsageTextField1.setBounds(0, 90, 500, 140);
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

                aboutFrame.setBounds(500, 50, 500, 720);

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
                FAQTextField1.setBounds(0, 80, 500, 135);
                FAQTextField1.setLineWrap(true);
                FAQTextField1.setWrapStyleWord(true);
                FAQTextField1.setEditable(false);

                //second text field
                JTextArea FAQTextField2 = new JTextArea(new About().howDoIFileAReportHeading + new About().howDoIFileAReportDescription);
                FAQTextField2.setBounds(0, 225, 500, 153);
                FAQTextField2.setLineWrap(true);
                FAQTextField2.setWrapStyleWord(true);
                FAQTextField2.setEditable(false);

                //third text field
                JTextArea FAQTextField3 = new JTextArea(new About().howDoIReAccessAReportHeading + new About().howDoIReAccessAReportDescription);
                FAQTextField3.setBounds(0, 388, 500, 135);
                FAQTextField3.setLineWrap(true);
                FAQTextField3.setWrapStyleWord(true);
                FAQTextField3.setEditable(false);

                //fourth text field
                JTextArea FAQTextField4 = new JTextArea(new About().howCurrentAreTheStatisticsHeading + new About().howCurrentAreTheStatisticsDescription);
                FAQTextField4.setBounds(0, 533, 500, 73);
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

                aboutFrame.setBounds(500, 50, 500, 400);

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
                foundersAndCurrTeamDescription.setBounds(0, 80, 500, 260);
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
                addResourcesFrame.setBounds(500,50, 500, 760);

                //buttons in the additional resources page
                JButton campusSafety = new JButton("Campus Safety");
                campusSafety.setBounds(150, 100, 200, 70);

                JButton titleIVOffice = new JButton("Title IV Office");
                titleIVOffice.setBounds(150, 200, 200, 70);

                JButton counselingCenter = new JButton("Counseling Center");
                counselingCenter.setBounds(150, 300, 200, 70);

                JButton SARC = new JButton("SARC");
                SARC.setBounds(150, 400, 200, 70);

                JButton onDemandCrisisCounseling = new JButton("On-Demand Crisis Counseling");
                onDemandCrisisCounseling.setBounds(150, 500, 200, 70);

                JButton otherOnCampusResources = new JButton("Other On Campus Resources");
                otherOnCampusResources.setBounds(150, 600, 200, 70);

                // Add button to return home
                JButton returnAddRe = new JButton("Back");
                returnAddRe.setBounds(1, 1, 75, 25);
//
                addResourcesContainer.add(campusSafety);
                addResourcesContainer.add(titleIVOffice);
                addResourcesContainer.add(counselingCenter);
                addResourcesContainer.add(SARC);
                addResourcesContainer.add(onDemandCrisisCounseling);
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
                        addResourcesContainer.remove(SARC);
                        addResourcesContainer.remove(onDemandCrisisCounseling);
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(500,50, 500, 600);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().campusSafetyDescription);
                        campusSafetyTextArea.setBounds(0,100,500, 280);
                        campusSafetyTextArea.setLineWrap(true);
                        campusSafetyTextArea.setWrapStyleWord(true);
                        campusSafetyTextArea.setEditable(false);

                        //links to campus safety
                        JLabel campusSafetyProgramsLabel = new JLabel("Campus Safety Safety Programs and Services Link: ");
                        campusSafetyProgramsLabel.setBounds(0, 400, 400, 30);

                        JLabel campusSafetyProgramsLink = new JLabel("<html><a href=\"https://www.coloradocollege.edu/offices/campussafety/safety-programs-and-services/\">https://www.coloradocollege.edu/offices/campussafety/safety-programs-and-services/</a></html>");
                        campusSafetyProgramsLink.setBounds(0, 420, 500, 30);
                        campusSafetyProgramsLink.setForeground(Color.BLUE);
                        campusSafetyProgramsLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        campusSafetyProgramsLink.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() > 0) {
                                    try {
                                        Desktop.getDesktop().browse(new URI("https://www.coloradocollege.edu/offices/campussafety/safety-programs-and-services/"));
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        });

                        JLabel campusSafetyPageLabel = new JLabel("Campus Safety Link: ");
                        campusSafetyPageLabel.setBounds(0, 450, 400, 30);

                        JLabel campusSafetyPageLink = new JLabel("<html><a href=\"https://www.coloradocollege.edu/offices/campussafety/\">https://www.coloradocollege.edu/offices/campussafety/</a></html>");
                        campusSafetyPageLink.setBounds(0, 470, 500, 30);
                        campusSafetyPageLink.setForeground(Color.BLUE);
                        campusSafetyPageLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        campusSafetyPageLink.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() > 0) {
                                    try {
                                        Desktop.getDesktop().browse(new URI("https://www.coloradocollege.edu/offices/campussafety/"));
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        });

                        //adding everything to the container
                        addResourcesContainer.add(campusSafetyTextArea);
                        addResourcesContainer.add(campusSafetyProgramsLabel);
                        addResourcesContainer.add(campusSafetyProgramsLink);
                        addResourcesContainer.add(campusSafetyPageLabel);
                        addResourcesContainer.add(campusSafetyPageLink);
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
                        addResourcesContainer.remove(SARC);
                        addResourcesContainer.remove(onDemandCrisisCounseling);
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(500,50, 500, 650);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().titleIVOfficeDescription);
                        campusSafetyTextArea.setBounds(0,100,500, 410);
                        campusSafetyTextArea.setLineWrap(true);
                        campusSafetyTextArea.setWrapStyleWord(true);
                        campusSafetyTextArea.setEditable(false);

                        //link to Title IX Office page
                        JLabel titleIXOfficeLabel = new JLabel("Office for Civil Rights & Title IX Link: ");
                        titleIXOfficeLabel.setBounds(0, 530, 400, 30);

                        JLabel titleIXOfficeLink = new JLabel("<html><a href=\"https://www.coloradocollege.edu/offices/titleix/index.html\">https://www.coloradocollege.edu/offices/titleix/index.html</a></html>");
                        titleIXOfficeLink.setBounds(0, 550, 500, 30);
                        titleIXOfficeLink.setForeground(Color.BLUE);
                        titleIXOfficeLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        titleIXOfficeLink.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() > 0) {
                                    try {
                                        Desktop.getDesktop().browse(new URI("https://www.coloradocollege.edu/offices/titleix/index.html"));
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        });
                        addResourcesContainer.add(campusSafetyTextArea);
                        addResourcesContainer.add(titleIXOfficeLabel);
                        addResourcesContainer.add(titleIXOfficeLink);
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
                        addResourcesContainer.remove(SARC);
                        addResourcesContainer.remove(onDemandCrisisCounseling);
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(400,50, 700, 800);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().counselingCenterDescription);
                        campusSafetyTextArea.setBounds(0,100,700, 530);
                        campusSafetyTextArea.setLineWrap(true);
                        campusSafetyTextArea.setWrapStyleWord(true);
                        campusSafetyTextArea.setEditable(false);

                        //links to Counseling Center
                        JLabel counselingCenterStaffLabel = new JLabel("Counseling Center Staff Link: ");
                        counselingCenterStaffLabel.setBounds(0, 640, 400, 30);

                        JLabel counselingCenterStaffLink = new JLabel("<html><a href=\"https://www.coloradocollege.edu/offices/counseling/staff/index.html\">https://www.coloradocollege.edu/offices/counseling/staff/index.html</a></html>");
                        counselingCenterStaffLink.setBounds(0, 660, 500, 30);
                        counselingCenterStaffLink.setForeground(Color.BLUE);
                        counselingCenterStaffLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        counselingCenterStaffLink.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() > 0) {
                                    try {
                                        Desktop.getDesktop().browse(new URI("https://www.coloradocollege.edu/offices/counseling/staff/index.html"));
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        });

                        JLabel counselingCenterLabel = new JLabel("Counseling Center Link: ");
                        counselingCenterLabel.setBounds(0, 680, 400, 30);

                        JLabel counselingCenterLink = new JLabel("<html><a href=\"https://www.coloradocollege.edu/offices/counseling/\">https://www.coloradocollege.edu/offices/counseling/</a></html>");
                        counselingCenterLink.setBounds(0, 700, 500, 30);
                        counselingCenterLink.setForeground(Color.BLUE);
                        counselingCenterLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        counselingCenterLink.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() > 0) {
                                    try {
                                        Desktop.getDesktop().browse(new URI("https://www.coloradocollege.edu/offices/counseling/"));
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        });
                        addResourcesContainer.add(campusSafetyTextArea);
                        addResourcesContainer.add(counselingCenterStaffLabel);
                        addResourcesContainer.add(counselingCenterStaffLink);
                        addResourcesContainer.add(counselingCenterLabel);
                        addResourcesContainer.add(counselingCenterLink);
                    }
                });

                SARC.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ARTitle.setText("SARC");
                        ARTitle.setBounds(200, 40, 450, 30);
                        addResourcesContainer.remove(campusSafety);
                        addResourcesContainer.remove(titleIVOffice);
                        addResourcesContainer.remove(counselingCenter);
                        addResourcesContainer.remove(SARC);
                        addResourcesContainer.remove(onDemandCrisisCounseling);
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(500,50, 500, 500);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().SARCdescription);
                        campusSafetyTextArea.setBounds(0,100,500, 230);
                        campusSafetyTextArea.setLineWrap(true);
                        campusSafetyTextArea.setWrapStyleWord(true);
                        campusSafetyTextArea.setEditable(false);

                        //SARC link
                        JLabel SARCLabel = new JLabel("SARC Website Link: "); //to access RAVE
                        SARCLabel.setBounds(0, 350, 400, 30);

                        JLabel SARCLink = new JLabel("<html><a href=\"https://www.coloradocollege.edu/other/wellness/sarp/index.html\">https://www.coloradocollege.edu/other/wellness/sarp/index.html</a></html>");
                        SARCLink.setBounds(0, 370, 500, 30);
                        SARCLink.setForeground(Color.BLUE);
                        SARCLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        SARCLink.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() > 0) {
                                    try {
                                        Desktop.getDesktop().browse(new URI("https://www.coloradocollege.edu/other/wellness/sarp/index.html"));
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        });
                        addResourcesContainer.add(campusSafetyTextArea);
                        addResourcesContainer.add(SARCLabel);
                        addResourcesContainer.add(SARCLink);
                    }
                });

                onDemandCrisisCounseling.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ARTitle.setText("On-Demand Crisis Counseling");
                        ARTitle.setBounds(50, 40, 450, 50);
                        addResourcesContainer.remove(campusSafety);
                        addResourcesContainer.remove(titleIVOffice);
                        addResourcesContainer.remove(counselingCenter);
                        addResourcesContainer.remove(SARC);
                        addResourcesContainer.remove(onDemandCrisisCounseling);
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(500,50, 500, 500);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().onDemandCrisisCounselingDescription);
                        campusSafetyTextArea.setBounds(0,100,500, 180);
                        campusSafetyTextArea.setLineWrap(true);
                        campusSafetyTextArea.setWrapStyleWord(true);
                        campusSafetyTextArea.setEditable(false);

                        //link for support services
                        JLabel supportServicesLabel = new JLabel("Support Services Website Link: "); //to access RAVE
                        supportServicesLabel.setBounds(0, 300, 400, 30);

                        JLabel supportServicesLink = new JLabel("<html><a href=\"https://www.coloradocollege.edu/lifeatcc/support/\">https://www.coloradocollege.edu/lifeatcc/support/</a></html>");
                        supportServicesLink.setBounds(0, 320, 750, 30);
                        supportServicesLink.setForeground(Color.BLUE);
                        supportServicesLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        supportServicesLink.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() > 0) {
                                    try {
                                        Desktop.getDesktop().browse(new URI("https://www.coloradocollege.edu/lifeatcc/support/"));
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        });
                        addResourcesContainer.add(campusSafetyTextArea);
                        addResourcesContainer.add(supportServicesLabel);
                        addResourcesContainer.add(supportServicesLink);
                    }
                });

                otherOnCampusResources.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ARTitle.setText("Other On Campus Resources");
                        ARTitle.setBounds(120, 40, 450, 30);
                        addResourcesContainer.remove(campusSafety);
                        addResourcesContainer.remove(titleIVOffice);
                        addResourcesContainer.remove(counselingCenter);
                        addResourcesContainer.remove(SARC);
                        addResourcesContainer.remove(onDemandCrisisCounseling);
                        addResourcesContainer.remove(otherOnCampusResources);
                        addResourcesFrame.repaint();

                        addResourcesFrame.setBounds(450,50, 600, 800);
                        JTextArea campusSafetyTextArea = new JTextArea(new AdditionalResources().otherOnCampusResourcesDescription);
                        campusSafetyTextArea.setBounds(0,100,600, 440);
                        campusSafetyTextArea.setLineWrap(true);
                        campusSafetyTextArea.setWrapStyleWord(true);
                        campusSafetyTextArea.setEditable(false);

                        //other on campus resources links
                        JLabel campusSafetyPageLabel = new JLabel("Campus Safety Website Link: "); //to access RAVE
                        campusSafetyPageLabel.setBounds(0, 560, 400, 30);

                        JLabel campusSafetyPageLink = new JLabel("<html><a href=\"https://www.coloradocollege.edu/offices/campussafety/\">https://www.coloradocollege.edu/offices/campussafety/</a></html>");
                        campusSafetyPageLink.setBounds(0, 580, 700, 30);
                        campusSafetyPageLink.setForeground(Color.BLUE);
                        campusSafetyPageLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        campusSafetyPageLink.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() > 0) {
                                    try {
                                        Desktop.getDesktop().browse(new URI("https://www.coloradocollege.edu/offices/campussafety/"));
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        });

                        JLabel chaplainsOffLabel = new JLabel("Chaplain's Office Website Link: "); //to access RAVE
                        chaplainsOffLabel.setBounds(0, 600, 400, 30);

                        JLabel chaplainsOffLink = new JLabel("<html><a href=\"https://www.coloradocollege.edu/offices/chaplainsoffice/about-us.html\">https://www.coloradocollege.edu/offices/chaplainsoffice/about-us.html</a></html>");
                        chaplainsOffLink.setBounds(0, 620, 700, 30);
                        chaplainsOffLink.setForeground(Color.BLUE);
                        chaplainsOffLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        chaplainsOffLink.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() > 0) {
                                    try {
                                        Desktop.getDesktop().browse(new URI("https://www.coloradocollege.edu/offices/chaplainsoffice/about-us.html"));
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        });

                        JLabel empAssistProgramLabel = new JLabel("Employee Assistance Program Website Link: "); //to access RAVE
                        empAssistProgramLabel.setBounds(0, 640, 400, 30);

                        JLabel empAssistProgramLink = new JLabel("<html><a href=\"https://www.coloradocollege.edu/offices/humanresources/covid19/supporting-employees.html\">https://www.coloradocollege.edu/offices/humanresources/covid19/supporting-employees.html</a></html>");
                        empAssistProgramLink.setBounds(0, 660, 750, 30);
                        empAssistProgramLink.setForeground(Color.BLUE);
                        empAssistProgramLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        empAssistProgramLink.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() > 0) {
                                    try {
                                        Desktop.getDesktop().browse(new URI("https://www.coloradocollege.edu/offices/humanresources/covid19/supporting-employees.html"));
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        });

                        JLabel butlerCenLabel = new JLabel("The Butler Center Website Link: "); //to access RAVE
                        butlerCenLabel.setBounds(0, 680, 400, 30);

                        JLabel butlerCenLink = new JLabel("<html><a href=\"https://www.coloradocollege.edu/offices/butlercenter/\">https://www.coloradocollege.edu/offices/butlercenter/</a></html>");
                        butlerCenLink.setBounds(0, 700, 750, 30);
                        butlerCenLink.setForeground(Color.BLUE);
                        butlerCenLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        butlerCenLink.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() > 0) {
                                    try {
                                        Desktop.getDesktop().browse(new URI("https://www.coloradocollege.edu/offices/butlercenter/"));
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        });

                        addResourcesContainer.add(campusSafetyTextArea);
                        addResourcesContainer.add(campusSafetyPageLabel);
                        addResourcesContainer.add(campusSafetyPageLink);
                        addResourcesContainer.add(chaplainsOffLabel);
                        addResourcesContainer.add(chaplainsOffLink);
                        addResourcesContainer.add(empAssistProgramLabel);
                        addResourcesContainer.add(empAssistProgramLink);
                        addResourcesContainer.add(butlerCenLabel);
                        addResourcesContainer.add(butlerCenLink);
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

                addResourcesFrame.setBounds(500,50, 500, 700);
                JTextArea offCampusTextArea = new JTextArea(new AdditionalResources().offCampusDescription);
                offCampusTextArea.setBounds(0,100,500, 380);
                offCampusTextArea.setLineWrap(true);
                offCampusTextArea.setWrapStyleWord(true);
                offCampusTextArea.setEditable(false);

                //off campus resources links
                JLabel counselingCenterLabel = new JLabel("Counseling Center Website Link: ");
                counselingCenterLabel.setBounds(0, 500, 400, 30);

                JLabel counselingCenterLink = new JLabel("<html><a href=\"https://www.coloradocollege.edu/offices/counseling/\">https://www.coloradocollege.edu/offices/counseling/</a></html>");
                counselingCenterLink.setBounds(0, 520, 500, 30);
                counselingCenterLink.setForeground(Color.BLUE);
                counselingCenterLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                counselingCenterLink.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() > 0) {
                            try {
                                Desktop.getDesktop().browse(new URI("https://www.coloradocollege.edu/offices/counseling/"));
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });

                JLabel COSpringPoliceDeptLabel = new JLabel("Colorado Springs Police Department Website Link: ");
                COSpringPoliceDeptLabel.setBounds(0, 540, 400, 30);

                JLabel COSpringPoliceDeptLink = new JLabel("<html><a href=\"https://coloradosprings.gov/police-department\">https://coloradosprings.gov/police-department</a></html>");
                COSpringPoliceDeptLink.setBounds(0, 560, 500, 30);
                COSpringPoliceDeptLink.setForeground(Color.BLUE);
                COSpringPoliceDeptLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                COSpringPoliceDeptLink.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() > 0) {
                            try {
                                Desktop.getDesktop().browse(new URI("https://coloradosprings.gov/police-department"));
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });

                JLabel natAllianceMentalIllnessLabel = new JLabel("National Alliance on Mental Illness Colorado Springs Website Link: ");
                natAllianceMentalIllnessLabel.setBounds(0, 580, 500, 30);

                JLabel natAllianceMentalIllnessLink = new JLabel("<html><a href=\"https://www.namicoloradosprings.org/\">https://www.namicoloradosprings.org/</a></html>");
                natAllianceMentalIllnessLink.setBounds(0, 600, 500, 30);
                natAllianceMentalIllnessLink.setForeground(Color.BLUE);
                natAllianceMentalIllnessLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                natAllianceMentalIllnessLink.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() > 0) {
                            try {
                                Desktop.getDesktop().browse(new URI("https://www.namicoloradosprings.org/"));
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });

                addResourcesContainer.add(offCampusTextArea);
                addResourcesContainer.add(counselingCenterLabel);
                addResourcesContainer.add(counselingCenterLink);
                addResourcesContainer.add(COSpringPoliceDeptLabel);
                addResourcesContainer.add(COSpringPoliceDeptLink);
                addResourcesContainer.add(natAllianceMentalIllnessLabel);
                addResourcesContainer.add(natAllianceMentalIllnessLink);

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
        campusStatsFrame.setBounds(450, 50, 600, 675);

        // create container with null layout
        Container campusStatsContainer = campusStatsFrame.getContentPane();
        campusStatsContainer.setLayout(null);

        Font titleFont = new Font("Arial", Font.PLAIN, 30);

        JLabel campusStatsTitle = new JLabel("Campus Statistics");
        campusStatsTitle.setOpaque(true);
        campusStatsTitle.setBounds(180, 20, 500, 40);
        campusStatsTitle.setFont(titleFont);

        //return button
        JButton returnHomeButton = new JButton("Back");
        returnHomeButton.setBounds(1, 1, 75, 25);

        //submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 550, 75, 25);

        campusStatsContainer.add(campusStatsTitle);
        campusStatsContainer.add(returnHomeButton);
        campusStatsContainer.add(submitButton);

        returnHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new homeGUI();
                campusStatsFrame.dispose();
            }
        });

        // text field at the top of stats
        JTextArea statsTextField = new JTextArea(generate3MostFreqLocations() + "\n" + "\n" + generateAvgMHIText() + "\n" + generateTotalNumOfRowsText());
        statsTextField.setBounds(140,80,320, 250);
        statsTextField.setLineWrap(true);
        statsTextField.setWrapStyleWord(true);
        statsTextField.setEditable(false);
        campusStatsContainer.add(statsTextField);

        // create panel for text fields and combo box
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.setBounds(campusStatsFrame.getWidth() / 4, campusStatsFrame.getHeight() - 300, campusStatsFrame.getWidth() / 2, 100);
        campusStatsContainer.add(inputPanel);

        // create input fields
        JTextField startDateField = new JTextField("Start Date");
        JTextField endDateField = new JTextField("End Date");
        JTextField identityField = new JTextField("Identity");

        // create combo boxs
        JComboBox<String> classComboBox = new JComboBox<>(new String[] {"", "First Year", "Second Year", "Third Year", "Fourth Year"});
        JComboBox<String> identityComboBox = new JComboBox<>(new String[] {"", "Yes", "No"});


        // add action listener to classComboBox
        classComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) classComboBox.getSelectedItem();
                switch (selectedOption) {
                    case "Freshman":
                        classValue = "3";
                        break;
                    case "Sophomore":
                        classValue = "2";
                        break;
                    case "Junior":
                        classValue = "1";
                        break;
                    case "Senior":
                        classValue = "0";
                        break;
                    default:
                        classValue = null;
                        break;
                }
                // do something with selectedValue
            }
        });

        // add input fields and combo box to panel
        inputPanel.add(new JLabel("Start Date"));
        inputPanel.add(startDateField);
        inputPanel.add(new JLabel("End Date"));
        inputPanel.add(endDateField);
        inputPanel.add(new JLabel("Identity"));
        inputPanel.add(identityField);
        inputPanel.add(new JLabel("Class"));
        inputPanel.add(classComboBox);
        inputPanel.add(new JLabel("IdentityYN"));
        inputPanel.add(identityComboBox);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statsTextField.setText(new Save().applyFilters(startDateField.getText(), endDateField.getText(), identityField.getText(), (String) classComboBox.getSelectedItem(), classValue));
            }
        });

        // make frame visible
        campusStatsFrame.setVisible(true);
    }

    public String generateAvgMHIText() {
        StringBuilder sb = new StringBuilder();
        ReportDAO reportDao = new ReportDAO();
        Connection conn = reportDao.getConnection();
        String avgMhiQuery = "SELECT AVG(MHI) FROM ShortAnswers";
        try (PreparedStatement pstmt = ReportDAO.conn.prepareStatement(avgMhiQuery)) {
            // calculate average MHI number
            ResultSet avgMhiResult = pstmt.executeQuery();
            if (avgMhiResult.next()) {
                double avgMhi = avgMhiResult.getDouble(1);
                sb.append(String.format("Average MHI Number: %.2f\n", avgMhi));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public String generateTotalNumOfRowsText(){
        StringBuilder sb = new StringBuilder();
        String numRowsQuery = "SELECT COUNT(*) FROM ShortAnswers";
        ReportDAO reportDao = new ReportDAO();
        Connection conn = reportDao.getConnection();
        try(PreparedStatement pstmt = ReportDAO.conn.prepareStatement(numRowsQuery)){
            ResultSet numRowsResult = pstmt.executeQuery();
            if (numRowsResult.next()) {
                int numRows = numRowsResult.getInt(1);
                sb.append(String.format("Total number of reports: %d\n", numRows));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String generate3MostFreqLocations() {
        StringBuilder sb = new StringBuilder();
        ReportDAO reportDao = new ReportDAO();
        Connection conn = reportDao.getConnection();
        String freqLocsQuery = "SELECT Location, COUNT(*) as count FROM LongAnswers GROUP BY location ORDER BY count DESC LIMIT 3";
        try (PreparedStatement pstmt = ReportDAO.conn.prepareStatement(freqLocsQuery)) {
            // calculate total number of rows
            ResultSet freqLocsResult = pstmt.executeQuery();
            sb.append("Most frequent locations: ");
            while (freqLocsResult.next()) {
                String location = freqLocsResult.getString("Location");
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
