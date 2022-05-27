package Builder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SantanderBoletoBuilder extends BoletoBuilder {

    static Long currentCod = Long.valueOf(1);

    @Override
    public void buildCodigoBarras() {
        boleto.codBarras = currentCod++; // Recebe o atual e depois incrementa.
    }

    @Override
    public void buildValor(Double valor) {
        boleto.valor = valor * 1.14;
    }

    @Override
    public void buildData(String dataVencimento) {
        SimpleDateFormat parser = new SimpleDateFormat("dd/mm/yyyy");
        try {
            boleto.dataVencimento = parser.parse(dataVencimento);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido");
        }
    }

    @Override
    public void buildCedente(String cedente) {
        boleto.cedente = cedente;

    }

    @Override
    public void buildSacado(String sacado) {
        boleto.sacado = sacado;
    }

    @Override
    public String toString() {
        NumberFormat formatter = new DecimalFormat("#0,00");
        return "\t\t\nBoleto\n" + "Banco Santander \n\n" + "Código de barras: " + boleto.codBarras + "\n" + "Cedente: "
                + boleto.cedente + "\n" + "Valor: " + formatter.format(boleto.valor) + "Vencimento: "
                + boleto.dataVencimento;
    }
}
