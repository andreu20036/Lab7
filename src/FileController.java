import java.io.*;
import java.util.*;

public class FileController
{
    static public void saveInFile(File file, ArrayList<Student> students)
    {
        try(FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer))
        {
            for (Iterator<Student> iterator = students.iterator(); iterator.hasNext(); )
            {
                Student student =  iterator.next();
                bufferWriter.write(student.toString() + "\r\n");
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.print("File not found");
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.out.print("Error");
        }
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
}
