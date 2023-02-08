import java.io.*;
import java.time.*;

public class Student
{
    private int id;
    private String surname;
    private String name;
    private String fatherName;
    private LocalDate birthday;
    private String address;
    private String phoneNumber;
    private String faculty;
    private int course;
    private String group;

    public int getId()
    {
        return id;
    }
    public String getSurname()
    {
        return surname;
    }
    public String getName()
    {
        return name;
    }
    public String getFatherName()
    {
        return fatherName;
    }
    public LocalDate getBirthday()
    {
        return birthday;
    }
    public String getAddress()
    {
        return address;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public String getFaculty()
    {
        return faculty;
    }
    public int getCourse()
    {
        return course;
    }
    public String getGroup()
    {
        return group;
    }

    public void setId(int id)
    {
        if(id > 1000) this.id = id;
    }
    public void setSurname(String surname)
    {
        if(surname.length() > 2) this.surname = surname;
    }
    public void setName(String name)
    {
        if(name.length() > 2) this.name = name;
    }
    public void setFatherName(String fatherName)
    {
        if(fatherName.length() > 2) this.fatherName = fatherName;
    }
    public void setBirthday(String birthday)
    {
        LocalDate birthdayDT = LocalDate.parse(birthday);
        if(birthdayDT.getYear() >= 2000) this.birthday = birthdayDT;
    }
    public void setAddress(String address)
    {
        if(address.length() > 5) this.address = address;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        if(phoneNumber.length() >= 10 && phoneNumber.length() < 20) this.phoneNumber = phoneNumber;
    }
    public void setFaculty(String faculty)
    {
        if(faculty.length() > 5) this.faculty = faculty;
    }
    public void setCourse(int course)
    {
        if(course > 0 && course < 10) this.course = course;
    }
    public void setGroup(String group)
    {
        if(group.length() > 4) this.group = group;
    }

    public String toString()
    {
        return  id + " " + surname + " " + name + " " + fatherName + " " + birthday + " " + address + " "
                + phoneNumber + " " + faculty + " " + course + " " + group;
    }
    public void saveInFile(File file)
    {
        try
        {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(toString() + "\r\n");
            bufferWriter.close();
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

    Student()
    {
        this.id = 0;
        this.surname = "";
        this.name = "";
        this.fatherName = "";
        this.birthday = LocalDate.parse("2000-01-01");
        this.address = "";
        this.phoneNumber = "";
        this.faculty = "";
        this.course = 0;
        this.group = "";
    }
    Student(int id, String surname, String name, String fatherName, String birthday,
            String address, String phoneNumber, String faculty, int course, String group)
    {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.birthday = LocalDate.parse(birthday);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }
}