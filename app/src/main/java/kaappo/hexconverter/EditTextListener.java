package kaappo.hexconverter;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class EditTextListener {
    private EditText hexadecimal;
    private EditText binary;
    private EditText decimal;
    private EditText octal;

    private Context context;
    private Activity activity;

    List<EditText> fields = new ArrayList<>();

    private EditTextListener (Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public static EditTextListener start(Context context, Activity activity, EditText hexadecimal, EditText octal, EditText binary, EditText decimal) throws Exception{
        EditTextListener temp = new EditTextListener(context, activity);

        temp.hexadecimal = hexadecimal;
        temp.octal = octal;
        temp.binary = binary;
        temp.decimal = decimal;

        temp.fields.add(temp.hexadecimal);
        temp.fields.add(temp.octal);
        temp.fields.add(temp.binary);
        temp.fields.add(temp.decimal);

        System.out.println("TryingTosetEditTextListeners");
        temp.setEditListeners();

        return temp;
    }

    public EditText getBinary() {
        return binary;
    }

    public EditText getDecimal() {
        return decimal;
    }

    public EditText getHexadecimal() {
        return hexadecimal;
    }

    public EditText getOctal() {
        return octal;
    }

    private void setEditListeners() throws Exception {
        System.out.println("Setting edittextlisteners");
        for (int i = 0; i < fields.size(); i++) {
            fields.get(i).addTextChangedListener(new MyTextWatcher(i, this, this.activity));
        }
    }

    public static class MyTextWatcher implements TextWatcher {
        public static final int HEX = 1;
        public static final int OCT = 2;
        public static final int BIN = 4;
        public static final int DEC = 3;

        private int fieldID;
        private EditTextListener context;
        private Activity activity;

        MyTextWatcher(int fieldID, EditTextListener context, Activity activity) throws Exception {
            if (fieldID > 3 || fieldID < 0) {
                throw new Exception("Invalid fieldID: " + fieldID + "!");
            } else {
                this.fieldID = fieldID;
            }
            this.context = context;
            this.activity = activity;

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            System.out.println("Not parsed: " + MainActivity.getId(this.activity.getCurrentFocus()));

            if (this.activity.getCurrentFocus() == this.context.fields.get(this.fieldID)) {
                System.out.println(MainActivity.getId(this.activity.getCurrentFocus()));

                SetOfNumbers data;
                switch (this.context.fields.get(this.fieldID).getId()) {
                    case R.id.hexadecimal:
                        System.out.println("Hex!");
                        data = NumberConverter.getOthersFromHex((s.toString()));

                        this.context.getBinary().setText(data.getBin());
                        this.context.getDecimal().setText(data.getDec());
                        this.context.getOctal().setText(data.getOct());

                    case R.id.octal:
                        System.out.println("Oct");
                        data = NumberConverter.getOthersFromOct(s.toString());

                        this.context.getBinary().setText(data.getBin());
                        this.context.getDecimal().setText(data.getDec());
                        this.context.getHexadecimal().setText(data.getHex());
                    case R.id.binary:
                        System.out.println("Bin!");
                        data = NumberConverter.getOthersFromBin((s.toString()));

                        this.context.getDecimal().setText(data.getDec());
                        this.context.getOctal().setText(data.getOct());
                        this.context.getHexadecimal().setText(data.getHex());
                    case R.id.decimal:
                        System.out.println("Dec!");
                        data = NumberConverter.getOthersFromDec((s.toString()));

                        this.context.getBinary().setText(data.getBin());
                        this.context.getOctal().setText(data.getOct());
                        this.context.getHexadecimal().setText(data.getHex());
                }
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }

    }

}
