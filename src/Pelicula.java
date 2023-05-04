public class Pelicula {
    private int id;
    private String titulo;
    private Genero genero;
    private int estreno;

    public Pelicula(int id, String titulo, String genero, int estreno) {
        this.id = id;
        this.titulo = titulo;
        if(Genero.COMEDIA.toString().equals(genero) || Genero.MIEDO.toString().equals(genero) ||
                Genero.ROMANTICA.toString().equals(genero)) {
            this.genero = Genero.valueOf(genero);
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
        if(Genero.COMEDIA.toString().equals(genero) || Genero.MIEDO.toString().equals(genero) ||
                Genero.ROMANTICA.toString().equals(genero)) {
            this.genero = Genero.valueOf(genero);
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
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero=" + genero +
                ", estreno=" + estreno +
                '}';
    }
}
