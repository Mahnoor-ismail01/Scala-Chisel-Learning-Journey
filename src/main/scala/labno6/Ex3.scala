package labno6
import chisel3._
import chisel3.util._

class TwoShotTimer extends Module{
    val io =IO(new Bundle{
        
        val reload=Input(Bool())
        val out=Output(Bool())

    })
    val din =2.U
    val timer_count = RegInit (0. U (8. W ) )
val done = timer_count === 0. U
val next = WireInit (0. U )
io.out:=0.B
when (io.reload){
    next:=din
}
.otherwise{

next:=0.B
}
when (!done){
    next:=timer_count-1.U

}
.otherwise{

next:=0.B
}


}