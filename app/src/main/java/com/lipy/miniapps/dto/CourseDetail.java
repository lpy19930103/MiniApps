package com.lipy.miniapps.dto;

import com.lipy.miniapps.miniappslibrary.http.response.DateObj;

import java.util.List;

/**
 * Created by lipy on 2017/3/6.
 */

public class CourseDetail implements DateObj {


    /**
     * head : {"text":"在当今的互联网时代，数据是一切应用的核心和基础，有数据的地方就存在安全隐患。在Java领域，我们可以使用Java加密解密技术来提高数据的安全性。本计划从基础入手，为小伙伴们带来了多种Java加解密算法的实现。还等什么，赶快来参加吧！","name":"狼在北京","logo":"http://img3.duitang.com/uploads/item/201407/01/20140701222607_AnKfj.thumb.224_0.jpeg","photoUrls":["http://img.mukewang.com/5465af0c0001bb6706000338-590-330.jpg","http://edu.sxgov.cn/image/attachement/png/site2/20160125/5cac4c73d2dd1810106661.png","http://ww1.sinaimg.cn/large/c5131475jw1ez7hdfvu87j20fk078myc.jpg"],"oldPrice":"￥30.00","newPrice":"￥15.00","zan":"3人点赞","scan":"506人浏览","hotComment":"热门留言(7)","from":"来自北京","dayTime":"3天前","video":{"resource":"http://fairee.vicp.net:83/2016rm/0116/baishi160116.mp4","adid":"00000001112","clickUrl":"http://www.imooc.com/","clickMonitor":[{"ver":"0","url":"http://imooc.com/click??click=1"},{"ver":"0","url":"http://imooc.com/click?click=2"}],"startMonitor":[{"ver":"0","url":"http://imooc.com/show?impression=1"},{"ver":"0","url":"http: //imooc.com/show?impression=2"}],"middleMonitor":[{"ver":"0","url":"http://imooc.com/show?SU=1","time":5},{"ver":"0","url":"http: //imooc.com/show?impression=2","time":5}],"endMonitor":[{"ver":"0","url":"http://imooc.com/show?end=1","time":5},{"ver":"0","url":"http: //imooc.com/show?end=2","time":5}]}}
     * body : [{"type":0,"name":"狼在北京","logo":"http://img3.duitang.com/uploads/item/201407/01/20140701222607_AnKfj.thumb.224_0.jpeg","text":"回复@偏执的柔情:多谢支持，继续支持我哈","userId":"0001"},{"type":1,"name":"偏执的柔情","logo":"http://tupian.qqjay.com/tou3/2016/0619/33ce4ff3e468e1c27535ea0c9cb424d5.jpg","text":"课程非常好","userId":"0002"},{"type":1,"name":"哈雷路亚","logo":"http://img2.imgtn.bdimg.com/it/u=477212778,1276839182&fm=21&gp=0.jpg","text":"良心课程,老师多多出课啊","userId":"0003"},{"type":1,"name":"麿麿816","logo":"http://img1.2345.com/duoteimg/qqTxImg/2/785e8d5ad17c0fadcc9595b4795d4e20.png","text":"老师学习遇到点问题，可以加您QQ吗","userId":"0004"},{"type":0,"name":"狼在北京","logo":"http://img3.duitang.com/uploads/item/201407/01/20140701222607_AnKfj.thumb.224_0.jpeg","text":"回复@jialiyuan333:可以的。","userId":"0001"},{"type":1,"name":"jialiyuan333","logo":"http://www.th7.cn/d/file/p/2016/07/26/22cfcf2f8cd0906976e99ec2a7434e92.jpg","text":"老师有没有demo,发我一份"},{"type":1,"name":"帅帅","logo":"http://img0.pconline.com.cn/pconline/1308/07/3417256_co130i1141025-171.jpg","text":"求源码,求源码,求源码","userId":"0005"}]
     * footer : {"recommand":[{"imageUrl":"http://it.enorth.com.cn/pic2014/002/000/092/00200009288_502cc21c.png","name":"5天学会IM","price":"￥23","zan":"3赞    5评论","courseId":"01112"},{"imageUrl":"http://img1.cache.netease.com/hebei/2014/3/25/20140325092345399eb_550.jpg","name":"MySQL从入门到精通","price":"￥54","zan":"10赞   4评论","courseId":"01114"}],"time":[{"dt":"1473264000","count":"40"},{"dt":"1473177600","count":"30"},{"dt":"1473091200","count":"70"},{"dt":"1473004800","count":"90"},{"dt":"1472918400","count":"70"},{"dt":"1472745600","count":"101"},{"dt":"1472659200","count":"20"}]}
     */

