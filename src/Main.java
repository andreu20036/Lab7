import java.io.*;
import java.util.*;

public class Main
{
    ArrayList<Student> madeListOfStudents()
    {
        return new ArrayList<>(List.of(
                new Student(1035, "Albert", "Liz", "Stark", "2001-05-23",
                        " ", " ", "Engineering", 2, "w2200"),
                new Student(1281, "Wilson", "Laura", "Phillips", "2001-06-30",
                        " ", " ", "Engineering", 2, "w2200"),
                new Student(1222, "Hunter", "Kevin", "Mayer", "2002-03-11",
                        " ", " ", "Law", 1, "w1100"),
                new Student(1091, "Berg", "Katherine", "Beck", "2001-12-09",
                        " ", " ", "Law", 1, "w1100"),
                new Student(1065, "Garcia", "Lucy", "Barron", "2001-01-10",
                        " ", " ", "Engineering", 3, "w2300")
        ));
    }
    List<Student> studentsWithSameFaculty(ArrayList<Student> students)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть факультет: ");//"Engineering"
        String Faculty = scanner.nextLine();
        return students.stream()
                .filter(x -> Faculty.equals(x.getFaculty()))
                .toList();
    }
    List<Student> studentsWhoBornAfterYear(ArrayList<Student> students)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть рік: ");
        int year = scanner.nextInt();
        return students.stream()
                .filter(x -> x.getBirthday().getYear() > year)
                .toList();
    }
    Set<String> getFaculties(ArrayList<Student> students)
    {
        Set<String> faculties = new HashSet<>();
        for (Student student : students) faculties.add(student.getFaculty());
        return faculties;
    }
    void howMuchStudentsInFaculties(ArrayList<Student> students)
    {
        Map<String, Integer> map = new HashMap<>();
        for (Student student : students)
        {
            String faculty = student.getFaculty();
            Integer count = map.get(faculty);
            if (count == null) map.put(faculty, 1);
            else map.put(faculty, ++count);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println(entry);
        }
    }
    void menu(ArrayList<Student> students)
    {
        Scanner scanner = new Scanner(System.in);
        String action = "";
        System.out.println("Щоб додати дані студента введіть \"додати\", " +
                "видалити дані про студента - \"видалити\", " + "\n" +
                "вивести список студентів - \"список\", " +
                "для завершення програми - \"вихід\".");
        while (!action.equals("вихід"))
        {
            System.out.print("Ваш вибір: ");
            action = scanner.nextLine();
            if (action.equals("додати"))
            {
                Student student = newStudent();
                students.add(student);
            }
            else if (action.equals("видалити"))
            {
                System.out.print("Введіть id: ");
                int id = scanner.nextInt();
                for (Iterator<Student> iterator = students.iterator(); iterator.hasNext(); )
                {
                    int Id =  iterator.next().getId();
                    if (id == Id) iterator.remove();
                }
            }
            else if (action.equals("список")) showListOfStudents(students);
            else System.out.println("Повторіть спробу!");
        }
        System.out.println("Гарного Вам дня!");
    }
    void showListOfStudents(List<Student> listOfStudents)
    {
        System.out.println();
        for (Iterator<Student> iterator = listOfStudents.iterator(); iterator.hasNext(); )
        {
            Student student =  iterator.next();
            System.out.println(student.toString());
        }
    }
    public Student newStudent()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть id, Прізвище, Ім’я, По батькові, Дата народження, " +
                "Адреса, Телефон, Факультет, Курс, Группу студента");
        int id, course;
        String surname, name, fatherName, birthday, faculty, group;
        id = scanner.nextInt();
        surname = scanner.next();
        name = scanner.next();
        fatherName = scanner.next();
        birthday = scanner.next();
        faculty = scanner.next();
        course = scanner.nextInt();
        group = scanner.next();
        Student student = new Student(id, surname, name, fatherName, birthday,
                " ", " ", faculty, course, group);
        return student;
    }
    public static void main(String[] args)
    {
        Main prog = new Main();
        prog.run();
    }

    private void run()
    {
        ArrayList<Student> students = madeListOfStudents();
        showListOfStudents(studentsWithSameFaculty(students));
        showListOfStudents(studentsWhoBornAfterYear(students));

        students.sort(null);
        showListOfStudents(students);

        students.sort(Comparator.comparing(Student::getFaculty).thenComparing(Student::getBirthday));
        showListOfStudents(students);

        System.out.println("\n" + getFaculties(students));

        howMuchStudentsInFaculties(students);

        menu(students);
    }
}