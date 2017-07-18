package com.example.collegemessageonline.Controller.ShiTi;

/**
 * Created by 陆向阳 on 2017/7/12.
 */

public class LoginShiTi {

    /**
     * state : true
     * message : 登录成功！
     * data : {"certflag":2,"sex":null,"userid":9993551,"city":"满洲里","loginname":"epEqgiG44V","username":"陆向阳","deptid":null,"gradeyear":null,"univname":"满洲里俄语职业学院","province":"内蒙古","dept":null,"classid":null,"userlogo":"http://img.univs.cn/logo/999/user/9993551.jpg","nickname":"陆向阳","toUrl":"","classname":null,"utvalue":"学生","provinceid":18,"usertype":1,"userauth":"570c2cd61d1adc7e2867611aa44e3cbd","cityid":1377,"univid":3667,"email":"2512420282@qq.com","userauth_top":"MTg3OTc1MgllcEVxZ2lHNDRWCTNmSkp3M1hWN2RZOWdPeGRLbmlGbE9zYTJtTWJrTEJYVHd0Ng==","mobile":null}
     */

    private boolean state;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * certflag : 2
         * sex : null
         * userid : 9993551
         * city : 满洲里
         * loginname : epEqgiG44V
         * username : 陆向阳
         * deptid : null
         * gradeyear : null
         * univname : 满洲里俄语职业学院
         * province : 内蒙古
         * dept : null
         * classid : null
         * userlogo : http://img.univs.cn/logo/999/user/9993551.jpg
         * nickname : 陆向阳
         * toUrl :
         * classname : null
         * utvalue : 学生
         * provinceid : 18
         * usertype : 1
         * userauth : 570c2cd61d1adc7e2867611aa44e3cbd
         * cityid : 1377
         * univid : 3667
         * email : 2512420282@qq.com
         * userauth_top : MTg3OTc1MgllcEVxZ2lHNDRWCTNmSkp3M1hWN2RZOWdPeGRLbmlGbE9zYTJtTWJrTEJYVHd0Ng==
         * mobile : null
         */

        private int certflag;
        private Object sex;
        private int userid;
        private String city;
        private String loginname;
        private String username;
        private Object deptid;
        private Object gradeyear;
        private String univname;
        private String province;
        private Object dept;
        private Object classid;
        private String userlogo;
        private String nickname;
        private String toUrl;
        private Object classname;
        private String utvalue;
        private int provinceid;
        private int usertype;
        private String userauth;
        private int cityid;
        private int univid;
        private String email;
        private String userauth_top;
        private Object mobile;

        public int getCertflag() {
            return certflag;
        }

        public void setCertflag(int certflag) {
            this.certflag = certflag;
        }

        public Object getSex() {
            return sex;
        }

        public void setSex(Object sex) {
            this.sex = sex;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getLoginname() {
            return loginname;
        }

        public void setLoginname(String loginname) {
            this.loginname = loginname;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Object getDeptid() {
            return deptid;
        }

        public void setDeptid(Object deptid) {
            this.deptid = deptid;
        }

        public Object getGradeyear() {
            return gradeyear;
        }

        public void setGradeyear(Object gradeyear) {
            this.gradeyear = gradeyear;
        }

        public String getUnivname() {
            return univname;
        }

        public void setUnivname(String univname) {
            this.univname = univname;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public Object getDept() {
            return dept;
        }

        public void setDept(Object dept) {
            this.dept = dept;
        }

        public Object getClassid() {
            return classid;
        }

        public void setClassid(Object classid) {
            this.classid = classid;
        }

        public String getUserlogo() {
            return userlogo;
        }

        public void setUserlogo(String userlogo) {
            this.userlogo = userlogo;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getToUrl() {
            return toUrl;
        }

        public void setToUrl(String toUrl) {
            this.toUrl = toUrl;
        }

        public Object getClassname() {
            return classname;
        }

        public void setClassname(Object classname) {
            this.classname = classname;
        }

        public String getUtvalue() {
            return utvalue;
        }

        public void setUtvalue(String utvalue) {
            this.utvalue = utvalue;
        }

        public int getProvinceid() {
            return provinceid;
        }

        public void setProvinceid(int provinceid) {
            this.provinceid = provinceid;
        }

        public int getUsertype() {
            return usertype;
        }

        public void setUsertype(int usertype) {
            this.usertype = usertype;
        }

        public String getUserauth() {
            return userauth;
        }

        public void setUserauth(String userauth) {
            this.userauth = userauth;
        }

        public int getCityid() {
            return cityid;
        }

        public void setCityid(int cityid) {
            this.cityid = cityid;
        }

        public int getUnivid() {
            return univid;
        }

        public void setUnivid(int univid) {
            this.univid = univid;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUserauth_top() {
            return userauth_top;
        }

        public void setUserauth_top(String userauth_top) {
            this.userauth_top = userauth_top;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }
    }
}
