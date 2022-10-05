package SingleCycle
import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile
import scala.io.Source


class Instruction_Memory extends Module{
val io=IO(new Bundle{
    val addr=Input(UInt(32.W))
    val inst=Output(UInt(32.W))

}
)
io.inst:=0.U
val imem=Mem(1024 ,UInt(32.W) )
loadMemoryFromFile(imem,"/home/mano/myfile.hex")//Myfile.hex )
io.inst:=imem(io.addr/4.U)
}