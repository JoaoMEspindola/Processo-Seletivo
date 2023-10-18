import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        String[] candidatos = {"JOAO", "ANA", "PEDRO", "LUISA", "MARIA", "ALVARO", "EDILSA","CLARA"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if(continuarTentando){
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO REALIZADO");
            }

        }while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + "º tentativa");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato);
        }
    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDITATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

    static void selecaoCandidatos(){
        String[] candidatos = {"JOAO", "ANA", "PEDRO", "LUISA", "MARIA", "ALVARO", "EDILSA","CLARA"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);

            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void imprimirSelecionados(){
        String[] candidatos = {"JOAO", "ANA", "PEDRO", "LUISA", "MARIA"};
        System.out.println("Imprimindo a lista de candidatos: ");

        for (int i = 0; i < candidatos.length; i++){
            System.out.println("O candidato de nº " + i+1 + " é o " + candidatos[i]);
        }

        for (String candidato: candidatos){
            System.out.println("O candidato foi " + candidato);
        }
    }
}