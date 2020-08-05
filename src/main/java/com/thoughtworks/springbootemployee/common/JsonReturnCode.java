package com.thoughtworks.springbootemployee.common;

public enum JsonReturnCode {
    SUCCESS("200", "succeed"),
    FAIL("500", "fail"),
    SERVICE_UNAVAILABLE("503", "Unable to provide services"),
    ACCESS_ERROR("403", "Access forbidden"),
    NOT_FOUND("404", "The resource does not exist"),
    ILLEGAL_ARGUMEN("400", "Error parameters");
    private String code;
    private String desc;

    JsonReturnCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
