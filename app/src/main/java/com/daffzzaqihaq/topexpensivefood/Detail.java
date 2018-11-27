package com.daffzzaqihaq.topexpensivefood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daffzzaqihaq.topexpensivefood.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Detail extends AppCompatActivity {

    @BindView(R.id.imgLogo)
    ImageView imgLogo;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtDetail)
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        txtTitle.setText(getIntent().getStringExtra("n"));
        txtDetail.setText(getIntent().getStringExtra("d"));
        Glide.with(this).load(getIntent().getIntExtra("g",0)).into(imgLogo);

    }
}

