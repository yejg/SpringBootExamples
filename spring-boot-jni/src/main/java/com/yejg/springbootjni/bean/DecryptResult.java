package com.yejg.springbootjni.bean;

/**
 * @author yejg
 * @since 2020-07-01
 */
public class DecryptResult {

    private int code;

    private String fund_account;

    private String password;

    public DecryptResult() {
    }

    public DecryptResult(int code, String fund_account, String password) {
        this.code = code;
        this.fund_account = fund_account;
        this.password = password;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFund_account() {
        return fund_account;
    }

    public void setFund_account(String fund_account) {
        this.fund_account = fund_account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DecryptResult{");
        sb.append("code=").append(code);
        sb.append(", fund_account='").append(fund_account).append('\'');
        sb.append(", sPassword='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
