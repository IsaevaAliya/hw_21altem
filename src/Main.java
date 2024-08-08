public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);

        while (true) {
            try {
                account.withDraw(6000);
                System.out.println("Успешно снято 6000 сом. Остаток: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println("Исключение: " + e.getMessage());
                System.out.println("Снимаем остаток: " + e.getRemainingAmount());
                try {
                    account.withDraw((int) e.getRemainingAmount());
                } catch (LimitException ex) {

                }
                break;
            }
        }
        System.out.println("Текущий остаток на счете: " + account.getAmount());
    }
}