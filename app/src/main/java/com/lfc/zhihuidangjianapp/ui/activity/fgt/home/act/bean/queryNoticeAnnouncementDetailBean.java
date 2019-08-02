package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.bean;

public class queryNoticeAnnouncementDetailBean {

    /**
     * code : 0
     * data : {"noticeAnnouncement":{"announcementComtent":"<p>撒打算的撒大所<\/p>","announcementTitle":"测试1","announcementType":1,"author":"admin","beginCreateDt":null,"createCode":"1001","createName":"admin","createTime":1559349859000,"department":null,"departmentCode":null,"endCreateDt":null,"groupByClause":null,"idList":null,"ifPass":0,"ifTop":1,"isDeleteText":null,"isEnableText":null,"noticeAnnouncementId":1,"orderByClause":null,"pageNumber":1,"pageSize":10,"releaseDate":"2019-05-14","remark":"小张2019-05-15 20:01:51执行修改操作---","startIndex":0,"topNum":null,"urlList":null}}
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
         * noticeAnnouncement : {"announcementComtent":"<p>撒打算的撒大所<\/p>","announcementTitle":"测试1","announcementType":1,"author":"admin","beginCreateDt":null,"createCode":"1001","createName":"admin","createTime":1559349859000,"department":null,"departmentCode":null,"endCreateDt":null,"groupByClause":null,"idList":null,"ifPass":0,"ifTop":1,"isDeleteText":null,"isEnableText":null,"noticeAnnouncementId":1,"orderByClause":null,"pageNumber":1,"pageSize":10,"releaseDate":"2019-05-14","remark":"小张2019-05-15 20:01:51执行修改操作---","startIndex":0,"topNum":null,"urlList":null}
         */

        private NoticeAnnouncementBean noticeAnnouncement;

        public NoticeAnnouncementBean getNoticeAnnouncement() {
            return noticeAnnouncement;
        }

        public void setNoticeAnnouncement(NoticeAnnouncementBean noticeAnnouncement) {
            this.noticeAnnouncement = noticeAnnouncement;
        }

        public static class NoticeAnnouncementBean {
            /**
             * announcementComtent : <p>撒打算的撒大所</p>
             * announcementTitle : 测试1
             * announcementType : 1
             * author : admin
             * beginCreateDt : null
             * createCode : 1001
             * createName : admin
             * createTime : 1559349859000
             * department : null
             * departmentCode : null
             * endCreateDt : null
             * groupByClause : null
             * idList : null
             * ifPass : 0
             * ifTop : 1
             * isDeleteText : null
             * isEnableText : null
             * noticeAnnouncementId : 1
             * orderByClause : null
             * pageNumber : 1
             * pageSize : 10
             * releaseDate : 2019-05-14
             * remark : 小张2019-05-15 20:01:51执行修改操作---
             * startIndex : 0
             * topNum : null
             * urlList : null
             */

            private String announcementComtent;
            private String announcementTitle;
            private int announcementType;
            private String author;
            private Object beginCreateDt;
            private String createCode;
            private String createName;
            private long createTime;
            private Object department;
            private Object departmentCode;
            private Object endCreateDt;
            private Object groupByClause;
            private Object idList;
            private int ifPass;
            private int ifTop;
            private Object isDeleteText;
            private Object isEnableText;
            private int noticeAnnouncementId;
            private Object orderByClause;
            private int pageNumber;
            private int pageSize;
            private String releaseDate;
            private String remark;
            private int startIndex;
            private Object topNum;
            private Object urlList;

            public String getAnnouncementComtent() {
                return announcementComtent;
            }

            public void setAnnouncementComtent(String announcementComtent) {
                this.announcementComtent = announcementComtent;
            }

            public String getAnnouncementTitle() {
                return announcementTitle;
            }

            public void setAnnouncementTitle(String announcementTitle) {
                this.announcementTitle = announcementTitle;
            }

            public int getAnnouncementType() {
                return announcementType;
            }

            public void setAnnouncementType(int announcementType) {
                this.announcementType = announcementType;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public Object getBeginCreateDt() {
                return beginCreateDt;
            }

            public void setBeginCreateDt(Object beginCreateDt) {
                this.beginCreateDt = beginCreateDt;
            }

            public String getCreateCode() {
                return createCode;
            }

            public void setCreateCode(String createCode) {
                this.createCode = createCode;
            }

            public String getCreateName() {
                return createName;
            }

            public void setCreateName(String createName) {
                this.createName = createName;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public Object getDepartment() {
                return department;
            }

            public void setDepartment(Object department) {
                this.department = department;
            }

            public Object getDepartmentCode() {
                return departmentCode;
            }

            public void setDepartmentCode(Object departmentCode) {
                this.departmentCode = departmentCode;
            }

            public Object getEndCreateDt() {
                return endCreateDt;
            }

            public void setEndCreateDt(Object endCreateDt) {
                this.endCreateDt = endCreateDt;
            }

            public Object getGroupByClause() {
                return groupByClause;
            }

            public void setGroupByClause(Object groupByClause) {
                this.groupByClause = groupByClause;
            }

            public Object getIdList() {
                return idList;
            }

            public void setIdList(Object idList) {
                this.idList = idList;
            }

            public int getIfPass() {
                return ifPass;
            }

            public void setIfPass(int ifPass) {
                this.ifPass = ifPass;
            }

            public int getIfTop() {
                return ifTop;
            }

            public void setIfTop(int ifTop) {
                this.ifTop = ifTop;
            }

            public Object getIsDeleteText() {
                return isDeleteText;
            }

            public void setIsDeleteText(Object isDeleteText) {
                this.isDeleteText = isDeleteText;
            }

            public Object getIsEnableText() {
                return isEnableText;
            }

            public void setIsEnableText(Object isEnableText) {
                this.isEnableText = isEnableText;
            }

            public int getNoticeAnnouncementId() {
                return noticeAnnouncementId;
            }

            public void setNoticeAnnouncementId(int noticeAnnouncementId) {
                this.noticeAnnouncementId = noticeAnnouncementId;
            }

            public Object getOrderByClause() {
                return orderByClause;
            }

            public void setOrderByClause(Object orderByClause) {
                this.orderByClause = orderByClause;
            }

            public int getPageNumber() {
                return pageNumber;
            }

            public void setPageNumber(int pageNumber) {
                this.pageNumber = pageNumber;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public String getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(String releaseDate) {
                this.releaseDate = releaseDate;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getStartIndex() {
                return startIndex;
            }

            public void setStartIndex(int startIndex) {
                this.startIndex = startIndex;
            }

            public Object getTopNum() {
                return topNum;
            }

            public void setTopNum(Object topNum) {
                this.topNum = topNum;
            }

            public Object getUrlList() {
                return urlList;
            }

            public void setUrlList(Object urlList) {
                this.urlList = urlList;
            }
        }
    }
}
