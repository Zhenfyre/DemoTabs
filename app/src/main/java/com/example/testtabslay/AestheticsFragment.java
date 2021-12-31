package com.example.testtabslay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.testtabslay.databinding.ActivityHomeBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class AestheticsFragment extends Fragment {
    private EditText appearanceField;
    private EditText smellField;
    private EditText tasteField;

    public AestheticsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_aesthetics, container, false);

        // Get appearance of water
        appearanceField = v.findViewById(R.id.water_appearance_description);
        Editable appearanceEditable = appearanceField.getText();
        String appearance = appearanceEditable.toString();

        // Get smell of water
        smellField = v.findViewById(R.id.water_smell_description);
        Editable smellEditable = smellField.getText();
        String smell = smellEditable.toString();

        // Get taste of water
        tasteField = v.findViewById(R.id.water_taste_description);
        Editable tasteEditable = tasteField.getText();
        String taste = tasteEditable.toString();

        // Create the results summary
        String summary = createResultsSummary(appearance, smell, taste);

        // Inflate the layout for this fragment
        return v;
    }

    /**
     * Create summary of the results.
     * @return text summary
     */
    private String createResultsSummary(String appearance, String smell,String taste) {

        String summaryMessage = "\n " + getString(R.string.appearance_short) + ": " + appearance + "\n";
        summaryMessage += "\n " + getString(R.string.smell_short) + ": " + smell + "\n";
        summaryMessage += "\n " + getString(R.string.taste_short) + ": " + taste;

        return summaryMessage;
    }

}
