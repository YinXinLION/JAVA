package Enum;

/**
 * Created by yinxin on 17-7-26.
 */
public enum  NewsRSSFeedEnum {
    // 雅虎头条新闻 RSS 种子
    YAHOO_TOP_STORIES("<a href=\"http://rss.news.yahoo.com/rss/topstories\"><code>http://rss.news.yahoo.com/rss/topstories</code></a>");

    //CBS 头条新闻 RSS 种子

            // 洛杉矶时报头条新闻 RSS 种子


    // 枚举对象的 RSS 地址的属性
            private String rss_url;

            // 枚举对象构造函数
    private NewsRSSFeedEnum(String rss) {
        this.rss_url = rss;
    }

    // 枚举对象获取 RSS 地址的方法
    public String getRssURL() {
        return this.rss_url;
    }
}
/*
头条新闻的枚举类型增加了一个 RSS 地址的属性 , 记录头条新闻的访问地址。
同时，需要外部传入 RSS 访问地址的值，因而需要定义一个构造函数来初始化此属性。
另外，还需要向外提供方法来读取 RSS 地址。

由于enum构造函数不支持public，protect
所以无法通过直接调用构造方法初始化

 enum 类型的值实际上是通过运行期构造出对象来表示的
 */