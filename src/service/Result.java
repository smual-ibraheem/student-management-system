package service;

public class Result<T> {
    private final boolean success;
    private final String message;
    private final T data;

    private Result(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> ok(String message, T data) {
        return new Result<>(true, message, data);//Controlled creation...
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(false, message, null);//Controlled creation...
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
