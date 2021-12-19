package br.softhouse.ioc;

public class SendEmails {

    private SendEmails(String tipo, String endereco, String senha) {
    }

    public static SendEmails getDataEmail() {
        return new SendEmails("smtp", "contact@email.com", "password");
    }

    public void success(String mensagem) {
        System.out.println();
        System.out.println("-".repeat(40));
        System.out.println("email sent");
        System.out.println("-".repeat(40));
    }

}
