public class ContaBancaria {

    // ATRIBUTOS (variáveis da conta)
    private double saldo;
    private double limiteChequeEspecial;
    private double valorUsadoChequeEspecial;

    // CONSTRUTOR (quando cria a conta)
    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;

        // Regra do cheque especial
        if (depositoInicial <= 500) {
            this.limiteChequeEspecial = 50;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }

        this.valorUsadoChequeEspecial = 0;
    }

    // CONSULTAR SALDO
    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    // CONSULTAR CHEQUE ESPECIAL
    public void consultarChequeEspecial() {
        System.out.println("Limite cheque especial: R$ " + limiteChequeEspecial);
        System.out.println("Usado do cheque especial: R$ " + valorUsadoChequeEspecial);
    }

    // DEPOSITAR DINHEIRO
    public void depositar(double valor) {
        saldo += valor;

        // Se estiver usando cheque especial, desconta primeiro
        if (valorUsadoChequeEspecial > 0) {
            double taxa = valorUsadoChequeEspecial * 0.2;

            if (saldo >= (valorUsadoChequeEspecial + taxa)) {
                saldo -= (valorUsadoChequeEspecial + taxa);
                valorUsadoChequeEspecial = 0;
                System.out.println("Cheque especial quitado com taxa de 20%");
            }
        }

        System.out.println("Depósito realizado!");
    }

    // SACAR DINHEIRO
    public void sacar(double valor) {

        double limiteTotal = saldo + (limiteChequeEspecial - valorUsadoChequeEspecial);

        if (valor <= limiteTotal) {

            // Se tiver saldo suficiente
            if (valor <= saldo) {
                saldo -= valor;
            } else {
                // Usa cheque especial
                double restante = valor - saldo;
                saldo = 0;
                valorUsadoChequeEspecial += restante;
            }

            System.out.println("Saque realizado!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    // PAGAR BOLETO (basicamente um saque)
    public void pagarBoleto(double valor) {
        sacar(valor);
        System.out.println("Boleto pago!");
    }

    // VERIFICAR SE ESTÁ USANDO CHEQUE ESPECIAL
    public void verificarUsoChequeEspecial() {
        if (valorUsadoChequeEspecial > 0) {
            System.out.println("Está usando cheque especial!");
        } else {
            System.out.println("Não está usando cheque especial.");
        }
    }
}