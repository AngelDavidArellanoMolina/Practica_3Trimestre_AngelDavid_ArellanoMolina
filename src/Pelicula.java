public class Pelicula {
    private int id;
    private String titulo;
    private Genero genero;
    private int estreno;

    public Pelicula(int id, String titulo, String genero, int estreno) {
        this.id = id;
        this.titulo = titulo;
        if(Genero.COMEDIA.toString().equals(genero.toUpperCase()) || Genero.MIEDO.toString().equals(genero.toUpperCase()) ||
                Genero.ROMANTICA.toString().equals(genero.toUpperCase())) {
            this.genero = Genero.valueOf(genero.toUpperCase());
        } else {
            throw new IllegalArgumentException("no existe un genero llamado "+genero);
        }
        this.estreno = estreno;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if(Genero.COMEDIA.toString().equals(genero.toUpperCase()) || Genero.MIEDO.toString().equals(genero.toUpperCase()) ||
                Genero.ROMANTICA.toString().equals(genero.toUpperCase())) {
            this.genero = Genero.valueOf(genero.toUpperCase());
        } else {
            throw new IllegalArgumentException("no existe un genero llamado "+genero);
        }
    }

    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\t    Título: '" + titulo + '\'' +
                "\t    Género: " + genero +
                "\t    Año de estreno: " + estreno;
    }
}
