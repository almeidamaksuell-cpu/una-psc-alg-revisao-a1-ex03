public class ProcessadorRisco {

    public static void main(String[] args) {
        
        int[] notasRisco = {
            10, 25, 80, 5, 
            95, // Analistas 0 a 4 (Sêniores - Peso 3)
            
            50, 65, 30, 75, 
            15, 45, 90, 85, 
            60, 70  // Analistas 5 a 14 (Juniores - Peso 1)
        };

        double somaPesos = 0;
        double somaNotasPonderadas = 0;
        
        for (int i = 0; i < notasRisco.length; i++) {
            int notaAtual = notasRisco[i];
            int peso;

            if (i >= 0 && i <= 4) {
                peso = 3; 
            } else {
                peso = 1;
            }

            somaNotasPonderadas += notaAtual * peso;
            somaPesos += peso;
        }

        double mediaPonderada = somaNotasPonderadas / somaPesos;

       
        int contagemOtimistas = 0; 
        int contagemAlarmantes = 0; 

        for (int nota : notasRisco) { 
            
            if (nota <= 20) { 
                contagemOtimistas++;
            }
            
            if (nota >= 90) { 
                contagemAlarmantes++;
            }
        }
        
       
        System.out.println("Processamento da Análise de Risco:");
        System.out.println("------------------------------------------");
        
        System.out.printf("Média Ponderada do Risco: %.2f\n", mediaPonderada);
        System.out.println("Analistas Otimistas (Nota <= 20): " + contagemOtimistas);
        System.out.println("Analistas Alarmantes (Nota >= 90): " + contagemAlarmantes);
        
        System.out.println("------------------------------------------");

        String parecerFinal;

        if (mediaPonderada > 70) {
            parecerFinal = "Alto Risco: Venda ou reajuste de portfólio recomendado.";
        } else if (mediaPonderada >= 40) {
            parecerFinal = "Risco Moderado: Acompanhar de perto, mas manter os ativos.";
        } else { 
            parecerFinal = "Baixo Risco: Excelente momento para capitalização.";
        }
        
        System.out.println("Parecer Final: " + parecerFinal);
    }
}