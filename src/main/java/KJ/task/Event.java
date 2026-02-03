package KJ.task;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Event extends Task {
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

    public Event(String description, String startTime, String endTime) {
        super(description);
        this.startTime = LocalDateTime.parse(startTime, INPUT_FORMAT);
        this.endTime = LocalDateTime.parse(endTime, INPUT_FORMAT);
    }

    @Override
    public String toFileString() {
        return "E | " + (isDone ? "1" : "0") + " | " + description
                + " | " + startTime.format(INPUT_FORMAT) + " | " + endTime.format(INPUT_FORMAT);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() +" (from: " + startTime.format(OUTPUT_FORMAT) + " to: " + endTime.format(OUTPUT_FORMAT) + " )";
    }
}