public class AdditionalResources extends MoreInfo{
    String title = "Additional Resources";
    String campusSafetyHeading = "1. Campus Safety";
    String campusSafetyDescription = "Campus Safety is committed to creating a safe environment on the Colorado College campus " +
            "by providing educational programs, services, support, emergency response, %nand high visibility patrol for the " +
            "campus community. Their services are available 24/7.\n" +
            "\n" +
            "If you would like to see a list of all their programs and services, please explore the Campus Safety Safety Programs " +
            "and Services page on the Colorado College%nwebsite. " +
            "(direct link here: https://www.coloradocollege.edu/offices/campussafety/safety-programs-and-services/) \n" +
            "\n" +
            "List of ways to contact Campus Safety:\n" +
            "219 E. Uintah Street\n" +
            "Non-Emergency: 719-389-6707\n" +
            "Emergency: 719-389-6911\n" +
            "campussafety@coloradocollege.edu\n" +
            "\n" +
            "Want to know more? Check out the Campus Safety page on the Colorado College website. " +
            "(direct link here: https://www.coloradocollege.edu/offices/campussafety/)\n";
    String titleIVOfficeHeader = "2. Title IV Office";
    String titleIVOfficeDescription = "The Title IV Office is a newly established office on the Colorado College campus " +
            "that is available to all students, staff, and faculty for concerns involving %ndiscrimination, harassment, " +
            "sexual misconduct (both sexual harassment and sexual assault), dating/domestic violence, stalking, and/or " +
            "related retaliation.\n" +
            "\n" +
            "Location & Hours:\n" +
            "Worner 216\n" +
            "Office Hours\n" +
            "8:30 a.m. - 5:00 p.m.\n" +
            "Monday - Friday\n" +
            "\n" +
            "Mailing Address:\n" +
            "Office for Civil Rights & Title IX\n" +
            "Colorado College \n" +
            "14 E. Cache La Poudre Street\n" +
            "Colorado Springs, CO 80903\n" +
            "\n" +
            "Who can you contact?\n" +
            "Tashana Taylor\n" +
            "719-239-6881\n" +
            "tashana.taylor@coloradocollege.edu\n" +
            "\n" +
            "If you want to know more about what their office offers, please explore the Office for Civil Rights & Title IX " +
            "page on the Colorado College website. " +
            "%n(direct link here: https://www.coloradocollege.edu/offices/titleix/index.html)" +
            "\n";
    String counselingCenterHeader = "3. Counseling Center";
    String counselingCenterDescription = "The Counseling Center provides mental health services such as counseling, " +
            "psychotherapy, consultations, medication management and prescriptions, workshops, %nreferrals to off-campus " +
            "services, and a 24-hour emergency service to all enrolled Colorado College students. There are no fees for " +
            "the first six sessions %nof counseling, but there are fees for psychiatrist medication services. If you have " +
            "questions about the details of your mental health coverage and benefits, %nplease consult your health insurance " +
            "provider. However, financial support is offered through the college if needed and no student is denied. \n" +
            "\n" +
            "The primary service offered at the Counseling Center is counseling and there are a variety of reasons why a " +
            "student would seek counseling. If you would like %nto see the current Counseling Center staff to make an " +
            "appointment with a specific counselor, please explore the Counseling Center Staff page on the Colorado " +
            "%nCollege website. (direct link here: https://www.coloradocollege.edu/offices/counseling/staff/index.html) " +
            "It’s also important to note that meetings with any %ncounselor are kept confidential by law. \n" +
            "\n" +
            "Hours of Operation:\n" +
            "** Urgent appointments are available daily. **\n" +
            "Academic Year: 9am - 5pm on weekdays (with some evening and weekend hours available)\n" +
            "Summer Session: 9am - 4pm weekdays (except for Memorial Day and 4th of July) \n" +
            "\n" +
            "Location:\n" +
            "In Person: 819 North Tejon Street, Colorado Springs, Colorado, 80903 (on the 2nd floor of the student health center)\n" +
            "Remote: Zoom\n" +
            "\n" +
            "How does someone make a counseling appointment?\n" +
            "Phone: 719-389-6093\n" +
            "Fax: 719-389-6064\n" +
            "Email: counselingcenter@coloradocollege.edu\n" +
            "\n" +
            "What if someone needs to contact the Counseling Center after hours?\n" +
            "Call 719-389-6093 and press 1 to leave a message for the next day, or press 2 to be immediately connected " +
            "with a licensed counselor, or press 0 to be %nconnected to campus safety\n" +
            "If it’s a life-threatening emergency, call 911 and/or campus safety (719-389-6911) \n" +
            "\n" +
            "Want to know more? Explore the Counseling Center page on the Colorado College website. " +
            "(direct link here: https://www.coloradocollege.edu/offices/counseling/) \n";


    @Override
    public void displayAllInfo() {
        System.out.println(title);
        System.out.println();
        System.out.println(campusSafetyHeading);
        System.out.printf(campusSafetyDescription);
        System.out.println();
        System.out.println(titleIVOfficeHeader);
        System.out.printf(titleIVOfficeDescription);
        System.out.println();
        System.out.println(counselingCenterHeader);
        System.out.printf(counselingCenterDescription);
    }
}
