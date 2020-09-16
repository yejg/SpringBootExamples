package io.ymq.swagger.model;

/**
 * @author yejg
 * @since 2019-08-28
 */
public class BaseResponse2 {

    private int errorCode = 0;
    private String errorInfo = "";

    private TestResponse data;

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

    public TestResponse getData() {
        return data;
    }

    public void setData(TestResponse data) {
        this.data = data;
    }
}
