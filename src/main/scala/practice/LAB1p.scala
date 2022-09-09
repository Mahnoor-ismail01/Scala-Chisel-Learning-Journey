package practice
import chisel3.stage.ChiselStage
import chisel3 . _
class Counter ( size : Int , maxValue : Int ) extends Module {
val io = IO ( new Bundle {
val result = Output ( Bool() )
})
// ' genCounter ' with counter size 'n '
def genCounter ( n : Int , max : Int ) = {
val count = RegInit (0.U ( n.W ) )//kitny bit ki value reg m askti
println(count)
when ( count === max.asUInt ) {
count := 0.U
}.otherwise {
count := count + 1.U
println(count)
}
count

}
// genCounter instantiation
val counter1 = genCounter(size , maxValue )
io.result := counter1 (size-1)
}



object Top1 {
def main ( args : Array [ String ]) : Unit =
{
var pObject = new  Counter(8,1)

}}
//println((new chisel3.stage.ChiselStage).emitVerilog(new Counter(8,255.U)))
