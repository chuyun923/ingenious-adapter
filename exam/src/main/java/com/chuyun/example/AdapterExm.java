package com.chuyun.example;

import android.content.Context;

import com.chuyun.example.bean.StuDetailInfo;
import com.chuyun.example.bean.Student;
import com.chuyun.ingeniousadapter.AdapterHolder;
import com.chuyun.ingeniousadapter.IngeniousAdapter;

import java.util.List;

/**
 * Author:彭亮
 * Date:14-12-13
 * Time:下午1:00
 * ～冰冻三尺非一日之寒，水滴石穿非一日之功～
 */
public class AdapterExm<Object> extends IngeniousAdapter {

    public AdapterExm(Context context, List list) {
        super(context, list);
    }

    @Override
    protected void convert(AdapterHolder holder, java.lang.Object item,int viewType) {
        switch (viewType) {
            case 0:
                Student student = (Student) item;
                holder.setText(R.id.name,student.getName());
                holder.setText(R.id.nickname,student.getNickName());
                break;
            case 1:
                StuDetailInfo stuDetailInfo = (StuDetailInfo) item;
                holder.setText(R.id.age,stuDetailInfo.getAge()+"");
                holder.setText(R.id.height,stuDetailInfo.getHeight()+"");
                holder.setText(R.id.weight,stuDetailInfo.getWeight()+"");
                holder.setText(R.id.sex,stuDetailInfo.getSex()== StuDetailInfo.Sex.MALE?"男":"女");
                break;
            default:
                break;
        }
    }

    @Override
    protected int[] assignLayoutIDs() {
        int[] result = {R.layout.list_item_stu_base_info,R.layout.list_item_stu_detail_info};
        return result;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }
}

