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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by NLCaceres on 2/29/2016.
 */
public class MoneyExchFragment extends Fragment {

    private EditText editMoneyExch;
    private double numToConv;
    private Spinner fromSpinner;
    private int fromSpinPos;
    private Spinner toSpinner;
    private int toSpinPos;
    private Button buttonUnitConv;
    private Double dubResult;
    private String exchResult;
    private TextView textResult;

    private static final String TAG = MoneyExchFragment.class.getSimpleName();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_money_exch, container, false);

        editMoneyExch = (EditText) v.findViewById(R.id.edit_money_exch);
        /* editMoneyExch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    String numConvString = editMoneyExch.getText().toString();
                    numToConv = Double.parseDouble(numConvString);
                    Log.d(TAG, numConvString);
                    return true;
            }
        });*/
        editMoneyExch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String numConvString = editMoneyExch.getText().toString();
                if (numConvString.length() > 0) {
                    numToConv = Double.parseDouble(numConvString);
                } else {
                    numToConv = 0.00;
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });
        textResult = (TextView) v.findViewById(R.id.text_money_result);
        fromSpinner = (Spinner) v.findViewById(R.id.spinner_from);
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromSpinPos = position;
                Log.d(TAG, "changed");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        toSpinner = (Spinner) v.findViewById(R.id.spinner_to);
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toSpinPos = position;
                Log.d(TAG, "changed");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        buttonUnitConv = (Button) v.findViewById(R.id.button_money_exch);
        buttonUnitConv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dec = new DecimalFormat("########0.00");
                dec.setMaximumFractionDigits(2);
                dec.setMinimumFractionDigits(2);
                if (fromSpinPos == 0 && toSpinPos == 0) {
                    dubResult = numToConv;
                    exchResult = dec.format(dubResult);
                    textResult.setText(getResources().getString(R.string.label_result) + "  " + exchResult + " " + getResources().getString(R.string.currency_USD));
                }
                else if (fromSpinPos == 0 && toSpinPos == 1) {
                    dubResult = numToConv * 6.51;
                    exchResult = dec.format(dubResult);
                    textResult.setText(getResources().getString(R.string.label_result) + "  " + exchResult + " " + getResources().getString(R.string.currency_Yuan));
                }
                else if (fromSpinPos == 0 && toSpinPos == 2) {
                    dubResult = numToConv * 0.90;
                    exchResult = dec.format(dubResult);
                    textResult.setText(getResources().getString(R.string.label_result) + "  " + exchResult + " " + getResources().getString(R.string.currency_Euro));
                }
                else if (fromSpinPos == 1 && toSpinPos == 0) {
                    dubResult = numToConv * 0.15;
                    exchResult = dec.format(dubResult);
                    textResult.setText(getResources().getString(R.string.label_result) + "  " + exchResult + " " + getResources().getString(R.string.currency_USD));
                }
                else if (fromSpinPos == 1 && toSpinPos == 1) {
                    dubResult = numToConv;
                    exchResult = dec.format(dubResult);
                    textResult.setText(getResources().getString(R.string.label_result) + "  " + exchResult + " " + getResources().getString(R.string.currency_Yuan));
                }
                else if (fromSpinPos == 1 && toSpinPos == 2) {
                    dubResult = numToConv * 0.14;
                    exchResult = dec.format(dubResult);
                    textResult.setText(getResources().getString(R.string.label_result) + "  " + exchResult + " " + getResources().getString(R.string.currency_Euro));
                }
                else if (fromSpinPos == 2 && toSpinPos == 0) {
                    dubResult = numToConv * 1.12;
                    exchResult = dec.format(dubResult);
                    textResult.setText(getResources().getString(R.string.label_result) + "  " + exchResult + " " + getResources().getString(R.string.currency_USD));
                }
                else if (fromSpinPos == 2 && toSpinPos == 1) {
                    dubResult = numToConv * 7.27;
                    exchResult = dec.format(dubResult);
                    textResult.setText(getResources().getString(R.string.label_result) + "  " + exchResult + " " + getResources().getString(R.string.currency_Yuan));
                }
                else if (fromSpinPos == 2 && toSpinPos == 2) {
                    dubResult = numToConv;
                    exchResult = dec.format(dubResult);
                    textResult.setText(getResources().getString(R.string.label_result) + "  " + exchResult + " " + getResources().getString(R.string.currency_Euro));
                }
            }
        });
        return v;
    }

}
