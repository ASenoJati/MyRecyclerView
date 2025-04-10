package com.example.myrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

    private ArrayList<ItemModel> listMakananModel;

    //Listener OBJ
    private final OnItemClickListener listener;

    // Interface untuk menangani klik item
    public interface OnItemClickListener {
        void onItemClick(ItemModel itemModel);
    }

    public ItemAdapter(ArrayList<ItemModel> listMakananModel, OnItemClickListener listener) {
        this.listMakananModel = listMakananModel;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapterViewHolder holder, int position) {
        ItemModel listMakananModel = this.listMakananModel.get(position);
        holder.tvNamaMakanan.setText(listMakananModel.getNamaMakanan());
        holder.tvHargaMakanan.setText(listMakananModel.getHargaMakanan());
        holder.imageView.setImageResource(listMakananModel.getImageResId());

        // Menangani klik item
        holder.itemView.setOnClickListener(v -> listener.onItemClick(listMakananModel));
    }

    @Override
    public int getItemCount() {
        return this.listMakananModel.size();
    }

    public static class ItemAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaMakanan;
        TextView tvHargaMakanan;
        ImageView imageView;

        public ItemAdapterViewHolder(View view) {
            super(view);
            tvNamaMakanan = (TextView) view.findViewById(R.id.tvNamaMakanan);
            tvHargaMakanan = (TextView) view.findViewById(R.id.tvHargaMakanan);
            imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
