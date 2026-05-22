import java.util.*;

public class Students {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Иван", "А-1", 1, Arrays.asList(4, 5, 4)));
        students.add(new Student("Анна", "Б-2", 1, Arrays.asList(2, 3, 2)));
        students.add(new Student("Петр", "В-3", 2, Arrays.asList(3, 4, 3)));
        students.add(new Student("Мария", "А-1", 2, Arrays.asList(5, 5, 5)));

        System.out.println("Исходный список студентов:");
        printAllStudents(students);

        StudentService.removeLowGpaStudents(students);

        System.out.println("\nПосле отчисления неуспевающих:");
        printAllStudents(students);

        StudentService.promoteStudents(students);

        System.out.println("\nПосле перевода на следующий курс:");
        printAllStudents(students);

        System.out.println("\nСтуденты на 2 курсе:");
        StudentService.printStudents(students, 2);
    }

    public static void printAllStudents(Set<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    @Override
    public String toString() {
        return name + " (Группа: " + group + ", Курс: " + course + ", Средний балл: " + getAverageGrade() + ")";
    }
}

class StudentService {
    public static void removeLowGpaStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                iterator.remove();
            }
        }
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Студентов на " + course + " курсе не найдено.");
        }
    }
}
