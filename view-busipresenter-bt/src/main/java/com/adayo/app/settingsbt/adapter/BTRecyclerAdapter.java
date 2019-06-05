package com.adayo.app.settingsbt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adayo.app.settingsbt.R;
import com.adayo.app.settingsbt.bean.BluetoothBean;

import java.util.List;


public class BTRecyclerAdapter extends RecyclerView.Adapter<BTRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<BluetoothBean> list;
    private int type;

   public BTRecyclerAdapter(Context context, List<BluetoothBean> list, int type){
       this.context = context;
       this.list = list;
       this.type = type;
   }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bt_device_item, viewGroup, false);


        MyViewHolder myViewHolder = new MyViewHolder(inflate);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder myViewHolder, final int i) {
        final BluetoothBean bean = list.get(i);

        myViewHolder.name.setTextColor(context.getResources().getColor(R.color.bt_normal_color));
        myViewHolder.state.setTextColor(context.getResources().getColor(R.color.bt_unselect_color));
        if(type == 1){
            // 搜索到的蓝牙列表
            myViewHolder.delete.setVisibility(View.GONE);
            myViewHolder.state.setVisibility(View.VISIBLE);
            myViewHolder.name.setText(bean.getName());
            if(bean.getState() == 2){
                myViewHolder.state.setText(context.getResources().getString(R.string.btstring12));
            }else {
                myViewHolder.state.setText("");
            }
        }else {
            // 历史配对
            myViewHolder.delete.setVisibility(View.VISIBLE);
            myViewHolder.state.setVisibility(View.VISIBLE);
            myViewHolder.name.setText(bean.getName());
            if(bean.getState() == 2){
                myViewHolder.state.setText(context.getResources().getString(R.string.btstring12));
            }else {
                myViewHolder.state.setText("");
            }

            myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onPairedDeleteListener.deleteDevice(i,bean.getAddress());
                }
            });

        }
        if(myViewHolder.view!=null){
            myViewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickLenster.itemClick(i,v);
                }
            });
        }
    }
    private OnItemClickLenster onItemClickLenster;
    public interface OnItemClickLenster{
        void itemClick(int position, View view);
    }
    public void setOnItemClickLenster(OnItemClickLenster onItemClickLenster){
       this.onItemClickLenster = onItemClickLenster;
    }

    public interface OnPairedDeleteListener{
        void deleteDevice(int position, String address);
    }
    private OnPairedDeleteListener onPairedDeleteListener;
    public void setOnPairedDeleteListener(OnPairedDeleteListener onPairedDeleteListener){
        this.onPairedDeleteListener = onPairedDeleteListener;
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

       private TextView name;
       private TextView state;
        public ImageView delete;
        private View view;
        public MyViewHolder( View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.bt_device_name);
            state = itemView.findViewById(R.id.bt_device_state);
            delete = itemView.findViewById(R.id.bt_device_delete);
            view = itemView;
        }
    }
}
