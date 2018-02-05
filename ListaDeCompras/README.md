# Lista de Compras

Este exercício contempla a criação de uma lista de compra para Dispositivo Mobile Android. Sendo possível adicionar itens, marcar como comprado e limpar a lista.

![](https://raw.githubusercontent.com/cristianodp/SenacAndroid/master/ListaDeCompras/imgs/prototipo_1.png)

----
### Criação do projeto com Android Studio.

#### Passo 1

Abra o Android Studio ![](https://developer.android.com/studio/images/studio-icon.png) e crie um novo projeto com o nome **Lista de Compras**.

![](https://raw.githubusercontent.com/cristianodp/SenacAndroid/master/ListaDeCompras/imgs/criacao_projeto_1.PNG)

----
#### Passo 2

Criar a classe de modelo de dados **ItemDeCompra**.

```java
public class ItemDeCompra {

    private String descricao;
    private Boolean comprado;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getComprado() {
        return comprado;
    }

    public void setComprado(Boolean comprado) {
        this.comprado = comprado;
    }
}

```
>Notem que os atributos são criados como privados, assim foram necessários criar os gets e sets dos atributos. 

----
#### Passo 3

Criar o arquivo **layout_item_compar.xml** em res->layout, que corresponderá ao layout do item da lista.

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/checkBox1"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:layout_toLeftOf="@+id/checkBox1"
        android:layout_toStartOf="@+id/checkBox1"
        android:text="TextView"
        android:textSize="24sp" />

    <CheckBox
        android:id="@+id/checkBox1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentEnd="true"
        android:layout_alignParentRight="true"
        android:layout_alignParentTop="true" />
</RelativeLayout>
```
----
#### Passo 4

Criar adapter para o modelo de dados **ItemDeCompra.java** como o layout da **layout_item_compar.xml** com o nome de **AdapterItemComprar.java**.

>Um objeto Adapter atua como uma ponte entre um AdapterView e os dados subjacentes para essa visualização. Ver mais detalhes consulte a [Documentação](https://developer.android.com/reference/android/widget/Adapter.html).

```java
public class AdapterItemComprar extends BaseAdapter {

    private List<ItemDeCompra> lista;
    private Context context;

    public AdapterItemComprar(Context context, List<ItemDeCompra> lista){
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i) ;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(R.layout.layout_item_compar, null);

        TextView textView1 = view.findViewById(R.id.textView1);
        CheckBox checkBox1 = view.findViewById(R.id.checkBox1);

        textView1.setText(lista.get(i).getDescricao());
        checkBox1.setChecked(lista.get(i).getComprado());

        return view;
    }
}

```

----
#### Passo 5

Criar o layout da lista de compra. Lembrando que o arquivo do layout ja foi criando e se encontra em res->layout->**activity_man.xml**.

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="6dp"
        android:text="Comprar"
        app:layout_constraintBottom_toTopOf="@+id/editTextCompra"
        app:layout_constraintLeft_toLeftOf="@+id/editTextCompra" />

    <EditText
        android:id="@+id/editTextCompra"
        android:layout_width="250dp"
        android:layout_height="wrap_content"
        android:layout_marginLeft="8dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="60dp"
        android:ems="10"
        android:inputType="text"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginStart="8dp"
        android:text="Add"
        app:layout_constraintLeft_toRightOf="@+id/editTextCompra"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="@+id/editTextCompra" />

    <ListView
        android:id="@+id/listView"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginLeft="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginTop="8dp"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editTextCompra"
        android:layout_marginStart="8dp"
        android:layout_marginEnd="8dp" />
</android.support.constraint.ConstraintLayout>

```

>Notem que o nos elementos o atributo **text** está sendo preenchido com o texto direto, contudo o mais correto e utilizar as strings.xml.

----
#### Passo 6

Criar o menu com o botão limpar com o nome de **menu_principal.xml** em res->menu.

```xml
<?xml version="1.0" encoding="utf-8"?>
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