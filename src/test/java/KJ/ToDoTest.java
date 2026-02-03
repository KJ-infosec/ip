package KJ.task;  //same package as the class being tested
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void testToString_newTodo_success() {
        ToDo todo = new ToDo("read book");
        assertEquals("[T][ ] read book", todo.toString());
    }

    @Test
    public void testMarkAsDone_todo_success() {
        ToDo todo = new ToDo("read book");
        todo.markAsDone();
        assertEquals("[T][X] read book", todo.toString());
    }

    @Test
    public void testToFileString_todo_success() {
        ToDo todo = new ToDo("read book");
        assertEquals("T | 0 | read book", todo.toFileString());
    }
}
