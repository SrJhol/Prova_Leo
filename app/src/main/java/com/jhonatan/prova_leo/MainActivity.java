package com.jhonatan.prova_leo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editNome, editCodigo, editPreco, editQuantidade;
    private Button btnSalvar, btnVerLista;
    private ProdutoDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = ProdutoDatabase.getInstancia(this);

        editNome = findViewById(R.id.editNome);
        editCodigo = findViewById(R.id.editCodigo);
        editPreco = findViewById(R.id.editPreco);
        editQuantidade = findViewById(R.id.editQuantidade);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnVerLista = findViewById(R.id.btnVerLista);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarProduto();
            }
        });

        btnVerLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaProdutosActivity.class);
                startActivity(intent);
            }
        });
    }

    private void salvarProduto() {
        String nome = editNome.getText().toString().trim();
        String codigo = editCodigo.getText().toString().trim();
        String precoStr = editPreco.getText().toString().trim();
        String quantStr = editQuantidade.getText().toString().trim();

        if (nome.isEmpty() || codigo.isEmpty() || precoStr.isEmpty() || quantStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double preco = Double.parseDouble(precoStr.replace(",", "."));
            int quantidade = Integer.parseInt(quantStr);

            if (preco <= 0 || quantidade <= 0) {
                Toast.makeText(this, "Preço e quantidade devem ser positivos!", Toast.LENGTH_SHORT).show();
                return;
            }

            Produto produto = new Produto(nome, codigo, preco, quantidade);
            db.produtoDao().inserir(produto);

            Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos();

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Digite valores válidos!", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparCampos() {
        editNome.setText("");
        editCodigo.setText("");
        editPreco.setText("");
        editQuantidade.setText("");
        editNome.requestFocus();
    }
}
