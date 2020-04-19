class Item
{ 
    private String name, type, description;

    public Item(String name, String type, String description)
    {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    // copy constructor
    public Item(Item item)
    {
        this.name = item.name;
        this.type = item.type;
        this.description = item.description;
    }

    // get name of this item
    public String getName()
    {
        return this.name;
    }

    // get type of this item
    public String getType()
    {
        return this.type;
    }

    // get description of this item
    public String getDescription()
    {
        return this.description;
    }

    // set name of this item
    public void setName(String name)
    {
        this.name = name;
    }

    // set type of this item
    public void setType(String type)
    {
        this.type = type;
    }

    // set description of this item
    public void setDescription(String description)
    {
        this.description = description;
    }

    // format the representative of this object
    public String toString()
    {
        return this.name + " [" + this.type + "]: " + this.description;
    }
}