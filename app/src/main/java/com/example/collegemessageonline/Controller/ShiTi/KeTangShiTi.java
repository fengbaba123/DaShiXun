package com.example.collegemessageonline.Controller.ShiTi;

import java.util.List;

/**
 * Created by 陆向阳 on 2017/7/12.
 */

public class KeTangShiTi {

    /**
     * state : true
     * more : true
     * time : 0
     * data : [{"contentid":10666,"modelid":1,"title":"习中华文化，扬国萃传统","thumb":"http://upload.univs.cn/2017/0710/thumb_160_120_1499671649724.jpg","description":"7月8日，安徽师范大学赴蚌埠市固镇第三中学暑期实践团队为固镇三中的孩子们带去了准备已久的传统文化教习。分别开展书法、中国结以及传统文化的特色教习。激发学生们对优秀传统文化的喜爱，意识","comments":0,"sorttime":1499672458},{"contentid":10665,"modelid":1,"title":"【传统精粹】\u201c安庆不仅只有黄梅戏，还有高腔\u201d","thumb":"http://upload.univs.cn/2017/0710/thumb_160_120_1499672278645.jpg","description":"\u201c你们大学生关注到岳西高腔，我很激动。提到安庆，大部分人只知黄梅戏，可咱的高腔，不差呀，不能失传了啊。\u201d五河镇关工委主任，义务传播岳西高腔的王学钿老先生深情地说。在响涧幽谷的大别山","comments":0,"sorttime":1499672442},{"contentid":10664,"modelid":1,"title":"安徽师大青年学子走进大别山区创新演绎传统文化","thumb":"http://upload.univs.cn/2017/0710/thumb_160_120_1499672316899.jpg","description":"安徽师范大学文学院赴安庆北中社会实践团队匠心独运，多元融通，在日常教学过程中将传统文化与现实生活\u201c有温度的连接\u201d，把看似高深莫测的传统文化带到学生身边，将理论性的文化知识转变为延展","comments":0,"sorttime":1499672442},{"contentid":10654,"modelid":1,"title":"\u201c红\u201d扬阅读：红色文化进课堂","thumb":"http://upload.univs.cn/2017/0707/thumb_160_120_1499409072559.jpg","description":"安徽师大赴河南潢川的支教老师将红色主题教育和阅读结合起来，开办了一节别开生面的爱国主题教育阅读课\u2014\u2014《我的战友邱少云》。","comments":0,"sorttime":1499409167},{"contentid":10652,"modelid":1,"title":"报考高职院校 参看质量年报","thumb":"http://upload.univs.cn/2017/0630/thumb_160_120_1498791923853.jpg","description":"本报告自2012年首发以来，始终坚持第三方的独立性，力求面向社会大众，从\u201c学生发展是根本，学校工作是重点，政府推动是保障，服务地方是特色\u201d四个维度，每年对高等职业教育的质量状况进行分析","comments":0,"sorttime":1499397218},{"contentid":10651,"modelid":1,"title":"安禅静思逢小暑","thumb":"http://upload.univs.cn/2017/0704/thumb_160_120_1499156224667.jpg","description":"小暑是农历二十节气之第十一个节气，夏天的第五个节气。小暑大约是每年的7月7日到8日左右，太阳到达黄经105度时称为小暑节气。暑，表示炎热的意思，小暑为小热，表明天气还不十分热，意指天气开","comments":0,"sorttime":1499330755},{"contentid":10650,"modelid":1,"title":"小暑传说：龙宫晒龙袍","thumb":"http://upload.univs.cn/2017/0706/thumb_160_120_1499322603615.png","description":"\u201c六月六\u201d相传这是龙宫晒龙袍的日子。因为这一天，差不多是在小暑的前夕，为一年中气温最高，日照时间最长，阳光辐射最强的日子，所以家家户户多会不约而同的选择这一天\u201c晒伏\u201d，就是把存放在","comments":0,"sorttime":1499330755},{"contentid":10649,"modelid":1,"title":"文雅节气，古诗中的小暑","thumb":"http://upload.univs.cn/2017/0706/thumb_160_120_1499322695856.png","description":"小暑有三候：\u201c一候温风至；二候蟋蟀居宇；三候鹰始鸷。\u201d突然暖暖的热风到了，原来是循着小暑的节气而来。小暑雷雨天气也开始多了起来，蟋蟀也因暑热从田野来到人家房屋下避暑。老鹰也因地面气","comments":0,"sorttime":1499330755},{"contentid":10648,"modelid":1,"title":"小暑养生：宅在家里避暑气，少动多静保阳气","thumb":"http://upload.univs.cn/2017/0706/thumb_160_120_1499322734708.png","description":"小暑节气已经是夏天的开始了，气温日渐升高，小暑养生最关键 ","comments":0,"sorttime":1499330755},{"contentid":10647,"modelid":1,"title":"小暑习俗：吃饺子、晒伏","thumb":"http://upload.univs.cn/2017/0706/thumb_160_120_1499322719997.png","description":"《月令七十二候集解》：\u201c六月节\u2026\u2026暑，热也，就热之中分为大小，月初为小，月中为大，今则热气犹小也。\u201d暑，表示炎热的意思，古人认为小暑期间，还不是一年中最热的时候，故称为小暑。也有节","comments":0,"sorttime":1499330755}]
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
         * contentid : 10666
         * modelid : 1
         * title : 习中华文化，扬国萃传统
         * thumb : http://upload.univs.cn/2017/0710/thumb_160_120_1499671649724.jpg
         * description : 7月8日，安徽师范大学赴蚌埠市固镇第三中学暑期实践团队为固镇三中的孩子们带去了准备已久的传统文化教习。分别开展书法、中国结以及传统文化的特色教习。激发学生们对优秀传统文化的喜爱，意识
         * comments : 0
         * sorttime : 1499672458
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
