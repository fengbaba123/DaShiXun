package com.example.collegemessageonline.Controller.ShiTi.XiaoNeiXinXi;

import java.util.List;

/**
 * Created by 陆向阳 on 2017/7/13.
 */

public class Character {

    /**
     * state : true
     * message : 成功获取认证状态元数据！
     * size : 3
     * data : [{"id":1,"name":"学生"},{"id":2,"name":"教师"},{"id":4,"name":"辅导员"}]
     */

    private boolean state;
    private String message;
    private int size;
    private List<DataBean> data;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 学生
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
