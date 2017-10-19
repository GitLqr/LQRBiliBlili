package com.lqr.biliblili.app.data.entity.live;


import java.util.List;

public class GetAllListData {

    private RecommendDataBean recommend_data;
    private List<BannerBean> banner;
    private List<EntranceIconsBean> entranceIcons;
    private List<PartitionsBean> partitions;

    public RecommendDataBean getRecommend_data() {
        return recommend_data;
    }

    public void setRecommend_data(RecommendDataBean recommend_data) {
        this.recommend_data = recommend_data;
    }

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public List<EntranceIconsBean> getEntranceIcons() {
        return entranceIcons;
    }

    public void setEntranceIcons(List<EntranceIconsBean> entranceIcons) {
        this.entranceIcons = entranceIcons;
    }

    public List<PartitionsBean> getPartitions() {
        return partitions;
    }

    public void setPartitions(List<PartitionsBean> partitions) {
        this.partitions = partitions;
    }

    public static class RecommendDataBean {

        private PartitionBean partition;
        private List<LivesBean> lives;
        private List<BannerDataBean> banner_data;

        public PartitionBean getPartition() {
            return partition;
        }

        public void setPartition(PartitionBean partition) {
            this.partition = partition;
        }

        public List<LivesBean> getLives() {
            return lives;
        }

        public void setLives(List<LivesBean> lives) {
            this.lives = lives;
        }

        public List<BannerDataBean> getBanner_data() {
            return banner_data;
        }

        public void setBanner_data(List<BannerDataBean> banner_data) {
            this.banner_data = banner_data;
        }

        public static class PartitionBean {
            /**
             * id : 0
             * name : 推荐主播
             * area : hot
             * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xhdpi/-1.png?20171019172700","height":"42","width":"42"}
             * count : 1750
             */

            private int id;
            private String name;
            private String area;
            private SubIconBean sub_icon;
            private int count;

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

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public SubIconBean getSub_icon() {
                return sub_icon;
            }

            public void setSub_icon(SubIconBean sub_icon) {
                this.sub_icon = sub_icon;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public static class SubIconBean {
                /**
                 * src : http://static.hdslb.com/live-static/images/mobile/android/small/xhdpi/-1.png?20171019172700
                 * height : 42
                 * width : 42
                 */

                private String src;
                private String height;
                private String width;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }
            }
        }

        public static class LivesBean {
            /**
             * owner : {"face":"http://i1.hdslb.com/bfs/face/a2e68765740b7c625fdaa11aa7bf8f9a91a98a31.jpg","mid":25526041,"name":"秦秦秦秦艾德"}
             * cover : {"src":"http://i0.hdslb.com/bfs/live/1efa95f00fa14e344899e7021cf469627ab95b86.jpg","height":180,"width":320}
             * room_id : 470714
             * check_version : 0
             * online : 3521
             * area : 生活娱乐
             * area_id : 6
             * title : 逛园子
             * playurl : http://txy.live-play.acgvideo.com/live-txy/517159/live_25526041_3271517.flv?wsSecret=2ddd09defe868f7cb0713a7c12a880d0&wsTime=1508401921
             * accept_quality : 4
             * broadcast_type : 0
             * is_tv : 0
             * area_v2_id : 26
             * area_v2_name : 日常
             * area_v2_parent_id : 1
             * area_v2_parent_name : 娱乐
             * corner :
             */

            private OwnerBean owner;
            private CoverBean cover;
            private int room_id;
            private int check_version;
            private int online;
            private String area;
            private int area_id;
            private String title;
            private String playurl;
            private String accept_quality;
            private int broadcast_type;
            private int is_tv;
            private int area_v2_id;
            private String area_v2_name;
            private int area_v2_parent_id;
            private String area_v2_parent_name;
            private String corner;

            public OwnerBean getOwner() {
                return owner;
            }

            public void setOwner(OwnerBean owner) {
                this.owner = owner;
            }

            public CoverBean getCover() {
                return cover;
            }

            public void setCover(CoverBean cover) {
                this.cover = cover;
            }

            public int getRoom_id() {
                return room_id;
            }

            public void setRoom_id(int room_id) {
                this.room_id = room_id;
            }

            public int getCheck_version() {
                return check_version;
            }

            public void setCheck_version(int check_version) {
                this.check_version = check_version;
            }

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getArea_id() {
                return area_id;
            }

