package com.lqr.biliblili.app.data.entity.recommend;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IndexData {

    private int code;
    private String message;
    private int ttl;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        // streamer topic、special
        private String badge;
        private boolean hide_badge;
        private String redirect_uri;

        // item ad_web_s
        private String ad_cb;
        private int ad_index;
        private String clien_ip;
        private int cm_mark;
        private int creative_id = 5077;
        private boolean is_ad;
        private boolean is_ad_loc;
        private String request_id;
        private int src_id;

        // item bangumi
        private int count;
        private int index;
        private String index_title;
        private int last_index;
        private int status;
        private int type;

        // item article_s
        private String banner_url;
        private CategoryBean category;
        private int temple;
        private List<String> covers;

        public static class CategoryBean {
            /**
             * children : {"id":15,"name":"其他"}
             * id : 3
             * name : 其他
             */

            private ChildrenBean children;
            private int id;
            private String name;

            public ChildrenBean getChildren() {
                return children;
            }

            public void setChildren(ChildrenBean children) {
                this.children = children;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public static class ChildrenBean {
                /**
                 * id : 15
                 * name : 其他
                 */

                private int id;
                private String name;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        // item av(有黄色标记的多一个rcmd_reason)、login
        private int coin;
        private String cover;
        private int ctime;
        private int danmaku;
        private String desc;
        private int duration;
        private String face;
        private int favorite;
        private int mid;
        private String name;
        private int play;
        private RcmdReasonBean rcmd_reason;
        private int reply;
        private int share;
        private TagBean tag;
        private int tid;
        private String title;
        private String tname;
        private String uri;
        private List<DislikeReasonsBean> dislike_reasons;

        public static class RcmdReasonBean {
            /**
             * bg_color : yellow
             * content : 很多人点推荐
             * icon_location : bottom
             * id : 2
             */

            private String bg_color;
            private String content;
            private String icon_location;
            private int id;

            public String getBg_color() {
                return bg_color;
            }

            public void setBg_color(String bg_color) {
                this.bg_color = bg_color;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getIcon_location() {
                return icon_location;
            }

            public void setIcon_location(String icon_location) {
                this.icon_location = icon_location;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class TagBean {
            /**
             * count : {"atten":134859}
             * tag_id : 5417
             * tag_name : 科普
             */

            private CountBean count;
            private int tag_id;
            private String tag_name;

            public CountBean getCount() {
                return count;
            }

            public void setCount(CountBean count) {
                this.count = count;
            }

            public int getTag_id() {
                return tag_id;
            }

            public void setTag_id(int tag_id) {
                this.tag_id = tag_id;
            }

            public String getTag_name() {
                return tag_name;
            }

            public void setTag_name(String tag_name) {
                this.tag_name = tag_name;
            }

            public static class CountBean {
                /**
                 * atten : 134859
                 */

                private int atten;

                public int getAtten() {
                    return atten;
                }

                public void setAtten(int atten) {
                    this.atten = atten;
                }
            }
        }

        public static class DislikeReasonsBean {
            /**
             * reason_id : 4
             * reason_name : UP主:Kyoko释怀
             */

            private int reason_id;
            private String reason_name;

            public int getReason_id() {
                return reason_id;
            }

            public void setReason_id(int reason_id) {
                this.reason_id = reason_id;
            }

            public String getReason_name() {
                return reason_name;
            }

            public void setReason_name(String reason_name) {
                this.reason_name = reason_name;
            }
        }

        // banner
        @SerializedName("goto")
        private String gotoX;
        private String hash;
        private int idx;
        private String param;
        private List<BannerItemBean> banner_item;


        public static class BannerItemBean {
            /**
             * cm_mark : 0
             * hash : 91db089c56a1337a735a4aa850a73291
             * id : 93334
             * image : http://i0.hdslb.com/bfs/archive/4917344e145d160e1c478708f45feb6bbf4de788.jpg
             * index : 1
             * request_id : 1508573699727
             * resource_id : 631
             * server_type : 0
             * title : 国创1021
             * uri : http://www.bilibili.com/blackboard/topic/activity-r18q6BwTb.html
             * ad_cb : CL0cEAAYog4gACgAMAM4vwVCHzE1MDg1NzM2OTk3NjNxMTcyYTE4YTYxYTE4OHEyMDVIs73/7/MrUgnmt7HlnLPluIJaCeW5v+S4nOecgWIG5Lit5Zu9aABwAHgAgAEAiAGvA5IBDjExMy45MS4xMDAuMTM2mgEHZGVmYXVsdKABAKgBALIBILsQE4YPnkQIBycAzcqXqYmoyd73bFdBtxWro5b1Yi8mugEmaHR0cDovL2Znby5iaWxpZ2FtZS5jb20vZXZlbnRfaWxseWEvaDU=
             * click_url : https://ad-bili-data.biligame.com/api/mobile/clickBili?ad_plan_id=1012&mid=__MID__&os=__OS__&idfa=__IDFA__&buvid=__BUVID__&android_id=__ANDROIDID__&imei=__IMEI__&mac=__MAC__&duid=__DUID__&ip=__IP__&request_id=__REQUESTID__&ts=__TS__&ua=__UA__
             * client_ip : 113.91.100.136
             * creative_id : 1826
             * is_ad_loc : true
             * src_id : 703
             * is_ad : true
             */

            private int cm_mark;
            private String hash;
            private int id;
            private String image;
            private int index;
            private String request_id;
            private int resource_id;
            private int server_type;
            private String title;
            private String uri;
            private String ad_cb;
            private String click_url;
            private String client_ip;
            private int creative_id;
            private boolean is_ad_loc;
            private int src_id;
            private boolean is_ad;

            public int getCm_mark() {
                return cm_mark;
            }

            public void setCm_mark(int cm_mark) {
                this.cm_mark = cm_mark;
            }

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public String getRequest_id() {
                return request_id;
            }

            public void setRequest_id(String request_id) {
                this.request_id = request_id;
            }

            public int getResource_id() {
                return resource_id;
            }

            public void setResource_id(int resource_id) {
                this.resource_id = resource_id;
            }

            public int getServer_type() {
                return server_type;
            }

            public void setServer_type(int server_type) {
                this.server_type = server_type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getAd_cb() {
                return ad_cb;
            }

            public void setAd_cb(String ad_cb) {
                this.ad_cb = ad_cb;
            }

            public String getClick_url() {
                return click_url;
            }

            public void setClick_url(String click_url) {
                this.click_url = click_url;
            }

            public String getClient_ip() {
                return client_ip;
            }

            public void setClient_ip(String client_ip) {
                this.client_ip = client_ip;
            }

            public int getCreative_id() {
                return creative_id;
            }

            public void setCreative_id(int creative_id) {
                this.creative_id = creative_id;
            }

            public boolean isIs_ad_loc() {
                return is_ad_loc;
            }

            public void setIs_ad_loc(boolean is_ad_loc) {
                this.is_ad_loc = is_ad_loc;
            }

            public int getSrc_id() {
                return src_id;
            }

            public void setSrc_id(int src_id) {
                this.src_id = src_id;
            }

            public boolean isIs_ad() {
                return is_ad;
            }

            public void setIs_ad(boolean is_ad) {
                this.is_ad = is_ad;
            }
        }

        public String getBadge() {
            return badge;
        }

        public void setBadge(String badge) {
            this.badge = badge;
        }

        public boolean isHide_badge() {
            return hide_badge;
        }

        public void setHide_badge(boolean hide_badge) {
            this.hide_badge = hide_badge;
        }

        public String getRedirect_uri() {
            return redirect_uri;
        }

        public void setRedirect_uri(String redirect_uri) {
            this.redirect_uri = redirect_uri;
        }

        public String getAd_cb() {
            return ad_cb;
        }

        public void setAd_cb(String ad_cb) {
            this.ad_cb = ad_cb;
        }

        public int getAd_index() {
            return ad_index;
        }

        public void setAd_index(int ad_index) {
            this.ad_index = ad_index;
        }

        public String getClien_ip() {
            return clien_ip;
        }

        public void setClien_ip(String clien_ip) {
            this.clien_ip = clien_ip;
        }

        public int getCm_mark() {
            return cm_mark;
        }

        public void setCm_mark(int cm_mark) {
            this.cm_mark = cm_mark;
        }

        public int getCreative_id() {
            return creative_id;
        }

        public void setCreative_id(int creative_id) {
            this.creative_id = creative_id;
        }

        public boolean is_ad() {
            return is_ad;
        }

        public void setIs_ad(boolean is_ad) {
            this.is_ad = is_ad;
        }

        public boolean is_ad_loc() {
            return is_ad_loc;
        }

        public void setIs_ad_loc(boolean is_ad_loc) {
            this.is_ad_loc = is_ad_loc;
        }

        public String getRequest_id() {
            return request_id;
        }

        public void setRequest_id(String request_id) {
            this.request_id = request_id;
        }

        public int getSrc_id() {
            return src_id;
        }

        public void setSrc_id(int src_id) {
            this.src_id = src_id;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getIndex_title() {
            return index_title;
        }

        public void setIndex_title(String index_title) {
            this.index_title = index_title;
        }

        public int getLast_index() {
            return last_index;
        }

        public void setLast_index(int last_index) {
            this.last_index = last_index;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getBanner_url() {
            return banner_url;
        }

        public void setBanner_url(String banner_url) {
            this.banner_url = banner_url;
        }

        public CategoryBean getCategory() {
            return category;
        }

        public void setCategory(CategoryBean category) {
            this.category = category;
        }

        public int getTemple() {
            return temple;
        }

        public void setTemple(int temple) {
            this.temple = temple;
        }

        public List<String> getCovers() {
            return covers;
        }

        public void setCovers(List<String> covers) {
            this.covers = covers;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getCtime() {
            return ctime;
        }

        public void setCtime(int ctime) {
            this.ctime = ctime;
        }

        public int getDanmaku() {
            return danmaku;
        }

        public void setDanmaku(int danmaku) {
            this.danmaku = danmaku;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public int getFavorite() {
            return favorite;
        }

        public void setFavorite(int favorite) {
            this.favorite = favorite;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPlay() {
            return play;
        }

        public void setPlay(int play) {
            this.play = play;
        }

        public RcmdReasonBean getRcmd_reason() {
            return rcmd_reason;
        }

        public void setRcmd_reason(RcmdReasonBean rcmd_reason) {
            this.rcmd_reason = rcmd_reason;
        }

        public int getReply() {
            return reply;
        }

        public void setReply(int reply) {
            this.reply = reply;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public TagBean getTag() {
            return tag;
        }

        public void setTag(TagBean tag) {
            this.tag = tag;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public List<DislikeReasonsBean> getDislike_reasons() {
            return dislike_reasons;
        }

        public void setDislike_reasons(List<DislikeReasonsBean> dislike_reasons) {
            this.dislike_reasons = dislike_reasons;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public List<BannerItemBean> getBanner_item() {
            return banner_item;
        }

        public void setBanner_item(List<BannerItemBean> banner_item) {
            this.banner_item = banner_item;
        }
    }
}
