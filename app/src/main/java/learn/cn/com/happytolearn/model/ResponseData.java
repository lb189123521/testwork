package learn.cn.com.happytolearn.model;


/**
 *
 */
public class ResponseData<T> {
    /**
     * "ReturnType":"true",
     * "ReturnMsg":"1",
     * "ReturnCount":"1"
     */
    private String code;
    private boolean ReturnType;
    private String ReturnMsg;
    private T ReturnData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getReturnType() {
        return ReturnType;
    }

    public void setReturnType(boolean returnType) {
        ReturnType = returnType;
    }

    public T getData() {
        return ReturnData;
    }

    public void setData(T data) {
        this.ReturnData = data;
    }

    public String getReturnMsg() {
        if ("1".equals(ReturnMsg)){
            return "成功";
        }else if ("2".equals(ReturnMsg)){
            return "账户不存在";
        }else if ("3".equals(ReturnMsg)){
            return "密码错误";
        }else if ("4".equals(ReturnMsg)){
            return "无权限登录";
        }else {
            return ReturnMsg;
        }

    }

    public void setReturnMsg(String returnMsg) {
        ReturnMsg = returnMsg;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code='" + code + '\'' +
                ", ReturnType='" + ReturnType + '\'' +
                ", ReturnMsg='" + ReturnMsg + '\'' +
                ", data=" + ReturnData +
                '}';
    }
}
