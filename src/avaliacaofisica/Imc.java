package avaliacaofisica;

public class Imc {

    public static double calcularImc(double peso, double altura) {

        double imc = peso / (altura * altura);

        if (imc < 18.5) {
            System.out.println("Classificação do IMC é Baixo Peso");
        } else if (imc >= 18.5 && imc <= 24.9) {
            System.out.println("Classificação do IMC é Peso Normal");
        } else if (imc >= 25 && imc <= 29.9) {
            System.out.println("Classificação do IMC é Sobrepeso");
        } else {
            System.out.println("Classificação do IMC é Obesidade");
        }


        return peso / (altura * altura);
    }

}