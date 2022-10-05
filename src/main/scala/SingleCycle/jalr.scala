package SingleCycle
import chisel3._
import chisel3.util._

class jalr extends Module{
    val io=IO(new Bundle{
        val rs1=Input(SInt(32.W))
        val rs2=Input(SInt(32.W))
        val jalrout=Output(SInt(32.W))
        

    })
    
  
    
    io.jalrout:=((io.rs1+io.rs2)&0xfffffffe.S)
}