    private HeadBean head;
    private FooterBean footer;
    private List<BodyBean> body;

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public FooterBean getFooter() {
        return footer;
    }

    public void setFooter(FooterBean footer) {
        this.footer = footer;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class HeadBean implements DateObj {
        /**
         * text : 在当今的互联网时代，数据是一切应用的核心和基础，有数据的地方就存在安全隐患。在Java领域，我们可以使用Java加密解密技术来提高数据的安全性。本计划从基础入手，为小伙伴们带来了多种Java加解密算法的实现。还等什么，赶快来参加吧！
         * name : 狼在北京
         * logo : http://img3.duitang.com/uploads/item/201407/01/20140701222607_AnKfj.thumb.224_0.jpeg
         * photoUrls : ["http://img.mukewang.com/5465af0c0001bb6706000338-590-330.jpg","http://edu.sxgov.cn/image/attachement/png/site2/20160125/5cac4c73d2dd1810106661.png","http://ww1.sinaimg.cn/large/c5131475jw1ez7hdfvu87j20fk078myc.jpg"]
         * oldPrice : ￥30.00
         * newPrice : ￥15.00
         * zan : 3人点赞
         * scan : 506人浏览
         * hotComment : 热门留言(7)
         * from : 来自北京
         * dayTime : 3天前
         * video : {"resource":"http://fairee.vicp.net:83/2016rm/0116/baishi160116.mp4","adid":"00000001112","clickUrl":"http://www.imooc.com/","clickMonitor":[{"ver":"0","url":"http://imooc.com/click??click=1"},{"ver":"0","url":"http://imooc.com/click?click=2"}],"startMonitor":[{"ver":"0","url":"http://imooc.com/show?impression=1"},{"ver":"0","url":"http: //imooc.com/show?impression=2"}],"middleMonitor":[{"ver":"0","url":"http://imooc.com/show?SU=1","time":5},{"ver":"0","url":"http: //imooc.com/show?impression=2","time":5}],"endMonitor":[{"ver":"0","url":"http://imooc.com/show?end=1","time":5},{"ver":"0","url":"http: //imooc.com/show?end=2","time":5}]}
         */

        private String text;
        private String name;
        private String logo;
        private String oldPrice;
        private String newPrice;
        private String zan;
        private String scan;
        private String hotComment;
        private String from;
        private String dayTime;
        private VideoBean video;
        private List<String> photoUrls;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(String oldPrice) {
            this.oldPrice = oldPrice;
        }

        public String getNewPrice() {
            return newPrice;
        }

        public void setNewPrice(String newPrice) {
            this.newPrice = newPrice;
        }

        public String getZan() {
            return zan;
        }

        public void setZan(String zan) {
            this.zan = zan;
        }

        public String getScan() {
            return scan;
        }

        public void setScan(String scan) {
            this.scan = scan;
        }

        public String getHotComment() {
            return hotComment;
        }

        public void setHotComment(String hotComment) {
            this.hotComment = hotComment;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getDayTime() {
            return dayTime;
        }

        public void setDayTime(String dayTime) {
            this.dayTime = dayTime;
        }

        public VideoBean getVideo() {
            return video;
        }

        public void setVideo(VideoBean video) {
            this.video = video;
        }

        public List<String> getPhotoUrls() {
            return photoUrls;
        }

        public void setPhotoUrls(List<String> photoUrls) {
            this.photoUrls = photoUrls;
        }

        public static class VideoBean implements DateObj {
            /**
             * resource : http://fairee.vicp.net:83/2016rm/0116/baishi160116.mp4
             * adid : 00000001112
             * clickUrl : http://www.imooc.com/
             * clickMonitor : [{"ver":"0","url":"http://imooc.com/click??click=1"},{"ver":"0","url":"http://imooc.com/click?click=2"}]
             * startMonitor : [{"ver":"0","url":"http://imooc.com/show?impression=1"},{"ver":"0","url":"http: //imooc.com/show?impression=2"}]
             * middleMonitor : [{"ver":"0","url":"http://imooc.com/show?SU=1","time":5},{"ver":"0","url":"http: //imooc.com/show?impression=2","time":5}]
             * endMonitor : [{"ver":"0","url":"http://imooc.com/show?end=1","time":5},{"ver":"0","url":"http: //imooc.com/show?end=2","time":5}]
             */

            private String resource;
            private String adid;
            private String clickUrl;
            private List<ClickMonitorBean> clickMonitor;
            private List<StartMonitorBean> startMonitor;
            private List<MiddleMonitorBean> middleMonitor;
            private List<EndMonitorBean> endMonitor;

            public String getResource() {
                return resource;
            }

            public void setResource(String resource) {
                this.resource = resource;
            }

            public String getAdid() {
                return adid;
            }

            public void setAdid(String adid) {
                this.adid = adid;
            }

            public String getClickUrl() {
                return clickUrl;
            }

            public void setClickUrl(String clickUrl) {
                this.clickUrl = clickUrl;
            }

            public List<ClickMonitorBean> getClickMonitor() {
                return clickMonitor;
            }

            public void setClickMonitor(List<ClickMonitorBean> clickMonitor) {
                this.clickMonitor = clickMonitor;
            }

            public List<StartMonitorBean> getStartMonitor() {
                return startMonitor;
            }

            public void setStartMonitor(List<StartMonitorBean> startMonitor) {
                this.startMonitor = startMonitor;
            }

            public List<MiddleMonitorBean> getMiddleMonitor() {
                return middleMonitor;
            }

            public void setMiddleMonitor(List<MiddleMonitorBean> middleMonitor) {
                this.middleMonitor = middleMonitor;
            }

            public List<EndMonitorBean> getEndMonitor() {
                return endMonitor;
            }

            public void setEndMonitor(List<EndMonitorBean> endMonitor) {
                this.endMonitor = endMonitor;
            }

            public static class ClickMonitorBean implements DateObj {
                /**
                 * ver : 0
                 * url : http://imooc.com/click??click=1
                 */

                private String ver;
                private String url;

                public String getVer() {
                    return ver;
                }

                public void setVer(String ver) {
                    this.ver = ver;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class StartMonitorBean implements DateObj {
                /**
                 * ver : 0
                 * url : http://imooc.com/show?impression=1
                 */

                private String ver;
                private String url;

                public String getVer() {
                    return ver;
                }

                public void setVer(String ver) {
                    this.ver = ver;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class MiddleMonitorBean implements DateObj {
                /**
                 * ver : 0
                 * url : http://imooc.com/show?SU=1
                 * time : 5
                 */

                private String ver;
                private String url;
                private int time;

                public String getVer() {
                    return ver;
                }

                public void setVer(String ver) {
                    this.ver = ver;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getTime() {
                    return time;
                }

                public void setTime(int time) {
                    this.time = time;
                }
            }

            public static class EndMonitorBean implements DateObj {
                /**
                 * ver : 0
                 * url : http://imooc.com/show?end=1
                 * time : 5
                 */

                private String ver;
                private String url;
                private int time;

                public String getVer() {
                    return ver;
                }

                public void setVer(String ver) {
                    this.ver = ver;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getTime() {
                    return time;
                }

                public void setTime(int time) {
                    this.time = time;
                }
            }
        }
    }

    public static class FooterBean implements DateObj {
        private List<RecommandBean> recommand;
        private List<TimeBean> time;

        public List<RecommandBean> getRecommand() {
            return recommand;
        }

        public void setRecommand(List<RecommandBean> recommand) {
            this.recommand = recommand;
        }

        public List<TimeBean> getTime() {
            return time;
        }

        public void setTime(List<TimeBean> time) {
            this.time = time;
        }

        public static class RecommandBean implements DateObj {
            /**
             * imageUrl : http://it.enorth.com.cn/pic2014/002/000/092/00200009288_502cc21c.png
             * name : 5天学会IM
             * price : ￥23
             * zan : 3赞    5评论
             * courseId : 01112
             */

            private String imageUrl;
            private String name;
            private String price;
            private String zan;
            private String courseId;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getZan() {
                return zan;
            }

            public void setZan(String zan) {
                this.zan = zan;
            }

            public String getCourseId() {
                return courseId;
            }

            public void setCourseId(String courseId) {
                this.courseId = courseId;
            }
        }

        public static class TimeBean implements DateObj {
            /**
             * dt : 1473264000
             * count : 40
             */

            private String dt;
            private String count;

            public String getDt() {
                return dt;
            }

            public void setDt(String dt) {
                this.dt = dt;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }
        }
    }

    public static class BodyBean implements DateObj {
        /**
         * type : 0
         * name : 狼在北京
         * logo : http://img3.duitang.com/uploads/item/201407/01/20140701222607_AnKfj.thumb.224_0.jpeg
         * text : 回复@偏执的柔情:多谢支持，继续支持我哈
         * userId : 0001
         */

        private int type;
        private String name;
        private String logo;
        private String text;
        private String userId;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
