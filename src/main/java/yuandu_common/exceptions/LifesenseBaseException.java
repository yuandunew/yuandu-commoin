package yuandu_common.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifesenseBaseException extends RuntimeException {

    private static Logger logger = LoggerFactory.getLogger(LifesenseBaseException.class);

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

    public LifesenseBaseException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public LifesenseBaseException(LifesenseExceptionCode lifesenseExceptionCode){
        this.code = lifesenseExceptionCode.code();
        this.msg = lifesenseExceptionCode.msg();
    }

    public static void throwException(LifesenseExceptionCode exceptionCode){
        LifesenseBaseException baseException = new LifesenseBaseException(exceptionCode);
        throw baseException;
    }

    public static void throwException(LifesenseExceptionCode exceptionCode, String msg){
        LifesenseBaseException baseException = new LifesenseBaseException(exceptionCode);
        baseException.msg = msg;
        throw baseException;
    }




}
