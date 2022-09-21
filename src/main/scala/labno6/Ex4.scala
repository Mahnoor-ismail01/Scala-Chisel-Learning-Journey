package labno6
import chisel3._
import chisel3.util._

class My_Queue extends Module {
val io=IO(new Bundle{
    val in1 = Flipped ( Decoupled ( UInt (8. W ) ) )
    val out=Decoupled( UInt (8. W ))
   
})

io.out.valid:=1.B
io.in1.ready:=1.B
val queue1 = Queue(io.in1,5)
val queue2 = Queue(queue1,5)
when (io.in1.valid && queue1.ready){

    io.out.enq(queue2.deq)
}


}