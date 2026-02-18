package kj.task;

import kj.KjException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeadlineTest {
    @Test
    public void testConstructor_validDate_success() throws KjException{
        Deadline deadline = new Deadline("return book", "2026-12-01 1800");
        assertEquals("[D][ ] return book (by: Dec 01 2026, 6:00 pm )", deadline.toString());
    }

    @Test
    public void testConstructor_invalidDate_exceptionThrown() {
        KjException exception = assertThrows(KjException.class, () -> {
            new Deadline("invalid date", "2026/12/01");
        });

        assertEquals("Use date format yyyy-MM-dd HHmm (e.g. 2019-12-02 1800).", exception.getMessage());
    }
}