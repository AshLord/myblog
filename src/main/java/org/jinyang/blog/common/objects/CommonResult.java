package org.jinyang.blog.common.objects;

import org.jinyang.blog.common.enums.ErrorEnum;

/**
 * Created by ${yaoting.guo} on 2016/12/25.
 */
public class CommonResult<T> {
    //错误结果
    public ErrorEnum error;
    //错误消息
    public String errorMsg;
    //返回结果
    public T result;

    public CommonResult<T> retError(ErrorEnum error, String errorMsg){
        this.error=error;
        this.errorMsg=errorMsg;
        return this;
    }
    public CommonResult<T> retSucc(T object){
        this.result=object;
        this.error= ErrorEnum.SUCCESS;
        return this;
    }
    public boolean isError(){
        if(ErrorEnum.SUCCESS.getErrorCode()==error.getErrorCode())
            return false;
        return true;
    }

    public int getErrorCode() {
        return error.getErrorCode();
    }

    public ErrorEnum getError() {
        return error;
    }

    public void setError(ErrorEnum error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
