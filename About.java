public class About extends MoreInfo{
    String title = "About";
    String heading1 = "How do you navigate the Student Reports & Statistics platform?";
    String description1 = "Depending on what you want to do...";

    @Override
    public void displayAllInfo() {
        System.out.println(title);
        System.out.println();
        System.out.println(heading1);
        System.out.println(description1);
    }
}
