package com.example.liufan.xiangmu.duanzi.bean;

import java.util.List;

/**
 * author:Created by Administrator on 2018/4/24.
 */

public class DZListBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"zheshi","createTime":"2018-04-24T20:20:41","imgUrls":null,"jid":2192,"praiseNum":null,"shareNum":null,"uid":11510,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524473753240spl.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"我是器凯凯","createTime":"2018-04-24T19:52:13","imgUrls":null,"jid":2191,"praiseNum":null,"shareNum":null,"uid":11510,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524473753240spl.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"好好学习","createTime":"2018-04-24T19:42:39","imgUrls":null,"jid":2190,"praiseNum":null,"shareNum":null,"uid":10713,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524570416047spl.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"啦啦","createTime":"2018-04-24T19:40:19","imgUrls":null,"jid":2189,"praiseNum":null,"shareNum":null,"uid":11186,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524556419086touxiang.jpg","nickname":"小哥哥i","praiseNum":"null"}},{"commentNum":null,"content":"1111","createTime":"2018-04-24T19:36:34","imgUrls":null,"jid":2188,"praiseNum":null,"shareNum":null,"uid":2561,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"嗜血任心","praiseNum":"null"}},{"commentNum":null,"content":"脚本之家","createTime":"2018-04-24T19:31:38","imgUrls":null,"jid":2187,"praiseNum":null,"shareNum":null,"uid":11019,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524569538655touxiang.jpg","nickname":"哈哈","praiseNum":"null"}},{"commentNum":null,"content":"？？？","createTime":"2018-04-24T18:59:50","imgUrls":null,"jid":2186,"praiseNum":null,"shareNum":null,"uid":13315,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"？？？？","createTime":"2018-04-24T18:59:04","imgUrls":null,"jid":2185,"praiseNum":null,"shareNum":null,"uid":13315,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"大吉大利今晚吃鸡。","createTime":"2018-04-24T16:29:38","imgUrls":null,"jid":2184,"praiseNum":null,"shareNum":null,"uid":13315,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"你好。","createTime":"2018-04-24T16:21:48","imgUrls":null,"jid":2183,"praiseNum":null,"shareNum":null,"uid":1570,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15243986664561366_768_20100117123715488932.jpg","nickname":"我是XXX","praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : zheshi
         * createTime : 2018-04-24T20:20:41
         * imgUrls : null
         * jid : 2192
         * praiseNum : null
         * shareNum : null
         * uid : 11510
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524473753240spl.jpg","nickname":null,"praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1524473753240spl.jpg
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
