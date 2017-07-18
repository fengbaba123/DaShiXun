package com.example.collegemessageonline.Controller.ShiTi;

import java.util.List;

/**
 * Created by 陆向阳 on 2017/7/12.
 */

public class HuoDongShiTi {

    /**
     * state : true
     * more : true
     * time : 0
     * data : [{"contentid":10114,"modelid":3,"title":"第二届全国大学生网络文化节","thumb":"http://upload.univs.cn/2017/0426/thumb_160_120_1493188870424.jpg","description":"为全面贯彻落实全国高校思想政治工作会议精神，进一步丰富优质网络文化内容供给，教育部思想政治工作司、中央网信办网络社会工作局在前期工作的基础上，决定联合开展\u201c第二届全国大学生网络文化节\u201d。","comments":0,"sorttime":1493188895},{"contentid":10113,"modelid":3,"title":"全国大学生公益广告作品征集活动","thumb":"http://upload.univs.cn/2017/0426/thumb_160_120_1493188386162.jpg","description":"学生个体（团队）可自荐作品数量不限，各部属高校可推荐平面作品10件、视频作品5件，各省（区、市）党委教育工作部门可推荐平面作品20件、视频作品10件。","comments":0,"sorttime":1493188397},{"contentid":9980,"modelid":3,"title":"2017年全国大学生摄影月赛","thumb":"http://upload.univs.cn/2017/0407/thumb_160_120_1491530592508.jpg","description":"\u201c把生活中稍纵即逝的平凡转化为不朽的视觉图像\u201d是我们不懈的追求。\n全国大学生摄影比赛（月赛）在这里，鼓励你们追寻梦想，做个快乐的大学生摄影家！","comments":0,"sorttime":1491530607},{"contentid":9979,"modelid":3,"title":"第十二届中国大学生年度人物评选","thumb":"http://upload.univs.cn/2017/0407/thumb_160_120_1491530171807.jpg","description":"本次活动将在人民网开通活动官方网站、手机官网并在中国大学生网、中国大学生在线设立活动专题页面。同时人民网、《大学生》杂志、中国大学生在线将在自己的微信公众号和《大学生》手机APP及时发布活动进展情况。","comments":0,"sorttime":1491530241},{"contentid":9974,"modelid":3,"title":"\u201c如何规范发展党员\u201d示范性党课","thumb":"","description":"本次党课，由视频中刘淯森同学扮演的\u201c刘小白\u201d不知道如何入党开篇，而后讲述了其在一位党性修养较高的学姐的帮助下顺利入党的故事。视频以故事情节的形式，在一问一答间详细介绍了发展党员的具体流程","comments":0,"sorttime":1491529277},{"contentid":9972,"modelid":3,"title":"全国高校\u201c两学一做\u201d支部风采展示活动","thumb":"http://upload.univs.cn/2017/0407/thumb_160_120_1491529591423.jpg","description":"支部工作案例、微党课是学习\"两学一做\"的重要载体，要求围绕阶段性主题，做到思想观点正确、内容积极健康。各级高校党委要对提交内容质量进行政治把关、认真推敲、仔细琢磨、精益求精、体现高水准高质量。","comments":0,"sorttime":1491528787}]
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
         * contentid : 10114
         * modelid : 3
         * title : 第二届全国大学生网络文化节
         * thumb : http://upload.univs.cn/2017/0426/thumb_160_120_1493188870424.jpg
         * description : 为全面贯彻落实全国高校思想政治工作会议精神，进一步丰富优质网络文化内容供给，教育部思想政治工作司、中央网信办网络社会工作局在前期工作的基础上，决定联合开展“第二届全国大学生网络文化节”。
         * comments : 0
         * sorttime : 1493188895
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
