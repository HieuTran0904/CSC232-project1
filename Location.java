import java.util.ArrayList;
class Location
{
    private String name, description;
	private ArrayList<Item> items;

    public Location(String name, String description)
    {
        this.name = name;
        this.description = description;
        items = new ArrayList<Item>();
    } 

    // Accessor for the name
    public String getName()
    {
        return this.name;
    }

    // Accessor for the description
    public String getDescription()
    {
        return this.description;
    }

    // Mutator for the name
    public void setName(String name)
    {
        this.name = name;
    }

    // Mutator for the description
    public void setDescription(String description)
    {
        this.description = description;
    }

    //Add i to the items ArrayList
    public void addItem(Item i)
    {
        this.items.add(i);
    }

    //Check the items in the ArrayList
    public boolean hasItem(String i)
    {
        i = i.toLowerCase();
        for (Item item: this.items)
            if (item.getName().toLowerCase().equals(i))
                return true;
		return false;
    }

    //Return the item from the list
    public Item getItem(String i)
    {
        i = i.toLowerCase();
        for (Item item: this.items)
            if (item.getName().toLowerCase().equals(i))
                return item;
        return null;
    }

    //Return the item by index
    public Item getItem(int i)
    {
        return this.items.get(i);
    }

    //Count the available items in the list
    public int numItems()
    {
        return this.items.size();
    }

    //Remove items from the list
    public Item removeItem(String i)
    {
        for (Item item: this.items)
            if (item.getName().equals(i))
            {
                Item ret = new Item(item); // copy constructor
                this.items.remove(item);
				return ret;
			}
		return null;
    }
}