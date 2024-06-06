package br.com.bibliotecaspring.bibliotecaSpring.models;

public enum Genero {
    ACAO("Action", "Ação"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comédia"),
    DRAMA("Drama", "Drama"),
    CRIME("Crime", "Crime");

    private String generoAPI;
    private String generoPortugues;

    Genero(String generoAPI, String generoPortugues){
        this.generoAPI = generoAPI;
        this.generoPortugues = generoPortugues;
    }

    public static Genero fromString(String text) {
        for (Genero genero : Genero.values()) {
            if (genero.generoAPI.equalsIgnoreCase(text)) {
                return genero;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

    public static Genero fromPortugues(String text) {
        for (Genero genero : Genero.values()) {
            if (genero.generoPortugues.equalsIgnoreCase(text)) {
                return genero;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
