# NineImageView
===
Android NineImageView 是类似于微信朋友圈以及新浪微博的九宫图。可以通过自定义属性以及设置适配器方便地显示九宫图，同时对于复杂布局可以设置滑动监听降低RecyclerView滑动过程中带来的卡顿问题。

###Demo

![NineImageView](https://github.com/KevinMbg/NineImageViews/raw/master/demo/scroll.gif)

[Download Demo](https://github.com/KevinMbg/NineImageViews/blob/master/demo/NineImageView-demo.apk)

###Usage
---

###Gradle

```groovy
dependencies {
   compile 'com.mbg.nineimageview:nineimageview:1.5'
}
```

#### Maven 

```xml
<dependency>
  <groupId>com.mbg.nineimageview</groupId>
  <artifactId>nineimageview</artifactId>
  <version>1.2</version>
  <type>pom</type>
</dependency>

布局中使用

```java
    <com.mbg.nineimageview.NineImageView
            android:id="@=id/nineimageview"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:defalGridSize="70dp"//多图模式下每个格子默认大小
            app:imgSpace="4dp"//每个格子间隔
            app:singleImgSize="200dp"//单张图默认大小
            />
```	

代码中使用方法

```java
    //适配器，必须设置，在recyclerview中只需在viewholder构造函数中实现即可
    NineImageViewAdapter adapter=new NineImageViewAdapter<String>() {
        @Override
        protected void onDisplayImage(Context context, final ImageView imageView, String url) {
            //加载图片
        }

        @Override
        protected void onItemImageClick(Context context, int index, List<String> list) {
            super.onItemImageClick(context, index, list);
            //每张图片点击事件
        }

        @Override
        protected ImageView generateImageView(Context context) {
            //获取ImageView，默认已实现，无特别需求不必重写
            return super.generateImageView(context);
        }

        @Override
        protected int setDefaultbackGround() {
            //设置每张图默认的背景
            return super.setDefaultbackGround();
        }

        @Override
        protected int[] getImageSize(String data, int defaultSize) {
            //单张图模式下，设置图片的尺寸
            return super.getImageSize(data, defaultSize);
        }
    };
    NineImageView image9view=(NineImageView)itemView.findViewById(R.id.image9view);
    image9view.setSpace(value);//设置图片间隔
    image9view.setDefaultGridSize(defaultsize);//设置多图模式下默认图片大小
    image9view.setSingleSize(singlesize);//设置单图模式时图片默认尺寸
    image9View.setAdapter(adapter);//设置适配器

    image9view.setImagesData(List list);//设置数据源，并在Image9View出现在窗口范围内时显示
```

####关于RecyclerView中布局过于复杂时滑动卡顿的解决
    关于滑动卡顿可以通过设置onBindScrollSpeedListener解决，在RecyclerView.Adapter中通过监听RecyclerView的滑动事件设置是否加载图片，如下：

```java
   private boolean isScrolling=false;
   private NineImageView.onBindScrollSpeedListener listener=new NineImageView.onBindScrollSpeedListener() {
            @Override
            public boolean isScrolling() {
                return isScrolling;
            }
        };
   
   @Override
   public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolder holder= new RecyclerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_layout,parent,false));
        holder.image9view.setOnBindScrllListener(listener);
        return holder;
   }
   
   @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        //super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_SETTLING){
                    isScrolling=true;
                }
                else if(newState == RecyclerView.SCROLL_STATE_DRAGGING){
                    isScrolling=false;
                }
                else{
                    isScrolling=false;
                    notifyDataSetChanged();
                }
            }
        });
    }

```

