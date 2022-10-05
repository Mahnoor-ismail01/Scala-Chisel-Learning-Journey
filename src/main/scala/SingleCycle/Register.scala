package SingleCycle
import chisel3._
import chisel3.util._

class Register_file_io extends Module{
    val io=IO(new Bundle{
    val addRS1 = Input(UInt(5.W))
    val addRS2 = Input(UInt(5.W))
    //val addRD = Input(UInt(5.W))
    val RS1Data=Output(SInt(32.W))
    val RS2Data=Output(SInt(32.W))
    val addWrite=Input(UInt(5.W))
    val DataWrite=Input(SInt(32.W))
    val RegWriteEnable=Input(Bool())
    })
val regs = RegInit(VecInit(Seq.fill(32)(0.S( 32.W ) ) ))
io.RS1Data:=Mux((io.addRS1.orR),regs(io.addRS1),0.S)//zero adrress nh lena hota is liye
io.RS2Data:=Mux((io.addRS2.orR),regs(io.addRS2),0.S)

when (io.RegWriteEnable && io.addWrite.orR){
    regs(io.addWrite):=io.DataWrite
}

}