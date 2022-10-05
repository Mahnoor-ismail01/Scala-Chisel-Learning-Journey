package SingleCycle
import chisel3._
import chisel3.util._

class Data_Memory1 extends Module {
    val io =IO(new Bundle{
        
        val memRead=Input(Bool())
        val DataIn=Input(SInt(32.W))
        val dataOut=Output(SInt(32.W))
        val memAdd=Input(UInt(32.W))
        val wr_en = Input ( Bool () )
      

    })
   
    val Sync_mem=Mem(1024,SInt(32.W))
    when(io.wr_en){
        Sync_mem.write(io.memAdd,io.DataIn)
    }
    io.dataOut:=0.S
    when(io.memRead){
    io.dataOut:=Sync_mem.read(io.memAdd)}
}