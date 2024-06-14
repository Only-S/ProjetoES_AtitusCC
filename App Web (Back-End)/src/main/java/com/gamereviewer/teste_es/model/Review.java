package com.gamereviewer.teste_es.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "review")
public class Review {
    @Id
    private String id;
    private int nota_grafico;
    private int nota_trilha_sonora;
    private int nota_historia;
    private int nota_gameplay;
    private String anexo;
    private String comentario;
    private String usuario;

    public Review() {
    }

    public Review(String id, int nota_grafico, int nota_trilha_sonora, int nota_historia, int nota_gameplay, String anexo, String comentario, String usuario) {
        this.id = id;
        this.nota_grafico = nota_grafico;
        this.nota_trilha_sonora = nota_trilha_sonora;
        this.nota_historia = nota_historia;
        this.nota_gameplay = nota_gameplay;
        this.anexo = anexo;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNota_grafico() {
        return nota_grafico;
    }

    public void setNota_grafico(int nota_grafico) {
        this.nota_grafico = nota_grafico;
    }

    public int getNota_trilha_sonora() {
        return nota_trilha_sonora;
    }

    public void setNota_trilha_sonora(int nota_trilha_sonora) {
        this.nota_trilha_sonora = nota_trilha_sonora;
    }

    public int getNota_historia() {
        return nota_historia;
    }

    public void setNota_historia(int nota_historia) {
        this.nota_historia = nota_historia;
    }

    public int getNota_gameplay() {
        return nota_gameplay;
    }

    public void setNota_gameplay(int nota_gameplay) {
        this.nota_gameplay = nota_gameplay;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
