package com.findapp.brunocardoso.findapp;

import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import com.findapp.brunocardoso.findapp.Dialogs.SearchDialog;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    FloatingActionButton fabAdd;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    LinearLayout emptyLayout;
    RecyclerView recyclerViewRepoLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_main);
        fabAdd = findViewById(R.id.fab_add);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navdrawer);
        emptyLayout = findViewById(R.id.main_activity_empty);
        recyclerViewRepoLocal = findViewById(R.id.recycler_repo_local);

        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        //Buscar Repositórios Locais
        new ListRepositorioTask().execute();

        //Se não houver pelo menos um Repositório, mostrar tela para adicionar, se não... Mostrar RecyclerView

        //Evento do FloatingActionButton
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        emptyLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    public void showDialog(){
        FragmentManager fm = getSupportFragmentManager();
        SearchDialog dialog = new SearchDialog();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.add(android.R.id.content, dialog).addToBackStack(null).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(navigationView)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setListVisibility(boolean visibility) {
        if (visibility) {
            emptyLayout.setVisibility(View.GONE);
            recyclerViewRepoLocal.setVisibility(View.VISIBLE);
        } else {
            emptyLayout.setVisibility(View.VISIBLE);
            recyclerViewRepoLocal.setVisibility(View.GONE);
        }
    }

    class ListRepositorioTask extends AsyncTask{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }
    }
}

