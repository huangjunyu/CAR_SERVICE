package com.example.administrator.carservice.news;

import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */
public class NewsBody {
    /**
     * status : 0
     * msg : ok
     * result : {"channel":"头条","num":"1","list":[{"title":"俄科学家研制防治雾霾催化剂","time":"2016-12-24 09:43","src":"环球网","category":"tech","pic":"http://api.jisuapi.com/news/upload/20161224/110002_61031.jpg","content":"<p class=\"art_t\">　　俄罗斯卫星新闻网12月22日报道称，据《西伯利亚科研新闻》杂志载文报道，托姆斯克国立大学的科学家们正在研制一种新的银催化剂(silver catalyst)，用于空气的过滤净化。<\/p><p class=\"art_t\">　　这种催化剂能够分解有毒煤气、甲醛等有害的空气中颗粒，分解成无毒的物质。报道指出，这种催化剂用于净化空气是氧化硅制成的纳米管，直径为6至10纳米，管内负载的是银和氧化铈的合成。<\/p><p class=\"art_t\">　　托姆斯克国立大学催化研究实验室高级研究员马蒙托夫指出，\"预计，得到的粉状物或颗粒催化剂能够用于家庭办公以及工厂车间用的空气净化设备。同时使用时不需要加热，与很多同类产品的区别是，催化剂是活性的而且常温下具有很好的稳定性\"。<\/p><p class=\"art_t\">　　他还表示，这种催化剂对于预防煤气中毒和甲醛中毒非常有效，同时使这些有毒物分解成无毒成分，还能够分解其它的有害空气颗粒。马蒙托夫说：\"首先，工业区和城市中，这种催化剂可以用来防治工业有毒气体排放、抵御森林火灾引发的雾霾，这种雾霾含有大量的煤气。此外，催化剂还能够治理化工厂的气体排放，以及净化汽车尾气\"。<\/p>","url":"http://tech.sina.cn/d/zr/2016-12-24/detail-ifxyxusa5128019.d.html?vt=4&pos=108","weburl":"http://tech.sina.com.cn/d/n/2016-12-24/doc-ifxyxusa5128019.shtml"}]}
     */

    private String status;
    private String msg;
    /**
     * channel : 头条
     * num : 1
     * list : [{"title":"俄科学家研制防治雾霾催化剂","time":"2016-12-24 09:43","src":"环球网","category":"tech","pic":"http://api.jisuapi.com/news/upload/20161224/110002_61031.jpg","content":"<p class=\"art_t\">　　俄罗斯卫星新闻网12月22日报道称，据《西伯利亚科研新闻》杂志载文报道，托姆斯克国立大学的科学家们正在研制一种新的银催化剂(silver catalyst)，用于空气的过滤净化。<\/p><p class=\"art_t\">　　这种催化剂能够分解有毒煤气、甲醛等有害的空气中颗粒，分解成无毒的物质。报道指出，这种催化剂用于净化空气是氧化硅制成的纳米管，直径为6至10纳米，管内负载的是银和氧化铈的合成。<\/p><p class=\"art_t\">　　托姆斯克国立大学催化研究实验室高级研究员马蒙托夫指出，\"预计，得到的粉状物或颗粒催化剂能够用于家庭办公以及工厂车间用的空气净化设备。同时使用时不需要加热，与很多同类产品的区别是，催化剂是活性的而且常温下具有很好的稳定性\"。<\/p><p class=\"art_t\">　　他还表示，这种催化剂对于预防煤气中毒和甲醛中毒非常有效，同时使这些有毒物分解成无毒成分，还能够分解其它的有害空气颗粒。马蒙托夫说：\"首先，工业区和城市中，这种催化剂可以用来防治工业有毒气体排放、抵御森林火灾引发的雾霾，这种雾霾含有大量的煤气。此外，催化剂还能够治理化工厂的气体排放，以及净化汽车尾气\"。<\/p>","url":"http://tech.sina.cn/d/zr/2016-12-24/detail-ifxyxusa5128019.d.html?vt=4&pos=108","weburl":"http://tech.sina.com.cn/d/n/2016-12-24/doc-ifxyxusa5128019.shtml"}]
     */

    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private String channel;
        private String num;
        /**
         * title : 俄科学家研制防治雾霾催化剂
         * time : 2016-12-24 09:43
         * src : 环球网
         * category : tech
         * pic : http://api.jisuapi.com/news/upload/20161224/110002_61031.jpg
         * content : <p class="art_t">　　俄罗斯卫星新闻网12月22日报道称，据《西伯利亚科研新闻》杂志载文报道，托姆斯克国立大学的科学家们正在研制一种新的银催化剂(silver catalyst)，用于空气的过滤净化。</p><p class="art_t">　　这种催化剂能够分解有毒煤气、甲醛等有害的空气中颗粒，分解成无毒的物质。报道指出，这种催化剂用于净化空气是氧化硅制成的纳米管，直径为6至10纳米，管内负载的是银和氧化铈的合成。</p><p class="art_t">　　托姆斯克国立大学催化研究实验室高级研究员马蒙托夫指出，"预计，得到的粉状物或颗粒催化剂能够用于家庭办公以及工厂车间用的空气净化设备。同时使用时不需要加热，与很多同类产品的区别是，催化剂是活性的而且常温下具有很好的稳定性"。</p><p class="art_t">　　他还表示，这种催化剂对于预防煤气中毒和甲醛中毒非常有效，同时使这些有毒物分解成无毒成分，还能够分解其它的有害空气颗粒。马蒙托夫说："首先，工业区和城市中，这种催化剂可以用来防治工业有毒气体排放、抵御森林火灾引发的雾霾，这种雾霾含有大量的煤气。此外，催化剂还能够治理化工厂的气体排放，以及净化汽车尾气"。</p>
         * url : http://tech.sina.cn/d/zr/2016-12-24/detail-ifxyxusa5128019.d.html?vt=4&pos=108
         * weburl : http://tech.sina.com.cn/d/n/2016-12-24/doc-ifxyxusa5128019.shtml
         */

        private List<ListBean> list;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String title;
            private String time;
            private String src;
            private String category;
            private String pic;
            private String content;
            private String url;
            private String weburl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getWeburl() {
                return weburl;
            }

            public void setWeburl(String weburl) {
                this.weburl = weburl;
            }
        }
    }
}
