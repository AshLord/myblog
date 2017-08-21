package org.jinyang.blog.common.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @see 1打头表示公共应答码,2打头表示内部业务逻辑码,5位数10开头代表虚拟卡业务
 * Created by ${yaoting.guo} on 2016/12/25.
 */
public enum CodeEnum {

    NORMAL(0,"正常业务返回"),
    ;


    private final int code;
    private final String message;

    private CodeEnum(int _code, String _message){
        this.code = _code;
        this.message = _message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 通过枚举code获取对应的message
     * @return 取不到时返回null
     * @create 2015-6-8 下午3:41:47
     * @author 玄玉<http://blog.csdn.net/jadyer>
     */
    public static String getMessageByCode(int code){
        for(CodeEnum _enum : values()){
            if(_enum.getCode() == code){
                return _enum.getMessage();
            }
        }
        return null;
    }

    /**
     * 通过枚举code获取枚举对象
     * @return 取不到时返回null
     * @create 2015-6-3 下午9:32:51
     * @author 玄玉<http://blog.csdn.net/jadyer>
     */
    public static CodeEnum getByCode(int code){
        for(CodeEnum _enum : values()){
            if(_enum.getCode() == code){
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     * @return 取不到时返回空List,即new ArrayList<CodeEnum>()
     * @create 2015-6-3 下午9:35:17
     * @author 玄玉<http://blog.csdn.net/jadyer>
     */
    public List<CodeEnum> getAllEnum(){
        List<CodeEnum> list = new ArrayList<CodeEnum>();
        for(CodeEnum _enum : values()){
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举code
     * @return 取不到时返回空List,即new ArrayList<Integer>()
     * @create 2015-6-3 下午9:57:28
     * @author 玄玉<http://blog.csdn.net/jadyer>
     */
    public List<Integer> getAllEnumCode(){
        List<Integer> list = new ArrayList<Integer>();
        for(CodeEnum _enum : values()){
            list.add(_enum.getCode());
        }
        return list;
    }
}
