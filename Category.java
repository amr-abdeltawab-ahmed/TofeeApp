import java.util.ArrayList;

public class Category {
    private String name;
    private String description;
    private int categoryId;
    private ArrayList<Item> itemLists;

    public String getName() {
        return name;
    }
    public void additem(Item item){
        this.itemLists.add(item);
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category() {
        this.itemLists = new ArrayList<Item>();
    }



    public int getCategory_it() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Category(String name,  int categoryId , String description) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.itemLists = new ArrayList<Item>();
    }
}
