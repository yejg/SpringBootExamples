package io.ymq.swagger.model;

/**
 * @author yejg
 * @since 2019-08-27
 */
public class BaseResponse {

    private int errorCode = 0;
    private String errorInfo = "";
    private Object data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
