public class AdditionalResources extends MoreInfo{
    String title = "Additional Resources";
    String heading1 = "1. Campus Safety";
    String description1 = "Campus Safety's goal...";
    String heading2 = "2. Title IV Office";
    String description2 = "The Title IV Office...";
    String heading3 = "3. Counseling Center";
    String description3 = "The Counseling Center...";


    @Override
    public void displayAllInfo() {
        System.out.println(title);
        System.out.println();
        System.out.println(heading1);
        System.out.println(description1);
        System.out.println();
        System.out.println(heading2);
        System.out.println(description2);
        System.out.println();
        System.out.println(heading3);
        System.out.println(description3);
    }
}
