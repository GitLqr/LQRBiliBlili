package com.lqr.biliblili.app.data.entity.video;

import java.util.List;


/**
 * @创建者 CSDN_LQR
 * @描述 视频详情-评论
 */
public class Reply {


    private int code;
    private DataBean data;
    private String message;
    private int ttl;

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

    public static class DataBean {

        private ConfigBean config;
        private Object notice;
        private PageBean page;
        private Object top;
        private UpperBean upper;
        private List<RepliesBean> hots;
        private List<RepliesBean> replies;

        public ConfigBean getConfig() {
            return config;
        }

        public void setConfig(ConfigBean config) {
            this.config = config;
        }

        public Object getNotice() {
            return notice;
        }

        public void setNotice(Object notice) {
            this.notice = notice;
        }

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public Object getTop() {
            return top;
        }

        public void setTop(Object top) {
            this.top = top;
        }

        public UpperBean getUpper() {
            return upper;
        }

        public void setUpper(UpperBean upper) {
            this.upper = upper;
        }

        public List<RepliesBean> getHots() {
            return hots;
        }

        public void setHots(List<RepliesBean> hots) {
            this.hots = hots;
        }

        public List<RepliesBean> getReplies() {
            return replies;
        }

        public void setReplies(List<RepliesBean> replies) {
            this.replies = replies;
        }

        public static class ConfigBean {
            /**
             * showadmin : 1
             * showentry : 1
             */

            private int showadmin;
            private int showentry;

            public int getShowadmin() {
                return showadmin;
            }

            public void setShowadmin(int showadmin) {
                this.showadmin = showadmin;
            }

            public int getShowentry() {
                return showentry;
            }

            public void setShowentry(int showentry) {
                this.showentry = showentry;
            }
        }

        public static class PageBean {
            /**
             * acount : 271
             * count : 206
             * num : 1
             * size : 20
             */

            private int acount;
            private int count;
            private int num;
            private int size;

            public int getAcount() {
                return acount;
            }

            public void setAcount(int acount) {
                this.acount = acount;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }
        }

        public static class UpperBean {

            private int mid;
            private TopBean top;

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public TopBean getTop() {
                return top;
            }

            public void setTop(TopBean top) {
                this.top = top;
            }

            public static class TopBean {

                private int rpid;
                private int oid;
                private int type;
                private int mid;
                private int root;
                private int parent;
                private int count;
                private int rcount;
                private int floor;
                private int state;
                private int fansgrade;
                private int attr;
                private int ctime;
                private String rpid_str;
                private String root_str;
                private String parent_str;
                private int like;
                private int action;
                private MemberBean member;
                private ContentBean content;
                private Object replies;
                private int assist;

                public int getRpid() {
                    return rpid;
                }

                public void setRpid(int rpid) {
                    this.rpid = rpid;
                }

                public int getOid() {
                    return oid;
                }

