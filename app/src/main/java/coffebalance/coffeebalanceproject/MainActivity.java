package coffebalance.coffeebalanceproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loanBtn = findViewById(R.id.loanBtn);
        Button georgeBtn = findViewById(R.id.georgeBtn);

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
