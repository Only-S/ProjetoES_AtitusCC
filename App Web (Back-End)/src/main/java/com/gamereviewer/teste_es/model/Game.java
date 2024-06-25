package com.gamereviewer.teste_es.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gamereviewer.teste_es.json.ObjectIdDeserializer;
import com.gamereviewer.teste_es.json.ObjectIdSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "game")
public class Game {
    @Id
    @JsonSerialize(using = ObjectIdSerializer.class)
    @JsonDeserialize(using = ObjectIdDeserializer.class)
    private ObjectId id;
    private String nome;
    private String capa_path;
    private String qrcode;
    private String executavel;
    @JsonSerialize(contentUsing = ObjectIdSerializer.class)
    @JsonDeserialize(contentUsing = ObjectIdDeserializer.class)
    private ArrayList<ObjectId> lista_reviews;
    private ArrayList<String> categorias;
    private String descricao;

    public Game() {}

    public Game(ObjectId id, String nome, String capa_path, String qrcode, String executavel, ArrayList<ObjectId> lista_reviews, ArrayList<String> categorias, String descricao) {
        this.id = id;
        this.nome = nome;
        this.capa_path = capa_path;
        this.qrcode = qrcode;
        this.executavel = executavel;
        this.lista_reviews = lista_reviews;
        this.categorias = categorias;
        this.descricao = descricao;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapaPath() {
        return capa_path;
    }

    public void setCapaPath(String capa_path) {
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

    public ArrayList<ObjectId> getListaReviews() {
        return lista_reviews;
    }

    public void setListaReviews(ArrayList<ObjectId> lista_reviews) {
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
