package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.bean;

import java.util.List;

public class QueryAppConfigListBean1 {

    /**
     * code : 0
     * data : {"appConfigList":{"datas":[{"appConfigId":1,"beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561098327000,"endCreateDt":null,"groupByClause":null,"ifBanner":1,"isDeleteText":null,"isEnableText":null,"number":null,"orderByClause":null,"pageNumber":1,"pageSize":10,"path":"http://www.baidu.com","position":0,"remark":"admin2019-06-21 14:25:27执行修改操作---","startIndex":0,"title":"ere","type":null,"url":"Path/20190621/af519b1a-a4f5-4c5f-9f4b-de1058e7bf1e.jpeg"},{"appConfigId":2,"beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561098331000,"endCreateDt":null,"groupByClause":null,"ifBanner":0,"isDeleteText":null,"isEnableText":null,"number":0,"orderByClause":null,"pageNumber":1,"pageSize":10,"path":"http://www.baidu.com","position":0,"remark":"admin2019-06-21 14:25:31执行修改操作---","startIndex":0,"title":"e","type":0,"url":"Path/20190621/2c60f52a-f4b7-47ee-8dba-b0284cde9098.jpg"},{"appConfigId":3,"beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561098334000,"endCreateDt":null,"groupByClause":null,"ifBanner":0,"isDeleteText":null,"isEnableText":null,"number":1,"orderByClause":null,"pageNumber":1,"pageSize":10,"path":"http://www.baidu.com","position":0,"remark":"admin2019-06-21 14:25:34执行修改操作---","startIndex":0,"title":"w","type":1,"url":"Path/20190621/30f27373-d6c2-4f77-b9ff-b79ce4fc7bdd.jpeg"},{"appConfigId":4,"beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561098322000,"endCreateDt":null,"groupByClause":null,"ifBanner":1,"isDeleteText":null,"isEnableText":null,"number":0,"orderByClause":null,"pageNumber":1,"pageSize":10,"path":"http://www.baidu.com","position":1,"remark":null,"startIndex":0,"title":"w","type":0,"url":"Path/20190621/52147353-e56a-4586-8cb2-b90b362ccaf8.png"}],"isLastPage":true,"pageCount":1,"pageNumber":1,"pageSize":10,"total":4}}
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
         * appConfigList : {"datas":[{"appConfigId":1,"beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561098327000,"endCreateDt":null,"groupByClause":null,"ifBanner":1,"isDeleteText":null,"isEnableText":null,"number":null,"orderByClause":null,"pageNumber":1,"pageSize":10,"path":"http://www.baidu.com","position":0,"remark":"admin2019-06-21 14:25:27执行修改操作---","startIndex":0,"title":"ere","type":null,"url":"Path/20190621/af519b1a-a4f5-4c5f-9f4b-de1058e7bf1e.jpeg"},{"appConfigId":2,"beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561098331000,"endCreateDt":null,"groupByClause":null,"ifBanner":0,"isDeleteText":null,"isEnableText":null,"number":0,"orderByClause":null,"pageNumber":1,"pageSize":10,"path":"http://www.baidu.com","position":0,"remark":"admin2019-06-21 14:25:31执行修改操作---","startIndex":0,"title":"e","type":0,"url":"Path/20190621/2c60f52a-f4b7-47ee-8dba-b0284cde9098.jpg"},{"appConfigId":3,"beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561098334000,"endCreateDt":null,"groupByClause":null,"ifBanner":0,"isDeleteText":null,"isEnableText":null,"number":1,"orderByClause":null,"pageNumber":1,"pageSize":10,"path":"http://www.baidu.com","position":0,"remark":"admin2019-06-21 14:25:34执行修改操作---","startIndex":0,"title":"w","type":1,"url":"Path/20190621/30f27373-d6c2-4f77-b9ff-b79ce4fc7bdd.jpeg"},{"appConfigId":4,"beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561098322000,"endCreateDt":null,"groupByClause":null,"ifBanner":1,"isDeleteText":null,"isEnableText":null,"number":0,"orderByClause":null,"pageNumber":1,"pageSize":10,"path":"http://www.baidu.com","position":1,"remark":null,"startIndex":0,"title":"w","type":0,"url":"Path/20190621/52147353-e56a-4586-8cb2-b90b362ccaf8.png"}],"isLastPage":true,"pageCount":1,"pageNumber":1,"pageSize":10,"total":4}
         */

