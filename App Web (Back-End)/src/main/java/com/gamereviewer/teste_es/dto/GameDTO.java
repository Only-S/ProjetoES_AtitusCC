package com.gamereviewer.teste_es.dto;

import java.util.List;

public class GameDTO {
    private String id;
    private String nome;
    private String capaPath;
    private String executavel;
    private List<String> categorias;
    private String descricao;
    private int quantidadeReviews;
    private double mediaNotas;

    public GameDTO(String id, String nome, String capaPath, String executavel, List<String> categorias, String descricao, int quantidadeReviews, double mediaNotas) {
        this.id = id;
        this.nome = nome;
        this.capaPath = capaPath;
        this.executavel = executavel;
        this.categorias = categorias;
        this.descricao = descricao;
        this.quantidadeReviews = quantidadeReviews;
        this.mediaNotas = mediaNotas;
    }

    // Getters e Setters

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

    public String getCapaPath() {
        return capaPath;
    }

    public void setCapaPath(String capaPath) {
        this.capaPath = capaPath;
    }

    public String getExecutavel() {
        return executavel;
    }

    public void setExecutavel(String executavel) {
        this.executavel = executavel;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeReviews() {
        return quantidadeReviews;
    }

    public void setQuantidadeReviews(int quantidadeReviews) {
        this.quantidadeReviews = quantidadeReviews;
    }

    public double getMediaNotas() {
        return mediaNotas;
    }

    public void setMediaNotas(double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }
}
