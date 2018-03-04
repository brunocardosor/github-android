package com.findapp.brunocardoso.findapp.Dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.findapp.brunocardoso.findapp.R;

/**
 * Created by Administrador on 23/02/2018.
 */

public class SearchDialog extends DialogFragment {

    SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_repository, container, false);
        searchView = view.findViewById(R.id.search_repository);
        EditText edtQuery = searchView.findViewById(R.id.search_src_text);
        edtQuery.requestFocus();
        ImageView closeButton = searchView.findViewById(R.id.search_mag_icon);
        closeButton.setImageResource(R.drawable.ic_arrow_back);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAlpha(1f);
                getFragmentManager().popBackStack();
            }
        });
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }



}
