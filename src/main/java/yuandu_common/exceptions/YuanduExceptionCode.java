package yuandu_common.exceptions;

public enum YuanduExceptionCode {
    NULL(400,"对象为空"),
    UNKNOWN_ERROR(500,"系统繁忙，请稍后再试...."),
    PORT_IS_IN_USE(100,"当前串口已经被占用"),
    PORT_IS_NOT_SERIAL(101,"当前串口不是串口"),
    THIRD_SYSTEM_ERROR(102,"访问第三方系统异常"),
    PORT_SEND_ERROR(103,"写入串口错误"),
    PO_NOT_SAME(104,  "工单不一致"),
    PORT_CONNECT_ERROR(105,"链接串口错误"),
    PARAMS_ERROR(106,"参数错误"),
    PORT_IS_NOT_EXISTS(107,"当前串口不存在"),
    PORT_PARAMS_WRONG(109,"设置串口参数错误"),
    IO_WRONG(110,"IO流错误"),
    PORT_TOO_MANY_LISTENER(111,"串口监听太多"),
    ;

    private Integer code;
    private String msg;

    private YuanduExceptionCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }
}
