package com.example.vanguardmetadeck.Main;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.vanguardmetadeck.Main.Detail.DetailedActivity;
import com.example.vanguardmetadeck.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class ClanAdapter extends FirestoreRecyclerAdapter<Clan, ClanAdapter.ClanHolder>{

    private OnItemClickListener listener;

    public ClanAdapter(@NonNull FirestoreRecyclerOptions<Clan> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ClanAdapter.ClanHolder holder, int position, @NonNull Clan model) {
        holder.bind(model);
    }

    @NonNull
    @Override
    public ClanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ClanHolder(view);
    }

    class ClanHolder extends RecyclerView.ViewHolder {

        TextView textViewClan;
        TextView textViewDescription;
        ImageView imageViewVG;
        CardView cardView;

        public ClanHolder(@NonNull View itemView) {
            super(itemView);
            textViewClan = itemView.findViewById(R.id.show_clan);
            textViewDescription = itemView.findViewById(R.id.show_description);
            imageViewVG = itemView.findViewById(R.id.clan_logo);
            cardView = itemView.findViewById(R.id.card_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION && listener !=null){
                        listener.onItemClick(getSnapshots().getSnapshot(pos),pos);
                    }
                }
            });

        }

        public void bind(final Clan clan) {
            textViewClan.setText(clan.getName());
            textViewDescription.setText(clan.getDescription());
            Glide.with(itemView)
                    .load(clan.getPhotoUrl())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .centerCrop()
                    .into(imageViewVG);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String namaClan = clan.getName();
                    String deskripsiClan = clan.getDescription();
                    String photo = clan.getPhotoUrl();

                    Intent intent = new Intent(v.getContext(), DetailedActivity.class);
                    intent.putExtra("clan", namaClan);
                    intent.putExtra("deskripsi", deskripsiClan);
                    intent.putExtra("photo", photo);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    public void setOnItemClickLlistener(OnItemClickListener listener){
        this.listener = listener;
    }
}
