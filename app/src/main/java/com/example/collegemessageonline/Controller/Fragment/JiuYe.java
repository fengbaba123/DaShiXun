package com.example.collegemessageonline.Controller.Fragment;

import java.util.List;

/**
 * Created by 陆向阳 on 2017/7/12.
 */

public class JiuYe {

    /**
     * state : true
     * more : true
     * time : 0
     * data : [{"contentid":10653,"modelid":1,"title":"[求职经]笨鸟先飞，实习生你准备好起飞了吗？","thumb":"http://upload.univs.cn/2017/0707/thumb_160_120_1499408771576.jpg","description":"如果你还没有到找工作的年纪，那么恭喜你，很多事情，越早知道越好。","comments":0,"sorttime":1499408854},{"contentid":10646,"modelid":1,"title":"[东林创业故事]之\u201c匠心传承\u201d\u2014\u2014道印轩","thumb":"http://upload.univs.cn/2017/0706/thumb_160_120_1499325652691.png","description":"东林大学生赵赫等人开拓创新，建立道印轩，传承匠心，是新时代大学生的楷模。","comments":0,"sorttime":1499325783},{"contentid":10634,"modelid":1,"title":"[简历助手]零工作经验的应届生如何写简历？","thumb":"http://upload.univs.cn/2017/0703/thumb_160_120_1499048927731.jpg","description":"无工作经验是应届生的特权，有工作经验了那还叫应届生？所以应届生简历不是要去凸显你多么老练多么牛逼，而是表现你的能力和这个岗位十分匹配。你所有的经历，都可以化成能力，并且在简历上展现","comments":0,"sorttime":1499049036},{"contentid":10633,"modelid":1,"title":"5项权益、6种补贴，送给步入职场的你！","thumb":"http://upload.univs.cn/2017/0703/thumb_160_120_1499047828171.jpg","description":"职场生活有哪些权益必须注意？国家为职场人准备了哪些补贴政策？","comments":0,"sorttime":1499047993},{"contentid":10616,"modelid":1,"title":"[求职经]高校毕业生面临就业大考 面试靠实力还是凭运气？","thumb":"http://upload.univs.cn/2017/0629/thumb_160_120_1498722584341.jpeg","description":"获得理想的工作并不轻松，取得面试的机会，却几乎是每一个求职者必然会经历的过程。常有求职者笑言\u201c成也面试，败也面试\u201d，面试如何发挥，有时候就成了求职成败的关键。","comments":0,"sorttime":1498722806},{"contentid":10615,"modelid":1,"title":"早就业的学生比考研的学生多赚几十万？真相在这","thumb":"http://upload.univs.cn/2017/0629/thumb_160_120_1498722536713.png","description":"能在艰苦的环境和巨大的压力下坚持下来的人，从来都最有资格接受成功。能在紧要关头选择继续深造自己，在图书馆夜以继日地备战和习惯坐冷板凳的人，会差到哪里？","comments":0,"sorttime":1498722806},{"contentid":10597,"modelid":1,"title":"斯坦福给被拒学生的信：什么东西能真正影响我们的一生？","thumb":"http://upload.univs.cn/2017/0626/thumb_160_120_1498459776927.jpg","description":"真正能够影响我们一生的，并不是你在哪里上的大学，而是你在那里学到了什么，以及你与他人的与众不同之处。","comments":0,"sorttime":1498459859},{"contentid":10596,"modelid":1,"title":"[人在职场]内向的人，职场发展会很差么？","thumb":"http://upload.univs.cn/2017/0626/thumb_160_120_1498459226889.jpg","description":"因为内向，我对新环境的融入程度总会比其他人来得更长一些，我总是给自己找理由称这是慢热，但直到我入职半年，许多同事都还对我没印象的时候，我才发现，其实或许不是同事不能记得我，而是我从","comments":0,"sorttime":1498459853},{"contentid":10580,"modelid":1,"title":"[职业规划]没有特定的兴趣，该如何选择职业？","thumb":"http://upload.univs.cn/2017/0623/thumb_160_120_1498186022747.jpg","description":"优秀的职业生涯，一定离不开精心的设计；而如何进行职业选择，则是这场设计中至关重要的第一步。","comments":0,"sorttime":1498186900},{"contentid":10579,"modelid":1,"title":"[求职经]为什么大学生毕业后找不到工作？","thumb":"http://upload.univs.cn/2017/0623/thumb_160_120_1498186642210.png","description":"大学的真正意义是认识你自己，完成对世界、对社会、对自己深刻但清晰的认知，知道自己要什么，不要什么，赞成什么，反对什么，能做什么，不能做什么。","comments":0,"sorttime":1498186770}]
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
         * contentid : 10653
         * modelid : 1
         * title : [求职经]笨鸟先飞，实习生你准备好起飞了吗？
         * thumb : http://upload.univs.cn/2017/0707/thumb_160_120_1499408771576.jpg
         * description : 如果你还没有到找工作的年纪，那么恭喜你，很多事情，越早知道越好。
         * comments : 0
         * sorttime : 1499408854
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
