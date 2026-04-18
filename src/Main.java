import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("karem", 25);
        s1.addGrade(90);
        s1.addGrade(85);
        s1.addGrade(70, 5);

        Student s2 = new Student("ibrahim", 21);
        s2.addGrade(89);
        s2.addGrade(84);

        Student s3 = new Student("massara", 22);

        List<Student> students = Arrays.asList(s1, s2, s3);

        System.out.println("Students information \n \n \n");
        students.forEach(student -> student.print());

        System.out.println("Print all student names using forEach");
        students.forEach(student -> System.out.println(student.getName()));

        System.out.println("1 Students with average > 80 ");
        students.stream()
                .filter(student -> student.calculateAverage() > 80)
                .forEach(student ->
                        System.out.println(student.getName() + " -> " + student.calculateAverage()));

        System.out.println("average of all students ");
        double allAverage = students.stream()
                .mapToDouble(Student::calculateAverage)
                .average()
                .orElse(0.0);

        System.out.println("all Average: " + allAverage);

        System.out.println("Filter grades > 80 for s1 ");
        List<Integer> filteredGrades = s1.filterGrades(g -> g > 80);
        System.out.println(filteredGrades);

        System.out.println(" Student Report");
        Student.Report report = s1.new Report();
        report.printReport();

        System.out.println("the getClass");
        Class<?> c = s1.getClass();

        System.out.println("Class Name: " + c.getName());

        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}