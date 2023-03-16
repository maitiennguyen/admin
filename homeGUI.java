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
                JLabel question1 = new JLabel("*Graduation Date (YYYY)");
                question1.setBounds(qx, qy, qw, qh);
                JTextField answer1 = new JTextField();
                answer1.setBounds(ax, ay, aw/4, ah);

                JLabel question2 = new JLabel("*Date (MM/dd/yyyy)");
                question2.setBounds(qx, qy + dis, qw, qh);
                JTextField answer2 = new JTextField();
                answer2.setBounds(ax, ay + dis, aw/4, ah);

                JLabel question3 = new JLabel("*Mental Health Impact");
                question3.setBounds(qx, qy + dis * 2, qw, qh);
                String[] optionsMHI = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                JComboBox<String> answer3 = new JComboBox<>(optionsMHI);
                answer3.setBounds(ax, ay + dis * 2, aw/6, ah);

                JLabel question4 = new JLabel(" Share your mental health experience");
                question4.setBounds(qx, qy + dis * 3, qw, qh);
                JTextArea answerText4 = new JTextArea();
                answerText4.setLineWrap(true);
                JScrollPane answer4 = new JScrollPane(answerText4);
                answer4.setBounds(ax, ay + dis * 3, aw, ah * 2);

                JLabel question5 = new JLabel(" Do you think your identities were being targeted?");
                question5.setBounds(qx, qy + dis * 4 + 25, qw, qh);
                String[] optionsIdentity = {" ", "Y", "N"};
                JComboBox<String> answer5 = new JComboBox<>(optionsIdentity);
                answer5.setBounds(ax, ay + dis * 4 + 25, aw/6, ah);

                JLabel question6 = new JLabel(" If yes, which aspect(s) of your identity do you feel were relevant to this event? ");
                question6.setBounds(qx, qy + dis * 5 + 20, qw, qh);
                JTextArea answerText6 = new JTextArea();
                answerText6.setLineWrap(true);
                JScrollPane answer6 = new JScrollPane(answerText6);
                answer6.setBounds(ax, ay + dis * 5 + 20, aw, ah * 2);

                JLabel question7 = new JLabel(" Location");
                question7.setBounds(qx, qy + dis * 6 + 45, qw, qh);
                JTextArea answerText7 = new JTextArea();
                answerText7.setLineWrap(true);
                JScrollPane answer7 = new JScrollPane(answerText7);
                answer7.setBounds(ax, ay + dis * 6 + 45, aw, ah * 2);

                JLabel question8 = new JLabel(" Event Description");
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

                        FileReport report = new FileReport();
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
                            errorMessage.setBounds(ax + 150, ay + dis - 30, aw + 100, ah + 50);
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
                            contentPane.remove(errorMessage);
                            fileReportPage.repaint();
                            JFrame submitted = new JFrame("Report Submitted Successfully.");
                            submitted.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                            submitted.setSize(300,200);
                            submitted.setLocationRelativeTo(null);

                            Container submittedContainer = submitted.getContentPane();
                            submittedContainer.setLayout(null);

                            JLabel submittedMessage = new JLabel();
                            submittedMessage.setText("<html>Report Submitted Successfully.<br><br>Your Report ID: " + report.getReport().getId() + "<br><br>Please save for future access.<html>");

                            Dimension labelSize = submittedMessage.getPreferredSize();
                            int centerX = submitted.getWidth() / 2;
                            int centerY = submitted.getHeight() / 2;

                            submittedMessage.setBounds(centerX - labelSize.width / 2, centerY - 30 - labelSize.height / 2, labelSize.width, labelSize.height);

                            submittedContainer.add(submittedMessage);
                            submitted.setVisible(true);

                            // Add button to return home
                            JButton returnHomeButton = new JButton("Back");
                            returnHomeButton.setBounds(centerX - labelSize.width / 2 + 60, centerY - labelSize.height / 2 + 70, 75, 25);
                            submittedContainer.add(returnHomeButton);
                            returnHomeButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    new homeGUI();
                                    submitted.dispose();
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
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
