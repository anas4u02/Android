import kotlin.math.PI
import kotlin.math.sqrt

fun main() {

    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 10.0)

    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor Area: %2f".format(floorArea()))
    }

    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor Area: %2f".format(floorArea()))
        println("Carpet Size: ${calculateMaxCarpetSize()}")
    }

    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor Area: %2f".format(floorArea()))
        println("Carpet Size: ${calculateMaxCarpetSize()}")
    }
 }


abstract class Dwelling(private var residents: Int) {

    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
}

    abstract fun floorArea(): Double
    
    fun getroom(){
        if (capacity > residents)
        residents ++
        else{
            println("Sorry, All Rooms are occupied!!")
        }
    }
}


class SquareCabin(residents: Int, 
    val length: Double) : Dwelling(residents) {
   
    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea(): Double {
       return length * length
    }
}


open class RoundHut(val residents: Int, 
    val radius: Double) : Dwelling(residents) {
   
    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }
    
    open fun calculateMaxCarpetSize(): Double{
        val diameter = 2 * radius
        return sqrt((diameter * diameter)/2)
    }
}


class RoundTower(residents: Int, radius: Double, 
    val floors: Int = 2) : RoundHut(residents, radius) {

    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
    override fun calculateMaxCarpetSize(): Double{
        val diameter = 2 * radius
        return sqrt((diameter * diameter)/2) * floors
    }
}