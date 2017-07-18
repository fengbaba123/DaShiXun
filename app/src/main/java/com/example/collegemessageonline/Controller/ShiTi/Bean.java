package com.example.collegemessageonline.Controller.ShiTi;

import java.util.List;

/**
 * Created by 陆向阳 on 2017/7/12.
 */

public class Bean {


    /**
     * state : true
     * more : true
     * time : 0
     * data : [{"contentid":10668,"modelid":2,"title":"非物遗\u201c守艺人\u201d：棒锣歌 三种手艺一种人生","thumb":"http://upload.univs.cn/2017/0710/thumb_160_120_1499674205918.jpg","description":"\u201c很希望我们这个团队能够给武隆带去盛夏里的春天。\u201d志愿者申小凡在出发前这样说道重庆理工大学管理学院脱贫攻坚服务团一行人走进重庆武隆天坑寨子，感受非文化遗产的魅力。","comments":0,"sorttime":1499674310},{"contentid":10645,"modelid":2,"title":"重理工学子走访老党员：我曾拿过钢枪 却独居在村庄","thumb":"http://upload.univs.cn/2017/0706/thumb_160_120_1499324236141.jpg","description":"抗美援朝老兵，曾在战场上扛枪打仗，也曾经历国家变革。重庆理工大学管理学院社会实践服务团怀揣着一颗对前辈的敬重之心，用镜头记录他们生活的琐碎，用快门定格每一个接触的瞬间。（重庆理工大学 欧敏 倪元鑫）","comments":0,"sorttime":1499325289},{"contentid":10640,"modelid":1,"title":"\u201c喜迎十九大 最美中国行\u201d 2017暑期社会实践成果展活动通知","thumb":"http://upload.univs.cn/2017/0703/thumb_160_120_1499050070102.jpg","description":"为展现2017年全国大中专学生暑期社会实践活动的丰硕成果，展示学生青春风采，挖掘并宣传一批优秀的、有价值、有成效的暑期社会实践团队、事迹，喜迎党的十九大胜利召开，全国高校校园网站联盟、","comments":0,"sorttime":1499131746},{"contentid":10612,"modelid":1,"title":"通讯员故事| 网络管理部部长兼校园网络通讯站站长王发利","thumb":"http://upload.univs.cn/2017/0627/thumb_160_120_1498544869861.jpg","description":"现任网管部部长兼校园网络通讯站站长王发利","comments":0,"sorttime":1498708440},{"contentid":10611,"modelid":1,"title":"合工大翡翠湖校区十大景色出炉，邀您来赏","thumb":"http://upload.univs.cn/2017/0629/thumb_160_120_1498697342988.jpg","description":"钢铁的光泽熠熠生辉，智慧与勤劳的结晶在太阳下闪耀，工大学子工业报国的志向，在实验楼东侧的室外大展览，展现得淋漓尽致。","comments":0,"sorttime":1498708411},{"contentid":10610,"modelid":1,"title":"[漂流日记] 这次大学生输了 输给了小学生","thumb":"http://upload.univs.cn/2017/0629/thumb_160_120_1498698082985.jpg","description":"热爱祖国从热爱国旗国歌做起！","comments":0,"sorttime":1498708411},{"contentid":10609,"modelid":1,"title":"安徽师大志愿行：七年之约 我们只和自己较量","thumb":"http://upload.univs.cn/2017/0629/thumb_160_120_1498698788422.jpg","description":"菖蒲花语，信仰者的幸福。从2011年到2017年，从江城芜湖到岳西菖蒲，从弘扬国学经典到创新阅读与写作，有这样一群大学生志愿者，用一颗诚挚的真心与一颗火热的爱心，在菖蒲这片山清水秀的土地上","comments":0,"sorttime":1498708411},{"contentid":10608,"modelid":1,"title":"一片皮呼圣唤贤 三根竹能文能武\u2014\u2014用纸说话的皮影艺术","thumb":"http://upload.univs.cn/2017/0629/thumb_160_120_1498699525767.jpg","description":"皮影戏是我国民间工艺美术和戏曲艺术巧妙结合而成的独特艺术形式，是中华民族艺术殿堂里不可或缺的一颗精巧明珠。水东探访皮影团队充分的利用暑期社会实践学习皮影的机会，感受皮影源远流长的历","comments":0,"sorttime":1498708411},{"contentid":10568,"modelid":1,"title":"段子| 那些年 我们经历过的奇葩考试","thumb":"http://upload.univs.cn/2017/0620/thumb_160_120_1497922593349.jpg","description":"只要专业选得好，年年期末似高考。 六月的暖风中夹杂着期末考试的气息 又又又到一学期的考试周","comments":0,"sorttime":1498032411},{"contentid":10567,"modelid":1,"title":"为什么你找不到改变自己的动力？","thumb":"http://upload.univs.cn/2017/0620/thumb_160_120_1497922660780.jpg","description":"\u201c如果你知道自己做事的目的，取得成功就很棒；但是如果你不知道，成功的果实，就会变成可怕的陷阱。\u201d","comments":0,"sorttime":1498032411}]
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
         * contentid : 10668
         * modelid : 2
         * title : 非物遗“守艺人”：棒锣歌 三种手艺一种人生
         * thumb : http://upload.univs.cn/2017/0710/thumb_160_120_1499674205918.jpg
         * description : “很希望我们这个团队能够给武隆带去盛夏里的春天。”志愿者申小凡在出发前这样说道重庆理工大学管理学院脱贫攻坚服务团一行人走进重庆武隆天坑寨子，感受非文化遗产的魅力。
         * comments : 0
         * sorttime : 1499674310
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
