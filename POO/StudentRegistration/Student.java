public class Student {
    private String name;
    private int age;
    private String course;
    private String studentNumber;

    public Student() {
        this.name = "Unnamed";
        this.age = 0;
        this.course = "Undeclared";
        this.studentNumber = "Not registered";
    }

    public Student(String name, int age, String course, String registrationNumber) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.studentNumber = registrationNumber;
    }

    public void displayInformation() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("Registration Number: " + studentNumber);
        System.out.println();
    }

    public String getName() {
        return name;
    }
}
