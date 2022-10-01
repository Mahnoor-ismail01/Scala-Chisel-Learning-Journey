package SingleCycle
import chisel3._
import chisel3.util._

class Register_file_io extends Module{
    val io=IO(new Bundle{
    val addRS1 = Input(UInt(5.W))
    val addRS2 = Input(UInt(5.W))
    val addRD = Input(UInt(5.W))
    val RS1Data=Output(UInt(32.W))
    val RS2Data=Output(UInt(32.W))
    val addWrite=Input(UInt(5.W))
    val DataWrite=Input(UInt(32.W))
    val RegWriteEnable=Input(Bool())
    })
val regs = Reg (Vec(32 ,UInt ( 32.W ) ) )
io.RS1Data:=Mux((io.addRS1.orR),io.addRS1,0.U)//zero adrress nh lena hota is liye
io.RS2Data:=Mux((io.addRS2.orR),io.addRS2,0.U)

when (io.RegWriteEnable && addWrite.R){
    regs(io.addWrite):=DataWrite
}

}