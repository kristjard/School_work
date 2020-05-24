import servlet.JettyServer;


public class App {

    public static void main(String[] Args){


        JettyServer server = new JettyServer();


        try {
            server.start();
        }
        catch (Exception ex){
            System.out.println("ettenägematu puue");
        }

    }
}
