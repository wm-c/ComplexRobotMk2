package tasks;

public interface Task<T> {
    T execute();
}