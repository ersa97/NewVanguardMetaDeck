package com.example.vanguardmetadeck.Main.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.vanguardmetadeck.Main.MainActivity;
import com.example.vanguardmetadeck.R;

import org.w3c.dom.Text;

public class DetailedActivity extends AppCompatActivity {

    String namaClan, deskripsiClan, photo;

    TextView textViewClan;
    TextView textViewDeskripsi;
    ImageView imageViewPhoto;

    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        bundle = getIntent().getExtras();

        namaClan = bundle.getString("clan");
        deskripsiClan = bundle.getString("deskripsi");
        photo = bundle.getString("photo");

        textViewClan = findViewById(R.id.txt_clan_name);
        textViewDeskripsi = findViewById(R.id.txt_deskripsi);
        imageViewPhoto = findViewById(R.id.img_VG);

        textViewClan.setText(namaClan);
        textViewDeskripsi.setText(deskripsiClan);

        Glide.with(this)
                .load(photo)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .centerCrop()
                .into(imageViewPhoto);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}
