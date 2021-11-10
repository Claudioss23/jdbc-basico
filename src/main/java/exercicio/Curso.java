package exercicio;

public class Curso {

    private int id;
    private int idAuxiliar;
    private String nome;
    private int duracaoHoras;

    public Curso(int id, String nome, int duracaoHoras) {
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(String nome, int duracaoHoras) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso() { }

    public int getIdAuxiliar() {
        return idAuxiliar;
    }

    public void setIdAuxiliar(int idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Curso{");

        sb.append("id= ").append(id);
        sb.append(", nome= '").append(nome).append('\'');
        sb.append(", duracao_horas= '").append(duracaoHoras).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
