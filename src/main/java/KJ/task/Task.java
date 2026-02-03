package KJ.task;

/**
 * Abstract base class for all types of tasks in the KJ application
 */
public abstract class Task {
  protected final String description;
  protected boolean isDone;

  public Task(String description) {
    this.description = description;
    this.isDone = false;
  }

  /** @return [X] if done, [ ] otherwise. */
  public String getStatusIcon() {
    return (isDone ? "[X]" : "[ ]");
  }

  /** Marks task as completed. */
  public void markAsDone() {
    this.isDone = true;
  }

  /** Marks task as not completed. */
  public void markAsUndone() {
    this.isDone = false;
  }

  public abstract String toFileString();

  @Override
  public String toString() {
    return getStatusIcon() + " " + this.description;
  }
}