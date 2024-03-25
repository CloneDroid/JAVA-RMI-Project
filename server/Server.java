import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server{

	public static void main(String[] args){

		try{
			Cart cart = new Cart();
			ProductInterface stub_cart = (ProductInterface) UnicastRemoteObject.exportObject(cart, 0);
			Registry registry = LocateRegistry.createRegistry(9100);
			registry.rebind("cart", stub_cart);
		} catch (Exception e){
			System.out.println("Server exception " + e.toString());
			e.printStackTrace();
		}

		try{

			System.setProperty("java.rmi.server.hostname", "127.0.0.1");
			System.out.println("Server has been started...");

			ArrayList<Product> products = new ArrayList<>();
			Product Laptop = new Product("Laptop", "Lenovo", 1111, 10, 15, 20);
			Product MobilePhone = new Product("Mobile Phone", "iPhone", 2222, 10, 15, 20);
			Product Charger = new Product("Charger", "Lenovo Charger", 3333, 10, 15, 20);
			Product powerBank = new Product("Power Bank", "Panasonic", 4444, 10, 15, 20);

			for (Product product : products){
				product.viewProducts();
			}

			ProductInterface stub_laptop = (ProductInterface) UnicastRemoteObject.exportObject(Laptop, 0);
			ProductInterface stub_mobilePhone = (ProductInterface) UnicastRemoteObject.exportObject(MobilePhone, 0);
			ProductInterface stub_charger = (ProductInterface) UnicastRemoteObject.exportObject(Charger, 0);
			ProductInterface stub_powerBank = (ProductInterface) UnicastRemoteObject.exportObject(powerBank, 0);

			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

			registry.rebind("laptop", stub_laptop);
			registry.rebind("mobilePhone", stub_mobilePhone);
			registry.rebind("charger", stub_charger);
			registry.rebind("powerBank", stub_powerBank);

			System.out.println("Exporting and binding of Objects has been completed...");
		}catch(Exception e){
			System.out.println("Some server error..." + e);
		}
	}
}


// CLI Server - start rmiregistry 9100
// CLI Server - compile and run
// CLI Client - compile and run