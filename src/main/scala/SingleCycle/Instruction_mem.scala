package SingleCycle
import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile
import scala.io.source

class Instruction_Memory extends Module{
val io=IO(new Bundle{
    val addr=Input(UInt(32.W))
    val inst=Output(UInt(32.W))

}
)
val imem=Mem(1024 ,32.U )
loadMemoryFromFile(imem,/home/mano/Documents/Myfile.hex )
io.inst:=imem(io.addr/4.U)
}