            public void setArea_id(int area_id) {
                this.area_id = area_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPlayurl() {
                return playurl;
            }

            public void setPlayurl(String playurl) {
                this.playurl = playurl;
            }

            public String getAccept_quality() {
                return accept_quality;
            }

            public void setAccept_quality(String accept_quality) {
                this.accept_quality = accept_quality;
            }

            public int getBroadcast_type() {
                return broadcast_type;
            }

            public void setBroadcast_type(int broadcast_type) {
                this.broadcast_type = broadcast_type;
            }

            public int getIs_tv() {
                return is_tv;
            }

            public void setIs_tv(int is_tv) {
                this.is_tv = is_tv;
            }

            public int getArea_v2_id() {
                return area_v2_id;
            }

            public void setArea_v2_id(int area_v2_id) {
                this.area_v2_id = area_v2_id;
            }

            public String getArea_v2_name() {
                return area_v2_name;
            }

            public void setArea_v2_name(String area_v2_name) {
                this.area_v2_name = area_v2_name;
            }

            public int getArea_v2_parent_id() {
                return area_v2_parent_id;
            }

            public void setArea_v2_parent_id(int area_v2_parent_id) {
                this.area_v2_parent_id = area_v2_parent_id;
            }

            public String getArea_v2_parent_name() {
                return area_v2_parent_name;
            }

            public void setArea_v2_parent_name(String area_v2_parent_name) {
                this.area_v2_parent_name = area_v2_parent_name;
            }

            public String getCorner() {
                return corner;
            }

            public void setCorner(String corner) {
                this.corner = corner;
            }

            public static class OwnerBean {
                /**
                 * face : http://i1.hdslb.com/bfs/face/a2e68765740b7c625fdaa11aa7bf8f9a91a98a31.jpg
                 * mid : 25526041
                 * name : 秦秦秦秦艾德
                 */

                private String face;
                private int mid;
                private String name;

                public String getFace() {
                    return face;
                }

                public void setFace(String face) {
                    this.face = face;
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
            }

            public static class CoverBean {
                /**
                 * src : http://i0.hdslb.com/bfs/live/1efa95f00fa14e344899e7021cf469627ab95b86.jpg
                 * height : 180
                 * width : 320
                 */

                private String src;
                private int height;
                private int width;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }
        }

        public static class BannerDataBean {
            /**
             * cover : {"src":"http://i0.hdslb.com/bfs/live/348fbbc30ca1578d900b44dda64acd1310b1d05e.png","height":180,"width":320}
             * title : 今天，你的小视频上榜了吗？
             * is_clip : 1
             */

            private CoverBeanX cover;
            private String title;
            private int is_clip;

            public CoverBeanX getCover() {
                return cover;
            }

            public void setCover(CoverBeanX cover) {
                this.cover = cover;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getIs_clip() {
                return is_clip;
            }

            public void setIs_clip(int is_clip) {
                this.is_clip = is_clip;
            }

            public static class CoverBeanX {
                /**
                 * src : http://i0.hdslb.com/bfs/live/348fbbc30ca1578d900b44dda64acd1310b1d05e.png
                 * height : 180
                 * width : 320
                 */

                private String src;
                private int height;
                private int width;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }
        }
    }

    public static class BannerBean {
        /**
         * title : 检验欧皇的时刻到了！一叶知秋头衔来袭
         * img : http://i0.hdslb.com/bfs/live/61dfc648d3ce8764cd758f922e770f36badabf99.png
         * remark : 一叶知秋
         * link : http://live.bilibili.com/AppBanner/index?id=615
         */

        private String title;
        private String img;
        private String remark;
        private String link;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }

    public static class EntranceIconsBean {
        /**
         * id : 9
         * name : 绘画专区
         * entrance_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/big/xhdpi/9_big.png?20170927172700","height":"89","width":"89"}
         */

        private int id;
        private String name;
        private EntranceIconBean entrance_icon;

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

        public EntranceIconBean getEntrance_icon() {
            return entrance_icon;
        }

        public void setEntrance_icon(EntranceIconBean entrance_icon) {
            this.entrance_icon = entrance_icon;
        }

        public static class EntranceIconBean {
            /**
             * src : http://static.hdslb.com/live-static/images/mobile/android/big/xhdpi/9_big.png?20170927172700
             * height : 89
             * width : 89
             */

            private String src;
            private String height;
            private String width;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }
        }
    }

