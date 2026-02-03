package KJ.task;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import KJ.KJException;

public class Deadline extends Task {
    protected LocalDateTime by;
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

    public Deadline(String description, String date) throws KJException {
        super(description);
        try {
            this.by = LocalDateTime.parse(date, INPUT_FORMAT);
        } catch (DateTimeException e) {
            throw new KJException("Use date format yyyy-MM-dd HHmm (e.g. 2019-12-02 1800).");
        }
    }

    @Override
    public String toFileString() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by.format(INPUT_FORMAT);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() +" (by: " + by.format(OUTPUT_FORMAT) + " )";
    }
}