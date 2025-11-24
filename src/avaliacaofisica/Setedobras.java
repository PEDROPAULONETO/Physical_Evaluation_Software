package avaliacaofisica;

public class Setedobras {

    public static double somaDobras(double abdominal, double supra, double axilar, double subescapular, double peitoral, double triceptal, double coxa) {

        double somaDobras = abdominal + supra + axilar + subescapular + peitoral + triceptal + coxa;

        return abdominal + supra + axilar + subescapular + peitoral + triceptal + coxa;
    }

    public static double densidadeCorporal(double somaDobras, int idade, String sexo) {

        if (sexo.equalsIgnoreCase("M")) {
            return 1.112 - (0.00043499 * somaDobras) + (0.00000055 * (somaDobras * somaDobras)) - (0.0002882 * idade);
        } else {
            return 1.0970 - (0.00046971 * somaDobras) + (0.00000056 * (somaDobras * somaDobras)) - (0.00012828 * idade);
        }
    }

    public static double percentualGordura(double densidadeCorporal, String sexo, int idade) {

        double percentualGordura = (4.95 / densidadeCorporal - 4.5) * 100;

        if (sexo.equalsIgnoreCase("M") && idade >= 18 && idade <= 25 && percentualGordura >= 8 && percentualGordura <= 16) {
            System.out.println("Percentual de Gordura está dentro do normal");
        } else if (sexo.equalsIgnoreCase("M") && idade >= 26 && idade <= 36 && percentualGordura >= 12 && percentualGordura <= 20) {
            System.out.println("Percentual de Gordura está dentro do normal");
        } else if (sexo.equalsIgnoreCase("M") && idade >= 36 && idade <= 45 && percentualGordura >= 16 && percentualGordura <= 23) {
            System.out.println("Percentual de Gordura está dentro do normal");
        } else if (sexo.equalsIgnoreCase("M") && idade >= 46 && idade <= 55 && percentualGordura >= 18 && percentualGordura <= 25) {
            System.out.println("Percentual de Gordura está dentro do normal");
        } else if (sexo.equalsIgnoreCase("F") && idade >= 18 && idade <= 25 && percentualGordura >= 16 && percentualGordura <= 25) {
            System.out.println("Percentual de Gordura está dentro do normal");
        } else if (sexo.equalsIgnoreCase("F") && idade >= 26 && idade <= 36 && percentualGordura >= 16 && percentualGordura <= 25) {
            System.out.println("Percentual de Gordura está dentro do normal");
        } else if (sexo.equalsIgnoreCase("F") && idade >= 36 && idade <= 45 && percentualGordura >= 19 && percentualGordura <= 29) {
            System.out.println("Percentual de Gordura está dentro do normal");
        } else if (sexo.equalsIgnoreCase("F") && idade >= 46 && idade <= 55 && percentualGordura >= 21 && percentualGordura <= 31) {
            System.out.println("Percentual de Gordura está dentro do normal");
        } else {
            System.out.println("Percentual de Gordura está fora do normal");
        }
        return (4.95 / densidadeCorporal - 4.5) * 100;
    }
}

