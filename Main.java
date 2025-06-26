import java.util.Scanner;
public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static MaquinaPet maquinaPet =  new MaquinaPet();

    public static void main(String[] args) {
        scanner.useDelimiter("\\n");

        var opcao =-1;

        do {
            System.out.println("\n \n === Escolha uma opção ====");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer a máquina com água");
            System.out.println("3 - Abastecer a máquina com shampoo");
            System.out.println("4 - Verificar água da máquina");
            System.out.println("5 - Verificar shampoo na máquina");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet da máquina");
            System.out.println("9 - Limpar máquina");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1 -> maquinaPet.tomarBanho();
                case 2 -> setAgua();
                case 3 -> setShampoo();
                case 4 -> verificaAgua();
                case 5 -> verificaShampoo();
                case 6 -> checkIfTemPetInMachine();
                case 7 -> setPetMaquina();
                case 8 -> maquinaPet.retiraPet();
                case 9 -> maquinaPet.lavarMaquina();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida! \n");
            }
        }while (true);
    }
    private static void setAgua(){
        System.out.println("Tentando colocar agua na máquina \n");
        maquinaPet.adicionarAgua();
    }

    private static void setShampoo() {
        System.out.println("Tentando colocar shampoo na máquina \n");
        maquinaPet.adicionarShampoo();
    }

    private static void verificaAgua(){
        var litros = maquinaPet.getAgua();

        System.out.println("A máquina está no momento com " + litros + " litros de agua \n");
    }

    private static void verificaShampoo(){
        var quantidade = maquinaPet.getShampoo();
        System.out.println("A máquina está no momento com " + quantidade + " litros de shampoo \n");
    }


    private static void checkIfTemPetInMachine(){
        var temPet = maquinaPet.temPet();
        System.out.println(temPet ? "Tem pet na máquina" : "Não tem pet na máquina \n");
    }

    public static void setPetMaquina(){
       var nome = "";
       while (nome == null || nome.isEmpty()){
           System.out.println("Informe o nome do Pet \n");
           nome = scanner.next();
       }
       var pet = new Pet(nome);
       maquinaPet.setPet(pet);
        System.out.println("O pet " + pet.getNome() + "foi colocado na máquina \n");
    }

}
