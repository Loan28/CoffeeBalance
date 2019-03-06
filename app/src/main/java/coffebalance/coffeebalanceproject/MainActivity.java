package coffebalance.coffeebalanceproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button button;

    int BalanceValue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView test = findViewById(R.id.Balance);
        final Button Cheap = findViewById(R.id.Cheap);
        final Button Expensive = findViewById(R.id.Cheap);




        button = (Button) findViewById(R.id.test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }

        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Balance1");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                BalanceValue = dataSnapshot.getValue(Integer.class);
                test.setText(Integer.toString(BalanceValue));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        Cheap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myRef.setValue(BalanceValue + 1);
            }
        });
        Expensive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myRef.setValue(BalanceValue + 2);
            }
        });



    }

    public void openActivity2() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


}
