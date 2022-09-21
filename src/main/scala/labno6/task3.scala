package labno6
import chisel3._
import chisel3.util._

class shift_reg_with_parallel_load ( val len : Int =4)  extends Module{
    val io=IO(new Bundle{
        val out = Vec ( len , Output ( Bool () ) )
        val load_in = Vec ( len , Input ( Bool () ) )
        val in = Input ( Bool () )
        val load = Input ( Bool () )
        
    })
    val state = RegInit ( 1. U (4. W ) )
    io.out(0):=0.B
    io.out(1):=0.B
    io.out(2):=0.B
    io.out(3):=0.B
    val counter= RegInit ( 0. U (3. W ) )
    when (counter=/=len.U){
    when (io.load){
        val nextState = ( state << 1) | io . in
        state:=nextState
        io.out(counter):=state(counter).asBool
        counter:=counter+1.U

    }

}}