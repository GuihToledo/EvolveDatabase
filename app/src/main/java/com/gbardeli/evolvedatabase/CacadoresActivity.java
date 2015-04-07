package com.gbardeli.evolvedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CacadoresActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private List<Map<String, Object>> cacadores;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cacadores, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cacadores);
        String[] de = {"imagem", "nome"};

        ListView lv = (ListView) findViewById(R.id.classes);

        int[] para = {R.id.imagemCacador, R.id.valor};
        lv.setAdapter( new SimpleAdapter(this, listarCacadores(),
                R.layout.list_cacadores, de, para));
        lv.setOnItemClickListener(this
        );

    }

    private List<Map<String, Object>> listarCacadores() {
        cacadores = new ArrayList<Map<String,Object>>();
        Map<String, Object> item = new HashMap<String, Object>();
        item.put("imagem", R.drawable.support);
        item.put("nome", "Suporte");
        cacadores.add(item);
        item = new HashMap<String, Object>();
        item.put("imagem", R.drawable.assault);
        item.put("nome", "Assalto");
        cacadores.add(item);

        return cacadores;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            /*Map<String, Object> map = cacadores.get(position);
            String destino = (String) map.get("nome");
            String mensagem = "A Classe selecionada foi: "+ destino;
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();*/

        Intent intent = new Intent(this, ClasseActivity.class);
        startActivity(intent);

    }
}
