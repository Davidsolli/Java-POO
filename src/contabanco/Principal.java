package contabanco;

import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        
        int escolha = 0;
        Scanner scan = new Scanner(System.in);
        ContaBanco conta1 = new ContaBanco();
        
        do {
            
            System.out.println("1. Para abrir uma nova conta." + "\n"
                             + "2. Para fechar sua conta." + "\n"
                             + "3. Para Depositar dinheiro em sua conta." + "\n"
                             + "4. Para sacar dinheiro da sua conta." + "\n"
                             + "5. Para pagar mensalidade da sua conta." + "\n" 
                             + "6. Para ver os estatus gerais de sua conta." + "\n"
                             + "0. Para sair." + "\n");
            
            escolha = scan.nextInt();
            
            switch(escolha) {
                case 1:
                    conta1.abrirConta();
                    break;
                case 2:
                    conta1.fecharConta();
                    break;
                case 3:
                    float d;
                    
                    System.out.println("Digite o valo de deposito: ");
                    d = scan.nextFloat();
                    
                    conta1.depositar(d);
                    break;
                case 4:
                    float s;
                    
                    System.out.println("Digite o valor de saque: ");
                    s = scan.nextFloat();
                    
                    conta1.sacar(s);
                    break;
                case 5:
                    conta1.pagarMensal();
                    break;
                case 6:
                    conta1.conta();
                    break;
            }
        } while(escolha != 0);
    }
}
