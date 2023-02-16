/**
 * @author <>
 * @id matrnr
 */

class Database extends ShoppingCart{
    private var storedItems: Array[StoreItem] = new Array[StoreItem](0)

    override def search(name: String): Array[StoreItem] = {
       var result = storedItems.filter(p => p.name.equals(name))

       if(result.isEmpty){
        println(name + " not found")
       }
       else{
        result.foreach(_.logAction("found", name))
       }
       result
    }

    override def store(item: StoreItem): Array[StoreItem] = {
        item.logAction("stored", item.name)
        storedItems = storedItems :+ item
        storedItems
    }
    
    override def sumUp(): Int = {
        storedItems.map(x => x.value).sum
    }

    def filterByName(name: String, items: Array[StoreItem]): Array[StoreItem] = {
        var filteredItems = items.filter(_.name.contains(name)).sortWith(_.value < _.value)
        filteredItems
    }

    override def delete(id: Int): Array[StoreItem] = {
        var alteredArray = new Array[StoreItem](0);
        for(element <- storedItems){
            if(element.id == id){
                element.logAction("deleted", element.name)
            }
            else{
                alteredArray :+ element
            }
        }
        storedItems = alteredArray
        storedItems
    }
    def sortByValuesAsc(): Array[StoreItem] = {
        storedItems.sortWith(_.value < _.value)
    }
    def sortByValuesDsc(): Array[StoreItem] = {
        storedItems.sortWith(_.value > _.value)
    }

    def getStoredItems(): Array[StoreItem] = {
        storedItems
    }
}