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
    }
}
