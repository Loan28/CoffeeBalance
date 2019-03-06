package coffebalance.coffeebalanceproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class georgeActivity extends AppCompatActivity {

    int  Balance1;
    int  Balance2;
    FirebaseDatabase database = FirebaseDatabase.getInstance();    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        final TextView test = findViewById(R.id.Balance);

        Button coffeeChpBtn = findViewById(R.id.coffeeChpBtn);
        Button coffeeExpBtn = findViewById(R.id.coffeeExpBtn);


        final DatabaseReference Ref = database.getReference("Balance2");

        // Read from the database
        Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Balance1 = dataSnapshot.getValue(Integer.class);
                test.setText(Integer.toString(Balance1));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        coffeeChpBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Ref.setValue(Balance1 + 1);
                Minus(1);

            }
        });
        coffeeExpBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Ref.setValue(Balance1 + 2);
                Minus(2);
            }
        });
    }

    public void Minus(int Value) {


            DatabaseReference Ref2 = database.getReference("Balance1");
            Ref2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Balance2 = dataSnapshot.getValue(Integer.class);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Failed to read value
                }
            });
            Ref2.setValue(Balance2 - Value);

    }

}