    public static class PartitionsBean {
        /**
         * partition : {"id":1,"name":"娱乐","sub_icon":{"src":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/android/android/1_2x.png?201709151052","height":"42","width":"42"},"count":490}
         * lives : [{"roomid":1154737,"uid":25752721,"title":"【声控】攻音，唱歌+聊天","uname":"小小小小小狮子CrysTal","online":789,"user_cover":"http://i0.hdslb.com/bfs/live/2c49e26e766b155ff1dd6573fdd88cced3c1c01d.jpg","user_cover_flag":1,"system_cover":"http://i0.hdslb.com/bfs/live/1154737.jpg?10191557","link":"/1154737","face":"http://i2.hdslb.com/bfs/face/a320d37a93b38b8c8200b922de6e31f162320dba.jpg","cover_size":{"height":180,"width":320},"parent_id":1,"parent_name":"娱乐","area_id":21,"area_name":"唱见","play_url":"http://live-play.acgvideo.com/live/391/live_25752721_3411081.flv?wsSecret=6b2b04ac3116d16a1275bded112d390d&wsTime=59c0dd09","accept_quality":"4","broadcast_type":0,"is_tv":0,"corner":""},{"roomid":470714,"uid":25526041,"title":"逛园子","uname":"秦秦秦秦艾德","online":3521,"user_cover":"http://i0.hdslb.com/bfs/live/1efa95f00fa14e344899e7021cf469627ab95b86.jpg","user_cover_flag":1,"system_cover":"http://i0.hdslb.com/bfs/live/470714.jpg?10191557","link":"/470714","face":"http://i1.hdslb.com/bfs/face/a2e68765740b7c625fdaa11aa7bf8f9a91a98a31.jpg","cover_size":{"height":180,"width":320},"parent_id":1,"parent_name":"娱乐","area_id":26,"area_name":"日常","play_url":"http://txy.live-play.acgvideo.com/live-txy/402241/live_25526041_3271517.flv?wsSecret=94b4e9e1a0fe0e6d38433aa03336d7d1&wsTime=1508401921","accept_quality":"4","broadcast_type":0,"is_tv":0,"corner":""},{"roomid":54869,"uid":881785,"title":"染头发啦","uname":"雪莹yuki","online":9897,"user_cover":"http://i0.hdslb.com/bfs/live/1c76879f2967250d658a7ea943969ba07bdd1253.jpg","user_cover_flag":1,"system_cover":"http://i0.hdslb.com/bfs/live/54869.jpg?10191556","link":"/195","face":"http://i0.hdslb.com/bfs/face/d554c3185209b455b24d27385c25d2a6ef9184e7.jpg","cover_size":{"height":180,"width":320},"parent_id":1,"parent_name":"娱乐","area_id":32,"area_name":"手机直播","play_url":"http://live-play.acgvideo.com/live/506/live_881785_6343266.flv?wsSecret=c1b3bb4578c9699132ead328dfd11fbc&wsTime=59c0dd09","accept_quality":"4","broadcast_type":0,"is_tv":0,"corner":""},{"roomid":1047975,"uid":13086801,"title":"【英文】唱功？还真不错！！","uname":"夸夸Dominic","online":1192,"user_cover":"http://i0.hdslb.com/bfs/live/b80a05699beac57d4432bc24fafce651bc0a0bbf.jpg","user_cover_flag":1,"system_cover":"http://i0.hdslb.com/bfs/live/1047975.jpg?10191557","link":"/391","face":"http://i1.hdslb.com/bfs/face/188513b421d127e2d3102270e7fb7356c023bad1.jpg","cover_size":{"height":180,"width":320},"parent_id":1,"parent_name":"娱乐","area_id":21,"area_name":"唱见","play_url":"http://txy.live-play.acgvideo.com/live-txy/317420/live_13086801_6538715.flv?wsSecret=089248f80616c3c88677c45ec4d397f8&wsTime=1508401921","accept_quality":"4","broadcast_type":0,"is_tv":0,"corner":""},{"roomid":286893,"uid":13763303,"title":"东京美女主播教你最地道的日语会话","uname":"月见兔","online":5772,"user_cover":"http://i0.hdslb.com/bfs/live/72c8821464e4b39347b6cdc683f1f794ae464a5e.jpg","user_cover_flag":1,"system_cover":"http://i0.hdslb.com/bfs/live/286893.jpg?10191558","link":"/320","face":"http://i0.hdslb.com/bfs/face/3d3c3ed32097bf15a11f8a291ceaa8907a932cb2.jpg","cover_size":{"height":180,"width":320},"parent_id":1,"parent_name":"娱乐","area_id":27,"area_name":"学习","play_url":"http://txy.live-play.acgvideo.com/live-txy/773430/live_13763303_3863644.flv?wsSecret=c06f20a358b9aeceaf075c1bed75e0e8&wsTime=1508401921","accept_quality":"4","broadcast_type":0,"is_tv":0,"corner":""},{"roomid":271913,"uid":292445,"title":"突然练一练吉他！","uname":"爽爽子","online":725,"user_cover":"http://i0.hdslb.com/bfs/live/0df92048cb1525b3b49cf82c6f749216343802ff.jpg","user_cover_flag":1,"system_cover":"http://i0.hdslb.com/bfs/live/271913.jpg?10191557","link":"/271913","face":"http://i1.hdslb.com/bfs/face/d2178e159cf76a9273e8d5151c3d3f2e9a52b4fb.jpg","cover_size":{"height":180,"width":320},"parent_id":1,"parent_name":"娱乐","area_id":32,"area_name":"手机直播","play_url":"http://live-play.acgvideo.com/live/223/live_292445_1620925.flv?wsSecret=b0a093471b7fbbf82b649d3cd95dfe51&wsTime=59c0dd09","accept_quality":"4","broadcast_type":0,"is_tv":0,"corner":""}]
         */