                public void setOid(int oid) {
                    this.oid = oid;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getMid() {
                    return mid;
                }

                public void setMid(int mid) {
                    this.mid = mid;
                }

                public int getRoot() {
                    return root;
                }

                public void setRoot(int root) {
                    this.root = root;
                }

                public int getParent() {
                    return parent;
                }

                public void setParent(int parent) {
                    this.parent = parent;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public int getRcount() {
                    return rcount;
                }

                public void setRcount(int rcount) {
                    this.rcount = rcount;
                }

                public int getFloor() {
                    return floor;
                }

                public void setFloor(int floor) {
                    this.floor = floor;
                }

                public int getState() {
                    return state;
                }

                public void setState(int state) {
                    this.state = state;
                }

                public int getFansgrade() {
                    return fansgrade;
                }

                public void setFansgrade(int fansgrade) {
                    this.fansgrade = fansgrade;
                }

                public int getAttr() {
                    return attr;
                }

                public void setAttr(int attr) {
                    this.attr = attr;
                }

                public int getCtime() {
                    return ctime;
                }

                public void setCtime(int ctime) {
                    this.ctime = ctime;
                }

                public String getRpid_str() {
                    return rpid_str;
                }

                public void setRpid_str(String rpid_str) {
                    this.rpid_str = rpid_str;
                }

                public String getRoot_str() {
                    return root_str;
                }

                public void setRoot_str(String root_str) {
                    this.root_str = root_str;
                }

                public String getParent_str() {
                    return parent_str;
                }

                public void setParent_str(String parent_str) {
                    this.parent_str = parent_str;
                }

                public int getLike() {
                    return like;
                }

                public void setLike(int like) {
                    this.like = like;
                }

                public int getAction() {
                    return action;
                }

                public void setAction(int action) {
                    this.action = action;
                }

                public MemberBean getMember() {
                    return member;
                }

                public void setMember(MemberBean member) {
                    this.member = member;
                }

                public ContentBean getContent() {
                    return content;
                }

                public void setContent(ContentBean content) {
                    this.content = content;
                }

                public Object getReplies() {
                    return replies;
                }

                public void setReplies(Object replies) {
                    this.replies = replies;
                }

                public int getAssist() {
                    return assist;
                }

                public void setAssist(int assist) {
                    this.assist = assist;
                }

                public static class MemberBean {
                    /**
                     * mid : 14734089
                     * uname : 卡卡Master丶
                     * sex : 男
                     * sign : 投食：13452812550 每天晚上8点B站直播 粉丝5群：206941029 商业合作加qq：3536387380
                     * avatar : http://i0.hdslb.com/bfs/face/eea3d604cfa064ed851894ffa6f10f2cc15b9436.jpg
                     * rank : 10000
                     * DisplayRank : 0
                     * level_info : {"current_level":6,"current_min":28800,"current_exp":98986,"next_exp":"-"}
                     * pendant : {"pid":0,"name":"","image":"","expire":0}
                     * nameplate : {"nid":8,"name":"知名偶像","image":"http://i1.hdslb.com/bfs/face/27a952195555e64508310e366b3e38bd4cd143fc.png","image_small":"http://i2.hdslb.com/bfs/face/0497be49e08357bf05bca56e33a0637a273a7610.png","level":"稀有勋章","condition":"所有自制视频总播放数>=100万"}
                     * official_verify : {"type":-1,"desc":""}
                     * vip : {"vipType":0,"vipDueDate":0,"dueRemark":"","accessStatus":1,"vipStatus":0,"vipStatusWarn":""}
                     * fans_detail : null
                     * following : 0
                     */

                    private String mid;
                    private String uname;
                    private String sex;
                    private String sign;
                    private String avatar;
                    private String rank;
                    private String DisplayRank;
                    private LevelInfoBean level_info;
                    private PendantBean pendant;
                    private NameplateBean nameplate;
                    private OfficialVerifyBean official_verify;
                    private VipBean vip;
                    private Object fans_detail;
                    private int following;

                    public String getMid() {
                        return mid;
                    }

                    public void setMid(String mid) {
                        this.mid = mid;
                    }

                    public String getUname() {
                        return uname;
                    }

                    public void setUname(String uname) {
                        this.uname = uname;
                    }

                    public String getSex() {
                        return sex;
                    }

                    public void setSex(String sex) {
                        this.sex = sex;
                    }

                    public String getSign() {
                        return sign;
                    }

                    public void setSign(String sign) {
                        this.sign = sign;
                    }

                    public String getAvatar() {
                        return avatar;
                    }

                    public void setAvatar(String avatar) {
                        this.avatar = avatar;
                    }

                    public String getRank() {
                        return rank;
                    }

                    public void setRank(String rank) {
                        this.rank = rank;
                    }

                    public String getDisplayRank() {
                        return DisplayRank;
                    }

                    public void setDisplayRank(String DisplayRank) {
                        this.DisplayRank = DisplayRank;
                    }

                    public LevelInfoBean getLevel_info() {
                        return level_info;
                    }

                    public void setLevel_info(LevelInfoBean level_info) {
                        this.level_info = level_info;
                    }

                    public PendantBean getPendant() {
                        return pendant;
                    }

                    public void setPendant(PendantBean pendant) {
                        this.pendant = pendant;
                    }

                    public NameplateBean getNameplate() {
                        return nameplate;
                    }

                    public void setNameplate(NameplateBean nameplate) {
                        this.nameplate = nameplate;
                    }

                    public OfficialVerifyBean getOfficial_verify() {
                        return official_verify;
                    }

                    public void setOfficial_verify(OfficialVerifyBean official_verify) {
                        this.official_verify = official_verify;
                    }

                    public VipBean getVip() {
                        return vip;
                    }

                    public void setVip(VipBean vip) {
                        this.vip = vip;
                    }

                    public Object getFans_detail() {
                        return fans_detail;
                    }

                    public void setFans_detail(Object fans_detail) {
                        this.fans_detail = fans_detail;
                    }

                    public int getFollowing() {
                        return following;
                    }

                    public void setFollowing(int following) {
                        this.following = following;
                    }

                    public static class LevelInfoBean {
                        /**
                         * current_level : 6
                         * current_min : 28800
                         * current_exp : 98986
                         * next_exp : -
                         */

                        private int current_level;
                        private int current_min;
                        private int current_exp;
                        private String next_exp;

                        public int getCurrent_level() {
                            return current_level;
                        }

                        public void setCurrent_level(int current_level) {
                            this.current_level = current_level;
                        }

                        public int getCurrent_min() {
                            return current_min;
                        }

                        public void setCurrent_min(int current_min) {
                            this.current_min = current_min;
                        }

                        public int getCurrent_exp() {
                            return current_exp;
                        }

                        public void setCurrent_exp(int current_exp) {
                            this.current_exp = current_exp;
                        }

                        public String getNext_exp() {
                            return next_exp;
                        }

                        public void setNext_exp(String next_exp) {
                            this.next_exp = next_exp;
                        }
                    }

                    public static class PendantBean {
                        /**
                         * pid : 0
                         * name :
                         * image :
                         * expire : 0
                         */

                        private int pid;
                        private String name;
                        private String image;
                        private long expire;

                        public int getPid() {
                            return pid;
                        }

                        public void setPid(int pid) {
                            this.pid = pid;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getImage() {
                            return image;
                        }

                        public void setImage(String image) {
                            this.image = image;
                        }

                        public long getExpire() {
                            return expire;
                        }

                        public void setExpire(long expire) {
                            this.expire = expire;
                        }
                    }

                    public static class NameplateBean {
                        /**
                         * nid : 8
                         * name : 知名偶像
                         * image : http://i1.hdslb.com/bfs/face/27a952195555e64508310e366b3e38bd4cd143fc.png
                         * image_small : http://i2.hdslb.com/bfs/face/0497be49e08357bf05bca56e33a0637a273a7610.png
                         * level : 稀有勋章
                         * condition : 所有自制视频总播放数>=100万
                         */

                        private int nid;
                        private String name;
                        private String image;
                        private String image_small;
                        private String level;
                        private String condition;

                        public int getNid() {
                            return nid;
                        }

                        public void setNid(int nid) {
                            this.nid = nid;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getImage() {
                            return image;
                        }

                        public void setImage(String image) {
                            this.image = image;
                        }

                        public String getImage_small() {
                            return image_small;
                        }

                        public void setImage_small(String image_small) {
                            this.image_small = image_small;
                        }

                        public String getLevel() {
                            return level;
                        }

                        public void setLevel(String level) {
                            this.level = level;
                        }

                        public String getCondition() {
                            return condition;
                        }

                        public void setCondition(String condition) {
                            this.condition = condition;
                        }
                    }

                    public static class OfficialVerifyBean {
                        /**
                         * type : -1
                         * desc :
                         */

                        private int type;
                        private String desc;

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }

                        public String getDesc() {
                            return desc;
                        }

                        public void setDesc(String desc) {
                            this.desc = desc;
                        }
                    }

                    public static class VipBean {
                        /**
                         * vipType : 0
                         * vipDueDate : 0
                         * dueRemark :
                         * accessStatus : 1
                         * vipStatus : 0
                         * vipStatusWarn :
                         */

                        private int vipType;
                        private long vipDueDate;
                        private String dueRemark;
                        private int accessStatus;
                        private int vipStatus;
                        private String vipStatusWarn;

                        public int getVipType() {
                            return vipType;
                        }

                        public void setVipType(int vipType) {
                            this.vipType = vipType;
                        }

                        public long getVipDueDate() {
                            return vipDueDate;
                        }

                        public void setVipDueDate(long vipDueDate) {
                            this.vipDueDate = vipDueDate;
                        }

                        public String getDueRemark() {
                            return dueRemark;
                        }

                        public void setDueRemark(String dueRemark) {
                            this.dueRemark = dueRemark;
                        }

                        public int getAccessStatus() {
                            return accessStatus;
                        }

                        public void setAccessStatus(int accessStatus) {
                            this.accessStatus = accessStatus;
                        }

                        public int getVipStatus() {
                            return vipStatus;
                        }

                        public void setVipStatus(int vipStatus) {
                            this.vipStatus = vipStatus;
                        }

                        public String getVipStatusWarn() {
                            return vipStatusWarn;
                        }

                        public void setVipStatusWarn(String vipStatusWarn) {
                            this.vipStatusWarn = vipStatusWarn;
                        }
                    }
                }

                public static class ContentBean {
                    /**
                     * message : 一口毒奶奶出世界纪录
                     * 10月20日   最新世界纪录：av15634247
                     * plat : 1
                     * device :
                     * members : []
                     */

                    private String message;
                    private int plat;
                    private String device;
                    private List<?> members;

                    public String getMessage() {
                        return message;
                    }

                    public void setMessage(String message) {
                        this.message = message;
                    }

                    public int getPlat() {
                        return plat;
                    }

                    public void setPlat(int plat) {
                        this.plat = plat;
                    }

                    public String getDevice() {
                        return device;
                    }

                    public void setDevice(String device) {
                        this.device = device;
                    }

                    public List<?> getMembers() {
                        return members;
                    }

                    public void setMembers(List<?> members) {
                        this.members = members;
                    }
                }
            }
        }


        public static class RepliesBean {
            /**
             * rpid : 458003484
             * oid : 15379648
             * type : 1
             * mid : 104261762
             * root : 0
             * parent : 0
             * count : 0
             * rcount : 0
             * floor : 219
             * state : 0
             * fansgrade : 0
             * attr : 0
             * ctime : 1508706477
             * rpid_str : 458003484
             * root_str : 0
             * parent_str : 0
             * like : 0
             * action : 0
             * member : {"mid":"104261762","uname":"钓鱼的兔几","sex":"男","sign":"嘻嘻","avatar":"http://i2.hdslb.com/bfs/face/e19a5f51df2ee9160fbc0dea561b1f3990b78e82.jpg","rank":"10000","DisplayRank":"0","level_info":{"current_level":2,"current_min":200,"current_exp":1393,"next_exp":1500},"pendant":{"pid":0,"name":"","image":"","expire":0},"nameplate":{"nid":0,"name":"","image":"","image_small":"","level":"","condition":""},"official_verify":{"type":-1,"desc":""},"vip":{"vipType":0,"vipDueDate":0,"dueRemark":"","accessStatus":1,"vipStatus":0,"vipStatusWarn":""},"fans_detail":null,"following":0}
             * content : {"message":"这B站真的有毒，有时候我把高清换成超清就不卡了～(￣▽￣～)","plat":2,"device":"","members":[]}
             * replies : []
             * assist : 0
             */

            private int rpid;
            private int oid;
            private int type;
            private int mid;
            private int root;
            private int parent;
            private int count;
            private int rcount;
            private int floor;
            private int state;
            private int fansgrade;
            private int attr;
            private int ctime;
            private String rpid_str;
            private String root_str;
            private String parent_str;
            private int like;
            private int action;
            private MemberBeanXX member;
            private ContentBeanXX content;
            private int assist;
            private List<RepliesBean> replies;

            public int getRpid() {
                return rpid;
            }

            public void setRpid(int rpid) {
                this.rpid = rpid;
            }

            public int getOid() {
                return oid;
            }

            public void setOid(int oid) {
                this.oid = oid;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public int getRoot() {
                return root;
            }

            public void setRoot(int root) {
                this.root = root;
            }

            public int getParent() {
                return parent;
            }

            public void setParent(int parent) {
                this.parent = parent;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getRcount() {
                return rcount;
            }

            public void setRcount(int rcount) {
                this.rcount = rcount;
            }

            public int getFloor() {
                return floor;
            }

            public void setFloor(int floor) {
                this.floor = floor;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getFansgrade() {
                return fansgrade;
            }

            public void setFansgrade(int fansgrade) {
                this.fansgrade = fansgrade;
            }

            public int getAttr() {
                return attr;
            }

            public void setAttr(int attr) {
                this.attr = attr;
            }

            public int getCtime() {
                return ctime;
            }

            public void setCtime(int ctime) {
                this.ctime = ctime;
            }

            public String getRpid_str() {
                return rpid_str;
            }

            public void setRpid_str(String rpid_str) {
                this.rpid_str = rpid_str;
            }

            public String getRoot_str() {
                return root_str;
            }

            public void setRoot_str(String root_str) {
                this.root_str = root_str;
            }

            public String getParent_str() {
                return parent_str;
            }

            public void setParent_str(String parent_str) {
                this.parent_str = parent_str;
            }

            public int getLike() {
                return like;
            }

            public void setLike(int like) {
                this.like = like;
            }

            public int getAction() {
                return action;
            }

            public void setAction(int action) {
                this.action = action;
            }

            public MemberBeanXX getMember() {
                return member;
            }

            public void setMember(MemberBeanXX member) {
                this.member = member;
            }

            public ContentBeanXX getContent() {
                return content;
            }

            public void setContent(ContentBeanXX content) {
                this.content = content;
            }

            public int getAssist() {
                return assist;
            }

            public void setAssist(int assist) {
                this.assist = assist;
            }

            public List<RepliesBean> getReplies() {
                return replies;
            }

            public void setReplies(List<RepliesBean> replies) {
                this.replies = replies;
            }

            public static class MemberBeanXX {
                /**
                 * mid : 104261762
                 * uname : 钓鱼的兔几
                 * sex : 男
                 * sign : 嘻嘻
                 * avatar : http://i2.hdslb.com/bfs/face/e19a5f51df2ee9160fbc0dea561b1f3990b78e82.jpg
                 * rank : 10000
                 * DisplayRank : 0
                 * level_info : {"current_level":2,"current_min":200,"current_exp":1393,"next_exp":1500}
                 * pendant : {"pid":0,"name":"","image":"","expire":0}
                 * nameplate : {"nid":0,"name":"","image":"","image_small":"","level":"","condition":""}
                 * official_verify : {"type":-1,"desc":""}
                 * vip : {"vipType":0,"vipDueDate":0,"dueRemark":"","accessStatus":1,"vipStatus":0,"vipStatusWarn":""}
                 * fans_detail : null
                 * following : 0
                 */

                private String mid;
                private String uname;
                private String sex;
                private String sign;
                private String avatar;
                private String rank;
                private String DisplayRank;
                private LevelInfoBeanXX level_info;
                private PendantBeanXX pendant;
                private NameplateBeanXX nameplate;
                private OfficialVerifyBeanXX official_verify;
                private VipBeanXX vip;
                private Object fans_detail;
                private int following;

                public String getMid() {
                    return mid;
                }

                public void setMid(String mid) {
                    this.mid = mid;
                }

                public String getUname() {
                    return uname;
                }

                public void setUname(String uname) {
                    this.uname = uname;
                }

                public String getSex() {
                    return sex;
                }

                public void setSex(String sex) {
                    this.sex = sex;
                }

                public String getSign() {
                    return sign;
                }

                public void setSign(String sign) {
                    this.sign = sign;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getRank() {
                    return rank;
                }

                public void setRank(String rank) {
                    this.rank = rank;
                }

                public String getDisplayRank() {
                    return DisplayRank;
                }

                public void setDisplayRank(String DisplayRank) {
                    this.DisplayRank = DisplayRank;
                }

                public LevelInfoBeanXX getLevel_info() {
                    return level_info;
                }

                public void setLevel_info(LevelInfoBeanXX level_info) {
                    this.level_info = level_info;
                }

                public PendantBeanXX getPendant() {
                    return pendant;
                }

                public void setPendant(PendantBeanXX pendant) {
                    this.pendant = pendant;
                }

                public NameplateBeanXX getNameplate() {
                    return nameplate;
                }

                public void setNameplate(NameplateBeanXX nameplate) {
                    this.nameplate = nameplate;
                }

                public OfficialVerifyBeanXX getOfficial_verify() {
                    return official_verify;
                }

                public void setOfficial_verify(OfficialVerifyBeanXX official_verify) {
                    this.official_verify = official_verify;
                }

                public VipBeanXX getVip() {
                    return vip;
                }

                public void setVip(VipBeanXX vip) {
                    this.vip = vip;
                }

                public Object getFans_detail() {
                    return fans_detail;
                }

                public void setFans_detail(Object fans_detail) {
                    this.fans_detail = fans_detail;
                }

                public int getFollowing() {
                    return following;
                }

                public void setFollowing(int following) {
                    this.following = following;
                }

                public static class LevelInfoBeanXX {
                    /**
                     * current_level : 2
                     * current_min : 200
                     * current_exp : 1393
                     * next_exp : 1500
                     */

                    private int current_level;
                    private int current_min;
                    private int current_exp;
                    private String next_exp;

                    public int getCurrent_level() {
                        return current_level;
                    }

                    public void setCurrent_level(int current_level) {
                        this.current_level = current_level;
                    }

                    public int getCurrent_min() {
                        return current_min;
                    }

                    public void setCurrent_min(int current_min) {
                        this.current_min = current_min;
                    }

                    public int getCurrent_exp() {
                        return current_exp;
                    }

                    public void setCurrent_exp(int current_exp) {
                        this.current_exp = current_exp;
                    }

                    public String getNext_exp() {
                        return next_exp;
                    }

                    public void setNext_exp(String next_exp) {
                        this.next_exp = next_exp;
                    }
                }

                public static class PendantBeanXX {
                    /**
                     * pid : 0
                     * name :
                     * image :
                     * expire : 0
                     */

                    private int pid;
                    private String name;
                    private String image;
                    private long expire;

                    public int getPid() {
                        return pid;
                    }

                    public void setPid(int pid) {
                        this.pid = pid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public long getExpire() {
                        return expire;
                    }

                    public void setExpire(long expire) {
                        this.expire = expire;
                    }
                }

                public static class NameplateBeanXX {
                    /**
                     * nid : 0
                     * name :
                     * image :
                     * image_small :
                     * level :
                     * condition :
                     */

                    private int nid;
                    private String name;
                    private String image;
                    private String image_small;
                    private String level;
                    private String condition;

                    public int getNid() {
                        return nid;
                    }

                    public void setNid(int nid) {
                        this.nid = nid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public String getImage_small() {
                        return image_small;
                    }

                    public void setImage_small(String image_small) {
                        this.image_small = image_small;
                    }

                    public String getLevel() {
                        return level;
                    }

                    public void setLevel(String level) {
                        this.level = level;
                    }

                    public String getCondition() {
                        return condition;
                    }

                    public void setCondition(String condition) {
                        this.condition = condition;
                    }
                }

                public static class OfficialVerifyBeanXX {
                    /**
                     * type : -1
                     * desc :
                     */

                    private int type;
                    private String desc;

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class VipBeanXX {
                    /**
                     * vipType : 0
                     * vipDueDate : 0
                     * dueRemark :
                     * accessStatus : 1
                     * vipStatus : 0
                     * vipStatusWarn :
                     */

                    private int vipType;
                    private long vipDueDate;
                    private String dueRemark;
                    private int accessStatus;
                    private int vipStatus;
                    private String vipStatusWarn;

                    public int getVipType() {
                        return vipType;
                    }

                    public void setVipType(int vipType) {
                        this.vipType = vipType;
                    }

                    public long getVipDueDate() {
                        return vipDueDate;
                    }

                    public void setVipDueDate(long vipDueDate) {
                        this.vipDueDate = vipDueDate;
                    }

                    public String getDueRemark() {
                        return dueRemark;
                    }

                    public void setDueRemark(String dueRemark) {
                        this.dueRemark = dueRemark;
                    }

                    public int getAccessStatus() {
                        return accessStatus;
                    }

                    public void setAccessStatus(int accessStatus) {
                        this.accessStatus = accessStatus;
                    }

                    public int getVipStatus() {
                        return vipStatus;
                    }

                    public void setVipStatus(int vipStatus) {
                        this.vipStatus = vipStatus;
                    }

                    public String getVipStatusWarn() {
                        return vipStatusWarn;
                    }

                    public void setVipStatusWarn(String vipStatusWarn) {
                        this.vipStatusWarn = vipStatusWarn;
                    }
                }
            }

            public static class ContentBeanXX {
                /**
                 * message : 这B站真的有毒，有时候我把高清换成超清就不卡了～(￣▽￣～)
                 * plat : 2
                 * device :
                 * members : []
                 */

                private String message;
                private int plat;
                private String device;
                private List<?> members;

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }

                public int getPlat() {
                    return plat;
                }

                public void setPlat(int plat) {
                    this.plat = plat;
                }

                public String getDevice() {
                    return device;
                }

                public void setDevice(String device) {
                    this.device = device;
                }

                public List<?> getMembers() {
                    return members;
                }

                public void setMembers(List<?> members) {
                    this.members = members;
                }
            }
        }
    }
}
