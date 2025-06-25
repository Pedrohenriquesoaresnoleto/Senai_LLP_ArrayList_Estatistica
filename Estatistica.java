import java.util.*;

public class Estatistica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> numeros = new ArrayList<>();

        while (true) {
            System.out.print("Informe um número (ou pressione Enter para encerrar): ");
            String entrada = scanner.nextLine();

            if (entrada.isEmpty()) break;

            try {
                double valor = Double.parseDouble(entrada);
                numeros.add(valor);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Tente novamente.");
            }
        }

        if (numeros.isEmpty()) {
            System.out.println("Nenhum número foi informado.");
            return;
        }

        double media = calcularMedia(numeros);
        double moda = calcularModa(numeros);
        double minimo = Collections.min(numeros);
        double maximo = Collections.max(numeros);
        double desvioPadrao = calcularDesvioPadrao(numeros, media);

        System.out.println("\nRESULTADOS:");
        System.out.printf("Média = %.2f\n", media);
        System.out.printf("Moda = %.2f\n", moda);
        System.out.printf("Mínimo = %.2f\n", minimo);
        System.out.printf("Máximo = %.2f\n", maximo);
        System.out.printf("Desvio Padrão = %.3f\n", desvioPadrao);

        scanner.close();
    }

    public static double calcularMedia(ArrayList<Double> lista) {
        double soma = 0;
        for (double num : lista) {
            soma += num;
        }
        return soma / lista.size();
    }

    public static double calcularModa(ArrayList<Double> lista) {
        HashMap<Double, Integer> frequencias = new HashMap<>();
        for (double num : lista) {
            frequencias.put(num, frequencias.getOrDefault(num, 0) + 1);
        }

        double moda = lista.get(0);
        int maxFreq = 0;
        for (Map.Entry<Double, Integer> entry : frequencias.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                moda = entry.getKey();
            }
        }
        return moda;
    }

    public static double calcularDesvioPadrao(ArrayList<Double> lista, double media) {
        double soma = 0;
        for (double num : lista) {
            soma += Math.pow(num - media, 2);
        }
        return Math.sqrt(soma / lista.size());
    }
}