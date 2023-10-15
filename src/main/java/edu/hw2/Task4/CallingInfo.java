package edu.hw2.Task4;

@SuppressWarnings("MagicNumber")
public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length >= 3) {
            StackTraceElement caller = stackTrace[2];
            String className = caller.getClassName();
            String methodName = caller.getMethodName();
            return new CallingInfo(className, methodName);
        }
        return null;
    }
}
