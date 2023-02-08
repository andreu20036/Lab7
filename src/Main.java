import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
    static ArrayList<Student> madeListOfStudents()
    {
        return new ArrayList<>(List.of(
                new Student(1035, "Albert", "Liz", "Stark", "2001-05-23",
                        " ", " ", "Engineering", 2, "w2200"),
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
    static public Student addNewStudent()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть id, Прізвище, Ім’я, По батькові, Дата народження, " +
                            "Адреса, Телефон, Факультет, Курс, Группу студента");
        return new Student(scanner.nextInt(), scanner.next(), scanner.next(),
                scanner.next(), scanner.next()," ", " ", scanner.next(),
                scanner.nextInt(), scanner.next());
    }
    static ArrayList<Student> listOfStudentsWithSameFaculty(String faculty, ArrayList<Student> listOfStudents)
    {
        ArrayList<Student> listOfStudentsWithSameFaculty = new ArrayList<>();
        Iterator<Student> iter = listOfStudentsWithSameFaculty.iterator();
        while(iter.hasNext())
        {
            Student temp = iter.next();
            if(temp.getFaculty() == faculty) listOfStudentsWithSameFaculty.add(temp);
        }
        return listOfStudentsWithSameFaculty;
    }
    static ArrayList<Student> listOfStudentsWhoBornAfterYear(int year, ArrayList<Student> listOfStudents)
    {
        ArrayList<Student> listOfStudentsWhoBornAfterYear = new ArrayList<>();
        Iterator<Student> iter = listOfStudentsWhoBornAfterYear.iterator();
        while(iter.hasNext())
        {
            Student temp = iter.next();
            if(temp.getBirthday().getYear() > year) listOfStudentsWhoBornAfterYear.add(temp);
        }
        return listOfStudentsWhoBornAfterYear;
    }
    static ArrayList<Student> listOfStudentsWithSameGroup(String group, ArrayList<Student> listOfStudents)
    {
        ArrayList<Student> listOfStudentsWithSameGroup = new ArrayList<>();
        Iterator<Student> iter = listOfStudentsWithSameGroup.iterator();
        while(iter.hasNext())
        {
            Student temp = iter.next();
            if(temp.getGroup() == group) listOfStudentsWithSameGroup.add(temp);
        }
        return listOfStudentsWithSameGroup;
    }
    static void showListOfStudents(ArrayList<Student> listOfStudents)
    {
        for (Iterator<Student> iterator = listOfStudents.iterator(); iterator.hasNext(); )
        {
            Student student =  iterator.next();
            System.out.println(student.toString());
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = madeListOfStudents();
        System.out.println("Введіть факультет: ");
        showListOfStudents(listOfStudentsWithSameFaculty(scanner.nextLine(), students));
        System.out.println("Введіть рік: ");
        showListOfStudents(listOfStudentsWhoBornAfterYear(scanner.nextInt(), students));

        students.add(addNewStudent());
    }
}