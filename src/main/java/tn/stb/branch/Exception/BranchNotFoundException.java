package tn.stb.branch.Exception;

public class BranchNotFoundException extends RuntimeException {
    private final ErrorCodes errorCode;

    public BranchNotFoundException(ErrorCodes errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }
}