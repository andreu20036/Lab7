import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest
{

    @Test
    void addNewStudent()
    {
        Student student = Main.newStudent();
        System.out.print(student.toString());
    }
}