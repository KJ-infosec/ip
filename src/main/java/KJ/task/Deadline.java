package KJ.task;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import KJ.KJException;

/**
 * Represents a task with a specific deadline.
 * A Deadline object contains a description and a date/time by which
 * the task must be completed.
 */
public class Deadline extends Task {
    protected LocalDateTime by;
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

    /**
     * Constructs a Deadline task with the given description and date.
     * * @param description The description of the task.
     * @param date The deadline date string in the format "yyyy-MM-dd HHmm".
     * @throws KJException If the date string does not match the required format.
     */
    public Deadline(String description, String date) throws KJException {
        super(description);
        try {
            this.by = LocalDateTime.parse(date, INPUT_FORMAT);
        } catch (DateTimeException e) {
            throw new KJException("Use date format yyyy-MM-dd HHmm (e.g. 2019-12-02 1800).");
        }
    }

    /**
     * Returns a string representation of the deadline task formatted for file storage.
     * The format used is: D | isDone | description | date.
     * * @return A formatted string suitable for saving to a text file.
     */
    @Override
    public String toFileString() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by.format(INPUT_FORMAT);
    }

    /**
     * Returns a string representation of the deadline task for display to the user.
     * Includes the task type identifier [D], the status icon, description, and formatted deadline date.
     * * @return A user-friendly string representation of the deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() +" (by: " + by.format(OUTPUT_FORMAT) + " )";
    }
}