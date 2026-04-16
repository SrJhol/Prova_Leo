package com.jhonatan.prova_leo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Activity responsável por exibir a listagem de todos os produtos cadastrados.
 */
public class ListaProdutosActivity extends AppCompatActivity {

    private RecyclerView recyclerProdutos;
    private ProdutoAdapter adapter;
    private Button btnVoltar;
    private ProdutoDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        // Inicializa a instância do banco de dados
        db = ProdutoDatabase.getInstancia(this);

        // Mapeia os componentes do layout
        recyclerProdutos = findViewById(R.id.recyclerProdutos);
        btnVoltar = findViewById(R.id.btnVoltar);

        // Configura o RecyclerView com um gerenciador de layout linear (lista vertical)
        recyclerProdutos.setLayoutManager(new LinearLayoutManager(this));
        
        // Busca a lista de produtos diretamente do banco de dados
        List<Produto> lista = db.produtoDao().listarTodos();
        
        // Inicializa o adaptador com os dados e conecta ao RecyclerView
        adapter = new ProdutoAdapter(lista);
        recyclerProdutos.setAdapter(adapter);

        // Configura o botão para fechar a tela atual e retornar à tela de cadastro
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finaliza esta activity, voltando automaticamente para a MainActivity
                finish();
            }
        });
    }
}
