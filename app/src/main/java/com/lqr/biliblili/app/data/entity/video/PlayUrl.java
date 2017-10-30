package com.lqr.biliblili.app.data.entity.video;

import java.util.Map;

public class PlayUrl {

    /**
     * accept_format : mp4
     * accept_quality : [1]
     * cid : https://comment.bilibili.com/25799794.xml
     * durl : [{"length":114050,"order":1,"size":15045954,"url":"http://cn-zjwz3-dx.acgvideo.com/vg6/f/77/25799794-1.mp4?expires=1509344700&platform=html5&ssig=5Fi194xb7taDblWOSPfCug&oi=1901815804&nfa=nm5pdaeMOoXTZWdjlIkKCg==&dynamic=1&hfa=2076565839&hfb=M2Y2ZWYwZjM2YmRiYmY5MDljYTBiOWE2ZmEwYjJmYTM="}]
     * format : mp4
     * from : local
     * fromview : vupload
     * hit_ssd_sid : []
     * img : https://i2.hdslb.com/bfs/archive/c10b7a67d198218bd2b3d4f7814f6d27f21a621d.jpg
     * quality : 16
     * result : suee
     * seek_param : start
     * seek_type : second
     * timelength : 114050
     */

    private String accept_format;
    private String cid;
    private String format;
    private String from;
    private String fromview;
    private String img;
    private int quality;
    private String result;
    private String seek_param;
    private String seek_type;
    private int timelength;
    private Map<String, DurlBean> durl;

    public String getAccept_format() {
        return accept_format;
    }

    public void setAccept_format(String accept_format) {
        this.accept_format = accept_format;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromview() {
        return fromview;
    }

    public void setFromview(String fromview) {
        this.fromview = fromview;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSeek_param() {
        return seek_param;
    }

    public void setSeek_param(String seek_param) {
        this.seek_param = seek_param;
    }

    public String getSeek_type() {
        return seek_type;
    }

    public void setSeek_type(String seek_type) {
        this.seek_type = seek_type;
    }

    public int getTimelength() {
        return timelength;
    }

    public void setTimelength(int timelength) {
        this.timelength = timelength;
    }

    public Map<String, DurlBean> getDurl() {
        return durl;
    }

    public void setDurl(Map<String, DurlBean> durl) {
        this.durl = durl;
    }

    public static class DurlBean {
        /**
         * length : 114050
         * order : 1
         * size : 15045954
         * url : http://cn-zjwz3-dx.acgvideo.com/vg6/f/77/25799794-1.mp4?expires=1509344700&platform=html5&ssig=5Fi194xb7taDblWOSPfCug&oi=1901815804&nfa=nm5pdaeMOoXTZWdjlIkKCg==&dynamic=1&hfa=2076565839&hfb=M2Y2ZWYwZjM2YmRiYmY5MDljYTBiOWE2ZmEwYjJmYTM=
         */

        private int length;
        private int order;
        private int size;
        private String url;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
