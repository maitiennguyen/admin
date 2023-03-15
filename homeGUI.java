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
        frame.setBounds(400,50, 700, 725);

        //container where buttons and labels are added to
        Container homeContainer = frame.getContentPane();
        homeContainer.setLayout(null);

        Font titleFont = new Font("Arial",Font.PLAIN, 30);

        //home label at the top of our window
        title = new JLabel("Home");
        title.setOpaque(true);
        title.setBounds(310,40,400,60);
        title.setFont(titleFont);

        //buttons on home page
        JButton aboutButton = new JButton("About");
        aboutButton.setBounds(250, 130, 200, 70);

        JButton additionalResourcesButton = new JButton("Additional Resources");
        additionalResourcesButton.setBounds(250, 230, 200, 70);

        JButton campusStatisticsButton = new JButton("Campus Statistics");
        campusStatisticsButton.setBounds(250, 330, 200, 70);

        JButton fileReportButton = new JButton("File Report");
        fileReportButton.setBounds(250, 430, 200, 70);

        JButton accessReportButton = new JButton("Access Report");
        accessReportButton.setBounds(250, 530, 200, 70);

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
                JFrame fileReportPage = new JFrame("File Report");
                fileReport(fileReportPage);
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
