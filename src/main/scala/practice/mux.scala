import chisel3._

class MUX extends Module{
    val io = IO(new Bundle{
        val in1 = Input(UInt(4.W))
        val in2 = Input(UInt(4.W))
        val out = Output(UInt(4.W))
        val sel = Input(Bool())
    })

    when(io.sel === 0.B){
        io.out := io.in1
    }.elsewhen(io.sel === 1.B){
        io.out := io.in2
    }.otherwise{
        io.out := 0.U
    }



}