        private AppConfigListBean appConfigList;

        public AppConfigListBean getAppConfigList() {
            return appConfigList;
        }

        public void setAppConfigList(AppConfigListBean appConfigList) {
            this.appConfigList = appConfigList;
        }

        public static class AppConfigListBean {
            /**
             * datas : [{"appConfigId":1,"beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561098327000,"endCreateDt":null,"groupByClause":null,"ifBanner":1,"isDeleteText":null,"isEnableText":null,"number":null,"orderByClause":null,"pageNumber":1,"pageSize":10,"path":"http://www.baidu.com","position":0,"remark":"admin2019-06-21 14:25:27执行修改操作---","startIndex":0,"title":"ere","type":null,"url":"Path/20190621/af519b1a-a4f5-4c5f-9f4b-de1058e7bf1e.jpeg"},{"appConfigId":2,"beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561098331000,"endCreateDt":null,"groupByClause":null,"ifBanner":0,"isDeleteText":null,"isEnableText":null,"number":0,"orderByClause":null,"pageNumber":1,"pageSize":10,"path":"http://www.baidu.com","position":0,"remark":"admin2019-06-21 14:25:31执行修改操作---","startIndex":0,"title":"e","type":0,"url":"Path/20190621/2c60f52a-f4b7-47ee-8dba-b0284cde9098.jpg"},{"appConfigId":3,"beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561098334000,"endCreateDt":null,"groupByClause":null,"ifBanner":0,"isDeleteText":null,"isEnableText":null,"number":1,"orderByClause":null,"pageNumber":1,"pageSize":10,"path":"http://www.baidu.com","position":0,"remark":"admin2019-06-21 14:25:34执行修改操作---","startIndex":0,"title":"w","type":1,"url":"Path/20190621/30f27373-d6c2-4f77-b9ff-b79ce4fc7bdd.jpeg"},{"appConfigId":4,"beginCreateDt":null,"createCode":"admin","createName":"admin","createTime":1561098322000,"endCreateDt":null,"groupByClause":null,"ifBanner":1,"isDeleteText":null,"isEnableText":null,"number":0,"orderByClause":null,"pageNumber":1,"pageSize":10,"path":"http://www.baidu.com","position":1,"remark":null,"startIndex":0,"title":"w","type":0,"url":"Path/20190621/52147353-e56a-4586-8cb2-b90b362ccaf8.png"}]
             * isLastPage : true
             * pageCount : 1
             * pageNumber : 1
             * pageSize : 10
             * total : 4
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
                 * appConfigId : 1
                 * beginCreateDt : null
                 * createCode : admin
                 * createName : admin
                 * createTime : 1561098327000
                 * endCreateDt : null
                 * groupByClause : null
                 * ifBanner : 1
                 * isDeleteText : null
                 * isEnableText : null
                 * number : null
                 * orderByClause : null
                 * pageNumber : 1
                 * pageSize : 10
                 * path : http://www.baidu.com
                 * position : 0
                 * remark : admin2019-06-21 14:25:27执行修改操作---
                 * startIndex : 0
                 * title : ere
                 * type : null
                 * url : Path/20190621/af519b1a-a4f5-4c5f-9f4b-de1058e7bf1e.jpeg
                 */

                private int appConfigId;
                private Object beginCreateDt;
                private String createCode;
                private String createName;
                private long createTime;
                private Object endCreateDt;
                private Object groupByClause;
                private int ifBanner;
                private Object isDeleteText;
                private Object isEnableText;
                private Object number;
                private Object orderByClause;
                private int pageNumber;
                private int pageSize;
                private String path;
                private int position;
                private String remark;
                private int startIndex;
                private String title;
                private Object type;
                private String url;

                public int getAppConfigId() {
                    return appConfigId;
                }

                public void setAppConfigId(int appConfigId) {
                    this.appConfigId = appConfigId;
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

                public int getIfBanner() {
                    return ifBanner;
                }

                public void setIfBanner(int ifBanner) {
                    this.ifBanner = ifBanner;
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

                public Object getNumber() {
                    return number;
                }

                public void setNumber(Object number) {
                    this.number = number;
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

                public String getPath() {
                    return path;
                }

                public void setPath(String path) {
                    this.path = path;
                }

                public int getPosition() {
                    return position;
                }

                public void setPosition(int position) {
                    this.position = position;
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

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public Object getType() {
                    return type;
                }

                public void setType(Object type) {
                    this.type = type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
