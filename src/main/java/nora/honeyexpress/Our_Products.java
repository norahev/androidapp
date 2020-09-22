package nora.honeyexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Our_Products extends AppCompatActivity {

    private TextView acacianame;
    private TextView acaciaenglish;
    private TextView polyfloraname;
    private TextView polyfloraenglish;

    @Override
    protected void onCreate(Bundle SavedInstanceState) {

        super.onCreate(SavedInstanceState);
        setContentView(R.layout.products_activity);
        acacianame = findViewById(R.id.acacia_name);
        acaciaenglish = findViewById(R.id.acacia_english);
        polyfloraname = findViewById(R.id.polyflora_name);
        polyfloraenglish = findViewById(R.id.polyflora_english);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton buyButton = findViewById(R.id.buy_float);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Our_Products.this, Shop.class));
            }
        });
        load();
    }

    private void load() {
        acaciaenglish.setText("Acacia honey is derived from the nectar of the Robinia pseudoacacia flower." +
                "It has a light, almost transparent color and stays liquid for longer, prolonging its shelf life." +
                "Acacia honey may aid wound healing, improve acne, and offer additional benefits due to its powerful antioxidants.");
        acacianame.setText("Acacia");
        polyfloraenglish.setText("Polyfloral honey, also known as wildflower honey, is derived from the nectar of many types of " +
                "flowers. The taste may vary from year to year, and the aroma and the flavor can be more or less intense, depending" +
                " on which bloomings are prevalent. Polyfloral honeys are a source of multiple essential nutrients like B vitamins" +
                " and vitamin C, potassium, calcium, iron, phosphorus, but also other elements with nutritional value like pollen" +
                " particles, enzymes, amino acids etc. The raw, unprocessed and unheated honey is good for low blood sugar levels, low energy levels and fatigue.");
        polyfloraname.setText("Polyflora");
    }
}