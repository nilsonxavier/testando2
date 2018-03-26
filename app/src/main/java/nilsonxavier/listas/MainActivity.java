package nilsonxavier.listas;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText txtInput;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.listv);
        String[] items = {"nilson","xavier","freitas"};
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this,R.layout.lis_item,R.id.txtitem,arrayList);
        listView.setAdapter(adapter);
        txtInput = (EditText)findViewById(R.id.editText);
        Button button = (Button)findViewById(R.id.button);

        // acao do botao adicionar na lista
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String newItem = txtInput.getText().toString();
                arrayList.add(newItem);
                adapter.notifyDataSetChanged();
            }
        });

        // acao do botao cadCliente
        Button cadCliente = (Button)findViewById(R.id.cadCliente);
        cadCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.cad_clientes);
            }
        });
    }

    public void butnGerar (View view){
        // mostrar mensagem toast

        EditText nome = (EditText) findViewById(R.id.editText2);
        String text = nome.getText().toString();
        Toast toast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG);
        toast.show();
    }

    public void butnEnviar (View view){
        // exibindo toast
        Context context = getApplicationContext();
        EditText nome = (EditText) findViewById(R.id.editText2);
        String text = nome.getText().toString();
        // Enviar toast para outra pagina
        setContentView(R.layout.mostrar_toast);
        Toast toast = Toast.makeText(context ,text , Toast.LENGTH_LONG);
        toast.show();
    }

}
