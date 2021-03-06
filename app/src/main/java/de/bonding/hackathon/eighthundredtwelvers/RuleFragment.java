package de.bonding.hackathon.eighthundredtwelvers;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.bonding.hackathon.eighthundredtwelvers.model.Rule;

/**
 * A fragment representing a list of Items.
 */
public class RuleFragment extends Fragment {

    RecyclerView recyclerView;

    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RuleFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RuleFragment newInstance(int columnCount) {
        RuleFragment fragment = new RuleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rule_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new RuleRecyclerViewAdapter(Rule.getAll()));
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_rules);
       // recyclerView.setAdapter(new RuleRecyclerViewAdapter(Rule.getDummy()));
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
