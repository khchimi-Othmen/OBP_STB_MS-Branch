package tn.stb.branch.Exception;

public class UnknownError extends RuntimeException {
    private final ErrorCodes errorCode;

    public UnknownError(ErrorCodes errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }
}