package sample.android.com.listviewtest;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ZoomControls;

public class DetailsActivity extends AppCompatActivity {

    private String dist = "Not Found";

    private TextView tvTitle, tvDetails;
   // ZoomControls simpleZoomControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            dist = bundle.getString("dist");
        }

        initView();
    }

    private void initView() {

        tvTitle = findViewById(R.id.tvDistId);
        tvDetails = findViewById(R.id.tvDetailsInfoId);
        //simpleZoomControls = (ZoomControls) findViewById(R.id.simpleZoomControl);

        tvTitle.setText(dist);

        Typeface  typeface = Typeface.createFromAsset(getAssets(), "BrotherTattoo_Demo.ttf");

        tvTitle.setTypeface(typeface);

        //tvDetails.setTypeface(typeface);

        if (dist.equalsIgnoreCase("dhaka")) {

           // String s = getResources().getString(R.string.dhaka);
            tvDetails.setText(getText(R.string.dhaka));

        }
       else if (dist.equalsIgnoreCase("khulna")) {

            String s = getResources().getString(R.string.khulna);
            tvDetails.setText(s);

        }

/*        simpleZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calculate current scale x and y value of ImageView
                float x = tvDetails.getScaleX();
                float y = tvDetails.getScaleY();
                // set increased value of scale x and y to perform zoom in functionality
                tvDetails.setScaleX((float) (x + 1));
                tvDetails.setScaleY((float) (y + 1));
                // display a toast to show Zoom In Message on Screen
                //Toast.makeText(getApplicationContext(),"Zoom In",Toast.LENGTH_SHORT).show();
                // hide the ZoomControls from the screen
               // simpleZoomControls.hide();
            }
        });
        // perform setOnZoomOutClickListener event on ZoomControls
        simpleZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calculate current scale x and y value of ImageView
                float x = tvDetails.getScaleX();
                float y = tvDetails.getScaleY();
                // set decreased value of scale x and y to perform zoom out functionality
                tvDetails.setScaleX((float) (x - 1));
                tvDetails.setScaleY((float) (y - 1));
                // display a toast to show Zoom Out Message on Screen
                //Toast.makeText(getApplicationContext(),"Zoom Out",Toast.LENGTH_SHORT).show();
                // hide the ZoomControls from the screen
                //simpleZoomControls.hide();
            }
        });*/




    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
