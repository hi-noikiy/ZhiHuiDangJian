package com.lfc.zhihuidangjianapp.bean;

public class LoginBean {

    /**
     * code : 0
     * data : {"contextUrl":"http://119.3.248.222:8099/","realName":"赵真鹏","deptName":"中共山西涑水河源头省级自然保护区管理局支部委员会","imPwd":"zhdj-888888","loginName":"1002","roleName":"分级管理员","roeId":"08d925c2a200409b9480ab6b5a58259d","imgAddress":"PathHead/20190630/2ca1ed73-8da6-4fd4-96e7-1a1aaf7aa79e.jpeg","userId":"95c727d0e8a44fa7bbf1a5cdd3befca5","userCode":"1002","deptCode":"10011","token":"87729BE9EF7C7E6FA2DBEB7D427D7326"}
     * msg : 请求成功
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * contextUrl : http://119.3.248.222:8099/
         * realName : 赵真鹏
         * deptName : 中共山西涑水河源头省级自然保护区管理局支部委员会
         * imPwd : zhdj-888888
         * loginName : 1002
         * roleName : 分级管理员
         * roeId : 08d925c2a200409b9480ab6b5a58259d
         * imgAddress : PathHead/20190630/2ca1ed73-8da6-4fd4-96e7-1a1aaf7aa79e.jpeg
         * userId : 95c727d0e8a44fa7bbf1a5cdd3befca5
         * userCode : 1002
         * deptCode : 10011
         * token : 87729BE9EF7C7E6FA2DBEB7D427D7326
         */

        private String contextUrl;
        private String realName;
        private String deptName;
        private String imPwd;
        private String loginName;
        private String roleName;
        private String roeId;
        private String imgAddress;
        private String userId;
        private String userCode;
        private String deptCode;
        private String token;

        public String getContextUrl() {
            return contextUrl;
        }

        public void setContextUrl(String contextUrl) {
            this.contextUrl = contextUrl;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getImPwd() {
            return imPwd;
        }

        public void setImPwd(String imPwd) {
            this.imPwd = imPwd;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getRoeId() {
            return roeId;
        }

        public void setRoeId(String roeId) {
            this.roeId = roeId;
        }

        public String getImgAddress() {
            return imgAddress;
        }

        public void setImgAddress(String imgAddress) {
            this.imgAddress = imgAddress;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getDeptCode() {
            return deptCode;
        }

        public void setDeptCode(String deptCode) {
            this.deptCode = deptCode;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
