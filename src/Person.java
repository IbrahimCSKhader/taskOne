public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String n, int a) {
        this.name = n;
        this.age = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        this.age = a;
    }

    public String getDescription() {
        return "Student Name: " + name + " \n Student  Age: " + age;
    }
}