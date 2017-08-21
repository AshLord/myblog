package org.jinyang.blog.common.enums;

/**
 * Created by ${yaoting.guo} on 2016/12/29.
 */
public enum ErrorEnum {

    SUCCESS(0, "成功", CodeEnum.NORMAL),
    ;

    private int errorCode;
    private String errorMsg;
    private CodeEnum codeEnum;

    private ErrorEnum(int errorCode, String errorMsg, CodeEnum codeEnum) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.codeEnum = codeEnum;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public CodeEnum getCodeEnum() {
        return codeEnum;
    }

    public void setCodeEnum(CodeEnum codeEnum) {
        this.codeEnum = codeEnum;
    }
}
