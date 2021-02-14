package basic;

public class BasicApp {
    public static void main(String arg[]) {
        WorkService workService = new WorkService();
        WorkManager employee = new Employee();
        WorkManager boss = new Boss();

        workService.setWorkManager(employee);
        workService.askWork();

        workService.setWorkManager(boss);
        workService.askWork();
    }
}
