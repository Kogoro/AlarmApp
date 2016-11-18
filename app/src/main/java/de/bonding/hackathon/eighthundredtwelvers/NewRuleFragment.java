package de.bonding.hackathon.eighthundredtwelvers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import de.bonding.hackathon.eighthundredtwelvers.common.Order;
import de.bonding.hackathon.eighthundredtwelvers.model.Condition;
import de.bonding.hackathon.eighthundredtwelvers.model.Rule;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewRuleFragment extends Fragment {

    private EditText nameET;
    private EditText deltaTet;
    private Spinner magnitudeS;
    private Spinner orderS;
    private EditText valueET;
    private Button makeBTN;

    public NewRuleFragment() {
        // Required empty public constructor
    }

    public static NewRuleFragment newInstance() {
        NewRuleFragment fragment = new NewRuleFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_rule, container, false);
        nameET = (EditText) v.findViewById(R.id.rulenameET);
        deltaTet = (EditText) v.findViewById(R.id.deltaTet);
        orderS = (Spinner) v.findViewById(R.id.orderS);
        magnitudeS = (Spinner) v.findViewById(R.id.magnitudeS);
        valueET = (EditText) v.findViewById(R.id.valueET);
        ArrayAdapter<Order> adO = new ArrayAdapter<Order>(getContext(), R.layout.support_simple_spinner_dropdown_item);
        adO.addAll(Order.values());
        orderS.setAdapter(adO);
        magnitudeS.setAdapter(new ArrayAdapter<Order>(getContext(), R.layout.support_simple_spinner_dropdown_item));
        ArrayAdapter<WeatherMagnitudes> mO = new ArrayAdapter<WeatherMagnitudes>(getContext(), R.layout.support_simple_spinner_dropdown_item);
        mO.addAll(WeatherMagnitudes.values());
        magnitudeS.setAdapter(mO);
        makeBTN = (Button) v.findViewById(R.id.makeruleBTN);
        makeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRule();
            }
        });
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void makeRule() {
        Condition c = new Condition();
        c.magnitude = (WeatherMagnitudes) magnitudeS.getSelectedItem();
        c.order = (Order) orderS.getSelectedItem();
        c.value = Integer.parseInt(valueET.getText().toString());
        Rule r = new Rule();
        c.rule = r;
        r.deltaT = Long.parseLong(deltaTet.getText().toString());
        r.name = nameET.getText().toString();
        r.insert();
        ((AppCompatActivity) getActivity()).getSupportFragmentManager().popBackStack();
    }

}
