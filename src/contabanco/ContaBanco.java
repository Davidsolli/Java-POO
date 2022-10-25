package contabanco;

import java.util.Scanner;

public class ContaBanco {
    
    public int numConta;
    protected String tipo;//"CC" = conta corrente "CP" = conta poupança.
    private String dono;
    private float saldo;
    private boolean status;
    
    Scanner scan = new Scanner(System.in);
    
    public ContaBanco() {
        setNumConta(000000);
        setDono(null);
        setSaldo(0);
        setStatus(false);
        setTipo(null);
    }
    
    public void abrirConta() {
        setStatus(true);
        setNumConta(123456);
        
        System.out.println("Vamos ao cadastro!" + "\n" 
                         + "Digite o tipo da conta: " + "\n\n" 
                         + "\"CC\" = conta corrente" + "\n" + "\"CP\" = conta poupança.");
        setTipo(scan.next());
        
        System.out.println("Digite seu nome completo: ");
        setDono(scan.next());
        
        if("CC".equals(getTipo())) {
            setSaldo(50);
        } else {
            setSaldo(150);
        }
        
        System.out.println("Cadastro realizado com sucesso!" + "\n");
    }
    
    public void fecharConta() {
        if(isStatus() == false) {
            System.out.println("Sua conta ja esta fechada!" + "\n");
        } else if(getSaldo() == 0) {
            setStatus(false);           
            setNumConta(000000);
            setDono(null);
            setSaldo(0);
            setTipo(null);
            
            System.out.println("Conta fechada!");
        } else {
            System.out.println("Existe debito a ser sacado ou pago em sua conta.\nPortanto, não pode ser fechada." + "\n");
        }
    }
    
    public void depositar(float d) {
        if(isStatus() == true) {
            setSaldo(getSaldo() + d);
        } else {
            System.out.println("Essa conta esta fechada.\nPortanto, não pode ser debitada." + "\n");
        }
    }
    
    public void sacar(float s) {
        if(isStatus() == false) {
            System.out.println("Sua conta esta fechada!" + "\n");
        } else if(s <= getSaldo()) {
            setSaldo(getSaldo() - s);
            
            System.out.println("Seu saldo: " + getSaldo() + "\n");
        } else {
            System.out.println("O valor que voce deseja sacar: " + s + "\nÉ superior ao seu saldo: " + getSaldo() + "\n");
        }
    }
    
    public void pagarMensal() {
        if(isStatus() == false) {
            System.out.println("Sua conta esta fechada!" + "\n");
        } else if("CC".equals(getTipo()) && getSaldo() >= 12) {
            setSaldo(getSaldo() - 12);
            
            System.out.println("Mensalidade paga!" + "\n");
        } else if("CP".equals(getTipo()) && getSaldo() >= 20){
            setSaldo(getSaldo() - 20);
            
            System.out.println("Mensalidade paga!" + "\n");
        } else {
            System.out.println("Voce não tem saldo o sulficiente para pagar a mensalidade!");
        }
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void conta() {
        System.out.println("Numero de sua conta: " + getNumConta() + "\n" 
                         + "Seu nome: " + getDono() + "\n" 
                         + "Seu saldo: " + getSaldo() + "\n" 
                         + "Status de sua conta: " + isStatus() + "\n" 
                         + "O tipo de sua conta: " + getTipo() + "\n");
    }
}
