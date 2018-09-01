package t.flatearchsocie.crimeview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class CrimeAdapter extends ArrayAdapter<Crime> {
    public CrimeAdapter(Context context, List<Crime> resource) {
        super(context, R.layout.individual_crime_layout, resource);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View personView = inflater.inflate(R.layout.individual_crime_layout, parent, false);

        // keep track of person this view is working with
        personView.setTag(getItem(position));

        // get text views that will hold strings
        //TextView txtSurname = personView.findViewById(R.id.txtSurname);


        // set text fields
        //txtSurname.setText(getItem(position));


        // return view to ListView to display
        return personView;
    }

}
