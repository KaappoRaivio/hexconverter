package kaappo.hexconverter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String getId(View view) {
        if (view.getId() == 0xffffffff) return "no-id";
        else return view.getResources().getResourceName(view.getId());
    }

    public void onCopyButtonPress (View v) {
        EditText editText;

        switch (v.getId()) {


            case R.id.binary_copy:
                editText = (EditText) findViewById(R.id.binary);
                break;
            case R.id.hexadecimal_copy:
                editText = (EditText) findViewById(R.id.hexadecimal);
                break;
            case R.id.octal_copy:
                editText = (EditText) findViewById(R.id.octal);
                break;
            case R.id.decimal_copy:
                editText = (EditText) findViewById(R.id.decimal);
                break;

            default:
                System.out.println("ASDASDASDASDASd");
                editText = null;
                break;

        }
        String textToCopy = editText.getText().toString();

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", textToCopy);
        clipboard.setPrimaryClip(clip);
        toast("Copied to clipboard");

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

    }

    public void toast (String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
