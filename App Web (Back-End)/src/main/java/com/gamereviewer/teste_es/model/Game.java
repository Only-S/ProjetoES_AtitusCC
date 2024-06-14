package com.gamereviewer.teste_es.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "game")
public class Game {
    @Id
    private String id;
    private String nome;
    private String capa_path;
    private String qrcode;
    private String executavel;
    private ArrayList<Review> lista_reviews;
    private ArrayList<String> categorias;
    private String descricao;

    public Game() {
    }

    public Game(String id, String nome, String capa_path, String qrcode, String executavel, ArrayList<Review> lista_reviews, ArrayList<String> categorias, String descricao) {
        this.id = id;
        this.nome = nome;
        this.capa_path = capa_path;
        this.qrcode = qrcode;
        this.executavel = executavel;
        this.lista_reviews = lista_reviews;
        this.categorias = categorias;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapa_path() {
        return capa_path;
    }

    public void setCapa_path(String capa_path) {
        this.capa_path = capa_path;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getExecutavel() {
        return executavel;
    }

    public void setExecutavel(String executavel) {
        this.executavel = executavel;
    }

    public ArrayList<Review> getLista_reviews() {
        return lista_reviews;
    }

    public void setLista_reviews(ArrayList<Review> lista_reviews) {
        this.lista_reviews = lista_reviews;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
