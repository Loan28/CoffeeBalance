package coffebalance.coffeebalanceproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        Button coffeeChpBtn = findViewById(R.id.coffeeChpBtn);
        Button coffeeExpBtn = findViewById(R.id.coffeeExpBtn);

        coffeeChpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // (TODO)Put Firebase code here for cheap coffee -- @Loan
            }
        });

        coffeeExpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // (TODO)Put Firebase code here for expensive coffee -- @Loan
            }
        });
    }
}
