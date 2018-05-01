package com.example.liufan.xiangmu.tuijain.modle.Bean;

import java.util.List;

/**
 * Created by lenovo on 2018/4/28.
 */

public class Tuijianyonghu_Xiangqing_bean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524401892413nv.png","createTime":"2018-04-22T20:58:12","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":null,"uid":13315,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524401892413baby.mp4","wid":363,"workDesc":"这个视屏非常好看！"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524402358555nv.png","createTime":"2018-04-22T21:05:58","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":null,"uid":13315,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524402358555baby.mp4","wid":364,"workDesc":"我是一组成员_范冰冰！"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524402688980nv.png","createTime":"2018-04-22T21:11:28","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":null,"uid":13315,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524402688980baby.mp4","wid":365,"workDesc":"我是一组成员_范冰冰！"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524402703425nv.png","createTime":"2018-04-22T21:11:43","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":null,"uid":13315,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524402703425baby.mp4","wid":366,"workDesc":"我是一组成员_范冰冰！"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524410202762nv.png","createTime":"2018-04-22T23:16:42","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":null,"uid":13315,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524410202762baby.mp4","wid":368,"workDesc":"我是一组成员_范冰冰！"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524412356400nv.png","createTime":"2018-04-22T23:52:36","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":null,"uid":13315,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524412356400recording1302250947.mp4","wid":369,"workDesc":"这个视屏非常好看！"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524439773801nv.png","createTime":"2018-04-23T07:29:33","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":null,"uid":13315,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524439773801baby.mp4","wid":370,"workDesc":"我是一组成员_范冰冰！"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524441715469nv.png","createTime":"2018-04-23T08:01:55","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":null,"uid":13315,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524441715469recording780809338.mp4","wid":371,"workDesc":"这个视屏非常好看！"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524464580424nv.png","createTime":"2018-04-23T14:23:00","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":null,"uid":13315,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524464580424recording1274569972.mp4","wid":379,"workDesc":"这个视屏非常好看！"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524566254086nv.png","createTime":"2018-04-24T18:37:34","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":null,"uid":13315,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524566254086recording131412904.mp4","wid":404,"workDesc":"这个视屏非常好看！"}]
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
         * cover : https://www.zhaoapi.cn/images/quarter/1524401892413nv.png
         * createTime : 2018-04-22T20:58:12
         * favoriteNum : null
         * latitude : 39.95
         * localUri : null
         * longitude : 116.30
         * playNum : 0
         * praiseNum : null
         * uid : 13315
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1524401892413baby.mp4
         * wid : 363
         * workDesc : 这个视屏非常好看！
         */

        private Object commentNum;
        private String cover;
        private String createTime;
        private Object favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private Object praiseNum;
        private int uid;
        private String videoUrl;
        private int wid;
        private String workDesc;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(Object favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }
    }
}
