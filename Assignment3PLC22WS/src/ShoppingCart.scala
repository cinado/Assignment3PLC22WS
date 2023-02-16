/**
 * @author Luka Dumonic
 * @id 12130861
 */

trait ShoppingCart {
    def delete(id: Int): Array[StoreItem]
    def search(name: String): Array[StoreItem]
    def sortByValuesAsc(): Array[StoreItem]
    def sortByValuesDsc(): Array[StoreItem]
    def store(item: StoreItem): Array[StoreItem]
    def sumUp(): Int
}