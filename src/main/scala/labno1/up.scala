package labno1
import chisel3._


class counter_up_down(n : Int) extends Module {
  val io = IO(new Bundle {
    //val data_in = Input(UInt(n.W))
    //val reload = Input(Bool())
    val out = Output(Bool())
  })
  val counter = RegInit(0.U(n.W))
  dontTouch(counter)
  val max_count = RegInit(6.U(n.W))
  val rel =RegInit(0.B)
 
  io.out := 0.U
when (rel===0.B){
    counter:=counter+1.U
    io.out:=1.B
    
}
.elsewhen(rel===1.B){
    counter:=counter-1.U
    io.out:=1.B
}
when(counter===max_count-1.U){
    rel:=1.B
    io.out:=1.B
}
.elsewhen(counter===1.U){
    rel:=0.B
    io.out:=1.B
}
}
