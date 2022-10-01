package SingleCycle
import chisel3._
import chisel3.util._

Class Data_Memory extends Module {
    val io =IO(new Bundle{
        val memWrite=Input(Bool())
        val memRead=Input(Bool())
        val DataIn=Input(UInt(32.W))
        val dataOut=Output(UInt(32.W))
        val memAdd=Input( UInt(log2Ceil(32).W))

    })
    val Sync_mem=Mem(32.U,32.U)
    when(io.memAdd){
        Sync_mem.write((io.memAdd,o.DataIn))
    }
    io.dataOut:=Sync_mem.read(io.add,io,memRead)
}