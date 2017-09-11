package yuandu_common.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YuanduBaseException extends RuntimeException {

    private static Logger logger = LoggerFactory.getLogger(YuanduBaseException.class);

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg(){
        return msg;
    }

    public static void main(String[] args){

    }

    public YuanduBaseException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public YuanduBaseException(YuanduExceptionCode lifesenseExceptionCode){
        this.code = lifesenseExceptionCode.code();
        this.msg = lifesenseExceptionCode.msg();
    }

    public static void throwException(YuanduExceptionCode exceptionCode){
        YuanduBaseException baseException = new YuanduBaseException(exceptionCode);
        throw baseException;
    }

    public static void throwException(YuanduExceptionCode exceptionCode, String msg){
        YuanduBaseException baseException = new YuanduBaseException(exceptionCode);
        baseException.msg = msg;
        throw baseException;
    }




}
