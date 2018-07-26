package kaappo.hexconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static String getId(View view) {
        if (view.getId() == 0xffffffff) return "no-id";
        else return view.getResources().getResourceName(view.getId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            EditTextListener editTextListener = EditTextListener.start(getApplicationContext(), MainActivity.this,(EditText) findViewById(R.id.hexadecimal), (EditText) findViewById(R.id.octal), (EditText) findViewById(R.id.binary), (EditText) findViewById(R.id.decimal));
        } catch (Exception e) {
            System.out.println(e.toString());
        }

//        EditText hex = (EditText) findViewById(R.id.hexadecimal);
//        hex.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                System.out.println(s + "," + start + "," + before + "," + count);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
    }
}
