package com.example.collegemessageonline.Controller.ShiTi;

import java.util.List;

/**
 * Created by 陆向阳 on 2017/7/12.
 */

public class HeadLineShiTi {

    /**
     * state : true
     * more : true
     * time : 0
     * data : [{"contentid":10670,"modelid":1,"title":"一声齐齐哈尔大学人 一生齐齐哈尔大学情","thumb":"http://upload.univs.cn/2017/0711/thumb_160_120_1499737407367.png","description":"\u201c一声齐齐哈尔大学人，一生齐齐哈尔大学情\u201d ","comments":0,"sorttime":1499742788},{"contentid":10669,"modelid":1,"title":"人大校长毕业致辞：有信仰，不孤独","thumb":"http://upload.univs.cn/2017/0711/thumb_160_120_1499736447136.jpg","description":"2017年中国人民大学校长在毕业典礼上的讲话","comments":0,"sorttime":1499736510},{"contentid":10663,"modelid":1,"title":"加强思政工作宿舍阵地建设 打造宿舍党建活动基地","thumb":"http://upload.univs.cn/2017/0710/thumb_160_120_1499665860899.jpg","description":"为充分发挥学生宿舍的\u201c第二课堂\u201d作用，加强思想政治工作宿舍阵地建设，积极推进思想和文化引领，学生宿舍管理中心于近日打造\u201c学生宿舍党建活动基地\u201d，面向各学院及全体学生开放","comments":0,"sorttime":1499665887},{"contentid":10662,"modelid":1,"title":"倏忽温风至 暑从何去？","thumb":"","description":"\u201c倏忽温风至，因循小暑来。\u201d伴随着阵阵热浪，我们迎来了小暑节气。\u201c小暑大暑，上蒸下煮\u201d，\u201c三伏天\u201d的序幕徐徐拉开。小暑是人体阳气最旺盛的时候，盛夏时节，养生要先\u201c静心\u201d。","comments":0,"sorttime":1499654712},{"contentid":10661,"modelid":1,"title":"电子科技大学自动化学院多方位提升学子\u201c新四会\u201d能力","thumb":"http://upload.univs.cn/2017/0710/thumb_160_120_1499654065742.jpg","description":"为全面贯彻落实全国高校思想政治工作会议精神，紧密围绕学校建设\u201c中国特色、世界一流\u201d大学的发展目标，实现全员全程全方位育人，电子科技大学自动化工程学院在用好课堂教学主渠道的同时，积极探索、创新思维","comments":0,"sorttime":1499654521},{"contentid":10660,"modelid":1,"title":"行动力，是对平庸生活最好的回击","thumb":"http://upload.univs.cn/2017/0710/thumb_160_120_1499648597123.jpg","description":"不行动，梦想就只是好高骛远；不执行，目标就只是海市蜃楼；不动手去做，理想生活就只是镜花水月，只能在幻觉里空欢喜一场。\n","comments":0,"sorttime":1499654378},{"contentid":10659,"modelid":1,"title":"高校毕业季：大学生如何上好\u201c最后一课\u201d","thumb":"http://upload.univs.cn/2017/0707/thumb_160_120_1499413960639.jpg","description":"又是一年毕业季，被称为大学生\u201c最后一课\u201d的高校毕业典礼再度成为舆论焦点。各种\u201c人生寄语\u201d、各式创意合影、各类\u201c红毯仪式\u201d\u2026\u2026今年，又有一批诞生于毕业典礼的大咖\u201c金句\u201d、校长合影走红网络，刷屏微信朋友圈","comments":0,"sorttime":1499414489},{"contentid":10658,"modelid":1,"title":"李彦宏：AI时代 世界会变得更简单","thumb":"http://upload.univs.cn/2017/0707/thumb_160_120_1499396152137.jpg","description":"7月5日，\u201c百度AI开发者大会\u201d在北京举办，会上百度首次公开AI发展战略和布局，宣布推出DuerOS和Apollo两大开放平台。","comments":0,"sorttime":1499413155},{"contentid":10657,"modelid":1,"title":"以油\u201c汇\u201d友：第三届中国国际学生石油论坛在岛城召开","thumb":"http://upload.univs.cn/2017/0707/thumb_160_120_1499390592805.jpg","description":"6月30日至7月2日，第三届石油汇：中国国际学生石油论坛（The 3rd Petro-Gathering: China International Student Petroleum Forum）在中国石油大学（华东）举行。","comments":0,"sorttime":1499413042},{"contentid":10656,"modelid":1,"title":"西工大AR录取通知书受到媒体的广泛报道","thumb":"http://upload.univs.cn/2017/0707/thumb_160_120_1499390011444.jpg","description":"7月4日17:00，西北工业大学2017年首封AR录取通知书正式发出后，嵌入\u201c黑科技\u201dAR技术的录取通知书迅速走红。","comments":0,"sorttime":1499413001}]
     */

    private boolean state;
    private boolean more;
    private int time;
    private List<DataBean> data;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * contentid : 10670
         * modelid : 1
         * title : 一声齐齐哈尔大学人 一生齐齐哈尔大学情
         * thumb : http://upload.univs.cn/2017/0711/thumb_160_120_1499737407367.png
         * description : “一声齐齐哈尔大学人，一生齐齐哈尔大学情”
         * comments : 0
         * sorttime : 1499742788
         */

        private int contentid;
        private int modelid;
        private String title;
        private String thumb;
        private String description;
        private int comments;
        private int sorttime;

        public int getContentid() {
            return contentid;
        }

        public void setContentid(int contentid) {
            this.contentid = contentid;
        }

        public int getModelid() {
            return modelid;
        }

        public void setModelid(int modelid) {
            this.modelid = modelid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public int getSorttime() {
            return sorttime;
        }

        public void setSorttime(int sorttime) {
            this.sorttime = sorttime;
        }
    }
}
