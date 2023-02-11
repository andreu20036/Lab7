import java.io.*;
import java.util.*;

public class Main
{
    static ArrayList<Student> madeListOfStudents()
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
                new Student(1035, "Garcia", "Lucy", "Barron", "2001-01-10",
                        " ", " ", "Engineering", 3, "w2300")
        ));
    }
    static public ArrayList<Student> readStudentsInFile(File file)
    {
        ArrayList<Student> listOfStudents = new ArrayList<>();
        try
        {
            Scanner scanner = new Scanner(file);
            try
            {
                while(scanner.hasNext())
                    listOfStudents.add(new Student(Integer.parseInt(scanner.next()), scanner.next(), scanner.next(),
                            scanner.next(), scanner.next()," ", " ", scanner.next(),
                            Integer.parseInt(scanner.next()), scanner.next()));
            }
            catch (NumberFormatException e)
            {
                System.out.print("Invalid format");
            }
            catch(Exception e)
            {
                System.out.print("Error");
            }
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.print("File not found");
        }
        catch(Exception e)
        {
            System.out.print("Error");
        }
        return listOfStudents;
    }
    static void showListOfStudents(List<Student> listOfStudents)
    {
        System.out.println();
        for (Iterator<Student> iterator = listOfStudents.iterator(); iterator.hasNext(); )
        {
            Student student =  iterator.next();
            System.out.println(student.toString());
        }
    }
    static public Student newStudent()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть id, Прізвище, Ім’я, По батькові, Дата народження, " +
                "Адреса, Телефон, Факультет, Курс, Группу студента");
        int id = scanner.nextInt();
        String surname = scanner.next();
        String name = scanner.next();
        String fatherName = scanner.next();
        String birthday = scanner.next();
        String faculty = scanner.next();
        int course = scanner.nextInt();
        String group = scanner.next();
        Student student = new Student(id, surname, name,
                fatherName, birthday," ", " ", faculty,
                course, group);
        return student;
    }
    public static void main(String[] args)
    {
        ArrayList<Student> students = madeListOfStudents();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть факультет: ");//"Engineering"  scanner.nextLine()
        String Faculty = scanner.nextLine();
        List<Student> studentsWithSameFaculty = students.stream()
                .filter(x -> Faculty.equals(x.getFaculty()))
                .toList();
        showListOfStudents(studentsWithSameFaculty);

        System.out.print("Введіть рік: ");
        int year = scanner.nextInt();
        List<Student> studentsWhoBornAfterYear = students.stream()
                        .filter(x -> x.getBirthday().getYear() > year)
                        .toList();
        showListOfStudents(studentsWhoBornAfterYear);

        students.sort(null);
        showListOfStudents(students);

        students.sort(Comparator.comparing(Student::getFaculty).thenComparing(Student::getBirthday));
        showListOfStudents(students);

        Set<String> faculties = new HashSet<>();
        for (Student student: students) faculties.add(student.getFaculty());
        System.out.println("\n" + faculties);

        Map<String, Integer> map = new HashMap<>();
        for (Student student : students)
        {
            String faculty = student.getFaculty();
            Integer count = map.get(faculty);
            if(count == null) map.put(faculty, 1);
            else map.put(faculty, ++count);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println(entry);
        }

        //students.add(addNewStudent());
    }
}