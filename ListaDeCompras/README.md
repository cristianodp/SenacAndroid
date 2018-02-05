utf-8"?>
<menu xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:id="@+id/mn_limpar"
        android:icon="@android:drawable/ic_delete"
        android:title="Limpar"
        app:showAsAction="always" />
</menu>
```

----
#### Passo 7

Alteração do arquivo **MainActivity.java** para conter a liagação dos elementos de tela com o codigo e as funcionalidades descritas.

```java
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextComprar;
    ListView listView;
    AdapterItemComprar adapter;
    List<ItemDeCompra> lista;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextComprar = (EditText) findViewById(R.id.editTextCompra);
        listView = (ListView) findViewById(R.id.listView);

        lista = new ArrayList<ItemDeCompra>();



        adapter = new AdapterItemComprar(this,lista);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                lista.remove(i);
                adapter.notifyDataSetChanged();

                return false;
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemDeCompra itemDeCompra =  new ItemDeCompra();
                itemDeCompra.setDescricao(editTextComprar.getText().toString());
                itemDeCompra.setComprado(false);

                //Limpar campo na tela
                editTextComprar.setText("");

                //Adicionar item
                lista.add(itemDeCompra);

                //notificar o adapter que um novo item foi adicionado
                adapter.notifyDataSetChanged();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.mn_limpar){
            lista.clear();
            adapter.notifyDataSetChanged();
        }

        return super.onOptionsItemSelected(item);
    }
}

```
---
Feito todos esse passo basta executar.