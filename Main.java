import java.util.Scanner;

class Main {
	
	private static Location currentLocation;
    
	public static void main(String[] args) {
    	
		//create the world in this game
    	createWorld();
    	
    	Scanner sc = new Scanner(System.in);
    	
        // infinite loop
        boolean isRunning = true;
        while (isRunning)
        {
            System.out.print("Enter command: ");
            String command = sc.next();
            
            switch (command)
            {
            	case "go":
            		String direction;
                    do
                    {
                        direction = sc.nextLine();
                        direction = direction.trim();
                        if (direction.isEmpty())
                            System.out.print("Where do you want to go?");
                    } while (direction.isEmpty());
                    
                    if(currentLocation.canMove(direction)) 
                    {
                    	currentLocation = currentLocation.getLocation(direction);
                    	System.out.println("You travel to the " + currentLocation.getName());
                    }
                    else
                    	System.out.println("Sorry but that the location is not avaible. Please do something else");
                    
                    break;
                    
                case "quit":
                    isRunning = false;
                    break;

                case "look":
                    System.out.println(currentLocation.getName() + " - " + currentLocation.getDescription());
                    for (int i = 0; i < currentLocation.numItems(); i++)
                        System.out.println("+ " + currentLocation.getItem(i).getName());
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

                    Item it = currentLocation.getItem(item);
                    if (it != null)
                        System.out.println(it.getName() + " - " + it.getDescription());
                    else
                        System.out.println("Cannot find that item");
                    break;

                default:
                    System.out.println("I don't know how to do that");
                    break;
            }
        }  
    }
    
    public static void createWorld()
    {
    	//Location: Kitchen
    	Location kitchen = new Location("Kitchen", "Cooking place");
    	//Instantiate the item in the kitchen
    	Item kettle = new Item("Kettle", "Appliance", "Perfect for brewing hot tea and coffee");
    	Item turkey = new Item("Turkey", "Food", "Good but not the best meat type");
    	Item plate = new Item("Plate", "Dinnerware", "Shiny silver ellipse object");
    	Item toaster = new Item("Toaster", "Appliance", "Stainless Classic Toaster");
    	//Add item to the kitchen
    	kitchen.addItem(kettle);
    	kitchen.addItem(turkey);
    	kitchen.addItem(plate);
    	kitchen.addItem(toaster);
    	
    	//Location: bedroom
    	Location bedroom = new Location("Bedroom", "Sleeping place");
    	//Instantiate the item in the bedroom
    	Item bed = new Item("Bed", "Furniture", "Softest Bed on Earth");
    	Item wardrobe= new Item("Wardrobe", "Furniture", "Old Wardrobe from the 90s");
    	Item lamp = new Item("Lamp", "Furniture", "Rich textures, highlighted in silver leaf");
    	Item crib = new Item("Crib", "Furniture", "Easy to re-style and re-arrange");
    	//Add item to the bedroom
    	bedroom.addItem(bed);
    	bedroom.addItem(wardrobe);
    	bedroom.addItem(lamp);
    	bedroom.addItem(crib);
    	
    	//Location: hallway
    	Location hallway = new Location("Hallway", "Path to go outside");
    	//Instantiate the item in the hallway
    	Item ball = new Item("Ball", "Toy", "Ultra-durable and Chewy");
    	Item golf = new Item("Golf Stick", "Tool", "Fancy Golf Stick");
    	Item rug = new Item("Rug", "Decor", "Soft and Luxurious");
    	Item sword = new Item("Sword", "Decor", "An Old Sword from the ancient Greece");
    	//Add item to the hallway
    	hallway.addItem(ball);
    	hallway.addItem(golf);
    	hallway.addItem(rug);
    	hallway.addItem(sword);
    	
    	//Location: bathroom
    	Location bathroom = new Location("Bathroom", "Shower");
    	//Instantiate the item in the bathroom
    	Item razor = new Item("Razor", "Blade", "Unisex, Double sided, Handmade Metal");
    	Item hairDryer = new Item("Hairdryer", "Tool", "Salon-quality hairdryer");
    	Item towels = new Item("Towels", "Towel", "Extremely Soft on Face");
    	Item basket = new Item("Waste Basket", "Basket", "Open, Steel in Black, with small capacity");
    	//Add item to the bathroom
    	bathroom.addItem(razor);
    	bathroom.addItem(hairDryer);
    	bathroom.addItem(rug);
    	bathroom.addItem(sword);
    	
    	// Connect 4 places together.
		kitchen.connect("north", hallway);
		kitchen.connect("east", bathroom);
		
		hallway.connect("south", kitchen);
		
		bathroom.connect("west", kitchen);
		bathroom.connect("south", bedroom);
		
		bedroom.connect("north", bathroom);
		
		//assign currentLocation to kitchen
		currentLocation = kitchen;
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
