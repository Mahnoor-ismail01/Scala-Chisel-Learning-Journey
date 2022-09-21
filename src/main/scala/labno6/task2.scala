package labno6
import chisel3._
import chisel3.util._

class XorCounter (val max:Int=4) extends Module{
    val io=IO(new Bundle{
        val out = Output ( UInt (( log2Ceil ( max ) . W ) ) )
    })
    val counter=RegInit(0.U(4.W))
    io.out:=0.U
    when(counter(3)===1.U){
        counter:=0.U
    

    }
    .otherwise{
        counter:=counter+1.U
    }
    io.out:=counter
}