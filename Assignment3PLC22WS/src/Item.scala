/**
 * @author <>
 * @id matrnr
 */

trait Item {
    var id: Int
    var name: String
    var value: Int

    def getId = id
    def getName = name
    def getValue = value

    def setId(idParam: Int): Unit = {
        id = idParam
    }

    def setName(nameParam: String): Unit = {
        name = nameParam
    }

    def setValue(valueParam: Int): Unit = {
        value = valueParam
    } 
}