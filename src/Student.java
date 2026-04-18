import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Student extends Person implements Printable {
    private List<Integer> grades;

    public Student() {
        this.grades = new ArrayList<>();
    }

    public Student(String n, int a) {
        super(n, a);
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public void addGrade(int grade, int bonus) {
        grades.add(grade + bonus);
    }

    public double calculateAverage() {
        double avg = 0;
       avg= grades.isEmpty()? 0 :grades.stream()
               .mapToInt(Integer::intValue)
               .average().getAsDouble();

        return avg;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public List<Integer> filterGrades(GradeFilter filter) {
        return grades.stream()
                .filter(g -> filter.test(g))
                .collect(Collectors.toList());
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\nStudent  Grades: " + grades  + "\n Student Average: " + calculateAverage();
    }

    @Override
    public void print() {
        System.out.println(getDescription());
    }

    public class Report {
        public void printReport() {
            System.out.println("Student Name: " + getName() + "\nAverage Grade: " + calculateAverage());
        }
    }
}