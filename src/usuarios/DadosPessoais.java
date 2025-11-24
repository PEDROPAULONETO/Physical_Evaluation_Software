package usuarios;

public class DadosPessoais {

    private String nome;
    private int idade;
    private String email;
    private String sexo;
    private double peso;
    private double altura;
    private double abdominal;
    private double supra;
    private double peitoral;
    private double subescapular;
    private double triceptal;
    private double axilar;
    private double coxa;

    public DadosPessoais(String nome, int idade, String email, String sexo, double peso, double altura, double abdominal, double supra, double peitoral, double subescapular, double triceptal, double axilar, double coxa) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.abdominal = abdominal;
        this.supra = supra;
        this.peitoral = peitoral;
        this.subescapular = subescapular;
        this.triceptal = triceptal;
        this.axilar = axilar;
        this.coxa = coxa;
    }

    public DadosPessoais(String nome, int idade, String email, double peso, double altura, String sexo, double abdominal, double supra, double subescapular, double axilar, double axilar1, double triceptal, double coxa) {

    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getSexo() {
        return sexo;
    }

    public double getAbdominal() {
        return abdominal;
    }

    public double getSupra() {
        return supra;
    }

    public double getSubescapular() {
        return subescapular;
    }

    public double getPeitoral() {
        return peitoral;
    }

    public double getAxilar() {
        return axilar;
    }

    public double getTriceptal() {
        return triceptal;
    }

    public double getCoxa() {
        return coxa;
    }
}

