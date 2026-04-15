package com.jhonatan.prova_leo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity {

    private RecyclerView recyclerProdutos;
    private ProdutoAdapter adapter;
    private Button btnVoltar;
    private ProdutoDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        db = ProdutoDatabase.getInstancia(this);
        recyclerProdutos = findViewById(R.id.recyclerProdutos);
        btnVoltar = findViewById(R.id.btnVoltar);

        // Configurar RecyclerView
        recyclerProdutos.setLayoutManager(new LinearLayoutManager(this));
        
        // Buscar produtos do banco
        List<Produto> lista = db.produtoDao().listarTodos();
        
        // Configurar Adapter
        adapter = new ProdutoAdapter(lista);
        recyclerProdutos.setAdapter(adapter);

        // Botão Voltar
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Fecha a activity e volta para a anterior
            }
        });
    }
}
