package edu.ptit.vhlee.mygallery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    public static final int INDEX_UNIT = 1;
    private List<Photo> mPhotos;
    private LayoutInflater mInflater;

    public PhotoAdapter(Context context, List<Photo> photos) {
        mPhotos = photos;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mPhotos.get(position));
    }

    @Override
    public int getItemCount() {
        return (mPhotos != null) ? mPhotos.size() : 0;
    }

    public void addPhoto(Photo photo) {
        mPhotos.add(photo);
        notifyItemInserted(mPhotos.size() - INDEX_UNIT);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mPhoto;
        private TextView mTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mPhoto = itemView.findViewById(R.id.image_content);
            mTitle = itemView.findViewById(R.id.text_name);
        }

        public void bindData(Photo photo) {
            mTitle.setText(photo.getName());
            Glide.with(itemView.getContext()).load(photo.getPath()).into(mPhoto);
        }
    }
}
