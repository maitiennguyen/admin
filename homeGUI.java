import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homeGUI extends GUIMethods{
    public JFrame frame;
    public JLabel title;

    public homeGUI(){
        frame = new JFrame("SRAS");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //program ends when exit button is clicked
        frame.setBounds(500,50, 500, 650);

        //container where buttons and labels are added to
        Container homeContainer = frame.getContentPane();
        homeContainer.setLayout(null);

        Font titleFont = new Font("Arial",Font.PLAIN, 30);

        //home label at the top of our window
        title = new JLabel("Home");
        title.setOpaque(true);
        title.setBounds(209,30,200,30);
        title.setFont(titleFont);

        //buttons on home page
        JButton aboutButton = new JButton("About");
        aboutButton.setBounds(150, 90, 200, 70);

        JButton additionalResourcesButton = new JButton("Additional Resources");
        additionalResourcesButton.setBounds(150, 190, 200, 70);

        JButton campusStatisticsButton = new JButton("Campus Statistics");
        campusStatisticsButton.setBounds(150, 290, 200, 70);

        JButton fileReportButton = new JButton("File Report");
        fileReportButton.setBounds(150, 390, 200, 70);

        JButton accessReportButton = new JButton("Access Report");
        accessReportButton.setBounds(150, 490, 200, 70);

        //adding everything to this frame
        homeContainer.add(title);
        homeContainer.add(aboutButton);
        homeContainer.add(additionalResourcesButton);
        homeContainer.add(campusStatisticsButton);
        homeContainer.add(fileReportButton);
        homeContainer.add(accessReportButton);

        //About button
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aboutPage = new JFrame("About");
                about(aboutPage);
                frame.dispose();
            }
        });

        //Additional Resources button when clicked
        additionalResourcesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame additionalResourcesPage = new JFrame("Additional Resources");
                additionalResources(additionalResourcesPage);
                frame.dispose();
            }
        });

        //Campus Statistics button when clicked
        campusStatisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame campusStatisticsPage = new JFrame("Campus Statistics");
                campusStats(campusStatisticsPage);
                frame.dispose();
            }
        });

        //File Report button when clicked
        fileReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qx = 5;
                int qy = 30;
                int qw = 500;
                int qh = 25;
                int ax = 5;
                int ay = 55;
                int aw = 500;
                int ah = 25;
                int dis = 70;

                // Set frame
                JFrame fileReportPage = new JFrame("File Report");
                fileReport(fileReportPage);
                Container contentPane = fileReportPage.getContentPane();

                // Add questions
                JLabel question1 = new JLabel("<html>Graduation Date (YYYY) <span style= color:red>*<small>Required</small></span></html>");
                question1.setBounds(qx, qy, qw, qh);
                JTextField answer1 = new JTextField();
                answer1.setBounds(ax, ay, aw/4, ah);

                JLabel question2 = new JLabel("<html>Date of Incident (MM/dd/yyyy) <span style= color:red>*<small>Required</small></span></html>");
                question2.setBounds(qx, qy + dis, qw, qh);
                JTextField answer2 = new JTextField();
                answer2.setBounds(ax, ay + dis, aw/4, ah);

                JLabel question3 = new JLabel("<html>Mental Health Impact <span style= color:red>*<small>Required</small></span></html>");
                question3.setBounds(qx, qy + dis * 2, qw, qh);
                String[] optionsMHI = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                JComboBox<String> answer3 = new JComboBox<>(optionsMHI);
                answer3.setBounds(ax, ay + dis * 2, aw/6, ah);

                JLabel question4 = new JLabel("Share your mental health experience (Optional)");
                question4.setBounds(qx, qy + dis * 3, qw, qh);
                JTextArea answerText4 = new JTextArea();
                answerText4.setLineWrap(true);
                JScrollPane answer4 = new JScrollPane(answerText4);
                answer4.setBounds(ax, ay + dis * 3, aw, ah * 2);

                JLabel question5 = new JLabel("Do you think your identities were being targeted? (Optional)");
                question5.setBounds(qx, qy + dis * 4 + 25, qw, qh);
                String[] optionsIdentity = {" ", "Yes", "No"};
                JComboBox<String> answer5 = new JComboBox<>(optionsIdentity);
                answer5.setBounds(ax, ay + dis * 4 + 25, aw/6, ah);

                JLabel question6 = new JLabel("If yes, which aspect(s) of your identity do you feel were relevant to this event? (Optional)");
                question6.setBounds(qx, qy + dis * 5 + 20, qw + 100, qh);
                JTextArea answerText6 = new JTextArea();
                answerText6.setLineWrap(true);
                JScrollPane answer6 = new JScrollPane(answerText6);
                answer6.setBounds(ax, ay + dis * 5 + 20, aw, ah * 2);

                JLabel question7 = new JLabel("Location of Incident (Optional)");
                question7.setBounds(qx, qy + dis * 6 + 45, qw, qh);
                JTextArea answerText7 = new JTextArea();
                answerText7.setLineWrap(true);
                JScrollPane answer7 = new JScrollPane(answerText7);
                answer7.setBounds(ax, ay + dis * 6 + 45, aw, ah * 2);

                JLabel question8 = new JLabel("Event Description (Optional)");
                question8.setBounds(qx, qy + dis * 7 + 70, qw, qh);
                JTextArea answerText8 = new JTextArea();
                answerText8.setLineWrap(true);
                JScrollPane answer8 = new JScrollPane(answerText8);
                answer8.setBounds(ax, ay + dis * 7 + 70, aw, ah * 2);

                contentPane.add(question1);
                contentPane.add(answer1);
                contentPane.add(question2);
                contentPane.add(answer2);
                contentPane.add(question3);
                contentPane.add(answer3);
                contentPane.add(question4);
                contentPane.add(answer4);
                contentPane.add(question5);
                contentPane.add(answer5);
                contentPane.add(question6);
                contentPane.add(answer6);
                contentPane.add(question7);
                contentPane.add(answer7);
                contentPane.add(question8);
                contentPane.add(answer8);

                // Add button to return home
                JButton returnHomeButton = new JButton("Back");
                returnHomeButton.setBounds(1, 1, 75, 25);
                contentPane.add(returnHomeButton);
                returnHomeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new homeGUI();
                        fileReportPage.dispose();
                    }
                });

                // Add button to submit report
                JButton submit = new JButton("Submit");
                submit.setBounds(575, 650, 75, 25);
                contentPane.add(submit);
                submit.addActionListener(new ActionListener() {
                    private final JLabel errorMessage = new JLabel();
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int error;
                        errorMessage.setForeground(Color.red);

                        ReportCommandsInvoker report = new ReportCommandsInvoker();
                        error = report.createReport(answer1.getText(), answer2.getText(),(String) answer3.getSelectedItem(), answerText4.getText(), (String) answer5.getSelectedItem(), answerText6.getText(), answerText7.getText(), answerText8.getText());
                        if (error == 1) {
                            contentPane.remove(errorMessage);
                            errorMessage.setText("Required. Must be in YYYY format and between 1900 and 2100.");
                            errorMessage.setBounds(ax + 150, ay, aw, ah);
                            contentPane.add(errorMessage);
                            fileReportPage.repaint();
                        }
                        else if (error == 2) {
                            contentPane.remove(errorMessage);
                            errorMessage.setText("<html>Required. Must be in MM/dd/yyyy format.<br>Date should be today or within the past 20 years of graduation year.</html>");
                            errorMessage.setBounds(ax + 150, ay + dis - 20, aw + 100, ah + 50);
                            contentPane.add(errorMessage);
                            fileReportPage.repaint();
                        }
                        else if (error == 3) {
                            contentPane.remove(errorMessage);
                            errorMessage.setText("Required");
                            errorMessage.setBounds(ax + 100, ay + dis * 2, aw + 100, ah);
                            contentPane.add(errorMessage);
                            fileReportPage.repaint();
                        }

                        else {
                            contentPane.removeAll();
                            fileReportPage.repaint();

                            JTextPane submittedMessage = new JTextPane();
                            submittedMessage.setOpaque(false);
                            submittedMessage.setContentType("text/html");
                            submittedMessage.setText("<html>Report Submitted Successfully.<br><br>Your Report ID: <b>" + report.getReport().getId() + "</b><br><br>Please save for future access.</html>");
                            Dimension labelSize = submittedMessage.getPreferredSize();
                            int centerX = fileReportPage.getWidth() / 2;
                            int centerY = fileReportPage.getHeight() / 2;
                            submittedMessage.setBounds(centerX - labelSize.width / 2, centerY - labelSize.height / 2 - 100, 225, labelSize.height + 20);
                            submittedMessage.setEditable(false);

                            contentPane.add(submittedMessage);

                            // Add button to return home
                            JButton returnHomeButton = new JButton("Back");
                            returnHomeButton.setBounds(centerX - labelSize.width / 2 + 50, centerY - labelSize.height / 2 + 25, 75, 25);
                            contentPane.add(returnHomeButton);
                            returnHomeButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    new homeGUI();
                                    fileReportPage.dispose();
                                }
                            });
                        }
                    }
                });
                frame.dispose();
            }
        });

        //Access Report button when clicked
        accessReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame accessReportPage = new JFrame("Access Report");
                accessReport(accessReportPage);
                Container contentPane = accessReportPage.getContentPane();

                // Add button to return home
                JButton returnHomeButton = new JButton("Back");
                returnHomeButton.setBounds(1, 1, 75, 25);
                contentPane.add(returnHomeButton);
                returnHomeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new homeGUI();
                        accessReportPage.dispose();
                    }
                });

                // Ask user for report ID
                JLabel idQ = new JLabel("Enter Report ID:");
                Dimension labelSize = idQ.getPreferredSize();
                int centerX = accessReportPage.getWidth() / 2;
                int centerY = accessReportPage.getHeight() / 2;
                idQ.setBounds(centerX - labelSize.width / 2, centerY - labelSize.height / 2 - 50, labelSize.width, labelSize.height);
                JTextField answerID = new JTextField();
                answerID.setBounds(centerX - labelSize.width / 2 - 50, centerY - labelSize.height / 2 - 20, labelSize.width + 100, labelSize.height + 10);
                contentPane.add(idQ);
                contentPane.add(answerID);

                // Submit report ID
                JButton submit = new JButton("Submit");
                submit.setBounds(centerX - labelSize.width / 2 + 10, centerY - labelSize.height / 2 + 20, 75, 25);
                contentPane.add(submit);
                submit.addActionListener(new ActionListener() {
                    private final JLabel errorMessage = new JLabel();
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int error;
                        errorMessage.setForeground(Color.red);

                        // access report
                        ReportCommandsInvoker retrievedReport = new ReportCommandsInvoker();
                        error = retrievedReport.accessReport(answerID.getText());
                        if (error == 1) {
                            contentPane.remove(errorMessage);
                            errorMessage.setText("Invalid. Report ID must have 10 characters.");
                            errorMessage.setBounds(centerX - labelSize.width / 2 - 75, centerY - labelSize.height / 2 - 175, 500, 200);
                            contentPane.add(errorMessage);
                            accessReportPage.repaint();
                        }
                        else if (error == 2) {
                            contentPane.remove(errorMessage);
                            errorMessage.setText("Report ID does not exist.");
                            errorMessage.setBounds(centerX - labelSize.width / 2 - 25, centerY - labelSize.height / 2 - 175, 500, 200);
                            contentPane.add(errorMessage);
                            accessReportPage.repaint();
                        }
                        else {
                            contentPane.removeAll();
                            accessReportPage.repaint();

                            Report report = retrievedReport.getReport();
                            int qx = 5;
                            int qy = 30;
                            int qw = 500;
                            int qh = 25;
                            int ax = 5;
                            int ay = 55;
                            int aw = 500;
                            int ah = 25;
                            int dis = 70;

                            // Add questions
                            JLabel question1 = new JLabel("*Graduation Date (YYYY)");
                            question1.setBounds(qx, qy, qw, qh);
                            JTextField answer1 = new JTextField();
                            answer1.setText(report.getGradYear());
                            answer1.setBounds(ax, ay, aw/4, ah);

                            JLabel question2 = new JLabel("*Date (MM/dd/yyyy)");
                            question2.setBounds(qx, qy + dis, qw, qh);
                            JTextField answer2 = new JTextField();
                            answer2.setText(report.getDate());
                            answer2.setBounds(ax, ay + dis, aw/4, ah);

                            JLabel question3 = new JLabel("*Mental Health Impact");
                            question3.setBounds(qx, qy + dis * 2, qw, qh);
                            String[] optionsMHI = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                            JComboBox<String> answer3 = new JComboBox<>(optionsMHI);
                            answer3.setSelectedItem(report.getMHI());
                            answer3.setBounds(ax, ay + dis * 2, aw/6, ah);

                            JLabel question4 = new JLabel(" Share your mental health experience");
                            question4.setBounds(qx, qy + dis * 3, qw, qh);
                            JTextArea answerText4 = new JTextArea();
                            answerText4.setText(report.getMHIText());
                            answerText4.setLineWrap(true);
                            JScrollPane answer4 = new JScrollPane(answerText4);
                            answer4.setBounds(ax, ay + dis * 3, aw, ah * 2);

                            JLabel question5 = new JLabel(" Do you think your identities were being targeted?");
                            question5.setBounds(qx, qy + dis * 4 + 25, qw, qh);
                            String[] optionsIdentity = {" ", "Yes", "No"};
                            JComboBox<String> answer5 = new JComboBox<>(optionsIdentity);
                            answer5.setSelectedItem(report.getIdentityYN());
                            answer5.setBounds(ax, ay + dis * 4 + 25, aw/6, ah);

                            JLabel question6 = new JLabel(" If yes, which aspect(s) of your identity do you feel were relevant to this event? ");
                            question6.setBounds(qx, qy + dis * 5 + 20, qw, qh);
                            JTextArea answerText6 = new JTextArea();
                            answerText6.setText(report.getIdentityText());
                            answerText6.setLineWrap(true);
                            JScrollPane answer6 = new JScrollPane(answerText6);
                            answer6.setBounds(ax, ay + dis * 5 + 20, aw, ah * 2);

                            JLabel question7 = new JLabel(" Location");
                            question7.setBounds(qx, qy + dis * 6 + 45, qw, qh);
                            JTextArea answerText7 = new JTextArea();
                            answerText7.setText(report.getLocation());
                            answerText7.setLineWrap(true);
                            JScrollPane answer7 = new JScrollPane(answerText7);
                            answer7.setBounds(ax, ay + dis * 6 + 45, aw, ah * 2);

                            JLabel question8 = new JLabel(" Event Description");
                            question8.setBounds(qx, qy + dis * 7 + 70, qw, qh);
                            JTextArea answerText8 = new JTextArea();
                            answerText8.setText(report.getEventDes());
                            answerText8.setLineWrap(true);
                            JScrollPane answer8 = new JScrollPane(answerText8);
                            answer8.setBounds(ax, ay + dis * 7 + 70, aw, ah * 2);

                            contentPane.add(question1);
                            contentPane.add(answer1);
                            contentPane.add(question2);
                            contentPane.add(answer2);
                            contentPane.add(question3);
                            contentPane.add(answer3);
                            contentPane.add(question4);
                            contentPane.add(answer4);
                            contentPane.add(question5);
                            contentPane.add(answer5);
                            contentPane.add(question6);
                            contentPane.add(answer6);
                            contentPane.add(question7);
                            contentPane.add(answer7);
                            contentPane.add(question8);
                            contentPane.add(answer8);

                            contentPane.revalidate();
                            contentPane.repaint();

                            // Add button to return home
                            JButton returnHomeButton = new JButton("Back");
                            returnHomeButton.setBounds(1, 1, 75, 25);
                            contentPane.add(returnHomeButton);
                            returnHomeButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    new homeGUI();
                                    accessReportPage.dispose();
                                }
                            });

                            /// add update button
                            JButton submit = new JButton("Update");
                            submit.setBounds(575, 650, 75, 25);
                            contentPane.add(submit);
                            submit.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int error;
                                    errorMessage.setForeground(Color.red);

                                    ReportCommandsInvoker updateReport = new ReportCommandsInvoker();
                                    error = updateReport.updateReport(report, answer1.getText(), answer2.getText(),(String) answer3.getSelectedItem(), answerText4.getText(), (String) answer5.getSelectedItem(), answerText6.getText(), answerText7.getText(), answerText8.getText());


                                    if (error == 1) {
                                        contentPane.remove(errorMessage);
                                        errorMessage.setText("Required. Must be in YYYY format and between 1900 and 2100.");
                                        errorMessage.setBounds(ax + 150, ay, aw, ah);
                                        contentPane.add(errorMessage);
                                        accessReportPage.repaint();
                                    }
                                    else if (error == 2) {
                                        contentPane.remove(errorMessage);
                                        errorMessage.setText("<html>Required. Must be in MM/dd/yyyy format.<br>Date should be today or within the past 20 years of graduation year.</html>");
                                        errorMessage.setBounds(ax + 150, ay + dis - 30, aw + 100, ah + 50);
                                        contentPane.add(errorMessage);
                                        accessReportPage.repaint();
                                    }
                                    else if (error == 3) {
                                        contentPane.remove(errorMessage);
                                        errorMessage.setText("Required");
                                        errorMessage.setBounds(ax + 100, ay + dis * 2, aw + 100, ah);
                                        contentPane.add(errorMessage);
                                        accessReportPage.repaint();
                                    }
                                    else {
                                        contentPane.removeAll();
                                        accessReportPage.repaint();

                                        JLabel updatedMessage = new JLabel();
                                        updatedMessage.setText("Report Updated Successfully.");
                                        Dimension labelSize = updatedMessage.getPreferredSize();
                                        int centerX = accessReportPage.getWidth() / 2;
                                        int centerY = accessReportPage.getHeight() / 2;
                                        updatedMessage.setBounds(centerX - labelSize.width / 2, centerY - 30 - labelSize.height / 2, 200, labelSize.height);

                                        contentPane.add(updatedMessage);

                                        // Add button to return home
                                        JButton returnHomeButton = new JButton("Back");
                                        returnHomeButton.setBounds(centerX - labelSize.width / 2 + 60, centerY - labelSize.height / 2 + 20, 75, 25);
                                        contentPane.add(returnHomeButton);
                                        returnHomeButton.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                new homeGUI();
                                                accessReportPage.dispose();
                                            }
                                        });

                                    }
                                }
                            });

                            // add delete button
                            JButton delete = new JButton("Delete Report");
                            delete.setBounds(550, 600, 125, 25);
                            contentPane.add(delete);
                            delete.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Command delete = new DeleteReportCommand(report);
                                    delete.execute();
                                    contentPane.removeAll();
                                    accessReportPage.repaint();

                                    JLabel deletedSuccess = new JLabel("Report Deleted Successfully.");
                                    Dimension labelSize = deletedSuccess.getPreferredSize();
                                    int centerX = accessReportPage.getWidth() / 2;
                                    int centerY = accessReportPage.getHeight() / 2;
                                    deletedSuccess.setBounds(centerX - labelSize.width / 2, centerY - labelSize.height / 2 - 50, labelSize.width, labelSize.height);
                                    contentPane.add(deletedSuccess);

                                    // Add button to return home
                                    JButton returnHomeButton = new JButton("Back");
                                    returnHomeButton.setBounds(centerX - labelSize.width / 2 + 60, centerY - labelSize.height / 2 + 20, 75, 25);
                                    contentPane.add(returnHomeButton);
                                    returnHomeButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            new homeGUI();
                                            accessReportPage.dispose();
                                        }
                                    });

                                    accessReportPage.revalidate();
                                    accessReportPage.repaint();

                                }
                            });

                        }
                    }
                });
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
