package practice 

class LAB1 ( counterBits : Int ) {
val max = (2 << counterBits ) - 1
var count = 0
if ( count == max ) {
count = 0
}
else {
count = count + 1
println(s"thisssssss $max")
}
}
class scalatypecasting(){
    val f: Float=34.6F
    val c: Char='a'
    val i: Int=97
    val ccast= c.asInstanceOf[Int]
    val fcast=f.asInstanceOf[Int]
    
    val ffcast=i.asInstanceOf[Char]
    println(ffcast)


}
object Top {
def main ( args : Array [ String ]) : Unit =
{
var pObject = new LAB1(5)

}}
