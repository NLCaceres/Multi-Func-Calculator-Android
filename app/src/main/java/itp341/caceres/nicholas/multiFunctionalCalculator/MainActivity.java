package itp341.caceres.nicholas.multiFunctionalCalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    private Button buttonTipCalc;
    private Button buttonUnitConv;
    private Button buttonMoneyExch;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTipCalc = (Button) findViewById(R.id.button_tipcalc);
        buttonTipCalc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Fragment A4Frag = fm.findFragmentById(R.id.fragment_container);
                if (A4Frag == null) {
                    A4Frag = new TipCalculatorFragment();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.fragment_container, A4Frag);
                    ft.commit();
                    Log.d(TAG, "added");
                }
                else {
                    A4Frag = new TipCalculatorFragment();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_container, A4Frag);
                    ft.commit();
                    Log.d(TAG, "replaced");
                }
            }
        });
        buttonUnitConv = (Button) findViewById(R.id.button_unitconv);
        buttonUnitConv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Fragment UnitConvFrag = fm.findFragmentById(R.id.fragment_container);
                if (UnitConvFrag == null) {
                    UnitConvFrag = new UnitConvFragment();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.fragment_container, UnitConvFrag);
                    ft.commit();
                }
                else {
                    UnitConvFrag = new UnitConvFragment();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_container, UnitConvFrag);
                    ft.commit();
                    Log.d(TAG, "replaced");
                }
            }
        });
        buttonMoneyExch = (Button) findViewById(R.id.button_moneyexch);
        buttonMoneyExch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Fragment MoneyExchFrag = fm.findFragmentById(R.id.fragment_container);
                if (MoneyExchFrag == null) {
                    MoneyExchFrag = new MoneyExchFragment();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.fragment_container, MoneyExchFrag);
                    ft.commit();
                    Log.d(TAG, "added");
                }
                else {
                    MoneyExchFrag = new MoneyExchFragment();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_container, MoneyExchFrag);
                    ft.commit();
                    Log.d(TAG, "replaced");
                }

            }
        });

    }



}




