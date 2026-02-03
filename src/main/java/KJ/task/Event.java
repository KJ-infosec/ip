package KJ.task;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * Represents an event task that occurs within a specific time range.
 * An Event object includes a description, a start time, and an end time.
 */
public class Event extends Task {
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

    /**
     * Constructs an Event task with the given description, start time, and end time.
     * * @param description The description of the event.
     * @param startTime The start time string in the format "yyyy-MM-dd HHmm".
     * @param endTime The end time string in the format "yyyy-MM-dd HHmm".
     * @throws KJException If either date string does not match the required format.
     */
    public Event(String description, String startTime, String endTime) {
        super(description);
        this.startTime = LocalDateTime.parse(startTime, INPUT_FORMAT);
        this.endTime = LocalDateTime.parse(endTime, INPUT_FORMAT);
    }

    /**
     * Returns a string representation of the event task formatted for file storage.
     * The format used is: E | isDone | description | startTime | endTime.
     * * @return A formatted string suitable for saving to a text file.
     */
    @Override
    public String toFileString() {
        return "E | " + (isDone ? "1" : "0") + " | " + description
                + " | " + startTime.format(INPUT_FORMAT) + " | " + endTime.format(INPUT_FORMAT);
    }

    /**
     * Returns a string representation of the event task for display to the user.
     * Includes the task type identifier [E], the status icon, description, and the time range.
     * * @return A user-friendly string representation of the event.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() +" (from: " + startTime.format(OUTPUT_FORMAT) + " to: " + endTime.format(OUTPUT_FORMAT) + " )";
    }
}