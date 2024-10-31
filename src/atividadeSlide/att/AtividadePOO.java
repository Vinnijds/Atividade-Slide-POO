package atividadeSlide.att;

import java.util.Scanner;

public class AtividadePOO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe seu nome: ");
        String usuario = scanner.nextLine();
        
        System.out.println("Saudações, " + usuario + "! Bem-vindo ao sistema de avaliação de saúde.");
        System.out.println("Escolha uma das opções a seguir:");
        System.out.println("1 - Calcular Índice de Massa Corporal (IMC)");
        System.out.println("2 - Estimar Taxa de Metabolismo Basal (TMB)");
        System.out.println("3 - Verificar se um número é par ou ímpar");
        
        int escolha = scanner.nextInt();
        
        switch (escolha) {
            case 1 -> calcularIMC(scanner);
            case 2 -> calcularMetabolismoBasal(scanner);
            case 3 -> verificarParImpar(scanner);
            default -> System.err.println("Opção inválida! Por favor, reinicie e selecione uma opção válida.");
        }
        scanner.close();
    }
    
    public static void calcularIMC(Scanner scanner) {
        System.out.print("Informe seu peso em quilogramas (kg): ");
        double massa = scanner.nextDouble();
        
        System.out.print("Informe sua altura em metros (m): ");
        double estatura = scanner.nextDouble();
        
        double imc = massa / (estatura * estatura);
        String classificacao = (imc < 19) ? "abaixo do peso" :
                               (imc < 25) ? "peso adequado" :
                               (imc < 30) ? "excesso de peso" :
                               (imc < 40) ? "obesidade grau I" : "obesidade grave";
        
        System.out.printf("Seu IMC é %.2f e sua classificação é %s.%n", imc, classificacao);
    }
    
    public static void calcularMetabolismoBasal(Scanner scanner) {
        System.out.print("Informe seu peso em quilogramas (kg): ");
        double massa = scanner.nextDouble();
        
        System.out.print("Informe sua idade: ");
        int idade = scanner.nextInt();
        
        System.out.print("Informe seu gênero (M/F): ");
        String genero = scanner.next().toUpperCase();
        
        double taxaMetabolica = estimarTaxaMetabolica(massa, idade, genero);
        
        if (taxaMetabolica != -1) {
            System.out.printf("Sua Taxa de Metabolismo Basal estimada é de %.2f calorias por dia.%n", taxaMetabolica);
        } else {
            System.err.println("Gênero inválido! Use 'M' para masculino ou 'F' para feminino.");
        }
    }

    private static double estimarTaxaMetabolica(double massa, int idade, String genero) {
        if ("M".equals(genero)) {
            if (idade < 30) return 15.057 * massa + 679;
            else if (idade < 60) return 11.6 * massa + 879;
            else return 13.5 * massa + 487;
        } else if ("F".equals(genero)) {
            if (idade < 30) return 14.7 * massa + 486.6;
            else if (idade < 60) return 8.7 * massa + 829;
            else return 10.5 * massa + 597;
        }
        return -1; 
    }
    
    public static void verificarParImpar(Scanner scanner) {
        System.out.print("Informe um número inteiro: ");
        if (scanner.hasNextInt()) {
            int numero = scanner.nextInt();
            System.out.println("O número " + numero + (numero % 2 == 0 ? " é Par." : " é Ímpar."));
        } else {
            System.err.println("Entrada inválida! Por favor, digite um número inteiro.");
        }
    }
}
