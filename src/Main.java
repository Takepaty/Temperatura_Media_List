import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<Double>();

        //Adicionando as temperaturas na lista:
        int count = 0;
        while (true){
            if (count == 6) break;

            System.out.println("Digite a temperatura: ");
            double temp = scan.nextDouble();
            temperaturas.add(temp);
            count++;
        }
        System.out.println("--------------------------");

        //exibindo todas as temperaturas:
        System.out.println("Totas as temperaturas: ");
        temperaturas.forEach(t -> System.out.println(t + " "));
        System.out.println("--------------------------");

        //calculando e exibindo a média das temperaturas:
        Double media = temperaturas.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0d);
        System.out.printf("\nMédia das temperaturas: %.1f\n", media);
        System.out.println("--------------------------");

        //exibindo as temperaturas acima da média
        System.out.println("Temperatura acima da média");
        temperaturas.stream()
                .filter(t -> t > media)
                .forEach(t -> System.out.printf("%.1f\n", t));
        System.out.println("--------------------------");

        //exibindo o mês das temperaturas acima da média por extenso:
        System.out.println("\n\nMeses das temperaturas acima da média: ");
        Iterator<Double> iterator = temperaturas.iterator();

        count = 0;
        while (iterator.hasNext()){
            Double temp = iterator.next();
            if (temp > media){
                switch (count) {
                    case (0):
                        System.out.printf("1 - Janeiro: %.1f\n ", temp);
                        break;
                    case (1):
                        System.out.printf("2 - Fevereiro: %.1f\n", temp);
                        break;
                    case (2):
                        System.out.printf("3 - Março: %.1f\n", temp);
                        break;
                    case (3):
                        System.out.printf("4 - Abril: %.1f\n", temp);
                        break;
                    case (4):
                        System.out.printf("5 - Maio: %.1f\n", temp);
                        break;
                    case (5):
                        System.out.printf("6 - Junho: %.1f\n", temp);
                        break;
                    default:
                        System.out.println("Não houve temperatura acima da média.");
                }
            }
            count++;
        }
    }
}

