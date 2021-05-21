package com.example.shaadidemo.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shaadidemo.MainActivity;
import com.example.shaadidemo.R;
import com.example.shaadidemo.RoomDataBase.ProfileEntity;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    Context mContext;
    List<ProfileEntity> resultList;

    public ProfileAdapter(Context context, List<ProfileEntity> heroList) {
        this.mContext = context;
        this.resultList = heroList;
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_new, parent,
                false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        Glide.with(mContext).load(resultList.get(position).getPicture())
                .into(holder.imageview_profile);
        holder.tv_name_age.setText(String.format("%s, %s yrs",
                resultList.get(position).getName(), resultList.get(position).getAge()));
        holder.tv_email.setText(resultList.get(position).getGender() + ", "
                + resultList.get(position).getEmail());
        holder.tv_address.setText(resultList.get(position).getLocation());
        String login_uuid = resultList.get(position).getLogin_uuid();

        Log.d("LOGIN_UUID>>>", resultList.get(position).getLogin_uuid());
        Log.d("STATUS>>>", resultList.get(position).getStatus());

        if (resultList.get(position).getStatus().equals("STATUS_ACCEPT")) {
            holder.image_accept.setVisibility(View.GONE);
            holder.tv_accept.setVisibility(View.VISIBLE);
            holder.image_decline.setVisibility(View.VISIBLE);
            holder.tv_decline.setVisibility(View.GONE);
        } else if (resultList.get(position).getStatus().equals("STATUS_DECLINE")) {
            holder.image_decline.setVisibility(View.GONE);
            holder.tv_decline.setVisibility(View.VISIBLE);
            holder.image_accept.setVisibility(View.VISIBLE);
            holder.tv_accept.setVisibility(View.GONE);
        } else {
            holder.image_accept.setVisibility(View.VISIBLE);
            holder.image_decline.setVisibility(View.VISIBLE);
            holder.tv_accept.setVisibility(View.GONE);
            holder.tv_decline.setVisibility(View.GONE);
        }

        holder.image_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultList.get(position).getStatus().equals("STATUS_NA")) {
                    holder.image_accept.setVisibility(View.GONE);
                    holder.tv_accept.setVisibility(View.VISIBLE);
                    if (mContext instanceof MainActivity) {
                        ((MainActivity)mContext).updateStatusInRoom("STATUS_ACCEPT",
                                login_uuid, position);
                    }
                }
            }
        });

        holder.image_decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultList.get(position).getStatus().equals("STATUS_NA")) {
                    holder.image_decline.setVisibility(View.GONE);
                    holder.tv_decline.setVisibility(View.VISIBLE);
//                    updateTask("STATUS_DECLINE", login_uuid);
                    if (mContext instanceof MainActivity) {
                        ((MainActivity)mContext).updateStatusInRoom("STATUS_DECLINE",
                                login_uuid, position);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (resultList != null)
            return resultList.size();
        else return 0;
    }

    class ProfileViewHolder extends RecyclerView.ViewHolder {

        ImageView imageview_profile;
        TextView tv_name_age, tv_email, tv_address;
        ImageView image_decline, image_accept;
        TextView tv_decline, tv_accept;

        public ProfileViewHolder(View itemView) {
            super(itemView);
            imageview_profile = itemView.findViewById(R.id.imageview_profile);
            tv_name_age = itemView.findViewById(R.id.tv_name_age);
            tv_email = itemView.findViewById(R.id.tv_email);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_accept = itemView.findViewById(R.id.tv_accept);
            tv_decline = itemView.findViewById(R.id.tv_decline);
            image_decline = itemView.findViewById(R.id.image_decline);
            image_accept = itemView.findViewById(R.id.image_accept);
        }
    }

}


