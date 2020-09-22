package nora.honeyexpress;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Shop extends AppCompatActivity {
    private Spinner honeyspinner;
    private EditText editquantity;
    private EditText editname;
    private EditText editcontact;
    private EditText editadress;
    private EditText editrequest;
    private Button order_button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity);
        final DatabaseHelper databaseHelper = new DatabaseHelper(this);
        honeyspinner = findViewById(R.id.spinner_bar);
        editquantity = findViewById(R.id.edit_quantity);
        editname = findViewById(R.id.edit_name);
        editcontact = findViewById(R.id.edit_contact);
        editadress = findViewById(R.id.edit_address);
        editrequest = findViewById(R.id.edit_request);
        order_button = findViewById(R.id.order_button);
        order_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addOrder(new Order(editname.getText().toString(), editcontact.getText().toString(),
                        editadress.getText().toString(), editrequest.getText().toString(), honeyspinner.getSelectedItem().toString(),
                        Integer.parseInt(editquantity.getText().toString())));
                sendMail();
            }
        });
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.honeys, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        honeyspinner.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    private void sendMail() {
        String email = "hevesinora17@gmail.com";
        String message = "Name:" + editname.getText().toString() + ", Contact: " + editcontact.getText().toString() + ", Address:" +
                editadress.getText().toString() + ", Special request:" + editrequest.getText().toString() + ", Honeytype: " +
                honeyspinner.getSelectedItem().toString() + ", Quantity:" + editquantity.getText().toString();
        String subject = "Honey Order";
        SendMail sendMail = new SendMail(this, email, subject, message );
        sendMail.execute();
    }

}
