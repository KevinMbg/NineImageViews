package com.mbg.nineimageviewtest.util;

import com.mbg.nineimageviewtest.bean.Dynamic;
import com.mbg.nineimageviewtest.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/9/21.
 */
public class DynamicSources {
    public static final String[] CONTENTS = { "",
            "如果你把现在的代码与开始的代码相比，你会发现它们大不相同，开始的代码易懂简介，你甚至可以脑补出运行结果。 而现在的代码更加复杂，有很多的模板代码，当把postDelayed设置为一个短时间，比如50ms的情况下，写这么多代码就有点亏了。其实，还有一个更简单的方法。\n" +
                    "文／BlackSwift（简书作者）" +
                    "原文链接：http://www.jianshu.com/p/c49f778e7acf" +
                    "著作权归作者所有，转载请联系作者获得授权，并标注“简书作者”。",
            "微信朋友圈指的是腾讯微信上的一个社交功能，于微信4.0版本2012年4月19日更新时上线，用户可以通过朋友圈发表文字和图片，同时可通过其他软件将文章或者音乐分享到朋友圈。用户可以对好友新发的照片进行“评论”或“赞”，用户只能看相同好友的评论或赞。",
            "呵噗",
            "我不信邪",
            "哈哈哈哈哈哈",
            "哈哈哈哈",
            "图不错",
            "我勒个去",
            "愿得一人心",
            "白首不分离",
            "重要的人越来越少，但留下的人越来越重要。",
            "在所有别人能给你造成的伤害中，破坏性最强、后果持续最久的一种，是让你怀疑自己配不上拥有任何好的事物。",
            "世界上其实根本没有感同深受这回事，针不刺到别人身上，他们就不知道有多痛。",
            "海底月是天上月，眼前人是心上人",
            "唯有行动才能打败一切不安",
            "知人不评人，知理别争论"};
    public static final String[] PHOTOS = {
            "http://ww3.sinaimg.cn/thumb180/84fe43edjw1es6hlis7ufj20c8085756.jpg" ,
            "http://ww4.sinaimg.cn/thumb180/84fe43edjw1es6hlj4f9yj20c808575e.jpg" ,
            "http://ww3.sinaimg.cn/thumb180/84fe43edjw1es6hljq0vpj20c8085752.jpg" ,
            "http://ww3.sinaimg.cn/thumb180/84fe43edjw1es6hlk5751j20c8085ab2.jpg" ,
            "http://ww4.sinaimg.cn/thumb180/84fe43edjw1es6hlkbol8j20c80hj40k.jpg" ,
            "http://ww2.sinaimg.cn/thumb180/84fe43edjw1es6hlkmhxbj20c807nq3l.jpg" ,
            "http://ww2.sinaimg.cn/thumb180/84fe43edjw1es6hll1zg8j20c8085wfc.jpg",
            "http://ww3.sinaimg.cn/thumb180/84fe43edjw1es6hll689uj20c80hj76n.jpg",
            "http://ww2.sinaimg.cn/thumb180/ad673c42gw1f3skqr4z2ej20dw0dwjsb.jpg",
            "http://ww4.sinaimg.cn/thumb180/ad673c42gw1f3skqrq2tbj20dw0dwjsc.jpg",
            "http://ww1.sinaimg.cn/thumb180/ad673c42gw1f3skqsap9sj20dw0dwgmm.jpg" ,
            "http://ww4.sinaimg.cn/thumb180/ad673c42gw1f3skqssptfj20dw0dwt9b.jpg" ,
            "http://ww3.sinaimg.cn/thumb180/ad673c42gw1f3skqtkkqdj20dw0dwt9f.jpg" ,
            "http://ww3.sinaimg.cn/thumb180/ad673c42gw1f3skque87ej20dw0dwaam.jpg" ,
            "http://ww1.sinaimg.cn/thumb180/ad673c42gw1f3skquxanrj20dw0dwt9p.jpg" ,
            "http://ww3.sinaimg.cn/thumb180/ad673c42gw1f3skqvh2k3j20dw0dwgm9.jpg" ,
            "http://ww1.sinaimg.cn/thumb180/ad673c42gw1f3skqw48yej20dw0dw3zd.jpg" };
    public static final String[] HEADIMG = {
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQl2XkPZ52DF_kyoxU5rD5x8S6MmsPtcEDBfeoBjw5wSIX4lCLh",
            "http://uupaper.oss-cn-qingdao.aliyuncs.com/ea202c4a590e0e055a69fb138813b362.jpeg",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcStlSsuCRzcsTyqHJqZwp65P8OKkmbFoUuoQvTY5gXbgckqHkI04Q",
            "http://v1.qzone.cc/avatar/201308/22/10/36/521579394f4bb419.jpg!200x200.jpg",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcT2UoVRD1XT40gGwqxoYlhVzCyul87W0ZH-IgE15G2pZsqZYZyh",
            "http://cdn.duitang.com/uploads/item/201408/13/20140813122725_8h8Yu.jpeg",
            "http://pic.qiantucdn.com/58pic/13/19/76/24G58PICAW7_1024.jpg",
            "http://p1.qqyou.com/touxiang/uploadpic/2013-3/12/2013031212295986807.jpg",
            "http://pic.qqtn.com/up/2016-3/2016033010291733899.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCYoU4_Z5FkxahblUlY-GO5PLCMKFhqkJF8vN-z5WETp5sRr_Z2g",
            "http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/133368477098.jpg",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSRYTp9_zp1KMAkDc87ydRgWaioer2NeksFOdJbFpzDzD9NUx3DlQ",
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRVQU0GpuqaBaNDpZ_IL0MrQeT5MGTcr94T7-anvr-5ExDiUxnD",
            "http://www.feizl.com/upload2007/2011_10/111007141450516.jpg",
            "http://p2.wmpic.me/article/2016/01/27/1453862710_gTHStPBh_215x185.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhZJZErf26Gs-OtTpFxg4h7kjHaa24ARrMNVEIUdpLRbVdNTJf"};

    public static final String[] NICKNAMES={"test","测试","哈哈哈","不知道","赤羽","丰州","帝国之殇",
            "光明","123123","测试账号","我就试试","行不行","终于……","走吧","098","007"};

    public static List<User> users = new ArrayList<User>();
    static {
        for(int i=0;i<16;i++){
            User user=new User(HEADIMG[i],NICKNAMES[i]);
            users.add(user);
        }
    }

    public static List<Dynamic> createDynamics(){
        List<Dynamic> dynamics=new ArrayList<>();
        Random random = new Random();
        int index;
        for(int i=0;i<30;i++){
            Dynamic dynamic=new Dynamic();
            index=random.nextInt(15);
            dynamic.setContent(CONTENTS[index]);
            dynamic.setUser(users.get(index));
            int photoNum=random.nextInt(7);
            List<String> urls=new ArrayList<>();
            for(int j=0;j<photoNum+1;j++){
                index=random.nextInt(16);
                urls.add(PHOTOS[index]);
            }
            dynamic.setPhotos(urls);
            dynamics.add(dynamic);
        }
        return dynamics;
    }

}

