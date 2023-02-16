/**
 * @author <>
 * @id matrnr
 */

import scala.io.Source

object MainApp {
    def main(args: Array[String]): Unit = {
        val database = new Database
        val csvFile = Source.fromFile("data.csv");
        for(line <- csvFile.getLines().drop(1)){
            val values = line.split(",").map(_.trim())
            val newItem = new StoreItem(values(0).toInt, values(1), values(2).toInt)
            database.store(newItem)
        }

        println("--- SUM UP ---")
        println(database.sumUp())

        println("--- FILTERED BY ASUS ---")
        var filteredByAsus = database.filterByName("ASUS", database.getStoredItems())
        filteredByAsus.foreach(x => println(x.name))
        println(filteredByAsus.size)

        println("--- FILTERED BY Lenovo ---")
        var filteredByLenovo = database.filterByName("Lenovo", database.getStoredItems())
        filteredByLenovo.foreach(x => println(x.name))
        println(filteredByLenovo.size)

        println("--- FILTERED BY HP ---")
        var filteredByHp = database.filterByName("HP", database.getStoredItems())
        filteredByHp.foreach(x => println(x.name))
        println(filteredByHp.size)

        println("--- SORTED ITEMS ---")
        database.sortByValuesDsc().foreach(x => println(x.name + " " + x.value))
    }
}