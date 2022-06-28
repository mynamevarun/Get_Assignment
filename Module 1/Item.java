package cart;


class Item{
		private static int id=0;
		private String name;
		private String desc;
		private double price;
		private int quantity;
		
		Item(String name, String desc, double price, int quantity){
			
			this.name=name;
			this.desc=desc;
			this.price=price;
			this.quantity=quantity;
			Item.id++;
		}
		
		
		public String getName() {
			return this.name;
		}
		public String getDesc() {
			return this.desc;
		}
		public double getPrice() {
			return this.price;
		}
		public int getQuantity() {
			return this.quantity;
		}
		
		public static double getPrice(Item item) {
			return item.price;
		}
	};