        private PartitionBeanX partition;
        private List<LivesBeanX> lives;

        public PartitionBeanX getPartition() {
            return partition;
        }

        public void setPartition(PartitionBeanX partition) {
            this.partition = partition;
        }

        public List<LivesBeanX> getLives() {
            return lives;
        }

        public void setLives(List<LivesBeanX> lives) {
            this.lives = lives;
        }

        public static class PartitionBeanX {
            /**
             * id : 1
             * name : 娱乐
             * sub_icon : {"src":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/android/android/1_2x.png?201709151052","height":"42","width":"42"}
             * count : 490
             */

            private int id;
            private String name;
            private SubIconBeanX sub_icon;
            private int count;

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

            public SubIconBeanX getSub_icon() {
                return sub_icon;
            }

            public void setSub_icon(SubIconBeanX sub_icon) {
                this.sub_icon = sub_icon;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public static class SubIconBeanX {
                /**
                 * src : http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/android/android/1_2x.png?201709151052
                 * height : 42
                 * width : 42
                 */

                private String src;
                private String height;
                private String width;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }
            }
        }

        public static class LivesBeanX {
            /**
             * roomid : 1154737
             * uid : 25752721
             * title : 【声控】攻音，唱歌+聊天
             * uname : 小小小小小狮子CrysTal
             * online : 789
             * user_cover : http://i0.hdslb.com/bfs/live/2c49e26e766b155ff1dd6573fdd88cced3c1c01d.jpg
             * user_cover_flag : 1
             * system_cover : http://i0.hdslb.com/bfs/live/1154737.jpg?10191557
             * link : /1154737
             * face : http://i2.hdslb.com/bfs/face/a320d37a93b38b8c8200b922de6e31f162320dba.jpg
             * cover_size : {"height":180,"width":320}
             * parent_id : 1
             * parent_name : 娱乐
             * area_id : 21
             * area_name : 唱见
             * play_url : http://live-play.acgvideo.com/live/391/live_25752721_3411081.flv?wsSecret=6b2b04ac3116d16a1275bded112d390d&wsTime=59c0dd09
             * accept_quality : 4
             * broadcast_type : 0
             * is_tv : 0
             * corner :
             */

            private int roomid;
            private int uid;
            private String title;
            private String uname;
            private int online;
            private String user_cover;
            private int user_cover_flag;
            private String system_cover;
            private String link;
            private String face;
            private CoverSizeBean cover_size;
            private int parent_id;
            private String parent_name;
            private int area_id;
            private String area_name;
            private String play_url;
            private String accept_quality;
            private int broadcast_type;
            private int is_tv;
            private String corner;

            public int getRoomid() {
                return roomid;
            }

            public void setRoomid(int roomid) {
                this.roomid = roomid;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public String getUser_cover() {
                return user_cover;
            }

            public void setUser_cover(String user_cover) {
                this.user_cover = user_cover;
            }

            public int getUser_cover_flag() {
                return user_cover_flag;
            }

            public void setUser_cover_flag(int user_cover_flag) {
                this.user_cover_flag = user_cover_flag;
            }

            public String getSystem_cover() {
                return system_cover;
            }

            public void setSystem_cover(String system_cover) {
                this.system_cover = system_cover;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public CoverSizeBean getCover_size() {
                return cover_size;
            }

            public void setCover_size(CoverSizeBean cover_size) {
                this.cover_size = cover_size;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public String getParent_name() {
                return parent_name;
            }

            public void setParent_name(String parent_name) {
                this.parent_name = parent_name;
            }

            public int getArea_id() {
                return area_id;
            }

            public void setArea_id(int area_id) {
                this.area_id = area_id;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }

            public String getPlay_url() {
                return play_url;
            }

            public void setPlay_url(String play_url) {
                this.play_url = play_url;
            }

            public String getAccept_quality() {
                return accept_quality;
            }

            public void setAccept_quality(String accept_quality) {
                this.accept_quality = accept_quality;
            }

            public int getBroadcast_type() {
                return broadcast_type;
            }

            public void setBroadcast_type(int broadcast_type) {
                this.broadcast_type = broadcast_type;
            }

            public int getIs_tv() {
                return is_tv;
            }

            public void setIs_tv(int is_tv) {
                this.is_tv = is_tv;
            }

            public String getCorner() {
                return corner;
            }

            public void setCorner(String corner) {
                this.corner = corner;
            }

            public static class CoverSizeBean {
                /**
                 * height : 180
                 * width : 320
                 */

                private int height;
                private int width;

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }
        }
    }
}
