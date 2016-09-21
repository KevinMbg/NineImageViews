package com.mbg.nineimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public class NineGridView<T> extends LinearLayout {

    private static int MAX_COUNT=3;
    private int space=4;//以后通过attr属性设置
    private int mGridSize=75;//每个格子的大小，以后动态设置
    private int mSingleSize=120;//一张图片时的大小，以后动态设置
    private boolean isMeasured=false;
    private boolean isFourGrid=false;


    private List<ImageView> imageViewList;
    private List<LinearLayout> linearLayoutList;

    private List<T> imageDataList;
    private NineGridViewAdapter mAdapter;
    private LayoutParams commenParams;

    public NineGridView(Context context) {
        this(context,null);
    }

    public NineGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        imageViewList=new ArrayList<>();
        linearLayoutList=new ArrayList<>();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NineGridView);
        this.space = (int) typedArray.getDimension(R.styleable.NineGridView_imgSpace, 0);
        this.mSingleSize = typedArray.getDimensionPixelSize(R.styleable.NineGridView_singleImgSize, -1);
        this.mGridSize=typedArray.getDimensionPixelSize(R.styleable.NineGridView_defalGridSize,75);
        typedArray.recycle();
        this.setOrientation(VERTICAL);
        commenParams=new LayoutParams(mGridSize,mGridSize);
        commenParams.rightMargin=space;
        initLinearLayoutList();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width=MeasureSpec.getSize(widthMeasureSpec);
        if(!isMeasured){
            isMeasured=true;
            mGridSize=(width-getPaddingLeft()-getPaddingRight())/3-space;
            commenParams.height=mGridSize;
            commenParams.width=mGridSize;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setAdapter(NineGridViewAdapter adapter){
        this.mAdapter=adapter;
    }



    /**
     * 设置数据
     * @param list 九宫图数据
     */
    public void setImagesData(List<T> list){
        this.imageDataList=list;
    }
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(listener == null || !listener.isScrolling()) {
            layoutViews();
        }
    }

    private void layoutViews(){
        if(imageDataList == null || imageDataList.size()== 0){
            return;
        }
        this.isFourGrid=(imageDataList.size()==4);
        int rowNum=(imageDataList.size()/3)+(imageDataList.size() % 3 > 0 ? 1 :0);

        setLinearLayoutList(rowNum);
        setFirstImage(imageDataList.size() == 1);
        hideImageViews(imageDataList.size(),rowNum*MAX_COUNT);
        int index=1;
        while (index < imageDataList.size()){
            setImageView(index);
            index++;
        }
    }

    /**
     * 初始化Linearlayout布局，因为RecyclerView中会复用ItemView，因此无碍
     */
    private void initLinearLayoutList(){
        LinearLayout.LayoutParams params=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.bottomMargin=space;
        for(int i=0;i<MAX_COUNT;i++){
            LinearLayout layout=new LinearLayout(getContext());
            layout.setLayoutParams(params);
            layout.setOrientation(HORIZONTAL);
            addView(layout);
            linearLayoutList.add(layout);
        }
    }

    /**
     * 设置Linearlayout的可见性
     * @param rowNum
     */
    private void setLinearLayoutList(int rowNum){
        for(int i=0;i<rowNum;i++){
            linearLayoutList.get(i).setVisibility(VISIBLE);
        }
        for(int i=rowNum;i<MAX_COUNT;i++){
            linearLayoutList.get(i).setVisibility(GONE);
        }
    }

    /**
     * 隐藏不应显示的ImageView
     */
    private void hideImageViews(int start,int end){
        for(int i=start;i<=end && i< imageViewList.size();i++){
            imageViewList.get(i).setVisibility(GONE);
        }
        if(isFourGrid){
            for(int i=imageViewList.size();i < 3;i++){
                ImageView imageView=createNormalImageView();
                imageViewList.add(imageView);
                linearLayoutList.get(0).addView(imageView);
            }
            imageViewList.get(2).setVisibility(GONE);
        }
    }

    /**
     * @return
     */
    private ImageView createNormalImageView(){
        ImageView imageView=mAdapter.generateImageView(getContext());
        /*LayoutParams imageParam=new LayoutParams(mGridSize,mGridSize);
        imageParam.rightMargin=space;*/
        //imageView.setLayoutParams(imageParam);
        imageView.setLayoutParams(commenParams);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag=(Integer)v.getTag();
                mAdapter.onItemImageClick(getContext(),tag,imageDataList);
            }
        });
        return imageView;
    }

    /**
     * 设置第一个图片
     * @param isSingleMode
     */
    private void setFirstImage(boolean isSingleMode){
        if(0 == imageViewList.size()){
            ImageView imageView=mAdapter.generateImageView(getContext());
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAdapter.onItemImageClick(getContext(),0,imageDataList);
                }
            });
            imageView.setTag(0);
            linearLayoutList.get(0).addView(imageView);
            imageViewList.add(imageView);
        }
        LayoutParams imageParam;
        if(isSingleMode){
            imageParam=new LayoutParams(mGridSize,mGridSize);
            imageParam.rightMargin=space;
            int[] size=mAdapter.getImageSize(imageDataList.get(0),mSingleSize);
            imageParam.width=size[0];
            imageParam.height=size[1];
        }
        else{
            imageParam=commenParams;
        }
        imageViewList.get(0).setLayoutParams(imageParam);
        mAdapter.onDisplayImage(getContext(),imageViewList.get(0),imageDataList.get(0));
    }

    /**
     * 设置其他位的ImageView
     * @param position
     */
    private void setImageView(int position){
        ImageView curImageView;
        int tag=position;
        if(isFourGrid && position >= 2){
            ++position;
        }
        if(position < imageViewList.size()){
            curImageView=imageViewList.get(position);
            curImageView.setVisibility(VISIBLE);
        }
        else{
            curImageView=createNormalImageView();
            imageViewList.add(curImageView);
            linearLayoutList.get(position/3).addView(curImageView);
        }
        curImageView.setTag(tag);
        mAdapter.onDisplayImage(getContext(),curImageView,imageDataList.get(tag));
    }

    private onBindScrollSpeedListener listener;
    public void setOnBindScrllListener(onBindScrollSpeedListener listener){
        this.listener=listener;
    }

    public interface onBindScrollSpeedListener{
        boolean isScrolling();
    }

}