import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Location loc = new Location("Kitchen", "Cooking place");

		Item k = new Item("Knife", "Tool", "Deadliest cooking material");
		Item t = new Item("Turkey", "Food", "Good but not the best meat type");
		Item p = new Item("Plate", "Tool", "Shiny silver ellipse object");
		Item l = new Item("Toaster", "Appliance", "Stainless Classic Toaster");
		loc.addItem(k);
		loc.addItem(t);
		loc.addItem(p);
		loc.addItem(l);
		//run

        Scanner sc = new Scanner(System.in);
        
        // infinite loop
        boolean isRunning = true;
        while (isRunning)
        {
            System.out.print("Enter command: ");
            String command = sc.next();
            
            switch (command)
            {
                case "quit":
                    isRunning = false;
                    break;

                case "look":
                    System.out.println(loc.getName() + " - " + loc.getDescription());
                    for (int i = 0; i < loc.numItems(); i++)
                        System.out.println("+ " + loc.getItem(i).getName());
                    break;
                
                case "examine":
                    String item;
                    do
                    {
                        item = sc.nextLine();
                        item = item.trim();
                        if (item.isEmpty())
                            System.out.print("What do you want to examine? ");
                    } while (item.isEmpty());

                    Item it = loc.getItem(item);
                    if (it != null)
                        System.out.println(it.getName() + " - " + it.getDescription());
                    else
                        System.out.println("Cannot find that item");
                    break;

                default:
                    System.out.println("I don’t know how to do that");
                    break;
            }
        }  
        //be de dam de bien thai
    }
    
/*
 *  private static void createWorld()
    {
    	Location kitchen = new Location("Kitchen", "Cooking place");
    	kitchen.addItem(new Item("Kettle", "Appliance", "Perfect for brewing hot tea and coffee"));
    	kitchen.addItem(new Item("Turkey", "Food", "Good but not the best meat type"));
    	kitchen.addItem(new Item("Plate", "Dinnerware", "Shiny silver ellipse object"));
    	kitchen.addItem(new Item("Toaster", "Appliance", "Stainless Classic Toaster"));
    	kitchen.addItem(new ContainerItem("Toolbox", "Container", "A wooden box"));
    	((ContainerItem) kitchen.getItem("Toolbox")).addItem(new Item("Knife", "Cutlery", "Japanese Knife"));
    	((ContainerItem) kitchen.getItem("Toolbox")).addItem(new Item("Cutting Board", "Tool", "Plastic Board"));
    
		Location bedroom = new Location("Bedroom", "Sleeping place");
		bedroom.addItem(new Item("Bed", "Furniture", "Softest Bed on Earth"));
		bedroom.addItem(new Item("Wardrobe", "Furniture", "Old Wardrobe from the 90s"));
		bedroom.addItem(new Item("Lamp", "Furniture", "Rich textures, highlighted in silver leaf"));
		bedroom.addItem(new Item("Crib", "Furniture", "Easy to re-style and re-arrange"));
		bedroom.addItem(new ContainerItem("Dresser", "Container", "Three-drawer chest"));
    	((ContainerItem) bedroom.getItem("Dresser")).addItem(new Item("Tee", "Clothes", "H&M Slim Fit"));
    	((ContainerItem) bedroom.getItem("Dresser")).addItem(new Item("Hoodie", "Clothes", "Soft, brushed inside"));
    	
		Location hallway = new Location("Hallway", "Path to go outside");
		hallway.addItem(new Item("Ball", "Toy", "Ultra-durable and Chewy"));
		hallway.addItem(new Item("Golf Stick", "Tool", "Fancy Golf Stick"));
		hallway.addItem(new Item("Rug", "Decor", "Soft and Luxurious"));
		hallway.addItem(new Item("Sword", "Decor", "An Old Sword from the ancient Greece"));
		hallway.addItem(new ContainerItem("Chest", "Container", "Made of 100% natural bamboo"));
    	((ContainerItem) hallway.getItem("Chest")).addItem(new Item("Adidas Shoes", "Shoes", "8.5 White Basketball Shoes"));
    	((ContainerItem) hallway.getItem("Chest")).addItem(new Item("Fur Slippers", "Slippers", "Grey, Ombre"));
    	
		Location bathroom = new Location("Bathroom", "Shower");
		bathroom.addItem(new Item("Razor", "Blade", "Unisex, Double sided, Handmade Metal"));
		bathroom.addItem(new Item("Hairdryer", "Tool", "Salon-quality hairdryer"));
		bathroom.addItem(new Item("Towels", "Towel", "Extremely Soft on Face"));
		bathroom.addItem(new Item("Waste Basket", "Basket", "Open, Steel in Black, with small capacity"));
		bathroom.addItem(new ContainerItem("Caddy", "Container", "A wooden box"));
    	((ContainerItem) bathroom.getItem("Caddy")).addItem(new Item("Shampoo", "Tool", "Expensive Shampoo"));
    	((ContainerItem) bathroom.getItem("Caddy")).addItem(new Item("Conditioner", "Tool", "Empty bottle of Hair Conditioner"));
    	
		// connect all 4 to some of the others
		kitchen.connect("north", hallway);
		kitchen.connect("east", bathroom);
		
		hallway.connect("south", kitchen);
		
		bathroom.connect("west", kitchen);
		bathroom.connect("south", bedroom);
		
		bedroom.connect("north", bathroom);
		
		//assign currentLocation to kitchen
		currentLocation = kitchen;
		
		//construct myInventory
		myInventory = new ContainerItem("Backpack", "Container", "My own storage");
		
		
    }
 */
}
