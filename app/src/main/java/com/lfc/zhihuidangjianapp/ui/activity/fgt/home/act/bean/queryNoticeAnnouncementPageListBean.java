package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.bean;

import java.util.List;

public class queryNoticeAnnouncementPageListBean {
    /**
     * code : 0
     * data : {"noticeAnnouncementList":{"datas":[{"announcementComtent":"<p>\t<span style=\"background-color: rgb(255, 255, 255); color: rgb(0, 0, 0);\">新华社大阪6月28日电（记者刘华 商洋）国家主席习近平28日在大阪会见联合国秘书长古特雷斯。<\/span><\/p>","announcementTitle":"<测试>习近平会见联合国秘书长古特雷斯","announcementType":0,"author":"M","beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561706465000,"department":"中共山西省中条山国有林管理局委员会","departmentCode":"DT000001","endCreateDt":null,"groupByClause":null,"idList":null,"ifPass":0,"ifTop":0,"isDeleteText":null,"isEnableText":null,"noticeAnnouncementId":15,"orderByClause":null,"pageNumber":1,"pageSize":10,"releaseDate":"2019-06-28","remark":null,"startIndex":0,"topNum":4,"urlList":null},{"announcementComtent":"<p>\t根据国务院扶贫开发领导小组印发的《2019年全国脱贫攻坚奖评选表彰工作方案》，经全国脱贫攻坚奖评选委员会初次评审，以下140名人选和59个单位作为2019年全国脱贫攻坚奖初评候选人（单位），现予以公示。<\/p><p>\t如对候选人（单位）有异议，请通过全国扶贫监督举报电话010-12317进行反映。受理时间为上午８：30至1２：00，下午13:00至17:00。公示截止时间为2019年7月1日17:00。<\/p>","announcementTitle":"<测试>2019年全国脱贫攻坚奖初评候选人（单位）公示公告","announcementType":0,"author":"M","beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561706463000,"department":"中共山西省中条山国有林管理局委员会","departmentCode":"DT000001","endCreateDt":null,"groupByClause":null,"idList":null,"ifPass":0,"ifTop":0,"isDeleteText":null,"isEnableText":null,"noticeAnnouncementId":16,"orderByClause":null,"pageNumber":1,"pageSize":10,"releaseDate":"2019-06-28","remark":null,"startIndex":0,"topNum":3,"urlList":null}],"isLastPage":true,"pageCount":1,"pageNumber":1,"pageSize":10,"total":2}}
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
         * noticeAnnouncementList : {"datas":[{"announcementComtent":"<p>\t<span style=\"background-color: rgb(255, 255, 255); color: rgb(0, 0, 0);\">新华社大阪6月28日电（记者刘华 商洋）国家主席习近平28日在大阪会见联合国秘书长古特雷斯。<\/span><\/p>","announcementTitle":"<测试>习近平会见联合国秘书长古特雷斯","announcementType":0,"author":"M","beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561706465000,"department":"中共山西省中条山国有林管理局委员会","departmentCode":"DT000001","endCreateDt":null,"groupByClause":null,"idList":null,"ifPass":0,"ifTop":0,"isDeleteText":null,"isEnableText":null,"noticeAnnouncementId":15,"orderByClause":null,"pageNumber":1,"pageSize":10,"releaseDate":"2019-06-28","remark":null,"startIndex":0,"topNum":4,"urlList":null},{"announcementComtent":"<p>\t根据国务院扶贫开发领导小组印发的《2019年全国脱贫攻坚奖评选表彰工作方案》，经全国脱贫攻坚奖评选委员会初次评审，以下140名人选和59个单位作为2019年全国脱贫攻坚奖初评候选人（单位），现予以公示。<\/p><p>\t如对候选人（单位）有异议，请通过全国扶贫监督举报电话010-12317进行反映。受理时间为上午８：30至1２：00，下午13:00至17:00。公示截止时间为2019年7月1日17:00。<\/p>","announcementTitle":"<测试>2019年全国脱贫攻坚奖初评候选人（单位）公示公告","announcementType":0,"author":"M","beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561706463000,"department":"中共山西省中条山国有林管理局委员会","departmentCode":"DT000001","endCreateDt":null,"groupByClause":null,"idList":null,"ifPass":0,"ifTop":0,"isDeleteText":null,"isEnableText":null,"noticeAnnouncementId":16,"orderByClause":null,"pageNumber":1,"pageSize":10,"releaseDate":"2019-06-28","remark":null,"startIndex":0,"topNum":3,"urlList":null}],"isLastPage":true,"pageCount":1,"pageNumber":1,"pageSize":10,"total":2}
         */

        private NoticeAnnouncementListBean noticeAnnouncementList;

