package itp341.caceres.nicholas.multiFunctionalCalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by NLCaceres on 2/29/2016.
 */
public class UnitConvFragment extends Fragment {

    private EditText editUnitConv;
    private double numToConvert;
    private RadioButton fromRBCm;
    private RadioButton fromRBM;
    private RadioButton fromRBFt;
    private RadioButton fromRBMi;
    private RadioButton fromRBKm;
    private RadioButton toRBCm;
    private RadioButton toRBM;
    private RadioButton toRBFt;
    private RadioButton toRBMi;
    private RadioButton toRBKm;
    private Button buttonUnitConv;
    private double dResult;
    private String unitResult;
    private TextView textVResult;

    private static final String TAG = UnitConvFragment.class.getSimpleName();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_unit_conv, container, false);
        editUnitConv = (EditText) v.findViewById(R.id.edit_unit_conv);
        /* editUnitConv.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String numConvString = editUnitConv.getText().toString();
                numToConvert = Double.parseDouble(numConvString);
                Log.d(TAG, numConvString);
                return true;
            }
        }); */
        editUnitConv.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String numConvString = editUnitConv.getText().toString();
                if (numConvString.length() > 0) {
                    numToConvert = Double.parseDouble(numConvString);
                } else {
                    numToConvert = 0.00;
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        textVResult = (TextView) v.findViewById(R.id.text_unit_result);

        fromRBCm = (RadioButton) v.findViewById(R.id.radiobutton_centimeter_from);
        toRBCm = (RadioButton) v.findViewById(R.id.radiobutton_centimeter_to);
        fromRBM = (RadioButton) v.findViewById(R.id.radiobutton_meter_from);
        toRBM = (RadioButton) v.findViewById(R.id.radiobutton_meter_to);
        fromRBFt = (RadioButton) v.findViewById(R.id.radiobutton_feet_from);
        toRBFt = (RadioButton) v.findViewById(R.id.radiobutton_feet_to);
        fromRBMi = (RadioButton) v.findViewById(R.id.radiobutton_mile_from);
        toRBMi = (RadioButton) v.findViewById(R.id.radiobutton_mile_to);
        fromRBKm = (RadioButton) v.findViewById(R.id.radiobutton_kilometer_from);
        toRBKm = (RadioButton) v.findViewById(R.id.radiobutton_kilometer_to);

        buttonUnitConv = (Button) v.findViewById(R.id.button_unit_conv);
        buttonUnitConv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dec = new DecimalFormat("########0.00");
                dec.setMaximumFractionDigits(9);
                dec.setMinimumFractionDigits(2);
                Log.d(TAG, "clicked");
                if (fromRBCm.isChecked() && toRBCm.isChecked()) {
                    dResult = numToConvert;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_centimeter));
                }
                else if (fromRBCm.isChecked() && toRBM.isChecked()) {
                    dResult = numToConvert * 0.01;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_meter));
                }
                else if (fromRBCm.isChecked() && toRBFt.isChecked()) {
                    dResult = numToConvert * 0.0328;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_feet));
                }
                else if (fromRBCm.isChecked() && toRBMi.isChecked()) {
                    dResult = numToConvert * 0.00000621;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_mile));
                }
                else if (fromRBCm.isChecked() && toRBKm.isChecked()) {
                    dResult = numToConvert * 0.00001;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_mile));
                }
                else if (fromRBM.isChecked() && toRBCm.isChecked()) {
                    dResult = numToConvert * 100;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_centimeter));
                }
                else if (fromRBM.isChecked() && toRBM.isChecked()) {
                    dResult = numToConvert;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_meter));
                }
                else if (fromRBM.isChecked() && toRBFt.isChecked()) {
                    dResult = numToConvert * 3.2808;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_feet));
                }
                else if (fromRBM.isChecked() && toRBMi.isChecked()) {
                    dResult = numToConvert * 0.000621;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_mile));
                }
                else if (fromRBM.isChecked() && toRBKm.isChecked()) {
                    dResult = numToConvert * 0.01;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_kilometer));
                }
                else if (fromRBFt.isChecked() && toRBCm.isChecked()) {
                    dResult = numToConvert * 30.48;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_centimeter));
                }
                else if (fromRBFt.isChecked() && toRBM.isChecked()) {
                    dResult = numToConvert * 0.3048;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_meter));
                }
                else if (fromRBFt.isChecked() && toRBKm.isChecked()) {
                    dResult = numToConvert;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_feet));
                }
                else if (fromRBFt.isChecked() && toRBMi.isChecked()) {
                    dResult = numToConvert * 0.000189;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_mile));
                }
                else if (fromRBFt.isChecked() && toRBKm.isChecked()) {
                    dResult = numToConvert * 0.000304;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_kilometer));
                }
                else if (fromRBMi.isChecked() && toRBCm.isChecked()) {
                    dResult = numToConvert * 160934;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_centimeter));
                }
                else if (fromRBMi.isChecked() && toRBM.isChecked()) {
                    dResult = numToConvert * 1609.34;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_meter));
                }
                else if (fromRBMi.isChecked() && toRBFt.isChecked()) {
                    dResult = numToConvert * 5280;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_feet));
                }
                else if (fromRBMi.isChecked() && toRBMi.isChecked()) {
                    dResult = numToConvert;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_mile));
                }
                else if (fromRBMi.isChecked() && toRBKm.isChecked()) {
                    dResult = numToConvert * 1.60934;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_kilometer));
                }
                else if (fromRBKm.isChecked() && toRBCm.isChecked()) {
                    dResult = numToConvert * 100000;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_centimeter));
                }
                else if (fromRBKm.isChecked() && toRBM.isChecked()) {
                    dResult = numToConvert * 1000;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_meter));
                }
                else if (fromRBKm.isChecked() && toRBFt.isChecked()) {
                    dResult = numToConvert * 3280.84;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_feet));
                }
                else if (fromRBKm.isChecked() && toRBMi.isChecked()) {
                    dResult = numToConvert * 0.62137;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_mile));
                }
                else if (fromRBKm.isChecked() && toRBKm.isChecked()) {
                    dResult = numToConvert;
                    unitResult = dec.format(dResult);
                    textVResult.setText(getResources().getString(R.string.label_result) + "  " + unitResult + " " + getResources().getString(R.string.units_kilometer));
                }
            }
        });
        return v;
    }

}
