package com.lipy.miniapps.dto;

import com.lipy.miniapps.miniappslibrary.http.response.DateObj;

import java.util.List;

/**
 * 首页数据
 * Created by lipy on 2017/3/8 0008.
 */
public class HomeData implements DateObj {
    private HeadBean head;
    /**
     * type : 2
     * logo : http://v1.qzone.cc/avatar/201305/17/22/06/519639762c4e6138.jpg%21200x200.jpg
     * title : tb73399384
     * info : 1
     * price : $1200
     * text : 还在手动写繁锁的页面吗？GRUT让你脱离苦海.
     * from :  来自北京|新中关
     * zan : 5
     * url : ["http://img.mukewang.com/54f55ee60001850f05000280.jpg"]
     */

    private List<ListBean> list;

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class HeadBean {
        private List<String> ads;
        private List<String> middle;
        /**
         * title : 5个新ios课程
         * info : jack大拿发布
         * from : 来自上海的讲师
         * imageOne : http://i7.hexunimg.cn/2015-07-07/177346079.jpg
         * imageTwo : http://imgsrc.baidu.com/forum/w%3D580/sign=2ca8123a261f95caa6f592bef9167fc5/bc1cae51f81986188dd8f8c049ed2e738ad4e6da.jpg
         * destationUrl : http://www.imooc.com/learn/677
         */

        private List<FooterBean> footer;

        public List<String> getAds() {
            return ads;
        }

        public void setAds(List<String> ads) {
            this.ads = ads;
        }

        public List<String> getMiddle() {
            return middle;
        }

        public void setMiddle(List<String> middle) {
            this.middle = middle;
        }

        public List<FooterBean> getFooter() {
            return footer;
        }

        public void setFooter(List<FooterBean> footer) {
            this.footer = footer;
        }

        public static class FooterBean implements DateObj{
            private String title;
            private String info;
            private String from;
            private String imageOne;
            private String imageTwo;
            private String destationUrl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getFrom() {
                return from;
            }

            public void setFrom(String from) {
                this.from = from;
            }

            public String getImageOne() {
                return imageOne;
            }

            public void setImageOne(String imageOne) {
                this.imageOne = imageOne;
            }

            public String getImageTwo() {
                return imageTwo;
            }

            public void setImageTwo(String imageTwo) {
                this.imageTwo = imageTwo;
            }

            public String getDestationUrl() {
                return destationUrl;
            }

            public void setDestationUrl(String destationUrl) {
                this.destationUrl = destationUrl;
            }
        }
    }

    public static class ListBean implements DateObj{
        private int type;
        private String logo;
        private String title;
        private String info;
        private String price;
        private String text;
        private String from;
        private String zan;
        private List<String> url;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getZan() {
            return zan;
        }

        public void setZan(String zan) {
            this.zan = zan;
        }

        public List<String> getUrl() {
            return url;
        }

        public void setUrl(List<String> url) {
            this.url = url;
        }
    }

}
