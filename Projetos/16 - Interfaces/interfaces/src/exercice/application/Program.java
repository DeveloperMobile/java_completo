package exercice.application;

import exercice.domain.entities.Contract;
import exercice.domain.entities.Installment;
import exercice.domain.service.ContractService;
import exercice.domain.service.PaypalService;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws DateTimeException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato: ");
        System.out.print("Número: ");
        int numero = sc.nextInt();
        System.out.print("Data (dd/MM/yy): ");
        sc.nextLine();
        LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Valor do contrato: ");
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(numero, date, totalValue);
        ContractService service = new ContractService(new PaypalService());

        System.out.print("Entre com o número de parcels: ");
        int parcelas = sc.nextInt();

        service.processContract(contract, parcelas);

        System.out.println("Parcelas: ");

        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        sc.close();
    }
}
