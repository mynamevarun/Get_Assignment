package cart;
import java.util.*;


// class to implement all the shopping cart methods

class ShoppingCart{
	HashMap<Item,Integer> mapp = new HashMap<>();
	
	void addToCart(Item item,int quantity) { // method to add item to cart
		mapp.put(item, quantity);
	}
	int showQuantity(Item item) {  // method to show the quantity of item in cart
		if(mapp.containsKey(item))
		return mapp.get(item);
		else 
			return 0;
	}
	void updateQuantity(Item item, int quantity) { // method to update the quantity of the item in the cart
		mapp.put(item, quantity);
	}
	
	void deleteItem(Item item) {     // method to delete the item from cart 
		mapp.remove(item);               
		System.out.println("Deleted Succesfully");
	}
	double displayBill() {        // method to display the total bill of cart
		Iterator<Item> cartIterator = mapp.keySet().iterator();
        double totalBill = 0d;
        while (cartIterator.hasNext()) {
            Item key = (Item) cartIterator.next();
            totalBill += key.getPrice() * mapp.get(key);
        }
        return totalBill;
	}
}


public class shoppingCartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item i1 = new Item("book","Good",10,5);
		Item i2 = new Item("toy","Good",19,6);
		Item i3 = new Item("laptop","Good",100,1);
		
		ShoppingCart cart = new ShoppingCart();
		cart.addToCart(i1,5);    // adding item to cart
		cart.addToCart(i2, 6);
		cart.addToCart(i3, 1);
		
		// printing the item 1 quantity
		System.out.println("The quantity is: "+cart.showQuantity(i1));
		
		
		cart.updateQuantity(i1,3);  // updating the quantity of item 1
		
		System.out.println("The updated quantity is: "+cart.showQuantity(i1));  // printing the updated quantity of item 1
		
		
		cart.deleteItem(i1);   // deleting the item 1
		
		System.out.println("Total Bill is: "+cart.displayBill());  // printing the total amount of items in the cart
	}

}
