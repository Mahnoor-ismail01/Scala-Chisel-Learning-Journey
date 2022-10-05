package SingleCycle
import chisel3._
import chisel3.util._

class PC extends Module{
    val io= IO(new Bundle{
        val start=Input(SInt(32.W))
       val PC4=Output(SInt(32.W))
        val PCout=Output(SInt(32.W))


    })
    io.PCout:=0.S
    io.PC4:=0.S
    val regi=RegInit(0.S(32.W))
    regi:=io.start
   
    

    io.PCout:=regi
    io.PC4:=regi+4.S


}