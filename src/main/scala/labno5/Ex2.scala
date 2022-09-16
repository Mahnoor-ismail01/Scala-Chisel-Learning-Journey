package labno5
import chisel3._
import chisel3.util._
class eMux [ T <: Data ]( gen : T ) extends Bundle {

val out = Output ( gen. cloneType )
val in1 = Input ( gen . cloneType)
val in2 = Input ( gen . cloneType)
val sel = Input ( Bool () )}


class Mux2_to_1 (size:UInt) extends Module {
    val io = IO ( new eMux ( size ) )
    
io.out:= Mux( io.sel , io.in2 , io.in1 )

}

object Top5 {
def main ( args : Array [ String ]) : Unit =
{
val a=new Mux2_to_1(2.U) 

}}
 