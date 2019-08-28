package itp341.caceres.nicholas.multiFunctionalCalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by NLCaceres on 2/29/2016.
 */
public class TipCalculatorFragment extends Fragment {

    private TextView textViewPerPersonTipValue;
    private TextView textViewPerPersonTip;
    private TextView textViewPerPersonTotalValue;
    private TextView textViewPerPersonTotal;
    private TextView textViewPerPerson;
    private TextView textViewTotalValue;
    private TextView textViewTipValue;
    private TextView textViewPercentValue;

    private Spinner spinnerSplit;

    private SeekBar seekBarPercent;

    private EditText editTextBillAmount;

    private double billAmount;
    private double percent;
    private double tip;
    private double tipPerPerson;
    private double total;
    private double totalPerPerson;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a4, container, false);

        percent = 15;

        textViewPercentValue = (TextView) v.findViewById(R.id.text_percent_value);
        textViewTipValue = (TextView) v.findViewById(R.id.text_tip_value);
        textViewTotalValue = (TextView) v.findViewById(R.id.text_total_value);
        textViewPerPersonTipValue = (TextView) v.findViewById(R.id.text_per_person_tip_value);
        textViewPerPersonTip = (TextView) v.findViewById(R.id.text_per_person_tip);
        textViewPerPersonTotalValue = (TextView) v.findViewById(R.id.text_per_person_total_value);
        textViewPerPersonTotal = (TextView) v.findViewById(R.id.text_per_person_total);
        textViewPerPerson = (TextView) v.findViewById(R.id.text_per_person);

//        DecimalFormat decFormat = new DecimalFormat("#.##");
//        decFormat.setRoundingMode(RoundingMode.HALF_EVEN);
//        Double textTip = Double.parseDouble(getResources().getString(R.string.label_initial).substring(1));
//        textViewTipValue.setText(getResources().getString(R.string.dollar_sign) + decFormat.format(textTip));

        spinnerSplit = (Spinner) v.findViewById(R.id.spinnerSplit);

        seekBarPercent = (SeekBar) v.findViewById(R.id.seek_bar);

        editTextBillAmount = (EditText) v.findViewById(R.id.edit_bill_amount);

        //billAmountEditorListener billAmountListener = new billAmountEditorListener();
        //editTextBillAmount.setOnEditorActionListener(billAmountListener);
        editTextBillAmount.addTextChangedListener(new BillAmountTextWatcher());
        percentSeekBarListener percentSeekListener = new percentSeekBarListener();
        seekBarPercent.setOnSeekBarChangeListener(percentSeekListener);
        spinnerSplitListener splitListener = new spinnerSplitListener();
        spinnerSplit.setOnItemSelectedListener(splitListener);
        return v;
    }

    private void updateTipTotalPerPerson() {
        double percentDbl = percent * 0.01;
        DecimalFormat dec = new DecimalFormat("####0.00");
        dec.setMaximumFractionDigits(2);
        dec.setMinimumFractionDigits(2);
        tip = billAmount * percentDbl;
        String stringTip = dec.format(tip);
        textViewTipValue.setText(getResources().getString(R.string.dollar_sign) + stringTip);
        total = billAmount + tip;
        String stringTotal = dec.format(total);
        textViewTotalValue.setText(getResources().getString(R.string.dollar_sign) + stringTotal);

        if (spinnerSplit.getSelectedItemPosition() == 1) {
            tipPerPerson = tip / 2;
            String stringTipPerPerson = dec.format(tipPerPerson);
            textViewPerPersonTipValue.setText(getResources().getString(R.string.dollar_sign) + stringTipPerPerson);
            totalPerPerson = total / 2;
            String stringTotalPerPerson = dec.format(totalPerPerson);
            textViewPerPersonTotalValue.setText(getResources().getString(R.string.dollar_sign) + stringTotalPerPerson);
        }
        else if (spinnerSplit.getSelectedItemPosition() == 2){
            tipPerPerson = tip / 3;
            String stringTipPerPerson = dec.format(tipPerPerson);
            textViewPerPersonTipValue.setText(getResources().getString(R.string.dollar_sign) + stringTipPerPerson);
            totalPerPerson = total / 3;
            String stringTotalPerPerson = dec.format(totalPerPerson);
            textViewPerPersonTotalValue.setText(getResources().getString(R.string.dollar_sign) + stringTotalPerPerson);
        }
        else if (spinnerSplit.getSelectedItemPosition() == 3) {
            tipPerPerson = tip / 4;
            String stringTipPerPerson = dec.format(tipPerPerson);
            textViewPerPersonTipValue.setText(getResources().getString(R.string.dollar_sign) + stringTipPerPerson);
            totalPerPerson = total / 4;
            String stringTotalPerPerson = dec.format(totalPerPerson);
            textViewPerPersonTotalValue.setText(getResources().getString(R.string.dollar_sign) + stringTotalPerPerson);
        }
        else {
            return;
        }
    }

    /*private class billAmountEditorListener implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String billAmountString = editTextBillAmount.getText().toString();
                billAmount = Double.parseDouble(billAmountString);
                updateTipTotalPerPerson();
                return true;
        }
    }*/
    private class BillAmountTextWatcher implements TextWatcher {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String billAmountString = editTextBillAmount.getText().toString();
            if (billAmountString.length() > 0) {
                billAmount = Double.parseDouble(billAmountString);
            } else {
                billAmount = 0.00;
            }
            updateTipTotalPerPerson();
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
        @Override
        public void afterTextChanged(Editable s) { }
    }

    private class percentSeekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            textViewPercentValue.setText(progress + getResources().getString(R.string.percent_sign));
            percent = progress;
            updateTipTotalPerPerson();
        }
        public void onStartTrackingTouch(SeekBar seekBar) {

        }
        public void onStopTrackingTouch (SeekBar seekBar) {

        }
    }

    private class spinnerSplitListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0){
                textViewPerPersonTipValue.setVisibility(View.GONE);
                textViewPerPersonTip.setVisibility(View.GONE);
                textViewPerPersonTotalValue.setVisibility(View.GONE);
                textViewPerPersonTotal.setVisibility(View.GONE);
                textViewPerPerson.setVisibility(View.GONE);
                updateTipTotalPerPerson();
            }
            else {
                textViewPerPersonTipValue.setVisibility(View.VISIBLE);
                textViewPerPersonTip.setVisibility(View.VISIBLE);
                textViewPerPersonTotalValue.setVisibility(View.VISIBLE);
                textViewPerPersonTotal.setVisibility(View.VISIBLE);
                textViewPerPerson.setVisibility(View.VISIBLE);
                updateTipTotalPerPerson();
            }
        }

        public void onNothingSelected(AdapterView<?> parent) {

        }

    }
}
