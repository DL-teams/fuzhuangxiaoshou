package priv.jesse.mall.entity.pojo;

import java.io.Serializable;

/**
 * 接口返回数据模型
 *
 * @author hzl
 * @date 2022/8/1
 */
//一个对象序列化的接口，一个类只有实现了Serializable接口，它的对象才能被序列化。
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = -6248298306422072592L;
    /**
     * 表示接口调用成功
     */
    public static final int SUCCESS = 0;
    /**
     * 表示接口调用失败
     */
    public static final int FAIL = 1;
    /**
     * 表示没有权限调用该接口
     */
    public static final int NO_PERMISSION = 2;

    public static final String NO_LOGIN_MSG = "未登录";
    public static final String NO_PERMISSION_MSG = "没有权限";
    public static final String SUCC_MSG = "成功";
    public static final String FAIL_MSG = "失败";

    private String message = SUCC_MSG;
    private int state = SUCCESS;
    /**
     * 返回的数据
     */
    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    /**
     * 包装异常信息
     *
     * @param e
     */
    public ResultBean(Throwable e) {
        super();
        this.message = e.getMessage();
        this.state = FAIL;
    }

    public ResultBean(String message) {
        super();
        this.message = message;
        this.state = FAIL;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "message='" + message + '\'' +
                ", state=" + state +
                ", data=" + data +
                '}';
    }
}
