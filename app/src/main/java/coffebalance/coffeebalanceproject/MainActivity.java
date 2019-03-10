package coffebalance.coffeebalanceproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private VideoView videoBG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loanBtn = findViewById(R.id.loanBtn);
        Button georgeBtn = findViewById(R.id.georgeBtn);

        // (TODO) Add video background, 1440 x 2550p for samsung s7 -- @George
        // Code for background video -- don't delete!
//        videoBG = findViewById(R.id.videoBG);
//        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.coffeecup);
//        videoBG.setVideoURI(uri);
//        videoBG.start();
//
//        videoBG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                // Loop here
//            }
//        });

        loanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Called upon click of loanBtn
                Intent startIntentL = new Intent(getApplicationContext(), loanActivity.class);
                // Load 'loanActivity' as a class into an Intent variable
                startActivity(startIntentL);
            }
        });

        georgeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentG = new Intent(getApplicationContext(), georgeActivity.class);
                startActivity(startIntentG);
            }
        });




    }




}
