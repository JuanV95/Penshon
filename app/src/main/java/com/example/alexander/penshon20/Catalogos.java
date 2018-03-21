package com.example.alexander.penshon20;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


public class Catalogos extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;

    ListView listView;
    listaPlaces places = listaPlaces.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogos);

        crearCatalogo();

        crearMenuUsuario();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.catalogos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent siguiente = new Intent(Catalogos.this, MapsActivity.class);
            startActivity(siguiente);

        } else if (id == R.id.nav_gallery) {

            Intent siguiente = new Intent(Catalogos.this, AgregarOferta.class);
            startActivity(siguiente);

        } else if (id == R.id.nav_share) {

            Intent siguiente = new Intent(Catalogos.this, Login.class);
            startActivity(siguiente);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public Place[] transformarArray(){

        Place place_datos[] = new Place[places.largo()];

        for (int i = 0; i < places.largo(); i++) {

            place_datos[i] = places.getPlace(i);
        }

        return place_datos;
    }

    public void crearCatalogo(){

        Place place_datos[] = new Place[places.largo()];

        place_datos = transformarArray();

        PlacesAdapter adapter = new PlacesAdapter(this, R.layout.catalogos_list_row, place_datos);

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView v = (TextView) view.findViewById(R.id.tv_titulo_single_post_circuito);
                Intent tarea = new Intent(Catalogos.this, Publicacion.class);
                tarea.putExtra("nombre", v.getText());
                startActivity(tarea);
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void crearMenuUsuario(){

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
//aqui deberia haber un boton con el usuario o no? , no se :/


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    public void onPerfil(View view){
        Intent hola = getIntent();
        String nombre = hola.getStringExtra("perfil");

        Intent perfil = new Intent(this,VerPerfil.class);
        perfil.putExtra("perfil",nombre);
        startActivity(perfil);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

}
