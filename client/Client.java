import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class Client{

	private static ArrayList<ProductInterface> cart = new ArrayList<>();
	public static void main(String[] args){

		try{
			// Get the references of exported object from RMI Registry...

			//locate the registry.
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

			// Get the references of exported object from the RMI Registry...
			ProductInterface p1 = (ProductInterface) registry.lookup("laptop");
			ProductInterface p2 = (ProductInterface) registry.lookup("mobilePhone");
			ProductInterface p3 = (ProductInterface) registry.lookup("charger");
			ProductInterface p4 = (ProductInterface) registry.lookup("powerBank");

			Scanner scanner = new Scanner(System.in);
            boolean running = true;

			while (running) {
                System.out.println("Select an option:");
                System.out.println("1. Display products");
                System.out.println("2. Add product to cart");
                System.out.println("3. View products in cart");
                System.out.println("4. Exit");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        //displayProducts(laptop, mobilePhone, charger, powerBank);
						displayProducts(p1, p2, p3, p4);
                        break;
                    case 2:
                        //addProductToCart(scanner, laptop, mobilePhone, charger, powerBank);
						addProductToCart(scanner, p1, p2, p3, p4);
                        break;
                    case 3:
                        viewProductsInCart();
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Client side error: " + e);
        }
    }

    private static void displayProducts(ProductInterface laptop, ProductInterface mobilePhone, ProductInterface charger, ProductInterface powerBank) throws Exception {
        System.out.println("Products:");
        System.out.println("1. " + laptop.getName() + " - Price: " + laptop.getStoreprice());
        System.out.println("2. " + mobilePhone.getName() + " - Price: " + mobilePhone.getStoreprice());
        System.out.println("3. " + charger.getName() + " - Price: " + charger.getStoreprice());
        System.out.println("4. " + powerBank.getName() + " - Price: " + powerBank.getStoreprice());
    }

    private static void addProductToCart(Scanner scanner, ProductInterface laptop, ProductInterface mobilePhone, ProductInterface charger, ProductInterface powerBank) throws Exception {
        System.out.println("Select a product to add to cart:");
		System.out.println("1.Laptop \n2.Mobile Phone \n3.Charger \n4.Power Bank");
        int productNumber = scanner.nextInt();

        switch (productNumber) {
            case 1:
                cart.add(laptop);
                System.out.println(laptop.getName() + " added to cart.");
                break;
            case 2:
                cart.add(mobilePhone);
                System.out.println(mobilePhone.getName() + " added to cart.");
                break;
            case 3:
                cart.add(charger);
                System.out.println(charger.getName() + " added to cart.");
                break;
            case 4:
                cart.add(powerBank);
                System.out.println(powerBank.getName() + " added to cart.");
                break;
            default:
                System.out.println("Invalid product number.");
        }
    }

    private static void viewProductsInCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Products in cart:");
            for (ProductInterface product : cart) {
                try {
                    System.out.println("Name: " + product.getName());
                    System.out.println("Description: " + product.getDescription());
                    System.out.println("Price: " + product.getStoreprice());
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("Error displaying product details: " + e.getMessage());
                }
            }
		try{

		}
		catch (Exception e){
			System.out.println("Client side error..." + e);
		}
	}
}
}