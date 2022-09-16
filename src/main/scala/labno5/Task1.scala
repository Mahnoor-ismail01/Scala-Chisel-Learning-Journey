package labno5
import chisel3._
import chisel3.util._

class AdderparamWidth ( Width : Int ) extends Module {
require ( Width >= 0)
val io = IO ( new Bundle {
val in1 = Input (UInt(Width.W) )
val in2 = Input (UInt(Width.W) )
val out = Output(UInt(Width.W) )
})
io.out:=io.in1+io.in2
}