        public NoticeAnnouncementListBean getNoticeAnnouncementList() {
            return noticeAnnouncementList;
        }

        public void setNoticeAnnouncementList(NoticeAnnouncementListBean noticeAnnouncementList) {
            this.noticeAnnouncementList = noticeAnnouncementList;
        }

        public static class NoticeAnnouncementListBean {
            /**
             * datas : [{"announcementComtent":"<p>\t<span style=\"background-color: rgb(255, 255, 255); color: rgb(0, 0, 0);\">新华社大阪6月28日电（记者刘华 商洋）国家主席习近平28日在大阪会见联合国秘书长古特雷斯。<\/span><\/p>","announcementTitle":"<测试>习近平会见联合国秘书长古特雷斯","announcementType":0,"author":"M","beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561706465000,"department":"中共山西省中条山国有林管理局委员会","departmentCode":"DT000001","endCreateDt":null,"groupByClause":null,"idList":null,"ifPass":0,"ifTop":0,"isDeleteText":null,"isEnableText":null,"noticeAnnouncementId":15,"orderByClause":null,"pageNumber":1,"pageSize":10,"releaseDate":"2019-06-28","remark":null,"startIndex":0,"topNum":4,"urlList":null},{"announcementComtent":"<p>\t根据国务院扶贫开发领导小组印发的《2019年全国脱贫攻坚奖评选表彰工作方案》，经全国脱贫攻坚奖评选委员会初次评审，以下140名人选和59个单位作为2019年全国脱贫攻坚奖初评候选人（单位），现予以公示。<\/p><p>\t如对候选人（单位）有异议，请通过全国扶贫监督举报电话010-12317进行反映。受理时间为上午８：30至1２：00，下午13:00至17:00。公示截止时间为2019年7月1日17:00。<\/p>","announcementTitle":"<测试>2019年全国脱贫攻坚奖初评候选人（单位）公示公告","announcementType":0,"author":"M","beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561706463000,"department":"中共山西省中条山国有林管理局委员会","departmentCode":"DT000001","endCreateDt":null,"groupByClause":null,"idList":null,"ifPass":0,"ifTop":0,"isDeleteText":null,"isEnableText":null,"noticeAnnouncementId":16,"orderByClause":null,"pageNumber":1,"pageSize":10,"releaseDate":"2019-06-28","remark":null,"startIndex":0,"topNum":3,"urlList":null}]
             * isLastPage : true
             * pageCount : 1
             * pageNumber : 1
             * pageSize : 10
             * total : 2
             */

            private boolean isLastPage;
            private int pageCount;
            private int pageNumber;
            private int pageSize;
            private int total;
            private List<DatasBean> datas;

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public int getPageCount() {
                return pageCount;
            }

            public void setPageCount(int pageCount) {
                this.pageCount = pageCount;
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

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<DatasBean> getDatas() {
                return datas;
            }

            public void setDatas(List<DatasBean> datas) {
                this.datas = datas;
            }

            public static class DatasBean {
                /**
                 * announcementComtent : <p>	<span style="background-color: rgb(255, 255, 255); color: rgb(0, 0, 0);">新华社大阪6月28日电（记者刘华 商洋）国家主席习近平28日在大阪会见联合国秘书长古特雷斯。</span></p>
                 * announcementTitle : <测试>习近平会见联合国秘书长古特雷斯
                 * announcementType : 0
                 * author : M
                 * beginCreateDt : null
                 * createCode : admin
                 * createName : admin
                 * createTime : 1561706465000
                 * department : 中共山西省中条山国有林管理局委员会
                 * departmentCode : DT000001
                 * endCreateDt : null
                 * groupByClause : null
                 * idList : null
                 * ifPass : 0
                 * ifTop : 0
                 * isDeleteText : null
                 * isEnableText : null
                 * noticeAnnouncementId : 15
                 * orderByClause : null
                 * pageNumber : 1
                 * pageSize : 10
                 * releaseDate : 2019-06-28
                 * remark : null
                 * startIndex : 0
                 * topNum : 4
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
                private String department;
                private String departmentCode;
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
                private Object remark;
                private int startIndex;
                private int topNum;
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

                public String getDepartment() {
                    return department;
                }

                public void setDepartment(String department) {
                    this.department = department;
                }

                public String getDepartmentCode() {
                    return departmentCode;
                }

                public void setDepartmentCode(String departmentCode) {
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

                public Object getRemark() {
                    return remark;
                }

                public void setRemark(Object remark) {
                    this.remark = remark;
                }

                public int getStartIndex() {
                    return startIndex;
                }

                public void setStartIndex(int startIndex) {
                    this.startIndex = startIndex;
                }

                public int getTopNum() {
                    return topNum;
                }

                public void setTopNum(int topNum) {
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
}
