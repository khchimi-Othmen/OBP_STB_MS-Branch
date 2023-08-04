package tn.stb.branch.Exception;

public enum ErrorCodes {
    OBP_UNKNOWN_ERROR(50000, "Unknown Error."),
    OBP_BANK_NOT_FOUND(30001, "Bank not found. Please specify a valid value for BANK_ID."),
    OBP_BRANCH_NOT_FOUND(30010, " Branch not found. Please specify a valid value for BRANCH_ID. Or License may not be set. meta.license.id and meta.license.name can not be empty");

    private final int errorCode;
    private final String errorMessage;

    ErrorCodes(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
