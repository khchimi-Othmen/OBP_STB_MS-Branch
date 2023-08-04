package tn.stb.branch.Exception;

public class BankNotFoundException extends RuntimeException {
    private final ErrorCodes errorCode;

    public BankNotFoundException(ErrorCodes errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }
}