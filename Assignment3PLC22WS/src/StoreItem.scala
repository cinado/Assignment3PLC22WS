/**
 * @author Luka Dumonic
 * @id 12130861
 */

class StoreItem(var id: Int, var name: String, var value: Int) extends Logger with Item{
    override def logAction(actionName: String, name: String) : Unit = { println(name + " " + actionName)}
}